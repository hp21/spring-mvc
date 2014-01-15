<html>

<head>
    <script>
        function keyUp() {
            var myText = document.getElementById("name_id");
            //var label = document.getElementById("result");
            //label.value = "Hello " + myText.value;

            var myRequest = createRequest();
            if (request == null) {
                alert("Unable to create request");
                return;
            }

            var url = "/base/helloforname?name="+myText.value;
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
                    detail = document.getElementById("result");
                    detail.value = "Hello " + request.responseText;
                }
            }
        }

    </script>
</head>

<body>
qqrq
<h1>${message}</h1>

<input type="text" id="name_id" onkeyup="keyUp()"/>

<input type="text" id="result" disabled="disabled" style='outline:none'/>

</body>
</html>