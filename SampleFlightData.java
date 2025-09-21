import flight.Flights;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class SampleFlightData {
    private SampleFlightData() {
    }
    
    public static List<Flights> createSampleFlight() {
        List<Flights> flights = new ArrayList<>();
        Flights flight1 = new Flights(
            "FL123","Boeing 737", "New York",  new Date(2025,8,21),"Los Angeles",360,  
            150, 
            true  
        );
        Flights flight2 = new Flights(
            "FL456","Airbus A320", "Chicago",  new Date(2025,9,9),"Miami",180,  
            100, 
            false  
        );
        Flights flight3 = new Flights(
            "FL789","Boeing 777", "San Francisco",  new Date(2025,10,10),"Seattle",120,  
            200, 
            true  
        );
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        return flights;
    }
    
}
