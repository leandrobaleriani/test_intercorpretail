package com.intercorpretail.test.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -1530919345278703002L;
  private Long id;
  private String name;
  private String lastName;
  private Integer age;
  private Date birthday;
}
