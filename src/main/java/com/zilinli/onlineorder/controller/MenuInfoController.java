//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 12/22
// * Definition: Implementation of MenuInfoController class.
//**********************************************************************************************************************

package com.zilinli.onlineorder.controller;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************

// Project includes
import com.zilinli.onlineorder.entity.MenuItem;
import com.zilinli.onlineorder.entity.Restaurant;
import com.zilinli.onlineorder.service.MenuInfoService;

// Framework includes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// System includes
import java.util.List;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@Controller
public class MenuInfoController {

//**********************************************************************************************************************
// * Class constructors
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************

    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuItem> getMenuItems(@PathVariable("restaurantId") int restaurantId) {
        return menuInfoService.getAllMenuItems(restaurantId);
    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> getRestaurants() {
        return menuInfoService.getRestaurants();
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
    private MenuInfoService menuInfoService;
}
