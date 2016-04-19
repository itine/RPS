/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Local;
import models.Client;
import models.Orders;

/**
 *
 * @author Сергей
 */
@Local
public interface ShopDAOLocal {

    public List<Orders> getAllOrders() throws Exception;

    public Orders addOrder(Orders order) throws Exception;

    public boolean deleteOrder(int idOrder) throws Exception;

    public List<Client> getAllClients() throws Exception;
}
