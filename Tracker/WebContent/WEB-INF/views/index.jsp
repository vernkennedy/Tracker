<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Jquery for tabs -->
<link
	href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
	rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>
			 $(document).ready(function(){
		
				$('ul.tabs li').click(function(){
					var tab_id = $(this).attr('data-tab');

					$('ul.tabs li').removeClass('current');
					$('.tab-content').removeClass('current');

					$(this).addClass('current');
					$("#"+tab_id).addClass('current');
				})

			})
		  </script>
<!--Stylesheet  -->
<link href="resources/css/index.css" rel="stylesheet" type="text/css"/ >
<!-- External Javascript Files -->
<script type="text/javascript" src="resources/javascript/myscript.js"></script>


<!-- Google PieChart -->
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
      
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          <c:forEach var="project" items="${listProjects}" varStatus="status">
     	  ['${project.name}',${project.cost}],
          
          </c:forEach>
        ]);
        
	
        var options = {
          title: 'Project',
          is3D: true 
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
    </script>


<title>Project Portfolio Tracker</title>
</head>
<body>





	<!--Google Table -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script type="text/javascript">
			  google.load("visualization", "1", {packages:["table"]});
			  google.setOnLoadCallback(drawTable);

			  function drawTable() {
				
				var data = new google.visualization.DataTable();
				data.addColumn('string', 'ProjectName');
				data.addColumn('number', 'Cost');
				data.addColumn('number', 'Duration');
				data.addColumn('number', '# of issues');
				data.addColumn('string', 'ProjectType');
				data.addColumn('boolean', 'Completed');
				data.addColumn('string', 'Information');
				data.addColumn('string', 'Edit');
				data.addColumn('string', 'Delete');      
			 
				
				data.addRows([		
				<c:forEach var="project" items="${listProjects}" varStatus="status">						
			['${project.name}',  {v: ${project.cost}, f: '$${project.cost}'},  {v: ${project.duration}, f: '${project.duration}'}, {v: ${project.issues}, f: '${project.issues}'},'${project.type}', ${project.completed},'<a href="projectDescription?id=${project.id}">description</a>','<a href="editProject?id=${project.id}">edit</a>','<a href="deleteProject?id=${project.id}">delete</a>'],
                 </c:forEach>
				
					]);

				var table = new google.visualization.Table(document.getElementById('table_div'));

				table.draw(data, {showRowNumber: true,allowHtml:true});
			  }
			</script>


	<!-- <div id="table_div" style="margin-left: -15.5px; "></div>				 
    		 <div id="piechart" style="width: 900px; height: 500px;"></div>
    	 -->


	<div id="header">
		<button>
			<a href="logout.php?logout=true">Log Out</a>
		</button>

		<h1>Project Portfolio Tracker(J2EE)</h1>
	</div>

	<div class="container">
		<ul class="tabs">
			<li class="tab-link current" data-tab="tab-1">Projects Home</li>
			<li class="tab-link" data-tab="tab-2">Reporting</li>
		</ul>


		<div id="tab-1" class="tab-content current">
			<h4>
				<a href="newProject"> + Add New Project</a>
			</h4>
			<div id="table_div" style="margin-left: -15.5px;"></div>
			<div id="piechart"
				style="width: 531px; height: 550px; position: fixed; top: 150px; margin-left: 787px;"></div>
		</div>

		<div id="tab-2" class="tab-content">
			<iframe id="graph"
				src="http://localhost:7001/ProjectPortfolioTracker/"></iframe>
			<br>
		</div>
	</div>
	<!-- container -->


</body>
</html>
