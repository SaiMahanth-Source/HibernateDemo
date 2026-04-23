package org.mahanth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class AppDemo {
    public static void main(String[] args) {

        Configuration configuration = new  Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        User user = session.find(User.class,1);

//        for(int i=1;i<119;i++){
//            UserName userName = new UserName();
//            userName.setFirstName("FirstName"+i);
//            userName.setLastName("LastName"+i);
//            userName.setMiddleName("MiddleName"+i);
//
//            User user = new User();
//            user.setuId(i);
//            user.setuName(userName);
//            user.setuEmail("email"+i);
//
//            session.persist(user);
//        }

        Query query1 = session.createQuery("from User"); // Like Select * from Users ;
        Query query2 = session.createQuery("from User where uId > 52");// Like Select * from Users where uId > 52 ;
        Query query3 = session.createQuery("from User where uId = 11");//Se;ect * from Users where uId = 11 ;
        Query query4 = session.createQuery("Select uId, uName, uEmail from User where uId = 19");
        Query query5 = session.createQuery("Select uId, uName, uEmail from User");
        Query query6 = session.createQuery("Select uId, uName, uEmail from User U where U.uId > 52");// Like Select * from Users where uId > 52 ;
        Query query7 =  session.createQuery("Select sum(uId) from User where uId > 69");

//        List<User> users = query1.list();
//        for(User user : users){
//            System.out.println(user.toString());
//        }

//        User user = (User)query3.uniqueResult();
//        System.out.println(user);

//        Object[] user = (Object[]) query4.uniqueResult();
//        List<Object[]> users2 = (List<Object[]>) query5.list();
//
//        for(Object[] u : users2){
//            System.out.println(u[0] + " :  " + u[1] + " : " +  u[2]);
//        }

        Long sumOfMarks = (Long)query7.uniqueResult();
        System.out.println(sumOfMarks);

        transaction.commit();
        session.close();
    }
}
