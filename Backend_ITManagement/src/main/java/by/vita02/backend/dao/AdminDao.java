package by.vita02.backend.dao;

import by.vita02.backend.users.Admin;
import by.vita02.backend.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class AdminDao {
  public Admin findByNickName(String nickName) {
    Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    Query query =
        session.createQuery("from Admin c where c.nickName =:name").setParameter("name", nickName);
    Admin admin = (Admin) query.uniqueResult();
    session.close();
    return admin;
  }
}
