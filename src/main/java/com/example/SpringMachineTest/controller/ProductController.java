package com.example.SpringMachineTest.controller;

import com.example.SpringMachineTest.entity.Product;
import com.example.SpringMachineTest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/dashboard")
    public String dashboardOwner(Model model){
        model.addAttribute("products",productService.getAllProduct());
        return "dashboard";
    }

    @GetMapping("/product")
    public String product(){
        return "addproduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product){
        productService.addProduct(product);
        return "redirect:/dashboard";
    }

    @GetMapping("/prodoctbyid/{id}")
    public String getProductById(@PathVariable("id") int id,Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "productbyid";
    }

    @GetMapping("/editproductform/{id}")
    public String editProductForm(@PathVariable ("id") int id,Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "editproduct";
    }

    @PostMapping("/editProduct/{id}")
    public String editProduct(@ModelAttribute Product product,@PathVariable("id") int id){
        productService.updateProduct(product,id);
        return "redirect:/dashboard";
    }

    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return "redirect:/dashboard";
    }
}
