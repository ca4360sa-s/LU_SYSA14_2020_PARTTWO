/**
 * 
 */
var city = "ingen stad hittades";
var long; 
var lat; 
var timeStrSunrise;
var timeStrSunset; 
var weather; 
var degree;

$(document).ready(function(){
	$.ajax({
		method: "GET",
		url: "http://api.ipstack.com/check?access_key=484528789261d639018993060dd1dee6",
		error: ajaxLocationReturn_Error,
		success: ajaxLocationReturn_Success
	})		
	function ajaxLocationReturn_Success(result, status, xhr){
		city = result.city; 
		long = result.longitude;
		lat = result.latitude; 
		console.log("long: "+long);
		console.log("lat: "+lat);
		$.ajax({
			// Key: ae7c3c390843a25d44f0e1a4393e78db'
			method:"GET",
			url: "http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+long+"&units=metric"+ "&APPID=ae7c3c390843a25d44f0e1a4393e78db",
			error: ajaxWeatherReturn_Error,
			success: ajaxWeatherReturn_Success 	
		})
	}
	function ajaxLocationReturn_Error(result, status, xhr){
		console.log("Ajax-Location-Call:"+status);
	}
	function ajaxWeatherReturn_Success(result, status, xhr){
		var sunrise = result.sys.sunrise; 
		var sunset = result.sys.sunset; 
		var sunriseDate = new Date(sunrise*1000);
		var sunsetDate = new Date(sunset*1000); 
		timeStrSunrise = sunriseDate.toLocaleTimeString();
		timeStrSunset = sunsetDate.toLocaleTimeString(); 
		weather = result.weather[0].main;
		degree = result.main.temp+"\u2103";	
	}
	function ajaxWeatherReturn_Error(result, status, xhr){
		console.log("Ajax-Weather-Call:"+status);	
	}
});
window.onload = function (){
	$("#spanPaceIconInfo").text("Temperaturen i "+city+ " är "+degree+", solen går upp "+timeStrSunrise+" och ner "+timeStrSunset); 	

};




