var incomingRequests = function() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', "/getLatestAlert", true);
    xhr.send();
    xhr.addEventListener("readystatechange", processRequest, false);

    function processRequest(e) {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var response = xhr.responseText;
            renderResults(response);
        }
    }
}

var renderResults = function(response) {
    if(response != "") {
        var parentList = document.getElementById("parent-list");
        var solrAlert = document.getElementById("solr-alert"), clone = solrAlert.cloneNode(true);
        clone.id = "solr-child-alert";
        clone.innerHTML = response;

        if(response.includes("ADDED:")){
            clone.className += " alert alert-success ";
        } else if(response.includes("DELETED:")){
            clone.className += " alert alert-danger ";
        }
        clone.style.display = "";
        parentList.appendChild(clone);
        solrAlert.style.display = "none";
    }
}

incomingRequests();
setInterval(incomingRequests, 500);