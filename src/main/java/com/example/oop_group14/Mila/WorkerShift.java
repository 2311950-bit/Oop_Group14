package com.example.oop_group14.Mila;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WorkerShift {
    private final String workerId;
    private final String shiftName;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public WorkerShift(String workerId, String shiftName, LocalDateTime startTime, LocalDateTime endTime) {
        this.workerId = workerId;
        this.shiftName = shiftName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getWorkerId() { return workerId; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }


    public boolean overlapsWith(WorkerShift other) {
        return (this.startTime.isBefore(other.endTime) && other.startTime.isBefore(this.endTime));
    }

    @Override
    public String toString() {
        return String.format("%s (%s): %s - %s",
                workerId, shiftName,
                startTime.format(FORMATTER),
                endTime.format(FORMATTER));
    }
}