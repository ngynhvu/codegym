package FuramaResort.Models.Facility;

public class Villa extends Facility{
    private String roomStandard;
    private double poolArea;
    private int floors;

    public Villa(String IdService, String serviceName, double areaUsing, long priceOfService, int limitNumberPeople, String typeOfRental, String roomStandard, double poolArea, int floors) {
        super(IdService, serviceName, areaUsing, priceOfService, limitNumberPeople, typeOfRental);
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

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", floors=" + floors;
    }
    public String simpleString(){
        return super.simpleString()+","+roomStandard+","+poolArea+","+floors;
    }
}
