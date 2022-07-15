package FuramaResort.Models.Facility;

public class Room extends Facility{
    private String serviceFree;

    public Room(String serviceName, double areaUsing, long priceOfService, int limitNumberPeople, String typeOfRental, String serviceFree) {
        super(serviceName, areaUsing, priceOfService, limitNumberPeople, typeOfRental);
        this.serviceFree = serviceFree;
    }

    public String getServiceFree() {
        return serviceFree;
    }

    public void setServiceFree(String serviceFree) {
        this.serviceFree = serviceFree;
    }

    @Override
    public String toString() {
        return super.toString() +"Room{" +
                "serviceFree='" + serviceFree + '\'' +
                '}';
    }
}
