package com.demo.jpastudy.ch05.sub02;

import com.demo.jpastudy.ch05.sub01.Member;
import com.demo.jpastudy.ch05.sub01.Team;
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
      saveMember(em);
      queryLogicJoin(em);
      updateRelation(em);
      removeTeam(em);

      tx.commit();

    } catch (Exception e){
      tx.rollback();
    }finally {
      em.close();
    }
    emf.close();
  }

  private static void removeTeam(EntityManager em) {
    Member member1 = em.find(Member.class, "member1");
    Member member2 = em.find(Member.class, "member2");

    Team team = em.find(Team.class, "team1");

    member1.setTeam(null);
    member2.setTeam(null);

    em.remove(team);
  }

  private static void updateRelation(EntityManager em) {
    Team team2 = new Team("team2", "팀2");
    em.persist(team2);

    Member member = em.find(Member.class, "member1");
    member.setTeam(team2);
  }

  private static void queryLogicJoin(EntityManager em) {
    String jpql = "select m from Member m join m.team t where " +
        "t.name=:teamName";

    List<Member> resultList = em.createQuery(jpql, Member.class)
        .setParameter("teamName", "팀1")
        .getResultList();

    for(Member member : resultList){
      System.out.println("[query] member.username = " + member.getUsername());
    }
  }

  private static void saveMember(EntityManager em) {
    Team team = new Team("team1", "팀1");
    em.persist(team);

    Member member1 = new Member("member1", "회원1");
    member1.setTeam(team);
    em.persist(member1);

    Member member2 = new Member("member2", "회원2");
    member2.setTeam(team);
    em.persist(member2);
  }

}
