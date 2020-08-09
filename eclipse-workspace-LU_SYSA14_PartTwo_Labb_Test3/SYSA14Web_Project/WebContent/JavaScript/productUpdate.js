/**
 * 
 */
$(document).ready(function (){
    let searchParams = new URLSearchParams(window.location.search); 
    let param = searchParams.get("id"); 
    if(param){
        $.post("/SYSA14Web_Project/ControllerServlet", {
            operation: "getProduct",
            productID: param
        }, function(data, status, xhr){
        	$("#productID").val(param); 
            $("#productName").attr("placeholder", data.productName);
            $("#productDescription").attr("placeholder", data.productDescription);
            $("#stockQuantity").attr("placeholder", data.stockQuantity);    
        }, "json");
    }
}); 

function checkContent(){
	var productName =  $("#productName").val();
    var productDescription  = $("#productDescription").val();
    var stockQuantity = $("#stockQuantity").val(); 
    if(productName || productDescription || stockQuantity){
    	return true; 
    } else {
    	alert("Ingen ny information har angets"); 
    	return false;
    }
};