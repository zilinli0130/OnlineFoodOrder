//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 12/22
// * Definition: Implementation of OrderItemService class.
//**********************************************************************************************************************

package com.zilinli.onlineorder.service;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************

// Project includes
import com.zilinli.onlineorder.dao.OrderItemDao;
import com.zilinli.onlineorder.entity.Customer;
import com.zilinli.onlineorder.entity.MenuItem;
import com.zilinli.onlineorder.entity.OrderItem;

// Framework includes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@Service
public class OrderItemService {

//**********************************************************************************************************************
// * Class constructors
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************
    public void saveOrderItem(int menuitemId) {

        OrderItem orderItem = new OrderItem();

        // Get the menu item
        MenuItem menuItem = menuInfoService.getMenuItem(menuitemId);

        // Get the authorized customer
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);

        // Save order item
        orderItem.setMenuItem(menuItem);
        orderItem.setCart(customer.getCart()); // "add order item to cart"
        orderItem.setQuantity(1);
        orderItem.setPrice(menuItem.getPrice());
        orderItemDao.save(orderItem);
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
    private OrderItemDao orderItemDao;

    @Autowired
    private MenuInfoService menuInfoService;

    @Autowired
    private CustomerService customerService;
}
