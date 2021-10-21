package com.intercorpretail.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intercorpretail.test.dto.CustomerDTO;
import com.intercorpretail.test.dto.CustomerDeath;
import com.intercorpretail.test.dto.CustomerKPI;
import com.intercorpretail.test.mapper.CustomerMapper;
import com.intercorpretail.test.model.Customer;
import com.intercorpretail.test.repository.CustomerRepository;
import com.intercorpretail.test.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private CustomerMapper customerMapper;

  @Override
  public void save(CustomerDTO customerDTO) {
    Customer customer = customerMapper.toEntity(customerDTO);
    this.customerRepository.save(customer);
  }

  @Override
  public CustomerKPI getCustomerKPIs() {
    List<Customer> customerList = this.customerRepository.findAll();
    return customerMapper.toDTO(customerList);
  }

  @Override
  public List<CustomerDeath> getCustomerList() {
    List<Customer> customerList = this.customerRepository.findAll();
    return customerMapper.toListDTO(customerList);
  }

}
