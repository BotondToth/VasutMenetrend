package com.database.szte.data;

import com.database.szte.dto.TicketDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Tickets")
public class Ticket {
    @Id
    private String id;
    public int distance;
    public int firstClassPrice;
    public int secondClassPrice;
    public int bicyclePrice;

    public Ticket(final TicketDTO dto) {
        this.distance = dto.distance;
        this.firstClassPrice = dto.firstClassPrice;
        this.secondClassPrice = dto.secondClassPrice;
        this.bicyclePrice = dto.bicyclePrice;
    }
}
