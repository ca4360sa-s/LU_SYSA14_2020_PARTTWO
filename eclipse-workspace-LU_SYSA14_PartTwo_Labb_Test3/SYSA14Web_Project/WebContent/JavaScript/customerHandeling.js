$(document).ready(function(){

	$("#customerFeedback").text("");  
	
	//---------------------------------------------------------------------------------------------------------------------
  
	let searchParams = new URLSearchParams(window.location.search); 
    let param = searchParams.get("feedback"); 
    
    if(param=="customerUpdated"){
			$("#customerFeedback").text("Kundens information har uppdaterats!"); 
			$("#customerFeedback").css("color", "green");
			setTimeout(function(){$("#customerFeedback").text("");},3000);
	
    };
    if(param=="customerNotUpdated"){
		$("#customerFeedback").text("Uppdateringen av kundens information misslyckades!"); 
		$("#customerFeedback").css("color", "red");
		setTimeout(function(){$("#customerFeedback").text("");},3000);
    };
	if(param=="customerCreated"){
			$("#customerFeedback").text("Kundens har lagts till!"); 
			$("#customerFeedback").css("color", "green");
			setTimeout(function(){$("#customerFeedback").text("");},3000);
	
    };
    if(param=="customerNotCreated"){
		$("#customerFeedback").text("Kunden kunde inte läggas till!"); 
		$("#customerFeedback").css("color", "red");
		setTimeout(function(){$("#customerFeedback").text("");},3000);
    };
	
	//---------------------------------------------------------------------------------------------------------------------

	$.post("/SYSA14Web_Project/ControllerServlet", {
		operation: "getAllCustomers"
	}, function(data, status, xhr){
		for (var i=0; i<data.length; i++){
	          var tempUpdate = ("./customer_Update.jsp?id="+data[i].customerID); 
	          var tempDeleteID = data[i].customerID; 
	          $("#customerTableTBoody").append("<tr><td>"+data[i].customerID+"</td><td>"+data[i].firstName+"</td><td>"+data[i].lastName+"</td><td>"+data[i].address+"</td><td><a href=\""+tempUpdate+"\"><input type=\"button\" value=\"Uppdatera\"></a></td><td><input type=\"button\" value=\"Delete\" onclick=\"deleteCustomer("+tempDeleteID+")\"></td></tr>");
	   	}
	}, "json");	
	
}); 

function deleteCustomer(tempDeleteID){
	$.post("/SYSA14Web_Project/ControllerServlet", {
		operation: "deleteCustomer",
		customerID: tempDeleteID
	}, function(data, status, xhr){
		if(data=="deleted"){	
			$("#customerFeedback").text("Kunden har raderats!"); 
			$("#customerFeedback").css("color", "green");
			setTimeout(function(){$("#customerFeedback").text("");},3000);
		} else if(data=="NotDeleted"){	
			$("#customerFeedback").text("Kunden kunde inte raderas!"); 
			$("#customerFeedback").css("color", "red");
			setTimeout(function(){$("#customerFeedback").text("");},3000);
		}
	}, "json");	
	location.reload(); 
	

}; 