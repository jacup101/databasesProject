# databasesProject

# Frontend
For this project we implemented the frontend using [React](https://reactjs.org/), which splits the project into different components.
The three main components are for the layout, businesses, and reviews.
These are completed components and the business and review components have a respective service defined in the "service" directory.
The components defing the display that users are going to see and interacte with, while the service enhances the functionality of the app, defining the methods used to query our database.
At the moment, a searchbar is defined in both the business and review components, but further developments will have a single search bar component for each of our entities.

At the beginning, the index.js is called and renders the defined components and calls a sequence of components: App.js -> LayoutComponent.js -> BusinessComponent.js & ReviewComponent.js.
The LayoutComponent defines the layout of the web app, creating the environment for the columns and sections.
The BusinessComponent and ReviewComponent each query the database, once when mounted (i.e. initially rendered) and when a search is made via the searchbar. The queries are made to the backend (i.e. Springboot) via the [fetch API](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API), and the data is passed back to the frontend as JSON.
This data can then be rendered using React and is displayed as a table.


# References
* When importing the data from JSON files to sql we used these pages:
  - [JSON to SQL](https://docs.microsoft.com/en-us/sql/relational-databases/json/import-json-documents-into-sql-server?view=sql-server-ver15)
  -     [OPENROWSET](https://docs.microsoft.com/en-us/sql/t-sql/functions/openrowset-transact-sql?view=sql-server-ver15)
* When implementing React
  - https://codebun.com/search-record-from-a-table-in-react-js-spring-boot-and-mysql/
  - https://www.javaguides.net/2020/07/react-js-spring-boot-rest-api-example-tutorial.html
  - https://www.javaguides.net/2020/07/react-js-fetch-api-to-consume-spring.html#fromHistory
  - https://javascript.plainenglish.io/how-to-implement-a-search-bar-in-react-js-8cf8f5513b8e#fromHistory
