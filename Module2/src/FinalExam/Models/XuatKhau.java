package FinalExam.Models;

public class XuatKhau extends Product {
    private long priceOut;
    private String quocGiaNhap;

    public XuatKhau(int stt, String idProduct, String nameProduct, long priceProduct, int numberProduct, String nhaSanXuat, long priceOut, String quocGiaNhap) {
        super(stt, idProduct, nameProduct, priceProduct, numberProduct, nhaSanXuat);
        this.priceOut = priceOut;
        this.quocGiaNhap = quocGiaNhap;
    }

    public long getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(long priceOut) {
        this.priceOut = priceOut;
    }

    public String getQuocGiaNhap() {
        return quocGiaNhap;
    }

    public void setQuocGiaNhap(String quocGiaNhap) {
        this.quocGiaNhap = quocGiaNhap;
    }

    @Override
    public String toString() {
        return super.toString()+  "XuatKhau{" +
                "priceOut=" + priceOut +
                ", quocGiaNhap='" + quocGiaNhap + '\'' +
                '}';
    }
    public String simpleString(){
        return super.simpleString()+","+priceOut+","+quocGiaNhap;
    }
}
