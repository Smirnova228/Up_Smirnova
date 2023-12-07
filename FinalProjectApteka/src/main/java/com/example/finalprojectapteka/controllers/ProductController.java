package com.example.finalprojectapteka.controllers;

import com.example.finalprojectapteka.models.Point;
import com.example.finalprojectapteka.models.Product;
import com.example.finalprojectapteka.models.TypeMedicine;
import com.example.finalprojectapteka.repository.ProductRepository;
import com.example.finalprojectapteka.repository.PointRepository;
import com.example.finalprojectapteka.repository.TypeMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@PreAuthorize("hasAnyAuthority('EMPLOYEE','ADMIN')")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TypeMedicineRepository typeMedicineRepository;
    @Autowired
    private PointRepository pointRepository;

    @GetMapping("/product")
    public String productMain(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "product";
    }

    @GetMapping("/product/add")
    public String productAdd(@ModelAttribute("products") Product product, Model type) {
        Iterable<TypeMedicine> typeProduct = typeMedicineRepository.findAll();
        Iterable<Point> stores = pointRepository.findAll();
        type.addAttribute("typeProduct", typeProduct);
        type.addAttribute("points", stores);
        return "product-add";
    }

    @PostMapping("/product/add")
    public String productPostAdd(@ModelAttribute("products") @Valid Product product,
                                 BindingResult bindingResult,
                                 @RequestParam String nameTypeMedicine,
                                 @RequestParam String namePoint,
                                 Model type) {
        if (bindingResult.hasErrors()) {
            Iterable<TypeMedicine> typeMedicine = typeMedicineRepository.findAll();
            Iterable<Point> point = pointRepository.findAll();
            type.addAttribute("typeMedicine", typeMedicine);
            type.addAttribute("namePoint", point);
            return "product-add";
        }
        product.setTypeMedicine(typeMedicineRepository.findByNameTypeMedicine(nameTypeMedicine));
        product.setPoint(pointRepository.findByNamePoint(namePoint));
        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping("/product/{id}/edit")
    public String productDetails(@PathVariable(value = "id") long id, Model model, Model type)
    {
        Iterable<TypeMedicine> typeProduct = typeMedicineRepository.findAll();
        Iterable<Point> points = pointRepository.findAll();
        type.addAttribute("typeProduct", typeProduct);
        type.addAttribute("points", points);
        Product product = productRepository.findById(id).orElseThrow();
        model.addAttribute("product", product);
        return "product-edit";
    }

    @PostMapping ("/product/{id}/edit")
    public  String productUpdate(@ModelAttribute("product") @Valid Product product,
                                 BindingResult bindingResult,
                                 @PathVariable(value = "id") long id)
    {
        if(bindingResult.hasErrors())
            return "product-edit";
        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping("/product/{id}/remove")
    public  String productDelete(@PathVariable(value = "id") long id, Model model)
    {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
        return "redirect:/product";
    }

}

