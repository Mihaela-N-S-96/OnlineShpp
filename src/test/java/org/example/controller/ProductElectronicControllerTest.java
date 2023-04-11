package org.example.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.example.model.ProductElectronic;
import org.example.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductElectronicControllerTest {

    @InjectMocks
    private ProductElectronicController controller;

    @Mock
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test addProduct() flow from ProductElectronicController")
    @Rollback(false)
    void addProductTest() {
        ProductElectronic productElectronic = new ProductElectronic(
                "Televizor", "Samsung", 15000, "Electronic", 200,
                "China.ro", 12);

        //test addElectronicProduct from ServiceProduct
        controller.addProduct(productElectronic);

        //verify if add method from repository was called by service
        Mockito.verify(productService).addElectronicProduct(productElectronic);

    }



}