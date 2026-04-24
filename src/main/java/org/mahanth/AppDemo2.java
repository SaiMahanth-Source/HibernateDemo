package org.mahanth;

import jakarta.persistence.Tuple;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class AppDemo2 {
    public static void main(String[] args){

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery<User> query1 = session.createNativeQuery("select * from users_data",User.class);
        NativeQuery query2 = session.createNativeQuery("select uId, User_Email from users_data");

        List<User> users = query1.getResultList();
        List<Object[]> users2 = (List<Object[]>) query2.getResultList();

//        for(Object[] u : users2){
//            System.out.println(u[0] + " : " + u[1]);
//        }

        List<Tuple> results = session
                .createNativeQuery("SELECT uId, User_Email FROM users_data", Tuple.class)
                .getResultList();

        for(Tuple u : results){
            System.out.println(u.get(0) + " : " + u.get(1) );
        }
    }
}
