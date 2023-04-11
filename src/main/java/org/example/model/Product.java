package org.example.model;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "brand")
    private String brand;
    @Column(name = "price")
    private double price;
    @Column(name = "product_type")
    private String productType;
//
//    @OneToOne(mappedBy = "product",
//                cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private ProductElectronic productElectronic;

    public Product(String name, String brand, double price, String productType) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.productType = productType;
    }

    protected Product() {
    }

    public abstract void showTheProductInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
