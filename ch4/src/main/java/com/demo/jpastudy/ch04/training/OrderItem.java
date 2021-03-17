package com.demo.jpastudy.ch04.training;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Table(name="ORDER_ITEM")
@Getter @Setter
public class OrderItem {

  @Id
  @GeneratedValue
  @Column(name = "ORDER_ITEM_ID")
  private Long id;

  @Column(name = "ITEM_ID")
  private Long itemID;

  @Column(name = "ORDER_ID")
  private Long orderId;

  private int orderPrice;
  private int count;

}
