package com.demo.jpastudy.ch07;

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

      Parent parent = new Parent();
      ParentId parentId = new ParentId("myId1", "myId2");
      parent.setId(parentId);
      parent.setName("parentName");
      em.persist(parent);

      Parent resultParent = em.find(Parent.class, parentId);

      System.out.println("--------------------------");
      System.out.println(parent);
      System.out.println(resultParent);
      tx.commit();

    } catch (Exception e){
      e.printStackTrace();
      System.out.println("=====================================");
      System.out.println(e.getMessage());
      tx.rollback();
    }finally {
      em.close();
    }
    emf.close();
  }
}
