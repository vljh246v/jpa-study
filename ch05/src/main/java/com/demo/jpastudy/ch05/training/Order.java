package com.demo.jpastudy.ch05.training;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//@Entity
@Table(name = "ORDERS")
public class Order {

  @Id
  @GeneratedValue
  @Column(name="ORDER_ID")
  private Long id;

  @ManyToOne
  @JoinColumn(name="MEMBER_ID")
  private Member member;

  @OneToMany(mappedBy="order")
  private List<OrderItem> orderItems = new ArrayList<>();

  @Temporal(TemporalType.TIMESTAMP)
  private Date orderDate;

  @Enumerated
  private OrderStatus status;

  public void setMember(Member member){
    if(this.member != null){
      this.member.getOrders().remove(this.member);
    }
    this.member = member;
    this.member.getOrders().add(this);
  }
}
