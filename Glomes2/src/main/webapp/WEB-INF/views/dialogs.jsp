
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
</head>
<body>


<div class="wrapper2">
    <div class="container2" style="margin-left: -15px">
    	 <div class="x_panel">
                    <div class="x_title">
                      <h2>Mesaj İstekleri </h2>
                      <ul class="nav navbar-right panel_toolbox">
                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                        </li>
                        <li class="dropdown">
                          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        </li>
                      </ul>
                      <div class="clearfix"></div>
                    </div>
                    <div class="x_content" >
                    <ul id="mesajistekleri" class="mesajistekleri" style="max-height: 150px ; overflow-y: scroll ">
                                       
                     </ul>	
                    </div>
                  </div>
    
        <div class="left" style="margin-left: -15px">
            <div class="top">
                <span>Mesajlar</span>
            </div>
            
            <ul class="people">
                
             

            </ul>
            <div style="clear:both"></div>
        </div>
        <div class="right">
        	
            <div class="chats" style="min-height: 550px ; background-color: #7FFFD4">
            <div class="top"><span>To: <span class="name"></span></span></div>
            
            
            </div>
           
            <div class="write">
                <input type="text" id="message"/>
                <a href="javascript:sendMessage('','');" class="write-link send"></a>
            </div>
            <div style="clear:both"></div>
        </div>
    </div>
    <input type="hidden" name="chatPerson" id="chatPerson" value="">
    <input type="hidden" id="chatPersonRep" value="">
    <input type="hidden" id="anasayfaRepID" value="${repID}">
    
    
    <div style="clear:both"></div>
</div>




<!-- <div class="chat_window"><div class="top_menu"> -->
<!-- <div class="buttons"><div class="button close"></div> -->
<!-- <div class="button minimize"></div><div class="button maximize"> -->
<!-- </div></div><div class="title">Chat</div></div><ul class="messages"> -->
<!-- </ul><div class="bottom_wrapper clearfix"><div class="message_input_wrapper"> -->
<!-- <input class="message_input" placeholder="Type your message here..." /></div> -->
<!-- <div class="send_message"><div class="icon"></div><div class="text">Send</div> -->
<!-- </div></div></div><div class="message_template"><li class="message"> -->
<!-- <div class="avatar"></div><div class="text_wrapper"><div class="text"> -->
<!-- </div></div></li> -->
<!-- </div> -->
</body>

</html>