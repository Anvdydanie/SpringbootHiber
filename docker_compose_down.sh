docker-compose down
docker rmi $(docker images -f "dangling=true" -q)
mvn clean