package org.example.mila;

public class GarbageTruck {
    private final String truckId;
    private final double capacity;
    private String status;
    private String currentLocation;
    private String currentRouteId;

    public GarbageTruck(String truckId, double capacity, String currentLocation) {
        this.truckId = truckId;
        this.capacity = capacity;
        this.currentLocation = currentLocation;
        this.status = "Available";
    }

    public String getTruckId() { return truckId; }
    public double getCapacity() { return capacity; }
    public String getStatus() { return status; }
    public String getCurrentLocation() { return currentLocation; }
    public String getCurrentRouteId() { return currentRouteId; }

    public void setStatus(String status) { this.status = status; }
    public void setCurrentLocation(String currentLocation) { this.currentLocation = currentLocation; }
    public void setCurrentRouteId(String currentRouteId) { this.currentRouteId = currentRouteId; }
}