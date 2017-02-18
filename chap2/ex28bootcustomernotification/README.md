# example
* hal browser
* h2
* jpa
* spring controller, curl
* amqp, rabbitmq on docker
* sprint mail, fakesmtp

# smtp
* fakesmtp.bat

# mq
* docker-rabbitmq.bat

# hal endpoints
* http://localhost:8080

# jpa rest endpoints
* http://localhost:8080/customers
* http://localhost:8080/customers/1
* http://localhost:8080/customers/search
* http://localhost:8080/customers/search/findByName?name=Harry
* http://localhost:8080/customers/search/findByName{?name}
* http://localhost:8080/customers?page=0
* http://localhost:8080/customers?size=2&page=1&sort=name
* http://localhost:8080/profile/customers

# spring controller
* http://localhost:8080/register POST

# register customer
* curl -X POST http://localhost:8080/register -d "{\"name\":\"Four\",\"email\":\"four@gmail.com\"}" -H "Content-Type: application/json"
