package org.example.repository;

import org.example.model.ProductElectronic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductElectronicRepositoryTest {

    @Autowired
    private ProductElectronicRepository productElectronicRepository;


    @Test
    @Rollback(value = false)
    void should_add_product(){
        ProductElectronic productElectronic = new ProductElectronic(
                "Monitor PC", "LG", 2000, "Electronic",
                200, "China.ro", 12);

        assertEquals(productElectronic,productElectronicRepository.save(productElectronic));
    }
}