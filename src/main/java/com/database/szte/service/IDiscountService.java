package com.database.szte.service;

import com.database.szte.data.Discount;

import java.util.List;

public interface IDiscountService {

    List<Discount> getAllDiscounts();

    Discount saveNewDiscount(Discount discountToSave);
}
