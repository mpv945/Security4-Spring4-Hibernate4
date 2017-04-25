<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>



<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<link href='<c:url value='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' /> ' rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="<c:url value='resources/css/login.css' /> "  type="text/css" media="all"/>

</head>

<body>
<!--header-->
	<div class="header-w3l">
		<h1> Admin Form</h1>
	</div>
<!--//header-->

<!--main-->
<div class="main-content-agile">
	<div class="sub-main-w3">	
        <form action="<c:url value='/j_spring_security_check' /> " method="post">
			<input placeholder="Username or E-mail" name="username" class="user" type="text" required=""><br>
			<input  placeholder="Password" name="password" class="pass" type="password" required=""><br>
			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
			<input type="submit" value="">
		</form>
	</div>
</div>
<!--//main-->

</body>
</html>