package com.database.szte.data;

import com.database.szte.dto.StationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Stations")
public class Station {
    @Id
    private String id;
    public int postCode;
    public String name;
    public String city;

    public Station(final StationDTO dto) {
        this.name = dto.name;
        this.postCode = dto.postCode;
        this.city = dto.city;
    }
}
