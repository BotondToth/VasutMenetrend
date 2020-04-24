package com.database.szte.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationDTO {
    public int postCode;
    public String name;
    public String city;
}
