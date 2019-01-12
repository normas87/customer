package com.normas.promotionservice.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreatorController {

    private CustomerRepository customerRepository;

    @Autowired
    public CreatorController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    @PostMapping("/customer")
    ResponseEntity save(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/customer")
    ResponseEntity<List<Customer>> getAll(){
        List<Customer>customerList=customerRepository.findAll();
        return ResponseEntity.ok(customerList);
    }
}
