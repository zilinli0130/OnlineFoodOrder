//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 02/23
// * Definition: Implementation of Customer class.
//**********************************************************************************************************************

package com.zilinli.onlineorder.entity;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************


import javax.persistence.*;
import java.io.Serializable;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

//**********************************************************************************************************************
// * Class constructors
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

    private static final long serialVersionUID = 1L;

    @Id
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Cart cart;

}
