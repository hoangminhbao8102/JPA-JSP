/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpawebdemo.dao;

import com.mycompany.jpawebdemo.entity.Course;
import com.mycompany.jpawebdemo.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author 20113
 */
public class CourseDAO {
    public List<Course> findAll() {
        List<Course> list;
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            list = em.createQuery("from Course", Course.class).getResultList();
        }
        return list;
    }

    public void save(Course course) {
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(course);
            tx.commit();
        }
    }

    public Course findById(int id) {
        Course c;
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            c = em.find(Course.class, id);
        }
        return c;
    }

    public void update(Course course) {
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(course);
            tx.commit();
        }
    }

    public void delete(int id) {
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Course c = em.find(Course.class, id);
            if (c != null) em.remove(c);
            tx.commit();
        }
    }
}
