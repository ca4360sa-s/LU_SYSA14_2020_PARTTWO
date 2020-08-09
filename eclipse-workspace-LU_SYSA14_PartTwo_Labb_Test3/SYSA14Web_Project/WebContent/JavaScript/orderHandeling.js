$(document).ready(function() {
    $("#mainSection").hide();
    $("#boxCreateOrderStepOne").hide();
    $("#boxCreateOrderStepTwo").hide();
    $("#boxCreateOrderStepThree").hide();
    $("#boxViewAlternatives").hide(); 
    //---
    $("#upperSubDivBoxViewAlternativesInputCustomerID").hide();
    $("#upperSubDivBoxViewAlternativesInputOrderID").hide(); 
    //---
    $("#lowerSubDivBoxViewAlternativesViewAllOrdersForCustomer").hide();
    $("#lowerSubDivBoxViewAlternativesViewSpecificOrder").hide(); 
    $("#lowerSubDivBoxViewAlternativesViewAllOrders").hide();
    $("#upperSubDivBoxViewAlternativesInner").hide();
    
    // --------------------------------------------------------------------------------------------
    // Feedback
    //orderCreated
    let searchParams = new URLSearchParams(window.location.search); 
    let param = searchParams.get("feedback"); 
    
    if(param=="orderCreated"){
		$("#orderFeedback").text("Ordern har skickats!"); 
		$("#orderFeedback").css("color", "green");
		setTimeout(function(){$("#orderFeedback").text("");},3000);
	
    };
    if(param=="orderNotCreated"){
		$("#orderFeedback").text("Ordern kunde inte skickas, försök igen!"); 
		$("#orderFeedback").css("color", "red");
		setTimeout(function(){$("#orderFeedback").text("");},3000);
    };
    if(param=="deleted"){
    	$("#orderFeedBack").text("Ordern har raderats!");
		console.log("Orderna har raderats korrekt"); 
		$("#orderFeedBack").css("color", "green"); 
		setTimeout(function(){$("#orderFeedback").text("");},3000);

    };
    if(param=="notDeleted"){
    	$("#orderFeedback").text("Ordern kunde inte raderas!"); 
		$("#orderFeedback").css("color", "red");
		setTimeout(function(){$("#orderFeedback").text("");},3000);
    };
    //---------------------------------------------------------------------------------------------
    // GetAllCustomers 
    $.post("/SYSA14Web_Project/ControllerServlet", {
		operation: "getAllCustomers"
	}, function(data, status, xhr){
		for (var i=0; i<data.length; i++){
	          var tempID = data[i].customerID.toString(); 
	          var tempName = data[i].firstName.toString()+" "+data[i].lastName.toString();  		          
	          var optionA = new Option(tempName, tempID);
	          var optionB = new Option(tempName, tempID); 
	          $("#listOfCustomers").append($(optionA)); 
	          $("#customerIDViewAlternatives ").append($(optionB));
		}	
	}, "json");	
    
    //GetAllProducts for displayProductTable
	$.post("/SYSA14Web_Project/ControllerServlet", {
		operation: "getAllProducts"
	}, function(data, status, xhr){
		for (var i=0; i<data.length; i++){
	          var tempProductID = data[i].productID; 
	          $("#displayProductTable").append("<tr><td>"+data[i].productName+"</td><td>"+data[i].productDescription+"</td><td><input id =\"selected"+tempProductID+"\" type=\"button\" value=\"Lägg till\" onclick=\"addProductToOrder("+tempProductID+")\"></td><td><input id =\"removed"+tempProductID+"\"type=\"button\" value=\"Ta bort\" onclick=\"removeProductFromOrder("+tempProductID+")\"></td></tr>");
	  
	          $("#removed"+tempProductID).hover(function(){
		         $(this).css({
		          "font-weight": "bold",
		          "color": "white",
		          "background-color": "red" 		        		         
		         });
	          }, function(){
	        		$(this).css({	
	  		           "font-weight": "normal",
	        			"color":"rgb(30 30 30)",
	        			"background-color": "white" 
	        		});
	          });
	      	$("#removed"+tempProductID).hide();
		}
	}, "json");	
	
	//
	
});

function addProductToOrder(tempProductID){	
	$("#selected"+tempProductID).css({"background-color": "green"  , "color":"white", "font-weight": "bold"});
	$("#selected"+tempProductID).hover(function(){
		$(this).css({
			"font-weight" :"bold",
			"color" : "white",
			"background-color": "green"
		});
	}, function(){
		$(this).css({
			"font-weight" :"bold",
			"color" : "white",
			"background-color":"green"
		});
	});
	$("#removed"+tempProductID).show();
    $.post("/SYSA14Web_Project/ControllerServlet", {
        operation: "getProduct",
        productID: tempProductID
    }, function(data, status, xhr){
    	var maxOrderQuantity = data.stockQuantity; 
        $("#displayProductQuantityTable").append("<tr id=\"tRow"+tempProductID+"\"><td>"+data.productID+"</td><td>"+data.productName+"</td><td><input name=\""+tempProductID+"\" type=\"number\" value=\"1\" min=\"1\" max=\""+maxOrderQuantity+"\" pattern=\"[0-9]\" required></td></tr>");
       }, "json");
	
}

function removeProductFromOrder(tempProductID){
	$("#selected"+tempProductID).css({"background-color": "white", "color":"rgb(30 30 30", "font-weight": "normal"});
	$("#selected"+tempProductID).hover(function(){
		$(this).css({
		"font-weight": "bold",
	  	"color": "white", 
	  	"background-color": "rgb(30 30 30)" }); 
	}, function(){
		$(this).css({
			"font-weight": "normal",
		  	"color": "rgb(30 30 30)", 
		  	"background-color": "white"
		});
	});

	$("#removed"+tempProductID).hide();
	$("#tRow"+tempProductID).remove();
}

// ----------------------------------------------------------------------

function displayBoxCreateOrderStepOne(){
    $("#mainSection").show();   
    $("#boxViewAlternatives").hide();  
    $("#boxCreateOrderStepTwo").hide();
    $("#boxCreateOrderStepThree").hide();
    $("#boxCreateOrderStepOne").show();
    const el = document.getElementById("boxCreateOrderStepOne");
    el.scrollIntoView(); 
}
function displayBoxCreateOrderStepTwo(){
	var tempProductList = $("#displayProductQuantityTable >tbody >tr").length;
	if(tempProductList>0){
		$("#mainSection").show();   
	    $("#boxViewAlternatives").hide();  
	    $("#boxCreateOrderStepOne").hide();
	    $("#boxCreateOrderStepThree").hide();
	    $("#boxCreateOrderStepTwo").show(); 
	    $("#displayProductQuantityTable tbody input[type='number']").keypress(function (evt) {
            evt.preventDefault();
        });
	} else {
		alert("Inga produkter har valts!\nVänligen ange önskade produkter för att kunna fortsätta."); 
	}

}

function displayBoxCreateOrderStepThree(){
    $("#mainSection").show();   
    $("#boxViewAlternatives").hide();  
    $("#boxCreateOrderStepOne").hide();
    $("#boxCreateOrderStepTwo").hide();
    $("#boxCreateOrderStepThree").show();
}

function displayBoxViewViewAlternatives(){
    $("#mainSection").show();
    $("#boxCreateOrderStepOne").hide();
    $("#boxCreateOrderStepThree").hide();
    $("#boxCreateOrderStepTwo").hide();
    $("#boxViewAlternatives").show();  
    const el = document.getElementById("boxViewAlternatives");
    el.scrollIntoView(); 
}
//---------------------------------------------------------------

function upperSubDivBoxViewAlternativesViewAllOrders(){
    $("#upperSubDivBoxViewAlternativesInputOrderID").hide();
    $("#upperSubDivBoxViewAlternativesInputCustomerID").hide(); 
    //---
    $("#lowerSubDivBoxViewAlternativesViewAllOrdersForCustomer").hide();
    $("#lowerSubDivBoxViewAlternativesViewSpecificOrder").hide(); 
    $("#lowerSubDivBoxViewAlternativesViewAllOrders").show();

    //-------
    // GetAllOrders
    $("#tableLowerSubDivBoxViewAlternativesViewAllOrders tbody").empty();
    $.post("/SYSA14Web_Project/ControllerServlet", {
		operation: "getAllOrders"
	}, function(data, status, xhr){
		for (var i=0; i<data.length; i++){
	          var tempOrderID = data[i].orderID.toString(); 
	          var tempCustomerID = data[i].privateCustomerID.toString(); 		          
	          $("#tableLowerSubDivBoxViewAlternativesViewAllOrders").append("<tr><td>"+tempOrderID+"</td><td>"+tempCustomerID+"</td><td><input type=\"button\" value=\"Granska\" onclick=\"upperSubDivBoxViewAlternativesInputOrderIDFromViewAllOrders("+tempOrderID+")\"></td><td><input type=\"button\" value=\"Radera\" onclick=\"deleteOrder("+tempOrderID+")\"></td></tr>");	    	  
		}	
	}, "json");	
}
function deleteOrder(orderID){
	 $.post("/SYSA14Web_Project/ControllerServlet", {
			operation: "deleteOrder",
			orderID: orderID
		}, function(data, status, xhr){
			if(data=="deleted"){	
				/*
			    let searchParams = new URLSearchParams(window.location.search); 
			    let param = searchParams.get("feedback"); 
				*/
				//URLSearchParams.set("feedback", "deleted");
				//location.reload(); 
				
				
			    $("#mainSection").hide();
			    $("#boxCreateOrderStepOne").hide();
			    $("#boxCreateOrderStepTwo").hide();
			    $("#boxCreateOrderStepThree").hide();
			    $("#boxViewAlternatives").hide(); 
			    //---
			    $("#upperSubDivBoxViewAlternativesInputCustomerID").hide();
			    $("#upperSubDivBoxViewAlternativesInputOrderID").hide(); 
			    //---
			    $("#lowerSubDivBoxViewAlternativesViewAllOrdersForCustomer").hide();
			    $("#lowerSubDivBoxViewAlternativesViewSpecificOrder").hide(); 
			    $("#lowerSubDivBoxViewAlternativesViewAllOrders").hide();
			    $("#upperSubDivBoxViewAlternativesInner").hide();
			    
				$("#orderFeedback").text("Ordern har raderats!"); 
				console.log("Ordern har raderars korrekt!")
				$("#orderFeedback").css("color", "green");			
				setTimeout(function(){$("#orderFeedback").text("");},3000);
				
			} else if(data=="notDeleted"){	
				location.reload().done(function(){
					
				    $("#mainSection").hide();
				    $("#boxCreateOrderStepOne").hide();
				    $("#boxCreateOrderStepTwo").hide();
				    $("#boxCreateOrderStepThree").hide();
				    $("#boxViewAlternatives").hide(); 
				    //---
				    $("#upperSubDivBoxViewAlternativesInputCustomerID").hide();
				    $("#upperSubDivBoxViewAlternativesInputOrderID").hide(); 
				    //---
				    $("#lowerSubDivBoxViewAlternativesViewAllOrdersForCustomer").hide();
				    $("#lowerSubDivBoxViewAlternativesViewSpecificOrder").hide(); 
				    $("#lowerSubDivBoxViewAlternativesViewAllOrders").hide();
				    $("#upperSubDivBoxViewAlternativesInner").hide();
				    
					$("#orderFeedback").text("Ordern kunde inte raderas!"); 
					$("#orderFeedback").css("color", "red");
					setTimeout(function(){$("#orderFeedback").text("");},3000);
				}); 	 

			}
		}, "json");		
}

function upperSubDivBoxViewAlternativesInputCustomerID(){
    $("#upperSubDivBoxViewAlternativesInputOrderID").hide();
    $("#upperSubDivBoxViewAlternativesInputCustomerID").show(); 
     //---
    $("#lowerSubDivBoxViewAlternativesViewSpecificOrder").hide(); 
    $("#lowerSubDivBoxViewAlternativesViewAllOrders").hide();
    $("#lowerSubDivBoxViewAlternativesViewAllOrdersForCustomer").hide();

}

function viewCustomerOrders(){
	  $("#tableLowerSubDivBoxViewViewAllOrdersForCustomer tbody").empty();
	  var tempCustomerID = $("#customerIDViewAlternatives option:selected").val(); 
	  console.log(tempCustomerID); 
	    $.post("/SYSA14Web_Project/ControllerServlet", {
			operation: "getAllOrdersForCustomer",
			customerID: tempCustomerID
		}, function(data, status, xhr){
			for (var i=0; i<data.length; i++){
		          var tempOrderID = data[i].orderID.toString(); 
		          var tempCallFrom = "viewAllOrdersForCustomer";
		          $("#tableLowerSubDivBoxViewViewAllOrdersForCustomer").append("<tr><td>"+tempOrderID+"</td><td><input type=\"button\" value=\"Granska\" onclick=\"upperSubDivBoxViewAlternativesInputOrderIDFromViewAllOrdersForCustomer("+tempOrderID+")\"></td><td><input type=\"button\" value=\"Radera\" onclick=\"deleteOrder("+tempOrderID+")\"></td></tr>");	    	  
			}	
		}, "json");	
	$("#lowerSubDivBoxViewAlternativesViewAllOrdersForCustomer").show(); 
}
function upperSubDivBoxViewAlternativesInputOrderIDFromViewAllOrders(orderID) {
    $("#upperSubDivBoxViewAlternativesInputCustomerID").hide(); 
    $("#upperSubDivBoxViewAlternativesInputOrderID").show(); 
     //---
    $("#lowerSubDivBoxViewAlternativesViewAllOrders").hide();
    $("#lowerSubDivBoxViewAlternativesViewAllOrdersForCustomer").hide();
    $("#upperSubDivBoxViewAlternatives").hide();
    $("#btnLowerSubDivBoxViewAlternativesViewSpecificOrderToAllOrdersForCustomer").hide();
    //---
    $("#btnLowerSubDivBoxViewAlternativesViewSpecificOrderToAllOrders").show();
    $("#lowerSubDivBoxViewAlternativesViewSpecificOrder").show(); 
    //-----------------------------------------------------------------------------------
    // tableLowerSubDivBoxViewAlternativesViewSpecificOrder
	$("#tableLowerSubDivBoxViewAlternativesViewSpecificOrder tbody").empty();
    $.post("/SYSA14Web_Project/ControllerServlet", {
		operation: "getSpecificOrder",
		orderID: orderID	
	}, function(data, status, xhr){
		for (var i=0; i<data.length; i++){
	          var tempProductID = data[i].productID.toString(); 
	          var tempProductName = data[i].productName;  	
	          var tempProductDescription = data[i].productDescription; 
	          var tempQuantity = data[i].quantity; 
	          $("#tableLowerSubDivBoxViewAlternativesViewSpecificOrder").append("<tr><td>"+tempProductID+"</td><td>"+tempProductName+"</td><td>"+tempProductDescription+"</td><td>"+tempQuantity+"</td></tr>");	    	  
		}	
	}, "json");	
    
}
function upperSubDivBoxViewAlternativesInputOrderIDFromViewAllOrdersForCustomer(orderID) {
    $("#upperSubDivBoxViewAlternativesInputCustomerID").hide(); 
    $("#upperSubDivBoxViewAlternativesInputOrderID").show(); 
     //---
    $("#lowerSubDivBoxViewAlternativesViewAllOrders").hide();
    $("#lowerSubDivBoxViewAlternativesViewAllOrdersForCustomer").hide();
    $("#upperSubDivBoxViewAlternatives").hide();
    $("#btnLowerSubDivBoxViewAlternativesViewSpecificOrderToAllOrders").hide();
    //--- 
    $("#btnLowerSubDivBoxViewAlternativesViewSpecificOrderToAllOrdersForCustomer").show();
    $("#lowerSubDivBoxViewAlternativesViewSpecificOrder").show(); 
    //------------------------------------------------------------------------------------
	$("#tableLowerSubDivBoxViewAlternativesViewSpecificOrder tbody").empty();
    $.post("/SYSA14Web_Project/ControllerServlet", {
		operation: "getSpecificOrder",
		orderID: orderID	
	}, function(data, status, xhr){
		for (var i=0; i<data.length; i++){
	          var tempProductID = data[i].productID.toString(); 
	          var tempProductName = data[i].productName;  	
	          var tempProductDescription = data[i].productDescription; 
	          var tempQuantity = data[i].quantity; 
	          $("#tableLowerSubDivBoxViewAlternativesViewSpecificOrder").append("<tr><td>"+tempProductID+"</td><td>"+tempProductName+"</td><td>"+tempProductDescription+"</td><td>"+tempQuantity+"</td></tr>");	    	  
		}	
	}, "json");	
}
function upperSubDivBoxViewAlternativesBackToViewAllOrders(){
	$("#tableLowerSubDivBoxViewAlternativesViewSpecificOrder tbody").empty(); 
    $("#lowerSubDivBoxViewAlternativesViewSpecificOrder").hide(); 
    $("#upperSubDivBoxViewAlternatives").show(); 
    $("#lowerSubDivBoxViewAlternativesViewAllOrders").show();
}
 function upperSubDivBoxViewAlternativesBackToViewAllOrdersForCustomer(){
    $("#lowerSubDivBoxViewAlternativesViewSpecificOrder").hide(); 
    $("#upperSubDivBoxViewAlternatives").show(); 
    $("#lowerSubDivBoxViewAlternativesViewAllOrdersForCustomer").show();
}
