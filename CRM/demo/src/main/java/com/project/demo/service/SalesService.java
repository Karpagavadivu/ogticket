package com.project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.entity.Sales;
import com.project.demo.repository.SalesRepository;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    private SalesRepository saleRepository;

    public Sales createSale(Sales sale) {
        return saleRepository.save(sale);
    }

    public Sales getSaleById(Long saleId) {
        return saleRepository.findById(saleId).orElseThrow(() -> new RuntimeException("Sale not found"));
    }

    public Sales updateSale(Long saleId, Sales sale) {
        Sales existingSale = getSaleById(saleId);
        existingSale.setProductId(sale.getProductId());
        existingSale.setProductName(sale.getProductName());
        existingSale.setSaleDate(sale.getSaleDate());
        existingSale.setAmount(sale.getAmount());
        existingSale.setStatus(sale.getStatus());
        return saleRepository.save(existingSale);
    }

    public void deleteSale(Long saleId) {
        saleRepository.deleteById(saleId);
    }

    public List<Sales> getAllSales() {
        return saleRepository.findAll();
    }

    public List<Sales> getSalesByProductId(Integer productId) {
        return saleRepository.findByProductId(productId);
    }
}
