package com.database.szte.service;

import com.database.szte.data.ApplicationUser;
import com.database.szte.data.Purchase;
import com.database.szte.dto.PurchaseResultDTO;
import com.database.szte.dto.PurchaseSaveDTO;
import com.database.szte.mapper.PurchaseMapper;
import com.database.szte.repository.PurchaseMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PurchaseService implements IPurchaseService {

    @Autowired
    private PurchaseMongoRepository purchaseMongoRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Autowired
    private UserService userService;

    @Override
    public List<PurchaseResultDTO> getPurchasesByUserId(final String userId) {
        return purchaseMongoRepository.findPurchaseByUser(findUserForPurchase(userId))
                .stream()
                .map(p -> purchaseMapper.toResultDTO(p))
                .collect(Collectors.toList());
    }

    @Override
    public Purchase saveNewPurchase(final PurchaseSaveDTO dto) {
        return purchaseMongoRepository.save(purchaseMapper.toPurchase(dto));
    }

    private ApplicationUser findUserForPurchase(final String userId) {
        return userService.findUserById(userId);
    }
}
