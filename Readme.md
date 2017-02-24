基于 spring cloud 的代码开发示例。

-- microservice-serviceprovider-user (service服务)

-- microservice-client-user (client订阅)

-- microservice-discovery-eurak (eurak服务端)

-- microservice-serprovider-user-eurekaclient (eurak客户端)
	注意：启动client，完成eureka注册后，访问eureka 服务器的的地址是
	  	 http://localhost:8761/ 
	  	 （不是 http://localhost:8761/eureka ）
	  	 详细可参看该 项目下readme.md
	  	 
-- microservice-client-user-ribbon (增加ribbon，访问 microservice-serprovider-user-eurekaclient微服务中
	的  UserController.class 下 /simple/{id} 的 URI)

相关链接：
http://projects.spring.io/spring-cloud/  右侧 （手册  Reference）
http://cloud.spring.io/spring-cloud-static/Camden.SR1/#netflix-eureka-client-starter

Github 地址：
https://github.com/cnliuy/microservice-service-cloud.git


