<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="by.htp.library.bean.DataConnect"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Library.com</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="js/connect.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/moment.min.js"></script>
<script type="text/javascript" src="js/moment-with-locales.min.js"></script>
<link rel="shortcut icon" href="img/favicon.ico" type="image/png">
<link href="css/index.css" rel="stylesheet">
<link href="css/animation.css" rel="stylesheet">
</head>
<script>
	$(document).ready(function() {
		autoEntrance();
		//natIP();
	});
</script>
<body>
	<div id="header" class="header">
		<label id="helloLbl" class="helloLbl">Greetings in the
			library!</label> <img src="img/library.png" class="libraryLbl"> <img
			id="userImg" src="img/user.png" class="userLoginImage">
		<div id="formLoggin" class="formLoggin">
			<input class="loginField" type="text" id="userField"
				placeholder="Login"> <input class="passwordField"
				type="password" id="passField" placeholder="Password">
			<button id="enterButton" class="enterButton"
				onclick="getUserEntranse();">OK</button>
			<button id="regButton" class="regButton"
				onclick="showRegistration();">Register</button>
			<img src="img/key.png" id="showPassword" class="showPasswordInput"
				onclick="showPasswordInField();">
		</div>
		<button id="closeButton" class="closeButton" onclick="reloadPage();">Exit</button>
		<label id="lblCountRent" class="lblCountRent">0</label>
		<button id="rentBtn" class="rentBtn" onClick="getListRenting();">Rent</button>

		<button id="rentListBtn" class="rentListBtn"
			onClick="showListRentingBookEmployee();">RentList</button>

		<button id="accountBtn" class="accountBtn"
			onClick="showFormPanelAccount();">Account</button>
	</div>




	<div id="disanablePanel" class="disanablePanel"></div>
	<div id="alertPanel" class="alertPanel">
		<img src="img/information.png" id="alertImagePanel"
			class="alertImagePanel"> <label id="alertLblPanel"
			class="alertLblPanel">INFORMATION</label>
	</div>





	<div id="panelReadBook" class="panelReadBook">
		<label id="panelReadBookLabl" class="panelReadBookLabl">READ
			BOOKS</label>
		<div id="panelReadBookTable" class="panelReadBookTable"></div>
		<label id="totalReadBook" class="totalReadBook">Total: 0</label>
		<div id="panelReadBookButtton" class="panelReadBookButtton">
			<button id="panelReadBookCancel" class="panelReadBookCancel"
				onclick="closeReadBookPanel();">Cancel</button>
		</div>
	</div>





	<div id="accountPanel" class="accountPanel">
		<img src="img/NoPhotoEmployee.png" id="backgroundAccountImage"
			class="backgroundAccountImage"> <img
			src="img/NoPhotoEmployee.png" id="accountPhotoImage"
			class="accountPhotoImage"> <label id="fullNameAccountLbl"
			class="fullNameAccountLbl">Fullname:</label> <input
			id="fullNameAccountField" class="fullNameAccountField" type="text">
		<label id="emailAccountLbl" class="emailAccountLbl">email:</label> <input
			id="emailAccountField" class="emailAccountField" type="text">
		<label id="dateBirthAccountLbl" class="dateBirthAccountLbl">Date
			of birth:</label> <input id="dateBirthAccountField"
			class="dateBirthAccountField" type="date"> <label
			id="tellAccountLbl" class="tellAccountLbl"
			pattern="2-[0-9]{3}-[0-9]{3}">Telephone:</label> <input
			id="tellAccountField" class="tellAccountField" type="text">

		<div class="buttonsAccountPanel">

			<label class="fileContainer"> Load photo <input type="file"
				class="loadPhotoAccount" id="loadPhotoAccount"
				onChange="loadImagePhotoAccount();" accept="image/*"
				value="???????????">
			</label>



			<button id="saveAccount" class="saveAccount"
				onclick="saveAccountPanel();">Save</button>
			<button id="cancelAccount" class="cancelAccount"
				onclick="cancelAccountPanel();">Cancel</button>
		</div>
	</div>


	<div id="panelAdditionalInfoBook" class="panelAdditionalInfoBook">
		<img src="img/book/nophoto.png" id="photoBook" class="photoBook">
		<img src="img/star.png" id="ratingBook" class="ratingBook"> <label
			id="discriptionBook" class="discriptionBook"></label> <label
			id="countRatin" class="countRatin">0,00</label>
		<button name="image" id="closePanelAdditionalInfoBook"
			class="closePanelAdditionalInfoBook"
			onclick="closePanelAdditionalInfoBook();">Close</button>
		<input type="file" class="loadImg" id="loadImg"
			onChange="loadImageInput();" accept="image/*" value="?????????????">
		<img src="img/address-book-edit.png" id="uploadInfoBtn"
			class="uploadInfoBtn" onClick="showPanelUpdateAdditionalInfo();">
		<button id="savePanelAdditionalInfoBook"
			class="savePanelAdditionalInfoBook"
			onclick="savePanelAdditionalInfoBook();">Save</button>
		<textarea class="discriptionUpdate" id="discriptionUpdate"></textarea>
	</div>




	<div class="panelRentingList" id="panelRentingList">
		<div class="geadPanelRentingList" id="geadPanelRentingList">Renting
			book list</div>
		<div class="tablePanelRentingList" id="tablePanelRentingList"></div>
		<div class="buttonPanelRentingList">
			<button id="printlPanelRentingList" class="printlPanelRentingList"
				onclick="">Print</button>
			<button id="cancellPanelRentingList" class="cancellPanelRentingList"
				onclick="hideListRentinPanel();">Cancel</button>
		</div>
	</div>





	<div id="panelAddRegRegistration" class="panelAddRegRegistration">
		<label id="lblStatusRegRegistration" class="lblStatusRegRegistration">status:modified</label>
		<label id="nameRegEmployeeLabel" class="nameRegEmployeeLabel">Name
			employee:</label> <label id="nameRegBookLabel" class="nameRegBookLabel">Name
			book:</label> <label id="dateOnRegBookLabel" class="dateOnRegBookLabel">Date
			on:</label> <label id="dateOffRegBookLabel" class="dateOffRegBookLabel">Date
			off:</label> <input id="selectEmployeeRegInput"
			class="selectEmployeeRegInput" type="text" list="employeeRegPanel">
		<datalist id="employeeRegPanel"></datalist>
		<input id="selectBookRegInput" class="selectBookRegInput" type="text"
			list="bookRegPanel">
		<datalist id="bookRegPanel"></datalist>
		<input id="selectRegDateOn" class="selectRegDateOn" type="date">
		<input id="selectRegDateOff" class="selectRegDateOff" type="date">
		<hr class="lineHrRegRegistration" />

		<div id="blockToolPanelBtn" class="blockToolPanelBtn">
			<button class="saveBtnRegRegistration"
				onclick="saveRegRegistrationFilter();">Save</button>
			<button class="cancelBtnRegRegistration"
				onclick="cancelRegRegistrationFilter();">Cancel</button>
		</div>
	</div>
	<div id="formRegistration" class="formRegistration">
		<div>
			<label id='labelRegistration' class='labelRegistration'>Registration</label>
		</div>
		<hr class="underLabelRegistration" />
		<div>
			<label id='labelLoginRegistrationForm'
				class='labelLoginRegistrationForm'>Login:</label> <input type="text"
				id="inputLoginRegistrationForm" name="inputLoginRegistrationForm"
				class="inputLoginRegistrationForm" oninput="validateInputLogin();">
		</div>
		<div>
			<label id="labelPasswordRegistrationForm"
				class="labelPasswordRegistrationForm">Password:</label> <input
				type="text" id="inputPasswordRegistrationForm"
				name="inputPasswordRegistrationForm"
				class="inputPasswordRegistrationForm"
				oninput="validateInputPassword();">
		</div>
		<div>
			<label id='labelFullnameRegistrationForm'
				class='labelFullnameRegistrationForm'>Full name:</label> <input
				type='text' id='inputFullnameRegistrationForm'
				name='inputFullnameRegistrationForm'
				class="inputFullnameRegistrationForm">
		</div>
		<div>
			<label id='labelEmailRegistrationForm'
				class='labelEmailRegistrationForm'>Email:</label> <input
				type='email' id='inputEmailRegistrationForm'
				name='inputEmailRegistrationForm' class="inputEmailRegistrationForm"
				oninput="validateInputEmail();">
		</div>
		<div>
			<label id='labelDateBirthRegistrationForm'
				class='labelDateBirthRegistrationForm'>Date of birth:</label> <input
				type="date" id='inputDateBirthRegistrationForm'
				name='inputDateBirthRegistrationForm'
				class="inputDateBirthRegistrationForm"
				oninput="validateInputDate();">
		</div>
		<hr class="underCaptchaLabelRegistration" />
		<div>
			<label id="labelcaptchaRegistrationForm"
				class="labelcaptchaRegistrationForm"></label> <input type="text"
				id='inputCaptchaRegistrationForm'
				name='inputCaptchaRegistrationForm'
				class="inputCaptchaRegistrationForm">
		</div>
		<hr class="belowLabelRegistration" />
		<div>
			<input type="submit" value='Save' id="saveButtonRegistrationForm"
				class="saveButtonRegistrationForm" onClick="saveRegistration();">
		</div>
		<div>
			<input type="submit" value='Cancel' id="cancelButtonRegistrationForm"
				class="cancelButtonRegistrationForm" onClick="cancelRegistration();">
		</div>
	</div>
	<div id="blockEditAdd" class="blockEditAdd">
		<div id="lblBrif" class="lblDrief">
			<label id="lblStatus" class="lblStatus">status: modified</label>
			<hr class="lineHr">
			<label id="lblBrief" class="lblBrief">Brief:</label> <input
				id="fieldBrief" class="fieldBrief" type="text"> <label
				id="lblPublishUear" class="lblPublishUear">Publish year:</label> <input
				id="selectPublisYear" class="selectPublisYear" type="text"
				list="years">
			<datalist id="years">
			<option value="1999">
			<option value="2000">
			<option value="2001">
			<option value="2002">
			<option value="2003">
			<option value="2004">
			<option value="2005">
			<option value="2006">
			<option value="2007">
			<option value="2008">
			<option value="2009">
			<option value="2010">
			<option value="2011">
			<option value="2012">
			<option value="2013">
			<option value="2014">
			<option value="2015">
			<option value="2016">
			<option value="2017">
			<option value="2018">
			</datalist>

			<label id="lblAuthor" class="lblAuthor">Author:</label> <input
				id="selectAuthor" class="selectAuthor" type="text" list="autiorList">
			<datalist id="autiorList"> </datalist>
		</div>
		<div id="blockToolPanelBtn" class="blockToolPanelBtn">
			<button class="saveBtnEdit" onclick="hideRegPanelSave();">Save</button>
			<button class="cancelBtnEdit" onclick="hideRegPanelCancel();">Cancel</button>
		</div>
	</div>
	<div id="blockEditAddEmployee" class="blockEditAddEmployee">
		<div id="lblEmployee" class="lblEmployee">
			<label id="lblStatusEmployee" class="lblStatusEmployee">status:
				modified</label>
			<hr class="lineHrEmployee">
			<label id="lblNmae" class="lblName">Name:</label> <input
				id="fieldName" class="fieldName" type="text"> <label
				id="lblDateBirth" class="lblDateBirth">Date of birth:</label> <input
				id="selectDateBirth" class="selectDateBirth" type="date" value="">
			<label id="lblEmail" class="lblEmail">Email:</label> <input
				id="selectEmail" class="selectEmail" type="text">
		</div>
		<div id="blockToolPanelBtn" class="blockToolPanelBtn">
			<button class="saveBtnEdit" onclick="hideRegPanelSave();">Save</button>
			<button class="cancelBtnEdit" onclick="hideRegPanelCancel();">Cancel</button>
		</div>
	</div>
	<div class="menuPanel">
		<img src="img/books.png" id="imgButton1" class="imgButton1"
			onClick="getListBook();"> <img src="img/peoples.png"
			id="imgButton2" class="imgButton2" onClick="getListEmployee();">
		<img src="img/reports.png" id="imgButton3" class="imgButton3"
			onClick="loadWorkPanel();"> <img src="img/noButton.png"
			id="imgButton4" class="imgButton4" onClick="">
	</div>
	<div id="tablesPanel" class="tablesPanel">
		<input class="findField" type="text" id="findField"
			placeholder="Search by..." onkeyup="GetChar (value);"> <img
			src="img/cancel.png" alt="" id="imgButtonClearFilter"
			class="imgButtonClearFilter" onClick="clearSearchField();">
		<script type="text/javascript">
			function GetChar(event) {
				var getTextFromSearchField = event;
				getFilterListBook(getTextFromSearchField);
			}
		</script>

		<div id="blockTable" class="blockNameTable">Select the table to
			work with.</div>
		<button id="reportDtn" class="reportBtn" onClick="reportBook();">Print</button>
		<button id="addDtn" class="addBtn" onClick="AddNew();">New</button>
		<div id="blokForTable" class="blokForTable">
			<div id="respServlet"></div>
		</div>





		<div id="paging" class="paging"></div>




	</div>
	<div id="tablesPanelControl" class="tablesPanelControl">
		<div id="blockTable" class="blockNameTable">Book registration.</div>
		<button id="addRedRegistrationBook" class="addRedRegistrationBook"
			onClick="showAddRegistrationPanel();">new</button>
		<button id="refreshRegistrationBook" class="refresh"
			onClick="loadRegistrationBook();">refresh</button>
		<input class="findField" type="text" id="searchRegRegistration"
			placeholder="Search by full name employee"
			onkeyup="GetCharRegFilter(value);">
		<script type="text/javascript">
			function GetCharRegFilter(event) {
				var getTextFromSearchField = event;
				getFilterRegRegistration(getTextFromSearchField);
			}
		</script>
		<img src="img/cancel.png" alt="" id="" class="imgButtonClearFilter"
			onClick="clearRegRegistrationFilter();">
		<div id="panelTableRegistrationBook"
			class="panelTableRegistrationBook"></div>
	</div>


	<div id="downloadBlock" class="downloadBlock">
		<!-- <a id="downloadLink" class="downloadLink" href="download/Library_client.apk" type="application/file" download></a> -->
		<img src="img/android.gif" id="downloadPng" class="downloadPng"
			onclick="downloadApp();">
	</div>

	<div id="footer" class="footer">&copy; Alexsander Gvozdev, 2018</div>

	<label> <jsp:useBean id="DataConnect"
			class="by.htp.library.bean.DataConnect" /> <%@ page
			import="java.util.*"%> <%
 	ResourceBundle rb = ResourceBundle.getBundle("db_config");
 	String vertion = rb.getString("project.version");
 %>
		<p class="dateOnlbl">
			[VERTION]:
			<%=vertion%>
			[SERVER]:
			<%=application.getServerInfo()%>
			<%=application.getMajorVersion()%>.<%=application.getMinorVersion()%>
			[IP]:
			<%=DataConnect.getIp()%>
			[DATE]:
			<%=DataConnect.getDate()%>
			[TIME]:
			<%=DataConnect.getTime()%>
		</p>
	</label>
</body>
</html>







