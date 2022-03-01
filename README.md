# CS458-Project1
- - - -
### About ###
This is a Netflix login page clone for the CS458 Project 1.
- - - -
### Team Members ###
Doğukan Ertunga Kurnaz 21702331<br/>
İdil Yılmaz 21703556<br/>
Sarp Ulaş Kaya 21801992<br/>
Berk Kerem Berçin 21803190<br/>

### INSTRUCTIONS ###
# Setting up and using the web site:
Once you clone the project, the first thing that you will need to do is open the folder inside Visual Studio Code, and download the Live Server extension if it is not already added using the Extensions tab on the left. Once the extension is added, you will have to click "Go live" on the bottom left, which will then display a port number. Using this port number, you can check the website that we have set up for yourself using the link as "http://localhost:port-number/index.html". This is an important step for each functionality to work as intended. Make sure that you use Chrome as your browser while testing the project, and make sure that pop-ups, cookies and redirects are enabled for the Facebook Login and Remember Me functionalities to work correctly.

# Setting up and using Selenium:
Make sure that JDK 11 and Eclipse IDE are installed on your computer before proceeding with the remaining steps. While the necessary files will be available inside the cloned directory, we strongly recommend that you add the Java project folder inside, SeleniumTest, inside your preferred eclipse workspace and access it through there using the Eclipse IDE. Once you locate the project inside the Eclipse IDE, right click on it and select Build Path > Configure Build Path. Then, select Libraries and click on Add External JARs. From here, locate and select the file "selenium-server-4.1.2.jar", which is also provided inside the cloned directory. If you have followed the steps correctly, you will see it under referenced libraries under the project folder inside your Eclipse IDE.

The next step is to make a few changes inside the Java classes themselves so that they work on your computer. The first thing to note is that there are two packages inside the source (src) folder. You will only have to use the classes inside the "testcase" package. Each of these classes is for a separate test case so that you can run each test individually. Thus, each of the classes have a main method, and the first few lines inside these main methods are all the same. First, inside the second parameter string of the first line in each of these main methods, you will see the path "C:\\Users\\ULAS\\Downloads\\chromedriver_win32\\chromedriver.exe". The chromedriver.exe file is inside the chromedriver_win32.zip file that is provided inside the project directory. Extract the .exe file from this zip and change the path accordingly based on wherever you would like to keep it on your own computer. Next, change the port number inside the line commented with "//open URL" based on your own port number that VSCode's Live Server extension gave you (in other words, the one you used to access the website before). Do these two things for each of the five classes. Lastly, since we have used an API in order to implement the Facebook Login feature, we had to use our real Facebook account details for testing. On lines 90 and 91 inside the FBLoginTest class, fill the inside of the Strings with your own Facebook account details.