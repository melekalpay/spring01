package com.example.spring01.client;

import com.example.spring01.rest.Customer;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/client")
public class CustomerClient {
    @GetMapping("/get")
    @ResponseBody
    public String getClient(){
        long customerId=301;
        String url="http://localhost:8080/customer/get/" + customerId;
        RestTemplate restTemplate = new RestTemplate();
        //Customer customer=restTemplate.getForObject(url,Customer.class); //kısa yol
        ResponseEntity<Customer> response=restTemplate.exchange(
                url, HttpMethod.GET, HttpEntity.EMPTY,Customer.class
        ); //uzun yol
        Customer customer = response.getBody();
        return "Alımcı Adı:" + customer.getCustomerName();
    }

    @GetMapping("/list")
    @ResponseBody
    public String getCustomers(){
        String url="http://localhost:8080/customer/list";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Customer>> response = restTemplate.exchange(
                url,HttpMethod.GET,HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Customer>>() { }
        );
        List<Customer> customerList = response.getBody();
        return "Alımcı sayısı:" + customerList.size();
    }

    @GetMapping("/post")
    @ResponseBody
    public String postCostumer(){
        Customer customer = new Customer(0,"Soner",78906);
        String url="http://localhost:8080/customer/post";
        RestTemplate restTemplate=new RestTemplate();
        Customer result=restTemplate.postForObject(url,customer,Customer.class);
        return "Alıcı kimliği :"+result.getCustomerId();
    }

    @GetMapping("/put/{id}")
    @ResponseBody
    public String putCustomer(@PathVariable("id") long customerId,
                              @RequestParam("name") String customerName,
                              @RequestParam("debit") double debit
                              ){
        Customer customer = new Customer(
                customerId,customerName,debit
        );
        String url="http://localhost:8080/customer/put";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Boolean> response =restTemplate.exchange(
        url,HttpMethod.PUT,new HttpEntity<Customer>(customer),Boolean.class
        );
        return  "Alıcı kimliği :" + response.getBody();
    }
    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteCustomer(@PathVariable long id){
        System.out.println("id " + id );
        String url= "http://localhost:8080/customer/delete/" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        return "Silindi";
    }

}
