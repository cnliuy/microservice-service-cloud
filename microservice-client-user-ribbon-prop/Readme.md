###3.使用 ribbon properties 设置 

###2.添加 ribbon自定义功能
添加 TestConfiguration.class
修改 MicroserviceClientUserRibbonApplication.class
       添加注释  @RibbonClient(name = "microservice-serprovider-user-eurekaclient", configuration = TestConfiguration.class)
       
TestConfiguration.class 放在 com.liuy.cloud 外面，不在  MicroserviceClientUserRibbonApplication.class 类的扫包描内。才能完成定制化开发。       

###1.添加  ribbon 功能。
参考: http://cloud.spring.io/spring-cloud-static/Camden.SR3/#netflix-ribbon-starter

    eureka-include-ribbon.png 显示 已包含 ribbon的所需包      
    
    1. MicroserviceClientUserRibbonApplication.class 内添加注解 @LoadBalanced
              如下:
    	 @Bean
	 @LoadBalanced   (新添加)
	 public RestTemplate restTemplate() {
	     return new RestTemplate();
	 }
	 
    2.ClientuserController 的 findById() 方法的
      this.restTemplate.getForObject("http://microservice-serprovider-user-eurekaclient/simple/" + id, User.class);
                其中 /simple/{id} 对应 微服务 microservice-serprovider-user-eurekaclient 项目中 UserController.class的   
        @GetMapping("/simple/{id}")
        public User findById(@PathVariable Long id) {}
                方法。
  

###0.添加  eureka client 功能。需要修改两处 （全方位的修改需要调整第三处）：

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
            
            
            
   
         
         