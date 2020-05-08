package com.database.szte.mapper;

import com.database.szte.data.Purchase;
import com.database.szte.dto.PurchaseResultDTO;
import com.database.szte.dto.PurchaseSaveDTO;
import com.database.szte.repository.TimetableMongoRepository;
import com.database.szte.repository.UserMongoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Autowired
    private TimetableMongoRepository timetableMongoRepository;

    public Purchase toPurchase(final PurchaseSaveDTO dto) {
        return Purchase.builder()
                .user(userMongoRepository.findApplicationUserById(new ObjectId(dto.userId)))
                .timetable(timetableMongoRepository.findTimetableById(dto.timetableId))
                .date(dto.date)
                .discount(dto.discount)
                .quantity(dto.quantity)
                .build();
    }

    public PurchaseResultDTO toResultDTO(final Purchase purchase) {
        return PurchaseResultDTO.builder()
                .timetable(purchase.getTimetable())
                .date(purchase.getDate())
                .discount(purchase.getDiscount())
                .quantity(purchase.getQuantity())
                .build();
    }
}
