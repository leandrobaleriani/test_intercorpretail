package com.intercorpretail.test.service;

import java.util.List;

import com.intercorpretail.test.dto.CustomerDTO;
import com.intercorpretail.test.dto.CustomerDeath;
import com.intercorpretail.test.dto.CustomerKPI;

public interface CustomerService {

  void save(CustomerDTO customer);

  CustomerKPI getCustomerKPIs();

  List<CustomerDeath> getCustomerList();

}
