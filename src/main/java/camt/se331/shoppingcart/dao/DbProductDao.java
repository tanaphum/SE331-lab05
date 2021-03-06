package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.Product;
import camt.se331.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Dto on 2/9/2015.
 */
@Profile("db.dbdao")
@Repository
public class DbProductDao implements ProductDao{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProducts(String anyKeyword) {
        return productRepository.findByAnyValue(anyKeyword);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(Product product) {
        productRepository.delete(product);
        product.setId(null);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
