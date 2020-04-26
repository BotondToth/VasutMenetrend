package com.database.szte.data;

import com.database.szte.dto.DiscountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Discounts")
public class Discount {
    @Id
    private String id;
    public String title;
    public int percentage;

    public Discount(final DiscountDTO dto) {
        this.title = dto.title;
        this.percentage = dto.percentage;
    }
}
