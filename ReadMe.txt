This is Demo application for creating monitoring services in Java Enterprise application.

This application contains below Modlules.
INGParent					--> Parent Module
INGEar						--> Ear Module which creates EAR. Below MOdules are added in single EAR	
WebModule					--> War Module which is dependent on below 3 modules.
Utility						--> Jar module which consist Java code for DAO,Service layer
WebModule1					--> Independant War module
WebModule2					--> Independant War module

This appplication consist 5 different endpoints : 
1. 	http://localhost:8080/WebModule/rest/statuscheck/db 		--> This will give us status whether DB server as UP or DOWN
2.  http://localhost:8080/WebModule/rest/statuscheck/app1		--> This will give us status whether dependent application-1(WebModule-1) is Up or DOWN
3.  http://localhost:8080/WebModule/rest/statuscheck/app2		--> This will give us status whether dependent application-2(WebModule-2) is Up or DOWN
4.  http://localhost:8080/WebModule/rest/statuscheck/app		--> This will give us UP stats of main application (WebModule)
5.  http://localhost:8080/WebModule/rest/statuscheck/dependency	--> This will give us list of dependency from Database.
	
Technology Used :
Java 		: 1.8
Maven 		: 3.0.4
Spring 		: 3.2.2
JPA
Hibernate
Database 	:MySQL
Server 		: JBoss


For screenshot and steps for executing application read Steps.doc file.