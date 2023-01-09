package com.example.spring01.rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping("/get/{id}")
    public Customer getCustomer(@PathVariable("id") long customerId){

        Customer customer=new Customer(customerId,"İrem Derici",435000);
        return customer;

    }

    @GetMapping("/list")
    public List<Customer> getCustomers(){
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(301,"İrem Derici",438555));
        customerList.add(new Customer(302,"Hande yener",430955));
        customerList.add(new Customer(303,"Merve özbey",85000));
        return customerList;
    }
    @PostMapping("/post")
    public Customer postCustomer(@RequestBody Customer customer){
        System.out.println("yollanıyor" + customer.getCustomerName()
        + " " + customer.getDebit());
        customer.setCustomerId(304);
        return customer;
    }

    @PutMapping("/put")
    public Boolean putCustoomer(@RequestBody Customer customer){
        System.out.println("Koyuluyor .." + customer.getCustomerId() +
                customer.getCustomerName() +
                customer.getDebit());
        return true;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable long id){
        System.out.println("Siliniyor" + id);

    }

}
