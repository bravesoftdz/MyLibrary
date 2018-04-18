# MyLibrary
![Image alt](https://github.com/gvozdev1986/MyLibrary/blob/master/webapp/img/logo.png)

<b style="color: red; font-size: 2em">Final work with the courses (JAVA, JAVA QA Automation).</b>


# Brief description
Web application for accounting books. 
The application was split into several users (administrator, librarians, readers). 
Each user has his own functions and access rights. 
The opportunity of self-registration of the user is realized. 
After successful registration, the user can change some of his data in the account settings after logging on. 
The user can use the mobile client (Android) to download the link in the web application or from the repository [Library_client](https://github.com/gvozdev1986/MyLibraryClient/blob/master/Library_client.apk "Download mobile application"). The application has two languages: English and Russian. 
The user can switch it over the flag image near the application logo. 
Important: the application will reboot. 

# Features:
1. Sending messages to e-mail.
2. Printing (saving) lists of books and readers in a file (Excel).
3. Implemented a simple chat between users.
4. The chat uses "tags" to quickly find a book or reader.
5. New User Registration.
6. Search for books and readers.
7. Accounting for books issued.
8. etc.

# Technologies used.
1. JAVA
2. Maven
3. Servlet
4. HTML
5. JavaScript 
6. JQuery
7. AJAX
8. CSS (without framework)
9. javax.servlet-api (library for servlet)
10. gson (library for JSON) https://sites.google.com/site/gson/gson-user-guide
11. javax.mail-api, java.mail (library for email) https://mvnrepository.com/
12. Apache POI (library for MS Office "Excel") <b>Apache POI - the Java API for Microsoft Documents</b> https://poi.apache.org/
13. mysql-connector-java (library for MySQL) https://dev.mysql.com/downloads/connector/j/5.1.html

# Data for the test input
URL: http://gvozdev.mycloud.by
* <b>ADMINISTRATOR</b> (login: <b>admin</b>, password: <b>250486al</b>)
* <b>LIBRARIAN</b> (login: <b>lib1</b>, password: <b>lib1</b>)
* <b>READER</b> The reader can register an account and use it.
