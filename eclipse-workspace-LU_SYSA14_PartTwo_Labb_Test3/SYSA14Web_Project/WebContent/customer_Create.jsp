<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Skapa kund | Bygghandeln AB</title>
    <link rel="stylesheet" href="./CSS/styleCustomer_Handeling/styleCustomer_Create.css">
</head>
<body>
    <div class="container">
        <div id="upperDiv">
            <a href="./customer_Handling.jsp"><button id="returnBtn">Tillbaka</button></a>
        </div>
        <div id="lowerDiv">
            <h3>Skapa en ny kund</h3>
                <form action="/SYSA14Web_Project/ControllerServlet" method="post">
                    <input type="text" name="firstName" id="firstName" required placeholder="Ange förnamn" >
                    <br>
                    <input type="text" name="lastName" id="lastName" required placeholder="Ange efternamn" >
                    <br>
                    <input type="text" name="address" id="address" required placeholder="Ange adress" >
                    <br>
					<input type="hidden" name="operation" value="createPrivateCustomer">
                    <input type="submit" name="submit" id="submit" value="Skapa privatkund">
                </form>
        </div>
    </div>
</body>
</html>