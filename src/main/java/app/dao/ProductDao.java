package app.dao;

import app.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {

 //   protected final Class<Product> typeParameterClass;
//
//    public ProductDao(Class<Product> typeParameterClass) {
//        this.typeParameterClass = typeParameterClass;
//    }

    SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Product.class)
            .buildSessionFactory();

    Session session = null;

    public Product findById(Long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return product;
    }

    public List<Product> findAll() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> list = session.createQuery("FROM Product").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return list;
    }

    public void deleteById(Long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Product WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
//        Product del = (Product) session.get(Product.class, id);
//        session.delete(del);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    public void saveOrUpdate(Product product) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    public void add(Product product) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

}

