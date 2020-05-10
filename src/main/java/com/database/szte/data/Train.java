package com.database.szte.data;

import com.database.szte.dto.TrainDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Trains")
@NoArgsConstructor
public class Train {
    @Id
    private String id;
    private String trainNum;
    private int limit;
    private int flags;

    public Train(TrainDTO dto) {
        this.limit = dto.limit;
        this.trainNum = dto.trainNum;
        this.flags = dto.flags;
    }
}
