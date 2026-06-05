/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.bl3434;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.tut.entity3434.OrderEntity;

/**
 *
 * @author mokau
 */
@Stateless
public class OrderFacade extends AbstractFacade<OrderEntity> implements OrderFacadeLocal {

    @PersistenceContext(unitName = "DBLuxAutoEJBModulePU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderFacade() {
        super(OrderEntity.class);
    }
    @Override
    @RolesAllowed("supervisor")
    public void create(OrderEntity entity) {
        super.create(entity); // Hands the data safely back up to AbstractFacade
    }

    @Override
    @DenyAll
    public void edit(OrderEntity entity) {
        super.edit(entity);
    }

    @Override
     @DenyAll
    public void remove(OrderEntity entity) {
        super.remove(entity);
    }

    @Override
    @RolesAllowed("manager")
    public java.util.List<OrderEntity> findAll() {
        return super.findAll();
    }
    
    @Override
    @RolesAllowed("supervisor")
    public Date createDate(String custID) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String sDate = custID.substring(0, 6);
         Date dateOfBirth = null;
        try {
             dateOfBirth = formatter.parse(sDate);
            
        } catch (ParseException ex) {
            Logger.getLogger(OrderFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dateOfBirth;
    }
      
    @Override
    @RolesAllowed("manager")
    public List<OrderEntity> underTwentyFive() {
        Query query = em.createQuery("SELECT c FROM OrderEntity c");
        Calendar current = Calendar.getInstance();
       
        List<OrderEntity> orders = query.getResultList();
        List<OrderEntity> people = new ArrayList<>();
        for(int x=0; x<orders.size(); x++)
        {
            OrderEntity order = orders.get(x);
            Date dob = order.getDateOfBrith();
            Calendar birth = Calendar.getInstance();
            birth.setTime(dob);
            int age = current.get(Calendar.YEAR)- birth.get(Calendar.YEAR);
            if(age<25)
            {
                people.add(order);
            }
        }
        return people;
    }

    @Override
     @RolesAllowed("manager")
    public List<OrderEntity> criticalDelayedOrders() {
        Query query = em.createQuery("SELECT c FROM OrderEntity c WHERE c.expectedDate < :currentDate AND c.quantityOrdered > 50");
        Calendar current = Calendar.getInstance();
        Date currentDate = current.getTime();
        query.setParameter("currentDate", currentDate);
        List<OrderEntity> orders = query.getResultList();
        return orders;
     
    }

    @Override
    @RolesAllowed("manager")
    public List<OrderEntity> pastNinetyDays() {
         Query query = em.createQuery("SELECT c FROM OrderEntity c WHERE c.orderDate >= :nineMinusDate ");
        Calendar ninetyDate = Calendar.getInstance();
        ninetyDate.add(Calendar.DAY_OF_YEAR, -90);
        Date nineMinusDate = ninetyDate.getTime();
        query.setParameter("nineMinusDate", nineMinusDate);
        List<OrderEntity> orders = query.getResultList();
         return orders;
       
    }

    @Override
    @RolesAllowed("manager")
    public OrderEntity oldest() {
        Query query = em.createQuery("SELECT c FROM OrderEntity c ORDER BY c.dateOfBrith ASC");
        query.setMaxResults(1);
        OrderEntity oldestPerson = (OrderEntity)query.getSingleResult();
        return oldestPerson;
       
    }
    
}
