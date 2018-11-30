package org.fasttrackit.magazin.dto;

/**
 * @author ttritean
 * @since 11/27/2018
 */
public class ProductDTO {
    private long id;

    private String name;
    private String pret;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }
}
