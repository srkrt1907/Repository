<%@ page pageEncoding="UTF-8" %>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	
	<div class="row">
			<h1>Sohbet Geçimişi</h1>
		<table class="table table-striped table-bordered table-hover" id="displayTable">
			<thead>
               <tr class="odd gradeX">
              	   <th>Mesajlasma id</th>
                   <th>Gonderen</th>
                   <th>Alan</th> 
                   <th>Mesaj</th>
                   <th>Tarih</th>                                       
               </tr>
           </thead>
           <tbody>
           <c:forEach items="${messages }" var="senders" >
   				<c:forEach items="${senders.message}" var="mesaj" >
   				<tr class="odd gradeX" >
				   	<c:choose>
				    <c:when test="${mesaj.messageSide=='left'}">
				    		<td >${senders.id }</td>	  		
				  			<td>${senders.senderName }</td>
				  			<td>${senders.userName}</td>
				  			<td>${ mesaj.messageTxt}</td>
				  			<td>${ mesaj.senderDate}</td>
				    </c:when>    
				    <c:otherwise>
				    		<td >${senders.id }</td>				  			
				  			<td>${senders.userName}</td>
				  			<td>${senders.senderName }</td>
				  			<td>${ mesaj.messageTxt}</td>
				  			<td>${ mesaj.senderDate}</td>	
				    </c:otherwise>
					</c:choose>
   				</tr>
   				</c:forEach>
   			</c:forEach>
           </tbody>
           
		</table>
	
	</div>	

</body>


<content tag="local_script">
<script>
$(document).ready(function() {

	  $('#displayTable').DataTable({
	        responsive: true,
	        dom: 'lBfrtip',
	        iDisplayLength: 50,
	        buttons: [
	            'copyHtml5',
	            'excelHtml5',
	            'pdfHtml5'
	        ]
	    });

// 			var	mesajlar ="<c:out value='${messages}'/>";
// 			var dataSet=[];
// 	          for (var int = 0; int < mesajlar.length; int++) {

// 					var data = mesajlar[int];

// 					var mesaj = data.message;
// 					for(var j = 0 ; j < mesaj.length ; j++)
// 						{
// 							if(mesaj.messageSide == "left")
// 	        				{
// 	        					var gonderen = data.senderName;
// 	        					var alan = data.userName;
// 	        					var mes = mesaj.messageTxt;
// 	        					 var data2 = [gonderen,alan,mes];
// 	        	                 dataSet.push(data2);
// 	        				}
	        			
// 		        			if(mesaj.messageSide == "right")
// 		    				{
// 		        				var gonderen = data.userName;
// 	        					var alan = data.senderName;
// 	        					var mes = mesaj.messageTxt;
// 	        					 var data2 = [gonderen,alan,mes];
// 	        	                 dataSet.push(data2);
// 		    				}
// 						}
// 	          }
	               
// 	          $('#displayTable').DataTable({        
// 	        	  data: dataSet,  
// 	              dom: 'lBfrtip',
// 	              buttons: [
// 	                  'copyHtml5',
// 	                  'excelHtml5',
// 	                  'pdfHtml5'
// 	              ]   
	              
// 	          });      	
});
</script>
</content tag="local_script">
</html>