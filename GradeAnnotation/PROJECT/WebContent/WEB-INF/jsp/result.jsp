

<html>
<head> 
    <title>Getting Started: Serving Web Content</title> 
    
   <head>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover{background-color:#f5f5f5}
</style>
</head>
</head>
<body>


	<center>
		<h2><font size="7">Automated Grade Report</h2>

	</center>
	<table id = "t1">
	  <tr>
	    <th><center><p><font size="5">Student Name</center></th>
	    <th><center><p><font size="5">BroncoId</center></th> 
	    <th><center><p><font size="5">Method Name</center></th>
	    <th><center><p><font size="5">Result correction</center></th>
	    <th><center><p><font size="5">Expected Output</center></th> 
	    <th><center><p><font size="5">Student Output</center></th>
	  </tr>
	<#list student as l>
	
	  <tr>
	    <td><center>${l.getStudentName()}</center></td>
	    <td><center>${l.getStudentNumber()}</center></td> 
	    <td><center>${l.getOperation()}</center></td>
	    <td><center>${l.getCodeCorrection()}</center></td>
	    <td><center>${l.getExpectedResult()}</center></td> 
	    <td><center>${l.getResult()}</td>
	  </tr>	   
	</#list>
	</table>
	<script type="text/javascript">
	<!--
	$(document).ready(function() {
    var listItems = $(".table tr td");
    listItems.each(function(idx, li) {
        if ($(this).text() == 'True') {
            $(this).css('background','green');
        } else if ($(this).text() == 'False') {
            $(this).css('background','red');
        }
    });
});
	-->
	</script>
</body>
</html>