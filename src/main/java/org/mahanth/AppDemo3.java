package org.mahanth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppDemo3 {
    public static void main(String[] args){

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(UserName.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        UserName userName = new UserName();
        userName.setFirstName("Sai");
        userName.setMiddleName("Mahanth"); //
        userName.setLastName("Nagendla");

        User user = new User() ;
        user.setuId(1);
        user.setuName(userName);
        user.setuEmail("saimahanthnagendla3@gmail.com"); // At this point it is in transient state

        session.persist(user);
        /*
        Once persisted then it is in persistence state which means for every change in code it fires query
         */

        user.setuEmail("Chintureddy1218@gmail.com"); // At this point it fires update query because of persistence state

//        session.remove(user);// Object will be in detached state after removing no more link between db and code

        session.getTransaction().commit(); // Once commited it goes to detach state

        session.detach(user); // Using detach method we are making it to detach state

        user.setuEmail("saimahanthnagendla3@gmail.com");
        session.close(); //
    }
}
