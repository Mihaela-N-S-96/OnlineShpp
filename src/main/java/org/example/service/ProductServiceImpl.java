package org.example.service;


import org.example.exceptions.InvalidProductException;
import org.example.model.ProductElectronic;
import org.example.repository.ProductElectronicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;

@Service
public class ProductServiceImpl {


    private final ProductElectronicRepository productElectronicRepository;

    @Autowired
    public ProductServiceImpl(ProductElectronicRepository productElectronicRepository){
        this.productElectronicRepository = productElectronicRepository;
    }

    public void validateProduct(ProductElectronic productElectronic) throws InvalidProductException{
        if(productElectronic.getProducer() == null || productElectronic.getProducer().isEmpty()) {
            throw new InvalidProductException("Producer is required.");
        }
        if(productElectronic.getGuarantee() <=0 ){
            throw new InvalidProductException("Guarantee must be grater that zero.");
        }
    }

    @Transactional
    public ProductElectronic addElectronicProduct(@Validated ProductElectronic productElectronic) {
        validateProduct(productElectronic);

        return  productElectronicRepository.save(productElectronic);
    }
}
