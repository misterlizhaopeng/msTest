# 基于哪个镜像
FROM java:8
# 复制文件到容器
# ADD microservice-eureka-server-0.0.1-SNAPSHOT.jar /app.jar
ADD config-server-1.0.jar /app.jar
# 声明需要暴露的端口
EXPOSE 5566
# 配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","/app.jar"]
# ENTRYPOINT ["java","-jar","/app.jar --spring.profiles.active=e1"]
#ENTRYPOINT ["java","-Dspring.profiles.active=e1","-jar","/app.jar"]
