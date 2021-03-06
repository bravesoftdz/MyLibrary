# <i>MyLibrary</i>
![Image alt](https://github.com/gvozdev1986/MyLibrary/blob/master/webapp/img/logo.png)

<b><i>Final work with the courses (JAVA, JAVA QA Automation).</i></b>


# <i>Brief description</i>
Web application for accounting books. 
The application was split into several users (administrator, librarians, readers). 
Each user has his own functions and access rights. 
The opportunity of self-registration of the user is realized. 
After successful registration, the user can change some of his data in the account settings after logging on. 
The user can use the mobile client (Android) to download the link in the web application or from the repository [Library_client](https://github.com/gvozdev1986/MyLibraryClient/blob/master/Library_client.apk "Download mobile application"). The application has two languages: English and Russian. 
The user can switch it over the flag image near the application logo. 
Important: the application will reboot. Each book has a description, an image. The user also has a series of data.

# <i>Features</i>
1. Sending messages to e-mail.
2. Printing (saving) lists of books and readers in a file (Excel).
3. Implemented a simple chat between users.
4. The chat uses "tags" to quickly find a book or reader.
5. New User Registration.
6. Search for books and readers.
7. Accounting for books issued.
8. etc.

# <i>Technologies used</i>
1. JAVA
2. Maven
3. Apache Tomcat® http://tomcat.apache.org/
4. Servlet (encoding UTF-8 (for for Cyrillic characters))
5. HTML
6. JavaScript 
7. JQuery
8. AJAX
9. Decode, Encode to Base64 (image)
10. CSS (without framework)
11. javax.servlet-api (library for servlet)
12. gson (library for JSON) https://sites.google.com/site/gson/gson-user-guide
13. javax.mail-api, java.mail (library for email) https://mvnrepository.com/
14. Apache POI (library for MS Office "Excel") <b>Apache POI - the Java API for Microsoft Documents</b> https://poi.apache.org/
15. mysql-connector-java (library for MySQL) https://dev.mysql.com/downloads/connector/j/5.1.html
16. WAR (<b>Web Application Resource</b>) file for deployment on the server.
17. etc.

# <i>Other resources</i>
1. freegeoip.net (To get the current position and user's IP in the format of the JSON and save to the database.)
2. Date formats in UNIX
3. mail.ru (To send messages to users. <b>smtp.mail.ru / 465</b>)
4. etc.

# <i>Data for the test input</i>
URL: http://gvozdev.mycloud.by
* <b>ADMINISTRATOR</b> (login: <b>admin</b>, password: <b>250486al</b>)
* <b>LIBRARIAN</b> (login: <b>lib1</b>, password: <b>lib1</b>)
* <b>READER</b> The reader can register an account and use it.
