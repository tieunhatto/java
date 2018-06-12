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
public class LineItem implements Serializable{
    
    private Product product;
    private int quantity;

    public LineItem() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal(){
        return product.getPrice() * quantity; 
        
    }
    
    public String getTotalCurrencyFormat(){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(this.getTotal());
    }
}
