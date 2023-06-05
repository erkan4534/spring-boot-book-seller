package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.security.UserPrincipal;
import com.sha.springbootbookseller.service.IPurchaseHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchase-history")//pre-path
public class PurchaseHistoryController {

    private IPurchaseHistoryService purchaseHistoryService;

    public PurchaseHistoryController(IPurchaseHistoryService purchaseHistoryService) {
        this.purchaseHistoryService = purchaseHistoryService;
    }

    @PostMapping//api/purchase-history
    public ResponseEntity<?> savePurchaseHistory(@RequestBody PurchaseHistory purchaseHistory){
        return new ResponseEntity<>(purchaseHistoryService.savePurchaseHistory(purchaseHistory), HttpStatus.CREATED);
    }
    //@AuthenticationPrincipal anatasyonu ile kimligi dogrulanmis kullaniciya  erisilir.
    @GetMapping//api/purchase-history
    public ResponseEntity<?> getAllPurchaseOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return  ResponseEntity.ok(purchaseHistoryService.findPurchasedItemsOfUser(userPrincipal.getId()));
    }
}
