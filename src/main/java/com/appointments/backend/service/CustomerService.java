package com.appointments.backend.service;

import com.appointments.backend.dto.CustomerRequest;
import com.appointments.backend.dto.CustomerResponse;
import com.appointments.backend.model.Customer;
import com.appointments.backend.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<CustomerResponse> getAllCustomers(){
        return customerRepository.findAll().stream().map(customer ->{
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setId(customer.getId());
            customerResponse.setName(customer.getName());
            customerResponse.setEmail(customer.getEmail());
            customerResponse.setPhone(customer.getPhone());
            return customerResponse;
                }
        ).toList();
    }

    public CustomerResponse getCustomer(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        response.setPhone(customer.getPhone());
        return response;
    }

    public CustomerResponse creatCustomer(CustomerRequest request){
        Customer newCustomer = new Customer();
        newCustomer.setName(request.getName());
        newCustomer.setEmail(request.getEmail());
        newCustomer.setPhone(request.getPhone());

        Customer saved = customerRepository.save(newCustomer);
        CustomerResponse response = new CustomerResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setEmail(saved.getEmail());
        response.setPhone(saved.getPhone());
        return response;
    }

    public CustomerResponse updateCustomer(Long id, CustomerRequest request){
        Customer cusToUpdate = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
        cusToUpdate.setName(request.getName());
        cusToUpdate.setEmail(request.getEmail());
        cusToUpdate.setPhone(request.getPhone());
        cusToUpdate =  customerRepository.save(cusToUpdate);
        CustomerResponse response = new CustomerResponse();
        response.setId(cusToUpdate.getId());
        response.setName(cusToUpdate.getName());
        response.setEmail(cusToUpdate.getEmail());
        response.setPhone(cusToUpdate.getPhone());
        return response;
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
