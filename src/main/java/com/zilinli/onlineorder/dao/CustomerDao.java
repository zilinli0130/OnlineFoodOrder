//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 02/23
// * Definition: Implementation of CustomerDap class.
//**********************************************************************************************************************

package com.zilinli.onlineorder.dao;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************
// Project includes
import com.zilinli.onlineorder.entity.Authorities;
import com.zilinli.onlineorder.entity.Customer;

// Framework includes
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@Repository
public class CustomerDao {

//**********************************************************************************************************************
// * Class constructors
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************
    public void signUp(Customer customer) {

        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmail(customer.getEmail());

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            throw e;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Customer getCustomer(String email) {
        Customer customer = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            customer = session.get(Customer.class, email);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return customer;
    }
//**********************************************************************************************************************
// * Protected methods
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Private methods
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Private attributes
//**********************************************************************************************************************

    @Autowired
    private SessionFactory sessionFactory;
}
