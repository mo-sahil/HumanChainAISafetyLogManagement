# HumanChain AI Safety Incident Log Management
A simple RESTful API built with Spring Boot and MongoDB to log and manage hypothetical AI safety incidents, with a static frontend built using HTML, CSS, and JavaScript. This project is part of a take-home assignment to demonstrate backend development skills and API design.

## Features
- Log new AI safety incidents
- View all incidents
- Get incident details by ID
- Delete incidents by ID

## Tech Stack
- Spring Boot (Java)
- MongoDB
- HTML, CSS, JavaScript (Vanilla)
- maven

## Installation

1. Clone the repo
```bash
git clone https://github.com/mo-sahil/HumanChainAISafetyLogManagement
cd HumanChainAISafetyLogManagement
```
2. Set up MongoDB locally or use MongoDB Atlas.
3. Add environment variables in application.properties:
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/human_chain_db
```
4. Build and run the backend
```bash
./mvnw spring-boot:run
```
5.Open http://localhost:8080/ in your browser to access the frontend.

## API Endpoints

### Get All Incidents
`GET /incidents`

### Create a New Incident
`POST /incidents`
```json
{
  "title": "Example Incident",
  "description": "Something went wrong",
  "severity": "High"
}
```

### Get Incident by ID
`GET /incidents/{id}`

### Delete Incident by ID
`DELETE /incidents/{id}`

## Project Structure
```
├── main/
│   ├── java/com/example/HumanChainIncidentAPI/
│   │   ├── controller/IncidentController.java
│   │   ├── model/Incident.java
│   │   ├── repository/IncidentRepository.java
|   |   ├── dto/IncidentRequest.java
|   |   ├── service/IncidentService.java
|   |   ├── exception/IncidentNotFoundException.java
│   │   └── HumanChainApiApplication.java
│   └── resources/
│       ├── static/
│       │   ├── index.html
│       │   ├── style.css
│       │   └── app.js
│       └── application.properties
```

## Author
### Mo Sahil
[Github](http://github.com/mo-sahil) - [LinkedIn](https://www.linkedin.com/in/mosahil1/) - [Email](mailto:sahilbmu@gmail.com)
