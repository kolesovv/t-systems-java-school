package com.t_systems.sbb.entity;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column
    private long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "departure_id")
    private Schedule scheduleDeparture;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "arrival_id")
    private Schedule scheduleArrival;



    public Ticket() {
    }

    public Ticket(long id, Passenger passenger, Schedule scheduleDeparture, Schedule scheduleArrival) {
        this.id = id;
        this.passenger = passenger;
        this.scheduleDeparture = scheduleDeparture;
        this.scheduleArrival = scheduleArrival;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Schedule getScheduleDeparture() {
        return scheduleDeparture;
    }

    public void setScheduleDeparture(Schedule scheduleDeparture) {
        this.scheduleDeparture = scheduleDeparture;
    }

    public Schedule getScheduleArrival() {
        return scheduleArrival;
    }

    public void setScheduleArrival(Schedule scheduleArrival) {
        this.scheduleArrival = scheduleArrival;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", scheduleDeparture=" + scheduleDeparture +
                ", scheduleArrival=" + scheduleArrival +
                '}';
    }
}
