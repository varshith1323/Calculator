FROM openjdk:21
COPY ./target/calculator-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java","-cp","calculator-1.0-SNAPSHOT-jar-with-dependencies.jar","org.example.Main"]