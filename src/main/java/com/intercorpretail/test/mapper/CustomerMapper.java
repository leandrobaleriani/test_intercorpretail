package com.intercorpretail.test.mapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.intercorpretail.test.dto.CustomerDTO;
import com.intercorpretail.test.dto.CustomerDeath;
import com.intercorpretail.test.dto.CustomerKPI;
import com.intercorpretail.test.model.Customer;

@Component
public class CustomerMapper {

  @Value("${life-expectancy}")
  private Integer lifeExpectancy;

  public Customer toEntity(CustomerDTO dto) {
    Customer customer = new Customer();
    customer.setBirthday(dto.getBirthday());
    customer.setLastName(dto.getLastName());
    customer.setName(dto.getName());
    customer.setAge(dto.getAge());

    return customer;
  }

  public CustomerDTO toDTO(Customer customer) {
    return new CustomerDTO(customer.getId(), customer.getName(), customer.getLastName(),
        customer.getAge(), customer.getBirthday());
  }

  public CustomerKPI toDTO(List<Customer> customer) {
    List<Integer> numbers = customer.stream().map(Customer::getAge).collect(Collectors.toList());

    double average = numbers.stream().collect(Collectors.averagingDouble(a -> a));
    double sd = calculateSd(numbers, average);

    return new CustomerKPI(average, sd);
  }

  public List<CustomerDeath> toListDTO(List<Customer> customers) {
    List<CustomerDeath> customerList = new ArrayList<>();

    for (Customer customer : customers) {
      customerList.add(toDeathDTO(customer));
    }
    
    return customerList;
  }

  private CustomerDeath toDeathDTO(Customer customer) {
    return new CustomerDeath(toDTO(customer), calculateDeathDate(customer.getAge()));
  }

  private double calculateSd(List<Integer> numbers, double average) {
    double sqrDiff = 0;

    for (Integer n : numbers) {
      sqrDiff += Math.pow((n - average), 2);
    }

    double variance = sqrDiff / numbers.size();

    return Math.sqrt(variance);
  }

  private Date calculateDeathDate(Integer age) {
    Date now = new Date(System.currentTimeMillis());
    int diff = lifeExpectancy - age;
    Calendar c = Calendar.getInstance();
    c.setTime(now);
    c.add(Calendar.YEAR, diff);
    return c.getTime();
  }
}
