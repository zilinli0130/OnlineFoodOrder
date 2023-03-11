//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 12/22
// * Definition: Implementation of MenuInfoDao class.
//**********************************************************************************************************************

package com.zilinli.onlineorder.dao;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************

// Project includes
import com.zilinli.onlineorder.entity.MenuItem;
import com.zilinli.onlineorder.entity.Restaurant;

// Framework includes
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// System includes
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@Repository
public class MenuInfoDao {

//**********************************************************************************************************************
// * Class constructors
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************

    public List<Restaurant> getRestaurants() {

        try {
            Session session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Restaurant> criteria = builder.createQuery(Restaurant.class);
            criteria.from(Restaurant.class);
            return session.createQuery(criteria).getResultList();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<MenuItem> getAllMenuItems(int restaurantId) {
        try {
            Session session = sessionFactory.openSession();
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            if (restaurant != null) {
                return restaurant.getMenuItemList();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public MenuItem getMenuItem(int menuitemId) {
        try {
            Session session = sessionFactory.openSession();
            return session.get(MenuItem.class, menuitemId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
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
