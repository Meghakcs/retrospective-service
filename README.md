# retrospective-service


How to Run:

1. Clone this repository
2. Make sure you are using JDK 1.8 and Maven 3.x above
3. Import the project in STS and build the project.


To Test the API in Postman:

1. Create Retrospective API:
http://localhost:8080/retrospective/createRetrospective

2. Get all Retrospective with pagination:
http://localhost:8080/retrospective/getRetrospects?currentPage=0&pageSize=2


3. To Filter By Date
http://localhost:8080/retrospective/getRetrospects?currentPage=0&pageSize=2

4. To update Feedback Body and type:
http://localhost:8080/retrospective/updateFeedbackDetails


5. To create new Feedback for existing Retrospective:
http://localhost:8080/retrospective/updateFeedback