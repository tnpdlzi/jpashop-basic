package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            // 객체지향적이지 않다.
//            Order order = em.find(Order.class, 1L);
//            Long memberId = order.getMemberId();
//
//            Member member = em.find(Member.class, memberId);
//
//            // 바로 멤버를 끄집어낼 수 있도록
//            Member findMember = order.getMember();
//            // 식별자로 끊기지 않도록!


//            Order order = new Order();
////            order.addOrderItem(new OrderItem());
//
//            // 이런 방법도 있다.
//            em.persist(order);
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//            em.persist(orderItem);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}
