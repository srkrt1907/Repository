<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   <title>Agent System</title>
    <!-- NProgress -->    <!-- iCheck -->
	<link href="../resources/assets/css/animate.css" rel="stylesheet" type="text/css"/>
	<link href="../resources/assets/css/buttons.css" rel="stylesheet" type="text/css"/>
    <!-- bootstrap-progressbar -->
    <link href="../resources/admin/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="../resources/admin/css/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="../resources/admin/css/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <!-- Bootstrap -->
    <link href="../resources/admin/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../resources/admin/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../resources/admin/css/nprogress.css" rel="stylesheet">

    <link href="../resources/admin/css/green.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../resources/admin/css/custom.min.css" rel="stylesheet">
	
	<link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />

    <link href="../resources/admin/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
    <link href="../resources/admin/datatables-responsive/dataTables.responsive.css" rel="stylesheet"> 
    <link href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css" rel="stylesheet">
    
    
    <link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" rel="stylesheet" type="text/css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet" type="text/css">
		<link href="../resources/admin/datatables/css/editor.dataTables.min.css" rel="stylesheet" type="text/css"/>
	<link href="../resources/admin/css/loading.css" rel="stylesheet" type="text/css"/>
	<link href="../resources/admin/datatables/css/select.dataTables.min.css" rel="stylesheet" type="text/css"/>
  	<link href="../resources/assets/css/style.css" rel="stylesheet" type="text/css"/>
  <dec:head />
  </head>

  <body class="nav-md" onload="connect()">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="home" class="site_title"><i class="fa fa-moon-o"></i> <span>Glomes</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="../resources/admin/img/user.png" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <a class="navbar-brand" href="home">Welcome,</a>
                <h2><sec:authentication property="principal.username" /></h2>
              </div>
              <div class="clearfix"></div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a href="home"><i class="fa fa-home"></i> Home </span></a>
                  </li>
                  <li><a href="dialogs"><i class="fa fa-edit"></i>Dialogs </span></a>
                  </li>

                    <li>
                       <a href="history"><i class="fa fa-edit"></i> Dialogs History</a>
                   </li>
                   
                    <li>
                       <a href="agentInfo"><i class="fa fa-edit"></i> Agent Info</a>
                   </li>

                </ul>
              </div>


            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                   <img src="../resources/admin/img/user.png" alt="" >
					<sec:authentication property="principal.username" />
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="changePassword">Change Password</a></li>
                    <li><a href="logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>
			</ul>
                
      
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
          	<dec:body />
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <!-- /footer content -->
      </div>
    </div>
	
	<script type="text/javascript" src="../resources/admin/js/jquery.min.js"></script>
    <!-- jQuery --><script type="text/javascript" src="../resources/admin/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../resources/admin/js/fastclick.js"></script>
    <script type="text/javascript" src="../resources/admin/js/nprogress.js"></script>
    
    <!-- DataTables JavaScript -->
    <script src="../resources/admin/datatables/js/jquery.dataTables.min.js"></script>
    <script src="../resources/admin/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="../resources/admin/datatables-responsive/dataTables.responsive.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
    <script src="../resources/admin/js/task.js"></script>
    
    <script src="https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"></script>
    <script src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
    <script src="//cdn.rawgit.com/bpampuch/pdfmake/0.1.18/build/vfs_fonts.js"></script>
    <script src="//cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js"></script>
    
   	
   	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>
   	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.min.js"></script>
   	<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.js"></script>
    
	<script type="text/javascript" src="../resources/admin/datatables/js/dataTables.editor.min.js"></script>
	<script type="text/javascript" src="../resources/admin/datatables/js/dataTables.select.min.js"></script>
	
	

    <!-- Chart.js -->
    <script src="../resources/admin/js/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="../resources/admin/js/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="../resources/admin/js/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="../resources/admin/js/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="../resources/admin/js/skycons.js"></script>
    <!-- Flot -->
    <script src="../resources/admin/js/jquery.flot.js"></script>
    <script src="../resources/admin/js/jquery.flot.pie.js"></script>
    <script src="../resources/admin/js/jquery.flot.time.js"></script>
    <script src="../resources/admin/js/jquery.flot.stack.js"></script>
    <script src="../resources/admin/js/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="../resources/admin/js/jquery.flot.orderBars.js"></script>
    <script src="../resources/admin/js/jquery.flot.spline.min.js"></script>
    <script src="../resources/admin/js/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="../resources/admin/js/date.js"></script>
    <!-- JQVMap -->
    <script src="../resources/admin/js/jquery.vmap.js"></script>
    <script src="../resources/admin/js/jquery.vmap.world.js"></script>
    <script src="../resources/admin/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../resources/admin/js/moment.min.js"></script>
    <script src="../resources/admin/js/daterangepicker.js"></script>

    <!-- Custom Theme Scripts -->
  
      <script src="../resources/admin/js/raphael.min.js"></script>
    <script src="../resources/admin/js/morris.min.js"></script>

    <script src="../resources/admin/js/echarts.min.js"></script>
    <script src="../resources/admin/js/world.js"></script>

	<script type="text/javascript" src="../resources/assets/js/sockjs-0.3.min.js"></script>
  <script type="text/javascript" src="../resources/assets/js/stomp.min.js"></script>



	  <script type="text/javascript" src="../resources/assets/noty/packaged/jquery.noty.packaged.min.js"></script>
	<script type="text/javascript" src="../resources/assets/noty/layouts/bottomLeft.js"></script>
	
	<script type="text/javascript" src="../resources/assets/noty/layouts/topCenter.js"></script>
	<script type="text/javascript" src="../resources/assets/noty/themes/default.js"></script> 
	<script type="text/javascript" src="../resources/assets/js/app.js"></script>
	
	
	<script src="https://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="https://www.amcharts.com/lib/3/serial.js"></script>
<script src="https://www.amcharts.com/lib/3/plugins/export/export.min.js"></script>

<script src="https://www.amcharts.com/lib/3/themes/light.js"></script>
	
	
	<script type="text/javascript" src="../resources/admin/js/custom.min.js"></script>
	
	
	<dec:getProperty property="page.local_script"></dec:getProperty>
  </body>
</html>
