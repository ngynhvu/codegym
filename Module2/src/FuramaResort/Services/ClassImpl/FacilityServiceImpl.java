package FuramaResort.Services.ClassImpl;



import FuramaResort.Models.Facility.House;
import FuramaResort.Models.Facility.Room;
import FuramaResort.Models.Facility.Villa;
import FuramaResort.Services.Interface.FacilityService;
import FuramaResort.Services.WriteReadFileCSV;

import java.util.LinkedHashMap;
import java.util.Set;


public class FacilityServiceImpl implements FacilityService {
    private static LinkedHashMap<Villa, Integer> villaService = new LinkedHashMap<>();
    private static LinkedHashMap<House, Integer> houseService = new LinkedHashMap<>();
    private static LinkedHashMap<Room, Integer> roomService = new LinkedHashMap<>();
    BookingServiceImpl bookingService = new BookingServiceImpl();
    @Override
    public void displayFacility() {
        Set<Villa>villas = WriteReadFileCSV.readVillaCSV().keySet();
        for (Villa villa:villas) {
            if(villas.isEmpty()){
                System.out.println("No service");
            }else {
                System.out.println(villa);
            }
        }
        Set<House> houses = WriteReadFileCSV.readHouseCSV().keySet();
        for (House house:houses) {
            if(houses.isEmpty()){
                System.out.println("No service");
            }else {
                System.out.println(house);
            }
        }
        Set<Room> rooms = WriteReadFileCSV.readRoomCSV().keySet();
        for (Room room:rooms) {
            if(rooms.isEmpty()){
                System.out.println("No service");
            }else {
                System.out.println(room);
            }
        }
    }

    @Override
    public void addNewVilla(Villa villa, int value) {
        villaService.put(villa, value);
        WriteReadFileCSV.writeToFileVilla(WriteReadFileCSV.FILE_VILLA,villa,value);
    }

    @Override
    public void addNewHouse(House house, int value) {
        houseService.put(house,value);
        WriteReadFileCSV.writeToFileHouse(WriteReadFileCSV.FILE_HOUSE,house,value);
    }

    @Override
    public void addNewRoom(Room room, int value) {
        roomService.put(room, value);
        WriteReadFileCSV.writeToFileRoom(WriteReadFileCSV.FILE_ROOM,room,value);
    }
    public void displayFacilityMaintenance(){
        Set<Villa> villas = WriteReadFileCSV.readVillaCSV().keySet();
        for (Villa villa:villas) {
            if(WriteReadFileCSV.readVillaCSV().get(villa)>=5){
                System.out.println(villa+" - " + WriteReadFileCSV.readVillaCSV().get(villa));
            }
        }
        Set<House> houses = WriteReadFileCSV.readHouseCSV().keySet();
        for (House house:houses) {
            if(WriteReadFileCSV.readVillaCSV().get(house)>=5){
                System.out.println(house+" - " + WriteReadFileCSV.readVillaCSV().get(house));
            }
        }
        Set<Room> rooms = WriteReadFileCSV.readRoomCSV().keySet();
        for (Room room:rooms) {
            if(WriteReadFileCSV.readVillaCSV().get(room)>=5){
                System.out.println(room+" - " + WriteReadFileCSV.readVillaCSV().get(room));
            }
        }
    }


}
