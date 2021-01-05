package jpabook2.jpashop2;

import jpabook2.jpashop2.domain.Book;
import jpabook2.jpashop2.domain.Order;
import jpabook2.jpashop2.domain.OrderItem;

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
        try{

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            em.persist(book);

            tx.commit();
        }catch( Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
