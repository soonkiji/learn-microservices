# setup
* cd /d %userprofile%
* mkdir config-repo
* cd config-repo
* git init .
* echo envname=World> search.properties
* git add -A .
* git commit -m "Added sample search.properties"

# config-server on port 8888
* cd config-server
* mvn spring-boot:run

# search on port 8090
* cd search
* mvn spring-boot:run
* curl http://localhost:8060/search/

# others
* curl http://localhost:8888/search/default
* curl http://localhost:8888/search/dev
* curl http://localhost:8888/refresh -d {} -X POST
