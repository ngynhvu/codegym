package FuramaResort.Models;

public class Villa extends Facility{
    private String roomStandard;
    private double poolArea;
    private byte floors;

    public Villa(String serviceName, int areaUsing, long priceOfService, byte limitNumberPeople, String typeOfRental, String roomStandard, double poolArea, byte floors) {
        super(serviceName, areaUsing, priceOfService, limitNumberPeople, typeOfRental);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public byte getFloors() {
        return floors;
    }

    public void setFloors(byte floors) {
        this.floors = floors;
    }
}
