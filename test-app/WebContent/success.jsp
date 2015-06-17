<%
    if ((session.getAttribute("PESEL") == null) || (session.getAttribute("PESEL") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} else {
%>
Welcome <%=session.getAttribute("PESEL")%>
<a href='logout.jsp'>Log out</a>
<%
    }
%>