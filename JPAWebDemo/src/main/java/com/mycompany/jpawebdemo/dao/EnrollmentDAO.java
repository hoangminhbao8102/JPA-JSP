/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpawebdemo.dao;

import com.mycompany.jpawebdemo.entity.Enrollment;
import com.mycompany.jpawebdemo.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author 20113
 */
public class EnrollmentDAO {
    public List<Enrollment> findAll() {
        List<Enrollment> list;
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            list = em.createQuery("from Enrollment", Enrollment.class).getResultList();
        }
        return list;
    }

    public void save(Enrollment enrollment) {
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(enrollment);
            tx.commit();
        }
    }

    public Enrollment findById(int id) {
        Enrollment e;
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            e = em.find(Enrollment.class, id);
        }
        return e;
    }

    public void delete(int id) {
        try (EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Enrollment e = em.find(Enrollment.class, id);
            if (e != null) em.remove(e);
            tx.commit();
        }
    }
}
