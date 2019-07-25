package com.meetup.customer.controller;

import com.meetup.customer.service.CustomerService;
import com.meetup.customer.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/{id}")
    public Customer findOne(@PathVariable("id") UUID id) {
        return customerService.findOne(id).orElse(null);
    }

    @PostMapping
    public Customer save(@RequestBody @Valid Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
