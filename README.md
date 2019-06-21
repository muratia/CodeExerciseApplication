#Coding Excersize
=================

The application is developed using Java version

 

*C:\\Users\\ahmet\>java -version*

*java version "1.8.0_211"*

*Java(TM) SE Runtime Environment (build 1.8.0_211-b12)*

*Java HotSpot(TM) 64-Bit Server VM (build 25.211-b12, mixed mode)*

Spring Framework version 2.1.5.RELEASE
## Running of the application
The application is run using command line instructions:

mvn spring-boot:run

Features
--------

| URL                                          | Parameter/s                                                                                                           | Method |
|----------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|--------|
| /localhost:8080/api-rest/appointments      | None                                                                                                                  | GET    |
| /localhost:8080/api-rest/appointments      | Id                                                                                                                    | DELETE |
| /localhost:8080/api-rest/appointments/add     | appointment =```json{ "place": "Prizeren", "price": 454, "id": 0, "date": "2019-06-18", "time": "21:37:44", "status": true } ```| PUT    |
| /localhost:8080/api-rest/appointments/bydates | startDate=2019-10-06 00:00:01 endDate=2019-30-06 23:59:59                                                             | GET    |
| /localhost:8080/api-rest/appointments/us      | id Long, Status Boolean                                                                                               | POST   |
 
