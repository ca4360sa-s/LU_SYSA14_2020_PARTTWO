<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Välkommen | Bygghandeln AB</title>
    <link rel="stylesheet" href="./CSS/styleIndex.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"> </script>	
	<script type="text/javascript" src="./JavaScript/index.js"></script>
</head>
<body>
    <header>
        <div class = "container">
            <div id="divPlaceInfo">
	        	<ion-icon name="location-outline" id="placeIcon"></ion-icon>        	
            	<span id="spanPaceIconInfo">Temperaturen i X är Y grade och vädret är Z</span>
            </div>
            <nav>
                <ul>
                    <li class="current"><a href="./index.jsp">Hem</a></li>
                    <li><a href="./order_Handeling.jsp">Orderhantering</a></li>
                    <li><a href="./product_Handeling.jsp">Produkthantering</a></li>
                    <li><a href="./customer_Handling.jsp">Kundhantering</a></li>
                    <li><a href="./unitTesting.jsp">Testning</a></li>          
                    <li><a href="./about.jsp">Om</a></li>                                            
                </ul>
            </nav>
        </div>
    </header>
    <section id = "showcase">
        <div class = "container">
            <p>Välkommen till administrationsprogrammet för</p>
            <h1>Bygghandeln AB</h1>
        </div>
    </section>
     <footer>
        <p>Carl Sandelius - Grupp 19 &copy; 2020 </p>
    </footer>
<script src="https://unpkg.com/ionicons@5.1.2/dist/ionicons.js"></script>   
</body>
</html>