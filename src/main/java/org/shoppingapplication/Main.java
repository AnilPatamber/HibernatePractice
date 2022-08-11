package org.shoppingapplication;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.shoppingapplication.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("List of all the products");
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(5, "Asus TUF A15", 65_000));
        productList.add(new Product(6, "Dell Inspiron", 70_000));
        productList.add(new Product(3, "HP Pavilion", 50_000));
        productList.add(new Product(4, "Apple McBook Pro", 80_000));
        System.out.println(productList);
        addProducts(productList);*/

    }
    public static void addProducts(List<Product> productList){


        //get Session factory object
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (Product prod : productList) {
            session.save(prod);
        }
        session.getTransaction().commit();
        sessionFactory.close();
        System.out.println("Products added to the database successfully!!!");
    }
}
