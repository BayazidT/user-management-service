#step 1
FROM maven:3.8.4-eclipse-temurin-17 as builder

ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME

COPY . $HOME

ARG GITHUB_TOKEN
ENV MAVEN_REPO_TOKEN=$GITHUB_TOKEN

ARG GITHUB_USER
ENV MAVEN_REPO_USER=$GITHUB_TOKEN


RUN mvn dependency:go-offline -B -s settings.xml
ENV PROFILE=dev
ENV ACC_CONFIG_SERVER_URL=http://122.152.48.180:9543
RUN mvn clean install -s $HOME/settings.xml
RUN mvn package spring-boot:repackage -s $HOME/settings.xml -f $HOME/infrastructure/pom.xml

#step 2
FROM eclipse-temurin:17-jre-alpine 

RUN rm -f /etc/localtime \
&& ln -sv /usr/share/zoneinfo/Asia/Dhaka /etc/localtime \
&& echo "Asia/Dhaka" > /etc/timezone

WORKDIR /opt/app
ENV PROFILE=dev
EXPOSE 7772

COPY --from=builder /usr/app/infrastructure/target/infrastructure-0.0.1.jar /opt/app/infrastructure-0.0.1

ENTRYPOINT ["java", "-jar", "/opt/app/infrastructure-0.0.1" ]