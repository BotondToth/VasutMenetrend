package com.database.szte.controller;

import com.database.szte.data.Discount;
import com.database.szte.dto.DiscountDTO;
import com.database.szte.service.IDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscountController {

    @Autowired
    private IDiscountService discountService;

    @GetMapping("/discounts")
    public List<Discount> getDiscounts() {
        return discountService.getAllDiscounts();
    }

    @PostMapping("/discount")
    public Discount insertNewDiscount(@RequestBody final DiscountDTO dto) {
        return discountService.saveNewDiscount(new Discount(dto));
    }
}
