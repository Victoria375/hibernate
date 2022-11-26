package app.dao;

import app.SessionFactoryUtils;
import app.model.Orders;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDao {
    private final SessionFactoryUtils sessionFactoryUtils;

    public OrderDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    Session session = null;

    public List<Orders> findAllOrders() {
        session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        List<Orders> list = session.createQuery("SELECT o FROM Orders o").getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return list;
    }

    public List<Orders> findOrdersByCustomerId(Long id) {
        session = sessionFactoryUtils.getSession();
        session.beginTransaction();
        List<Orders> list = session.createQuery("SELECT * FROM Orders WHERE customer_id = :id")
                .setParameter("id", id)
                .getResultList();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return list;
    }

}
