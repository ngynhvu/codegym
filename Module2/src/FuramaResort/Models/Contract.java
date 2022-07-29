package FuramaResort.Models;

public class Contract {
    private int numberContract;
    private int bookingID;
    private long deposit;
    private long payment;
    private int customerID;

    public Contract(int numberContract, int bookingID, long deposit, long payment, int customerID) {
        this.numberContract = numberContract;
        this.bookingID = bookingID;
        this.deposit = deposit;
        this.payment = payment;
        this.customerID = customerID;
    }

    public int getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
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

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "numberContract=" + numberContract +
                ", bookingID=" + bookingID +
                ", deposit=" + deposit +
                ", payment=" + payment +
                ", customerID=" + customerID +
                '}';
    }
    public String simpleString(){
        return numberContract+","+bookingID+","+deposit+","+payment+","+customerID;
    }
}
