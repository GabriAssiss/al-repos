FROM maven:3.9.9 AS deps

WORKDIR /app

COPY pom.xml .

RUN mvn go-offline:resolve-dependencies

FROM maven:3.9.9 AS run

WORKDIR /app
COPY --from=deps /root/.m2/repository /root/.m2/repository
COPY . /app

CMD ["mvn", "spring-boot:run", "-Dspring.devtools.restart.enabled=true", "-Dspring-boot.run.profiles=dev", \
	"-Dspring.devtools.livereload.enabled=true"]

