# Final-Project
BMT GYM
Spring project created about GYM application

My project has 3 databaseswhic are Accounts Users, GymMemberShip

The Accounts database have the following fields:

id (Long) : auto-incremented
-accountName (String)
-accountPassword (String)
-email (String)
-telNumber (String)
-address (String)
-price (float)
-isdelete (boolean)

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

This GYM project is my assesment project for QA software developer. It's for gym companies. You can use it for creating customers, getting all the customers details, updating, chanhing membership type etc.

Everything went well when I started the project, but I had a hard time creating 4 tables and testing them. I reduced the number of tables to 3. I had to delete the branch's table. Because of I couldn't post the branches as a separate page in postman.

I guess it was a mistake to leave testing to the last day. It took me a long time to complete the testing because of the errors I keep getting. 
I didn't want to do a project with a very simple single table, and when I started having difficulties, I couldn't get back from this idea. So I ask you to please forgive some of my mistakes.




