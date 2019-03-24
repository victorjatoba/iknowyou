# iknowyou

"I know you' helps doctors to get a quick glance of patient history by using machine learning to highlight keywords like patient's past symptoms, medicine and doctor's actions taken.

By searching by patient's name, the doctor can visualize all the patient basic information, a quick medical history briefing with highlighted keywords and access to the complete medical history files.

![](https://github.com/victorjatoba/iknowyou/blob/develop/backend/userDocs/i_know_you.png)

# How To Execute

## Backend

The source code is located at the backend folder. Just download and import as a Maven Project in your preferred IDE.
Execute *IknowyouApplication* as Java Application. Spring Boot will start Tomcat and the application will run on *localhost:8080*.
Check https://github.com/victorjatoba/iknowyou/wiki/Project-Design for available end-points.

## Frontend

You will need to install node and ionic on your machine in order to run the frontend project.

Node: https://nodejs.org/en/
Ionic: https://ionicframework.com/docs/installation/cli

The source code is located at the frontend folder. Just download it, get into the folder and run the following commands:

npm install
ionic serve

### Known Issues

Currently, the CORS is enabled. The front-end won't be able to retrieve the data without a CORS plugin in the browser.
