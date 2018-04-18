var idBookForUpdate;
var idEmployeeForUpdate;
var encodedFiel;
var getEncodeImg = "";
var strCaptcha;
var intChaptcha;
var login_constant = "";
var statusUser;
var statusAdmin;
var userIdRenting;
var getEncodephoto;
var idEditIssue;

var lblListBook;
var lblListEmployee;

var totalLbl;
var fromLbl;

var RU_LANGUAGE = {
    exit : 'Выход',
    account : 'Аккаунт',
    rent : 'Заказы',
    footer : '© Александр Гвоздев, 2018',
    addDtn : 'Новый',
    reportDtn : 'Печать',
    viewBtnRoe : 'Открыть',
    editBtnRow : 'Редакт.',
    deleteBtnRow : 'Удалить',
    addRedRegistrationBook : 'Новый',
    refreshRegistrationBook : 'Обновить',
    cancellPanelRentingList : 'Закрыть',
    fullNameAccountLbl : 'ФИО:',
    emailAccountLbl : 'email:',
    dateBirthAccountLbl : 'Дата рождения:',
    tellAccountLbl : 'Телефон:',
    loadPhotoAccount : 'Фото',
    saveAccount : 'Сохранить',
    cancelAccount : 'Закрыть',
    blockTable : 'Регистрация',
    geadPanelRentingList : 'Список заказов',
    nameRegEmployeeLabel : 'ФИО:',
    nameRegBookLabel : 'Книга:',
    dateOnRegBookLabel : 'Дата:',
    cancelBtnRegRegistration : 'Отмена',
    saveBtnRegRegistration : 'Сохранить',
    MSG_SEND_LETTER : 'Письмо было отправлено.',
    MSG_ERROR_TAG : 'Не определен тег для поиска.',
    lblChat : 'Чат',
    lblNameUserSendTo : 'Пользователь:',
    lblAllMessages : 'Сообщения:',
    lblNameUserSendFrom : 'Сообщение:',
    btnSendMessage : 'Отправить',
    enterButton : 'OK',
    regButton : 'Регистр.',
    lblUsersList : 'Пользователи:',
    idBookForChatBook : '[Книга]',
    idBookForChatEmployee : '[Читатель]'
};

var EN_LANGUAGE = {
    exit : 'Exit',
    account : 'Account',
    rent : 'Rent',
    footer : '© Alexsander Gvozdev, 2018',
    addDtn : 'New',
    reportDtn : 'Print',
    viewBtnRoe : 'View',
    editBtnRow : 'Edit',
    deleteBtnRow : 'Delete',
    addRedRegistrationBook : 'New',
    refreshRegistrationBook : 'Refresh',
    cancellPanelRentingList : 'Cancel',
    fullNameAccountLbl : 'Full name:',
    emailAccountLbl : 'email:',
    dateBirthAccountLbl : 'Date of birth:',
    tellAccountLbl : 'Telephone:',
    loadPhotoAccount : 'Load photo',
    saveAccount : 'Save',
    cancelAccount : 'Cancel',
    blockTable : 'Book registration',
    geadPanelRentingList : 'Renting book list',
    nameRegEmployeeLabel : 'Name employee:',
    nameRegBookLabel : 'Name book:',
    dateOnRegBookLabel : 'Date on:',
    cancelBtnRegRegistration : 'Cancel',
    saveBtnRegRegistration : 'Save',
    MSG_SEND_LETTER : 'The letter was sent.',
    MSG_ERROR_TAG : 'The tag for the search is not defined.',
    lblChat : 'Chat',
    lblNameUserSendTo : 'User:',
    lblAllMessages : 'Messages:',
    lblNameUserSendFrom : 'Message:',
    btnSendMessage : 'Send',
    enterButton : 'OK',
    regButton : 'Sign in',
    lblUsersList : 'Users:',
    idBookForChatBook : '[Book]',
    idBookForChatEmployee : '[Employee]'
};

var LANG = readCookie('LANG');

// showInformationPanel("The book list has been saved.");
// showInformationPanel("The employee list has been saved.");
// showInformationPanel("The employee list has been saved.");
// showInformationPanel("Editing the book has been canceled.");
// showInformationPanel("Editing the employee has been canceled.");
// showInformationPanel("The employee list hasn't been saved.");
// showInformationPanel("The employee list has been saved.");
// showInformationPanel("The book list hasn't been saved.");
// showInformationPanel("The book list has been saved.");
// showInformationPanel("Error automatic entry into the program..");
// showInformationPanel("A letter about the book order information was sent.");
// showInformationPanel("A letter about the book order information was sent.");
// showInformationPanel("The registration of the issuance of the book wasn't
// saved.");
// showInformationPanel("The registration of the issuance of the book was
// saved.");
// showInformationPanel("The registration of the issuance of the book was
// saved.");

function changeLanguage() {

    if (LANG == 'RU') {
        console.log('loadRussianContext: ' + LANG);
        var img = document.getElementById('EN_RU');
        setCookie('LANG', 'EN', '');
        img.src = "img/en.png";
        location.reload();
    } else {
        console.log('loadEnglishContext: ' + LANG);
        var img = document.getElementById('EN_RU');
        setCookie('LANG', 'RU', '');
        img.src = "img/ru.png";
        location.reload();
    }

};

function loadLanguageContext() {

    var LANG = readCookie('LANG');

    if (LANG == 'RU') {
        console.log('load russian context');
        var imgLang = document.getElementById('EN_RU');
        imgLang.src = 'img/ru.png';

        lblListBook = 'Список книг';
        lblListEmployee = 'Список читателей';
        totalLbl = 'ИТОГО: ';
        fromLbl = ' из ';

        document.getElementById('geadPanelRentingList').innerHTML = RU_LANGUAGE['geadPanelRentingList'];
        document.getElementById('closeButton').innerHTML = RU_LANGUAGE['exit'];
        document.getElementById('accountBtn').innerHTML = RU_LANGUAGE['account'];
        document.getElementById('rentBtn').innerHTML = RU_LANGUAGE['rent'];
        document.getElementById('footer').innerHTML = RU_LANGUAGE['footer'];
        document.getElementById('addDtn').innerHTML = RU_LANGUAGE['addDtn'];
        document.getElementById('reportDtn').innerHTML = RU_LANGUAGE['reportDtn'];

        document.getElementsByClassName('viewBtnRow').innerHTML = RU_LANGUAGE['viewBtnRoe'];
        document.getElementsByClassName('editBtnRow').innerHTML = RU_LANGUAGE['editBtnRow'];
        document.getElementsByClassName('deleteBtnRow').innerHTML = RU_LANGUAGE['deleteBtnRow'];

        document.getElementById('addRedRegistrationBook').innerHTML = RU_LANGUAGE['addRedRegistrationBook'];
        document.getElementById('refreshRegistrationBook').innerHTML = RU_LANGUAGE['refreshRegistrationBook'];
        document.getElementById('cancellPanelRentingList').innerHTML = RU_LANGUAGE['cancellPanelRentingList'];
        var place = document.getElementById('findField');
        place.setAttribute('placeholder', 'Поиск по...');
        var place = document.getElementById('searchRegRegistration');
        place.setAttribute('placeholder', 'Поиск по полному имени');
        document.getElementById('fullNameAccountLbl').innerHTML = RU_LANGUAGE['fullNameAccountLbl'];
        document.getElementById('fullNameAccountLbl').style.left = '41px';
        document.getElementById('emailAccountLbl').innerHTML = RU_LANGUAGE['emailAccountLbl'];
        document.getElementById('dateBirthAccountLbl').innerHTML = RU_LANGUAGE['dateBirthAccountLbl'];
        document.getElementById('dateBirthAccountLbl').style.left = '135px';
        document.getElementById('tellAccountLbl').innerHTML = RU_LANGUAGE['tellAccountLbl'];
        document.getElementById('tellAccountLbl').style.left = '179px';
        document.getElementById('fileContainer').innerHTML = RU_LANGUAGE['loadPhotoAccount'];
        document.getElementById('saveAccount').innerHTML = RU_LANGUAGE['saveAccount'];
        document.getElementById('cancelAccount').innerHTML = RU_LANGUAGE['cancelAccount'];
        document.getElementById('blockTable').innerHTML = RU_LANGUAGE['blockTable'];
        document.getElementById('nameRegEmployeeLabel').innerHTML = RU_LANGUAGE['nameRegEmployeeLabel'];
        document.getElementById('nameRegEmployeeLabel').style.left = '92px';
        document.getElementById('nameRegBookLabel').innerHTML = RU_LANGUAGE['nameRegBookLabel'];
        document.getElementById('nameRegBookLabel').style.left = '87px';
        document.getElementById('dateOnRegBookLabel').innerHTML = RU_LANGUAGE['dateOnRegBookLabel'];
        document.getElementById('dateOnRegBookLabel').style.left = '96px';
        document.getElementById('cancelBtnRegRegistration').innerHTML = RU_LANGUAGE['cancelBtnRegRegistration'];
        document.getElementById('saveBtnRegRegistration').innerHTML = RU_LANGUAGE['saveBtnRegRegistration'];
        document.getElementById('lblChat').innerHTML = RU_LANGUAGE['lblChat'];
        document.getElementById('lblNameUserSendTo').innerHTML = RU_LANGUAGE['lblNameUserSendTo'];
        document.getElementById('lblAllMessages').innerHTML = RU_LANGUAGE['lblAllMessages'];
        document.getElementById('lblNameUserSendFrom').innerHTML = RU_LANGUAGE['lblNameUserSendFrom'];
        document.getElementById('btnSendMessage').innerHTML = RU_LANGUAGE['btnSendMessage'];
        document.getElementById('enterButton').innerHTML = RU_LANGUAGE['enterButton'];
        document.getElementById('regButton').innerHTML = RU_LANGUAGE['regButton'];
        document.getElementById('lblUsersList').innerHTML = RU_LANGUAGE['lblUsersList'];
        document.getElementById('idBookForChatBook').innerHTML = RU_LANGUAGE['idBookForChatBook'];
        document.getElementById('idBookForChatEmployee').innerHTML = RU_LANGUAGE['idBookForChatEmployee'];

    } else {
        console.log('load english context');
        var imgLang = document.getElementById('EN_RU');
        imgLang.src = 'img/en.png';

        lblListBook = 'List of books';
        lblListEmployee = 'List of employee';
        totalLbl = 'Total: ';
        fromLbl = ' from ';

        document.getElementById('geadPanelRentingList').innerHTML = EN_LANGUAGE['geadPanelRentingList'];
        document.getElementById('closeButton').innerHTML = EN_LANGUAGE['exit'];
        document.getElementById('accountBtn').innerHTML = EN_LANGUAGE['account'];
        document.getElementById('rentBtn').innerHTML = EN_LANGUAGE['rent'];
        document.getElementById('footer').innerHTML = EN_LANGUAGE['footer'];
        document.getElementById('addDtn').innerHTML = EN_LANGUAGE['addDtn'];
        document.getElementById('reportDtn').innerHTML = EN_LANGUAGE['reportDtn'];

        document.getElementsByClassName('viewBtnRow').innerHTML = EN_LANGUAGE['viewBtnRoe'];
        document.getElementsByClassName('editBtnRow').innerHTML = EN_LANGUAGE['editBtnRow'];
        document.getElementsByClassName('deleteBtnRow').innerHTML = EN_LANGUAGE['deleteBtnRow'];

        document.getElementById('addRedRegistrationBook').innerHTML = EN_LANGUAGE['addRedRegistrationBook'];
        document.getElementById('refreshRegistrationBook').innerHTML = EN_LANGUAGE['refreshRegistrationBook'];
        document.getElementById('cancellPanelRentingList').innerHTML = EN_LANGUAGE['cancellPanelRentingList'];
        var place = document.getElementById('findField');
        place.setAttribute('placeholder', 'Search by...');
        var place = document.getElementById('searchRegRegistration');
        place.setAttribute('placeholder', 'Search by full name employee');
        document.getElementById('fullNameAccountLbl').innerHTML = EN_LANGUAGE['fullNameAccountLbl'];
        document.getElementById('fullNameAccountLbl').style.left = '12px';
        document.getElementById('emailAccountLbl').innerHTML = EN_LANGUAGE['emailAccountLbl'];
        document.getElementById('dateBirthAccountLbl').innerHTML = EN_LANGUAGE['dateBirthAccountLbl'];
        document.getElementById('dateBirthAccountLbl').style.left = '155px';
        document.getElementById('tellAccountLbl').innerHTML = EN_LANGUAGE['tellAccountLbl'];
        document.getElementById('tellAccountLbl').style.left = '170px';
        document.getElementById('fileContainer').innerHTML = EN_LANGUAGE['loadPhotoAccount'];
        document.getElementById('saveAccount').innerHTML = EN_LANGUAGE['saveAccount'];
        document.getElementById('cancelAccount').innerHTML = EN_LANGUAGE['cancelAccount'];
        document.getElementById('blockTable').innerHTML = EN_LANGUAGE['blockTable'];
        document.getElementById('nameRegEmployeeLabel').innerHTML = EN_LANGUAGE['nameRegEmployeeLabel'];
        document.getElementById('nameRegBookLabel').innerHTML = EN_LANGUAGE['nameRegBookLabel'];
        document.getElementById('dateOnRegBookLabel').innerHTML = EN_LANGUAGE['dateOnRegBookLabel'];
        document.getElementById('nameRegEmployeeLabel').innerHTML = EN_LANGUAGE['nameRegEmployeeLabel'];
        document.getElementById('nameRegEmployeeLabel').style.left = '27px';
        document.getElementById('nameRegBookLabel').innerHTML = EN_LANGUAGE['nameRegBookLabel'];
        document.getElementById('nameRegBookLabel').style.left = '57px';
        document.getElementById('dateOnRegBookLabel').innerHTML = EN_LANGUAGE['dateOnRegBookLabel'];
        document.getElementById('dateOnRegBookLabel').style.left = '81px';
        document.getElementById('cancelBtnRegRegistration').innerHTML = EN_LANGUAGE['cancelBtnRegRegistration'];
        document.getElementById('saveBtnRegRegistration').innerHTML = EN_LANGUAGE['saveBtnRegRegistration'];
        document.getElementById('lblChat').innerHTML = EN_LANGUAGE['lblChat'];
        document.getElementById('lblNameUserSendTo').innerHTML = EN_LANGUAGE['lblNameUserSendTo'];
        document.getElementById('lblAllMessages').innerHTML = EN_LANGUAGE['lblAllMessages'];
        document.getElementById('lblNameUserSendFrom').innerHTML = EN_LANGUAGE['lblNameUserSendFrom'];
        document.getElementById('btnSendMessage').innerHTML = EN_LANGUAGE['btnSendMessage'];
        document.getElementById('enterButton').innerHTML = EN_LANGUAGE['enterButton'];
        document.getElementById('regButton').innerHTML = EN_LANGUAGE['regButton'];
        document.getElementById('lblUsersList').innerHTML = EN_LANGUAGE['lblUsersList'];
        document.getElementById('idBookForChatBook').innerHTML = EN_LANGUAGE['idBookForChatBook'];
        document.getElementById('idBookForChatEmployee').innerHTML = EN_LANGUAGE['idBookForChatEmployee'];

    }

};

function setCookie(name, value, options) {
    options = options || {};

    var expires = options.expires;

    if (typeof expires == "number" && expires) {
        var d = new Date();
        d.setTime(d.getTime() + expires * 1000);
        expires = options.expires = d;
    }
    if (expires && expires.toUTCString) {
        options.expires = expires.toUTCString();
    }

    value = encodeURIComponent(value);

    var updatedCookie = name + "=" + value;

    for ( var propName in options) {
        updatedCookie += "; " + propName;
        var propValue = options[propName];
        if (propValue !== true) {
            updatedCookie += "=" + propValue;
        }
    }

    document.cookie = updatedCookie;
};

function unixtimetodate(date) {
    var theDate = date;
    var timestamp = moment.unix(theDate);
    return timestamp.format("DD.MM.YYYY");
};

function unixtimetodateDateBirth(date) {
    var theDate = date;
    var timestamp = moment.unix(theDate);
    return timestamp.format("YYYY-MM-DD");
};

function date2timestamp(year, month, day, hour, min, sec) {
    return (Date.UTC(year, month - 1, day, hour, min, sec) / 1000);
};

function showPanelUpdateAdditionalInfo() {

    document.getElementById("discriptionUpdate").style.display = "block";
    document.getElementById("loadImg").style.display = "block";
    document.getElementById("savePanelAdditionalInfoBook").style.display = "block";

    document.getElementById("panelAdditionalInfoBook").style.height = "500px";
    document.getElementById("closePanelAdditionalInfoBook").style.top = "462px";

    document.getElementById("discriptionUpdate").value = document
            .getElementById("discriptionBook").innerHTML;

};

function viewBookInfo() {
    var str = event.target.id;
    var strAction = str.split('-')[0];
    var strId = str.split('-')[1];

    document.getElementById("savePanelAdditionalInfoBook").setAttribute(
            "idRow", strId);

    var ratingBook = {
        action : 'rating',
        idBook : strId
    };

    $.ajax({
        url : urlServerBook,
        dataType : "json",
        data : ratingBook,
        error : function (message) {
        },
        success : function (data) {

            var arrAdditional = JSON.parse(JSON.stringify(data));
            var rating = arrAdditional["rantlist"][0]["rating"];

            if (arrAdditional.length != 0) {
                var countRatin = document.getElementById("countRatin");
                countRatin.innerHTML = rating;
            } else {
                var countRatin = document.getElementById("countRatin");
                countRatin.innerHTML = "0,00";
            }

        }
    });

    var additionalInfoBook = {
        action : 'additionalInfo',
        idBook : strId
    };

    $
            .ajax({
                url : urlServerBook,
                dataType : "json",
                data : additionalInfoBook,
                error : function (message) {
                },
                success : function (data) {
                    var arrDisrImg = JSON.parse(JSON.stringify(data));
                    var nameImgBook = arrDisrImg["arrBooksAditional"][0]["nameImgBook"];
                    var discriptionBook = arrDisrImg["arrBooksAditional"][0]["discriptionBook"];

                    if (arrDisrImg.length != 0) {
                        var photo = document.getElementById("photoBook");
                        photo.src = nameImgBook;
                        var str = document.getElementById("discriptionBook");
                        str.innerHTML = discriptionBook;
                    } else {
                        var photo = document.getElementById("photoBook");
                        photo.src = nameImgBook;
                        var str = document.getElementById("discriptionBook");
                        str.innerHTML = "not information";
                    }

                }
            });

    showDisenablePanel();
    var panelAdditionalInfoBook = document
            .getElementById("panelAdditionalInfoBook");
    panelAdditionalInfoBook.style.display = "block";

};

function loadImageInput() {
    var preview = document.getElementById('photoBook');
    var file = document.getElementById('loadImg').files[0];
    var reader = new FileReader();

    reader.onloadend = function () {
        preview.src = reader.result;
        getEncodeImg = reader.result;
    }

    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.src = "";
    }
};

function savePanelAdditionalInfoBook() {
    // указать что в тексте не более 600 символов
    var attr = document.getElementById("savePanelAdditionalInfoBook");
    var idBook = attr.getAttribute("idRow");
    var discriptionBook = document.getElementById("discriptionUpdate").value;
    var nameImageBook = document.getElementById("loadImg").value;
    var attrImg = document.getElementById("discriptionUpdate");
    var encodeImg = attrImg.src;

    var dataForUploadAdditionalInfo = {
        action : 'updateAdditionalInformation',
        idBook : idBook,
        discriptionBook : discriptionBook,
        nameImageBook : nameImageBook,
        imgEnCode : getEncodeImg
    };

    $.ajax({
        url : urlServerBook,
        type : "POST",
        dataType : "json",
        data : dataForUploadAdditionalInfo,
        error : function (message) {
        },
        success : function (data) {

        }
    });

    showInformationPanel("The additional information of the book has been saved.");

    document.getElementById("discriptionUpdate").style.display = "none";
    document.getElementById("loadImg").style.display = "none";
    document.getElementById("savePanelAdditionalInfoBook").style.display = "none";
    document.getElementById("panelAdditionalInfoBook").style.height = "309px";
    document.getElementById("closePanelAdditionalInfoBook").style.top = "273px";

    var panelAdditionalInfoBook = document
            .getElementById("panelAdditionalInfoBook");
    panelAdditionalInfoBook.style.display = "none";
};

function closePanelAdditionalInfoBook() {

    hideDisenablePanel();

    var heightPanel = document.getElementById("panelAdditionalInfoBook").style.height;

    console.log(heightPanel);

    if (heightPanel == "500px") {
        showInformationPanel("The additional information of the book hasn't been saved.");
        hideDisenablePanel();
    } else {
        hideDisenablePanel();
    }

    document.getElementById("discriptionUpdate").style.display = "none";
    document.getElementById("loadImg").style.display = "none";
    document.getElementById("savePanelAdditionalInfoBook").style.display = "none";
    document.getElementById("panelAdditionalInfoBook").style.height = "309px";
    document.getElementById("closePanelAdditionalInfoBook").style.top = "273px";

    var panelAdditionalInfoBook = document
            .getElementById("panelAdditionalInfoBook");
    panelAdditionalInfoBook.style.display = "none";

};

function getIdElementClickEmployeeEdit() {

    var str = event.target.id;
    var strAction = str.split('-')[0];
    var strId = str.split('-')[1];

    var tablesPanel = document.getElementById("lblStatus");
    tablesPanel.innerHTML = "status: editing employee";

    var expression = strId;

    idEmployeeForUpdate = strId;

    $.ajax({
        url : urlServerEmployee,
        dataType : "json",
        data : {
            action : 's',
            text : expression
        },
        error : function (message) {
        },
        success : function (data) {

            var arr = JSON.parse(JSON.stringify(data));
            var count = Object.keys(arr[0]).length;

            var bName = arr[0]["name"];
            var bDateBirth = arr[0]["dateBirth"];
            var bEmail = arr[0]["email"];

            var fieldName = document.getElementById("fieldName");
            fieldName.value = bName;

            var dateFromated = unixtimetodateDateBirth(bDateBirth);
            var selectDateBirth = document.getElementById("selectDateBirth");
            selectDateBirth.value = dateFromated;

            var selectEmail = document.getElementById("selectEmail");
            selectEmail.value = bEmail;

        }
    });

    var tablesPanel = document.getElementById("blockEditAddEmployee");
    tablesPanel.style.display = "block";

};

function getElementIdClickBookEdit() {

    showDisenablePanel();

    var str = event.target.id;
    var strAction = str.split('-')[0];
    var strId = str.split('-')[1];

    var tablesPanel = document.getElementById("lblStatus");
    tablesPanel.innerHTML = "status: editing";

    var expression = strId;

    idBookForUpdate = strId;

    $.ajax({
        url : urlServerBook,
        dataType : "json",
        data : {
            action : 'selectBookId',
            text : expression
        },
        error : function (message) {
        },
        success : function (data) {

            var arr = JSON.parse(JSON.stringify(data));
            var count = Object.keys(arr[0]).length;

            var bBrief = arr[0]["brief"];
            var bPublishYear = arr[0]["publishYear"];
            var bAuthor = arr[0]["author"];

            var fieldBrief = document.getElementById("fieldBrief");
            fieldBrief.value = bBrief;

            var selectPublisYear = document.getElementById("selectPublisYear");
            selectPublisYear.value = bPublishYear;

            var selectAuthor = document.getElementById("selectAuthor");
            selectAuthor.value = bAuthor;

        }
    });

    var tablesPanel = document.getElementById("blockEditAdd");
    tablesPanel.style.display = "block";

};

function deleeEmployById() {

    var str = event.target.id;
    var strAction = str.split('-')[0];
    var strId = str.split('-')[1];

    var dateDeleteBook = {
        action : 'deleteEmployee',
        id : strId
    };
    $.ajax({
        url : urlServerEmployee,
        dataType : "json",
        data : dateDeleteBook,
        error : function (message) {
            document.getElementById("respServlet").innerHTML = "";
            getListEmployee();
            setTimeout(getListBook(), 500);
        },
        success : function (data) {
            document.getElementById("respServlet").innerHTML = "";
            getListEmployee();
            setTimeout(getListBook(), 500);
        }
    });
    showInformationPanel("Employee ID:" + strId + " was deleted.");
    document.getElementById("respServlet").innerHTML = "";
    getListEmployee();
    setTimeout(getListBook(), 500);
};

function deleebookById() {

    var str = event.target.id;
    var strAction = str.split('-')[0];
    var strId = str.split('-')[1];

    var dateDeleteBook = {
        action : 'deleteBook',
        id : strId
    };
    $.ajax({
        url : urlServerBook,
        dataType : "json",
        data : dateDeleteBook,
        error : function (message) {
            document.getElementById("respServlet").innerHTML = "";
            getListBook();
            setTimeout(getListBook(), 500);
        },
        success : function (data) {
            document.getElementById("respServlet").innerHTML = "";
            getListBook();
            setTimeout(getListBook(), 500);
        }
    });
    document.getElementById("respServlet").innerHTML = "";
    getListBook();
    setTimeout(getListBook(), 500);

    showInformationPanel("Book ID:" + strId + " was deleted.");

};

function getListBook() {

    // load work panel
    loadWorkPanelHide();
    loadBookPanel();

    document.getElementById("addDtn").style.display = "block";

    $
            .ajax({
                url : urlServerBook,
                dataType : "json",
                data : {
                    action : 'readAllBooks'
                },
                error : function (message) {
                },
                success : function (data) {
                    document.getElementById("blockTable").innerHTML = lblListBook;
                    var arr = JSON.parse(JSON.stringify(data));

                    var count = Object.keys(arr["books"]).length;

                    document.getElementById("respServlet").innerHTML = "";

                    var colRowForPaging = 20;
                    var countBtn = count / colRowForPaging;

                    if (Math.round(countBtn) == 0) {
                        var panelPaginig = document.getElementById('paging');
                        var divsStart = "<div class=\"btnNextRows\" onClick=\"allBooks();\">*</div>";
                        var divsBlock = "";
                        var divsEnd = "<div class=\"btnNextRows\">»</div>";
                        var divTotal = "<div id=\"btnTotalRows\" class=\"btnTotalRows\">"
                                + count + fromLbl + count + "</div>";
                        document.getElementById('paging').innerHTML = ""
                                + divTotal;
                    } else {
                        var panelPaginig = document.getElementById('paging');
                        var divsStart = "<div class=\"btnNextRows\"  onClick=\"allBooks();\">*</div>";
                        var divsBlock = "";
                        var divsEnd = "<div class=\"btnNextRows\">»</div>";
                        var divTotal = "<div id=\"btnTotalRows\" class=\"btnTotalRows\">"
                                + count + fromLbl + count + "</div>";

                        for (var i = 1; i < Math.round(countBtn) + 1; i++) {
                            divsBlock = divsBlock
                                    + "<div onClick=\"showPageCount("
                                    + i
                                    + ", "
                                    + count
                                    + ");\" class=\"btnNextRows\" value=\"btnPaging-"
                                    + i + "\">" + i + "</div>";
                        }

                        document.getElementById('paging').innerHTML = divsStart
                                + divsBlock + divsEnd + divTotal;
                    }

                    var headStr = "";

                    var LANG = readCookie('LANG');

                    if (LANG == 'RU') {
                        var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff\">№</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Названиве</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 100px;\">Год</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Автор</td>"
                                + "<td  style=\"text-align: center;  background: #39b54a;  color: #fff\" colspan=\"3\" >Действия</td>"
                                + "</tr><tr>";
                    } else {

                        var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff\">Id</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Brief</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 100px;\">Publish year</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Author</td>"
                                + "<td  style=\"text-align: center;  background: #39b54a;  color: #fff\" colspan=\"3\" >Action</td>"
                                + "</tr><tr>";

                    }

                    var footStr = "</tr></table>";

                    var bodyStr = "";
                    for (var i = 0; i < count; i++) {

                        $("#autiorList").append(
                                '<option value="' + arr["books"][i]["author"]
                                        + '" selected="selected">'
                                        + arr["books"][i]["author"]
                                        + '</option>');

                        var value = value + arr["books"][i]["brief"];

                        bodyStr = bodyStr
                                + "<tr><td style=\"text-align: right;\">"
                                + arr["books"][i]["id"] + "</td>";
                        bodyStr = bodyStr + "<td>" + arr["books"][i]["brief"]
                                + "</td>";
                        bodyStr = bodyStr + "<td style=\"text-align: right;\">"
                                + arr["books"][i]["publishYear"] + "</td>";
                        bodyStr = bodyStr + "<td>" + arr["books"][i]["author"]
                                + "</td>";
                        bodyStr = bodyStr
                                + "<td style=\"width: 50px\"><button id=viewBtn-"
                                + arr["books"][i]["id"]
                                + " onClick=\"viewBookInfo();\" class=\"viewBtnRow\">view</button></td>";
                        bodyStr = bodyStr
                                + "<td style=\"width: 50px\"><button id=editBtn-"
                                + arr["books"][i]["id"]
                                + " onClick=\"getElementIdClickBookEdit();\" class=\"editBtnRow\">edit</button></td>";
                        bodyStr = bodyStr
                                + "<td style=\"width: 50px\"><button id=deleteBtn-"
                                + arr["books"][i]["id"]
                                + " onClick=\"deleebookById();\" class=\"deleteBtnRow\">delete</button></td>";

                    }
                    var table = headStr + bodyStr + footStr;
                    document.getElementById("respServlet").innerHTML = table;
                }
            });
};

function allBooks() {
    getListBook();
};

function allEmployee() {
    getListEmployee();
};

function saveBook() {

    var status = document.getElementById("lblStatus").innerHTML;

    if (status == "status: adding") {

        var a = document.getElementById("fieldBrief").value;
        var b = document.getElementById("selectPublisYear").value;
        var c = document.getElementById("selectAuthor").value;

        var dateAddBook = {
            action : 'createBook',
            brief : a,
            publisher : b,
            author : c
        };

        $.ajax({
            url : urlServerBook,
            dataType : "json",
            data : dateAddBook,
            error : function (message) {
                var tablesPanel = document.getElementById("blockEditAdd");
                tablesPanel.style.display = "none";
                getListBook();
            },
            success : function (data) {
                var tablesPanel = document.getElementById("blockEditAdd");
                tablesPanel.style.display = "none";
                getListBook();
            }
        });
        var tablesPanel = document.getElementById("blockEditAdd");
        tablesPanel.style.display = "none";
        getListBook();

        showInformationPanel("The book list has been saved.");

    } else {

        var a = idBookForUpdate;
        var b = document.getElementById("fieldBrief").value;
        var c = document.getElementById("selectPublisYear").value;
        var d = document.getElementById("selectAuthor").value;

        var dateUpdateBook = {
            action : 'updateBook',
            id : a,
            brief : b,
            publisher : c,
            author : d
        };

        $.ajax({
            url : urlServerBook,
            dataType : "json",
            data : dateUpdateBook,
            error : function (message) {
                var tablesPanel = document.getElementById("blockEditAdd");
                tablesPanel.style.display = "none";
                getListBook();
            },
            success : function (data) {
                var tablesPanel = document.getElementById("blockEditAdd");
                tablesPanel.style.display = "none";
                getListBook();
            }
        });
        var tablesPanel = document.getElementById("blockEditAdd");
        tablesPanel.style.display = "none";
        getListBook();
        showInformationPanel("The book list has been saved.");
    }

};

function saveEmployee() {

    var status = document.getElementById("lblStatusEmployee").innerHTML;

    if (status == "status: adding employee") {

        var a = document.getElementById("fieldName").value;

        var b = document.getElementById("selectDateBirth").value;
        var str = b;
        var year = str.split('-')[0];
        var month = str.split('-')[1];
        var day = str.split('-')[2];

        var dateUnix = date2timestamp(year, month, day, 0, 0, 0);

        var c = document.getElementById("selectEmail").value;

        var dateAddEmployee = {
            action : 'createEmployee',
            name : a,
            birthDay : dateUnix,
            email : c
        };

        $.ajax({
            url : urlServerEmployee,
            dataType : "json",
            data : dateAddEmployee,
            error : function (message) {
                var tablesPanel = document
                        .getElementById("blockEditAddEmployee");
                tablesPanel.style.display = "none";
                getListEmployee();
            },
            success : function (data) {
                var tablesPanel = document
                        .getElementById("blockEditAddEmployee");
                tablesPanel.style.display = "none";
                getListEmployee();
            }
        });
        var tablesPanel = document.getElementById("blockEditAddEmployee");
        tablesPanel.style.display = "none";
        getListEmployee();

        showInformationPanel("The employee list has been saved.");

    } else {

        var a = idEmployeeForUpdate;
        var b = document.getElementById("fieldName").value;

        var oldDate = document.getElementById("selectDateBirth").value;
        var str = oldDate;
        var year = str.split('-')[0];
        var month = str.split('-')[1];
        var day = str.split('-')[2];

        var dateUnix = date2timestamp(year, month, day, 0, 0, 0);

        var d = document.getElementById("selectEmail").value;

        var dateUpdateEmployee = {
            action : 'readAllBooks',
            id : a,
            name : b,
            birthDay : dateUnix,
            email : d
        };

        $.ajax({
            url : urlServerBook,
            dataType : "json",
            data : dateUpdateEmployee,
            error : function (message) {
                var tablesPanel = document
                        .getElementById("blockEditAddEmployee");
                tablesPanel.style.display = "none";
                getListEmployee();
            },
            success : function (data) {
                var tablesPanel = document
                        .getElementById("blockEditAddEmployee");
                tablesPanel.style.display = "none";
                getListEmployee();
            }
        });
        var tablesPanel = document.getElementById("blockEditAddEmployee");
        tablesPanel.style.display = "none";
        getListEmployee();

        showInformationPanel("The employee list has been saved.");
    }

};

function hideRegPanelSave() {

    var str = document.getElementById("blockTable").innerHTML;
    switch (str) {
    case lblListBook:
        saveBook();
        break
    case lblListEmployee:
        saveEmployee();
        break;
    }

};

function AddNew() {
    showDisenablePanel();
    document.getElementById("fieldBrief").value = "";
    document.getElementById("selectPublisYear").value = "";
    document.getElementById("selectAuthor").value = "";

    document.getElementById('saveBtnEditBook').style.border = '1px solid rgb(97, 100, 103)';
    document.getElementById('saveBtnEditBook').style.backgroundColor = 'rgb(88, 95, 101)';
    document.getElementById('saveBtnEditBook').disabled = true;

    // border: 1px solid #39b54a;
    // background-color: #39b54a;

    var lblStatus = document.getElementById("lblStatus");
    lblStatus.innerHTML = "status: adding";
    var tablesPanel = document.getElementById("blockEditAdd");
    tablesPanel.style.display = "block";

};

function checkFullFieldInAddNewBook() {

    var brief = document.getElementById('fieldBrief').value;
    var year = document.getElementById('selectPublisYear').value;
    var author = document.getElementById('selectAuthor').value;

    console.log(brief);
    console.log(year);
    console.log(author);

    if (brief == "" || year == "" || author == "") {
        document.getElementById('saveBtnEditBook').style.border = '1px solid rgb(97, 100, 103)';
        document.getElementById('saveBtnEditBook').style.backgroundColor = 'rgb(88, 95, 101)';
        document.getElementById('saveBtnEditBook').disabled = true;
        console.log('need fill all fields');
    } else {
        document.getElementById('saveBtnEditBook').style.border = '1px solid #39b54a';
        document.getElementById('saveBtnEditBook').style.backgroundColor = '#39b54a';

        document.getElementById('saveBtnEditBook').disabled = '';
    }

};

function checkFullFieldInRegistrationBook() {
    var employee = document.getElementById('selectEmployeeRegInput').value;
    var nameBook = document.getElementById('selectBookRegInput').value;
    var dateOn = document.getElementById('selectRegDateOn').value;
    // var dateOff = document.getElementById('selectRegDateOff').value;

    console.log(employee);
    console.log(nameBook);
    console.log(dateOn);
    // console.log(dateOff);

    if (employee == "" || nameBook == "" || dateOn == "") {
        document.getElementById('saveBtnRegRegistration').style.border = '1px solid rgb(97, 100, 103)';
        document.getElementById('saveBtnRegRegistration').style.backgroundColor = 'rgb(88, 95, 101)';
        document.getElementById('saveBtnRegRegistration').disabled = true;
        console.log('need fill all fields');
    } else {
        document.getElementById('saveBtnRegRegistration').style.border = '1px solid #39b54a';
        document.getElementById('saveBtnRegRegistration').style.backgroundColor = '#39b54a';
        document.getElementById('saveBtnRegRegistration').disabled = '';
    }
};

function checkFullFieldInRegistrationBook() {
    var employee = document.getElementById('selectEmployeeRegInput').value;
    var nameBook = document.getElementById('selectBookRegInput').value;
    var dateOn = document.getElementById('selectRegDateOn').value;
    var dateOff = document.getElementById('selectRegDateOff').value;

    console.log(employee);
    console.log(nameBook);
    console.log(dateOn);
    console.log(dateOff);

    if (employee == "" || nameBook == "" || dateOn == "" || dateOff == "") {
        document.getElementById('saveBtnRegRegistration').style.border = '1px solid rgb(97, 100, 103)';
        document.getElementById('saveBtnRegRegistration').style.backgroundColor = 'rgb(88, 95, 101)';
        document.getElementById('saveBtnRegRegistration').disabled = true;
        console.log('need fill all fields');
    } else {
        document.getElementById('saveBtnRegRegistration').style.border = '1px solid #39b54a';
        document.getElementById('saveBtnRegRegistration').style.backgroundColor = '#39b54a';
        document.getElementById('saveBtnRegRegistration').disabled = '';
    }
};

function hideRegPanelCancel() {

    var str = document.getElementById("blockTable").innerHTML;
    switch (str) {
    case lblListBook:
        var tablesPanel = document.getElementById("blockEditAdd");
        tablesPanel.style.display = "none";
        showInformationPanel("Editing the book has been canceled.");
        break
    case lblListEmployee:
        var tablesPanel = document.getElementById("blockEditAddEmployee");
        tablesPanel.style.display = "none";
        showInformationPanel("Editing the employee has been canceled.");
        break;
    }

};

function buildReportOfEployee() {

    var expression = document.getElementById("findField").value;

    $.ajax({
        url : urlServerEmployee,
        dataType : "json",
        data : {
            action : 'createXLSEmployee',
            text : expression
        },
        error : function (message) {
            showInformationPanel("The employee list hasn't been saved.");
        },
        success : function (data) {
            showInformationPanel("The employee list has been saved.");
        }
    });
};

function s2ab(s) {
    var buf = new ArrayBuffer(s.length);
    var view = new Uint8Array(buf);
    for (var i = 0; i != s.length; ++i)
        view[i] = s.charCodeAt(i) & 0xFF;
    return buf;
}

function buildReportOfBook() {

    var expression = document.getElementById("findField").value;

    $
            .ajax({
                url : urlServerBook,
                dataType : "json",
                data : {
                    action : 'createXLSBook',
                    text : expression
                },
                headers : {
                    'Content-type' : 'application/json'
                },
                responseType : 'arraybuffer',
                error : function (message) {
                    showInformationPanel("The book list hasn't been saved.");
                    // console.log(message.responseText);

                    var blob = new Blob(
                            [ message.responseText ],
                            {
                                type : "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                            });
                    var objectUrl = URL.createObjectURL(blob);
                    window.open(objectUrl);

                },
                success : function (data) {
                    showInformationPanel("The book list has been saved.");
                    console.log(data.responseText);
                }
            });
};

function reportBook() {

    var str = document.getElementById("blockTable").innerHTML;

    switch (str) {
    case lblListBook:
        buildReportOfBook();
        break
    case lblListEmployee:
        buildReportOfEployee();
        break
    }

};

function clearSearchField() {

    document.getElementById("findField").value = "";

    var str = document.getElementById("blockTable").innerHTML;

    switch (str) {
    case lblListBook:

        var lbl = document.getElementById("helloLbl").innerHTML;

        if (statusAdmin == "false") {
            $
                    .ajax({
                        url : urlServerBook,
                        dataType : "json",
                        data : {
                            action : 'readAllBooks'
                        },
                        error : function (message) {
                        },
                        success : function (data) {
                            document.getElementById("blockTable").innerHTML = lblListBook;
                            var arr = JSON.parse(JSON.stringify(data));

                            var count = Object.keys(arr["books"]).length;
                            document.getElementById("respServlet").innerHTML = "";

                            var headStr = "";

                            var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                    + "<td style=\"text-align: center; background: #39b54a; color: #fff\">Id</td>"
                                    + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Brief</td>"
                                    + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 100px;\">Publish year</td>"
                                    + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Author</td>"
                                    + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">View</td>"
                                    + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Rent</td>"
                            "<tr>";
                            var footStr = "</tr></table>";

                            var bodyStr = "";
                            for (var i = 0; i < count; i++) {

                                var value = value + arr["books"][i]["brief"];

                                bodyStr = bodyStr
                                        + "<tr><td style=\"text-align: right;\">"
                                        + arr["books"][i]["id"] + "</td>";
                                bodyStr = bodyStr + "<td>"
                                        + arr["books"][i]["brief"] + "</td>";
                                bodyStr = bodyStr
                                        + "<td style=\"text-align: right;\">"
                                        + arr["books"][i]["publishYear"]
                                        + "</td>";
                                bodyStr = bodyStr + "<td>"
                                        + arr["books"][i]["author"] + "</td>";

                                bodyStr = bodyStr
                                        + "<td style=\"width: 50px\"><button id=viewBtn-"
                                        + arr["books"][i]["id"]
                                        + " onClick=\"viewBookInfo();\" class=\"viewBtnRow\">view</button></td>";

                                bodyStr = bodyStr
                                        + "<td style=\"width: 50px\"><button id=viewBtn-"
                                        + arr["books"][i]["id"]
                                        + "-"
                                        + userIdRenting
                                        + " onClick=\"createRenting();\" class=\"viewBtnRow\">rent</button></td>";

                            }
                            var table = headStr + bodyStr + footStr;
                            document.getElementById("respServlet").innerHTML = table;
                        }
                    });
        } else {

            document.getElementById("findField").value = "";
            getListBook();

        }

        break

    case lblListEmployee:
        document.getElementById("findField").value = "";
        getListEmployee();
        document.getElementById("addDtn").style.display = "none";
        break
    }

};

function getFilterListBook(getTextFromSearchField) {

    var str = document.getElementById("blockTable").innerHTML;

    switch (str) {
    case lblListBook:

        var lbl = document.getElementById("helloLbl").innerHTML;

        if (lbl != "Hello, admin.") {

            var textSearch = getTextFromSearchField;

            $
                    .ajax({
                        url : urlServerBook,
                        dataType : "json",
                        data : {
                            action : 'findBook',
                            text : textSearch
                        },
                        error : function (message) {
                        },
                        success : function (data) {
                            document.getElementById("blockTable").innerHTML = lblListBook;
                            var arr = JSON.parse(JSON.stringify(data));
                            var count = Object.keys(arr["books"]).length;
                            document.getElementById("respServlet").innerHTML = "";

                            var headStr = "";

                            var LANG = readCookie('LANG');

                            if (LANG == 'RU') {
                                var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                        + "<td style=\"text-align: center; background: #39b54a; color: #fff\">№</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Название</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 100px;\">Год</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Автор</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Откр.</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Заказ</td>"
                                "<tr>";
                            } else {
                                var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                        + "<td style=\"text-align: center; background: #39b54a; color: #fff\">Id</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Brief</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 100px;\">Publish year</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Author</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">View</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Rent</td>"
                                "<tr>";
                            }

                            var footStr = "</tr></table>";

                            var bodyStr = "";
                            for (var i = 0; i < count; i++) {

                                var value = value + arr["books"][i]["brief"];

                                bodyStr = bodyStr
                                        + "<tr><td style=\"text-align: right;\">"
                                        + arr["books"][i]["id"] + "</td>";
                                bodyStr = bodyStr + "<td>"
                                        + arr["books"][i]["brief"] + "</td>";
                                bodyStr = bodyStr
                                        + "<td style=\"text-align: right;\">"
                                        + arr["books"][i]["publishYear"]
                                        + "</td>";
                                bodyStr = bodyStr + "<td>"
                                        + arr["books"][i]["author"] + "</td>";

                                bodyStr = bodyStr
                                        + "<td style=\"width: 50px\"><button id=viewBtn-"
                                        + arr["books"][i]["id"]
                                        + " onClick=\"viewBookInfo();\" class=\"viewBtnRow\">view</button></td>";

                                bodyStr = bodyStr
                                        + "<td style=\"width: 50px\"><button id=viewBtn-"
                                        + arr["books"][i]["id"]
                                        + "-"
                                        + userIdRenting
                                        + " onClick=\"createRenting();\" class=\"viewBtnRow\">rent</button></td>";

                            }
                            var table = headStr + bodyStr + footStr;
                            document.getElementById("respServlet").innerHTML = table;
                        }
                    });
        } else {

            var textSearch = getTextFromSearchField;

            $
                    .ajax({
                        url : urlServerBook,
                        dataType : "json",
                        data : {
                            action : 'findBook',
                            text : textSearch
                        },
                        error : function (message) {
                        },
                        success : function (data) {
                            document.getElementById("blockTable").innerHTML = lblListBook;
                            var arr = JSON.parse(JSON.stringify(data));
                            var count = Object.keys(arr["books"]).length;
                            document.getElementById("respServlet").innerHTML = "";

                            var headStr = "";

                            var LANG = readCookie('LANG');

                            if (LANG == 'RU') {
                                var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                        + "<td style=\"text-align: center; background: #39b54a; color: #fff\">№</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Название</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 100px;\">Год</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Автор</td>"
                                        + "<td  style=\"text-align: center;  background: #39b54a;  color: #fff\" colspan=\"3\" >Действие</td></tr><tr>";
                            } else {
                                var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                        + "<td style=\"text-align: center; background: #39b54a; color: #fff\">Id</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Brief</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 100px;\">Publish year</td>"
                                        + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Author</td>"
                                        + "<td  style=\"text-align: center;  background: #39b54a;  color: #fff\" colspan=\"3\" >Action</td></tr><tr>";
                            }

                            var footStr = "</tr></table>";

                            var bodyStr = "";
                            for (var i = 0; i < count; i++) {

                                $("#autiorList").append(
                                        '<option value="'
                                                + arr["books"][i]["author"]
                                                + '" selected="selected">'
                                                + arr["books"][i]["author"]
                                                + '</option>');

                                var value = value + arr["books"][i]["brief"];

                                bodyStr = bodyStr
                                        + "<tr><td style=\"text-align: right;\">"
                                        + arr["books"][i]["id"] + "</td>";
                                bodyStr = bodyStr + "<td>"
                                        + arr["books"][i]["brief"] + "</td>";
                                bodyStr = bodyStr
                                        + "<td style=\"text-align: right;\">"
                                        + arr["books"][i]["publishYear"]
                                        + "</td>";
                                bodyStr = bodyStr + "<td>"
                                        + arr["books"][i]["author"] + "</td>";
                                bodyStr = bodyStr
                                        + "<td style=\"width: 50px\"><button id=viewBtn-"
                                        + arr["books"][i]["id"]
                                        + " onClick=\"viewBookInfo();\" class=\"viewBtnRow\">view</button></td>";
                                bodyStr = bodyStr
                                        + "<td style=\"width: 50px\"><button id=editBtn-"
                                        + arr["books"][i]["id"]
                                        + " onClick=\"getElementIdClickBookEdit();\" class=\"editBtnRow\">edit</button></td>";
                                bodyStr = bodyStr
                                        + "<td style=\"width: 50px\"><button id=deleteBtn-"
                                        + arr["books"][i]["id"]
                                        + " onClick=\"deleebookById();\" class=\"deleteBtnRow\">delete</button></td>";

                            }
                            var table = headStr + bodyStr + footStr;
                            document.getElementById("respServlet").innerHTML = table;
                        }
                    });

        }
        break
    case lblListEmployee:

        var textSearch = getTextFromSearchField;

        $
                .ajax({
                    url : urlServerEmployee,
                    dataType : "json",
                    data : {
                        action : 'findEmployee',
                        text : textSearch
                    },
                    error : function (message) {
                    },
                    success : function (data) {
                        document.getElementById("blockTable").innerHTML = lblListEmployee;
                        var arr = JSON.parse(JSON.stringify(data));

                        var count = Object.keys(arr["employee"]).length;
                        document.getElementById("respServlet").innerHTML = "";

                        var headStr = "";

                        var LANG = readCookie('LANG');

                        if (LANG == 'RU') {
                            var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                    + "<td style=\"text-align: center; background: #39b54a; width: 50px; color: #fff\">№</td>"
                                    + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">ФИО</td>"
                                    + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 90px;\">Дата рожд.</td>"
                                    + "<td style=\"text-align: center;  background: #39b54a; width: 250px; color: #fff\">Email</td>"
                                    + "<td  style=\"text-align: center;  background: #39b54a;  color: #fff\" colspan=\"3\" >Действие</td></tr><tr>";
                        } else {
                            var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                    + "<td style=\"text-align: center; background: #39b54a; width: 50px; color: #fff\">Id</td>"
                                    + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Name</td>"
                                    + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 90px;\">Date of birth</td>"
                                    + "<td style=\"text-align: center;  background: #39b54a; width: 250px; color: #fff\">Email</td>"
                                    + "<td  style=\"text-align: center;  background: #39b54a;  color: #fff\" colspan=\"3\" >Action</td></tr><tr>";
                        }

                        var footStr = "</tr></table>";

                        var bodyStr = "";
                        for (var i = 0; i < count; i++) {

                            var date = arr["employee"][i]["dateBirth"];
                            var newDate = unixtimetodate(date);

                            bodyStr = bodyStr
                                    + "<tr><td style=\"text-align: right;\">"
                                    + arr["employee"][i]["id"] + "</td>";
                            bodyStr = bodyStr + "<td>"
                                    + arr["employee"][i]["name"] + "</td>";
                            bodyStr = bodyStr
                                    + "<td style=\"text-align: right;\">"
                                    + newDate + "</td>";
                            bodyStr = bodyStr + "<td>"
                                    + arr["employee"][i]["email"] + "</td>";
                            // bodyStr = bodyStr
                            // + "<td style=\"width: 50px\"><button id=editBtn-"
                            // + arr["employee"][i]["id"]
                            // + " onClick=\"getIdElementClickEmployeeEdit();\"
                            // class=\"editBtnRow\">edit</button></td>";
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"><button id=deleteBtn-"
                                    + arr["employee"][i]["id"]
                                    + " onClick=\"deleeEmployById();\" class=\"deleteBtnRow\">delete</button></td>";

                        }
                        var table = headStr + bodyStr + footStr;
                        document.getElementById("respServlet").innerHTML = table;
                    }
                });
        break
    }

};

function autoEntrance() {

    var login = document.getElementById('userField').value;
    var password = document.getElementById('passField').value;
    var enterButton = document.getElementById('enterButton');

    try {
        document.getElementById("userField").value = readCookie('strLoggin');
        document.getElementById("passField").value = readCookie('strPassword');

        enterButton.click();

        natIP();
    } catch (err) {

        showInformationPanel("Error automatic entry into the program..");

    }
};

function readCookie(name) {
    var name_cook = name + "=";
    var spl = document.cookie.split(';');
    for (var i = 0; i < spl.length; i++) {
        var c = spl[i];
        while (c.charAt(0) == ' ')
            c = c.substring(1, c.length);
        if (c.indexOf(name_cook) == 0)
            return c.substring(name_cook.length, c.length);
    }
    return null;
};

function showPasswordInField() {
    element = document.getElementById("passField");
    if (element.type == 'password') {
        element.type = "text";
    } else {
        element.type = "password";
    }
};

function validateInputLogin() {
    var str = document.getElementById('inputLoginRegistrationForm').value;
    if (/[a-zA-Z]/.test(str)) {
        document.getElementById('inputLoginRegistrationForm').style.background = "#fff";
        document.getElementById('labelLoginRegistrationForm').innerHTML = "Login:";
        document.getElementById('saveButtonRegistrationForm').removeAttribute(
                'disabled');
        document.getElementById('saveButtonRegistrationForm').style.background = "rgb(41, 129, 202)";
    } else {
        document.getElementById('inputLoginRegistrationForm').style.background = "#ffad99";
        document.getElementById('labelLoginRegistrationForm').innerHTML = "Login: (оnly English letters) ";
        document.getElementById('saveButtonRegistrationForm').setAttribute(
                'disabled', 'disabled');
        document.getElementById('saveButtonRegistrationForm').style.background = "rgb(186, 190, 193)";
    }
};

function validateInputPassword() {
    var str = document.getElementById('inputPasswordRegistrationForm').value;
    if (/[a-zA-Z]/.test(str)) {
        document.getElementById('inputPasswordRegistrationForm').style.background = "#fff";
        document.getElementById('labelPasswordRegistrationForm').innerHTML = "Password:";
        document.getElementById('saveButtonRegistrationForm').removeAttribute(
                'disabled');
        document.getElementById('saveButtonRegistrationForm').style.background = "rgb(41, 129, 202)";
    } else {
        document.getElementById('inputPasswordRegistrationForm').style.background = "#ffad99";
        document.getElementById('labelPasswordRegistrationForm').innerHTML = "Password: (оnly English letters) ";
        document.getElementById('saveButtonRegistrationForm').setAttribute(
                'disabled', 'disabled');
        document.getElementById('saveButtonRegistrationForm').style.background = "rgb(186, 190, 193)";
    }
};

function validateInputEmail() {
    var str = document.getElementById('inputEmailRegistrationForm').value;
    if (/^[-._a-z0-9]+@(?:[a-z0-9][-a-z0-9]+\.)+[a-z]{2,6}$/.test(str)) {
        document.getElementById('inputEmailRegistrationForm').style.background = "#fff";
        document.getElementById('labelEmailRegistrationForm').innerHTML = "Email:";
        document.getElementById('saveButtonRegistrationForm').removeAttribute(
                'disabled');
        document.getElementById('saveButtonRegistrationForm').style.background = "rgb(41, 129, 202)";
    } else {
        document.getElementById('inputEmailRegistrationForm').style.background = "#ffad99";
        document.getElementById('labelEmailRegistrationForm').innerHTML = "Email: (incorrect email) ";
        document.getElementById('saveButtonRegistrationForm').setAttribute(
                'disabled', 'disabled');
        document.getElementById('saveButtonRegistrationForm').style.background = "rgb(186, 190, 193)";
    }
};

function validateInputDate() {

    var dateBirth = document.getElementById("inputDateBirthRegistrationForm").value;

    var str = dateBirth;
    var year = str.split('-')[0];
    var month = str.split('-')[1];
    var day = str.split('-')[2];

    var dateUnix = date2timestamp(year, month, day, 0, 0, 0);

    if (isNaN(dateUnix)) {
        document.getElementById('inputDateBirthRegistrationForm').style.background = "#ffad99";
        document.getElementById('saveButtonRegistrationForm').setAttribute(
                'disabled', 'disabled');
        document.getElementById('saveButtonRegistrationForm').style.background = "rgb(186, 190, 193)";
    } else {
        document.getElementById('inputDateBirthRegistrationForm').style.background = "#fff";
        document.getElementById('saveButtonRegistrationForm').removeAttribute(
                'disabled');
        document.getElementById('saveButtonRegistrationForm').style.background = "rgb(41, 129, 202)";
    }

};

function showDisenablePanel() {

    document.getElementById('accountBtn').style.border = '1px solid rgb(97, 100, 103)';
    document.getElementById('accountBtn').style.backgroundColor = 'rgb(88, 95, 101)';

    document.getElementById('rentBtn').style.border = '1px solid rgb(97, 100, 103)';
    document.getElementById('rentBtn').style.backgroundColor = 'rgb(88, 95, 101)';

    document.getElementById('rentListBtn').style.border = '1px solid rgb(97, 100, 103)';
    document.getElementById('rentListBtn').style.backgroundColor = 'rgb(88, 95, 101)';

    document.getElementById('accountBtn').disabled = true;
    document.getElementById('rentBtn').disabled = true;
    document.getElementById('disanablePanel').style.display = "block";
};

function hideDisenablePanel() {

    document.getElementById('accountBtn').style.border = '1px solid rgb(41, 129, 202)';
    document.getElementById('accountBtn').style.backgroundColor = 'rgb(41, 129, 202)';

    document.getElementById('rentBtn').style.border = '1px solid rgb(185, 195, 85)';
    document.getElementById('rentBtn').style.backgroundColor = 'rgb(185, 195, 85)';

    document.getElementById('rentListBtn').style.border = '1px solid rgb(177, 105, 187)';
    document.getElementById('rentListBtn').style.backgroundColor = 'rgb(177, 105, 187)';

    document.getElementById('accountBtn').disabled = false;
    document.getElementById('rentBtn').disabled = false;
    document.getElementById('disanablePanel').style.display = "none";
};

function hideInformationPanel() {
    document.getElementById('alertPanel').style.display = "none";
};

function showInformationPanel(msg) {
    var massage = msg;
    document.getElementById('alertPanel').style.display = "block";
    document.getElementById('alertLblPanel').innerHTML = massage;
    showDisenablePanel();
    setTimeout(function () {
        hideInformationPanel();
        hideDisenablePanel();
    }, 1500);
};

function loadPanelControl() {
    document.getElementById('tablesPanel').style.display = "none";
};

// скрываем панель кконтроля
function loadWorkPanelHide() {
    document.getElementById('tablesPanelControl').style.display = "none";
};

// скрывваем панель книги аботники и открываем с контролем
function loadWorkPanel() {
    document.getElementById('tablesPanel').style.display = "none";
    document.getElementById('tablesPanelControl').style.display = "block";
    loadRegistrationBook();
    loadEmployeeIformation();
    loadBookIformation();

};

// показываем панель с книги, работники
function loadBookPanel() {
    document.getElementById("tablesPanel").style.display = "block";
    // documnet.getElementById('rentBtn').style.display = "block";
    // documnet.getElementById('lblCountRent').style.display = "block";
};

function loadEmployeePanel() {
    document.getElementById("tablesPanel").style.display = "block";
    // documnet.getElementById('rentBtn').style.display = "none";
    // documnet.getElementById('lblCountRent').style.display = "none";
};

function showPanelListRentingPanel() {
    document.getElementById("panelRentingList").style.display = "block";
};

function hideListRentinPanel() {
    hideDisenablePanel();
    document.getElementById("panelRentingList").style.display = "none";
};

function getListRentingCount() {
    $.ajax({
        url : urlServerBook,
        dataType : "json",
        data : {
            action : 'readAllRent'
        },
        error : function (message) {
        },
        success : function (data) {
            var arr = JSON.parse(JSON.stringify(data));
            var count = Object.keys(arr["allRentBooks"]).length;
            var countRents = document.getElementById("lblCountRent");
            countRents.innerHTML = "";
            countRents.innerHTML = count;
        }
    });

};

function getListRenting() {
    // /tablePanelRentingList
    showDisenablePanel();
    $
            .ajax({
                url : urlServerBook,
                dataType : "json",
                data : {
                    action : 'readAllRent'
                },
                error : function (message) {
                },
                success : function (data) {
                    var arr = JSON.parse(JSON.stringify(data));
                    var count = Object.keys(arr["allRentBooks"]).length;
                    var countRents = document.getElementById("lblCountRent");
                    countRents.innerHTML = "";
                    countRents.innerHTML = count;

                    var headStr = "";

                    var LANG = readCookie('LANG');

                    if (LANG == 'RU') {
                        var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">№</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">Дата</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">ФИО</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">Email</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">Книга</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\" colspan=\"3\" >Действие</td>"
                                + "</tr><tr>";
                    } else {
                        var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">Id</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">Date</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">Employee</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">Email</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">Book</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\" colspan=\"3\" >Action</td>"
                                + "</tr><tr>";
                    }

                    var footStr = "</tr></table>";

                    var bodyStr = "";

                    var a = 0;

                    for (var i = 0; i < count; i++) {

                        a = a + 1;

                        bodyStr = bodyStr
                                + "<tr><td style=\"text-align: right;\">" + a
                                + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"text-align: right;\">"
                                + unixtimetodate(arr["allRentBooks"][i]["dateOnRenting"])
                                + "</td>";

                        bodyStr = bodyStr + "<td style=\"text-align: left;\">"
                                + arr["allRentBooks"][i]["nameEmployee"]
                                + "</td>";

                        bodyStr = bodyStr + "<td style=\"text-align: left;\">"
                                + arr["allRentBooks"][i]["emailEmployee"]
                                + "</td>";

                        bodyStr = bodyStr + "<td style=\"text-align: left;\">"
                                + arr["allRentBooks"][i]["nameBook"] + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"width: 50px\"><button id=YesRent-"
                                + arr["allRentBooks"][i]["idRent"]
                                + " onClick=\"\" class=\"editBtnRow\">Yes</button></td>";
                        bodyStr = bodyStr
                                + "<td style=\"width: 50px\"><button id=NoRent-"
                                + arr["allRentBooks"][i]["idRent"]
                                + "-"
                                + arr["allRentBooks"][i]["emailEmployee"]
                                + "-"
                                + arr["allRentBooks"][i]["dateOnRenting"]
                                + "-"
                                + arr["allRentBooks"][i]["nameBook"]
                                + "-"
                                + " onClick=\"noAnswerRenting();\" class=\"deleteBtnRow\">No</button></td>";
                    }

                    var table = headStr + bodyStr + footStr;
                    document.getElementById("tablePanelRentingList").innerHTML = table;

                }
            });
    try {
        showPanelListRentingPanel();
    } catch (err) {
        // //
    }
};

function noAnswerRenting() {

    var str = event.target.id;
    var strAction = str.split('-')[0];
    var strId = str.split('-')[1];

    var emailEmployee = str.split('-')[2];
    var dateOnEmployee = str.split('-')[3];
    var bookName = str.split('-')[4];

    var dataNoAnswer = {
        action : 'answerRenting',
        idRenting : strId,
        emailEmployee : emailEmployee,
        dateOnEmployee : dateOnEmployee,
        bookName : bookName
    };

    $
            .ajax({
                url : urlServerBookEmployee,
                dataType : "json",
                data : dataNoAnswer,
                error : function (message) {
                    showInformationPanel("A letter about the book order information was sent.");
                    getListRenting();
                },
                success : function (data) {
                    showInformationPanel("A letter about the book order information was sent.");
                    getListRenting();
                }
            });

    getListRenting();
};

function loadRegistrationBook() {

    $
            .ajax({
                url : urlServerBook,
                dataType : "json",
                data : {
                    action : 'issueBookReport'
                },
                error : function (message) {
                },
                success : function (data) {
                    document.getElementById("panelTableRegistrationBook").innerHTML = table;
                    var arr = JSON.parse(JSON.stringify(data));
                    var count = Object.keys(arr["issueBook"]).length;

                    var headStr = "";

                    var LANG = readCookie('LANG');

                    if (LANG == 'RU') {
                        var headStr = "<table id=\"tabResponse\" class=\"tableRegistration\"><tr>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">№</td>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Читатель</td>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Книга</td>"
                                + "<td colspan=\"3\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Регистрация</td>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Действия</td>"
                                + "</tr>"
                                + "<tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">*</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">С</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">КОД</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">ФИО</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">КОД</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Название</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Дата</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Воврат</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Дни</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Откр.</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Отпр.</td>"
                                + "</tr>";
                    } else {
                        var headStr = "<table id=\"tabResponse\" class=\"tableRegistration\"><tr>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">*</td>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Employee</td>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Book</td>"
                                + "<td colspan=\"3\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Data registration</td>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Action</td>"
                                + "</tr>"
                                + "<tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">#</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">S</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Id</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Name</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Id</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Brief</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Issue</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Return</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Day</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">View</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Email</td>"
                                + "</tr>";
                    }

                    var footStr = "</tr></table>";

                    var bodyStr = "";
                    for (var i = 0; i < count; i++) {

                        var countRow = i + 1;

                        var dateOn = unixtimetodate(arr["issueBook"][i]["dateOn"]);

                        if (arr["issueBook"][i]["dateOff"] == 0) {
                            dateOff = "";
                        } else {
                            var dateOff = unixtimetodate(arr["issueBook"][i]["dateOff"]);
                            var daysNormal = parseInt((dateOff - dateOn) / 86400);
                        }

                        var toDay = Math.round(new Date().getTime() / 1000);
                        var countDay = toDay - arr["issueBook"][i]["dateOn"];

                        var t = parseInt(countDay);
                        var days = parseInt(t / 86400);

                        bodyStr = bodyStr
                                + "<tr><td style=\"text-align: right; width: 50px;\">"
                                + countRow + "</td>";
                        // + arr["issueBook"][i]["idIssue"] + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"text-align: center; width: 10px;\"><img src=\"img/"
                                + arr["issueBook"][i]["status"]
                                + ".png\" class=\"statusPng\"></td>";

                        bodyStr = bodyStr
                                + "<td style=\"text-align: right; width: 50px;\">"
                                + arr["issueBook"][i]["idEmployee"] + "</td>";

                        bodyStr = bodyStr + "<td>"
                                + arr["issueBook"][i]["nameEmployee"] + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"text-align: right; width: 50px;\">"
                                + arr["issueBook"][i]["idBook"] + "</td>";

                        bodyStr = bodyStr + "<td>"
                                + arr["issueBook"][i]["nameBook"] + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"text-align: center; width: 50px;\">"
                                + dateOn + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"text-align: center; width: 50px;\">"
                                + dateOff + "</td>";

                        var status = arr["issueBook"][i]["status"];
                        if (status = "true" && dateOff != "") {

                            bodyStr = bodyStr
                                    + "<td style=\"text-align: center; width: 50px;\">"
                                    + arr["issueBook"][i]["countDay"] + "</td>";

                            // btn view
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"><button id=viewBtnEmployeeBook-"
                                    + arr["issueBook"][i]["idIssue"]
                                    + " onClick=\"editRegistrationBook();\" class=\"viewBtnEmployeeBook\">view</button></td>";

                            // btn email
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"></td>";

                        } else if (status = "false" && days > 10) {
                            bodyStr = bodyStr
                                    + "<td style=\"text-align: center; width: 50px; color: #fff; background-color: rgb(232, 95, 76);\" class=\"garientCountDay\">"
                                    + arr["issueBook"][i]["countDay"] + "</td>";

                            // btn view
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"><button id=viewBtnEmployeeBook-"
                                    + arr["issueBook"][i]["idIssue"]
                                    + " onClick=\"editRegistrationBook();\" class=\"viewBtnEmployeeBook\">view</button></td>";

                            var dateOn = arr["issueBook"][i]["dateOn"];
                            var idBook = arr["issueBook"][i]["idBook"];
                            var idEmployee = arr["issueBook"][i]["idEmployee"];
                            var nameBook = arr["issueBook"][i]["nameBook"];
                            var nameEmployee = arr["issueBook"][i]["nameEmployee"];
                            var status = arr["issueBook"][i]["status"];

                            var txt = dateOff + "/" + dateOn + "/" + idBook
                                    + "/" + idEmployee + "/" + nameBook + "/"
                                    + nameEmployee + "/" + status;

                            // btn email
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"><button id=emailBtnEmployeeBook-"
                                    + arr["issueBook"][i]["idEmployee"]
                                    + " onClick=\"sendEmail();\" value=\""
                                    + txt
                                    + "\" class=\"emailBtnEmployeeBook\">email</button></td>";

                        } else if (status = "false" && days < 10) {
                            bodyStr = bodyStr
                                    + "<td style=\"text-align: center; width: 50px;\">"
                                    + days + "</td>";

                            // btn view
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"><button id=viewBtnEmployeeBook-"
                                    + arr["issueBook"][i]["idIssue"]
                                    + " onClick=\"editRegistrationBook();\" class=\"viewBtnEmployeeBook\">view</button></td>";

                            // btn email
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"></td>";
                        }

                    }
                    var table = headStr + bodyStr + footStr;
                    document.getElementById("panelTableRegistrationBook").innerHTML = table;
                }
            });
};

function sendEmail() {
    var str = event.target.id;
    var strAction = str.split('-')[0];
    var strId = str.split('-')[1];
    var valueAlt = document.getElementById(str).value;
    $.ajax({
        url : urlServerServices,
        dataType : "json",
        data : {
            action : 'sendEmail',
            value : valueAlt
        },
        error : function (message) {
        },
        success : function (data) {
            var arr = JSON.parse(JSON.stringify(data));
        }
    });

    var LANG = readCookie('LANG');

    if (LANG == 'RU') {
        showInformationPanel(RU_LANGUAGE['MSG_SEND_LETTER']);
    } else {
        showInformationPanel(EN_LANGUAGE['MSG_SEND_LETTER']);
    }

};

function loadBookIformation() {
    // $("#bookRegPanel").remove();
    $.ajax({
        url : urlServerBook,
        dataType : "json",
        data : {
            action : 'readAllBooks'
        },
        error : function (message) {
        },
        success : function (data) {
            var arr = JSON.parse(JSON.stringify(data));
            var count = Object.keys(arr["books"]).length;
            for (var i = 0; i < count; i++) {
                $("#bookRegPanel").append(
                        '<option value="' + arr["books"][i]["brief"]
                                + '" data-status="' + arr["books"][i]["id"]
                                + '" selected="selected">'
                                + arr["books"][i]["id"] + '</option>');
            }
        }
    });
};

function loadEmployeeIformation() {
    // $("#employeeRegPanel").remove();
    $.ajax({
        url : urlServerEmployee,
        dataType : "json",
        data : {
            action : 'readAllEmployee'
        },
        error : function (message) {
        },
        success : function (data) {
            var arr = JSON.parse(JSON.stringify(data));
            var count = Object.keys(arr["employee"]).length;
            for (var i = 0; i < count; i++) {
                $("#employeeRegPanel").append(
                        '<option value="' + arr["employee"][i]["name"]
                                + '" data-status="' + arr["employee"][i]["id"]
                                + '" selected="selected">'
                                + arr["employee"][i]["id"] + '</option>');
            }
        }
    });
};

function editRegistrationBook() {

    document.getElementById('saveBtnRegRegistration').style.border = '1px solid rgb(97, 100, 103)';
    document.getElementById('saveBtnRegRegistration').style.backgroundColor = 'rgb(88, 95, 101)';
    document.getElementById('saveBtnRegRegistration').disabled = true;

    showDisenablePanel();

    var str = event.target.id;
    var strAction = str.split('-')[0];
    var strId = str.split('-')[1];

    document.getElementById("panelAddRegRegistration").style.display = "block";
    document.getElementById("lblStatusRegRegistration").innerHTML = "status: modified issue #"
            + strId;
    idEditIssue = strId;
    document.getElementById("selectEmployeeRegInput").setAttribute('readonly',
            'readonly');
    document.getElementById("selectBookRegInput").setAttribute('readonly',
            'readonly');
    document.getElementById("selectRegDateOn").setAttribute('readonly',
            'readonly');
    document.getElementById("selectRegDateOff").style.display = "block";
    document.getElementById("dateOffRegBookLabel").style.display = "block";

    var dateSelect = {
        action : 'issueBookFindRow',
        idIssue : strId
    };
    $
            .ajax({
                url : urlServerBook,
                dataType : "json",
                data : dateSelect,
                error : function (message) {
                    loadRegistrationBook();
                },
                success : function (data) {
                    var arr = JSON.parse(JSON.stringify(data));
                    document.getElementById("selectEmployeeRegInput").value = arr["issueBookFindRow"][0]["nameEmployee"];
                    document.getElementById("selectBookRegInput").value = arr["issueBookFindRow"][0]["nameBook"];
                    document.getElementById("selectRegDateOn").value = unixtimetodateDateBirth(arr["issueBookFindRow"][0]["dateOn"]);

                    var notNull = arr["issueBookFindRow"][0]["dateOff"];
                    if (notNull == 0) {
                        document.getElementById("selectRegDateOff").value = unixtimetodateDateBirth(Math
                                .round(new Date().getTime() / 1000.0));
                    } else {
                        document.getElementById("selectRegDateOff").value = unixtimetodateDateBirth(arr["issueBookFindRow"][0]["dateOff"]);
                    }

                    loadRegistrationBook();
                }
            });
};

function showAddRegistrationPanel() {

    showDisenablePanel();

    var str = event.target.id;
    var strAction = str.split('-')[0];
    var strId = str.split('-')[1];

    document.getElementById("panelAddRegRegistration").style.display = "block";
    document.getElementById("lblStatusRegRegistration").innerHTML = "status: new issue";

    document.getElementById("selectEmployeeRegInput").value = "";
    document.getElementById("selectBookRegInput").value = "";

    document.getElementById("selectEmployeeRegInput").removeAttribute(
            "readonly");
    document.getElementById("selectBookRegInput").removeAttribute("readonly");
    document.getElementById("selectRegDateOn").removeAttribute("readonly");
    document.getElementById("selectRegDateOff").style.display = "none";
    document.getElementById("dateOffRegBookLabel").style.display = "none";

    document.getElementById('saveBtnRegRegistration').style.border = '1px solid rgb(97, 100, 103)';
    document.getElementById('saveBtnRegRegistration').style.backgroundColor = 'rgb(88, 95, 101)';
    document.getElementById('saveBtnRegRegistration').disabled = true;

};

function getFilterRegRegistration(simbol) {
    var nameEmployyInput = simbol;
    var dateToFilter = {
        action : 'filterIssue',
        text : nameEmployyInput
    };
    $
            .ajax({
                url : urlServerBook,
                dataType : "json",
                data : dateToFilter,
                error : function (message) {
                },
                success : function (data) {
                    document.getElementById("panelTableRegistrationBook").innerHTML = table;
                    var arr = JSON.parse(JSON.stringify(data));
                    var count = Object.keys(arr["issueBookFilter"]).length;

                    var headStr = "";

                    var LANG = readCookie('LANG');

                    if (LANG == 'RU') {
                        var headStr = "<table id=\"tabResponse\" class=\"tableRegistration\"><tr>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">№</td>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Читатель</td>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Книга</td>"
                                + "<td colspan=\"3\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Регистрация</td>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Действия</td>"
                                + "</tr>"
                                + "<tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">*</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">С</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">КОД</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">ФИО</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">КОД</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Название</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Дата</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Воврат</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Дни</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Откр.</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Отпр.</td>"
                                + "</tr>";
                    } else {
                        var headStr = "<table id=\"tabResponse\" class=\"tableRegistration\"><tr>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">*</td>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Employee</td>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Book</td>"
                                + "<td colspan=\"3\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Data registration</td>"
                                + "<td colspan=\"2\" style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Action</td>"
                                + "</tr>"
                                + "<tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">#</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">S</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Id</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Name</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Id</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Brief</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Issue</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Return</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Day</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">View</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; border-color: #fff;\">Email</td>"
                                + "</tr>";
                    }

                    var footStr = "</tr></table>";

                    var bodyStr = "";
                    for (var i = 0; i < count; i++) {

                        var dateOn = unixtimetodate(arr["issueBookFilter"][i]["dateOn"]);

                        if (arr["issueBookFilter"][i]["dateOff"] == 0) {
                            dateOff = "";
                        } else {
                            var dateOff = unixtimetodate(arr["issueBookFilter"][i]["dateOff"]);
                            var daysNormal = parseInt((dateOff - dateOn) / 86400);
                        }

                        var toDay = Math.round(new Date().getTime() / 1000);
                        var countDay = toDay
                                - arr["issueBookFilter"][i]["dateOn"];

                        var t = parseInt(countDay);
                        var days = parseInt(t / 86400);

                        bodyStr = bodyStr
                                + "<tr><td style=\"text-align: right; width: 50px;\">"
                                + arr["issueBookFilter"][i]["idIssue"]
                                + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"text-align: center; width: 10px;\"><img src=\"img/"
                                + arr["issueBookFilter"][i]["status"] // /////
                                + ".png\" class=\"statusPng\"></td>";

                        bodyStr = bodyStr
                                + "<td style=\"text-align: right; width: 50px;\">"
                                + arr["issueBookFilter"][i]["idEmployee"]
                                + "</td>";

                        bodyStr = bodyStr + "<td>"
                                + arr["issueBookFilter"][i]["nameEmployee"]
                                + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"text-align: right; width: 50px;\">"
                                + arr["issueBookFilter"][i]["idBook"] + "</td>";

                        bodyStr = bodyStr + "<td>"
                                + arr["issueBookFilter"][i]["nameBook"]
                                + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"text-align: center; width: 50px;\">"
                                + dateOn + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"text-align: center; width: 50px;\">"
                                + dateOff + "</td>";

                        var status = arr["issueBookFilter"][i]["status"]; // ////
                        if (status = "true" && dateOff != "") {

                            bodyStr = bodyStr
                                    + "<td style=\"text-align: center; width: 50px;\">"
                                    + arr["issueBookFilter"][i]["countDay"]
                                    + "</td>";

                            // btn view
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"><button id=viewBtnEmployeeBook-"
                                    + arr["issueBookFilter"][i]["idIssue"]
                                    + " onClick=\"editRegistrationBook();\" class=\"viewBtnEmployeeBook\">view</button></td>";

                            // btn email
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"></td>";

                        } else if (status = "false" && days > 10) {
                            bodyStr = bodyStr
                                    + "<td style=\"text-align: center; width: 50px; color: #fff; background-color: rgb(232, 95, 76);\" class=\"garientCountDay\">"
                                    + arr["issueBookFilter"][i]["countDay"]
                                    + "</td>";

                            // btn view
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"><button id=viewBtnEmployeeBook-"
                                    + arr["issueBookFilter"][i]["idIssue"]
                                    + " onClick=\"editRegistrationBook();\" class=\"viewBtnEmployeeBook\">view</button></td>";

                            var dateOn = arr["issueBookFilter"][i]["dateOn"];
                            var idBook = arr["issueBookFilter"][i]["idBook"];
                            var idEmployee = arr["issueBookFilter"][i]["idEmployee"];
                            var nameBook = arr["issueBookFilter"][i]["nameBook"];
                            var nameEmployee = arr["issueBookFilter"][i]["nameEmployee"];
                            var status = arr["issueBookFilter"][i]["statusReturn"];

                            var txt = dateOff + "/" + dateOn + "/" + idBook
                                    + "/" + idEmployee + "/" + nameBook + "/"
                                    + nameEmployee + "/" + status;

                            // btn email
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"><button id=emailBtnEmployeeBook-"
                                    + arr["issueBookFilter"][i]["idEmployee"]
                                    + " onClick=\"sendEmail();\" value=\""
                                    + txt
                                    + "\" class=\"emailBtnEmployeeBook\">email</button></td>";

                        } else if (status = "false" && days < 10) {
                            bodyStr = bodyStr
                                    + "<td style=\"text-align: center; width: 50px;\">"
                                    + days + "</td>";

                            // btn view
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"><button id=viewBtnEmployeeBook-"
                                    + arr["issueBookFilter"][i]["idIssue"]
                                    + " onClick=\"editRegistrationBook();\" class=\"viewBtnEmployeeBook\">view</button></td>";

                            // btn email
                            bodyStr = bodyStr
                                    + "<td style=\"width: 50px\"></td>";
                        }

                    }
                    var table = headStr + bodyStr + footStr;
                    document.getElementById("panelTableRegistrationBook").innerHTML = table;
                }
            });
};

function clearRegRegistrationFilter() {
    loadRegistrationBook();
    document.getElementById("searchRegRegistration").value = "";
};

function cancelRegRegistrationFilter() {
    showInformationPanel("The registration of the issuance of the book wasn't saved.");
    document.getElementById("panelAddRegRegistration").style.display = "none";
};

function saveRegRegistrationFilter(idIssueForUpdate) {

    var shownValEmployee = document.getElementById("selectEmployeeRegInput").value;
    var strEmployee = document.querySelector("#employeeRegPanel option[value='"
            + shownValEmployee + "']");
    var idEmployee = strEmployee.getAttribute('data-status');
    var nameEmployee = document.getElementById("selectEmployeeRegInput").value;
    var shownValBook = document.getElementById("selectBookRegInput").value;
    var strBook = document.querySelector("#bookRegPanel option[value='"
            + shownValBook + "']");
    var idBook = strBook.getAttribute('data-status');
    var nameBookEmployee = document.getElementById("selectBookRegInput").value;
    var dateOn = getUnixTimeStamp(document.getElementById("selectRegDateOn").value);
    var dateOff = getUnixTimeStamp(document.getElementById("selectRegDateOff").value);

    var statusModifed = document.getElementById("lblStatusRegRegistration").innerHTML;
    if (statusModifed == "status: new issue") {
        var dateCreate = {
            action : 'createEmployeeBook',
            idEmployee : idEmployee,
            idBook : idBook,
            dateOn : dateOn,
            dateOff : 0,
            status : "false"
        };
        $.ajax({
            url : urlServerBookEmployee,
            dataType : "json",
            data : dateCreate,
            error : function (message) {
                loadRegistrationBook();
            },
            success : function (data) {
                loadRegistrationBook();
            }
        });
        loadRegistrationBook();
        showInformationPanel("The registration of the issuance of the book was saved.");
    } else {
        var dateReturn = getUnixTimeStamp(document
                .getElementById("selectRegDateOff").value);
        var dateUpdate = {
            action : 'updateBook', // ????????????????????????
            idIssue : idEditIssue,
            dateReturn : dateReturn,
            status : "true"
        };
        $.ajax({
            url : urlServerBookEmployee,
            dataType : "json",
            data : dateUpdate,
            error : function (message) {
                loadRegistrationBook();
            },
            success : function (data) {
                loadRegistrationBook();
            }
        });
        loadRegistrationBook();
        showInformationPanel("The registration of the issuance of the book was saved.");
    }
    document.getElementById("panelAddRegRegistration").style.display = "none";
};

function getUnixTimeStamp(dateStr) {
    var year = dateStr.split('-')[0];
    var month = dateStr.split('-')[1];
    var day = dateStr.split('-')[2];
    var dateUnix = date2timestamp(year, month, day, 0, 0, 0);
    return dateUnix;
};

function getListEmployee() {

    loadWorkPanelHide()
    loadEmployeePanel();

    document.getElementById("addDtn").style.display = "none";

    $
            .ajax({
                url : urlServerEmployee,
                dataType : "json",
                data : {
                    action : 'readAllEmployee'
                },
                error : function (message) {
                },
                success : function (data) {
                    document.getElementById("blockTable").innerHTML = lblListEmployee;
                    var arr = JSON.parse(JSON.stringify(data));

                    var count = Object.keys(arr["employee"]).length;
                    document.getElementById("respServlet").innerHTML = "";

                    var colRowForPaging = 20;
                    var countBtn = count / colRowForPaging;

                    if (Math.round(countBtn) == 0) {
                        var panelPaginig = document.getElementById('paging');
                        var divsStart = "<div class=\"btnNextRows\" onClick=\"allEmployee();\">*</div>";
                        var divsBlock = "";
                        var divsEnd = "<div class=\"btnNextRows\">»</div>";
                        var divTotal = "<div id=\"btnTotalRows\" class=\"btnTotalRows\">"
                                + count + fromLbl + count + "</div>";
                        document.getElementById('paging').innerHTML = ""
                                + divTotal;
                    } else {

                        var panelPaginig = document.getElementById('paging');
                        var divsStart = "<div class=\"btnNextRows\" onClick=\"allEmployee();\">«</div>";
                        var divsBlock = "";
                        var divsEnd = "<div class=\"btnNextRows\">»</div>";
                        var divTotal = "<div id=\"btnTotalRows\" class=\"btnTotalRows\">"
                                + count + fromLbl + count + "</div>";

                        for (var i = 1; i < Math.round(countBtn) + 1; i++) {
                            divsBlock = divsBlock
                                    + "<div onClick=\"showPageCount("
                                    + i
                                    + ", "
                                    + count
                                    + ");\" class=\"btnNextRows\" value=\"btnPaging-"
                                    + i + "\">" + i + "</div>";
                        }

                        document.getElementById('paging').innerHTML = divsStart
                                + divsBlock + divsEnd + divTotal;

                    }

                    var headStr = "";

                    var LANG = readCookie('LANG');

                    if (LANG == 'RU') {
                        var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                + "<td style=\"text-align: center; background: #39b54a; width: 50px; color: #fff\">№</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">ФИО</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 90px;\">Дата рожд.</td>"
                                + "<td style=\"text-align: center;  background: #39b54a; width: 250px; color: #fff\">Email</td>"
                                + "<td  style=\"text-align: center;  background: #39b54a;  color: #fff\" colspan=\"3\" >Дейст.</td>"
                                + "</tr><tr>";
                    } else {
                        var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                + "<td style=\"text-align: center; background: #39b54a; width: 50px; color: #fff\">Id</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Name</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 90px;\">Date of birth</td>"
                                + "<td style=\"text-align: center;  background: #39b54a; width: 250px; color: #fff\">Email</td>"
                                + "<td  style=\"text-align: center;  background: #39b54a;  color: #fff\" colspan=\"3\" >Action</td>"
                                + "</tr><tr>";
                    }

                    var footStr = "</tr></table>";

                    var bodyStr = "";
                    for (var i = 0; i < count; i++) {

                        var date = arr["employee"][i]["dateBirth"];
                        var newDate = unixtimetodate(date);

                        bodyStr = bodyStr
                                + "<tr><td style=\"text-align: right;\">"
                                + arr["employee"][i]["id"] + "</td>";
                        bodyStr = bodyStr + "<td>"
                                + "<a href=\"javascript:countBookEmployee("
                                + arr["employee"][i]["id"] + ")\">"
                                + arr["employee"][i]["name"] + "</a>" + "</td>";
                        bodyStr = bodyStr + "<td style=\"text-align: right;\">"
                                + newDate + "</td>";
                        bodyStr = bodyStr + "<td>"
                                + arr["employee"][i]["email"] + "</td>";

                        // bodyStr = bodyStr
                        // + "<td style=\"width: 50px\"><button id=editBtn-"
                        // + arr["employee"][i]["id"]
                        // + " onClick=\"getIdElementClickEmployeeEdit();\"
                        // + "class=\"editBtnRow\">edit</button></td>";

                        bodyStr = bodyStr
                                + "<td style=\"width: 50px\"><button id=deleteBtn-"
                                + arr["employee"][i]["id"]
                                + " onClick=\"deleeEmployById();\" class=\"deleteBtnRow\">delete</button></td>";

                    }
                    var table = headStr + bodyStr + footStr;
                    document.getElementById("respServlet").innerHTML = table;
                }
            });
};

function showPageCount(i, count) {

    var countRound = Math.round(count / 20);

    var d = [];
    var a = 20;
    var b = 20;

    for (j = 0; j < countRound; j++) {
        d[j] = [ j + 1, a + 1, a + b ];
        a = a + 20;
    }

    d.unshift([ 0, 0, 20 ]);

    var start = d[i - 1][1];
    var end = d[i - 1][2];
    console.log(start + " " + end);

    if (start == 0) {
        var total = document.getElementById('btnTotalRows');
        total.innerHTML = 'from ' + 1 + ' to ' + end;
    } else {
        var total = document.getElementById('btnTotalRows');
        total.innerHTML = 'from ' + start + ' to ' + end;
    }

    var pageBook = {
        action : 'bookPage',
        start : start,
        end : end
    };

    $
            .ajax({
                url : urlServerBook,
                dataType : "json",
                data : pageBook,
                error : function (message) {
                },
                success : function (data) {
                    document.getElementById("blockTable").innerHTML = lblListBook;
                    var arr = JSON.parse(JSON.stringify(data));

                    var count = Object.keys(arr["pages"]).length;

                    document.getElementById("respServlet").innerHTML = "";

                    var headStr = "";

                    var LANG = readCookie('LANG');

                    if (LANG == 'RU') {
                        var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff\">№</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Название</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 100px;\">Год</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Автор</td>"
                                + "<td  style=\"text-align: center;  background: #39b54a;  color: #fff\" colspan=\"3\" >Действие</td>"
                                + "</tr><tr>";
                    } else {
                        var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff\">Id</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Brief</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 100px;\">Publish year</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Author</td>"
                                + "<td  style=\"text-align: center;  background: #39b54a;  color: #fff\" colspan=\"3\" >Action</td>"
                                + "</tr><tr>";
                    }

                    var footStr = "</tr></table>";

                    var bodyStr = "";
                    for (var i = 0; i < count; i++) {

                        $("#autiorList").append(
                                '<option value="' + arr["pages"][i]["author"]
                                        + '" selected="selected">'
                                        + arr["pages"][i]["author"]
                                        + '</option>');

                        var value = value + arr["pages"][i]["brief"];

                        bodyStr = bodyStr
                                + "<tr><td style=\"text-align: right;\">"
                                + arr["pages"][i]["id"] + "</td>";
                        bodyStr = bodyStr + "<td>" + arr["pages"][i]["brief"]
                                + "</td>";
                        bodyStr = bodyStr + "<td style=\"text-align: right;\">"
                                + arr["pages"][i]["publishYear"] + "</td>";
                        bodyStr = bodyStr + "<td>" + arr["pages"][i]["author"]
                                + "</td>";
                        bodyStr = bodyStr
                                + "<td style=\"width: 50px\"><button id=viewBtn-"
                                + arr["pages"][i]["id"]
                                + " onClick=\"viewBookInfo();\" class=\"viewBtnRow\">view</button></td>";
                        bodyStr = bodyStr
                                + "<td style=\"width: 50px\"><button id=editBtn-"
                                + arr["pages"][i]["id"]
                                + " onClick=\"getElementIdClickBookEdit();\" class=\"editBtnRow\">edit</button></td>";
                        bodyStr = bodyStr
                                + "<td style=\"width: 50px\"><button id=deleteBtn-"
                                + arr["pages"][i]["id"]
                                + " onClick=\"deleebookById();\" class=\"deleteBtnRow\">delete</button></td>";

                    }
                    var table = headStr + bodyStr + footStr;
                    document.getElementById("respServlet").innerHTML = table;
                }
            });

};

function countBookEmployee(idEmployee) {
    // alert(idEmployee);
    // selectReadBooks

    var readBook = {
        action : 'selectReadBooks',
        idEmployee : idEmployee
    };

    console.log(readBook);

    $
            .ajax({
                url : urlServerBook,
                dataType : "json",
                data : readBook,
                error : function (message) {
                },
                success : function (data) {

                    getEmployeeByIdReadBook(idEmployee);

                    var arr = JSON.parse(JSON.stringify(data));
                    var count = Object.keys(arr["readBooks"]).length;

                    if (count == 0) {
                        showInformationPanel("The user has not read any books yet.");
                        console.log(arr);
                    } else {
                        showDisenablePanel();
                        var panel = document.getElementById('panelReadBook');
                        panel.style.display = "block";

                        var totalReadBook = document
                                .getElementById('totalReadBook');
                        totalReadBook.innerHTML = totalLbl + count;

                        console.log(arr);
                        var headStr = "";

                        var LANG = readCookie('LANG');

                        if (LANG == 'RU') {
                            var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                    + "<td style=\"text-align: center; background: #39b54a; color: #fff; width: 45px;\">№</td>"
                                    + "<td style=\"text-align: center; background: #39b54a; color: #fff; \">Название</td>"
                                    + "<td style=\"text-align: center; background: #39b54a; color: #fff; width: 80px;\">Дата</td>"
                                    + "</tr><tr>";
                        } else {
                            var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                    + "<td style=\"text-align: center; background: #39b54a; color: #fff; width: 45px;\">#</td>"
                                    + "<td style=\"text-align: center; background: #39b54a; color: #fff; \">Name book</td>"
                                    + "<td style=\"text-align: center; background: #39b54a; color: #fff; width: 80px;\">Date issue</td>"
                                    + "</tr><tr>";
                        }

                        var footStr = "</tr></table>";

                        var bodyStr = "";
                        var a = 0;
                        for (var i = 0; i < count; i++) {
                            a++;
                            bodyStr = bodyStr
                                    + "<tr><td style=\"text-align: right;\">"
                                    + a + "</td>";

                            bodyStr = bodyStr
                                    + "<td style=\"text-align: left;\">"
                                    + arr["readBooks"][i]["nameBook"] + "</td>";

                            bodyStr = bodyStr
                                    + "<td style=\"text-align: center;\">"
                                    + unixtimetodate(arr["readBooks"][i]["dateOn"])
                                    + "</td>";

                        }

                        var table = headStr + bodyStr + footStr;
                        document.getElementById("panelReadBookTable").innerHTML = table;

                    }

                }
            });
};

function getEmployeeByIdReadBook(idEmployee) {

    var textSearch = idEmployee;

    $.ajax({
        url : urlServerEmployee,
        dataType : "json",
        data : {
            action : 'findEmployee',
            text : textSearch
        },
        error : function (message) {
        },
        success : function (data) {
            var arr = JSON.parse(JSON.stringify(data));
            var nameEmployee = arr["employee"][0]["name"];

            var LANG = readCookie('LANG');

            if (LANG == 'RU') {
                var labelPanel = document.getElementById('panelReadBookLabl');
                labelPanel.innerHTML = 'Список книг, прочитанных "'
                        + nameEmployee + '".';
            } else {
                var labelPanel = document.getElementById('panelReadBookLabl');
                labelPanel.innerHTML = 'The list of books read by "'
                        + nameEmployee + '".';
            }

        }
    });

};

function closeReadBookPanel() {
    var panel = document.getElementById('panelReadBook');
    panel.style.display = "none";
    hideDisenablePanel();
};

function unixtimetodate(date) {
    var theDate = date;
    var timestamp = moment.unix(theDate);
    return timestamp.format("DD.MM.YYYY");
};

function showListRentingBookEmployee() {

    var ratingBook = {
        action : 'selectBookRentEmployee',
        idEmployee : userIdRenting
    };

    console.log(ratingBook);

    $
            .ajax({
                url : urlServerBookEmployee,
                dataType : "json",
                data : ratingBook,
                error : function (message) {
                },
                success : function (data) {
                    var arr = JSON.parse(JSON.stringify(data));
                    var count = Object.keys(arr["allRentBooksEmployee"]).length;
                    console.log(arr);
                    var headStr = "";

                    var LANG = readCookie('LANG');

                    if (LANG == 'RU') {
                        var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; width: 45px;\">№</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; width: 80px;\">Дата</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">Название</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">Действие</td>"
                                + "</tr><tr>";
                    } else {
                        var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; width: 45px;\">Id</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff; width: 80px;\">Date</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">Book</td>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff;\">Action</td>"
                                + "</tr><tr>";
                    }

                    var footStr = "</tr></table>";

                    var bodyStr = "";

                    for (var i = 0; i < count; i++) {

                        bodyStr = bodyStr
                                + "<tr><td style=\"text-align: right;\">"
                                + arr["allRentBooksEmployee"][i]["idRent"]
                                + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"text-align: right;\">"
                                + unixtimetodate(arr["allRentBooksEmployee"][i]["dateOnRenting"])
                                + "</td>";

                        bodyStr = bodyStr + "<td style=\"text-align: left;\">"
                                + arr["allRentBooksEmployee"][i]["nameBook"]
                                + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"width: 50px\"><button id=Rent-"
                                + arr["allRentBooksEmployee"][i]["idRent"]
                                + " onClick=\"deleteRentFromEmployeeRentingPanel();\" class=\"deleteBtnRow\">Delete</button></td>";
                    }

                    var table = headStr + bodyStr + footStr;
                    document.getElementById("tablePanelRentingList").innerHTML = table;
                }
            });
    try {
        showPanelListRentingPanel();
    } catch (err) {
        // //
    }

};

function deleteRentFromEmployeeRentingPanel() {

    var str = event.target.id;
    var strAction = str.split('-')[0];
    var strId = str.split('-')[1];

    var dataDeleteBookRenting = {
        action : 'deleteRentingBookEmployee',
        idRent : strId
    };

    console.log(dataDeleteBookRenting);

    $.ajax({
        url : urlServerBookEmployee,
        dataType : "json",
        type : "GET",
        data : dataDeleteBookRenting,
        error : function (message) {
            showInformationPanel("The renting book has been deleted.");
        },
        success : function (data) {
            showInformationPanel("The renting book has been deleted.");
        }
    });
    showInformationPanel("The renting book has been deleted.");

    showListRentingBookEmployee();

};

function showFormPanelAccount() {
    document.getElementById("accountPanel").style.display = "block";
    showDisenablePanel();
    var dataForFindEmployee = {
        action : 'selectAccountEmployeeId',
        idEmployee : userIdRenting
    };

    $
            .ajax({
                url : urlServerBook,
                dataType : "json",
                type : "GET",
                data : dataForFindEmployee,
                error : function (message) {
                },
                success : function (data) {
                    var arr = JSON.parse(JSON.stringify(data));
                    var photo = arr["account"][0]["photoEmployee"];

                    if (photo == "") {
                        document.getElementById("backgroundAccountImage").src = "img/NoPhotoEmployee.png";
                        document.getElementById("accountPhotoImage").src = "img/NoPhotoEmployee.png";
                        document.getElementById("userImg").src = "img/NoPhotoEmployee.png";
                    } else {
                        document.getElementById("backgroundAccountImage").src = photo;
                        document.getElementById("accountPhotoImage").src = photo;
                        document.getElementById("userImg").src = photo;
                    }

                    document.getElementById("fullNameAccountField").value = arr["account"][0]["name"];
                    document.getElementById("emailAccountField").value = arr["account"][0]["email"];
                    document.getElementById("dateBirthAccountField").value = unixtimetodateDateBirth(arr["account"][0]["dateBirth"]);
                    document.getElementById("tellAccountField").value = arr["account"][0]["tellNumber"];
                }
            });
};

function loadImagePhotoAccount() {
    var preview = document.getElementById('accountPhotoImage');
    var backPhoto = document.getElementById('backgroundAccountImage');
    var imgUserOnHeader = document.getElementById('userImg');

    var file = document.getElementById('loadPhotoAccount').files[0];
    var reader = new FileReader();

    reader.onloadend = function () {
        preview.src = reader.result;
        backPhoto.src = reader.result;
        getEncodephoto = reader.result;
        imgUserOnHeader = reader.result;
    }

    if (file) {
        reader.readAsDataURL(file);
    } else {
        preview.src = "";
        backPhoto.src = "";
        imgUserOnHeader = "";
    }
};

function cancelAccountPanel() {
    document.getElementById("accountPanel").style.display = "none";
    showInformationPanel("The account information hasn't been saved.");

    // try {
    // do smth
    // } catch (e) {
    // window.location.href = "http://stackoverflow.com/search?q=[js]+"
    // + e.message;
    // }

};

function saveAccountPanel() {

    var idEmployee = userIdRenting;
    var nameEmployee = document.getElementById("fullNameAccountField").value;
    var dateBirthEmployee = document.getElementById("dateBirthAccountField").value;
    var tellEmployee = document.getElementById("tellAccountField").value;
    var emailEmployee = document.getElementById("emailAccountField").value;
    var photoEmployee = document.getElementById("accountPhotoImage").src;
    var dateUnix = getUnixTimeStamp(dateBirthEmployee);

    var dataForUpdate = {
        action : 'updateEmployee',
        idEmployee : idEmployee,
        nameEmployee : nameEmployee,
        dateBirthEmployee : dateUnix,
        emailEmployee : emailEmployee,
        photoEmployee : photoEmployee,
        tellEmployee : tellEmployee
    };

    $.ajax({
        url : urlServerBook,
        dataType : "json",
        type : "POST",
        data : dataForUpdate,
        error : function (message) {
        },
        success : function (data) {
        }
    });
    showInformationPanel("The account information has been saved.");
    document.getElementById("accountPanel").style.display = "none";
};

function createRenting() {

    var str = event.target.id;
    var strAction = str.split('-')[0];
    var strId = str.split('-')[1];

    var idBook = strId;
    var dateOn = Math.round(new Date().getTime() / 1000.0);
    var status = "false";

    var dataForRenting = {
        action : 'createRent',
        idBook : idBook,
        idEmployee : userIdRenting,
        dateOn : dateOn,
        status : status
    };

    $.ajax({
        url : urlServerBook,
        dataType : "json",
        data : dataForRenting,
        error : function (message) {
        },
        success : function (data) {
        }
    });
    showInformationPanel("The order of the book was successfully issued.");
};

function getUserEntranse() {
    var strLoggin = document.getElementById("userField").value;
    var strPassword = document.getElementById("passField").value;
    if (strLoggin == "" && strPassword == "") {
        showInformationPanel("Please, insert loggin and password!");
    } else {
        var dataEnter = {
            action : 'entranceUser',
            loggin : strLoggin,
            password : strPassword
        };
        $
                .ajax({
                    url : urlServerEmployee,
                    dataType : "json",
                    data : dataEnter,
                    error : function (message) {
                    },
                    success : function (data) {

                        document.cookie = "strLoggin=" + strLoggin;
                        document.cookie = "strPassword=" + strPassword;

                        try {
                            var entranceStatus = data["entrance"][0]["satatusAdmin"];

                            statusAdmin = data["entrance"][0]["satatusAdmin"];
                            userIdRenting = data["entrance"][0]["id"];

                            if (entranceStatus == "true") {
                                loadAdminPanel();
                                var fullName = document
                                        .getElementById("helloLbl");
                                fullName.innerHTML = "Hello, "
                                        + data["entrance"][0]["userLoggin"]
                                        + ".";
                                // showFormPanelAccount();
                                document.getElementById("accountPanel").style.display = "none";
                                getListBook();
                                getListRentingCount();

                                var chatPanel = document
                                        .getElementById('chatBlock');
                                chatPanel.style.display = 'block';

                                var appDownloadPanel = document
                                        .getElementById('downloadBlock');
                                appDownloadPanel.style.display = 'none';

                            } else if (entranceStatus == "false") {
                                loadUserPanel();
                                var fullName = document
                                        .getElementById("helloLbl");
                                fullName.innerHTML = "Hello, "
                                        + data["entrance"][0]["userLoggin"]
                                        + ".";
                                // showFormPanelAccount();
                                document.getElementById("accountPanel").style.display = "none";

                                var chatPanel = document
                                        .getElementById('chatBlock');
                                chatPanel.style.display = 'block';

                                // ///load lib panel
                            } else if (entranceStatus == "lib") {

                                loadWorkPanel();
                                var fullName = document
                                        .getElementById("helloLbl");
                                fullName.innerHTML = "Hello, "
                                        + data["entrance"][0]["userLoggin"]
                                        + ".";
                                document.getElementById("userImg").src = "img/NoPhotoEmployee.png";
                                var formLoggin = document
                                        .getElementById("formLoggin");
                                formLoggin.style.display = "none";
                                var closeButton = document
                                        .getElementById("closeButton");
                                closeButton.style.display = "block";

                                var panelListBooking = document
                                        .getElementById("tablesPanelControl");
                                panelListBooking.style.width = "95%";
                                panelListBooking.style.left = "2%";

                                var chatPanel = document
                                        .getElementById('chatBlock');
                                chatPanel.style.display = 'block';

                                var appDownloadPanel = document
                                        .getElementById('downloadBlock');
                                appDownloadPanel.style.display = 'none';

                            } else {
                                alert("Error in login or password!");
                                showFormPanelAccount();
                                document.getElementById("accountPanel").style.display = "none";
                            }
                        } catch (err) {
                            var fullName = document.getElementById("helloLbl");
                            fullName.innerHTML = "Incorrect login or password!";
                        }
                    }
                });
    }
};

function loadAdminPanel() {
    var helloLbl = document.getElementById("helloLbl");
    helloLbl.innerHTML = "Hello, " + login_constant + ".";
    var btn1 = document.getElementById("imgButton1");
    btn1.style.display = "block";
    var btn2 = document.getElementById("imgButton2");
    btn2.style.display = "block";
    var btn3 = document.getElementById("imgButton3");
    btn3.style.display = "block";
    var btn4 = document.getElementById("imgButton4");
    btn4.style.display = "block";
    var formLoggin = document.getElementById("formLoggin");
    formLoggin.style.display = "none";
    var closeButton = document.getElementById("closeButton");
    closeButton.style.display = "block";
    var closeButton = document.getElementById("regButton");
    closeButton.style.display = "none";
    var tablesPanel = document.getElementById("tablesPanel");
    tablesPanel.style.display = "block";
    var rentBtn = document.getElementById("rentBtn");
    rentBtn.style.display = "block";

    var rentListBtn = document.getElementById("rentListBtn");
    rentListBtn.style.display = "none";

    var lblCountRent = document.getElementById("lblCountRent");
    lblCountRent.style.display = "block";
    var accountBtn = document.getElementById("accountBtn");
    accountBtn.style.display = "block";
};

function loadUserPanel() {
    document.getElementById("reportDtn").style.visibility = "hidden";
    document.getElementById("addDtn").style.visibility = "hidden";
    var btn1 = document.getElementById("imgButton1");
    btn1.style.visibility = "hidden";
    var btn2 = document.getElementById("imgButton2");
    btn2.style.visibility = "hidden";
    var btn3 = document.getElementById("imgButton3");
    btn3.style.visibility = "hidden";
    var btn4 = document.getElementById("imgButton4");
    btn4.style.visibility = "hidden";
    var tableWidth = document.getElementById("tablesPanel");
    tableWidth.style.width = "94%";
    var tableLeft = document.getElementById("tablesPanel");
    tableLeft.style.left = "3%";
    var helloLbl = document.getElementById("helloLbl");
    helloLbl.innerHTML = "Hello, " + login_constant + ".";
    var btn1 = document.getElementById("imgButton1");
    btn1.style.display = "block";
    var formLoggin = document.getElementById("formLoggin");
    formLoggin.style.display = "none";
    var closeButton = document.getElementById("closeButton");
    closeButton.style.display = "block";
    var tablesPanel = document.getElementById("tablesPanel");
    tablesPanel.style.display = "block";
    var rentBtn = document.getElementById("rentBtn");
    rentBtn.style.display = "none";

    var rentListBtn = document.getElementById("rentListBtn");
    rentListBtn.style.display = "block";

    var lblCountRent = document.getElementById("lblCountRent");
    lblCountRent.style.display = "none";
    var accountBtn = document.getElementById("accountBtn");
    accountBtn.style.display = "block";
    var editBookBtnImg = document.getElementById("uploadInfoBtn");
    editBookBtnImg.style.display = "none";
    loadUserTable();
};

function loadUserTable() {
    $
            .ajax({
                url : urlServerBook,
                dataType : "json",
                data : {
                    action : 'readAllBooks'
                },
                error : function (message) {
                },
                success : function (data) {
                    document.getElementById("blockTable").innerHTML = lblListBook;
                    var arr = JSON.parse(JSON.stringify(data));

                    var count = Object.keys(arr["books"]).length;
                    document.getElementById("respServlet").innerHTML = "";

                    var headStr = "";

                    var LANG = readCookie('LANG');

                    if (LANG == 'RU') {
                        var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff\">№</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Название</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 30px;\">Год</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Автор</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Откр.</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Заказ</td>"
                        "</tr><tr>";
                    } else {
                        var headStr = "<table id=\"tabResponse\" class=\"tabResponse\"><tr>"
                                + "<td style=\"text-align: center; background: #39b54a; color: #fff\">Id</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Brief</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff; width: 30px;\">Publish year</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Author</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">View</td>"
                                + "<td style=\"text-align: center;  background: #39b54a;  color: #fff\">Rent</td>"
                        "</tr><tr>";
                    }

                    var footStr = "</tr></table>";

                    var bodyStr = "";
                    for (var i = 0; i < count; i++) {

                        $("#autiorList").append(
                                '<option value="' + arr["books"][i]["author"]
                                        + '" selected="selected">'
                                        + arr["books"][i]["author"]
                                        + '</option>');

                        var value = value + arr["books"][i]["brief"];

                        bodyStr = bodyStr
                                + "<tr><td style=\"text-align: right;\">"
                                + arr["books"][i]["id"] + "</td>";
                        bodyStr = bodyStr + "<td>" + arr["books"][i]["brief"]
                                + "</td>";
                        bodyStr = bodyStr + "<td style=\"text-align: right;\">"
                                + arr["books"][i]["publishYear"] + "</td>";
                        bodyStr = bodyStr + "<td>" + arr["books"][i]["author"]
                                + "</td>";

                        bodyStr = bodyStr
                                + "<td style=\"width: 50px\"><button id=viewBtn-"
                                + arr["books"][i]["id"]
                                + " onClick=\"viewBookInfo();\" class=\"viewBtnRow\">view</button></td>";

                        bodyStr = bodyStr
                                + "<td style=\"width: 50px\"><button id=viewBtn-"
                                + arr["books"][i]["id"]
                                + "-"
                                + userIdRenting
                                + " onClick=\"createRenting();\" class=\"viewBtnRow\">rent</button></td>";
                        // idBook, idEmployee, dateON, status ??????????????????
                    }
                    var table = headStr + bodyStr + footStr;
                    document.getElementById("respServlet").innerHTML = table;
                }
            });
};

function deleteCookie(name) {
    document.cookie = name + '=';
};

function reloadPage() {
    deleteCookie("strLoggin");
    deleteCookie("strPassword");
    location.reload();
};

function cancelRegistration() {
    document.getElementById("formRegistration").style.display = "none";
};

function clerInputsRegistration() {
    var login = document.getElementById("inputLoginRegistrationForm").value;
    var password = document.getElementById("inputPasswordRegistrationForm").value;
    var fullName = document.getElementById("inputFullnameRegistrationForm").value;
    var email = document.getElementById("inputEmailRegistrationForm").value;
    var dateBirth = document.getElementById("inputDateBirthRegistrationForm").value;
    var captcha = document.getElementById("inputCaptchaRegistrationForm").value;
};

function showRegistration() {
    clerInputsRegistration();
    var randomSimbol = getRandomArbitary(1, 1000);
    intChaptcha = randomSimbol;
    document.getElementById("labelcaptchaRegistrationForm").innerHTML = "Please, insert this "
            + randomSimbol + " in ";
    document.getElementById("formRegistration").style.display = "block";
};

function saveRegistration(summ) {
    var login = document.getElementById("inputLoginRegistrationForm").value;
    var password = document.getElementById("inputPasswordRegistrationForm").value;
    var fullName = document.getElementById("inputFullnameRegistrationForm").value;
    var email = document.getElementById("inputEmailRegistrationForm").value;
    var dateBirth = document.getElementById("inputDateBirthRegistrationForm").value;

    var str = dateBirth;
    var year = str.split('-')[0];
    var month = str.split('-')[1];
    var day = str.split('-')[2];

    var dateUnix = date2timestamp(year, month, day, 0, 0, 0);
    var captcha = document.getElementById("inputCaptchaRegistrationForm").value;

    if (login == "" || password == "" || fullName == "" || email == ""
            || captcha == "" || isNaN(dateUnix)) {

        showInformationPanel("Save failed. Check the user registration data entered and try again.");

        if (isNaN(dateUnix)) {
            document.getElementById('inputDateBirthRegistrationForm').style.background = "#ffad99";
        } else {
            document.getElementById('inputDateBirthRegistrationForm').style.background = "#fff";
        }

    } else {
        var userData = {
            action : 'createEmployee_8',
            login : login,
            password : password,
            fullName : fullName,
            email : email,
            dateBirth : dateUnix,
            statusAdmin : "false"
        };

        if (captcha = intChaptcha) {
            $.ajax({
                url : urlServerEmployee,
                dataType : "json",
                type : "GET",
                data : userData,
                error : function (message) {
                },
                success : function (data) {
                }
            });
            document.getElementById("formRegistration").style.display = "none";
        } else {
        }

        showInformationPanel("New user successfully registered.");
        document.getElementById('inputDateBirthRegistrationForm').style.background = "#fff";
    }
};

function getRandomArbitary(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
};

function natIP() {

    $.getJSON('//freegeoip.net/json/?callback=?', function (data) {

        var arr = JSON.parse(JSON.stringify(data, null, 2));

        var IPvisit = arr['ip'];
        var countryCode = arr['country_code'];
        var countyName = arr['country_name'];
        var regionCode = arr['region_code'];
        var regionName = arr['region_name'];
        var city = arr['city'];
        var zipCode = arr['zip_code'];
        var timeZone = arr['time_zone'];
        var latitude = arr['latitude'];
        var langitude = arr['longitude'];
        var metroCode = arr['metro_code'];

        var visiterData = {
            action : 'visitersInformation',
            ipVisit : IPvisit,
            countryCode : countryCode,
            countyName : countyName,
            regionCode : regionCode,
            regionName : regionName,
            city : city,
            zipCode : zipCode,
            timeZone : timeZone,
            latitude : latitude,
            langitude : langitude,
            metroCode : metroCode
        };

        $.ajax({
            url : urlServerEmployee,
            dataType : "json",
            data : visiterData,
            error : function (message) {
            },
            success : function (data) {
            }
        });

    });

};

function downloadApp() {
    window.open('https://goo.gl/Syn1p2');
};

function closeOpenChat() {
    var panel = document.getElementById('chatPanel');

    if (panel.style.display == 'none') {
        panel.style.display = "block";
        var btn = document.getElementById('btnSendMessage');
        btn.style.border = '1px solid rgb(97, 100, 103)';
        btn.style.backgroundColor = 'rgb(88, 95, 101)';
        btn.disabled = true;
    } else {
        panel.style.display = "none";
    }

};

function selectUserChat() {
    var user = document.getElementById('listUsers');
    var selectedUser = document.getElementById('fieldNameUserSendTo');

    selectedUser.value = user.value;

};

function checkFullFieldMessage() {
    var msg = document.getElementById('sendMessageToUser');
    var user = document.getElementById('fieldNameUserSendTo');
    var btn = document.getElementById('btnSendMessage');

    if (msg.value == '' || user.value == '') {
        btn.style.border = '1px solid rgb(97, 100, 103)';
        btn.style.backgroundColor = 'rgb(88, 95, 101)';
        btn.disabled = true;
    } else {
        btn.style.border = '1px solid rgb(41, 129, 202)';
        btn.style.backgroundColor = 'rgb(41, 129, 202)';
        btn.disabled = false;
    }

};

function selectChatUsers() {

    var select = document.getElementById("listUsers");
    var length = select.options.length;
    for (j = 0; j < length; j++) {
        select.options[j] = null;
    }

    var fromUser = document.getElementById('userField');
    var select = document.getElementById("listUsers");

    var data = {
        action : 'selectChatUsers',
        login : fromUser.value
    };

    $.ajax({
        url : urlServerServices,
        dataType : "json",
        data : data,
        error : function (message) {
        },
        success : function (data) {
            var arr = JSON.parse(JSON.stringify(data));
            var count = Object.keys(arr["listChatUsers"]).length;
            for (var i = 0; i < count; i++) {
                select.options[i] = new Option(
                        arr["listChatUsers"][i]["userLoggin"],
                        arr["listChatUsers"][i]["userLoggin"]);
            }
        }
    });
};

var addBookForSearchChat = '';

function useTagForSearchBook() {
    var fielMsg = document.getElementById('sendMessageToUser');
    fielMsg.value = fielMsg.value + '[B-]';
    fielMsg.focus();
};

function useTagForSearchEmployee() {
    var fielMsg = document.getElementById('sendMessageToUser');
    fielMsg.value = fielMsg.value + '[E-]';
    fielMsg.focus();
};

function loadlast10Messages() {
    // readMessage
    var msg = document.getElementById('sendMessageToUser');
    var btn = document.getElementById('btnSendMessage');
    var msgList = document.getElementById('listMessages');
    var toUser = document.getElementById('fieldNameUserSendTo');
    var fromUser = document.getElementById('userField');

    var msgFromUserWithStyle = '';

    msgList.innerHTML = '';

    var data = {
        action : 'readMessage'
    };

    $
            .ajax({
                url : urlServerServices,
                dataType : "json",
                data : data,
                error : function (message) {
                },
                success : function (data) {
                    var arr = JSON.parse(JSON.stringify(data));
                    var count = Object.keys(arr["msgList"]).length;
                    for (var i = 0; i < count; i++) {

                        var senderJSON = arr["msgList"][i]["fromUser"];
                        var senderApp = document.getElementById('userField').value;

                        if (senderJSON == senderApp) {
                            msgFromUserWithStyle = '<label id=messageFromUser" class="messageFromUser">'
                                    + arr["msgList"][i]["fromUser"]
                                    + '</label>';
                        } else {
                            msgFromUserWithStyle = '<label id=messageFromAnyUser" class="messageFromAnyUser">'
                                    + arr["msgList"][i]["fromUser"]
                                    + '</label>';
                        }

                        var codeMessage = 'spanMsg-' + i;
                        var messageArr = '<span id="' + codeMessage
                                + '"  onClick="selectSearchLink(' + i + ');">'
                                + arr["msgList"][i]["message"] + '</span>';

                        msgList.innerHTML = msgList.innerHTML
                                + msgFromUserWithStyle + '->'
                                + arr["msgList"][i]["toUser"] + ':'
                                + messageArr + '</br>';
                    }
                }
            });
};

function selectSearchLink(codeMessage) {

    if (statusAdmin == 'true') {
        try {
            var idMessage = codeMessage;
            var code = document.getElementById('spanMsg-' + idMessage).innerHTML;
            var arr = code.match(/\[[^\[]*?\]/g, "");
            var t1 = arr[0].split('-')[0];
            var t2 = arr[0].split('-')[1].split(']')[0]; // code
            var t3 = t1.split('[')[1]; // kode symbol

            if (t3.trim() == 'B') {
                var searchBookField = document.getElementById('findField');
                getListBook();
                searchBookField.value = t2;
                setTimeout(function () {
                    searchBookField.onkeyup();
                }, 1000);
            } else if (t3.trim() == 'E') {
                var searchEmployeeField = document.getElementById('findField');
                getListEmployee();
                searchEmployeeField.value = t2;
                setTimeout(function () {
                    searchEmployeeField.onkeyup();
                }, 1000);
            }
        } catch (err) {
            var LANG = readCookie('LANG');
            if (LANG == 'RU') {
                showInformationPanel(RU_LANGUAGE['MSG_ERROR_TAG']);
            } else {
                showInformationPanel(RU_LANGUAGE['MSG_ERROR_TAG']);
            }
        }
    } else {
        // /
    }

};

function loadListUsersChat() {

};

function sendMessageFromChat() {
    console.log('Sending the message to user.');
    var msg = document.getElementById('sendMessageToUser');
    var btn = document.getElementById('btnSendMessage');
    var msgList = document.getElementById('listMessages');
    var toUser = document.getElementById('fieldNameUserSendTo');
    var fromUser = document.getElementById('userField');
    // msgList.innerHTML = msgList.innerHTML
    // + '<div id=\'messageFromAdmin\' class=\'messageFromAdmin\'>' + msg.value
    // + '</br><label class="dateOnMessage" for="messageFromAdmin">20.20.2018
    // 15:22</label></div>';
    //

    var data = {
        action : 'writeMessage',
        dateOn : 1523962426,
        fromUser : fromUser.value,
        toUser : toUser.value,
        message : msg.value
    };

    $.ajax({
        url : urlServerServices,
        dataType : "json",
        data : data,
        error : function (message) {
        },
        success : function (data) {
        }
    });

    msg.value = '';
    btn.style.border = '1px solid rgb(97, 100, 103)';
    btn.style.backgroundColor = 'rgb(88, 95, 101)';
    btn.disabled = true;

    loadlast10Messages();

};