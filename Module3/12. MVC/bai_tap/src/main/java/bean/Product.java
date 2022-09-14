package bean;

import java.util.Date;

public class Product {
    private String idProduct;
    private String nameProduct;
    private double price;
    private Date dateRelease;
    private int quantity;
    private String status;

    public Product() {
    }

    public Product(String idProduct, String nameProduct, double price, Date dateRelease, int quantity, String status) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.dateRelease = dateRelease;
        this.quantity = quantity;
        this.status = status;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
