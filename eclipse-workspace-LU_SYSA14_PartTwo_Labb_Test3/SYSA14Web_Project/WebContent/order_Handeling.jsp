<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Orderhantering | Bygghandeln AB</title>
    <link rel="stylesheet" href="./CSS/styleOrder_Handeling.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="./JavaScript/orderHandeling.js"></script>
</head>

<body>
    <header>
        <div class = "container">
        	<p id="orderFeedback"></p>
            <nav>
                <ul>
                    <li><a href="./index.jsp">Hem</a></li>
                    <li class="current"><a href="./order_Handeling.jsp">Orderhantering</a></li>
                    <li><a href="./product_Handeling.jsp">Produkthantering</a></li>
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
                <img src="./img/Orderhantering_order.png" alt="Picture of Orderhandeling logo">
                <h3>Orderhanteraren erbjuder funktioner för att skapa och hantera ordrar, innehållande olika produkter.</h3>
            </div>
            <div id="picBox">
            </div>
        </div>
    </section>

    <section id="selectionSection">
        <div id = "selectionBox" >          
                <input type="button" id="btnCreateOrderStepOne" value="Skapa ny order" onclick="displayBoxCreateOrderStepOne()" >
                <input type="button" id="btnViewAlternatives" value="Visningsalternativ" onclick="displayBoxViewViewAlternatives()">        
        </div>
    </section>

    <section id="mainSection" class="container">
      
        <div id="mainBoxes"> 
            <form action="/SYSA14Web_Project/ControllerServlet" method="post">      
                <div id="boxCreateOrderStepOne">
                    <div>
                    <input id="btnCreateOrderNextStepTwo" type="button" value="Steg 2" onclick="displayBoxCreateOrderStepTwo()">
               		</div>
                    <h2>Steg 1) Välj önskade produkter</h2>
                    <table id="displayProductTable">
                    	<thead>
	                    	<th>Produktnamn</th>
	                        <th>Produktbeskrivning</th>
	                        <th></th>
	                        <th></th>	                        
                    	</thead>
                        <tbody>
                        </tbody>
                   </table>          

                </div>
                <div id="boxCreateOrderStepTwo">
                    <div id="SubDivBoxCreateOrderStepTwo">
                        <input id="btnCreateOrderBackStepOne" type="button" value="Steg 1" onclick="displayBoxCreateOrderStepOne()">
                        <input id="btnCreateOrderNextStepThree" type="button" value="Steg 3" onclick="displayBoxCreateOrderStepThree()">
                    </div>
                    <h2>Steg 2) Välj önskad kvantitet</h2>
                    <table id="displayProductQuantityTable">
                    	<thead>
	                    	<th>ProduktID</th>            
	                        <th>Produktnamn</th>
	                        <th>Kvantitet</th>
                    	</thead>
                        <tbody>
                        </tbody>
                    </table>     
                
              
                </div>
                <div id="boxCreateOrderStepThree">
                    <div id="lowerSubDivboxCreateOrderStepThree">
                        <div>
                            <input type="button" id="btnCreateOrderBackStepTwo" value="Steg 2" onclick="displayBoxCreateOrderStepTwo()">
                        </div>
                        <div>
                    		<input type="hidden" name="operation" value="createOrder">                   
                            <input type="submit" name="submit" id="submit" value="Skicka order">
                        </div>
                    </div>
                    <div id="upperSubDivboxCreateOrderStepThree">
                        <h2>Steg 3) Ange kund</h2>
                        <select name="listOfCustomers" id="listOfCustomers"  required >
                        </select>
                    </div>


                    
                </div> 
            </form>
            <div id="boxViewAlternatives">
                <div id="upperSubDivBoxViewAlternatives">
                   <div>
                        <input type="button" value="Visa alla ordrar" onclick="upperSubDivBoxViewAlternativesViewAllOrders()">
                        <input type="button" value="Alla ordrar för kund" onclick="upperSubDivBoxViewAlternativesInputCustomerID()">
                        <!--<input type="button" value="Specifik order" onclick="upperSubDivBoxViewAlternativesInputOrderID()">  --> 

                        <div id ="upperSubDivBoxViewAlternativesInputCustomerID">
                            <label for="customerIDViewAlternatives"> Välj kund: </label>
                            <select name="customerIDViewAlternatives" id="customerIDViewAlternatives">
                            </select>
                            <input type="button" id="btnCustomerIDViewAlternatives" value="Visa" onclick="viewCustomerOrders()">
                        </div>
                        <!--
                        <div id ="upperSubDivBoxViewAlternativesInputOrderID">
                            <label for="orderIDViewAlternatives">VÃÂ¤lj order: </label>
                            <select name="orderIDViewAlternatives" id="orderIDViewAlternatives">
                                <option value="0000">0000</option>
                                <option value="0000">0001</option>
                            </select>
                            <input type="button" value="Visa" id="btnOrderIDViewAlternativesViewCustomerOrders">
                        </div>
                        -->
                    </div>  
                   
                </div>
                <div id="lowerSubDivBoxViewAlternatives">
                    <div id="lowerSubDivBoxViewAlternativesViewAllOrders">
                        <h2>Visar alla ordrar</h2>
                        <table id="tableLowerSubDivBoxViewAlternativesViewAllOrders">
                           <thead>
	                            <th>OrderID</th>
	                            <th>KundID</th>
	                            <th></th>
	                            <th></th>
                           </thead>
                           <tbody>
                           		<!--                        <tr>
                                <td>0000</td>
                                <td>1111</td>
                                <td><input type="button" value="Granska" onclick="upperSubDivBoxViewAlternativesInputOrderIDFromViewAllOrders()"></td>
                                <td><input id="selectBtn"type="button" value="Radera"></td>
                            </tr>
                            <tr>
                                <td>0000</td>
                                <td>1111</td>
                                <td><input type="button" value="Granska" onclick="upperSubDivBoxViewAlternativesInputOrderIDFromViewAllOrders()" ></td>
                                <td><input id="selectBtn"type="button" value="Radera"></td>
                            </tr> -->
                           </tbody>
                        </table>
                    </div>
                    <div id= "lowerSubDivBoxViewAlternativesViewAllOrdersForCustomer">
                        <h2>Visar kundens ordrar</h2>
                        <table id="tableLowerSubDivBoxViewViewAllOrdersForCustomer">
                            <thead>
	                            <th>OrderID</th>
	                            <th></th>
	                            <th></th>
                            </thead>
                            <tbody>
                            <!--                             <tr>
                                <td>0000</td>
                                <td><input type="button" value="Granska" onclick="upperSubDivBoxViewAlternativesInputOrderIDFromViewAllOrdersForCustomer()"></td>
                                <td><input type="button" value="Radera"></td>
                            </tr>
                            <tr>
                                <td>0000</td>
                                <td><input type="button" value="Granska" onclick="upperSubDivBoxViewAlternativesInputOrderIDFromViewAllOrdersForCustomer()"></td>
                                <td><input type="button" value="Radera"></td>
                            </tr> -->
                            </tbody>  
                        </table>
                    </div>
                    <div id="lowerSubDivBoxViewAlternativesViewSpecificOrder">
                        <input id="btnLowerSubDivBoxViewAlternativesViewSpecificOrderToAllOrders" type="button" value="Tillbaka" onclick="upperSubDivBoxViewAlternativesBackToViewAllOrders()">
                        <input id="btnLowerSubDivBoxViewAlternativesViewSpecificOrderToAllOrdersForCustomer"type="button" value="Tillbaka" onclick="upperSubDivBoxViewAlternativesBackToViewAllOrdersForCustomer()">

                        <h2>Visar specifik order</h2>
                        <table id="tableLowerSubDivBoxViewAlternativesViewSpecificOrder">
                            <thead>
	                            <th>ProduktID</th>
	                            <th>Produktnamn</th>
	                            <th>Produktbeskrivning</th>
	                            <th>Kvantitet</th>
                            </thead>
                            <tbody>
                            	<!-- <tr>
                                <td>0000</td>
                                <td>Namn</td>
                                <td>Beskrivning</td>
                                <td>Kvantitet</td>
                            </tr>
                            <tr>
                                <td>0000</td>
                                <td>Namn</td>
                                <td>Beskrivning</td>
                                <td>Kvantitet</td>
                            </tr> -->
                            </tbody>                           
                        </table>
                    </div>
                </div>
            </div>  
        </div>      
    </section>
    <footer>
        <p>Carl Sandelius - Grupp 19 &copy; 2020 </p>
    </footer>
</body>
</html>