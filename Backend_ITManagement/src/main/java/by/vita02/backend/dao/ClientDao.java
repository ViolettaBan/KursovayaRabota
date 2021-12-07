package by.vita02.backend.dao;

import by.vita02.backend.order.Order;
import by.vita02.backend.users.Client;
import by.vita02.backend.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDao {
  public Client findById(Long id) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Client client = session.get(Client.class, id);
    session.close();
    return client;
  }

  public Client findByNick(String nickName) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Query query =
        session.createQuery("from Client c where c.nickName =:name").setParameter("name", nickName);
    Client client =  (Client) query.uniqueResult();
    session.close();
    return client;
  }

  public void save(Client client) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Transaction tx1 = session.beginTransaction();
    session.save(client);
    tx1.commit();
    session.close();
  }

  public void update(Client client) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Transaction tx1 = session.beginTransaction();
    session.update(client);
    tx1.commit();
    session.close();
  }

  public void delete(Client client) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Transaction tx1 = session.beginTransaction();
    session.delete(client);
    tx1.commit();
    session.close();
  }
  public List<Client> getAll() {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Query query = session.createQuery("from Client ");
    List<Client> orders= query.list();
    session.close();
    return orders;
  }
}
