package app.dao;

import app.SessionFactoryUtils;
import app.model.Cart;
import app.model.Product;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class CartDao {

    private final SessionFactoryUtils sessionFactoryUtils;

    public CartDao(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    Session session = null;

    public void addProduct(Cart cart, Product product, Integer quantity) {
//TODO
    }

//    public Integer getSum(Cart cart) {
//TODO
//    }

//    public int getQuantityOfProducts(Cart cart, Product product) {
//
//    }

}