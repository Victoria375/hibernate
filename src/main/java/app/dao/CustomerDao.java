package app.dao;

import app.SessionFactoryUtils;
import app.model.Customer;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDao {

    private final SessionFactoryUtils sessionFactoryUtils;

    public CustomerDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    Session session = null;

    public List<Customer> findAll() {
        session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        List<Customer> list = session.createQuery("FROM Customers").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return list;
    }
}
