<%@ page import="java.io.*,java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.webapp.db.*" %> 
<%
 

            String sn=request.getParameter("ver");
 
Connection connection = null;

connection = DBUtill.getConnection();

                  
                    PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where login=?");
                   
                    preparedStatement.setString(1, sn);
        			ResultSet rs = preparedStatement.executeQuery();
                    if(rs.next())
                    {    
                        out.println("<font color=red>");
                        out.println("Login already taken");
                        out.println("</font>");
 
                    }else {
 
                        out.println("<font color=green>");
                        out.println("Available");
                        out.println("</font>");
 
                    }
 
                    DBUtill.closeConnection(connection);
 
%>