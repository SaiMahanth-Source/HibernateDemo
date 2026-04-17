package org.mahanth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App
{
    public static void main( String[] args )
    {
        User user = null;
//        user.setuId(1);
//        user.setuName("Sai Mahanth Nagendla");
//        user.setuEmail("Chintureddy1218@gmail.com");

//        UserName userName = new UserName();
//        userName.setFirstName("Nagendla");
//        userName.setMiddleName("Sai Mahanth");
//        userName.setLastName("Reddy");
//
//        user.setuId(1);
//        user.setuName(userName);
//        user.setuEmail("Chintureddy1218@gmail.com");
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
        //For default file name no need to mention the configuration file name

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        // As buildSessionFactory is deprecated we were creating object of ServiceRegistry for to be else not required
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
//        session.persist(user);
//        user = (User) session.get(User.class, 11);// get is from old hibernate
        user = (User) session.find(User.class, 1);// find is for new hibernate
        transaction.commit();

        System.out.println(user);
        session.close();
    }
}
