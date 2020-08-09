<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kundhantering | Bygghandeln AB</title>
    <link rel="stylesheet" href="./CSS/styleCustomer_Handeling.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="./JavaScript/customerHandeling.js"></script>
</head>
<body>
    <header>
        <div class = "container">
            <p id="customerFeedback"></p>
            <nav>
                <ul>
                    <li><a href="./index.jsp">Hem</a></li>
                    <li><a href="./order_Handeling.jsp">Orderhantering</a></li>
                    <li><a href="./product_Handeling.jsp">Produkthantering</a></li>
                    <li  class="current"><a href="./customer_Handling.jsp">Kundhantering</a></li>
                    <li><a href="./unitTesting.jsp">Testning</a></li>
                    <li><a href="./about.jsp">Om</a></li>                                                                              		
                </ul>
            </nav>
        </div>
    </header>
    <section id="informationSection">
        <div id = "informationBoxes">
            <div id="infoBox">
                <img src="./img/Kundhantering_kunder.png" alt="Picture of Customer Handeling logo">
                <h3>Kundhanteraren tillåter dig att skapa, uppdatera, radera och överblicka registrerade kunder.</h3>
            </div>
            <div id="picBox">
            </div>
        </div>
    </section>
    <section id="inputSection">
        <div class="container">
            <a href="./customer_Create.jsp"><input type="button" value="Skapa kund" >
            </a>
        </div>
    </section>
    <section id="displaySection" class="container">
       <div>          
            <h2>Kundregister</h2>
            <table id="displayCustomerTable">
            	<thead>
            		<th>KundID</th>
	                <th>Förnamn</th>
	                <th>Efternamn</th>
	                <th>Adress</th>
	                <th> </th>
	                <th> </th>      
            	</thead>
				<tbody id="customerTableTBoody">
				</tbody>
				
            </table>
       </div>
    </section>
    <footer>
        <p>Carl Sandelius - Grupp 19 &copy; 2020 </p>
    </footer>
</body>
</html>