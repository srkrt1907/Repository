var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}
getAllMessage();
function connect() {
    var socket = new SockJS('../fb/hello');
    stompClient = Stomp.over(socket);
   
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        
        var headers = frame.headers;
    	var user = headers['user-name'];
    	console.log(user);
        stompClient.subscribe('/fb/topic/greetings', function (greeting) {
        	console.log(greeting);
        	
        	var array = greeting.body.split(',');        	 
        	var repID = $("#anasayfaRepID").val();
        	if(array[1] != repID)
        		return;
        	
        	if(array[5] == "yeni")
        		{
        		var deneme = false;
            	$('#mesajistekleri').each(function(i, items_list){
                    var myText = "";
                                
                    $(items_list).find('li').each(function(j, li){
                        var adi = $(li).attr('data-sender');
                        
                        if(adi == array[2])
                        	{
                        		deneme = true;
                        	}                  
                    });
                });
            	
            	if(!deneme)
            		{
            			$('#mesajistekleri').append("<li class='istek' data-sender="+array[2]+" data-rep="+array[1]+" style='font-size: 16px;margin-top:5px ; color: red'>"+array[4]+" kişisinden gelen mesaj konusmaya baslamak için tıklayınız.</li>");
            		}
            		return;          	
        		}
        	
        	var deneme = false;
        	$('.people').each(function(i, items_list){
                var myText = "";
                            
                $(items_list).find('li').each(function(j, li){
                    var adi = $(li).attr('data-chat');
                    
                    if(adi == array[2])
                    	{
                    		deneme = true;
                    	}                  
                });
            });
        	
        	if(!deneme)
        		{
        		var baslik = array[1] +","+ array[2];
        		$('.people').append("<li class='person' data-chat="+array[2]+" data-rep="+array[1]+"><img src='http://s13.postimg.org/ih41k9tqr/img1.jpg' alt='' /><span class='name'>"+array[4]+"</span></li>");        		
        		$('.chats').append("<div class='chat' data-chat="+array[2]+"><div class='conversation-start'><span>Today, 6:48 AM</span></div></div>");	
        		}
        	
        	
        	getMessage(array[0],array[2] );
        	generate( array[0] , array[4] );
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
   // stompClient.send("/app/chat", {}, $("#name").val());
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});


    var Message;
    Message = function (arg) {
        this.text = arg.text, this.message_side = arg.message_side;
        this.draw = function (_this) {
            return function () {
                var $message;
                $message = $($('.message_template').clone().html());
                $message.addClass(_this.message_side).find('.text').html(_this.text);
                $('.messages').append($message);
                return setTimeout(function () {
                    return $message.addClass('appeared');
                }, 0);
            };
        }(this);
        return this;
    };

        var getMessageText, message_side, sendMessage;
        getMessageText = function () {
            var $message_input;
            $message_input = $('.message_input');
            return $message_input.val();
        };

        $("#mesajistekleri").on('click','.istek',function(){
                var senderName = $(this).attr('data-sender');
                var repid = $(this).attr('data-rep');       
        		    
                $.ajax({
                	url: "../secure/KonusmayaBasla",
                	data: "senderId=" + senderName + "&recipientId=" +repid,
                	type: "GET",
                	contentType: "application/x-www-form-urlencoded;charset=utf-8",
                	success: function(response) {
                		
                		
                		var data = response;
            			var messages = data.message;
            			var name = data.senderName;
            			var repID = $("#anasayfaRepID").val();
            			if(data.repID != repID)
            				return;
                		
                		$('.people').append("<li class='person' data-chat="+data.senderID+" data-rep="+data.repID+"><img src='http://s13.postimg.org/ih41k9tqr/img1.jpg' alt='' /><span class='name'>"+name+"</span></li>");
                    	$('.chats').append("<div class='chat' data-chat="+data.senderID+"><div class='conversation-start'><span>Today, 6:48 AM</span></div></div>");	
                    	
                    	for(var j = 0 ; j < messages.length ; j++)
                    		{
                    			var message = messages[j];
                    			if(message.messageSide == "left")
                    				{
                    					getMessage(message.messageTxt , data.senderID);
                    				}
                    			
                    			if(message.messageSide == "right")
                				{
                    				sendMessage(message.messageTxt , data.senderID);
                				}
                    		}
                		
                		
                }});
                $(this).remove();
                

        	});
        
        
        
        var findChat="";
        $(".left").on('click','.person',function(){
        	if ($(this).hasClass('.active')) {
                return false;
            } else {
                findChat = $(this).attr('data-chat');
                var personName = $(this).find('.name').text();  
                var repid = $(this).attr('data-rep');       
        		document.getElementById("chatPerson").value =  findChat; 
                document.getElementById("chatPersonRep").value =  repid; 
                $('.right .top .name').html(personName);
                $('.chat').removeClass('active-chat');
                $('.left .person').removeClass('active');
                $(this).addClass('active');
                $('.chat[data-chat = '+findChat+']').addClass('active-chat');
                var deneme = $('.chat[data-chat = '+findChat+']');
                var child = deneme[0];
                child.scrollTop = child.scrollHeight;
            }
        	});
        
        $("#message").keyup(function(event){
            if(event.keyCode == 13){
            	sendMessage('','');
            }
        });

        function sendMessage(messageTxt , sender )
        {
        	var personName = $("#chatPerson").val(); // senderid
        	if(sender != '')
        		personName = sender;
        	
        	var repId = $("#chatPersonRep").val();
        	var txt = $("#message").val();
        	if(messageTxt != '')
        		txt = messageTxt;
        	if(txt =='')
        		return;
        	
        	
        	txt = txt.toUpperCase();
        	$('.chat[data-chat='+personName+']').append(" <div class='bubble me'>"+txt+"</div>");
        	var deneme = $('.chat[data-chat = '+personName+']');
            var child = deneme[0];
            child.scrollTop = child.scrollHeight;
        	
//        	
        	var mesaj = document.getElementById("message");
        	mesaj.value = '';
        	
        	
        	if(sender != '')
        		return;
      
        	$.ajax({
            	url: "../fb/sendMessage",
            	data: "messageText=" + txt + "&senderId=" +personName+ "&recipientId=" + repId,
            	type: "GET",
            	contentType: "application/x-www-form-urlencoded;charset=utf-8",
            	success: function(response) {
            		console.log("basarili sekilde gönderild.");
            }});
        
        }
        
        function getMessage(message , sender)
        {
        	$('.chat[data-chat='+sender+']').append(" <div class='bubble you'>"+message+"</div>");
        	var deneme = $('.chat[data-chat = '+sender+']');
            var child = deneme[0];
            child.scrollTop = child.scrollHeight;
        	
        }
        
        function getAllMessage()
        {
        	$.ajax({
            	url: "../secure/getAllMessage",
            	type: "GET",
            	cache: false,
            	success: function(response) {
            		
            		for(var i = 0 ; i< response.length ; i++)
            		{
            			

            			var deger = response[i];
            			var messages = response[i].message;
            			var name = response[i].senderName;
            			
            			
            			var repID = $("#anasayfaRepID").val();
            			if(deger.repID != repID)
            				continue;
            			
            			if(deger.userName == null || deger.userName == '')
        				{
            				$('#mesajistekleri').append("<li class='istek' data-sender="+deger.senderID+" data-rep="+deger.repID+" style='font-size: 16px;margin-top:5px;color: red'>"+name+" kişisinden gelen mesaj konusmaya baslamak için tıklayınız.</li>");
        					continue;
        				}

                    	$('.people').append("<li class='person' data-chat="+deger.senderID+" data-rep="+deger.repID+"><img src='http://s13.postimg.org/ih41k9tqr/img1.jpg' alt='' /><span class='name'>"+name+"</span></li>");
                    	$('.chats').append("<div class='chat' data-chat="+deger.senderID+"><div class='conversation-start'><span>Today, 6:48 AM</span></div></div>");	
                    	
                    	for(var j = 0 ; j < messages.length ; j++)
                    		{
                    			var message = messages[j];
                    			if(message.messageSide == "left")
                    				{
                    					getMessage(message.messageTxt , deger.senderID);
                    				}
                    			
                    			if(message.messageSide == "right")
                				{
                    				sendMessage(message.messageTxt , deger.senderID);
                				}
                    		}
                		
            		}
            		
            		
            		
            }});
        }
        
        function generate( text , sender) {
        	var txt = "<div class='activity-item'> <i class='fa fa-check text-success'></i> <div class='activity'>"+sender+ " kisinden gelen mesaj:  " +text+ " </div> </div>";
        	 var n = noty({
                 text        : txt,
                 type        : "information",
                 dismissQueue: true,
                 timeout	 : 10000,
                 layout      : 'topCenter',
                 closeWith   : ['click'],
                 theme       : 'relax',
                 maxVisible  : 10,
                 animation   : {
                     open  : 'animated bounceInLeft',
                     close : 'animated bounceOutLeft',
                     easing: 'swing',
                     speed : 500
                 }
             });
             console.log('html: ' + n.options.id);
             console.log(text + ' - ' + n.options.id);
             return n;
        }
        
        function getUser()
        {
        	$.ajax({
            	url: "../secure/getUser",
            	type: "GET",
            	success: function(response) {
            		return response;
            }});
        }
        
        //$('.chat').scrollTop = 9999999999999;
        
        
        
        