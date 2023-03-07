//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 12/22
// * Definition: Implementation of CustomerService class.
//**********************************************************************************************************************

package com.zilinli.onlineorder.service;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************

// Project includes
import com.zilinli.onlineorder.dao.CustomerDao;
import com.zilinli.onlineorder.entity.Cart;
import com.zilinli.onlineorder.entity.Customer;

// Framework includes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@Service
public class CustomerService {

//**********************************************************************************************************************
// * Class constructors
//**********************************************************************************************************************
    @Autowired
    public CustomerService(CustomerDao customerDao, PasswordEncoder passwordEncoder) {
        this.customerDao = customerDao;
        this.passwordEncoder = passwordEncoder;
    }
//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************
    public void signUp(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);
        customer.setEnabled(true);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
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
    private CustomerDao customerDao;
    private PasswordEncoder passwordEncoder;

}
