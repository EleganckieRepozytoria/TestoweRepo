<%
session.setAttribute("PESEL", null);
session.invalidate();
response.sendRedirect("index.jsp");
%>