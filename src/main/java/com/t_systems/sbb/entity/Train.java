package com.t_systems.sbb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "train")
public class Train implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "train_name")
    private String trainName;
    @Column(name = "seats")
    private int seats;
    @OneToMany(mappedBy = "trainTicket", fetch = FetchType.LAZY)
    private Set<Ticket> tickets;
    @OneToMany(mappedBy = "train", fetch = FetchType.LAZY)
    private List<Schedule> schedules;

    public Train() {
    }

    public Train(long id, String trainName, int seats) {
        this.id = id;
        this.trainName = trainName;
        this.seats = seats;
    }

    public Train(String trainName) {
        this.trainName = trainName;
    }

    public long getId() {
        return id;
    }

    public void setId(long trainNumber) {
        this.id = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public long getSeats() {
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

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", trainName='" + trainName + '\'' +
                ", seats=" + seats +
                ", tickets=" + tickets +
                ", schedules=" + schedules +
                '}';
    }
}
