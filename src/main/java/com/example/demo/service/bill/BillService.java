package com.example.demo.service.bill;

import com.example.demo.model.Bill;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.bill.request.BillSaveRequest;
import com.example.demo.ulti.AppUtils;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    private final ProductRepository productRepository;

    private final BillRepository billRepository;

    public BillService(ProductRepository productRepository, BillRepository billRepository) {
        this.productRepository = productRepository;
        this.billRepository = billRepository;
    }


    public void create(BillSaveRequest request){
        //check phonenumber of customer
        // if exist update field
        // else create
        Bill bill = AppUtils.mapper.map(request, Bill.class);
        for (var item: bill.getBillDetails()) {
            var product = productRepository.findById(item.getProduct().getId()).orElseThrow();
            item.setPrice(product.getPrice());
            item.setNameProduct(product.getTitle());
        }
    }
}
