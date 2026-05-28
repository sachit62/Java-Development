package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Alien a1 = new Alien();
        a1.setId(102);
        a1.setName("sk");
        a1.setTech("Java");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // loads hibernate.cfg.xml

        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        session.persist(a1);

        t.commit();

        session.close();
        sf.close();
    }
}