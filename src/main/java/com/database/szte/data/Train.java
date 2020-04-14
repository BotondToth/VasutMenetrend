package com.database.szte.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Trains")
public class Train {
    @Id
    private String id;
    private String trainNum;
    private int limit;
}
