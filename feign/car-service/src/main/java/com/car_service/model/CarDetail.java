package com.car_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;


@Entity
public class CarDetail {

    /*{

        "id":"100",
            "brand":"ford",
            "model":"2024",
            "price":6000,
            "currency":"USD"
    }*/


    @Id
    int id;

    private String brand;

    private String model;

    private BigDecimal price;

    @Column(name = "currency_type")
    private String currency;

    public CarDetail() {
    }

    public CarDetail(int id, String brand, String model, BigDecimal price, String currency) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CarDetail{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}
