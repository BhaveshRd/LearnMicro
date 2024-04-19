package com.dealer_service.model;

import java.math.BigDecimal;

public class CardInfoResponse {


    private String brand;

    private String model;

    private BigDecimal pricePerUnit;

    private BigDecimal quantity;

    private BigDecimal totalPrice;


    private String environment;

    private CardInfoResponse (CardInfoResponseBuilder builder){
        this.brand= builder.brand;
        this.model = builder.model;
        this.pricePerUnit = builder.pricePerUnit;
        this.totalPrice =  builder.totalPrice;
        this.quantity = builder.quantity;
        this.environment = builder.environment;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public String getEnvironment() {
        return environment;
    }

    public static class CardInfoResponseBuilder{

        private String brand;

        private String model;

        private BigDecimal pricePerUnit;

        private BigDecimal quantity;

        private BigDecimal totalPrice;


        private String environment;

        public CardInfoResponseBuilder setBrand(String brand){
            this.brand = brand;
            return this;
        }

        public CardInfoResponseBuilder setModel(String model){
            this.model = model;
            return this;
        }

        public CardInfoResponseBuilder setEnvironment(String environment){
            this.environment = environment;
            return this;
        }

        public CardInfoResponseBuilder setPerUnit(BigDecimal pricePerUnit){
            this.pricePerUnit = pricePerUnit;
            return this;
        }

        public CardInfoResponseBuilder setTotal(BigDecimal totalPrice){
            this.totalPrice = totalPrice;
            return this;
        }

        public CardInfoResponseBuilder setQuantity(BigDecimal quantity){
            this.quantity = quantity;
            return this;
        }

        public CardInfoResponse build(){
            return  new CardInfoResponse(this);
        }
    }


}
