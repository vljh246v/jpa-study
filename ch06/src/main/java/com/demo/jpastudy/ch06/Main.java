package com.demo.jpastudy.ch06;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

  public static void main(String[] args) {
    // 엔티티 매니저 팩토리 생성
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");

    // 엔티티 매니저 생성
    EntityManager em = emf.createEntityManager();

    // 트랜잭션 획득
    EntityTransaction tx = em.getTransaction();

    try{
      tx.begin();
      tx.commit();

    } catch (Exception e){
      tx.rollback();
    }finally {
      em.close();
    }
    emf.close();
  }


}
