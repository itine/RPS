/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import models.Client;
import models.Orders;

/**
 *
 * @author Сергей
 */
@Stateless
public class ShopDAO implements ShopDAOLocal {
    @PersistenceContext(unitName = "jpalab-ejbPU")
    private EntityManager em;

    @Override
    public List<Orders> getAllOrders() throws Exception {
        TypedQuery<Orders> namedQuery = em.createNamedQuery("Orders.findAll", Orders.class);
        return namedQuery.getResultList();
    }

    @Override
    public Orders addOrder(Orders order) throws Exception {
        em.persist(order); //добавить
        em.flush(); //заканчивает транзакцию
        return order;
    }

    @Override
    public boolean deleteOrder(int idOrder) throws Exception {
        em.remove(em.getReference(Orders.class, idOrder));
        return true;
    }

    @Override
    public List<Client> getAllClients() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
