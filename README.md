# Task Manager Backend App

This repository contains the backend code for a Task Manager application. The backend is built using Spring Boot and uses MySQL as the database to store task and user information.

## Installation

To get started with the Task Manager backend app, follow these steps:

1. Clone the repository to your local machine:


2. Navigate to the project directory:

    ```bash
    cd task-manager-backend
    ```

3. Ensure you have Docker installed on your machine. If not, download and install it from [Docker's official website](https://www.docker.com/).


4. Start the MySQL database using Docker Compose:

    ```bash
    docker-compose up -d
    ```

   This command will use the `docker-compose.yml` file to spin up a MySQL database instance.


5. Open `application.properties` located in `src/main/resources` and make sure the database connection settings are correctly configured:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/task_manager
    spring.datasource.username=root
    spring.datasource.password=password
    ```

   Replace `root` and `password` with your MySQL username and password if they are different.


6. Initialize the schema and tables by updating the Hibernate properties. Open `application.properties` and set:

    ```properties
    spring.jpa.properties.hibernate.hbm2ddl.auto=update
    ```

   This will update the schema based on your entity classes.


7. Run the Spring Boot application:


   The app will start and run on http://localhost:8080

## API Documentation

The Task Manager backend provides a RESTful API for managing tasks and users. The API documentation can be found at [API Documentation](task-manager-apis.postman_collection.json).

To import this collection into Postman, follow these steps:
1. Open Postman.
2. Click on 'Import' in the top left corner.
3. Select 'Import File' and choose the JSON file.
4. The collection will now be available in your Postman workspace.

Please note that all API calls require an Authorization to be included in the request.
To authenticate your API requests, you need to include an Authorization header with a valid token.

Feel free to contact me if you have any questions or need further assistance.

**Contact:**  
For inquiries, please email [saku.work.2k23@gmail.com](mailto:saku.work.2k23@gmail.com).
