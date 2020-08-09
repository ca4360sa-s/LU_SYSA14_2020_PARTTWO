$(document).ready(function (){
	
	let searchParams = new URLSearchParams(window.location.search); 
    let param = searchParams.get("feedback"); 
    
    if(param=="productUpdated"){
			$("#customerFeedback").text("Produktens information har uppdaterats!"); 
			$("#customerFeedback").css("color", "green");
			setTimeout(function(){$("#customerFeedback").text("");},3000);
	
    };
    if(param=="productNotUpdated"){
		$("#customerFeedback").text("Uppdateringen av produktens information misslyckades!"); 
		$("#customerFeedback").css("color", "red");
		setTimeout(function(){$("#customerFeedback").text("");},3000);
    };
	if(param=="productCreated"){
			$("#customerFeedback").text("Produkten har lagts till!"); 
			$("#customerFeedback").css("color", "green");
			setTimeout(function(){$("#customerFeedback").text("");},3000);
	
    };
    if(param=="productNotCreated"){
		$("#customerFeedback").text("Produkten kunde inte läggas till!"); 
		$("#customerFeedback").css("color", "red");
		setTimeout(function(){$("#customerFeedback").text("");},3000);
    };
    
    //-------------------------------------------------------------------
    
	$.post("/SYSA14Web_Project/ControllerServlet", {
		operation: "getAllProducts"
	}, function(data, status, xhr){
		for (var i=0; i<data.length; i++){
	          var tempUpdate = ("./product_Update.jsp?id="+data[i].productID); 
	          var tempDeleteID = data[i].productID; 
	          $("#productTableTBoody").append("<tr><td>"+data[i].productID+"</td><td>"+data[i].productName+"</td><td>"+data[i].productDescription+"</td><td>"+data[i].stockQuantity+"</td><td><a href=\""+tempUpdate+"\"><input type=\"button\" value=\"Uppdatera\"></a></td><td><input type=\"button\" value=\"Delete\" onclick=\"deleteProduct("+tempDeleteID+")\"></td></tr>");
	   	}
	}, "json");	
    
});

//-------------------------------------------------------------------------



function deleteProduct(tempDeleteID){
	$.post("/SYSA14Web_Project/ControllerServlet", {
		operation: "deleteProduct",
		productID: tempDeleteID
	}, function(data, status, xhr){
		if(data=="deleted"){	
			$("#productFeedback").text("Produkten har raderats!"); 
			$("#productFeedback").css("color", "green");
			setTimeout(function(){$("#productFeedback").text("");},3000);
		} else if(data=="notDeleted"){	
			$("#productFeedback").text("Produkten kunde inte raderas!"); 
			$("#productFeedback").css("color", "red");
			setTimeout(function(){$("#productFeedback").text("");},3000);
		}
	}, "json");	
	location.reload(); 
	

}; 
