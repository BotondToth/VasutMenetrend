package com.database.szte.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    public int distance;
    public int firstClassPrice;
    public int secondClassPrice;
    public int bicyclePrice;
}
