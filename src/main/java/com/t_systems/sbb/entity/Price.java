package com.t_systems.sbb.entity;

import javax.persistence.*;

@Entity
@Table(name = "price")
public class Price {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "ticket_type")
    private String ticketType;

    @Column(name = "price")
    private Integer price;

    @Column(name = "schedule_id_arrival")
    private Integer scheduleIdArrival;

    @Column(name = "schedule_id_departure")
    private Integer scheduleIdDeparture;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicketType() {
        return this.ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getScheduleIdArrival() {
        return this.scheduleIdArrival;
    }

    public void setScheduleIdArrival(Integer scheduleIdArrival) {
        this.scheduleIdArrival = scheduleIdArrival;
    }

    public Integer getScheduleIdDeparture() {
        return this.scheduleIdDeparture;
    }

    public void setScheduleIdDeparture(Integer scheduleIdDeparture) {
        this.scheduleIdDeparture = scheduleIdDeparture;
    }
}
