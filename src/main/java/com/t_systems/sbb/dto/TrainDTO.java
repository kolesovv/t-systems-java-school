package com.t_systems.sbb.dto;

import com.t_systems.sbb.entity.Ticket;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

public class TrainDTO {
    private long id;
    private String trainName;
    private int seats;
    private Set<Ticket> tickets;
    private LinkedList<ScheduleDTO> schedulePath;

    public TrainDTO() {
    }

    public TrainDTO(long id, String trainName, int seats) {
        this.id = id;
        this.trainName = trainName;
        this.seats = seats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public LinkedList<ScheduleDTO> getSchedulePath() {
        return schedulePath;
    }

    public void setSchedulePath(LinkedList<ScheduleDTO> schedulePath) {
        this.schedulePath = schedulePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainDTO trainDTO = (TrainDTO) o;
        return id == trainDTO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
