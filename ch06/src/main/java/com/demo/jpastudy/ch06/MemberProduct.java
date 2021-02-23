package com.demo.jpastudy.ch06;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@IdClass(MemberProductId.class)
public class MemberProduct {

  @Id
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "MEMBER_ID")
  private Member member;

  @Id
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;

  private int orderAmount;
}
