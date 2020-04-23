package com.database.szte.data;

import com.database.szte.dto.TrainDTO;
import lombok.AllArgsConstructor;
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

    public Train(TrainDTO dto) {
        this.limit = dto.limit;
        this.trainNum = dto.trainNum;
    }
}
