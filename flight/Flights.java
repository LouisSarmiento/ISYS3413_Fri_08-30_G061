package flight;

import java.util.Date;
    public class Flights {

private String flightID;
private String airplaneModel;
private String destination;
private Date departure;
private String departFrom;
private Date flightDuration;
private int availableSeat;
private boolean mealplan;

    public Flights(String flightID, String airplaneModel, String destination, Date departure, String departFrom, Date flightDuration, int availableSeat, boolean mealplan) {
        this.flightID = flightID;
        this.airplaneModel = airplaneModel;
        this.destination = destination;
        this.departure = departure;
        this.departFrom = departFrom;
        this.flightDuration = flightDuration;
        this.availableSeat = availableSeat;
        this.mealplan = mealplan;
    }
    public String getFlightID() {
        return flightID;
    }
    public String getAirplaneModel() {
        return airplaneModel;
    }
    public String getDestination() {
        return destination;
    }
    public Date getDeparture() {
        return departure;
    }
    public String getDepartFrom() {
        return departFrom;
    }
    public Date getFlightDuration() {
        return flightDuration;
    }
    public int getAvailableSeat() {
        return availableSeat;
    }
    public boolean isMealplan() {
        return mealplan;
    }
    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }
    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setDeparture(Date departure) {
        this.departure = departure;
    }
    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }
    public void setFlightDuration(Date flightDuration) {
        this.flightDuration = flightDuration;
    }
    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }
    public void setMealplan(boolean mealplan) {
        this.mealplan = mealplan;
    }
}
    