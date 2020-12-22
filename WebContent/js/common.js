function getParameter(name) {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),results = regex.exec(location.search);

	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function getParameters() {
	name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),results = regex.exec(location.search);

	return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));

// "&size=10&key=nickname&searchOption=contain&rule=7&value=a"
}
