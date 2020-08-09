<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produkthantering | Bygghandeln AB</title>
    <link rel="stylesheet" href="./CSS/styleProduct_Handeling.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="./JavaScript/productHandeling.js"></script>
</head>
<body>
    <header>
        <div class = "container">
        <p id="customerFeedback"></p>
            <nav>
                <ul>
                    <li><a href="./index.jsp">Hem</a></li>
                    <li><a href="./order_Handeling.jsp">Orderhantering</a></li>
                    <li class="current"><a href="./product_Handeling.jsp">Produkthantering</a></li>
                    <li><a href="./customer_Handling.jsp">Kundhantering</a></li>
                    <li><a href="./unitTesting.jsp">Testning</a></li>
                    <li><a href="./about.jsp">Om</a></li>                                            
                </ul>
            </nav>
        </div>
    </header>
    <section id="informationSection">
        <div id = "informationBoxes">
            <div id="infoBox">
                <img src="./img/Produkthantering_verktyg.png" alt="Picture of Product Handeling logo">
                <h3>Produkthanteraren möjliggör skapandet och hanteringen av produkter och lagersaldon.</h3>
            </div>
            <div id="picBox">
            </div>
        </div>
    </section>
    <section id="inputSection">
        <div class="container">
            <a href="./product_Create.jsp"><input type="button" name="btnToCreateProduct" value="Skapa produkt" ></a>
        </div>
    </section>
    <section id="displaySection" class="container">
       <div>          
            <h2>Produktregister</h2>
            <table id="displayProductTable">
				<thead>
				    <th>ProduktID</th>
	                <th>Produktnamn</th>
	                <th>Produktbeskrivning</th>
	                <th>Lagerkvantitet</th>
	                <th> </th>
	                <th> </th>
				</thead>
                <tbody id="productTableTBoody">
				</tbody>

            </table>
       </div>
    </section>
    <footer>
        <p>Carl Sandelius - Grupp 19 &copy; 2020 </p>
    </footer>
</body>
</html>