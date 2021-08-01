# Simple Spring Boot Web application

## Prerequisites

  - Installed Java 11
  - Installed Maven >= 3.8.x to run `mvn spring-boot:run`

## How to run

  - Run `mvn spring-boot:run` in the command line
  - Navigate to [http://localhost:8080](http://localhost:8080) for basic check
  - Quick endpoint check (commands uses [HTTPie](https://httpie.io/))
    - `http --auth user:password :8080/v1/users`
    - `http --auth user:password POST :8080/v1/users/ name=mibo password=test`
    - `http --auth mibo:test :8080/v1/users`
    - `http --auth mibo:test PUT :8080/v1/users/mibo name=mibo password=test2021`
    - `http --auth mibo:test :8080/v1/users`
    - `http --auth mibo:test2021 :8080/v1/users`

## Additional links

  - Access [http://localhost:8080/v1/service/health](http://localhost:8080/v1/service/health) which is open
  - Access [http://localhost:8080/v1/users/](http://localhost:8080/v1/users/) which requires authentication (`user/password`)