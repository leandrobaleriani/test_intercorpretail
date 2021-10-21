package com.intercorpretail.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intercorpretail.test.dto.CustomerDTO;
import com.intercorpretail.test.dto.CustomerDeath;
import com.intercorpretail.test.dto.CustomerKPI;
import com.intercorpretail.test.service.CustomerService;

@RestController("/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @PostMapping(path = "/creacliente", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> save(@RequestBody CustomerDTO customer) {
    this.customerService.save(customer);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  /**
   * TODO: GET /kpideclientes Promedio edad entre todos los clientes Desviación estándar entre las
   * edades de todos los clientes
   */
  @GetMapping(path = "/kpideclientes", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<CustomerKPI> customerKPIs() {
    return new ResponseEntity<CustomerKPI>(customerService.getCustomerKPIs(), HttpStatus.OK);
  }

  /**
   * TODO: GET /listclientes Lista de personas con todos los datos + fecha probable de muerte de
   * cada una
   */
  @GetMapping(path = "/listclientes", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<CustomerDeath>> customerList() {
    return new ResponseEntity<List<CustomerDeath>>(customerService.getCustomerList(),
        HttpStatus.OK);
  }
}
