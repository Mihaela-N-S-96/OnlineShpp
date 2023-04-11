package org.example.service;

import jdk.jfr.Name;
import org.example.exceptions.InvalidProductException;
import org.example.model.ProductElectronic;
import org.example.repository.ProductElectronicRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest_validateProduct {

    @Autowired
    private ProductServiceImpl productService;

    @MockBean
    private ProductElectronicRepository productElectronicRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Name("Validate the producer field is not null or empty")
    void validateProduct_Producer_Required() {
        // given
        ProductElectronic productElectronic = new ProductElectronic(
                "dd", "Samsung", 15000,
                "Electronic", 200, null,
                12);

        //Act & Assert
        Assertions.assertThrows(
                InvalidProductException.class,
                () -> productService.validateProduct(productElectronic)
        );
    }

    @Test
    @Name("Validate the guarantee is grater than 0")
    void validateProduct_Guarantee() {
        // given
        ProductElectronic productElectronic = new ProductElectronic(
                "dd", "Samsung", 15000,
                "Electronic", 200, null,
                0);

        //Act & Assert
        Assertions.assertThrows(
                InvalidProductException.class,
                () -> productService.validateProduct(productElectronic)
        );
    }

    @Test
    @Rollback(value = false)
    @Name("Test the database functionality")
     public void testAddElectronicProduct() {

        ProductElectronic productElectronic = new ProductElectronic(
                "Televizor3", "Samsung", 15001, "Electronic",
                200, "China.ro", 12);

        when(productElectronicRepository.save(productElectronic)).thenReturn(productElectronic);

        ProductElectronic savedProduct = productService.addElectronicProduct(productElectronic);

        assertThat(savedProduct).isEqualTo(productElectronic);

    }
}