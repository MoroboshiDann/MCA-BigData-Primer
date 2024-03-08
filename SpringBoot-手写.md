# 前置知识

## 1. spring web程序执行的大致原理

​	首先，Spring Web程序有一个启动类Application.java。其被`@SpringBootApplication`注解修饰。该类的`main()`方法中，调用了`SpringApplication.run()`，是SpringBoot的一个类的静态方法。执行启动类的`main()`方法，程序便开始执行。

​	`@SpringBootApplication`注解，其表明该注解修饰的是一个SpringBoot的启动类。该注解内部包含了：

- `@SpringBootConfiguration`：本注解修饰的类是Spring的配置类，其中包含了`@Configuration`注解。
- `@ComponentScan`：Spring提供的，通过注解的方式来扫描SpringBean，会扫描指定包下被`@Component`修饰的类。默认路径就是该注解所在位置的包及子包。

​	

​	`SpringApplication`是SpringBoot的一个类，其内部最主要的方法为`run()`，一个静态方法。启动类调用这个方法，并将启动类的字节码传入。在`run()`方法中，需要做如下操作：

- 获取一个Spring容器：由于SpringBoot的配置是基于注解实现的，所以通常会获取一个`AnnotationConfigWebApplicationContext`容器。
- 根据配置类的字节码文件来设置Spring容器：调用`applicationContext.register(clazz)`方法，并将启动类的字节码文件传入。为Spring容器指定相应的SpringBean的信息。
- 启动容器：通过容器调用`applicationContext.refresh()`方法，来启动容器。
- 创建并启动WebServer服务器



## 2. 创建Tomcat的过程

​	Tomcat是WebServer，是Spring默认使用的。创建Tomcat服务器，通常包含以下几个主要步骤：

- 申请内置的Tomcat对象
- 为Tomcat服务器指定端口号、域名
- 为Tomcat创建并指定Servlet，并为Servlet指定SpringIoC容器 
- 指定Tomcat需要处理的请求路径
- 启动Tomcat

> 在SpringMVC模式下，Tomcat服务器在接收到请求之后，会将请求交给Servlet来处理，而不是自己处理。
>
> 因此，需要创建一个`DispatcherServlet`对象，并且将`SpringApplication`中创建的SpringIoC容器传入`DispatcherServlet`。因为前端控制器会根据请求路径来调用响应的controller，如果不指定容器就会无法工作。



## 3. 如何实现开箱即用与可插拔

​	以WebServer为例。Spring中默认使用的web Server为Tomcat，因此，我们无需配置WebServer，也无需添加依赖，即可使用。而如果我们想使用其他WebServer，只需要添加对应依赖，如Jetty，并在添加依赖时使用<exclusion>标签来排除Tomcat即可。

​	为了能够实现上述功能，首先需要写一个`WebServer`接口，来规定每个WebServer的共性操作工。根据每个WebServer提供一个类，实现`WebServer`接口。然后，需要一个`WebServerAutoConfiguration`的自动配置类，用`@Configuration`修饰，其内部提供如`getTomcatWebServer()`等方法，来获得对应的WebServer对象。并在每个方法上都添加`@Bean`注解，让SpringIoC容器能够管理这些WebServer的Bean。

​	而上述操作会注册多个Bean，导致`WebServer`有多个实现类，Spring容器无法正常管理。因此，需要引入`@Conditional`注解，每个`@Bean`注解下都要添加一个，该注解需要传入一个实现了`Condition`接口的类的字节码文件。

​	实现`Condition`接口，需要重写`matches()`方法，该方法返回值为`boolean`，若为true，则被修饰的方法返回值被标记为`@Bean`。则在方法内部，就需要通过类加载器来读取对应WebServer的jar包，如果能读取到就返回true，表明导入了该类的依赖。

​	基于上述操作，实现了可插拔，项目中需要哪个WebServer就导入对应的依赖。我们的手写SpringBoot就能够启动对应的WebServer。

​	为了能够让我们的手写SpringBoot能够读取到`WebServerAutoConfiguration`这个配置类，就需要在启动类上使用`@Import(WebServerAutoConfiguration)`注解，来导入自定配置类。

> ​	在上述操作之后，我们仅仅只是解决了WebServer的开箱即用和可插拔。但是，我们用到了`@Import`注解，因此，以后所有的插件如数据库相关的MySQL，和数据库操作的MyBatis，我们都需要在启动类上添加`@Import`注解来添加对应的自动配置类。



## 4. 自动导入自动配置类

​	为了解决上面提出的导入自动配置类的问题，Spring提出了一种规范：在SpringBoot的jar包中，有一个`spring.factories`文件，将所有的自动配置类通过键值对的方式写入到该文件中。然后，通过`@Import`注解，导入一个`ImportSelector`实现类，来完成批量导入自动配置类。

​	`@Import`注解可以传入三类对象：

- `@Configuration`注解修饰的类字节码对象
- `ImportSelector`类的实现类字节码对象
- `ImportBeanDefinitionRegister`类的实现类字节码对象

​	因此，我们可以自己创建一个`MyImportSelector`类，实现`ImportSelector`接口，重写其中的`selectImports()`方法，将自动配置类的全路径名放在返回数组中，即可完成自动导入自动配置类。

> ​	在Spring中，它先将`spring.factories`文件中的，以`EnableAutoConfiguration`为key，的键值对取出，然后加载自动配置类。
>
> ​	并且，为了节省资源，在一些自动配置类的相关以来没有导入时，如`Rabbit`，不会加载该自动配置类。这是因为，在自动配置类上会添加`@ConditionalOnClass`注解，当对应的依赖没有导入时，不加载自动配置类。
>
> ​	`@ConditionalOnClass`注解回传入一些类的字节码文件，当这些类存在时，被修的的类才会生效。
>
> ​	而Spring为了判断一个自动配置类是否生效，需要先加载该自动配置类，然后再加载条件中的类，判断@ConditionalOnClass是否生效。这样十分浪费资源，因为大部分自动配置都时不生效的。
>
> ​	因此，SpringBoot的另一个规范，将`@ConditionalOnClass`条件中的类，写到`spring-autoconfigure-metadata.properties`文件，这样就可以直接加载条件中的类，来直接判断是否生效了。这就是启动优化。



## 5. 自动配置类的作用

​	SpringBoot通过自动配置类，将程序中每个部分可能用到的所有的Bean，提前配置好。通过SpringBoot开发，只需要导入相关的依赖，就可以让容器管理对应的Bean。而为了能做到开箱即用，SpringBoot将所有的依赖都导入了。因此，即使不配置也可以直接运行程序。

​	当程序员想要对某一个Bean进行自己定义。就需要让SpringBoot配置的对应的Bean失效。这需要在自动配置类中使用`@ConditionalOnMissBean`，即当容器中缺失这一类型的Bean才会生效。
