package com.database.szte.dto;

import com.database.szte.data.Station;
import com.database.szte.data.Ticket;
import com.database.szte.data.Train;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimetableDTO {
    public Station start;
    public Station end;
    public List<Station> stops;
    public Train train;
    public Ticket ticket;
    public Instant date;
    public int duration;
}
