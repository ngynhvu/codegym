package FuramaResort.Models;

public class Room extends Facility{
    private String serviceFree;

    public Room(String serviceName, int areaUsing, long priceOfService, byte limitNumberPeople, String typeOfRental, String serviceFree) {
        super(serviceName, areaUsing, priceOfService, limitNumberPeople, typeOfRental);
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }
}
