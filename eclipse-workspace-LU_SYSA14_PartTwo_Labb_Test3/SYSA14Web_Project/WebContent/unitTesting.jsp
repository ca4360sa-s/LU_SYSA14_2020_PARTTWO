<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./CSS/styleUnitTesting.css">

</head>
 <header>
        <div class = "container">
            <nav>
                <ul>
                    <li> <a href="./index.jsp">Hem</a></li>
                    <li><a href="./order_Handeling.jsp">Orderhantering</a></li>
                    <li><a href="./product_Handeling.jsp">Produkthantering</a></li>
                    <li><a href="./customer_Handling.jsp">Kundhantering</a></li>
                    <li class="current"><a href="./unitTesting.jsp">Testning</a></li>   
                    <li><a href="./about.jsp">Om</a></li>                                                                             
                </ul>
            </nav>
        </div>
    </header>
<body>
<section id="mainSection">
	<h2>JUnitEE testning av fasaden</h2>
	<div>
		<form action="TestServlet" method="get">
			<select name="suite">
				<option value="sysa14.junit.carl.FacadeProductBeanTest">Test av fasadens produkthantering</option>
				<option value="sysa14.junit.carl.FacadePrivateCustomerBeanTest">Test av fasadens kundhantering</option>
				<option value="sysa14.junit.carl.FacadeOrdersBeanTest">Test av fasadens orderhantering</option>
			</select>
			<br>
			<input type="submit" value="Kör testet"></input>
			
		</form>
	</div>
</section>
<footer>
	<p>Carl Sandelius - Grupp 19 &copy; 2020 </p>
</footer>
</body>
</html>