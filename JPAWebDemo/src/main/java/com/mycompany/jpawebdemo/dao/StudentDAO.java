/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpawebdemo.dao;

import com.mycompany.jpawebdemo.entity.Student;
import com.mycompany.jpawebdemo.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author 20113
 */
public class StudentDAO {
    public List<Student> findAll() {
        List<Student> students;
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            students = em.createQuery("from Student", Student.class).getResultList();
        }
        return students;
    }

    public void save(Student student) {
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(student);
            tx.commit();
        }
    }

    public Student findById(int id) {
        Student s;
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            s = em.find(Student.class, id);
        }
        return s;
    }

    public void update(Student student) {
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(student);
            tx.commit();
        }
    }

    public void delete(int id) {
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Student s = em.find(Student.class, id);
            if (s != null) em.remove(s);
            tx.commit();
        }
    }
}
