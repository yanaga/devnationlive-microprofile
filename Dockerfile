FROM jboss/base-jdk:8
  
EXPOSE 8080

USER jboss

CMD java -Djava.net.preferIPv4Stack=true -jar /opt/jboss/demo-swarm.jar

ADD target/demo-swarm.jar /opt/jboss
