package com.vaibhav.example.springjpa.Repository;

import com.vaibhav.example.springjpa.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Component
public class StudentRepository {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public StudentRepository(EntityManagerFactory entityManagerFactory){
        this.entityManagerFactory = entityManagerFactory;
    }


    public List<Student> getAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT s FROM Student s");
        List<Student> list = query.getResultList();
        System.out.println(list.size());
        entityManager.getTransaction().commit();
        entityManager.close();
        return list;
    }

}
