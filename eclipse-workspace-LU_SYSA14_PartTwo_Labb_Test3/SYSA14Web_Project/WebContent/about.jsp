<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="./CSS/styleAbout.css">
</head>
<body>
<header>
        <div class = "container">
            <nav>
                <ul>
                    <li><a href="./index.jsp">Hem</a></li>
                    <li><a href="./order_Handeling.jsp">Orderhantering</a></li>
                    <li><a href="./product_Handeling.jsp">Produkthantering</a></li>
                    <li><a href="./customer_Handling.jsp">Kundhantering</a></li>
                    <li><a href="./unitTesting.jsp">Testning</a></li>          
                    <li class="current"><a href="./about.jsp">Om</a></li>                                            
                </ul>
            </nav>
        </div>
    </header>
 <section id = "information">
        <div class="container">
            <h1>Uppgiftsinformation</h1>
            <p>Programmet tillåer användaren att hantera information om kunder, produkter, lagerkvantiteter 
                och ordrar på ett lättöverskådligt sätt. Detta utifrån tre övergripande menyer för att bl.a. tillhandahålla CRUD-funktionalitet för de olika entiteterna i databasen.</p>
        </div>    
    </section>
    <section id="boxes">
        <div class="container">
            <div class="box" onclick="location.href='./order_Handeling.jsp'">
                <img src="./img/Orderhantering_order.png" alt="Picture of an order">
                <h3>Orderhanteraren</h3>
                <p>Tillhandahåller funktionalitet för dig att skapa och hantera ordrar innehållande olika produkter för kund</p>
            </div>
            
            <div id="boxProductHandler" class="box" onclick="location.href='./product_Handeling.jsp'">
                <img src="./img/Produkthantering_verktyg.png" alt="Picture of different products">
                <h3>Produkthanteraren</h3>
                <p>Möjliggör skapandet och hanteringen av produkter och lagersaldon.</p>
            </div>
            <div class="box" onclick="location.href='./customer_Handling.jsp'">
                <img src="./img/Kundhantering_kunder.png" alt="Picture of a group of customers">
                <h3>Kundhanteraren</h3>
                <p>Tillåter dig att skapa, uppdatera, radera och söka efter en eller flera kunder.</p>
            </div>
        </div>
    </section>
    <footer>
        <p>Carl Sandelius - Grupp 19 &copy; 2020 </p>
    </footer>
</body>
</html>