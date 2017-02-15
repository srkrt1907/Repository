<%@ page pageEncoding="UTF-8" %>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-type" content="text/plain; charset=UTF-8"/>
<title>Home</title>

</head>
<body>   <!-- page content -->
        <div role="main" style="min-height: 1209px;">
          <div class="">
            
            
            

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Agent 1 <small>Activity report</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>





                  <div class="x_content" style="display: block;">
                    
                    <div class="col-md-12 col-sm-12 col-xs-12">

                      <div class="profile_title">
                        <div class="col-md-6">
                          <h2>User Activity Report</h2>
                        </div>
                        <div class="col-md-6">
                          <div id="reportrange" class="pull-right" style="margin-top: 5px; background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #E6E9ED">
                            <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                            <span>January 15, 2017 - February 13, 2017</span> <b class="caret"></b>
                          </div>
                        </div>
                      </div>

                               <div class="row tile_count">
                          <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                              <span class="count_top"><i class="fa fa-user"></i> Toplam Kullanici</span>
                              <div class="count">15</div>
                              <span class="count_bottom"><i class="green">4% </i> From last Week</span>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                              <span class="count_top"><i class="fa fa-clock-o"></i> Toplam Konusma Süresi</span>
                              <div class="count">7500dk</div>
                              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>3% </i> From last Week</span>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                              <span class="count_top"><i class="fa fa-user"></i> Toplam Mesaj</span>
                              <div class="count green">22,500</div>
                              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                              <span class="count_top"><i class="fa fa-user"></i> Memnıniyet Orani</span>
                              <div class="count">%52</div>
                              <span class="count_bottom"><i class="red"><i class="fa fa-sort-desc"></i>12% </i> From last Week</span>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                              <span class="count_top"><i class="fa fa-user"></i> VIP Müşteri</span>
                              <div class="count">3</div>
                              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                              <span class="count_top"><i class="fa fa-user"></i> VIP Müşteri Süre</span>
                              <div class="count">3000dk</div>
                              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                            </div>
                      </div>

                      <!-- start of user-activity-graph -->
                        <div id="mainb2" style="width:100%;height:290px"></div>
                      <!-- end of user-activity-graph -->

                       <div class="" role="tabpanel" data-example-id="togglable-tabs">
                        <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                          <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Son Konusmalar</a>
                          </li>
                          <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">Tüm Konusmalar</a>
                          </li>
                          <li role="presentation" class=""><a href="#tab_content3" role="tab" id="profile-tab2" data-toggle="tab" aria-expanded="false">Hakkında</a>
                          </li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                          <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">

                            <!-- start recent activity -->
                            <ul class="messages">
                              <li>
                                <img src="../resources/assets/img/user.png" class="avatar" alt="Avatar">
                                <div class="message_date">
                                  <h3 class="date text-info">24</h3>
                                  <p class="month">Şubat</p>
                                </div>
                                <div class="message_wrapper">
                                  <h4 class="heading">Serkan</h4>
                                  <blockquote class="message">Deneme verisi</blockquote>
                                  <br />
                                  <p class="url">
                                    <span class="fs1 text-info" aria-hidden="true" data-icon=""></span>
                                    <a href="#"><i class="fa fa-paperclip"></i> User Acceptance Test.doc </a>
                                  </p>
                                </div>
                              </li>
                              <li><li>
                                <img src="../resources/assets/img/user.png" class="avatar" alt="Avatar">
                                <div class="message_date">
                                  <h3 class="date text-info">24</h3>
                                  <p class="month">Şubat</p>
                                </div>
                                <div class="message_wrapper">
                                  <h4 class="heading">Serkan</h4>
                                  <blockquote class="message">Deneme verisi 2</blockquote>
                                  <br />
                                  <p class="url">
                                    <span class="fs1 text-info" aria-hidden="true" data-icon=""></span>
                                    <a href="#"><i class="fa fa-paperclip"></i> User Acceptance Test.doc </a>
                                  </p>
                                </div>
                              </li>
                              <li>

                            </ul>
                            <!-- end recent activity -->

                          </div>
                          <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">

                            <!-- start user projects -->
                            <table class="data table table-striped no-margin">
                              <thead>
                                <tr>
                                  <th>#</th>
                                  <th>Kişi</th>
                                  <th>Konusma Süresi</th>
                                  <th class="hidden-phone">Toplam Mesaj</th>
                                </tr>
                              </thead>
                              <tbody>
                                <tr>
                                  <td>1</td>
                                  <td>Serkan</td>
                                  <td>2 saat</td>
                                  <td class="hidden-phone">175</td>
                                </tr>                      
                                <tr>
                                  <td>1</td>
                                  <td>Mehmet</td>
                                  <td>2 saat</td>
                                  <td class="hidden-phone">350</td>
                                </tr>
                              </tbody>
                            </table>
                            <!-- end user projects -->

                          </div>
                          <div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="profile-tab">
                            <p>Example </p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>




          <div class="">
            
            
            

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Agent 2 <small>Activity report</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>





                  <div class="x_content" style="display: block;">
                    
                    <div class="col-md-12 col-sm-12 col-xs-12">

                      <div class="profile_title">
                        <div class="col-md-6">
                          <h2>User Activity Report</h2>
                        </div>
                        <div class="col-md-6">
                          <div id="reportrange" class="pull-right" style="margin-top: 5px; background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #E6E9ED">
                            <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                            <span>January 15, 2017 - February 13, 2017</span> <b class="caret"></b>
                          </div>
                        </div>
                      </div>

                               <div class="row tile_count">
                          <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                              <span class="count_top"><i class="fa fa-user"></i> Toplam Kullanici</span>
                              <div class="count">5</div>
                              <span class="count_bottom"><i class="green">4% </i> From last Week</span>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                              <span class="count_top"><i class="fa fa-clock-o"></i> Toplam Konusma Süresi</span>
                              <div class="count">5200dk</div>
                              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>4% </i> From last Week</span>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                              <span class="count_top"><i class="fa fa-user"></i> Toplam Mesaj</span>
                              <div class="count green">12.000</div>
                              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>-2% </i> From last Week</span>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                              <span class="count_top"><i class="fa fa-user"></i> Memnıniyet Orani</span>
                              <div class="count">%70</div>
                              <span class="count_bottom"><i class="red"><i class="fa fa-sort-desc"></i>52% </i> From last Week</span>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                              <span class="count_top"><i class="fa fa-user"></i> VIP Müşteri</span>
                              <div class="count">1</div>
                              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>100% </i> From last Week</span>
                            </div>
                            <div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
                              <span class="count_top"><i class="fa fa-user"></i> VIP Müşteri Süre</span>
                              <div class="count">30dk</div>
                              <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>1000% </i> From last Week</span>
                            </div>
                      </div>

                      <!-- start of user-activity-graph -->
                        <div id="mainb" style="height:280px;"></div>
                      <!-- end of user-activity-graph -->

                       <div class="" role="tabpanel" data-example-id="togglable-tabs">
                        <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                          <li role="presentation" class="active"><a href="#tab_content6" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Son Konusmalar</a>
                          </li>
                          <li role="presentation" class=""><a href="#tab_content4" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">Tüm Konusmalar</a>
                          </li>
                          <li role="presentation" class=""><a href="#tab_content5" role="tab" id="profile-tab2" data-toggle="tab" aria-expanded="false">Hakkında</a>
                          </li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                          <div role="tabpanel" class="tab-pane fade active in" id="tab_content6" aria-labelledby="home-tab">

                            <!-- start recent activity -->
                            <ul class="messages">
                              <li>
                                <img src="../resources/assets/img/user.png" class="avatar" alt="Avatar">
                                <div class="message_date">
                                  <h3 class="date text-info">24</h3>
                                  <p class="month">Şubat</p>
                                </div>
                                <div class="message_wrapper">
                                  <h4 class="heading">Serkan</h4>
                                  <blockquote class="message">Deneme verisi2</blockquote>
                                  <br />
                                  <p class="url">
                                    <span class="fs1 text-info" aria-hidden="true" data-icon=""></span>
                                    <a href="#"><i class="fa fa-paperclip"></i> User Acceptance Test.doc </a>
                                  </p>
                                </div>
                              </li>
                              <li><li>
                                <img src="../resources/assets/img/user.png" class="avatar" alt="Avatar">
                                <div class="message_date">
                                  <h3 class="date text-info">24</h3>
                                  <p class="month">Şubat</p>
                                </div>
                                <div class="message_wrapper">
                                  <h4 class="heading">Serkan</h4>
                                  <blockquote class="message">Deneme verisi 3</blockquote>
                                  <br />
                                  <p class="url">
                                    <span class="fs1 text-info" aria-hidden="true" data-icon=""></span>
                                    <a href="#"><i class="fa fa-paperclip"></i> User Acceptance Test.doc </a>
                                  </p>
                                </div>
                              </li>
                              <li>

                            </ul>
                            <!-- end recent activity -->

                          </div>
                          <div role="tabpanel" class="tab-pane fade" id="tab_content4" aria-labelledby="profile-tab">

                            <!-- start user projects -->
                            <table class="data table table-striped no-margin">
                              <thead>
                                <tr>
                                  <th>#</th>
                                  <th>Kişi</th>
                                  <th>Konusma Süresi</th>
                                  <th class="hidden-phone">Toplam Mesaj</th>
                                </tr>
                              </thead>
                              <tbody>
                                <tr>
                                  <td>1</td>
                                  <td>Serkan</td>
                                  <td>1 saat</td>
                                  <td class="hidden-phone">75</td>
                                </tr>                      
                                <tr>
                                  <td>1</td>
                                  <td>Mehmet</td>
                                  <td>1 saat</td>
                                  <td class="hidden-phone">50</td>
                                </tr>
                              </tbody>
                            </table>
                            <!-- end user projects -->

                          </div>
                          <div role="tabpanel" class="tab-pane fade" id="tab_content5" aria-labelledby="profile-tab">
                            <p>Example </p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

</html>