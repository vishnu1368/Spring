package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/*
* JPA - Java persistent API, Jakarta Persistence
* Think JPA as an interface for implementing ORM. And all the tools which solves ORM should implement JPA
*   Frameworks under JPA:
*           Hibernate
*           IBatis
*           TopLink
* ORM - Object Relation Management
*   To reduce the migration effort, after 6.0 Hibernate framework switched to standard naming convention for the client facing methods.
*
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

        Configuration config = new Configuration()
                                .addAnnotatedClass(Student.class)
                                //.addAnnotatedClass(Teacher.class); // entity 2
                                .configure(); // If the created configuration file has a different name than compared to the standard one - hibernate.cfg.xml. You can pass the name as a parameter.

        SessionFactory factory = config.buildSessionFactory(); // Holds mappings for all entities. Knows: Student, Course, Teacher, etc.
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(s1);
        transaction.commit();

       Student s = session.find(Student.class, 101);
       session.remove(s);

       session.close();
       factory.close();
    }
}
