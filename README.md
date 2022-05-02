# Yalp
## A Fullstack Webapp Using the Yelp Dataset

# Table of Contents
1. [Introduction](#Introduction)
2. [Frontend](#Frontend)
3. [Backend](#Backend)
   - [Businesses](#Businesses)
   - [Users](#Users)
   - [Reviews](#Reviews)
   - [Addresses](#Addresses)
   - [Hours](#Hours)
   - [Tips](#Tips)
   - [Photos](#Photos)
4. [References](#References)

# Introduction

Yalp is a project that seeks to recreate Yelp, using the public dataset available at [yelp.com/dataset]. This project is currently split into two pieces, a front end built using REACT.JS, which interacts with a local database, and a backend built using Spring boot. The database ER diagram and schema for the database construction can be found [here](https://docs.google.com/document/d/149_Xzw38OxuVXO0Zw7oQ7iNSDs5ZToJ21riY9bWRQAk/edit?usp=sharing) and the presentation in the Assets folder on our [GitHub repository](https://github.com/jacup101/databasesProject).

We are using Yelp’s public dataset, which contains data on businesses from 8 large cities across the globe - including reviews, tips, photos, relevant users, etc.
Found at: https://www.yelp.com/dataset
Stored in JSON (uploading is a pain)
Yelp provides access to a dataset which contains the restaurants and reviews from 8 large metropolitan areas in a 10 GB json file, which provides enough data for a starting point. Since the data for other restaurants is also publicly available to everyone, just not contained in the dataset, we can grab more data if needed, possibly using Yelp’s REST API or by building a simple web scraper in Python.

# Frontend
For this project we implemented the frontend using [React](https://reactjs.org/), which splits the project into different components.
The three main components are for the layout, businesses, and reviews.
These are completed components and the business and review components have a respective service defined in the "service" directory.
The components defing the display that users are going to see and interacte with, while the service enhances the functionality of the app, defining the methods used to query our database.
At the moment, a searchbar is defined in both the business and review components, but further developments will have a single search bar component for each of our entities.

At the beginning, the index.js is called and renders the defined components and calls a sequence of components: App.js -> LayoutComponent.js -> BusinessComponent.js & ReviewComponent.js.
The LayoutComponent defines the layout of the web app, creating the environment for the columns and sections.
The BusinessComponent and ReviewComponent each query the database, once when mounted (i.e. initially rendered) and when a search is made via the searchbar. The queries are made to the backend (i.e. Springboot) via the [fetch API](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API), and the data is passed back to the frontend as JSON.
This data can then be rendered using React and is displayed as a table, seen below.

<!-- Example for Table and Searchbar -->
<div style="background-color:whitesmoke;
  padding-top: 10px;
  padding-bottom: 10px;
  padding-left: 10px;
  color:black">
  <div>
      <input type="text" placeholder="Search Here"/>
      <button type="button" name="search">Search</button>
      <button type="reset">Clear</button>
  </div>

  <table>
      <thead>
          <tr  style="background-color:grey">
              <th>Business Id</th>
              <th>Business Name</th>
              <th>Business Category</th>
          </tr>
      </thead>
      <tbody>
          <tr>
              <td>1</td>
              <td>Papa Hut</td>
              <td>resturant</td>
          </tr>
          <tr>
              <td>2</td>
              <td>Denimos</td>
              <td>resturant</td>
          </tr>
          <tr>
              <td>3</td>
              <td>McDorger King</td>
              <td>resturant</td>
          </tr>
      </tbody>
  </table>
</div>

# Backend

Our backend is currently run on a remote server (http://joshuapulido.com:8080/api/v1). Below are instructions for interacting with this remote database, each can be entered at the end of the URL to interact with the database.

## Businesses
__/businesses__<br>
Retrives all businesses in database, in JSON format (not recommended for large databases).

__/businesses/{id}__<br>
Retrives a specific business, by the business_id field.

__/addbusiness__<br>
Add a business, by using JSON in the body of the http request, in the following format:

    {
      "businessId": businessId,
      "name": name,
      "reviewCount": reviewCount,
      "stars": stars,
      "category": category
    }

where businessId, name, and category are strings, reviewCount is a short, and stars is a decimal between 0 and 5, in the tens place (i.e. 2.3, 4.3, etc.)

__/search/businesses/{text}__<br>
Search businesses by the text argument passed, checking both name and category of businesses.

__/search/businesses/stars/equals/{num}__<br>
Return businesses where they have the same number of stars as the passed argument.

__/search/businesses/stars/greater/{num}__<br>
Return businesses with more stars (inclusive) than the passed argument.

__/search/businesses/stars/less/{num}__<br>
Return businesses with less stars (inclusive) than the passed argument.

## Users
__/userss__<br>
Retrives all users in database, in JSON format (not recommended for large databases).

__/users/{id}__<br>
Retrives a specific user, by the user_id field.

__/adduser__<br>
Add a user, by using JSON in the body of the http request, in the following format:

    {
      "userId": businessId,
      "name": name,
      "reviewCount": reviewCount
    }

where userId and name are strings, and reviewCount is a short.

__/search/users/{text}__<br>
Search users by the text argument passed, checking their names.

## Reviews
__/reviews__<br>
Retrives all reviews in database, in JSON format (not recommended for large databases).

__/reviews/{id}__<br>
Retrives a specific review, by the review_id field.

__/addreview__<br>
Add a review, by using JSON in the body of the http request, in the following format:

    {
      "reviewId": reviewId,
      "text": text,
      "date": date,
      "stars": stars,
      "businessId": businessId,
      "userId": userId
    }

where reviewId, businessId, userId, date, and text are string, and stars is a decimal between 0 and 5, in the tens place (i.e. 2.3, 4.3, etc.). Note that a business and user with the given business_id and user_id fields, respectively, must already exist.

## Addresses
__/addresses__<br>
Retrives all addresses in database, in JSON format (not recommended for large databases).

__/addresses/{id}__<br>
Retrives a specific address, by the business_id field.

__/addaddress__<br>
Add an address, by using JSON in the body of the http request, in the following format:

    {
      "businessId": businessId,
      "street": street,
      "city": city,
      "state": state,
      "zip": zip
    }

where all fields are strings. Note that the business must exist, and an address must not already exist.

__/update/address__<br>
Update an address, by using JSON in the body of the http request, in the following format:

    {
      "businessId": businessId,
      "street": street,
      "city": city,
      "state": state,
      "zip": zip
    }

where all fields are strings. Note that both a business and address must already exist with the given business id.

## Hours
__/hours__<br>
Retrives all hours in database, in JSON format (not recommended for large databases).

__/hours/{id}__<br>
Retrives a specific hours set, by the business_id field.

__/addhours__<br>
Add an hours set, by using JSON in the body of the http request, in the following format:

    {
      "businessId": businessId,
      "monday": monday,
      "tuesday": tuesday,
      "wednesday": wednesday,
      "thursday": thursday,
      "friday": friday,
      "saturday": saturday,
      "sunday": sunday
    }

where all fields are strings. Note that the business must exist, and an address must not already exist. Days can be left out, and will default to closed.

__/update/hours__<br>
Update an hours set, by using JSON in the body of the http request, in the following format.

    {
      "businessId": businessId,
      "monday": monday,
      "tuesday": tuesday,
      "wednesday": wednesday,
      "thursday": thursday,
      "friday": friday,
      "saturday": saturday,
      "sunday": sunday
    }

where all fields are strings. Note that the business and hours set must already exist with the given business_id. Days can be left out, and will default to closed. Note that any left out here will default, even if they were not "Closed" previously.

## Tips
__/tips__<br>
Retrives all tips in database, in JSON format (not recommended for large databases).

__/tips/business/{id}__<br>
Retrives all tips for a specific business, by the business_id field.

__/tips/user/{id}__<br>
Retrieves all tips for a specific user, by the user_id field.

__/addtip__<br>
Add a business, by using JSON in the body of the http request, in the following format:

  {
    "businessId": businessId,
    "userId": userId,
    "text": text,
    "complimentCount": complimentCount,
    "date": date
  }

where businessId, userId, text, and date are strings, complimentCount is a short. Note that a business and user with the given ids must already exist.

## Photos
__/photos__<br>
Retrives all photos in database, in JSON format (not recommended for large databases).

__/photos/{id}__<br>
Retrives photos for a business, by the business_id field.

__/addphotos__<br>
Add a business, by using JSON in the body of the http request, in the following format:

    {
      "businessId": businessId,
      "photoId": photoId,
      "caption": caption,
      "label": label
    }

where all fields are strings. Note that a business given id must already exist, and a photo with the given id must not exist.

# References
* When importing the data from JSON files to sql we used these pages:
  - [JSON to SQL](https://docs.microsoft.com/en-us/sql/relational-databases/json/import-json-documents-into-sql-server?view=sql-server-ver15)
  - [OPENROWSET](https://docs.microsoft.com/en-us/sql/t-sql/functions/openrowset-transact-sql?view=sql-server-ver15)
* When implementing React
  - https://codebun.com/search-record-from-a-table-in-react-js-spring-boot-and-mysql/
  - https://www.javaguides.net/2020/07/react-js-spring-boot-rest-api-example-tutorial.html
  - https://www.javaguides.net/2020/07/react-js-fetch-api-to-consume-spring.html#fromHistory
  - https://javascript.plainenglish.io/how-to-implement-a-search-bar-in-react-js-8cf8f5513b8e#fromHistory
* Celia Chen, personal correspondance
