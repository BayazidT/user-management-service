# Build stage
FROM maven:3.8.4-eclipse-temurin-17 as builder

ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME

# Copy the source code into the container
COPY . .

# Build the project
RUN mvn clean install

# Runtime stage
FROM eclipse-temurin:17-jdk-alpine

ENV HOME=/opt/app
RUN mkdir -p $HOME
WORKDIR $HOME

# Set the timezone
RUN rm -f /etc/localtime \
&& ln -sv /usr/share/zoneinfo/Asia/Dhaka /etc/localtime \
&& echo "Asia/Dhaka" > /etc/timezone

# Copy the built jar from the builder stage
COPY --from=builder /usr/app/target/trstoreapi-0.0.1-SNAPSHOT.jar /opt/app/trstoreapi-0.0.1-SNAPSHOT.jar

# Expose the port
EXPOSE 8088

# Command to run the application
ENTRYPOINT ["java", "-jar", "/opt/app/trstoreapi-0.0.1-SNAPSHOT.jar"]
