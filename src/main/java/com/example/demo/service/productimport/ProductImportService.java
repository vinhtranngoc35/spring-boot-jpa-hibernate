package com.example.demo.service.productimport;

import com.example.demo.model.ProductImport;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProductImportRepository;
import com.example.demo.service.productimport.request.ProductImportSaveRequest;
import com.example.demo.ulti.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductImportService {
    private final CustomerRepository customerRepository;

    private final ProductImportRepository productImportRepository;


    public void create(ProductImportSaveRequest request){
        ProductImport productImport = AppUtils.mapper.map(request, ProductImport.class);
        for (var item : productImport.getProductImportDetails()) {
            item.setProductImport(productImport);
        }
//        productImport.getProductImportDetails().forEach(e -> {
//            e.setProductImport(productImport);
//        });
        productImportRepository.save(productImport);
    }
}
