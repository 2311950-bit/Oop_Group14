package com.example.oop_group14.Mila;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class WasteManagementService {
    private static WasteManagementService instance;


    private final List<Complaint> complaints = new ArrayList<>();
    private final List<String> feedback = new ArrayList<>();


    private final Map<String, GarbageTruck> trucks = new HashMap<>();
    private final List<WorkerShift> workerShifts = new ArrayList<>();
    private final Map<String, String> assignedRoutes = new HashMap<>();


    private final Map<String, String> citizenCredentials = new ConcurrentHashMap<>();
    private final Map<String, Integer> citizenIdMap = new ConcurrentHashMap<>();
    private final AtomicInteger nextCitizenId = new AtomicInteger(20000);


    private final List<String> truckLocations = List.of(
            "TRK001: Sector A (Expected 11:00)",
            "TRK002: Sector B (In Service)",
            "TRK003: Depot (Maintenance)"
    );

    private WasteManagementService() {
        // Initialize sample data
        complaints.add(new Complaint(100, 10101, "Uncollected Garbage", "Bin missed this week.", "House 5, Road 10"));
        complaints.add(new Complaint(101, 10101, "Area Dirty", "Park needs cleaning.", "Central Park, Sector C"));
        complaints.add(new Complaint(102, 10102, "Illegal Dumping", "Mattress left on curb.", "Corner of Main St and Elm Ave"));

        feedback.add("The recycling guideline page is very clear.");


        trucks.put("TRK001", new GarbageTruck("TRK001", 10.5, "Depot A"));
        trucks.put("TRK002", new GarbageTruck("TRK002", 15.0, "Near Sector C"));
        trucks.put("TRK003", new GarbageTruck("TRK003", 8.0, "In Service"));


        workerShifts.add(new WorkerShift("W001", "Morning", LocalDateTime.now().withHour(7).withMinute(0), LocalDateTime.now().withHour(15).withMinute(0)));


        citizenCredentials.put("citizen", "pass");
        citizenIdMap.put("citizen", 10101);
    }

    public static WasteManagementService getInstance() {
        if (instance == null) {
            instance = new WasteManagementService();
        }
        return instance;
    }



    public int registerNewCitizen(String username, String password) {
        if (citizenCredentials.containsKey(username) || username.equals("wmo")) {
            return -1;
        }

        int newId = nextCitizenId.incrementAndGet();
        citizenCredentials.put(username, password);
        citizenIdMap.put(username, newId);
        System.out.println("Registered new citizen: " + username + " with ID: " + newId);
        return newId;
    }


    public String authenticate(String username, String password) {
        // Check WMO
        if (username.equals("wmo") && password.equals("pass")) {
            return "WMO";
        }

        if (citizenCredentials.containsKey(username) && citizenCredentials.get(username).equals(password)) {
            return "Citizen";
        }
        return "None";
    }


    public int getCitizenId(String username) {
        return citizenIdMap.getOrDefault(username, -1);
    }


    public List<GarbageTruck> getAllTrucks() {
        return new ArrayList<>(trucks.values());
    }

    public boolean assignRouteToTruck(String truckId, String routeName, String startLocation, String endLocation) {
        GarbageTruck truck = trucks.get(truckId);
        if (truck == null || truck.getStatus().equals("Maintenance")) {
            return false;
        }

        String routeDetails = String.format("Route: %s | Start: %s | End: %s", routeName, startLocation, endLocation);
        truck.setCurrentRouteId(routeName);
        truck.setStatus("On Route");
        truck.setCurrentLocation(startLocation);
        assignedRoutes.put(truckId, routeDetails);

        return true;
    }

    public String scheduleWorkerShift(String workerId, String shiftName, LocalDateTime start, LocalDateTime end) {
        WorkerShift newShift = new WorkerShift(workerId, shiftName, start, end);

        for (WorkerShift existingShift : workerShifts) {
            if (existingShift.getWorkerId().equals(workerId) && newShift.overlapsWith(existingShift)) {
                return "Overlap Error: Worker " + workerId + " already has a shift scheduled during this time.";
            }
        }

        workerShifts.add(newShift);
        return "Shift successfully scheduled for Worker " + workerId + ".";
    }

    public List<WorkerShift> getWorkerSchedule() {
        return workerShifts;
    }

    public String updateComplaintStatus(int complaintId, String newStatus, String resolutionSummary) {
        Complaint complaintToUpdate = null;
        for (Complaint c : complaints) {
            if (c.getComplaintId() == complaintId) {
                complaintToUpdate = c;
                break;
            }
        }

        if (complaintToUpdate != null) {
            complaintToUpdate.setStatus(newStatus);
            System.out.println("Resolution for ID " + complaintId + ": " + resolutionSummary);
            return "Complaint ID " + complaintId + " updated to: " + newStatus;
        }
        return "Error: Complaint ID " + complaintId + " not found.";
    }

    public List<Complaint> getPendingComplaints() {
        return complaints.stream()
                .filter(c -> c.getStatus().equals("Pending"))
                .collect(Collectors.toList());
    }

    public List<Complaint> getAllComplaints() {
        return complaints;
    }


    public Complaint submitNewComplaint(int userId, String category, String description, String address) {
        int id = 5000 + new Random().nextInt(999);
        Complaint newComplaint = new Complaint(id, userId, category, description, address);
        complaints.add(newComplaint);
        return newComplaint;
    }

    public List<String> getTruckTrackingInfo() {
        return truckLocations;
    }

    public String getRecyclingGuidelines() {
        return "Recycling Centers:\n1. Main City Depot: Open M-F, 9am-5pm.\n2. Northern Park Station: Open Sat, 10am-2pm.\n\nGuidelines:\n- Rinse all containers.\n- Only plastics 1 and 2.\n- Flatten cardboard boxes.";
    }

    public void submitFeedback(String feedbackText) {
        feedback.add(feedbackText);
    }

    public List<Complaint> getCitizenComplaints(int userId) {
        return complaints.stream()
                .filter(c -> c.getUserId() == userId)
                .collect(Collectors.toList());
    }
}