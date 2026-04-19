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
        User user = null ;
//        user.setuId(1);
//        user.setuName("Sai Mahanth Nagendla");
//        user.setuEmail("Chintureddy1218@gmail.com");

//        UserName userName = new UserName();
//        userName.setFirstName("Sai");
//        userName.setMiddleName("Nagendla");
//        userName.setLastName("Mahanth");
//
//        user.setuId(2);
//        user.setuName(userName);
//        user.setuEmail("saimahanthnagendla3@gmail.com");
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
        System.out.println(user);

        user = (User) session.find(User.class, 1);
        System.out.println(user);
        /*
           When we mentioned different id's query filed for twice but when we mention same id in two different times
           then query will be filed for only once because of hibernate first level cache, which it stores the data for
           the query filed within the session, and first level cache is for session private unlike second level cache
         */

        transaction.commit();
        session.close();
    }
}
