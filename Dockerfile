FROM lippert/adoptopenjdk-17

# Copy files
COPY /src/main/resources /etc/resources

COPY ./docker-entrypoint.sh /
ADD /target/syscode.test-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8199
EXPOSE 40002

ENTRYPOINT [ "/docker-entrypoint.sh" ]
