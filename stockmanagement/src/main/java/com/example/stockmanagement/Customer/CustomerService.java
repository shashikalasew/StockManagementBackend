package com.example.stockmanagement.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {

        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {

        return customerRepository.findById(id).orElse(null);
    }

    public Customer addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setCustomerName(customerDTO.getCustomerName());
        customer.setEmail(customerDTO.getEmail());
        customer.setContactInformation(customerDTO.getContactInformation());
        customer.setCreatedAt(customerDTO.getCreatedAt());
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(int id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setCustomerName(customerDetails.getCustomerName());
            customer.setEmail(customerDetails.getEmail());
            customer.setContactInformation(customerDetails.getContactInformation());


            return customerRepository.save(customer);
        }
        return null;
    }

    public void deleteCustomer(int id) {

        customerRepository.deleteById(id);
    }
}
