package by.vita02.backend.utils;

import by.vita02.backend.company.Company;
import by.vita02.backend.order.Order;
import by.vita02.backend.result.ITProject;
import by.vita02.backend.users.Admin;
import by.vita02.backend.users.Client;
import by.vita02.backend.users.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
  private static SessionFactory sessionFactory;

  private HibernateSessionFactoryUtil() {}

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      try {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Order.class);
        configuration.addAnnotatedClass(ITProject.class);
        configuration.addAnnotatedClass(Admin.class);
        StandardServiceRegistryBuilder builder =
            new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
      } catch (Exception e) {
        System.out.println("Исключение!" + e);
      }
    }
    return sessionFactory;
  }
}
