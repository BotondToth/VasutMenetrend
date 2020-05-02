package com.database.szte.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Reports")
public class Report {
    public int year;
    public String month;
    public int sold; //includes @discountTickets
    public int discountTickets;
    public long income;
    public long profit;
}
