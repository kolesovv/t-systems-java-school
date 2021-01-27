package com.t_systems.sbb.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ScheduleItem {
    private long id;
    private long itemId;
    private Date arrivalTime;
    private Date departureTime;

    public ScheduleItem() {
    }

    public ScheduleItem(long id, long itemId, Date arrivalTime, Date departureTime) {
        this.id = id;
        this.itemId = itemId;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss.s")
    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) throws ParseException {
        this.arrivalTime = stringToDate(arrivalTime);
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss.s")
    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) throws ParseException {
        this.departureTime = stringToDate(departureTime);
    }

    public static Date stringToDate(String dateTime) throws ParseException {
        if (dateTime == null || dateTime.equals("")){
            return null;
        }
        else {
            String date = "2021-01-01 ";
            String time = ":00.0";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s", Locale.ENGLISH);
            return sdf.parse(date + dateTime + time);
        }
    }
}
