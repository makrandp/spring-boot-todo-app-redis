# Java Spring boot Todo app backed by Jedis (Redis Client) using docker with hot reload using spring boot dev-tools

## Setup
- `docker-compose up --force-recreate`
- In Eclipse:
  - Go to Run -> Run Configurations -> Java Application -> New
  - Choose `org.springframework.boot.devtools.RemoteSpringApplication` as the `main class`
  - Choose `todo-app-redis` as the project
  - Set http://localhost:80 to program arguments

## Useful Commands
- `docker-compose up --force-recreate -d`
- `docker-compose start`
- `docker-compose stop`
- `docker-compose down --rmi all`

## APIs
- `curl --request GET \
    --url http://localhost/cache/todo/1`
- `curl --request POST \
    --url http://localhost/cache/todo \
    --header 'content-type: application/json' \
    --data '{
  	"id" : 1,
  	"title" : "Title",
  	"description" : "Description"
  }'`
