# 项目介绍

```text
Spring in action学习
```

## 启动Nexus
```text
Path：X:\Nexus\nexus-3.20.1-01-win64\nexus-3.20.1-01\bin
启动命令：.\nexus.exe /run
页面链接：http://localhost:8081/
用户名：admin
密码：admin
工作目录：X:\Nexus\nexus-3.20.1-01-win64\sonatype-work\nexus3
```

## 启动Tomcat(Jenkins自动部署之前需要先启动Tomcat)
```text
Path：X:\servers\apache-tomcat-9.0.37-8888
启动命令：bin目录里面执行startup.bat
页面链接：http://localhost:8888/
```

## 启动jekins
```text
Path：D:\Program Files (x86)\Jenkins
启动命令：java -jar jenkins.war --httpPort=8080
页面链接：http://localhost:8080/
用户名：admin
密码：admin
工作目录：D:\Program Files (x86)\Jenkins
```

## 启动Artemis
```text
Path：X:\Artemis\apache-artemis-2.15.0\bin\myartemis\bin
启动命令：.\artemis.cmd run
网页地址：http://localhost:8161/
默认监听端口号：61616
```

## 微服务
```text
Path：microservice_registry + microservice_service + microservice_client
microservice_registry：注册中心，http://localhost:8761/
microservice_service：微服务提供者
microservice_client：微服务消费者，http://localhost:8888/ingredients
```
