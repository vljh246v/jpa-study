package com.demo.jpastudy.ch05.training;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="ORDER_ITEM")
public class OrderItem {

  @Id
  @GeneratedValue
  @Column(name="ORDER_ITEM_ID")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "ORDER_ID")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "ITEM_ID")
  private Item item;

  private int orderPrice;
  private int count;


}
