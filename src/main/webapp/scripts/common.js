/**
 * Created by hp21 on 2014.01.16..
 */

function keyUp() {
    var myText = document.getElementById("name_id");

    var myRequest = createRequest();

    if (request == null) {
        alert("Unable to create request");
        return;
    }

//    var url = "/base/helloforname?name=" + myText.value;
    var url = "/base/" + myText.value;
    request.open("GET", url, true);
    request.onreadystatechange = displayDetails;
    request.send(null);

}

function createRequest() {
    try {
        request = new XMLHttpRequest();
    } catch (tryMS) {
        try {
            request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (otherMS) {
            try {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (failed) {
                request = null;
            }
        }
    }
    return request;
}

function displayDetails() {
    if (request.readyState == 4) {
        if (request.status == 200) {
            var detail = document.getElementById("result");
            detail.value = "Hello " + request.responseText;
        }
    }
}