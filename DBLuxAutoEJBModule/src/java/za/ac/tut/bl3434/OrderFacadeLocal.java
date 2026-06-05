/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.bl3434;

import jakarta.ejb.Local;
import java.util.Date;
import java.util.List;
import za.ac.tut.entity3434.OrderEntity;

/**
 *
 * @author mokau
 */
@Local
public interface OrderFacadeLocal {

    void create(OrderEntity order);

    void edit(OrderEntity order);

    void remove(OrderEntity order);

    OrderEntity find(Object id);
    Date createDate(String custID);
    List<OrderEntity> underTwentyFive();
    List<OrderEntity> criticalDelayedOrders();
    List<OrderEntity> pastNinetyDays();
    OrderEntity oldest();

    List<OrderEntity> findAll();

    List<OrderEntity> findRange(int[] range);

    int count();
    
}
