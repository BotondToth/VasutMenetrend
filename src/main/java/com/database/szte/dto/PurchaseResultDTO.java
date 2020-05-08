package com.database.szte.dto;

import com.database.szte.data.Timetable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResultDTO {
    public Timetable timetable;
    public int quantity;
    public Instant date;
    public int discount;
}

