# ejemploSeleniumWeb

## Build docker image
`docker build -t ejemplo-selenium .`

## Run docker
`docker run --rm selenium-java:latest mvn test`
### Mounting Volume
`docker run --rm -it -v $(pwd):/app selenium-java:latest mvn test`
