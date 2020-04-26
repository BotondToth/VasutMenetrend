package com.database.szte.service;

import com.database.szte.data.Discount;
import com.database.szte.repository.DiscountMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService implements IDiscountService {

    @Autowired
    private DiscountMongoRepository discountMongoRepository;

    @Override
    public List<Discount> getAllDiscounts() {
        return discountMongoRepository.findAll();
    }

    @Override
    public Discount saveNewDiscount(final Discount discountToSave) {
        return discountMongoRepository.save(discountToSave);
    }
}
