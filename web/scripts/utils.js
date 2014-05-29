// Some useful function - Paolo Galeone

// Cookie utils
var createCookie = function createCookie(name,value,days) {
	var expires = "";
	if (days) {
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		expires = "; expires="+date.toGMTString();
	}
	document.cookie = name+"="+value+expires+"; path=/";
};

var readCookie = function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0) === ' ') {
			c = c.substring(1,c.length);
		}
		if (c.indexOf(nameEQ) === 0) {
			return c.substring(nameEQ.length,c.length);
		}
	}
	return null;
};

var eraseCookie = function eraseCookie(name) {
	createCookie(name,"",-1);
};

// Add proxy to getElementById
document._oldGetElementById = document.getElementById;
document.getElementById = function(id) {
	return document._oldGetElementById ? document._oldGetElementById(id) : document.all[id];
};