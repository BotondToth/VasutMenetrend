package com.database.szte.data;

import com.database.szte.dto.TimetableDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Timetables")
public class Timetable {

    @Id
    private String id;
    
    @DBRef
    private Station start;

    @DBRef
    private Station end;

    @DBRef
    private List<Station> stops;

    @DBRef
    private Train train;

    @DBRef
    private Ticket ticket;

    private Instant date;

    private int duration;

    public Timetable(final TimetableDTO dto) {
        this.start = dto.start;
        this.end = dto.end;
        this.stops = dto.stops;
        this.train = dto.train;
        this.ticket = dto.ticket;
        this.date = dto.date;
        this.duration = dto.duration;
    }

}
