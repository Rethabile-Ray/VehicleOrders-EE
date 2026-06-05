<%-- 
    Document   : view_past_ninety_days
    Created on : 04 Jun 2026, 20:41:49
    Author     : mokau
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity3434.OrderEntity"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Orders In The Past Ninety Days View</h1>
        <table border="1">
            <th>No.</th>
            <th>Order Ref</th>
            <th>Name</th>
            <th>ID</th>
            <th>Date Of Birth</th>
            <th>Part Name</th>
            <th>Quantity Ordered</th>
            <th>Ordered Date</th>
            <%
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
               List<OrderEntity> orders = (List<OrderEntity>)request.getAttribute("pastNinetyDaysOrders");
               for(int x =0; x<orders.size(); x++)
               {
                  OrderEntity order = orders.get(x);
                  String orderID = order.getId();
                  
                   String fullName = order.getFullName();
                   String custID = order.getCustID();
                   String partName = order.getPartName();
                   
                    Integer partQuantity = order.getQuantityOrdered();
                    Date dateOrdered = order.getOrderDate();
                    Date dateOfBirth = order.getDateOfBrith();
                %>
            <tr>
                <td><%=x+1%></td>
                <td><%=orderID%></td>
                <td><%=fullName%></td>
                <td><%=custID%></td>
                <td><%= dateOfBirth%></td>
                <td><%= partName%></td>
                <td><%= partQuantity%></td>
                <td><%= dateOrdered%></td>
            </tr>
                <%
            }
                %>
        </table>
       <p>Click <a href= "menu_page.html">here</a> to view menu.</p>
        <p>Click <a href="LogoutServlet.do">here</a> to logout</p>
    </body>
</html>
