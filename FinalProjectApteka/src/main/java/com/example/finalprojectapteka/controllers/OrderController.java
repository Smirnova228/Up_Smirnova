package com.example.finalprojectapteka.controllers;

import com.example.finalprojectapteka.models.Client;
import com.example.finalprojectapteka.models.Order;
import com.example.finalprojectapteka.models.Product;
import com.example.finalprojectapteka.repository.ClientRepository;
import com.example.finalprojectapteka.repository.ProductRepository;
import com.example.finalprojectapteka.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@PreAuthorize("hasAnyAuthority('USER','EMPLOYEE','ADMIN')")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/order")
    public String orderMain(Model model) {
        Iterable<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "order";
    }

    @GetMapping("/order/add")
    public String orderAdd(@ModelAttribute("orders") Order order, Model model) {
        Iterable<Product> products = productRepository.findAll();
        Iterable<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("products", products);
        return "order-add";
    }

    @PostMapping("/order/add")
    public String orderPostAdd(@ModelAttribute("orders") @Valid Order order,
                               BindingResult bindingResult,
                               @RequestParam String name,
                               @RequestParam String firstName,
                               Model model) {
        if(bindingResult.hasErrors()) {
            Iterable<Client> client = clientRepository.findAll();
            Iterable<Product> product = productRepository.findAll();
            model.addAttribute("client", client);
            model.addAttribute("product", product);
            return "order-add";
        }
        order.setProduct(productRepository.findByName(name));
        order.setClient(clientRepository.findByFirstName(firstName));
        orderRepository.save(order);
        return "redirect:/order";
    }

    @GetMapping("/order/{id}/edit")
    public  String orderDetails(@PathVariable(value = "id") long id, Model model, Model models)
    {
        Iterable<Product> product = productRepository.findAll();
        Iterable<Client> client = clientRepository.findAll();
        models.addAttribute("product", product);
        models.addAttribute("client", client);
        Order order = orderRepository.findById(id).orElseThrow();
        model.addAttribute("order", order);
        return "order-edit";
    }

    @PostMapping ("/order/{id}/edit")
    public  String orderUpdate(@ModelAttribute("order") @Valid Order order,
                               BindingResult bindingResult,
                               @PathVariable(value = "id") long id)
    {
        if(bindingResult.hasErrors())
            return "order-edit";
        orderRepository.save(order);
        return "redirect:/order";
    }

    @GetMapping("/order/{id}/remove")
    public  String orderDelete(@PathVariable(value = "id") long id, Model model)
    {
        Order order = orderRepository.findById(id).orElseThrow();
        orderRepository.delete(order);
        return "redirect:/order";
    }
}
