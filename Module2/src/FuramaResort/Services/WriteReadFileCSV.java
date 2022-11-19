package FuramaResort.Services;

import FuramaResort.Models.Booking;
import FuramaResort.Models.Contract;
import FuramaResort.Models.Facility.Facility;
import FuramaResort.Models.Facility.House;
import FuramaResort.Models.Facility.Room;
import FuramaResort.Models.Facility.Villa;
import FuramaResort.Models.Person.Customer;
import FuramaResort.Models.Person.Employee;
import FuramaResort.Models.Person.Person;

import java.io.*;
import java.util.*;

public class WriteReadFileCSV {
    public static final String FILE_EMPLOYEE="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\employee.csv";
    public static final String FILE_CUSTOMER="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\customer.csv";
    public static final String FILE_VILLA="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\villa.csv";
    public static final String FILE_HOUSE="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\house.csv";
    public static final String FILE_ROOM="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\room.csv";
    public static final String FILE_FACITILY="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\facitilyMaintance.csv";
    public static final String FILE_BOOKING="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\booking.csv";
    public static final String FILE_CONTRACT="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\contract.csv";
    public static final String FILE_VOUCHER="E:\\CodeGym\\Module2\\src\\FuramaResort\\Data\\voucher.csv";
    public static void writeToFileEmployee(String path, Employee employee ) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(employee.simpleString());
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Employee> readEmloyeeCSV() {
        List<Employee> employeeList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader buffRead = null;
        try {
            fileReader = new FileReader(FILE_EMPLOYEE);
            buffRead = new BufferedReader(fileReader);
            String line;
            String temp[];
            Employee employee;

            while ((line = buffRead.readLine()) != null) {
                temp = line.split(",");
                String name = temp[0];
                String date = temp[1];
                String sex = temp[2];
                String cmnd = temp[3];
                String phone = temp[4];
                String email = temp[5];
                int id = Integer.parseInt(temp[6]);
                String level = temp[7];
                String position = temp[8];
                long salary = Long.parseLong(temp[9]);
                employee = new Employee(name,date,sex,cmnd,phone,email,id,level,position,salary);
                employeeList.add(employee);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffRead.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return employeeList;
    }
    public static void writeToFileCustomer(String path, Customer customer ) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(customer.simpleString());
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Customer> readCustomerCSV() {
        List<Customer> customerList  = new LinkedList<>();
        FileReader fileReader = null;
        BufferedReader buffRead = null;
        try {
            fileReader = new FileReader(FILE_CUSTOMER);
            buffRead = new BufferedReader(fileReader);
            String line;
            String temp[];
            Customer customer;

            while ((line = buffRead.readLine()) != null) {
                temp = line.split(",");
                String name = temp[0];
                String date = temp[1];
                String sex = temp[2];
                String cmnd = temp[3];
                String phone = temp[4];
                String email = temp[5];
                int id = Integer.parseInt(temp[6]);
                String type = temp[7];
                String address = temp[8];
                customer = new Customer(name,date,sex,cmnd,phone,email,id,type,address);
                customerList.add(customer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffRead.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return customerList;
    }
    public static void writeToFileVilla(String path, Villa villa, int value ) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(villa.simpleString()+","+value);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeToFileHouse(String path, House house, int value) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(house.simpleString()+","+value);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeToFileRoom(String path, Room room, int value ) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(room.simpleString()+","+value);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static LinkedHashMap<Villa, Integer> readVillaCSV() {
        LinkedHashMap<Villa, Integer> villaService = new LinkedHashMap<>();
        FileReader fileReader = null;
        BufferedReader buffRead = null;
        try {
            fileReader = new FileReader(FILE_VILLA);
            buffRead = new BufferedReader(fileReader);
            String line;
            String temp[];
            Villa villa;

            while ((line = buffRead.readLine()) != null) {
                temp = line.split(",");
                String id = temp[0];
                String name = temp[1];
                double areaUsing = Double.parseDouble(temp[2]);
                long price = Long.parseLong(temp[3]);
                int limit = Integer.parseInt(temp[4]);
                String type = temp[5];
                String room = temp[6];
                double areaPool = Double.parseDouble(temp[7]);
                int floors = Integer.parseInt(temp[8]);
                int value = Integer.parseInt(temp[9]);
                villa = new Villa(id,name,areaUsing,price,limit,type,room,areaPool,floors);
                villaService.put(villa,value);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffRead.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return villaService;
    }
    public static LinkedHashMap<House, Integer> readHouseCSV() {
        LinkedHashMap<House, Integer> houseService = new LinkedHashMap<>();
        FileReader fileReader = null;
        BufferedReader buffRead = null;
        try {
            fileReader = new FileReader(FILE_HOUSE);
            buffRead = new BufferedReader(fileReader);
            String line;
            String temp[];
            House house;

            while ((line = buffRead.readLine()) != null) {
                temp = line.split(",");
                String id = temp[0];
                String name = temp[1];
                double areaUsing = Double.parseDouble(temp[2]);
                long price = Long.parseLong(temp[3]);
                int limit = Integer.parseInt(temp[4]);
                String type = temp[5];
                String room = temp[6];
                int floors = Integer.parseInt(temp[7]);
                int value = Integer.parseInt(temp[8]);
                house = new House(id,name,areaUsing,price,limit,type,room,floors);
                houseService.put(house,value);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffRead.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return houseService;
    }
    public static LinkedHashMap<Room, Integer> readRoomCSV() {
        LinkedHashMap<Room, Integer> roomService = new LinkedHashMap<>();
        FileReader fileReader = null;
        BufferedReader buffRead = null;
        try {
            fileReader = new FileReader(FILE_ROOM);
            buffRead = new BufferedReader(fileReader);
            String line;
            String temp[];
            Room room;

            while ((line = buffRead.readLine()) != null) {
                temp = line.split(",");
                String id = temp[0];
                String name = temp[1];
                double areaUsing = Double.parseDouble(temp[2]);
                long price = Long.parseLong(temp[3]);
                int limit = Integer.parseInt(temp[4]);
                String type = temp[5];
                String serviceFree = temp[6];
                int value = Integer.parseInt(temp[7]);
                room = new Room(id,name,areaUsing,price,limit,type,serviceFree);
                roomService.put(room,value);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffRead.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return roomService;
    }
    public static void writeToFileBooking(String path, Booking booking) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(booking.simpleString());
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static TreeSet<Booking> readBookingCSV() {
        TreeSet<Booking> bookingTreeSet = new TreeSet<>(new BookingComparator());
        FileReader fileReader = null;
        BufferedReader buffRead = null;
        try {
            fileReader = new FileReader(FILE_BOOKING);
            buffRead = new BufferedReader(fileReader);
            String line;
            String temp[];
            Booking booking;

            while ((line = buffRead.readLine()) != null) {
                temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                String startDay = temp[1];
                String endDay = temp[2];
                int customerID = Integer.parseInt(temp[3]);
                String nameService = temp[4];
                String type = temp[5];
                booking = new Booking(id,startDay,endDay,customerID,nameService,type);
                bookingTreeSet.add(booking);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffRead.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return bookingTreeSet;
    }
    public static void writeToFileContracts(String path, Contract contract) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(contract.simpleString());
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static TreeSet<Contract> readContractCSV() {
        TreeSet<Contract> contracts = new TreeSet<>(new ContractComparator());
        FileReader fileReader = null;
        BufferedReader buffRead = null;
        try {
            fileReader = new FileReader(FILE_CONTRACT);
            buffRead = new BufferedReader(fileReader);
            String line;
            String temp[];
            Contract contract;

            while ((line = buffRead.readLine()) != null) {
                temp = line.split(",");
                int numberOfContract = Integer.parseInt(temp[0]);
                int bookingID = Integer.parseInt(temp[1]);
                long deposit = Long.parseLong(temp[2]);
                long payment = Long.parseLong(temp[3]);
                int customerID = Integer.parseInt(temp[4]);
                contract = new Contract(numberOfContract, bookingID,deposit,payment, customerID);
                contracts.add(contract);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                buffRead.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return contracts;
    }
}
