<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8" />
    <title>Pointer</title>
    <meta name="viewport" content="width=device-width">
    <style>
    .wrapper {
      position: relative;
      width: 640px;
      height: 480px;
      margin: 50px auto 0 auto;
      padding-bottom: 30px;
      border: 1px solid #ccc;
      border-radius: 3px;
      clear: both;
    }

    .box {
      float: left;
      width: 50%;
      height: 50%;
      box-sizing: border-box;
    }

    .container {
      width: 450px;
      margin: 0 auto;
      text-align: center;
    }

    .gauge {
      width: 320px;
      height: 240px;
    }

    button {
      margin: 30px 5px 0 2px;
      padding: 16px 40px;
      border-radius: 5px;
      font-size: 18px;
      border: none;
      background: #34aadc;
      color: white;
      cursor: pointer;
    }
    </style>
  </head>

  <body>
    <div class="wrapper">
      <div class="box">
        <div id="g1" class="gauge"></div>
      </div>
      <div class="box">
        <div id="g2" class="gauge"></div>
      </div>
      <div class="box">
        <div id="g3" class="gauge"></div>
      </div>
      <div class="box">
        <div id="g4" class="gauge"></div>
      </div>
    </div>
    <div class="container">
      <button type="button" id="gauge_refresh">Refresh Gauges</button>
    </div>
    <script src="/js/raphael-2.1.4.min.js"></script>
    <script src="/js/justgage.js"></script>
    <script>
    document.addEventListener("DOMContentLoaded", function(event) {

      var g1 = new JustGage({
        id: 'g1',
        value: 65,
        min: 0,
        max: 100,
        symbol: '%',
        pointer: true,
        gaugeWidthScale: 0.6,
        customSectors: [{
          color: '#ff0000',
          lo: 50,
          hi: 100
        }, {
          color: '#00ff00',
          lo: 0,
          hi: 50
        }],
        counter: true
      });

      var g2 = new JustGage({
        id: 'g2',
        value: 45,
        min: 0,
        max: 100,
        symbol: '%',
        pointer: true,
        pointerOptions: {
          toplength: -15,
          bottomlength: 10,
          bottomwidth: 12,
          color: '#8e8e93',
          stroke: '#ffffff',
          stroke_width: 3,
          stroke_linecap: 'round'
        },
        gaugeWidthScale: 0.6,
        counter: true
      });

      var g3 = new JustGage({
        id: 'g3',
        value: 40,
        min: 0,
        max: 100,
        symbol: '%',
        donut: true,
        pointer: true,
        gaugeWidthScale: 0.4,
        pointerOptions: {
          toplength: 10,
          bottomlength: 10,
          bottomwidth: 8,
          color: '#000'
        },
        customSectors: [{
          color: "#ff0000",
          lo: 50,
          hi: 100
        }, {
          color: "#00ff00",
          lo: 0,
          hi: 50
        }],
        counter: true
      });

      var g4 = new JustGage({
        id: 'g4',
        value: 70,
        min: 0,
        max: 100,
        symbol: '%',
        pointer: true,
        pointerOptions: {
          toplength: 8,
          bottomlength: -20,
          bottomwidth: 6,
          color: '#8e8e93'
        },
        gaugeWidthScale: 0.1,
        counter: true
      });

      document.getElementById('gauge_refresh').addEventListener('click', function() {
        g1.refresh(getRandomInt(0, 100));
        g2.refresh(getRandomInt(0, 100));
        g3.refresh(getRandomInt(0, 100));
        g4.refresh(getRandomInt(0, 100));
      });
    });
    </script>
  </body>

</html>
