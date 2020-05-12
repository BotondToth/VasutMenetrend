package com.database.szte.controller;

import com.database.szte.data.Purchase;
import com.database.szte.dto.PurchaseResultDTO;
import com.database.szte.dto.PurchaseSaveDTO;
import com.database.szte.service.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
public class PurchaseController extends BaseController {

    @Autowired
    private IPurchaseService purchaseService;

    @GetMapping("/purchases")
    public List<PurchaseResultDTO> getPurchasesByUserId(@RequestParam final String userId) {
        return purchaseService.getPurchasesByUserId(userId);
    }

    @PostMapping("/purchase")
    public Purchase insertNewPurchase(@RequestBody final PurchaseSaveDTO dto) throws MessagingException {
        return purchaseService.saveNewPurchase(dto);
    }
}