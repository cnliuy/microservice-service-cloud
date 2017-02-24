添加  eureka client 功能。需要修改两处 （全方位的修改需要调整第三处）：

    1. pom.xml 添加 
     <dependency>
        	<groupId>org.springframework.cloud</groupId>
        	<artifactId>spring-cloud-starter-eureka</artifactId>
    	</dependency>
    	
    2. MicroserviceClientUserApplication.class
    	  添加 @EnableEurekaClient 注解。
    	  
    3. application.yml 添加 application属性和 ip访问等属性    
      spring:
        application:
           name: microservice-serprovider-user-eurekaclient #保持小写
           
      #eureka client new add  ----注意缩进
      eureka:
        client:
          service-url:
            defultZone: http://localhost:8761/eureka
        instance:
            prefer-ip-address: true   #set show ipadress
            instance-id: ${spring.application.name}:${spring.application.instance_id:${server.port}}
      
         
         
         