package com.database.szte.service;

import com.database.szte.data.Ticket;
import com.database.szte.repository.TicketMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private TicketMongoRepository ticketMongoRepository;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketMongoRepository.findAll();
    }

    @Override
    public Ticket saveNewTicket(final Ticket ticketToSave) {
        return ticketMongoRepository.save(ticketToSave);
    }
}
