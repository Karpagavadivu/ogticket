package com.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.demo.entity.Sales;
import com.project.demo.service.SalesService;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService saleService;

    @PostMapping
    public ResponseEntity<Sales> createSale(@RequestBody Sales sale) {
        return ResponseEntity.ok(saleService.createSale(sale));
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<Sales> getSaleById(@PathVariable Long saleId) {
        return ResponseEntity.ok(saleService.getSaleById(saleId));
    }

    @PutMapping("/{saleId}")
    public ResponseEntity<Sales> updateSale(@PathVariable Long saleId, @RequestBody Sales sale) {
        return ResponseEntity.ok(saleService.updateSale(saleId, sale));
    }

    @DeleteMapping("/{saleId}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long saleId) {
        saleService.deleteSale(saleId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Sales>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @GetMapping("{productId}")
    public ResponseEntity<List<Sales>> getSalesByProductId(@PathVariable Integer productId) {
        return ResponseEntity.ok(saleService.getSalesByProductId(productId));
    }
}
