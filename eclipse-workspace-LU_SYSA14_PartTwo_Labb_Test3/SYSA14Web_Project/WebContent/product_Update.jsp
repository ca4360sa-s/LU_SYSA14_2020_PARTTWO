<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Skapa Produkt | Bygghandeln AB</title>
    <link rel="stylesheet" href="./CSS/styleProduct_Handeling/styleProduct_Update.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="./JavaScript/productUpdate.js"></script>
</head>
<body>
    <div class="container">
        <div id="upperDiv">
            <a href="./product_Handeling.jsp"><button id="returnBtn">Tillbaka</button></a>
        </div>
        <div id="lowerDiv">
            <h3>Uppdatera produkt</h3>
            <p>Fyll i det eller dom fält som ska uppdateras</p>
                <form action="/SYSA14Web_Project/ControllerServlet" onsubmit="return checkContent();" method="post">
                    <input type= "hidden" name="productID" id="productID">   
                    <input type="text" name="productName" id="productName"   >
                    <br>
                    <input type="text" name="productDescription" id="productDescription"  >
                    <br>
                    <input type="number" min="0" max="15000"name="stockQuantity" id="stockQuantity" pattern="[0-9]" >
                    <br>
                    <input type="hidden" name="operation" value="updateProduct">                   
                    <input type="submit" name="submit" id="submit" value="Uppdatera produkt">
                </form>
        </div>
    </div>
</body>
</html>