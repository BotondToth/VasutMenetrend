package com.database.szte.data;

import com.database.szte.dto.CityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Cities")
public class City {
    @Id
    private String id;
    public int postCode;
    public String name;
    public String station;

    public City(CityDTO dto) {
        this.name = dto.name;
        this.postCode = dto.postCode;
        this.station = dto.station;
    }
}
