<%@ page import="java.sql.*"%>
<%
try {
	//load Driver class
	Class.forName("com.mysql.jdbc.Driver");
	           //create connection
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
	               //create statement
	Statement stmt=con.createStatement();
	String sql="select * from patients";
ResultSet rs=stmt.executeQuery(sql);
%>
<body style='background-image: url(cartoon-male-doctor-a8Je0VC-600.jpg); height:700px ;width:700px;'>
<table border='1'>
<tr><th>PatientID</th><th>Name</th><th>Mobile</th><th>RoomNo</th><th>Disease</th><th>Date_of_admit</th><th>Date_of_discharge</th><th colspan='2'>ACTION</th></tr>
<% 
while(rs.next()) {
	%>
	<tr>
<td>"+rs.getInt(1)+"</td>
<td>"+rs.getString(2)+"</td>
<td>"+rs.getLong(3)+"</td>
<td>"+rs.getInt(4)+"</td>
<td>"+rs.getString(5)+"</td>
<td>"+rs.getString(6)+"</td>
<td>"+rs.getString(7)+"</td>
<td><a href='delete?PatientID="+rs.getInt(1)+"'>DELETE</a></td>
<td><a href='edit?PatientID="+rs.getInt(1)+"'>EDIT</a></td>
</tr>
<% 
 } 
%>
<tr><td colspan='9'><a href='index2.html'>Add</a></td></tr>
</table>
<a href='logout.jsp'>Logout</a>
</body>
<%
}
catch(Exception e) {
e.printStackTrace();
}
%>