package app.dao;

import app.SessionFactoryUtils;
import app.model.Product;
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

//    SessionFactory sessionFactory = new Configuration()
//            .addAnnotatedClass(Product.class)
//            .buildSessionFactory();

    private final SessionFactoryUtils sessionFactoryUtils;

    public ProductDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    Session session = null;

    public Product findById(Long id) {
        session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return product;
    }

    public List<Product> findAll() {
        session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        List<Product> list = session.createQuery("FROM Product").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return list;
    }

    public void deleteById(Long id) {
        session = sessionFactoryUtils.getSession();
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
        session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        session.update(product);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    public void add(Product product) {
        session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

}

