<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String uploadUrl = (String) request.getAttribute("uploadUrl");%>
<% String index = (String) request.getAttribute("indexNum");%>
<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
     </head>
    <body>		
        <form method="POST" action="<%= uploadUrl %>"
        enctype="multipart/form-data">
            <table>
                <tr>	
                    <td>Title</td>
                    <td><input type="text" name="title" /></td>
                </tr>
                <tr>	
                    <td>StudentId</td>
                    <td><input type="text" name="studentId"  /></td>
                </tr>
                <tr>	
                    <td>Upload</td>
                    <td><input type="file" name="file" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" /></td>
                </tr>				
            </table>
        </form>
    </body>	
</html>
</html>