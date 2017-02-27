启动client 注册后，访问eureka的地址是 http://localhost:8761/

一些注释 参看 show1.png , show2.png .

show3.png 显示的是  添加erueka用户名密码验证时需要的 依赖项 （现程序中没有）

--------------

Using the EurekaClient 开发手册（5*）
http://cloud.spring.io/spring-cloud-static/Camden.SR1/#_using_the_eurekaclient


https://jmnarloch.wordpress.com/2015/09/02/spring-cloud-fixing-eureka-application-status/
Spring Cloud: Fixing Eureka application status
关于erueka 健康检查的 文章

https://github.com/Netflix/eureka/wiki/Eureka-at-a-glance
show4.png 系统架构图 

--------------
重点：

负载均衡问题 ，两个本项目，在 application.yml中，分别设置不同的端口 启动即可。
客户端通过 ribbon 和 eureka ，是这两个同项目（不同端口），实现负载均衡。由于配置
在客户端即ribbon上配置的，所以称为 客户端负载均衡。



