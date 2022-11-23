package app.service;

import app.dao.OrderDao;
import app.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Orders> findAll() {
        return orderDao.findAll();
    }

    public List<Orders> findOrdersByCustomerId (Long id) {
        return orderDao.findOrdersByCustomerId(id);
    }

}
