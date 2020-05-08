package com.database.szte.service;

import com.database.szte.data.Purchase;
import com.database.szte.dto.PurchaseResultDTO;
import com.database.szte.dto.PurchaseSaveDTO;

import java.util.List;

public interface IPurchaseService {
    List<PurchaseResultDTO> getPurchasesByUserId(String UserId);

    Purchase saveNewPurchase(PurchaseSaveDTO purchaseToSave);
}

