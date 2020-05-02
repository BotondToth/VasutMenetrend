package com.database.szte.controller;

import com.database.szte.data.Ticket;
import com.database.szte.dto.TicketDTO;
import com.database.szte.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController extends BaseController {

    @Autowired
    private ITicketService ticketService;

    @GetMapping("/tickets")
    public List<Ticket> getTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping("/ticket")
    public Ticket insertNewTicket(@RequestBody final TicketDTO dto) {
        return ticketService.saveNewTicket(new Ticket(dto));
    }
}
