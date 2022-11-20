package lesson5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = null;

        try {

            // === CREATE ===
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Product product = new Product("Bread", 50);
//            System.out.println(product);
//            session.save(product);
//            System.out.println(product);
//            session.getTransaction().commit();

            // === READ ===
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Product productFromDb = session.get(Product.class, 1L);
//            System.out.println(productFromDb);
//            session.getTransaction().commit();

//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Product productFromDb = session.createQuery("SELECT p FROM Product p WHERE p.id = 2", Product.class)
//                            .getSingleResult();
//            System.out.println(productFromDb);
//            session.getTransaction().commit();

//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class)
//                    .getResultList();
//            System.out.println(products);
//            session.getTransaction().commit();

            // === UPDATE ===
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Product productFromDb = session.get(Product.class, 1L);
//            System.out.println(productFromDb);
//            productFromDb.setPrice(100);
//            System.out.println(productFromDb);
//            session.getTransaction().commit();

            // === DELETE ===
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//            Product productFromDb = session.get(Product.class, 1L);
//            session.remove(productFromDb);
//            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
            if (session != null) {
                session.close();
            }
        }

    }
}
