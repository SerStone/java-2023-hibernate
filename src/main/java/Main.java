import models.Car;
import models.DriverLicense;
import models.Owner;
import models.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(DriverLicense.class)
                .getMetadataBuilder()
                .build();


        try (
            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
            Session session = sessionFactory.openSession();
        ) {
            Transaction transaction = session.beginTransaction();
            Owner owner = new Owner("Harry", new DriverLicense("C1"));
            session.save(owner);

            Car car = new Car("Volvo", Type.UNIVERSAL, 700, 150000, 2015, owner);
            session.save(car);

//            Car car = session.find(Car.class, 4);
//            System.out.println(car);
//            System.out.println(car.getOwner());
            transaction.commit();
        }

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
    }
}
