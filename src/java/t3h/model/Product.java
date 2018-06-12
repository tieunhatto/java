/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3h.model;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author User name
 */
public class Product implements Serializable{

    private String code;
    private String description;
    private double price;

    public Product() {
        code = "";
        description = "";
        price = 0;
    }

    public Product(String code, String descriptio, double price) {
        this.code = code;
        this.description = descriptio;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescriptio() {
        return description;
    }

    public void setDescriptio(String descriptio) {
        this.description = descriptio;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceCurrencyFormat() {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return format.format(price);
    }
}
