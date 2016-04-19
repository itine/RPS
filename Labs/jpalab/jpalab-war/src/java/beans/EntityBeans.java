
package beans;

import dao.ShopDAOLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import models.Orders;


@Named(value = "entityBeans")
@RequestScoped
public class EntityBeans {
   
    @EJB
    private ShopDAOLocal shop;
    
    @PostConstruct
    private void initializeBean(){
        order = new Orders();
    }
    
    private Orders order;

    private int idOrder;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
    
    
    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
    
    
    public List<Orders> getAllOrders() throws Exception{
        return shop.getAllOrders();
    }
   
    public String addOrder() throws Exception{
       this.shop.addOrder(order);
       return "/Orders.xhtml";
    }
    
    public void deleteOrder(int idOrder) throws Exception{
       shop.deleteOrder(idOrder);        
    }
}