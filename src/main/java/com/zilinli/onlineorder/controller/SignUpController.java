//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 02/23
// * Definition: Implementation of SignUpController class.
//**********************************************************************************************************************

package com.zilinli.onlineorder.controller;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************

// Project includes
import com.zilinli.onlineorder.entity.Customer;
import com.zilinli.onlineorder.service.CustomerService;

// Framework includes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@Controller
public class SignUpController {

//**********************************************************************************************************************
// * Class constructors
//**********************************************************************************************************************
    @Autowired
    public SignUpController(CustomerService customerService) {
        this.customerService = customerService;
    }
//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************
    @RequestMapping(value="/signup", method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public void signUp(@RequestBody Customer customer) {
        customerService.signUp(customer);
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

    private CustomerService customerService;

}
