package FuramaResort.Services.Interface;


import FuramaResort.Models.Facility.House;
import FuramaResort.Models.Facility.Room;
import FuramaResort.Models.Facility.Villa;

public interface FacilityService extends Service{
    void displayFacility();
    void addNewVilla(Villa villa, int value);
    void addNewHouse(House house, int value);
    void addNewRoom(Room room, int value);
}
