<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Uppdatera kund | Bygghandeln AB</title>
    <link rel="stylesheet" href="./CSS/styleCustomer_Handeling/styleCustomer_Update.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="./JavaScript/customerUpdate.js"></script>
</head>
<body>
    <div class="container">
        <div id="upperDiv">
            <a href="./customer_Handling.jsp"><button id="returnBtn">Tillbaka</button></a>
        </div>
        <div id="lowerDiv">
            <h3>Uppdatera kund</h3>
            <p>Fyll i det eller dom fält som ska uppdateras</p>
                <form action="/SYSA14Web_Project/ControllerServlet" onsubmit="return checkContent();" method="post">
                   	<input type= "hidden" name="customerID" id="customerID">
                    <input type="text" name="firstName" id="firstName" >
                    <br>
                    <input type="text" name="lastName" id="lastName" >
                    <br>
                    <input type="text" name="address" id="address" >
                    <br>
                    <input type="hidden" name="operation" value="updatePrivateCustomer">                  
                    <input type="submit" name="submitUpateCustomer" id="submitUpateCustomer" value="Uppdatera privatkund" >
                </form>
        </div>
    </div>
</body>
</html>