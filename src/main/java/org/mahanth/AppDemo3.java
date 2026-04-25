package org.mahanth;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AppDemo3 {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).addAnnotatedClass(UserName.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        User user1 = session.find(User.class,1);// It will hit db because fetch type is eager that's why and not proxy

        /*
        Load or getReference will not hit the database until unless we are using in the code so it gives proxy object instead
        */
        User user2 = session.getReference(User.class,2);
        /*
        find, load will throw different exception for example if no data then find will return the null and load will
        throw no object found error which we can handle with try catch
         */
//        System.out.println(user1);

        try{
            System.out.println(user2);
        }
        catch(ObjectNotFoundException objectNotFoundException){
            System.out.println(objectNotFoundException.getMessage());
        }

        session.getTransaction().commit();
        session.close();
    }
}
