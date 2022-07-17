package FuramaResort.Services.ClassImpl;



import FuramaResort.Models.Facility.House;
import FuramaResort.Models.Facility.Room;
import FuramaResort.Models.Facility.Villa;
import FuramaResort.Services.Interface.FacilityService;

import java.util.LinkedHashMap;
import java.util.Set;


public class FacilityServiceImpl implements FacilityService {
    private static LinkedHashMap<Villa, Integer> villaService = new LinkedHashMap<>();
    private static LinkedHashMap<House, Integer> houseService = new LinkedHashMap<>();
    private static LinkedHashMap<Room, Integer> roomService = new LinkedHashMap<>();
    BookingServiceImpl bookingService = new BookingServiceImpl();
    @Override
    public void displayFacility() {
        villaService.put(new Villa("anh", 12.8, 12000, 2,"23","2",2.0,2),1);
        Set<Villa> villas = villaService.keySet();
        for (Villa villa:villas) {
            if(villaService.isEmpty()){
                System.out.println("No service");
            }else {
                System.out.println(villa);
            }
        }
        Set<House> houses = houseService.keySet();
        for (House house:houses) {
            if(houseService.isEmpty()){
                System.out.println("No service");
            }else {
                System.out.println(house);
            }
        }
        Set<Room> rooms = roomService.keySet();
        for (Room room:rooms) {
            if(roomService.isEmpty()){
                System.out.println("No service");
            }else {
                System.out.println(room);
            }
        }
    }

    @Override
    public void addNewVilla(Villa villa, int value) {
        villaService.put(villa, value);
    }

    @Override
    public void addNewHouse(House house, int value) {
        houseService.put(house,value);
    }

    @Override
    public void addNewRoom(Room room, int value) {
        roomService.put(room, value);
    }
    public void displayFacilityMaintenance(){
        Set<Villa> villas = villaService.keySet();
        for (Villa villa:villas) {
            if(villaService.isEmpty()){
                System.out.println("No service");
            }else if(bookingService.numberUsingVilla()>=5){
                System.out.println(villa);
            }else {
                System.out.println("No facility Maintenance");
            }
        }
        Set<House> houses = houseService.keySet();
        for (House house:houses) {
            if(houseService.isEmpty()){
                System.out.println("No service");
            }else if(bookingService.numberUsingHouse()>=5){
                System.out.println(house);
            }else {
                System.out.println("No facility Maintenance");
            }
        }
        Set<Room> rooms = roomService.keySet();
        for (Room room:rooms) {
            if(roomService.isEmpty()){
                System.out.println("No service");
            }else if(bookingService.numberUsingRoom() >=5){
                System.out.println(room);
            }else {
                System.out.println("No facility Maintenance");
            }
        }
    }


}
