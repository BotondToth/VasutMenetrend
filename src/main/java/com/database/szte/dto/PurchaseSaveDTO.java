package com.database.szte.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseSaveDTO {
    public String userId;
    public String timetableId;
    public int quantity;
    public Instant date;
    public int discount;
}
