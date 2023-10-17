import models.Car;
import models.Type;
import models.User;
import models.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Word.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        User user = session.find(User.class, 1);
//        System.out.println(user);

//        List<User> list = session.createQuery("select u from User u", User.class).list();
//        System.out.println(list);

//        session.save(new Car("Toyota", Type.HATCHBACK, 300 , 100000,2011));
//
//        session.save(new Word("Harry"));
//        session.save(new Word("Potter"));
//        session.save(new Word("Ron"));
//        session.save(new Word("Granger"));

        List<Word> wordList = session.createQuery("select w from Word w", Word.class).list();
        System.out.println(wordList);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();


    }
}
