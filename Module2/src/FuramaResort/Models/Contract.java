package FuramaResort.Models;

public class Contract {
    private String numberContract;
    private String bookingID;
    private long deposit;
    private long payment;
    private String customerID;

    public Contract(String numberContract, String bookingID, long deposit, long payment, String customerID) {
        this.numberContract = numberContract;
        this.bookingID = bookingID;
        this.deposit = deposit;
        this.payment = payment;
        this.customerID = customerID;
    }

    public String getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(String numberContract) {
        this.numberContract = numberContract;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getPayment() {
        return payment;
    }

    public void setPayment(long payment) {
        this.payment = payment;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}
