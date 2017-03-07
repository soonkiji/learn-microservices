# spring boot config server
* cd /d %userprofile%
* mkdir config-repo
* cd config-repo
* git init .
* echo envname=World> search.properties
* git add -A .
* git commit -m "Added sample search.properties"

# config-server
* cd config-server
* mvn spring-boot:run
* curl http://localhost:8888/search/default
* curl http://localhost:8888/search/dev
* curl http://localhost:8888/refresh -d {} -X POST

# search
* cd search
* mvn spring-boot:run
* curl http://localhost:8060/search/
