package com.t_systems.sbb.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "train_id")
    private Train trainTicket;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "passenger_id")
    private Passenger passengerTicket;

    public Ticket() {
    }

    public Ticket(Train trainTicket, Passenger passengerTicket) {
        this.trainTicket = trainTicket;
        this.passengerTicket = passengerTicket;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Train getTrainTicket() {
        return trainTicket;
    }

    public void setTrainTicket(Train trainTicket) {
        this.trainTicket = trainTicket;
    }

    public Passenger getPassengerTicket() {
        return passengerTicket;
    }

    public void setPassengerTicket(Passenger passengerTicket) {
        this.passengerTicket = passengerTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
