package org.example.service;

import jdk.jfr.Name;
import org.example.model.Product;
import org.example.model.ProductElectronic;
import org.example.repository.ProductElectronicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl serviceProduct;

    @MockBean
    private ProductElectronicRepository productElectronicRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Name("Test the logic of method")
    public void testAddNewElectronic() {
        // given
        ProductElectronic productElectronic = new ProductElectronic("Televizor22", "Samsung", 15000, "Electronic", 200, "China.ro", 12);

        // simularea răspunsului metodei save() din repository
        when(productElectronicRepository.save(productElectronic)).thenReturn(productElectronic);

        // when
        ProductElectronic result = serviceProduct.addElectronicProduct(productElectronic);

        // then
        assertThat(productElectronic).isEqualTo(result);

    }

//    @Test
//    @Name("Test the database functionality")
//     public void testAddElectronicProduct() {
//
//        ProductElectronic productElectronic = new ProductElectronic(
//                "Televizor2", "Samsung", 15001, "Electronic",
//                200, "China.ro", 12);
//
//        when(productElectronicRepository.save(productElectronic)).thenReturn(productElectronic);
//
//        ProductElectronic savedProduct = serviceProduct.addElectronicProduct(productElectronic);
//
//        assertThat(savedProduct).isEqualTo(productElectronic);
//
//
//
//    }


}