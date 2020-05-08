package com.database.szte.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Purchases")
public class Purchase {

    @Id
    private String id;

    @DBRef
    private ApplicationUser user;

    @DBRef
    private Timetable timetable;

    private int quantity;

    private Instant date;

    private int discount;

}