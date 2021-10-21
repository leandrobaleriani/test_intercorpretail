package com.intercorpretail.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerKPI {

  private double averageAge;
  private double sdAge;
}
