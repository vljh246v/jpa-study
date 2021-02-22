package com.demo.jpastudy.ch06;


import java.io.Serializable;

public class MemberProductId implements Serializable {

  private Long member;
  private Long product;

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
