package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/*
* ORM - Object Relation Management
* JPA - Java persistent API, Jakarta Persistence
*
*  docker run --name my-postgres -p 5432:5432 -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=1234 -d postgres
*  docker exec -it my-postgres psql -U admin
*  create database db;
*  \l => to list all the DBs;
*   \c db; => to connect to database db
*
* CREATE USER myuser WITH PASSWORD 'mypassword';
* GRANT ALL PRIVILEGES ON DATABASE db TO myuser;
*
* GRANT ALL ON SCHEMA public TO myuser;
* */


public class Main {
    public static void main(String[] args){
        Student s1 = new Student();
        s1.setSid(1);
        s1.setSname("Anand");
        s1.setFavCourse("Java");

        Configuration config = new Configuration().addAnnotatedClass(Student.class).configure();
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(s1);
        transaction.commit();
    }
}
