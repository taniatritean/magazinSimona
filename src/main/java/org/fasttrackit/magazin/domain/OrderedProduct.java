package org.fasttrackit.magazin.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ttritean
 * @since 11/27/2018
 */
//@Entity
public class OrderedProduct {

    private Product product;
    private int quantity;

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
}
