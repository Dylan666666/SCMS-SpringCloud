# SCMS-SpringCloud
* 上一个项目 Supermarket-Management-System 的微服务版本
-----
* SOA架构，使用组件如下：
* Netflix的Eureka
* Rest方式调用，负载均衡，服务熔断 Feign、Ribbon、Hystrix
* Zuul网关
----
* 本项目采用Eureka做注册中心，对业务进行了相应的拆分，mapper层全部拆出来作为数据中心，Zuul作为网关拦截器（用作拦截、转发）
* 第一次试着做微服务拆分，本项目肯定有很多缺陷，日后我会系统学习分布式微服务技术并再次开发相应项目
