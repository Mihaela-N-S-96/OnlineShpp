package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.jfr.Name;
import org.example.exceptions.InvalidProductException;
import org.example.model.ProductElectronic;
import org.example.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProductElectronicController.class)
class ProductElectronicControllerTest2 {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductElectronicController electronicController;

    @MockBean
    private ProductServiceImpl service;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Name("Run ADD method from controller when data is valid.")
    void testAddProductWithValidData() throws Exception{
        //given
        ProductElectronic productElectronic = new ProductElectronic(
                "Telefon", "Samsung", 1200, "Electronic", 100,
                "China.ro", 24);

        //when
        when(service.addElectronicProduct(productElectronic)).thenReturn(productElectronic);

        String json = new ObjectMapper().writeValueAsString(productElectronic);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/new/electronic/")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(json))
                .andReturn();

        assertThat(HttpStatus.OK.value()).isEqualTo(result.getResponse().getStatus());

    }

    @Test
    @Name("Run ADD method from controller when data is not valid (guarantee<0).")
    void testAddProductWithInvalidData() throws Exception{

        //given
        ProductElectronic productElectronic = new ProductElectronic(
                "Telefon", "Samsung", 1200, "Electronic", 100,
                null, 0);

        //when
        when(service.addElectronicProduct(productElectronic)).thenThrow(InvalidProductException.class);

        //then
        assertThrows(InvalidProductException.class , () -> electronicController.addProduct(productElectronic));

    }



}