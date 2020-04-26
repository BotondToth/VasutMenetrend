package com.database.szte.service;

import com.database.szte.data.Ticket;

import java.util.List;

public interface ITicketService {

    List<Ticket> getAllTickets();

    Ticket saveNewTicket(Ticket ticketToSave);
}
