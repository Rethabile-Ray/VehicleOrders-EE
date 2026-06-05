/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web3434;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import za.ac.tut.bl3434.OrderFacadeLocal;
import za.ac.tut.entity3434.OrderEntity;

/**
 *
 * @author mokau
 */
public class ViewAllOrdersServlet extends HttpServlet {

 @EJB OrderFacadeLocal oFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            List<OrderEntity> allOrders = oFacade.findAll();
            request.setAttribute("allOrders", allOrders);
            RequestDispatcher diss = request.getRequestDispatcher("view_all_orders.jsp");
            diss.forward(request, response);
    }

}
