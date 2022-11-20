package app.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDao<Product> {

    protected final Class<Product> typeParameterClass;

    @Autowired
    public ProductDao(Class<Product> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
    }

    SessionFactory sessionFactory = new Configuration()
            .buildSessionFactory();

    Session session = null;

    public Product findById(Long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = (Product) session.get(typeParameterClass, id);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return product;
    }

    public List<Product> findAll() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = String.format("from %s",typeParameterClass.getCanonicalName());
        Query SQLQuery = session.createQuery(hql);
        List<Product> list = (List<Product>) SQLQuery.list();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return list;
    }

    public void deleteById(Long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product del = (Product) session.get(typeParameterClass, id);
        session.delete(del);
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

