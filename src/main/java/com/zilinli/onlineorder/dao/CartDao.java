//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 12/22
// * Definition: Implementation of CartDao class.
//**********************************************************************************************************************

package com.zilinli.onlineorder.dao;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************

// Framework includes
import com.zilinli.onlineorder.entity.Cart;
import com.zilinli.onlineorder.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@Repository
public class CartDao {

//**********************************************************************************************************************
// * Class constructors
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************

    public void removeCartItem(int orderItemId) {

        Session session = null;
        try {
            session = sessionFactory.openSession();

            // Remove order item from carts
            OrderItem orderItem = session.get(OrderItem.class, orderItemId);
            Cart cart = orderItem.getCart();
            cart.getOrderItemList().remove(orderItem);

            // Remove order item from db
            session.beginTransaction();
            session.delete(orderItem);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public void removeAllCartItems(Cart cart) {
        for (OrderItem orderItem : cart.getOrderItemList()) {
            this.removeCartItem(orderItem.getId());
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
    private SessionFactory sessionFactory;
}
