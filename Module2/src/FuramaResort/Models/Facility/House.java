package FuramaResort.Models.Facility;

public class House extends Facility {
    private String roomStandard;
    private byte floors;

    public House(String serviceName, int areaUsing, long priceOfService, byte limitNumberPeople, String typeOfRental, String roomStandard, byte floors) {
        super(serviceName, areaUsing, priceOfService, limitNumberPeople, typeOfRental);
        this.roomStandard = roomStandard;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public byte getFloors() {
        return floors;
    }

    public void setFloors(byte floors) {
        this.floors = floors;
    }
}
