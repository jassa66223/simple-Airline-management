import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Flight {

    private String airline, number, departureAirportCode, arrivalAirportCode;
    private LocalDateTime departureDatetime, arrivalDatetime;

    // Constructor (data)
    public Flight() {
    }

    // Getter
    public String getAirline() {
        return this.airline;
    }

    public String getNumber() {
        return this.number;
    }

    public String getDepartureAirportCode() {
        return this.departureAirportCode;
    }

    public String getArrivalAirportCode() {
        return this.arrivalAirportCode;
    }

    public LocalDateTime getDepartureDatetime() {
        return this.departureDatetime;
    }

    public LocalDateTime getArrivalDatetime() {
        return this.arrivalDatetime;
    }

    // Setter

    public void setAirline(String value) {
        this.airline = value;
    }

    public void setNumber(String value) {
        this.number = value;
    }

    public void setDepartureAirportCode(String value) {
        this.departureAirportCode = value;
    }

    public void setArrivalAirportCode(String value) {
        this.arrivalAirportCode = value;
    }

    public void setDepartureDatetime(LocalDateTime value) {
        this.departureDatetime = value;

    }

    public void setArrivalDatetime(LocalDateTime value) {
        this.arrivalDatetime = value;
    }

    // This function tells the hour difference between the given time and now
    // Can be use to identify , how many hours ago was flight Departured or arrived 
    public String timeCalc(LocalDateTime value) {
        LocalDateTime fromDateTime = value;
        LocalDateTime toDateTime = LocalDateTime.now();

        // long minutes = ChronoUnit.MINUTES.between(fromDateTime, toDateTime);
        long hours = ChronoUnit.HOURS.between(fromDateTime, toDateTime);
        
        return hours + " hours Ago";
    }

}
