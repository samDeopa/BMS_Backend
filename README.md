
```markdown
# Book My Show Backend Application

BookMyShow is a movie ticket booking system project. This backend application is developed using Spring Boot and consists of various layers such as Controller, Service, Repository, and DTO (Data Transfer Object). These layers increase the project's code maintainability, understandability, and readability.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Booking System:** Users can book tickets and find shows.
- **Movie Search:** Allows users to search for movies.
- **API Endpoints:** Provides 10-12 API endpoints for various functionalities.
- **Spring Boot:** Utilizes Spring Boot for application configuration.
- **JPA Hibernate:** Uses JPA Hibernate for database interactions.
- **Maven:** Builds and manages the project using Maven.
- **Postman:** API testing and development.

### What BookMyShow Project Can Do

#### For Admins:
Admins can:
- Add a Movie.
- Add a Theater.
- Add Theater Seats.
- Create a Show for any Movie in any theater.
- Create Show Seats for booking purposes.

#### For Users:
Users can:
- Get the Show details.
- See the Show Seats.
- Book the Ticket for available seats.
- Cancel the Ticket.

### Different Models / Entities / Tables in MySQL

- **User Entity**
- **Movie Entity**
- **Theater Entity**
- **Show Entity**
- **Theater Seat Entity**
- **Show Seat Entity**
- **Ticket Entity**

## Technologies Used

- **Backend:**
  - Spring Boot
  - JPA Hibernate (MySQL DB)
  - Maven

- **Tools:**
  - Postman

## Setup and Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/samDeopa/Student_Library_Management_System.git
   cd Student_Library_Management_System
   ```

2. **Configure the MySQL Database:**
   - Ensure MySQL is installed and running.
   - Create a database named `book_my_show_db`.
   - Update the `application.properties` file with your MySQL username and password.

3. **Build and Run the application:**
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```

## Usage

1. **API Endpoints:**
   - Use Postman to test the various API endpoints provided by the application.
   - Sample endpoints include booking tickets, finding shows, and searching for movies.

2. **Booking Tickets:**
   - Endpoint: `/api/bookings`
   - Method: POST
   - Description: Book tickets for a show.

3. **Finding Shows:**
   - Endpoint: `/api/shows`
   - Method: GET
   - Description: Retrieve a list of available shows.

4. **Searching Movies:**
   - Endpoint: `/api/movies`
   - Method: GET
   - Description: Search for movies by title or genre.

## Project Structure

```
book-my-show-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── bookmyshow/
│   │   │           ├── controller/
│   │   │           ├── model/
│   │   │           ├── repository/
│   │   │           └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
├── pom.xml
└── README.md
```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any bugs, enhancements, or features you would like to add.

1. **Fork the repository:**
   ```sh
   git fork https://github.com/samDeopa/Student_Library_Management_System.git
   ```

2. **Create a new branch:**
   ```sh
   git checkout -b feature-branch
   ```

3. **Make your changes and commit them:**
   ```sh
   git commit -m "Description of changes"
   ```

4. **Push to the branch:**
   ```sh
   git push origin feature-branch
   ```

5. **Open a pull request:**
   - Go to the repository on GitHub and open a pull request.




