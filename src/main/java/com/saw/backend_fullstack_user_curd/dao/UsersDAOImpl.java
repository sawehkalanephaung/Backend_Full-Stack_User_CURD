package com.saw.backend_fullstack_user_curd.dao;

import com.saw.backend_fullstack_user_curd.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDAOImpl implements UsersDAO {
    // define fileds for entity manager
    private EntityManager entityManager;


    // set up constructor injection
    @Autowired
    public UsersDAOImpl(EntityManager entityManager) {
            this.entityManager = entityManager;

    } // end

    // defind findall method
    @Override
    public List<Users> findAll() {
        TypedQuery<Users> theQuery = entityManager.createQuery("from Users", Users.class);
        List<Users> users = theQuery.getResultList();
        return users;
    } // end

    // defind findById method
    @Override
    public Users findById(int theId) {
        Users theUser = entityManager.find(Users.class, theId);
        return theUser;
    } // end

    // defind save method
    @Override
    public Users save(Users theUser) {
        // if statement to check if id is null or not
        if (theUser.getId() == 0) {
            entityManager.persist(theUser);
        } else {
             return entityManager.merge(theUser);
        }
        return theUser;
    } // end

    // defind deleteById method
    @Override
    public void deleteById(int theId) {
        Users theUser = entityManager.find(Users.class, theId);
        entityManager.remove(theUser);
    } //end
}
