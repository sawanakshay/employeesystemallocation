var flag;
// let isLoggedIn = false;
// var basePath = "http://3.17.73.55:8080/"; //server
var apiUrl = "http://localhost:8082/";
// var basePath = "file:///C:/Users/Reaper/Documents/Projects/inventorymanagementweb/"; local

var common = {

		
		dateFormat: function(name) {
	        var date = new Date();
	        var month = '' + date.getMonth() + 1;
	        var day = '' + date.getDate();
	        var year = '' + date.getFullYear();
	        if (month.length < 2) 
	            month = '0' + month;
	        if (day.length < 2) 
	            day = '0' + day;
	        return name+"_"+day+"_"+month+"_"+year;
	    },

		ajaxGet : function(url, callback) {
		
			$.ajax({
				url			: 	url,
				type		: 	"get",
				// contentType	: 	"application/json",
				beforeSend: function(request) {
    				 request.setRequestHeader("Access-Control-Allow-Origin", "*");
    			// 	 request.setRequestHeader("Authorization", localStorage.getItem("token"));
  				},
				dataType	: 	"json",
				success		: 	function(result, status, xhr) {
									callback(xhr);
									console.log(status);
									console.log(xhr);
								},
				error		: 	function(xhr, status) {
									callback(xhr);
									if(xhr.status == 406) {
										localStorage.clear();
	            						window.location.href = basePath+"index.html";
									}
								}
			});
		},
}

$(document).ready(function() {
	$(document.body).bind('keyup click change',common.updateSession); 
});

// common.isLoggedIn();

var opts = {
		lines: 12 // The number of lines to draw
		, length: 3 // The length of each line
		, width: 2 // The line thickness
		, radius: 6 // The radius of the inner circle
		, scale: 1 // Scales overall size of the spinner
		, corners: 1 // Corner roundness (0..1)
		, color: '#ffffff' // #rgb or #rrggbb or array of colors
		, opacity: 0.2 // Opacity of the lines
		, rotate: 0 // The rotation offset
		, direction: 1 // 1: clockwise, -1: counterclockwise
		, speed: 2.0 // Rounds per second
		, trail: 36 // Afterglow percentage
		, fps: 20 // Frames per second when using setTimeout() as a fallback for CSS
		, zIndex: 2e9 // The z-index (defaults to 2000000000)
		, className: 'spinner' // The CSS class to assign to the spinner
		, top: '50%' // Top position relative to parent
		, left: '50%' // Left position relative to parent
		, shadow: false // Whether to render a shadow
		, hwaccel: false // Whether to use hardware acceleration
		, position: 'absolute' // Element positioning
	};
var target = document.getElementById('loader');
var spinner = new Spinner(opts).spin(target);

function changeIconSize() {
	var element = $("#auiSidebar").attr("aria-expanded");
	if(element == undefined || element == "true"){
		$(".cms-icon").attr("height","25");
		$(".cms-icon").attr("width","25");
		$("#navList").removeClass("ml-cms-280");
		$("#navList").addClass("ml-cms-56");
	}else{
		$(".cms-icon").attr("height","");
		$(".cms-icon").attr("width","");
		$("#navList").addClass("ml-cms-280");
		$("#navList").removeClass("ml-cms-56");
	}
}

var showFlag = function(type,title,body) {
	if(flag!=null)
		flag.close();
	AJS.$(document).ready(function() {
	    flag = AJS.flag({
			type: type,
			body: body,
			title:title,
			close:'auto'
	    });
	});
	return flag;
}
