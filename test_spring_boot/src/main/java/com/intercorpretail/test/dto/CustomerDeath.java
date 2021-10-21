package com.intercorpretail.test.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDeath implements Serializable {
  /**
  * 
  */
  private static final long serialVersionUID = -8879346158052965593L;
  private CustomerDTO customer;
  private Date estimatedDeath;

}
