package com.intercorpretail.test.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cus_customer")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
  /**
  * 
  */
  private static final long serialVersionUID = -2834190301804764194L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cus_id", nullable = false)
  private Long id;
  @Column(name = "cus_name", nullable = false)
  private String name;
  @Column(name = "cus_lastname", nullable = false)
  private String lastName;
  @Column(name = "cus_birthday", nullable = false)
  private Date birthday;
  @Column(name = "cus_age", nullable = false)
  private Integer age;

}
