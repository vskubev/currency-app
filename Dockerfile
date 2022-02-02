FROM openjdk:11
WORKDIR /app
EXPOSE 8080
ADD ./build/libs/currency-0.0.1-SNAPSHOT.jar currency.jar
CMD ["java", "-jar", "currency.jar"]