<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Montserrat', sans-serif;
}

body {
	background: #fec107;
	padding: 0 10px;
}

.wrapper {
	max-width: 500px;
	width: 100%;
	background: #fff;
	margin: 50px auto;
	box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.125);
	padding: 30px;
}

.wrapper .title {
	font-size: 24px;
	font-weight: 700;
	margin-bottom: 25px;
	color: #fec107;
	text-transform: uppercase;
	text-align: center;
}

.wrapper .form {
	width: 100%;
}

.wrapper .form .inputfield {
	margin-bottom: 15px;
	display: flex;
	align-items: center;
}

.wrapper .form .inputfield label {
	width: 200px;
	color: #757575;
	margin-right: 10px;
	font-size: 14px;
}

.wrapper .form .inputfield .input, .wrapper .form .inputfield .textarea
	{
	width: 100%;
	outline: none;
	border: 1px solid #d5dbd9;
	font-size: 15px;
	padding: 8px 10px;
	border-radius: 3px;
	transition: all 0.3s ease;
}

.wrapper .form .inputfield .textarea {
	width: 100%;
	height: 125px;
	resize: none;
}

.wrapper .form .inputfield .custom_select {
	position: relative;
	width: 100%;
	height: 37px;
}

.wrapper .form .inputfield .custom_select:before {
	content: "";
	position: absolute;
	top: 12px;
	right: 10px;
	border: 8px solid;
	border-color: #d5dbd9 transparent transparent transparent;
	pointer-events: none;
}

.wrapper .form .inputfield .custom_select select {
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	outline: none;
	width: 100%;
	height: 100%;
	border: 0px;
	padding: 8px 10px;
	font-size: 15px;
	border: 1px solid #d5dbd9;
	border-radius: 3px;
}

.wrapper .form .inputfield .input:focus, .wrapper .form .inputfield .textarea:focus,
	.wrapper .form .inputfield .custom_select select:focus {
	border: 1px solid #fec107;
}

.wrapper .form .inputfield p {
	font-size: 14px;
	color: #757575;
}

.wrapper .form .inputfield .check {
	width: 15px;
	height: 15px;
	position: relative;
	display: block;
	cursor: pointer;
}

.wrapper .form .inputfield .check input[type="checkbox"] {
	position: absolute;
	top: 0;
	left: 0;
	opacity: 0;
}

.wrapper .form .inputfield .check .checkmark {
	width: 15px;
	height: 15px;
	border: 1px solid #fec107;
	display: block;
	position: relative;
}

.wrapper .form .inputfield .check .checkmark:before {
	content: "";
	position: absolute;
	top: 1px;
	left: 2px;
	width: 5px;
	height: 2px;
	border: 2px solid;
	border-color: transparent transparent #fff #fff;
	transform: rotate(-45deg);
	display: none;
}

.wrapper .form .inputfield .check input[type="checkbox"]:checked ~
	.checkmark {
	background: #fec107;
}

.wrapper .form .inputfield .check input[type="checkbox"]:checked ~
	.checkmark:before {
	display: block;
}

.wrapper .form .inputfield .btn {
	width: 100%;
	padding: 8px 10px;
	font-size: 15px;
	border: 0px;
	background: #fec107;
	color: #fff;
	cursor: pointer;
	border-radius: 3px;
	outline: none;
}

.wrapper .form .inputfield .btn:hover {
	background: #ffd658;
}

.wrapper .form .inputfield:last-child {
	margin-bottom: 0;
}

@media ( max-width :420px) {
	.wrapper .form .inputfield {
		flex-direction: column;
		align-items: flex-start;
	}
	.wrapper .form .inputfield label {
		margin-bottom: 5px;
	}
	.wrapper .form .inputfield.terms {
		flex-direction: row;
	}
}

/* Custom styles for the popup */
.popup {
	display: none;
	position: fixed;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	border: 1px solid #000;
	background-color: #fff;
	z-index: 1000;
	padding: 20px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.popup-overlay {
	display: none;
	position: fixed;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	z-index: 999;
}

.loginBtn{
	background: #fec107 ;
	margin: 1rem 0rem ;
	text-align: center;
	padding  : 0.5rem ;
	color: #fff ;
}
.loginBtn a {
color: #fff ;	
text-decoration: none ;

}
</style>
<script type="text/javascript">
	function showPopup(message) {
		if (message) {
			var popup = document.getElementById('popup');
			var overlay = document.getElementById('popup-overlay');
			var messageElem = document.getElementById('popup-message');
			messageElem.textContent = message;
			popup.style.display = 'block';
			overlay.style.display = 'block';
		}
	}

	function closePopup() {
		var popup = document.getElementById('popup');
		var overlay = document.getElementById('popup-overlay');
		popup.style.display = 'none';
		overlay.style.display = 'none';
	}
</script>
</head>
<body onload="showPopup('${message}')">
	<form action="checkUser" method="post">
		<div class="wrapper">
			<div class="title">Registration Form</div>
			<div class="form">
				<div class="inputfield">
					<label>Email Address</label> 
					<input type="text" name="email"	class="input">
				</div>
				<div class="inputfield">
					<label>Password</label> <input type="password" name="password" class="input">
				</div>
				<div class="inputfield">
					<input type="submit" value="login" class="btn">
				</div>
			</div>

			<div class="loginBtn">
				 New here? Please 
       			 <a href="register">register</a> to create account.
			</div>
		</div>


	</form>
	<div id="popup-overlay" class="popup-overlay" onclick="closePopup()"></div>
	<div id="popup" class="popup">
		<span id="popup-message"></span>
		<button onclick="closePopup()">Close</button>
	</div>

</body>
</html>

