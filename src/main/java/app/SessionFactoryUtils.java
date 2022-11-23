package app;

import app.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class SessionFactoryUtils {

    private final SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Product.class)
            .buildSessionFactory();

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

}
