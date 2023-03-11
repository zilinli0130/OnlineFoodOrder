//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 12/22
// * Definition: Implementation of ItemOrderController class.
//**********************************************************************************************************************

package com.zilinli.onlineorder.controller;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************

// Project includes
import com.zilinli.onlineorder.service.OrderItemService;

// Framework includes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@Controller
public class ItemOrderController {

//**********************************************************************************************************************
// * Class constructors
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************
    @RequestMapping(value = "/order/{menuId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addMenuItemToCart(@PathVariable("menuId") int menuId) {
        orderItemService.saveOrderItem(menuId);
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
    private OrderItemService orderItemService;
}
