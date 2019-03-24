# iknowyou

"I know you' helps doctors to get a quick glance of patient history by using machine learning to highlight keywords like patient's past symptoms, medicine and doctor's actions taken.

By searching by patient's name, the doctor can visualize all the patient basic information, a quick medical history briefing with highlighted keywords and access to the complete medical history files.

![](https://github.com/victorjatoba/iknowyou/blob/develop/backend/userDocs/i_know_you.png)

# How To Execute

## Backend

The source code is located at the backend folder. Just download and import as a Maven Project in your preferred IDE.
Execute *IknowyouApplication* as Java Application. Spring Boot will start Tomcat and the application will run on *localhost:8080*.
Check https://github.com/victorjatoba/iknowyou/wiki/Project-Design for available end-points.

### Known Issues

Currently, the CORS is enabled. The front-end won't be able to retrieve the data without a CORS plugin in the browser.
