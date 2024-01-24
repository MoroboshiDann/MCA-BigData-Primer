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



