<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="RegisterServlet"  method="POST" >
                <table>
                    <tr>
                        <td>
                           First Name :  
                        </td>
                        <td>
                            <input type="text" name="firstname"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            Last Name :  
                        </td>
                        <td>
                            <input type="text" name="lastname"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Index Number : 
                        </td>
                        <td>
                            <input type="text" name="indexNum"/>
                        </td>

                    </tr>
                     <tr>
                        <td>
                            Field : 
                        </td>
                        <td>
                            <select name="field">
                            	<option value="cse">CSE</option>
                            	<option value="civil">Civil</option>                            	
                            </select>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            Password :
                        </td>
                        <td>
                            <input type="password" name="password"/>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            Retype Password :
                        </td>
                        <td>
                            <input type="password" name="rePassword"/>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            Email :
                        </td>
                        <td>
                            <input type="text" name="email"/>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            Mobile :
                        </td>
                        <td>
                            <input type="text" name="phone1"/>
                        </td>

                    </tr>
                    <tr>
                        <td>
                            Land Line :
                        </td>
                        <td>
                            <input type="text" name="phone2"/>
                        </td>

                    </tr>   
                                          
                    <tr> 
                        <td>
                            <input type="submit" value="Register"/>
                        </td>
                    </tr>
                </table>
            </form>

</body>
</html>