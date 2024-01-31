# 一、SpringMVC概述

SpringMVC属于SpringFramework的后续产品，已经融合在SpringWebFlow里面。Spring框架提供了构建Web应用程序的全功能MVC模块。使用Spring可插入的MVC架构，从而在使用Spring进行Web开发时，可以选择Spring的SpringMVC框架，或继承其他MVC开发框架，如Struts1，Struts2等。

| M(Model)      | 模型层 | DAO封装 >>> MyBatis   |
| ------------- | ------ | --------------------- |
| V(View)       | 视图层 | HTML，CSS，JS，JSP    |
| C(Controller) | 控制层 | Servlet >>> SpringMVC |

特点：

- SpringMVC时Spring为展现层提供的基于MVC设计理念的优秀Web框架，是目前最主流的MVC框架之一
- SpringMVC通过一套注解，可以让普通的Java类称为controller控制器，无虚继承Servlet，实现了控制层和Servlet之间的解耦
- SpringMVC支持Rest风格的URL写法
- SpringMVC采用了松耦合，可插班的主键结构，比其他的框架更具灵活性和扩展性



前端控制器(DispatcherServlet)，根据请求路径找到对应的controller



工作流程

- tomcat将项目打包为war，并启动项目
- 根据`web.xml`中的配置，指定将请求映射到对应`controller`的前端控制器`DispathcerServlet`。并指定spring的配置文件路径`classpath:springmvc.xml`
  - 如果不使用`<init-param>`来指定springMVC配置文件的路径，那么DispatcherServlet会自动到WEB-INF目录下找指定名字的配置文件`<servletname>-servlet.xml`。
- `springmvc.xml`中指定了spring的扫描路径，会将路径下带有`@Component`注解或其变形的类加载为Bean
- 当有请求发起时，`DishpatcherServlet`会根据请求路径，将请求交给对应的`controller`来处理。
- `controller`内的请求处理方法，需要通过`@RequestMapping`来指定该方法对应的请求路径。



配置文件的注意事项：

- `@RequestMapping`注解既可以放在方法上，可以放在类上。如果两者被该注解修饰，则访问时需要将两个路径拼接起来才能正常访问。并且返回的jsp文件需要放在类上注解的路径内才能正常返回
- 如果jsp文件没有放在`WEB-INF`文件下，而是放在了内部的一个二级目录下。controller方法的返回值就需要写出全路径名才能正常访问。
  - 如果想简化路径，就需要在`springmvc.xml`文件中配置视图解析器。



执行流程

![](..\img\springMvcProcess.png)

![](..\img\springMvcProcess2.png)

- DispatcherServlet：前端控制器。用户请求到达前端控制器，它就相当于MVC模式中的C，DispatcherServlet就是整个流程控制的中心，由它来调用其他组件处理用户的请求。DispathcerServlet降低了组件之间的耦合程度。
- HandlerMapping：处理器映射器。它负责根据用户请求找到Handler，SpringMVC提供了不同的映射方式，如：配置文件方式、实现接口方式、注解方式等。
- Handler：处理器，它就是我们开发中需要编写的具体业务控制器(Controller)。由DispatcherServlet将用户请求转发至Handler。由Handler对具体的请求进行处理。
- HandlerAdapter：处理器适配器。通过HandlerAdapter对处理器进行执行，是适配器模式的应用，通过扩展适配器，可以对更多类型的处理器进行执行。
- ViewResolver：视图解析器。负责将处理结果生成View视图。首先根据逻辑视图名解析成物理视图名，再生成View视图对象，最会对View进行渲染碱处理结果通过页面展示给用户。
- View：视图。SpringMVC框架提供了很多类型视图的支持，最常用的视图就是jsp。一般情况下需要通过页面标签或者页面模板技术将模型数据通过页面展示给用户，需要程序员根据业务需求开发具体的页面。
- 



SpringMVC三大核心组件：

- HandlerMapping，处理器映射器
  - 实现类RequestMappingHandlerMapping，会处理@RequestMapping注解，将其映射到请求映射表中。
- HandlerAdapter，处理器适配器：即在controller中选择方法来处理。
  - 实现类RequestMappingHandlerAdapter，是处理请求的适配器，确定调用哪个类的哪个方法，并且构造方法参数，返回值。
- ViewResolver，试图解析器

> 当在springmvc.xml配置文件中使用了`<mvc:annotation-driven/>`，会启用注解驱动，然后Spring会通过`<context:component-scan/>`标签的配置，会自动将扫描到的@Component, @Controller, @Service, @Repository等注解标记的组件注册到工厂中



静态资源放行

如果请求的返回值为一个jsp文件，前端为了渲染这个页面，还需要再发三个请求，分别请求aaa.css, bbb.js, logo.png

而前端的请求都会经过前端控制器DispatcherServlet，而这些请求都没有请求路径，因此解析过以后找不到对应的Handler，因此如果不对静态资源放行，就会报404错误。

静态资源放行就是对于这些请求直接放行，让前端直接去资源文件夹下找即可

`<mvc:resources mapping="url" location="location"></mvc:resources>`

```xml
<mvc:resources mapping="/js/**" location="/js/"></mvc:resources>
<mvc:resources mapping="/img/**" location="/img/"></mvc:resources>
<mvc:resources mapping="/css/**" location="/css/"></mvc:resources>
```



