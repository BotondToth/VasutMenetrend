package com.database.szte.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class TrainDTO {
    public String trainNum;
    public int limit;
    public int flags; //b XYZ: X: bicigli tároló, Y: másodosztály, Z: elsőosztály
}
