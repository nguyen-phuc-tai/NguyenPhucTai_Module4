package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
//    private static final Map<Integer, Product> products;
//
//    static {
//        products = new HashMap<>();
//        products.put(1, new Product(1, "Iphone X", "Apple", "White, Black", 700));
//        products.put(2, new Product(2, "Iphone 11", "Apple", "White, Black, Red, Yellow", 800));
//        products.put(3, new Product(3, "Iphone 12", "Apple", "White, Black", 1000));
//        products.put(4, new Product(4, "Note 10", "Samsung", "White, Black, Pink", 900));
//        products.put(5, new Product(5, "Galaxy S20", "Samsung", "White, Black", 800));
//        products.put(6, new Product(6, "Iphone 11 pro Max", "Apple", "White, Black", 1100));
//    }

    @Override
    public List<Product> findAll() {
        return BaseRepository.entityManager.createQuery(
                "select p " +
                        "from product p", Product.class).getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> typedQuery =  BaseRepository.entityManager.createQuery(
                "select p " +
                        "from product p " +
                        "where p.nameProduct = ?1", Product.class);
        typedQuery.setParameter(1, name);

        return typedQuery.getResultList();
    }

    @Override
    public void update( Product product) {
        BaseRepository.entityManager.getTransaction().begin();
        BaseRepository.entityManager.merge(product);
        BaseRepository.entityManager.getTransaction().commit();
    }

    @Override
    public void remove(Product product) {
        BaseRepository.entityManager.getTransaction().begin();
        BaseRepository.entityManager.remove(product);
        BaseRepository.entityManager.getTransaction().commit();
    }
}