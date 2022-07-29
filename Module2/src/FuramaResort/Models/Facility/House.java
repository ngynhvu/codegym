package FuramaResort.Models.Facility;

public class House extends Facility {
    private String roomStandard;
    private int floors;

    public House(String IdService, String serviceName, double areaUsing, long priceOfService, int limitNumberPeople, String typeOfRental, String roomStandard, int floors) {
        super(IdService, serviceName, areaUsing, priceOfService, limitNumberPeople, typeOfRental);
        this.roomStandard = roomStandard;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
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
                ", floors=" + floors +
                '}';
    }
    public String simpleString(){
        return super.simpleString()+","+roomStandard+","+floors;
    }
}
