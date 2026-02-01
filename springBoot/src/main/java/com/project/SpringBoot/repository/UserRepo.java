package com.project.SpringBoot.repository;

import com.project.SpringBoot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByName(String name);
}
/*
docker run -d \
  --name postgres-db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=0000 \
  -e POSTGRES_DB=mydb \
  -v pgdata://var/lib/postgresql \
  -p 5432:5432 \
  postgres

*  docker exec -it postgres-db psql -U postgres
*  create database db;
*  \l => to list all the DBs;
*   \c db; => to connect to database db


CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  password TEXT UNIQUE NOT NULL
);

INSERT INTO users (name, password) VALUES ('Alice', '0000');
 */