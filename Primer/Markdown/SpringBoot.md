# 一、SpringBoot基础内容

## 1. Spring和SpringBoot

### 1.1 Spring介绍

​	Spring（Spring Framework） 是一个开源框架，最早由Rod Johnson创建，并在《Expert One-on-One：J2EE Design and Development》这本著作中进行了介绍。Spring是为了解决企业级应用开发的复杂性而创建的，使用Spring可以让简单的JavaBean实现之前只有EJB才能完成的事情。但Spring不仅仅局限于服务器端开发，任何Java应用都能在简单性、可测试性和松耦合等方面从Spring中获益。

![](../img/SpringHistory.png)

### 1.2 SpringBoot介绍

​	SpringBoot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring 应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。简单来说,就是SpringBoot其实不是什么新的框架，它默认配置了很多框架的使用方式，就像Maven整合了所有的Jar包，SpringBoot整合了所有的框架。

## 2. SpringBoot2入门操作

### 2.1 在线构建

​	直接从Spring官网下载demo，解压到本地后，依赖导入完成后，即可直接运行。

### 2.2 本地构建

​	

## 3. 浅谈自动装配原理

​	`@SpringBootApplication`是一个组合注解，是自动装配的关键。内部包含：

- `@SpringBootConfiguration`：内部包含`@Configuration`，即启动类本质上也是Spring的配置类。
- `@EnableAutoConfiguration`：SpringBoot的依赖中，有一个`spring-boot-autoconfigure`包，其包含的META-INF包中有一个`spring.factories`文件。
  - SpringBoot会将组件的自动配置类的类名，通过键值对的方式，放在该文件中。
  - 开启自动配置，SpringBoot会加载这些自动配置类，完成自动配置。
- `@ComponentScan`：指定扫描路径，默认为当前类所在包和其子包。会扫描所有的`@Component`注解修饰的Bean。



# 二、SpringBoot核心功能

## 1. 配置文件

​	在SpringBoot中，配置文件有两种格式：

- `application.properties`：默认提供的，以键值对`(key=value)`的方式来配置。`server.port = 8080`
- `application.yaml`：一种标记语言。



### 1.1 配置文件介绍

​	yaml(YAML Ain't Markup Language)，可以缩写为yml。其实是Yet Another Markup Language。

### 1.2 语法规则

- `key: value`：`:`和`value`之间需要有空格。
- 区分大小写
- 使用缩进表示层级关系，缩进的空格数不重要，只需要相同层级对齐。
- `#`为注释
- 字符串不需要使用单引号或双引号包裹。

### 1.3 数据类型

​	yaml中的支持的数据类型很多，字面量、对象、数组均支持。

- 字面量：单个的、不可再分的值。date、boolean、string、number、null。
  - key: value
- 对象：键值对的集合。map、hash、set、object。

```yaml
# 行内写法：
key: {k1: v1, k2: v2, k3: v3}
key:
	k1: v1
	k2: v2
	ke: v3
```

- 数组：有序的数据。array、list、queue

```yaml
key: [v1, v2, v3]
key:
	- v1
	- v2
	- v3
```



### 1.4 使用案例

​	Person类

```java
@ConfigurationProperties(prefix = "person")
public class Person {
    private String username;
    private String address;
    private int age;
    private List<String> hobbys;
    private Map<String, Object> map;
    private Dept dept;
    private Map<String, List<Dept>> allDepts;
}
```

```yaml
person:
	username: moro
	age: 18
	address: wuhan
	# hobbys: [basketball, football, badminton]
	hobbys: 
		- bastetball
		- football
		- badminton
    # map: {k1: v1, k2: v2, k3: v3}
    map:
    	k1: v1
    	k2: v2
    	k3: v3
	# dept: {departId: 111, departName: jvm}
	dept:
		departId: 111
		departName: jvm
    allDepts:
    	k1: [{departId: 1, departName: 111}, {departId: 2, departName: 222}]
    	k2: [{departId: 1, departName: 111}]
    	k3: [{departId: 1, departName: 111}]
```

​	为了能够在yaml文件中能够有代码提示，需要加入入下依赖。

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```



## 2. WEB开发

### 2.1 静态资源文件

​	在web开发中，静态资源文件也是十分重要的内容。在SpringBoot中默认提供了这几个目录用于存放静态资源文件：

- `/static`
- `/public`
- `/resources`
- `META-INF/resources`

> ​	客户端发送的请求，Web服务器接收到后，会将请求路径交给DishpatcherServlet，后者会进行解析，并尝试查找与请求路径对应的controller。如果找不到对应的controller，就回去对应的静态资源目录下查找是否有符合的静态资源文件。如果静态资源处理器也无法处理，就会响应404。

​	SpringBoot中可以在`application.yaml`文件中配置静态资源目录和访问静态资源的*请求路径*。

```yaml
spring:
	# 给静态资源文件加上一个同一前缀
	mvc:
		static-path-pattern: /static/**
    # 定义静态资源文件存储的路径
    web:
    	resources:
    		static-location: [classpatch:/static]
```



### 2.2 请求参数处理

#### 2.2.1 注解

​	在控制器中，接收客户端传递的相关请求数据时，可以通过各种注解来接收。

- `@PathVariable`：请求路径中的数据
- `@RequestHeader`：请求头中的数据
- `@ModelAttribute`：
- `@RequestParam`：get请求的参数
- `@MatrixVariable`：
- `@CookieValue`：cookie的数据
- `@RequestBody`：请求体中的数据

#### 2.2.2 Servlet API

​	`HttpServletRequest`和`HttpServletResponse`对象来来处理数据。

​	还可以通过自定义的对象来接受前端传输来的数据。



### 2.3 响应数据处理-Thymeleaf整合

​	在SpringBoot项目中，常用的前端模板框架Thymeleaf。

​	添加依赖

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

​	设置thymeleaf

​	创建`templates`文件夹，项目相关的动态模板文件都存储在这个目录中。模板文件为html文件，需要用到thymeleaf的都需要在头部引入

```html
<html xmlns="http://www.thymeleaf.org"></html>
```

​	在controller中可以进行如下操作绑定数据

```java
@GetMapping("/user/query")
public String query(Model model, Map map) {
    model.addAttribute("msg", "thymeleaf的第一个数据");
    map.put("msg2", "thymeleaf的第二个数据");
    return "/user.html";
}
```



#### 2.4 日志和profile

​	SpringBoot支持Java Util Logging、Log4J、Log4J2和Logback作为日志框架，无论使用哪种日志框架，SpringBoot已为当前使用的日志框架的控制台输出及文件输出做好了配置,默认情况下，SpringBoot使用Logback作为日志框架。

```yaml
server:
  port: 8081
spring:
  thymeleaf:
    prefix: classpath:/templates/
    suffix: .html
logging:
  level:
    root: info

  file:
    name: d:/Coding/JavaDemo/SpringBootDemo/myapp.log
```

​	profile针对的是不同环境下的不同配置信息的支持。可以将开发、测试、发行的配置分别放置在`application-dev`, `application-test` `application-prod`中。然后新建一个`application.yaml`，其中指定需要加载的profile

```yaml
spring:
	profiles:
		active: prod
```



​	

### 2.4 视图解析

### 2.5 拦截器

### 2.6 文件上传

### 2.7异常处理

## 3. 整合MyBatis

​	首先，构建数据库。

​	然后，在项目中添加依赖。

```xml
<!--mybatis-->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>3.0.3</version>
</dependency>
<!--mysql-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.30</version>
</dependency>
```

​	接着，在`application.yaml`文件中，配置数据源和mybatis

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/spring-boot-demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
    driver-class-name: com.mysql.jdbc.Driver
    username: root
    password: 123123
mybatis:
  type-aliases-package: org.moroboshidan.pojo
  mapper-locations: classpath:mapper/**.xml
```

​	然后，做mybatis相关的应用配置。创建对应的mapper接口，并使用`@Mapper`修饰，在`resources`目录下创建`mapper`包，并创建同名`.xml`文件，编写sql语句。

​	并在启动类上添加`@MapperScan(basePackages = {"org.moroboshidan.mapper"})`注解，指定mapper接口位置。

## 4. 单元测试

​	在`test.java.org.moroboshidan`包下，有一个和启动类同名的测试类`SpringBootDemoApplicationTest`类。其类上有一个`@SpringBootTest`注解。该注解的作用是，执行测试方法时，会启动SpringBoot环境，和正常启动类一致。如果不使用该注解，就是普通的Junit测试类。其相关依赖为：

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

​	对于如service接口中的方法，如果想测试，可以直接右键类名，可以自动在测试包下生成同名包和测试类。

## 5. 整合Redis

​	添加依赖

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
	<groupId>org.apache.commons</groupId>
    <artifactId>commons-pool2</artifactId>
</dependency>
```

​	然后在`application.yaml`中添加对应的配置

```yaml
spring:
	redis:
		host: 127.0.0.1
		port: 6379
		password: 123123
		# 连接池
		
```



# 三、案例讲解

