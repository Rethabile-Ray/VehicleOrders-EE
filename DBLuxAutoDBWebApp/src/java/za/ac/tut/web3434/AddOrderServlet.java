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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.tut.bl3434.OrderFacadeLocal;
import za.ac.tut.entity3434.OrderEntity;

/**
 *
 * @author mokau
 */
public class AddOrderServlet extends HttpServlet {
@EJB OrderFacadeLocal oFacade;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderID = request.getParameter("referenceNum");
         String fullName = request.getParameter("fullName");
           String custID = request.getParameter("id");
             String partName = request.getParameter("partName");
               String partCategory = request.getParameter("partCategory");
        String partQuantity = request.getParameter("partQuantity");
        Integer quantity = Integer.parseInt(partQuantity);
        
        String unitPrice = request.getParameter("unitPrice");
        Double price = Double.parseDouble(unitPrice);
        Date dob = oFacade.createDate(custID);
        
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        String sOrderDate = request.getParameter("orderDate");
       
    try {
        Date orderDate = formatter.parse(sOrderDate);
        String sExpectedDate = request.getParameter("expectedDate");
        Date expectedDate = formatter.parse(sExpectedDate);
        
        OrderEntity order = new OrderEntity(orderID, fullName, custID, dob, partName, partCategory, quantity, price,  orderDate,  expectedDate);
        oFacade.create(order);
        RequestDispatcher diss = request.getRequestDispatcher("added_order.jsp");
        diss.forward(request, response);
        
    } catch (ParseException ex) {
        Logger.getLogger(AddOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
       // processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
