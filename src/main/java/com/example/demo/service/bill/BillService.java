package com.example.demo.service.bill;

import com.example.demo.model.Bill;
import com.example.demo.model.Customer;
import com.example.demo.model.enums.EStatusCart;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.bill.request.BillSaveRequest;
import com.example.demo.ulti.AppUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class BillService {

    private final ProductRepository productRepository;

    private final BillRepository billRepository;

    private final CustomerRepository customerRepository;

    public BillService(ProductRepository productRepository, BillRepository billRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.billRepository = billRepository;
        this.customerRepository = customerRepository;
    }


    @Transactional
    public void create(BillSaveRequest request){
        //check phonenumber of customer
        // if exist update field
        // else create
        Bill bill = AppUtils.mapper.map(request, Bill.class);
        bill.setCustomerName(request.getCustomer().getName());
        bill.setStatusCart(EStatusCart.UNPAID);
        var totalAmount = BigDecimal.ZERO;
        for (var item: bill.getBillDetails()) {
            var product = productRepository.findById(item.getProduct().getId()).orElseThrow();
            item.setPrice(product.getPrice());
            item.setNameProduct(product.getTitle());
            item.setBill(bill);
            totalAmount = totalAmount
                            .add(product.getPrice()
                            .multiply(new BigDecimal(item.getQuantity().toString())));
        }
        bill.setTotalAmount(totalAmount);
        Customer customer = customerRepository.findCustomerByPhoneNumber(request.getCustomer().getPhoneNumber()).orElse(null);
        if(customer != null){
            bill.getCustomer().setId(customer.getId());
            //
        }
        customer = bill.getCustomer();

        bill.setCustomer(customerRepository.save(customer));

        billRepository.save(bill);
    }
}
