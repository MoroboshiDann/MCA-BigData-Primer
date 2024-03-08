# 一、SpringMVC-概述

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



# 二、SpringMVC-项目搭建

# 三、SpringMVC-执行流程

## 工作流程

- tomcat将项目打包为war，并启动项目
- 根据`web.xml`中的配置，指定将请求映射到对应`controller`的前端控制器`DispathcerServlet`。并指定spring的配置文件路径`classpath:springmvc.xml`
  - 如果不使用`<init-param>`来指定springMVC配置文件的路径，那么DispatcherServlet会自动到WEB-INF目录下找指定名字的配置文件`<servletname>-servlet.xml`。
- `springmvc.xml`中指定了spring的扫描路径，会将路径下带有`@Component`注解或其变形的类加载为Bean
- 当有请求发起时，`DishpatcherServlet`会根据请求路径，将请求交给对应的`controller`来处理。
- `controller`内的请求处理方法，需要通过`@RequestMapping`来指定该方法对应的请求路径。



## 配置文件的注意事项：

- `@RequestMapping`注解既可以放在方法上，可以放在类上。如果两者被该注解修饰，则访问时需要将两个路径拼接起来才能正常访问。并且返回的jsp文件需要放在类上注解的路径内才能正常返回
- 如果jsp文件没有放在`WEB-INF`文件下，而是放在了内部的一个二级目录下。controller方法的返回值就需要写出全路径名才能正常访问。
  - 如果想简化路径，就需要在`springmvc.xml`文件中配置视图解析器。



## 执行流程

![](..\img\springMvcProcess.png)

![](..\img\springMvcProcess2.png)

- DispatcherServlet：前端控制器。用户请求到达前端控制器，它就相当于MVC模式中的C，DispatcherServlet就是整个流程控制的中心，由它来调用其他组件处理用户的请求。DispathcerServlet降低了组件之间的耦合程度。
- HandlerMapping：处理器映射器。它负责根据用户请求找到Handler，SpringMVC提供了不同的映射方式，如：配置文件方式、实现接口方式、注解方式等。
- Handler：处理器，它就是我们开发中需要编写的具体业务控制器(Controller)。由DispatcherServlet将用户请求转发至Handler。由Handler对具体的请求进行处理。
- HandlerAdapter：处理器适配器。通过HandlerAdapter对处理器进行执行，是适配器模式的应用，通过扩展适配器，可以对更多类型的处理器进行执行。
- ViewResolver：视图解析器。负责将处理结果生成View视图。首先根据逻辑视图名解析成物理视图名，再生成View视图对象，最会对View进行渲染碱处理结果通过页面展示给用户。
- View：视图。SpringMVC框架提供了很多类型视图的支持，最常用的视图就是jsp。一般情况下需要通过页面标签或者页面模板技术将模型数据通过页面展示给用户，需要程序员根据业务需求开发具体的页面。



## SpringMVC三大核心组件：

- HandlerMapping，处理器映射器
  - 实现类RequestMappingHandlerMapping，会处理@RequestMapping注解，将其映射到请求映射表中。
- HandlerAdapter，处理器适配器：即在controller中选择方法来处理。
  - 实现类RequestMappingHandlerAdapter，是处理请求的适配器，确定调用哪个类的哪个方法，并且构造方法参数，返回值。
- ViewResolver，试图解析器

> 当在springmvc.xml配置文件中使用了`<mvc:annotation-driven/>`，会启用注解驱动，然后Spring会通过`<context:component-scan/>`标签的配置，会自动将扫描到的@Component, @Controller, @Service, @Repository等注解标记的组件注册到工厂中



## 静态资源放行

如果请求的返回值为一个jsp文件，前端为了渲染这个页面，还需要再发三个请求，分别请求aaa.css, bbb.js, logo.png

而前端的请求都会经过前端控制器DispatcherServlet，而这些请求都没有请求路径，因此解析过以后找不到对应的Handler，因此如果不对静态资源放行，就会报404错误。

静态资源放行就是对于这些请求直接放行，让前端直接去资源文件夹下找即可

`<mvc:resources mapping="url" location="location"></mvc:resources>`

```xml
<mvc:resources mapping="/js/**" location="/js/"></mvc:resources>
<mvc:resources mapping="/img/**" location="/img/"></mvc:resources>
<mvc:resources mapping="/css/**" location="/css/"></mvc:resources>
```

# 四、SpringMVC-@RequestMapping注解

## 1. @RequestMapping控制请求方式

`method`属性可以控制请求的方式，值为`RequestMethod`枚举值

```java
@RequestMapping(value = "/***", method = {RequestMethod.GET, RequestMethod.POST})
```

## 2. @RequestMapping控制请求参数`params`和请求头`headers`

- `param`：表示请求中*必须包含*名为`param`的参数
- `!param`：表示请求中不能包含名为`param`的参数
- `param = value`：表示请求中必须包含名为`param`的参数，其值必须为`value`
- `param != value`：表示请求中必须包含名为`param`的参数，其值不能为`value`

```java
@RequestMapping(value = "/***", params = {"username != root", "password"})
@RequestMapping(value = "/***", headers = {"Accept-Encoding=gzip, deflate"})
```

## 3. @PathVariable注解和REST风格支持

REST(Representational State Transfer)，表征性状态转移。本身没有创造新的技术、组件或服务，其理念为使用Web现有的表征和能力，更好地使用现有Web标准中的一些约束和准则。目前HTTP是REST唯一的实例。

- Resources，资源：网络上的一个文件或信息，就是URI
- Representatin，表现层：把资源呈现出来的具体形式，如txt, mp3, json
- State Transfer，状态转移：

如果请求路径本身就包含了参数，如将`id, username`等放在请求路径中，且是个变量，就可以通过如下方式获取

如果想在方法中使用解析出来的变量，就需要用到`@Pathvariable`注解

```java
@RequestMapping("/test/{id}/{username}")
public void test(@PathVariable(value = "id")String id,@PathVariable(value = "username")String username) {
    sout(id + " " + username);
    return "success";
}
```



在访问同一个URL时，通过请求方式的不同，对应到不同的controller方法。通过`method`属性来控制

```java
@RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
public void test1(@PathVariable(value = "id")String id) {sout(id);}
@RequestMapping(value = "/test/{id}", method = RequestMethod.POST)
public void test2(@PathVariable(value = "id")String id) {sout(id + "POST");}
```

但是在前端中，form是不能直接发送`PUT`和`DELETE`请求的，直接在form中指定请求方式为这两种，后端会映射到`POST`上。

需要用到方法过滤器`hiddenMethodFilter`



# 五、SpringMVC-获取请求参数

## 紧耦合方式注入(了解)

紧耦合方式注入：使用HttpServletRequest对象获取参数

```java
@RequestMapping("/getParamByRequest")
public String getParamByRequest(HttpServletRequest req, HttpServletResponse resp) {
    String name = req.getParameter("username");
    String password = req.getParameter("password");
    sout(name + password);
    return "success";
}
```

参数较少时，可以采用这种方式。如果参数较多需要手动一一获取，比较繁琐，而且耦合程度太高。

## 解耦合方式注入(熟练)

解耦合方式注入：使用SpringMVC提供的功能，自动转换参数

```java
@RequestMapping("/getParam")
public String getParam(String username, String password) {
    sout(name + password);
    return "success";
}
```

直接将参数作为方法的形参，即可自动转换参数并注入方法。

参数的类型也可以自动转换为需要的类型，如果类型无法正确转化(String -> Integer)就会报错。

注意：处理单元(Handler，也就是对应的响应方法)参数列表中的参数名，必须与请求中的参数名一致

### 1. POJO类型

当前后端传输的参数较多时，可以将传输的参数列表封装为一个POJO对象。

在controller方法的形参中，只需要接收一个POJO对象即可自动将前端的参数封装为对象。

具体做法如下：

- 创建POJO类，实现`Serializable`接口

> 在以下几种情况下需要实现`Serializable`接口：
>
> - 需要将对象写入硬盘
> - 需要将对象通过网络传输
> - 需要通过RMI调用对象(远程调用，在另一个JVM中调用)

- 在POJO类中将传输的参数列表作为成员属性
- 在controller方法的形参处传入POJO对象

需要注意：提交的参数名需要和POJO的成员属性名一致

> SpringMVC底层是通过*反射*给属性进行赋值的，是通过setter方法来实现的。
>
> 因此，如果属性名不一致或者没有setter，就无法正确接收

### 2. 日期类型转换

如果在前端页面传入的时间类型为`String`，而在后端接收时采用`Date`类型，就会出现类型转换错误。

为了能够正确转换时间类型，有如下方法

#### 注解方式(推荐使用)

`@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")`注解，可以添加在方法的形参前或者对象的成员属性上

#### 自定义类型转换器(不推荐)

定义一个`StringToDateConverter`类，实现`Converter<String, Date>`接口。重写`convert()`方法。

该方法形参为转换前的类型，返回值为转换后的类型

```java
public class StringToDateConverter implements Converter<String, Date> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Date convert(String source) {
        Date date = null;
        try {
            date = dateFormat.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date;
    }
}
```

并在springmvc.xml中配置转换工厂

```xml
<!--    配置转换工厂-->
<bean class="org.springframework.context.support.ConversionServiceFactoryBean">
<!--        配置转换器-->
    <property name="converters">
        <array>
            <bean class="org.moroboshidan.util.StringToDateConverter"></bean>
        </array>
    </property>
</bean>
<!-- 开启mvc注册驱动，自动配置处理器和转换器-->
<mvc:annotation-driven conversion-service="conversionService"/>
```

配置繁琐，且类型写死

### 3. List集合参数接收

在前端页面接收用户输入的数据，如果想以集合类型传递给后端，需要对<input>标签进行修改

对宠物进行定义：

```java
public class Pet implements Serializable {
    private String petName;
    private String petType;
}
```

```jsp
宠物List：
<p>
   宠物1<input type="text" name="pets[0].petName">类型<input type="text" name="pets[0].petType">
</p>
<p>
   宠物2<input type="text" name="pets[1].petName">类型<input type="text" name="pets[1].petType">
</p>
```

在后端直接使用List集合即可接收。

如果接收的集合为List<>多态类型，那么这个集合要么是一个成员属性，要么需要在前端使用Ajax。

### 4. Map集合参数接收

同上，也需要对<input>标签进行修改，由于Map集合没有索引，因此需要使用key来定位数据。

```jsp
宠物List：
<p>
   宠物1<input type="text" name="pets['a'].petName">类型<input type="text" name="pets['a'].petType">
</p>
<p>
   宠物2<input type="text" name="pets['b'].petName">类型<input type="text" name="pets['b'].petType">
</p>
```

### 5. 编码问题

#### GET乱码问题

直接在页面中指定使用UTF-8编码即可解决

#### POST乱码问题

在JavaEE中，可以使用过滤器来解决乱码问题，SpringMVC已经提供了过滤器。

只需要在web.xml中配置编码过滤器即可。

```xml
<filter>
	<filter-name>encFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
    	<param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
</filter>
<filter-mapping>
	<filter-name>encFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```



# 六、SpringMVC-常见注解

## 1. @RequestMapping

作用：建立请求URL和请求处理方法之间的对应关系。

出现位置：

- 类上：请求URL的第一级访问目录。此处不写的话，相当于对应根目录。
- 方法上：请求URL的第二级目录。

属性：

- value：指定请求的URL，和path属性是一致的。
- method：用于指定请求的方式

## 2. @RequestParam

作用：把请求中的指定名称的参数给控制器中的形参赋值。

位置：控制器形参前，每个形参一个。

属性：

- value：请求参数中的名称。
- required：请求中是否必须提供此参数，默认为true，如果不提供会报错。



# 七、SpringMVC-响应处理

在SpringMVC中，如果当前控制单元没有返回值，SpringMVC就会找到和当前控制单元名称一致的页面进行展示。如果找不到页面就会报404错误，此时并不是控制单元报错。

## 1. 转发和重定向 ServletAPI实现 

```java
@RequestMapping("/servlet")
public void testServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 请求转发
	// request.getRequestDispatcher("/WEB-INF/view/servletPage.jsp").forward(request,response);
    // 响应重定向
    response.sendRedirect(request.getContextPath() + "/WEB-INF/view/servletPage.jsp");
}
```

控制单元返回值为void，因为使用response对象在方法中对此次请求进行了响应，不在通过DispatcherServlet了，既然已经响应，就不需要给DispatcherServlet返回值了。

耦合度较高，不推荐使用。

## 2. forward实现

通过控制单元方法返回值的字符串，告诉DispatcherServlet跳转的路径。

在路径前需要放上`forward:`关键字，表示请求转发，该关键字可以省略不写

```java
@RequestMapping("/forward")
public String testForward() {
    return "/forwardPage";
}
```

## 3. redirect关键字完成响应

通过控制单元方法的返回值告诉DispatcherServlet重定向指定的资源，该关键字不可省略

```java
@RequestMapping("/redirect")
public String testRedirect() {
    return "redirect:/redirectPage.jsp";
}
```

## 4. view视图转发和重定向

```java
public View testView(HttpServletRequest request) {
    // 转发
//        View view = new InternalResourceView("/viewPage.jsp");
    // 重定向
    View view = new RedirectView(request.getContextPath() + "/viewPage.jsp");
    return view;
}
```

RedirectView所做的操作，最终实现实在renderMergedOutputModel中完成的，简单来说RedirectView实现了链接的重定向，并将数据保存在FlashMap中，这样在跳转后的链接中可以获取一些数据。

## 5. ModelAndView实现



## 6. 响应JSON格式数据

当浏览器发起一个Ajax请求，服务器调用对应的单元方法来处理，而Ajax请求被处理完后需要直接响应。而单元方法响应Ajax请求使用的是response对象，需要我们自己完成响应数据的转换，转换为JSON字符串。操作繁琐，我们希望无论是否请求为Ajax，都使用return关键字来完成资源的响应。

目前DispatherServlet底层会将单元方法的返回值按照请求转发或者重定向来处理，因此，我们需要告诉DispatcherServlet，单元方法的返回值不需要转发或重定向，而是直接按照直接响应处理，将单元方法的返回值交给浏览器。

具体操作如下

- 第一步：导入jackson的jar包
- 第二步：声明单元方法是处理Ajax请求的，在该方法上添加`@ResponseBody`注解
  - 该注解表明，方法的返回值不再作为页面跳转依据，而是直接作为返回的数据。
  - 并且自动使用ObjectMapper将方法返回值转换为JSON。
- 第三步：在页面的Ajax回调函数中，无需再次使用eval函数将响应数据转换为JSON，而是直接使用。



> @RestController = @ResponseBody + @Controller
>
> 被该注解修饰的控制器，其所有方法返回值默认直接响应，且自动转换为JSON格式。



# 八、SpringMVC-SSM整合

登录案例开发

## 1. 准备数据库

创建数据库，创建表

## 2. 创建Maven项目，并准备好MVC模式下的主要目录

- main
  - java
  -  resources
  - webapp
- test

## 3. 配置web.xml并准备好包结构

controller, service, mapper, pojo

## 4. 导入依赖并准备配置文件

通过pom.xml文件导入依赖

配置文件放在`resources`包中，配置文件包括：

- 域名反写mapper包下的`UserMapper.xml`
- resources包中的：
  - applicationContext.xml：配置SpringBean
  - jdbc.properties：配置Java数据库链接
  - log4j2.xml：配置日志文件
  - springmvc.xml：配置Spring

> 配置文件中，在springmvc.xml文件中扫描controller包，将其下被@Component注解标注的类注册为SpringBean。
>
> 而mapper包下只存在对应接口，而没有实现类。接口的实现类是Mbatis通过`UserMapper userMapper = SQLSession.getMapper(UserMapper.class);`方法生成的，而不是Spring实现的，因此无需在配置文件中扫描mapper。
>
> Spring整合Mybatis的思路就是，可以在Service层中注入Mapper对象。Mapper对象是Mybatis实现的。
>
> Mybatis将SQLSessionFactory、SQLSession，以及Mapper接口全部交给Spring去创建，然后存储在Spring容器中。

# 九、SpringMVC- 作用域传参

### 传统数据传输

对象类型

- PageContext对象：作用域范围为当前jsp页面内有效。
- request对象：一次请求内有效，解决了一次请求内资源的数据共享问题。
- session对象：一次会话内有效，浏览器不关闭，且后台的session不失效，在任意请求中都可以获取到一个session对象，结局了同一个用户不同请求间的数据共享问题。
- application(ServletContext)对象：整个项目内有效，一个项目只有一个，在服务器启动时完成初始化创建，解决了不同用户的数据共享问题。

### Model传输

处理器适配器adapter负责管理model对象，将model对象作为参数传入controller方法

是对request(请求域)传输的封装，降低servlet和controller之间的耦合度



# 十、SpringMVC- 上传



文件上传中的问题：

## 1. 中文文件名编码问题：通过过滤器解决

## 2. 文件存储位置问题：可以放在当前项目的目录下，作为静态资源，可以通过url访问

- 传入HttpServletRequest对象，用于获取当前项目的实际路径，并指定存储的文件夹名称
- `realPath = request.getServletContext().getRealPath("upload");`
- 创建目录对象，`File dir = new File(realPath);`

## 3. 文件名冲突问题：使用UUID对文件进行重命名

- 通过UUID类获取一个随机的uuid
- 获取上传的文件的后缀`String extendName = photo.substring(photo.lastIndexOf("."));`
- 然后拼接得到以uuid命名的文件名

## 4. 控制文件类型问题

- 通过检查后缀来控制文件类型

## 5. 文件大小控制问题

```JAVA
long size = photo.getSize();
if(10*1024*1024<size){map.put("error","oversize");return map;}
```

也可以通过文件上传解析组件控制

但是会出现异常，后期可以配置一个异常解析器解决

```xml
<bean class="org.springframework.web.multipart.commons.CommonsMultipartResolver" id="multipartResolver">
    <property name="maxUploadSize"  value="5242880"></property>
</bean>
```

## 6. 图片回显和进图条问题

ajax设置回显，从后端返回的结果中读取文件名称，然后加载到img标签中

## 7. 进度条问题

## 8. 单独准备文件存储服务器

分服务器上传作用

- 数据库服务器：运行数据库
- 缓存和消息数据库：负责处理大并发访问的缓存和消息
- 文件服务器：负责存储用户上传的文件
- 应用服务器：负责部署应用

分服务器处理的目的是让服务器各司其职，从而提高项目效率。



过滤器对比拦截器

| 过滤器                                                       | 拦截器                            |
| ------------------------------------------------------------ | --------------------------------- |
| 过滤器在请求到到项目组件之前工作(请求到达前端控制器之前就被过滤器过滤) | 拦截器在前端控制器之后工作        |
| 过滤器依赖servlet容器                                        | 拦截器依赖spring容器              |
| 可以对所有请求起作用                                         | 只能对action请求起作用            |
| 过滤器不能放为action上下文、值栈里的对象                     | 拦截器可以访问                    |
| 在action的生命周期中，过滤器只能在容器初始化时被调用一次     | 拦截器可以被调用多次              |
| 过滤器不太方便获取                                           | 拦截器可以获取IOC容器中的各个bean |

拦截器可以分为：

- preHandler
  - 在请求到达handler之前拦截，进行工作
- postHandler
  - 在handler处理之后，返回ModelAndView之前拦截

作用为：权限验证、记录请求信息的日志、判断用户是否登录等

要使用SpringMVC中的拦截器，就需要对拦截器类进行定义和配置。通常拦截器类可以通过两种方式来定义：

- 1. 通过实现`HandlerInterceptor`接口，或继承`HandlerInterceptor`接口的实现类来定义
- 2. 通过实现`WebRequestInterceptor`接口或继承其实现类来定义

