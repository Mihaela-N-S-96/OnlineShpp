package org.example.model;

import lombok.Data;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.*;


@Entity(name = "electronics")
@Table(name = "electronics")
public class ProductElectronic extends Product{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "kw")
    private double kW;
    @Column(name = "producer")
    private String producer;
    @Column(name = "guarantee")
    private int guarantee;

    public ProductElectronic() {
    }
//    @OneToOne
//    @JoinColumn(name = "product_id")
//    @JsonBackReference
//    private Product product;


    public ProductElectronic(String name, String brand, double price, String productType,
                             double kW, String producer, int guarantee){
        super(name, brand, price, productType);
        this.kW = kW;
        this.producer = producer;
        this.guarantee = guarantee;
    }



    public void showTheProductInfo(){
        System.out.println("This electronic product's name is" + getName()+ "\n"+
                            "brand is "+ getBrand()+"\n"+
                            "price is "+ getPrice()+"\n"+
                            "and has a power of "+ this.kW + " kW");
    }

    @Override
    public String toString() {
        return "ProductElectronic{" +
                "id=" + id +
                ", kW=" + kW +
                ", producer='" + producer + '\'' +
                ", guaranteeee=" + guarantee +
                '}';
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getkW() {
        return kW;
    }

    public void setkW(double kW) {
        this.kW = kW;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }
}
