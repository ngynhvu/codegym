package FinalExam.Models;

public abstract class Product {
    private int stt;
    private String idProduct;
    private String nameProduct;
    private long priceProduct;
    private int numberProduct;
    private String nhaSanXuat;

    public Product(int stt, String idProduct, String nameProduct, long priceProduct, int numberProduct, String nhaSanXuat) {
        this.stt = stt;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.numberProduct = numberProduct;
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
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

    public long getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(long priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getNumberProduct() {
        return numberProduct;
    }

    public void setNumberProduct(int numberProduct) {
        this.numberProduct = numberProduct;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return "Product{" +
                "stt=" + stt +
                ", idProduct='" + idProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                ", numberProduct=" + numberProduct +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                '}';
    }

    public String simpleString(){
        return stt+","+idProduct+","+nameProduct+","+priceProduct+","+numberProduct+","+nhaSanXuat;
    }
}
