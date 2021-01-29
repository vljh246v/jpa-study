package com.demo.jpastudy.ch04.training;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ORDERS")
@Getter @Setter
public class Order {

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ID")
  private Long id;
  
  @Column(name = "MEMBER_ID")
  private Long memberId;

  @Temporal(TemporalType.TIMESTAMP)
  private Date orderDate;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;
}
