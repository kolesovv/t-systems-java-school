package com.t_systems.sbb.entity;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "passenger_id")
    private Integer passengerId;

    @Column(name = "train_id")
    private Integer trainId;

    @Column(name = "price_id")
    private Integer priceId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getPassengerId() {
        return this.passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public Integer getTrainId() {
        return this.trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public Integer getPriceId() {
        return this.priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }
}
