<%-- 
    Document   : index.jsp
    Created on : Aug 30, 2018, 11:04:04 PM
    Author     : rashid ahmad
--%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
  
    <head>
        <title>word count</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <hr>  <center>
                        <form action="Data1" enctype="multipart/form-data" method="post" data-toggle="validator" class="form-horizontal" role="form">   
                        	<br><b>select number to find: </b> <br> <br>                         
                        	
                            <div class="form-group">
                                <div class="col-sm-10 col-sm-offset-1">
                                  number:  <input type="number" class="form-control"  name="num" required >
                                </div>
                            </div>
                            <div class="form-group">                                
                            	<div class="col-sm-10 col-sm-offset-1">
                            		<b>File Uploaded: </b> <br>
                                 <input type="file" class="form-control" name="file" >
                                </div>
                            </div>
                                
                             <div class="form-group">                                
                            	<div class="col-sm-10 col-sm-offset-1">
                            		<b>File Uploaded: </b> <br>
                                  <input type="submit" class="form-control" value="go" >
                                </div>
                            </div>
                        </form>
        
         </center>
         <hr>
                               
        high: ${msg}
        
        <br>
        
        Low :${msg1}
      
        
        <% session=request.getSession();
        
        session.invalidate();
        %>
    </body>
</html>
