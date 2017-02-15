<!DOCTYPE html>
<html>
<head>
    <title>Hello WebSocket</title>
    <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/main.css" rel="stylesheet">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>
    <script src="/app.js"></script>
</head>
<body>
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being
    enabled. Please enable
    Javascript and reload this page!</h2></noscript>
    <div class="row">
        <div class="col-md-12">
          <div class="top_menu" style="max-width: 200px ">
<div class="buttons"><div class="button close"></div>
<div class="button minimize"></div><div class="button maximize">
</div></div><div class="title">Chat</div></div><ul class="messages">
</ul><div class="bottom_wrapper clearfix"><div class="message_input_wrapper">
<input class="message_input" placeholder="Type your message here..." /></div>
<div class="send_message"><div class="icon"></div><div class="text">Send</div>
</div></div><div class="message_template"><li class="message">
<div class="avatar"></div><div class="text_wrapper"><div class="text">
</div></div></li>
</div>
        </div>
    </div>
   
</body>
</html>