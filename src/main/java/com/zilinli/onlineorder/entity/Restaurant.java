//**********************************************************************************************************************
// * Documentation
// * Author: zilin.li
// * Date: 12/22
// * Definition: Implementation of Restaurant class.
//**********************************************************************************************************************

package com.zilinli.onlineorder.entity;
//**********************************************************************************************************************
// * Includes
//**********************************************************************************************************************

// System includes
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//**********************************************************************************************************************
// * Class definition
//**********************************************************************************************************************
@Entity
@Table(name = "restaurants")
public class Restaurant implements Serializable {

//**********************************************************************************************************************
// * Class constructors
//**********************************************************************************************************************

//**********************************************************************************************************************
// * Public methods
//**********************************************************************************************************************

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
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
    private int id;
    private String address;
    private String name;
    private String phone;
    private String imageUrl;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // "restaurant" is the name of data field in MenuItem
    // fetch eager: get menu item list information when querying the restaurant information
    private List<MenuItem> menuItemList;
}
