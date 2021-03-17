package com.demo.jpastudy.ch05.test;

import java.util.List;
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
      JobOfferRegisterRequest request = new JobOfferRegisterRequest();

      tx.commit();

    } catch (Exception e){
      e.printStackTrace();
      tx.rollback();
    }finally {
      em.close();
    }
    emf.close();
  }
}
