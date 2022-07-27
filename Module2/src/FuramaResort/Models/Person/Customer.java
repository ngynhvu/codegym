package FuramaResort.Models.Person;

public class Customer extends Person {
    private int customerID;
    private String typeOfCustomer;
    private String address;

    public Customer(String fullName, String dateOfBirth, String sex, String numberCMND, String phoneNumber, String email, int customerID, String typeOfCustomer, String address) {
        super(fullName, dateOfBirth, sex, numberCMND, phoneNumber, email);
        this.customerID = customerID;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", customerID='" + customerID + '\'' +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    public String simpleString(){
        return super.simpleString()+","+customerID+","+typeOfCustomer+","+address;
    }
}
