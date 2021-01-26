package com.t_systems.sbb.service;

import com.t_systems.sbb.dao.PassengerDAOImpl;
import com.t_systems.sbb.dao.TicketDAO;
import com.t_systems.sbb.entity.*;
import com.t_systems.sbb.model.TicketItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketDAO ticketDAO;

    @Autowired
    PassengerDAOImpl passengerDAO;

    @Autowired
    ScheduleService scheduleService;

    @Transactional
    public List<TicketItem> getTickets(long passengerId){
        Collection<Ticket> tickets = ticketDAO.findAllByPassenger(passengerId);
        Passenger passenger = passengerDAO.findById(passengerId);
        List<TicketItem> results = new ArrayList<>();
        for (Ticket ticket : tickets) {
            Schedule scheduleDeparture = ticket.getScheduleDeparture();
            Train train = scheduleDeparture.getTrain();
            Station stationDeparture = scheduleDeparture.getStation();
            Date departure = scheduleDeparture.getDepartureTime();
            Schedule scheduleArrival = ticket.getScheduleArrival();
            Station stationArrival = scheduleArrival.getStation();
            Date arrival = scheduleArrival.getArrivalTime();
            TicketItem ticketItem = new TicketItem(passenger,train,stationDeparture,departure,stationArrival,arrival);
            results.add(ticketItem);
        }
        return results;
    }

    @Transactional
    public List<TicketItem> getTickets(long passengerId, long trainId){
        Collection<Ticket> tickets = ticketDAO.findAllByPassenger(passengerId);
        Passenger passenger = passengerDAO.findById(passengerId);
        List<TicketItem> results = new ArrayList<>();
        for (Ticket ticket : tickets) {
            Schedule scheduleDeparture = ticket.getScheduleDeparture();
            Train train = scheduleDeparture.getTrain();
            if (train.getNumberTrain() == trainId) {
            Station stationDeparture = scheduleDeparture.getStation();
            Date departure = scheduleDeparture.getDepartureTime();
            Schedule scheduleArrival = ticket.getScheduleArrival();
            Station stationArrival = scheduleArrival.getStation();
            Date arrival = scheduleArrival.getArrivalTime();
            TicketItem ticketItem = new TicketItem(passenger,train,stationDeparture,departure,stationArrival,arrival);
            results.add(ticketItem);
            }
        }
        return results;
    }
}
