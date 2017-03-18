# Spring Boot Drools Web Service

Simple project for creating a Spring Boot Drools Web Service

## Projects

### webservice

Based on the work done by Scattercode - [https://scattercode.co.uk/2015/02/06/a-minimal-spring-boot-drools-web-service/](https://scattercode.co.uk/2015/02/06/a-minimal-spring-boot-drools-web-service/)

### spring-boot-starter-drools

Based on the work done by Janine Eichler [https://github.com/jeichler/spring-boot-starter-drools](https://github.com/jeichler/spring-boot-starter-drools)


## Execute

__**Note:**__ Requires the installation of `jq` details here: [https://stedolan.github.io/jq/download/](https://stedolan.github.io/jq/download/)

### Start Web Service

    mvn clean install
    cd webservice
    mvn spring-boot:run

### Execute Web Service Call

Test for a Child Bus Pass

    ccurl -s "http://127.0.0.1:8080/buspass?name=Steve&age=15" | jq .

returns

    {
      "person": {
        "name": "Steve",
        "age": 15
      },
      "busPassType": "ChildBusPass"
    }

Test for a Adult Buss Pass

    curl -s "http://127.0.0.1:8080/buspass?name=Steve&age=16" | jq .

returns

    {
      "person": {
        "name": "Steve",
        "age": 16
      },
      "busPassType": "AdultBusPass"
    }