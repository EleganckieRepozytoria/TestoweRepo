<%@ page import ="java.sql.*" %>
<%
    String userid = request.getParameter("PESEL");    
    String pwd = request.getParameter("haslo");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl:3306/dorotaj1",
            "dorotaj1", "J56VfF3b");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from Users where PESEL='" + userid + "' and haslo='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("PESEL", userid);
        response.sendRedirect("success.jsp");
    } else {
        out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
%>