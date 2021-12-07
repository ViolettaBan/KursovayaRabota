package by.vita02.backend.dao;

import by.vita02.backend.order.Order;
import by.vita02.backend.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDao {
  public List<Order> getAll() {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Query query = session.createQuery("from Order");
    List<Order> orders= query.list();
    session.close();
    return orders;
  }
  public Order findById(Long id){
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Order order = session.get(Order.class, id);
    session.close();
    return order;
  }
  public void update(Order order){
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.update(order);
    transaction.commit();
    session.close();
  }
}
