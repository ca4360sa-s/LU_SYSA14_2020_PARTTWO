<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Skapa Produkt | Bygghandeln AB</title>
    <link rel="stylesheet" href="./CSS/styleProduct_Handeling/styleProduct_Create.css">
</head>
<body>
    <div class="container">
        <div id="upperDiv">
            <a href="./product_Handeling.jsp"><button id="returnBtn">Tillbaka</button></a>
        </div>
        <div id="lowerDiv">
            <h3>Skapa en ny produkt</h3>
                <form action="/SYSA14Web_Project/ControllerServlet" method="post">
                    <input type="text" name="productName" id="productName" required placeholder="Ange produktnamn" >
                    <br>
                    <input type="text" name="productDescription" id="productDescription" required placeholder="Ange produktbeskrivning" >
                    <br>
                    <input type="number" min="0" max="15000"name="stockQuantity" id="stockQuantity" required placeholder="Lagerkvantitet" pattern="[0-9]">
                    <br>
                    <input type="hidden" name="operation" value="createProduct">                   
                    <input type="submit" name="submit" id="submit" value="Skapa produkt">
                </form>
        </div>
    </div>
</body>
</html>