package org.example.controller;

import org.example.exceptions.InvalidProductException;
import org.example.model.ProductElectronic;
import org.example.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products/")
public class ProductElectronicController {


    private ProductServiceImpl product;

    public ProductElectronicController(ProductServiceImpl product) {
        this.product = product;
    }

    @PostMapping("new/electronic/")
    public ResponseEntity<Object> addProduct(@RequestBody ProductElectronic electronic){

        try {
            return new ResponseEntity<>(product.addElectronicProduct(electronic), HttpStatus.OK);
        }catch (InvalidProductException ex){
            throw new InvalidProductException(ex.getMessage());
        }


    }
}
