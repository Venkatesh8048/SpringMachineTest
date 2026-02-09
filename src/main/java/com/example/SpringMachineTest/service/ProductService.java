package com.example.SpringMachineTest.service;

import com.example.SpringMachineTest.entity.Product;
import com.example.SpringMachineTest.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public void addProduct(Product product){
        productRepo.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    public Product getProductById(int id){
        return productRepo.findById(id).get();
    }

    public void updateProduct(Product product,int id){
        Product p = productRepo.findById(id).get();
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setDescription(product.getDescription());

        productRepo.save(p);
    }

    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }
}
