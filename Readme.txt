Rising Sun, v1.0
------------------------------
About:
	Rising Sun is an android mobile app designed to simulate remote ordering capabilities 
	for a coffee shop. The order function transmits the order to a dummy server for logging. 
	   


Project Enviroment:
	Android Studio 3.0.1
	Build #AI-171.4443003, built on November 9, 2017
	JRE: 1.8.0_152-release-915-b01 amd64
	JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
	Windows 10 10.0

Import Instructions:
	After launching Android Studio, File > Open > (navigate to location of gorbert folder)



Changelog:
------------------------------


In Development:
------------------------------
~Spanish language support
~JUNIT tests
~New theme/color scheme
~Expanded menu for tea


Dummy Server set-up:
------------------------------
Made using Tomcat 9.0 -- https://tomcat.apache.org/download-90.cgi

After Tomcat has been set up, copy the "receive_order" file located in "WEB-INF backup for tomcat".
Launch Tomcat server, and update the URL in the doInBackground(String order) method of CartListFragment.java
to "localhost:9999/receive_order/order" (9999 should be set to the port Tomcat is configured to use)

