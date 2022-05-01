# Yalp

Yalp is a project that seeks to recreate Yelp, using the public dataset available at [yelp.com/dataset]. This project is currently split into two pieces, a front end built using REACT.JS, which interacts with a local database, and a backend built using Spring boot. The database ER diagram and schema for the database construction can be found [here](https://docs.google.com/document/d/149_Xzw38OxuVXO0Zw7oQ7iNSDs5ZToJ21riY9bWRQAk/edit?usp=sharing). Detailed instructions on running the front-end and back-end can be found below.
# Backend

Our backend is currently run on a remote server (http://joshuapulido.com:8080/api/v1). Below are instructions for interacting with this remote database.

__http://joshuapulido.com:8080/api/v1__



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
