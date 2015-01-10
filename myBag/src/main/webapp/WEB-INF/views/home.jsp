<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>My Notepad</title>

<style type="text/css">

/*!
 * Start Bootstrap - Simple Sidebar HTML Template (http://startbootstrap.com)
 * Code licensed under the Apache License v2.0.
 * For details, see http://www.apache.org/licenses/LICENSE-2.0.
 */

/* Toggle Styles */
#wrapper {
	padding-left: 0;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
}

#wrapper.toggled {
	padding-left: 250px;
}

#sidebar-wrapper {
	z-index: 1000;
	position: fixed;
	left: 250px;
	width: 0;
	height: 100%;
	margin-left: -250px;
	overflow-y: auto;
	background: #000;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-o-transition: all 0.5s ease;
	transition: all 0.5s ease;
}

#wrapper.toggled #sidebar-wrapper {
	width: 200px;
}

#page-content-wrapper {
	width: 100%;
	padding: 15px;
}

#wrapper.toggled #page-content-wrapper {
	position: absolute;
	margin-right: -250px;
}

/* Sidebar Styles */
.sidebar-nav {
	position: absolute;
	top: 0;
	width: 200px;
	margin: 0;
	padding: 0;
	list-style: none;
}

.sidebar-nav li {
	text-indent: 20px;
	line-height: 40px;
}

.sidebar-nav li a {
	display: block;
	text-decoration: none;
	color: #999999;
}

.sidebar-nav li a:hover {
	text-decoration: none;
	color: #fff;
	background: rgba(255, 255, 255, 0.2);
}

.sidebar-nav li a:active,.sidebar-nav li a:focus {
	text-decoration: none;
}

.sidebar-nav>.sidebar-brand {
	height: 65px;
	font-size: 18px;
	line-height: 60px;
}

.sidebar-nav>.sidebar-brand a {
	color: #999999;
}

.sidebar-nav>.sidebar-brand a:hover {
	color: #fff;
	background: none;
}

@media ( min-width :768px) {
	#wrapper {
		padding-left: 200px;
	}
	#wrapper.toggled {
		padding-left: 0;
	}
	#sidebar-wrapper {
		width: 200px;
	}
	#wrapper.toggled #sidebar-wrapper {
		width: 0;
	}
	#page-content-wrapper {
		padding: 20px;
	}
	#wrapper.toggled #page-content-wrapper {
		position: relative;
		margin-right: 0;
	}
}
</style>

<!-- Bootstrap -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- SYNTAX HIGHLIGHER: Include *at least* the core style and default theme -->
<link
	href="<c:url value='/resources/js/syntaxhighlighter_3.0.83/styles/shCore.css'/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value='/resources/js/syntaxhighlighter_3.0.83/styles/shThemeDefault.css'/>"
	rel="stylesheet" type="text/css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<!-- Constants -->
	<c:url var="logoutUrl" value="/logout" />

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="#"> My Notepad </a></li>
				<li><a id="id_a_add" href="#">Add</a></li>
				<li>
					<form action="${logoutUrl}" method="post">
						<input type="submit" value="Log out" class="btn" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</li>
			</ul>
		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						<div id="id_div_add">

							<a href="#menu-toggle" class="btn btn-default" id="menu-toggle"><<</a>

							<div id="id_div_add_page1">
								<h1>Add</h1>

								<form id="id_form_addInfo">
									<div class="form-group">
										<label for="question">Name *</label> <input type="text"
											class="form-control" id="id_inputText_name" required>
									</div>
									<div class="form-group">
										<label for="tag">Email address</label> <input type="email"
											class="form-control" id="id_inputText_emailAddr">
									</div>
									<div class="form-group">
										<label for="tag">Mobile number</label> <input type="tel"
											class="form-control" id="id_inputText_MobNumber"
											placeholder="Mobile number">
									</div>
									<div class="form-group">
										<label for="question">4 digit code</label> <input type="text"
											class="form-control" id="id_inputText_code" disabled>
									</div>
									<button id="id_submit" type="button" class="btn btn-default">Submit</button>
									<button id="id_new" type="button" class="btn btn-default">+</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery 
	<script src="js/jquery.js"></script>
	-->


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<!-- Latest compiled and minified JavaScript -->

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>


	<script>
		// Shorthand for $( document ).ready()
		$(function() {

			$('#id_inputText_code').val(Math.floor(Math.random() * 10000));

			//Initialization

			var id_question = '';

			$("#menu-toggle").click(function(e) {
				e.preventDefault();
				$("#wrapper").toggleClass("toggled");
			});

			$('#id_div_search').hide();
			$('#id_div_quiz').hide();

			$('#id_a_add').click(function() {
				$('#id_div_search').hide();
				$('#id_div_quiz').hide();
				$('#id_div_add').show();
			});

			$('#id_a_quiz').click(function() {
				$('#id_div_search').hide();
				$('#id_div_add').hide();
				$('#id_div_quiz').show();
			});

			$('#id_a_search').click(function() {
				$('#id_div_search').show();
				$('#id_div_add').hide();
				$('#id_div_quiz').hide();
			});

			$('#id_div_add_page2').hide();

			function IsEmail(email) {
				var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
				return regex.test(email);
			}

			function IsValidMobNumber(mobNumbr) {
				var pattern = /^\d{10}$/;
				if (pattern.test(mobNumbr)) {
					return true;
				} else {
					return false;
				}
			}

			$('#id_new').click(function() {
				$('#id_inputText_emailAddr').val('');
				$('#id_inputText_MobNumber').val('');
				$('#id_inputText_name').val('');
				$('#id_inputText_code').val(Math.floor(Math.random() * 10000));
			});

			$('#id_submit')
					.click(
							function(event) {

								if (($('#id_inputText_name').val()).length < 2) {
									alert('Unable to add info. Name should have atleast 2 characters');
									return;
								}

								if (($('#id_inputText_emailAddr').val()).length > 1) {
									if (!IsEmail($('#id_inputText_emailAddr')
											.val())) {
										alert('Email addr invalid try again.');
										return;
									}
								}

								if (($('#id_inputText_MobNumber').val()).length > 1) {
									if (!IsValidMobNumber($(
											'#id_inputText_MobNumber').val())) {
										alert('Mobile number is invalid. Try again.');
										return;
									}
								}

								var name = $('#id_inputText_name').val();
								var emailAddr = $('#id_inputText_emailAddr')
										.val();
								var mobNumbr = $('#id_inputText_MobNumber')
										.val();
								var code = $('#id_inputText_code').val();

								var json = {
									"name" : name,
									"emailAddress" : emailAddr,
									"mobileNumber" : mobNumbr,
									"code" : code
								};

								$
										.ajax({
											url : "blog/add",
											data : JSON.stringify(json),
											type : "POST",
											contentType : 'application/json',
											beforeSend : function(xhr) {
												xhr.setRequestHeader("Accept",
														"application/json");
												xhr.setRequestHeader(
														"Content-Type",
														"application/json");
											},
											success : function(response) {

												if (response.status == "FAILURE") {
													alert("Input validation failed. Check all input parameters and try again");
												}

												if (response.status == "SUCCESS") {
													alert("User has been added successfully.");
												}

											},
											error : function(xhr, ajaxOptions,
													thrownError) {
												alert("Unable to add contact. Error status: "
														+ xhr.status
														+ ", Error: "
														+ thrownError);
											}
										});// End ajax call	

								event.preventDefault();

							});

			$('#id_button_page2_back').click(function() {
				$('#id_div_add_page2').hide();
				$('#id_div_add_page1').show();
			});

			$('#id_a_quiz').click(function() {
				quizMe();
			});

			$('#id_button_nextBlog').click(function() {
				quizMe();
			});

		});
	</script>

</body>
</html>