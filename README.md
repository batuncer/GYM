# Final-Project
BMT GYM
Spring project created about GYM application

My project has 3 databaseswhic are Accounts Users, GymMemberShip

The Accounts database have the following fields:

id (Long) : auto-incremented
accountName (String)
accountPassword (String)
email (String)
telNumber (String)
address (String)
price (float)
isdelete (boolean)

The Users database have the following fields:

id (Long) : auto-incremented
fullName (String)
height(int)
weight (int)
email (String)
telNumber (String)
isdelete (boolean)

The GymMemberShip database have the following fields:

id (Long) : auto-incremented
userId (long)
accountId (long)
price (float)
mType (int)
start_date DATETIME
period_date (int)
create_date (DATETIME)
isdelete (boolean)

This GYM project is my assesment project for QA software developer. It's for gym companies. You can use it for creating customers, getting all the customers details, updating, chanhing membership type etc. Also i can extend membership with using pay fonction. I can see how many days are remanining from custumers memberhips.

Everything went well when I started the project, but I had a hard time creating 4 tables and testing them. I reduced the number of tables to 3. I had to delete the branch's table. Because of I couldn't post the branches as a separate page in postman. Also i had some problems adding start date and create date, i found some codes from online to make them string. it took a lot of time as well.

I guess it was a mistake to leave testing to the last day. It took me a long time to complete the testing because of the errors I keep getting. 
I didn't want to do a project with a very simple single table, and when I started having difficulties, I couldn't get back from this idea. So I ask you to please forgive me If i have some mistakes.

You can find screenshoots and links below,


Jira
https://bakimurat.atlassian.net/jira/people/61f110c06fa12a00704f46ca

github link
https://github.com/batuncer/GYM


Database Diagram https://imgur.com/a/9jSHUTn
Business diagram https://imgur.com/a/MSKFiOb
Risk assessment to identify and analyse any potential risks  https://imgur.com/a/1fR670e
Postman: create, get, update, delete (4photos)== for USERS == https://imgur.com/a/sP06dgh
Postman: create, get, update, delete (4photos) ===for accounts   https://imgur.com/a/POuprVI
Postman: for gym_membership https://imgur.com/a/0stlpWQ
MySQL : screenshots (3 tables) https://imgur.com/a/VgI16SN
Testing https://imgur.com/a/y3tuLFo

STRECTH GOALS

An ERD diagram for your specified domain and include it in the documentation folder- addded with business and database diagram

Use of custom queries = isdelete

Use of custom exceptions in your service = added exception
Include the use of DTOs = with pay function
Include the use of Lombok = i completed without using this. but i leanrt it from online 
Achieve 80% test coverage of the src/main/java folder.
2 branched wer used and merge into the main.

This is my first proje and i did my best to do this. I hope you can see my effort and i can get the certificate. I can say that I will become software engeneer one day and that day is today or next year. This is my career goal and i will do everthing for it.

THANK YOU


