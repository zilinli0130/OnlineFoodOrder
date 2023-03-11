//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 12/22
// * Definition: Implementation of CartService class.
//**********************************************************************************************************************

package com.zilinli.onlineorder.service;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************

// Project includes
import com.zilinli.onlineorder.dao.CartDao;
import com.zilinli.onlineorder.entity.Cart;
import com.zilinli.onlineorder.entity.Customer;

// Framework includes
import com.zilinli.onlineorder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@Service
public class CartService {

//**********************************************************************************************************************
// * Class constructors
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************

    public Cart getCart() {

        // Get the authorized customer
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);

        if (customer != null) {
            Cart cart = customer.getCart();
            double totalPrice = 0;
            for (OrderItem orderItem : cart.getOrderItemList()) {
                totalPrice += orderItem.getPrice() * orderItem.getQuantity();
            }
            cart.setTotalPrice(totalPrice);
            return cart;
        }
        return new Cart();
    }

    public void cleanCart() {

        // Get the authorized customer
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);

        if (customer != null) {
            cartDao.removeAllCartItems(customer.getCart());
        }
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
    private CustomerService customerService;

    @Autowired
    private CartDao cartDao;
}
