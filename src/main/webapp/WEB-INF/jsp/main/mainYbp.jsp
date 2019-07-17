<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>

<head>
    <meta charset="utf-8" />
    <title>Donuts, baby!</title>
    <meta name="viewport" content="width=device-width">
    <style>
    .container {
        width: 450px;
        margin: 50px auto 0 auto;
        text-align: center;
    }

    .gauge {
        width: 450px;
        height: 450px;
    }

    a:link.button,
    a:active.button,
    a:visited.button,
    a:hover.button {
        margin: 30px 5px 0 2px;
        padding: 7px 13px;
    }
    </style>
</head>

<body>
    <div class="container">
        <div id="g1" class="gauge"></div>
        <a href="#" id="g1_refresh" class="button grey">Random Refresh</a>
        <br />
        <a href="#" id="g1_setmax100" class="button grey">Set Max 100</a>
        <a href="#" id="g1_setmax200" class="button grey">Set Max 200</a>
        <a href="#" id="g1_setmax400" class="button grey">Set Max 400</a>
    </div>
    <script src="oa/justgage-1.2.2/raphael-2.1.4.min.js"></script>
    <script src="oa/justgage-1.2.2/justgage.js"></script>
    <script>
    document.addEventListener("DOMContentLoaded", function(event) {

        var g1 = new JustGage({
            id: "g1",
            title: "Max is 100.",
            value: 50,
            min: 0,
            max: 100,
            decimals: 0,
            gaugeWidthScale: 0.6
        });

        document.getElementById('g1_refresh').addEventListener('click', function() {
            g1.refresh(getRandomInt(0, 100));
        });

        document.getElementById('g1_setmax100').addEventListener('click', function() {
            g1.refresh(g1.originalValue, 100);
            g1.txtTitle.attr({
                "text": "Max is 100."
            });
        });

        document.getElementById('g1_setmax200').addEventListener('click', function() {
            g1.refresh(g1.originalValue, 200);
            g1.txtTitle.attr({
                "text": "Whoops, max jumped to 200."
            });
            return false;
        });

        document.getElementById('g1_setmax400').addEventListener('click', function() {
            g1.refresh(g1.originalValue, 400);
            g1.txtTitle.attr({
                "text": "Blimey, max blasted to 400!"
            });
            return false;
        });

    });
    </script>
</body>

</html>
