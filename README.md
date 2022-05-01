# Yalp

Yalp is a project that seeks to recreate Yelp, using the public dataset available at [yelp.com/dataset]. This project is currently split into two pieces, a front end built using REACT.JS, which interacts with a local database, and a backend built using Spring boot. The database ER diagram and schema for the database construction can be found [here](https://docs.google.com/document/d/149_Xzw38OxuVXO0Zw7oQ7iNSDs5ZToJ21riY9bWRQAk/edit?usp=sharing). Detailed instructions on running the front-end and back-end can be found below.
# Backend

Our backend is currently run on a remote server (http://joshuapulido.com:8080/api/v1). Below are instructions for interacting with this remote database.

## Businesses
__/businesses__<br>
Retrives all businesses in database, in JSON format (not recommended for large databases)<br>

__/businesses/{id}__<br>
Retrives a specific business, by the business_id field<br>

__/addbusiness__<br>
Add a business, by using JSON in the body of the http request, in the following format:<br>
{<br>
  "businessId": businessId,<br>
  "name": name,<br>
  "reviewCount": reviewCount,<br>
  "stars": stars,<br>
  "category": category<br>
}<br>
where businessId, name, and category are strings, reviewCount is a short, and stars is a decimal between 0 and 5, in the tens place (i.e. 2.3, 4.3, etc.)<br>

__/search/businesses/{text}__<br>
Search businesses by the text argument passed, checking both name and category of businesses<br>

__/search/businesses/stars/equals/{num}__<br>
Return  businesses where they have the same number of stars as the passed argument<br>

__/search/businesses/stars/greater/{num}__<br>
Return businesses with more stars (inclusive) than the passed argument<br>

__/search/businesses/stars/less/{num}__<br>
Return businesses with less stars (inclusive) than the passed argument

## Users
__/userss__<br>
Retrives all users in database, in JSON format (not recommended for large databases)<br>

__/users/{id}__<br>
Retrives a specific user, by the user_id field<br>

__/adduser__<br>
Add a user, by using JSON in the body of the http request, in the following format:<br>
{<br>
  "userId": businessId,<br>
  "name": name,<br>
  "reviewCount": reviewCount<br>
}<br>
where userId and name are strings, and reviewCount is a short<br>

__/search/users/{text}__<br>
Search users by the text argument passed, checking their names<br>

## Reviews
__/reviews__<br>
Retrives all reviews in database, in JSON format (not recommended for large databases)<br>

__/reviews/{id}__<br>
Retrives a specific review, by the review_id field<br>

__/addreview__<br>
Add a review, by using JSON in the body of the http request, in the following format:<br>
{<br>
  "reviewId": reviewId,<br>
  "text": text,<br>
  "date": date,<br>
  "stars": stars,<br>
  "businessId": businessId,<br>
  "userId": userId<br>
}<br>
where reviewId, businessId, userId, date, and text are string, and stars is a decimal between 0 and 5, in the tens place (i.e. 2.3, 4.3, etc.). Note that a business and user with the given business_id and user_id fields, respectively, must already exist<br>

## Addresses
__/addresses__<br>
Retrives all addresses in database, in JSON format (not recommended for large databases)<br>

__/addresses/{id}__<br>
Retrives a specific address, by the business_id field<br>

__/addaddress__<br>
Add an address, by using JSON in the body of the http request, in the following format:<br>
{<br>
  "businessId": businessId,<br>
  "street": street,<br>
  "city": city,<br>
  "state": state,<br>
  "zip": zip<br>
}<br>
where all fields are strings. Note that the business must exist, and an address must not already exist<br>

__/update/address__<br>
Update an address, by using JSON in the body of the http request, in the following format.<br>
{<br>
  "businessId": businessId,<br>
  "street": street,<br>
  "city": city,<br>
  "state": state,<br>
  "zip": zip<br>
}<br>
where all fields are strings. Note that both a business and address must already exist with the given business id.<br>

## Hours
__/hours__<br>
Retrives all hours in database, in JSON format (not recommended for large databases)<br>

__/hours/{id}__<br>
Retrives a specific hours set, by the business_id field<br>

__/addhours__<br>
Add an hours set, by using JSON in the body of the http request, in the following format:<br>
{<br>
  "businessId": businessId,<br>
  "monday": monday,<br>
  "tuesday": tuesday,<br>
  "wednesday": wednesday,<br>
  "thursday": thursday,<br>
  "friday": friday,<br>
  "saturday": saturday,<br>
  "sunday": sunday<br>A
}<br>
where all fields are strings. Note that the business must exist, and an address must not already exist. Days can be left out, and will default to closed.<br>

__/update/hours__<br>
Update an hours set, by using JSON in the body of the http request, in the following format.<br>
{<br>
  "businessId": businessId,<br>
  "monday": monday,<br>
  "tuesday": tuesday,<br>
  "wednesday": wednesday,<br>
  "thursday": thursday,<br>
  "friday": friday,<br>
  "saturday": saturday,<br>
  "sunday": sunday<br>A
}<br>
where all fields are strings. Note that the business and hours set must already exist with the given business_id. Days can be left out, and will default to closed. Note that any left out here will default, even if they were not "Closed" previously.<br>

## Tips
__/tips__<br>
Retrives all tips in database, in JSON format (not recommended for large databases)<br>

__/tips/business/{id}__<br>
Retrives all tips for a specific business, by the business_id field<br>

__/tips/user/{id}__<br>
Retrieves all tips for a specific user, by the user_id field<br>

__/addtip__<br>
Add a business, by using JSON in the body of the http request, in the following format:<br>
{<br>
  "businessId": businessId,<br>
  "userId": userId,<br>
  "text": text,<br>
  "complimentCount": complimentCount,<br>
  "date": date<br>
}<br>
where businessId, userId, text, and date are strings, complimentCount is a short. Note that a business and user with the given ids must already exist<br>

## Photos
__/photos__<br>
Retrives all photos in database, in JSON format (not recommended for large databases)<br>

__/photos/{id}__<br>
Retrives photos for a business, by the business_id field<br>

__/addphotos__<br>
Add a business, by using JSON in the body of the http request, in the following format:<br>
{<br>
  "businessId": businessId,<br>
  "photoId": photoId,<br>
  "caption": caption,<br>
  "label": label<br>
}<br>
where all fields are strings. Note that a business given id must already exist, and a photo with the given id must not exist<br>




# References
* When importing the data from JSON files to sql we used these pages:
  - [JSON to SQL](https://docs.microsoft.com/en-us/sql/relational-databases/json/import-json-documents-into-sql-server?view=sql-server-ver15)
  -     [OPENROWSET](https://docs.microsoft.com/en-us/sql/t-sql/functions/openrowset-transact-sql?view=sql-server-ver15)
* When implementing React
  - https://codebun.com/search-record-from-a-table-in-react-js-spring-boot-and-mysql/
  - https://www.javaguides.net/2020/07/react-js-spring-boot-rest-api-example-tutorial.html
  - https://www.javaguides.net/2020/07/react-js-fetch-api-to-consume-spring.html#fromHistory
  - https://javascript.plainenglish.io/how-to-implement-a-search-bar-in-react-js-8cf8f5513b8e#fromHistory
  - 
