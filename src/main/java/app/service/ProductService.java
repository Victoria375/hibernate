package app.service;

import app.dao.ProductDao;
import app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product findById(Long id) {
        return productDao.findById(id);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public Product saveOrUpdate(Product product) {
        productDao.saveOrUpdate(product);
        return product;
    }

    public void add(Product product) {
        productDao.add(product);
    }

}
