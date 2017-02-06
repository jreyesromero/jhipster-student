FROM openjdk:8-jre-alpine

ENV JHIPSTER_SLEEP 0

# add directly the war
ADD target/*.war /app.war

RUN sh -c 'touch /app.war'
VOLUME /tmp
EXPOSE 8080 5701/udp
CMD echo "The application will start in ${JHIPSTER_SLEEP}s..." && \
    sleep ${JHIPSTER_SLEEP} && \
    java -Djava.security.egd=file:/dev/./urandom -jar /app.war
