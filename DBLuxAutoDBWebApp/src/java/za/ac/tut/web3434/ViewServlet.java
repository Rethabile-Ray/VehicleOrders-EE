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
public class ViewServlet extends HttpServlet {
@EJB OrderFacadeLocal oFacade;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            List<OrderEntity> underTwentyFive= oFacade.underTwentyFive();
            request.setAttribute("underTwentyFive", underTwentyFive);
            RequestDispatcher diss = request.getRequestDispatcher("view_under_twenty.jsp");
        diss.forward(request, response);
    }
}
