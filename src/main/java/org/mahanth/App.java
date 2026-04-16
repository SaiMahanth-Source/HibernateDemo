package org.mahanth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        User user = new User();
        user.setuId(1);
        user.setuEmail("Chintureddy1218@gmail.com");
        user.setuName("Sai Mahanth Nagendla");

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
        //For default file name no need to mention the configuration file name

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();

        session.close();
    }
}
