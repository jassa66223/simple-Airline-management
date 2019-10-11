import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class FlightManagement {

    private Flight[] flight;

    // Constructor (data)
    public FlightManagement() {
        this.flight= new Flight[100];
        try {
            // file instance 
            File database = new File("flightdb.txt");

            // Checking is file exists
            if (database.exists()) {
                Scanner scan = new Scanner(database);
                int index =0;

                // iteration to every line
                while(scan.hasNextLine()) {
                    String[] data = scan.nextLine().split(",");

            
                    Flight object = new Flight();
                    object.setAirline(data[0]);
                    object.setNumber(data[1]);
                    object.setDepartureAirportCode(data[2]);
                    object.setArrivalAirportCode(data[4]);
                    object.setDepartureDatetime( LocalDateTime.parse(data[3]) );
                    object.setArrivalDatetime( LocalDateTime.parse(data[5]) );

                    this.flight[index]= object;

                    index++;
                }
                
                System.out.println("Database loaded successfully and total records are "+ index);
                
                scan.close();
              
            } else {
              System.out.println("File does not exist..");
            }


          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    // Methods

    //  Print all flight info

    public void showAllFlight() {
        String data = "-------------------- \n";
        for(Flight value: this.flight) {
            if(value == null){
                break;
            }
            data += "Airline: " + value.getAirline() + "\n" + "Flight Number: " + value.getNumber() + "\n" + value.getDepartureAirportCode() + "(" + value.getDepartureDatetime().toString() + ")   " + "-->" +  "  " + value.getArrivalAirportCode() + "(" + value.getArrivalDatetime().toString() + ")" + "\n-------------------- \n";
        }
        System.out.println(data);
    }

    public void searchFlightByArivalCity(String searchText) {
        String data = "-------------------- \n";
        for(Flight value: this.flight) {
            if(value == null){
                break;
            }
            if(value.getArrivalAirportCode().equalsIgnoreCase(searchText) ) {
                data += "Airline: " + value.getAirline() + "\n" + "Flight Number: " + value.getNumber() + "\n" + value.getDepartureAirportCode() + "(" + value.getDepartureDatetime().toString() + ")   " + "-->" +  "  " + value.getArrivalAirportCode() + "(" + value.getArrivalDatetime().toString() + ")" + "\n-------------------- \n";
            }
        }
        System.out.println( (data.equals("-------------------- \n") )? "Data not found": data);
        
    }

    public void searchFlightByDepartureCity(String searchText) {
        String data = "-------------------- \n";
        for(Flight value: this.flight) {
            if(value == null){
                break;
            }
            if(value.getDepartureAirportCode().equalsIgnoreCase(searchText) ) {
                data += "Airline: " + value.getAirline() + "\n" + "Flight Number: " + value.getNumber() + "\n" + value.getDepartureAirportCode() + "(" + value.getDepartureDatetime().toString() + ")   " + "-->" +  "  " + value.getArrivalAirportCode() + "(" + value.getArrivalDatetime().toString() + ")" + "\n-------------------- \n";
            }
        }
        System.out.println( (data.equals("-------------------- \n") )? "Data not found": data);
    }
    public void searchFlightByFlightNumber(String searchText) {
        String data = "-------------------- \n";
        for(Flight value: this.flight) {
            if(value == null){
                break;
            }
            if(value.getNumber().equalsIgnoreCase(searchText) ) {
                data += "Airline: " + value.getAirline() + "\n" + "Flight Number: " + value.getNumber() + "\n" + value.getDepartureAirportCode() + "(" + value.getDepartureDatetime().toString() + ")   " + "-->" +  "  " + value.getArrivalAirportCode() + "(" + value.getArrivalDatetime().toString()  + ")" + "(" + value.timeCalc(value.getArrivalDatetime()) + ")" + "\n-------------------- \n";
            }
        }
        System.out.println( (data.equals("-------------------- \n") )? "Data not found": data);
        
    }

    public static void main(String[] args) {
        
        FlightManagement obj = new FlightManagement();

        boolean looper = true;
        int input;
        
        Scanner scan = new Scanner(System.in);
        
        while(looper) {
            System.out.println(" Please choose >> \n 1. Print all flight info \n 2. Search flight by arrival city \n 3. Search flight by departure city \n 4. Search flight by flight number \n 0. Exit");
            input = scan.nextInt();
            Scanner searchScanner = new Scanner(System.in);

            switch (input) {
                case 1:
                   obj.showAllFlight();
                    break;
                case 2:
                    System.out.println("Arrival city airport >> ");
                    obj.searchFlightByArivalCity(searchScanner.nextLine());
                    break;
                case 3:
                    System.out.println("Departure city airport >> ");
                    obj.searchFlightByDepartureCity(searchScanner.nextLine());
                    break;
                case 4:
                    System.out.println("Flight number >>");
                    obj.searchFlightByFlightNumber(searchScanner.nextLine());
                    break;
                case 5:
                    
                    obj.searchFlightByFlightNumber(searchScanner.nextLine());
                    break;
                case 0:
                    looper = false;
                    break;
                default:
                    System.out.println("Please type valid inputs ...");
                    break;
            }
            
        }
        scan.close();
    }
}
