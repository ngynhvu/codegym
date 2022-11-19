package FinalExam.Models;

public class NhapKhau extends Product {
    private long priceInput;
    private String provinceInput;
    private long thue;

    public NhapKhau(int stt, String idProduct, String nameProduct, long priceProduct, int numberProduct, String nhaSanXuat, long priceInput, String provinceInput, long thue) {
        super(stt, idProduct, nameProduct, priceProduct, numberProduct, nhaSanXuat);
        this.priceInput = priceInput;
        this.provinceInput = provinceInput;
        this.thue = thue;
    }

    public long getPriceInput() {
        return priceInput;
    }

    public void setPriceInput(long priceInput) {
        this.priceInput = priceInput;
    }

    public String getProvinceInput() {
        return provinceInput;
    }

    public void setProvinceInput(String provinceInput) {
        this.provinceInput = provinceInput;
    }

    public long getThue() {
        return thue;
    }

    public void setThue(long thue) {
        this.thue = thue;
    }

    @Override
    public String toString() {
        return super.toString()+  " NhapKhau{" +
                "priceInput=" + priceInput +
                ", provinceInput='" + provinceInput + '\'' +
                ", thue=" + thue +
                '}';
    }
    public String simpleString(){
        return super.simpleString()+","+priceInput+","+provinceInput+","+thue;
    }
}
