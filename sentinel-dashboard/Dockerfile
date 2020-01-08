FROM openjdk:8-jdk-alpine

ARG SENTINEL_VERSION="1.7.1"

WORKDIR /home/sentinel

RUN adduser -S sentinel && \
    apk add --no-cache tzdata && \
    cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" >  /etc/timezone && \
    rm -rf /var/cache/apk/*
COPY target/sentinel-dashboard.jar .
USER sentinel

EXPOSE 8080
CMD java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "/home/sentinel/sentinel-dashboard.jar"