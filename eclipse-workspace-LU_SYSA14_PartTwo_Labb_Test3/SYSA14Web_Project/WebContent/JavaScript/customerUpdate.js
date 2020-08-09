/**
 * 
 */
$(document).ready(function (){
    let searchParams = new URLSearchParams(window.location.search); 
    let param = searchParams.get("id"); 
    if(param){
        $.post("/SYSA14Web_Project/ControllerServlet", {
            operation: "getCustomer",
            customerID: param
        }, function(data, status, xhr){
        	$("#customerID").val(param); 
            $("#firstName").attr("placeholder", data.firstName);
            $("#lastName").attr("placeholder", data.lastName);
            $("#address").attr("placeholder", data.address);    
        }, "json");
    }
}); 

function checkContent(){ 
    var firstName =  $("#firstName").val();
    var lastName  = $("#lastName").val();
    var address = $("#address").val(); 
    if(firstName || lastName || address){
    	return true; 
    } else {
    	alert("Ingen ny information har angets"); 
    	return false;
    }
}