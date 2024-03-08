# Spring Framework介绍

## 官方文档

https://www.spring.io

## Spring的发展历史

![spring history](..\img\SpringHistory.png)

## Spring概述

​        一个Java应用层程序，是由许多个类组成的，这些类之间必然存在依赖关系，当项目越来越大，依赖关系越来越复杂，需要一个专业的框架来处理类之间的依赖关系，为了解决这个问题，SUN公司推出了EJB（重量级）专门用来解决类的依赖问题。

&emsp;&emsp;Spring（Spring Framework） 是一个开源框架，最早由Rod Johnson创建，并在《Expert One-on-One：J2EE Design and Development》这本著作中进行了介绍。Spring是为了解决企业级应用开发的复杂性而创建的，使用Spring可以让简单的JavaBean实现之前只有EJB才能完成的事情。但Spring不仅仅局限于服务器端开发，任何Java应用都能在简单性、可测试性和松耦合等方面从Spring中获益。

&emsp;&emsp;bean的各种名称……虽然Spring用bean或者JavaBean来表示应用组件，但并不意味着Spring组 件必须要遵循JavaBean规范。一个Spring组件可以是任何形式的POJO（POJO（Plain Ordinary Java Object）简单的Java对象，实际就是普通JavaBeans，是为了避免和EJB混淆所创造的简称）。

&emsp;&emsp;Spring 可以做非常多的事情。但归根结底，支撑Spring的仅仅是少许的基本理念，所有的理念都可以追溯到Spring最根本的使命上：简化Java开发。这是一个郑重的承诺。许多框架都声称在某些方面做了简化，但Spring的目标是致力于全方位的简化Java开发。这势必引出更多的解释，Spring是如何简化Java开发的？

为了降低Java开发的复杂性，Spring采取了以下4种关键策略：

* 基于POJO的轻量级和最小侵入式编程；
* 通过控制反转和依赖注入以及面向接口实现松耦合；
* 基于切面和惯例进行声明式编程；
* 通过切面和模板减少样板式代码。

几乎Spring所做的任何事情都可以追溯到上述的一条或多条策略。

* Spring的各种注入方式
* IOC/DI
* AOP（事务）
* JdbcTemplate
* 事务

## 版本号说明

## Spring结构

![](..\img\SpringStructure.png)



# Spring入门案例

## 环境要求

## 项目创建

### 构建项目

创建一个maven项目

### Spring引入

在`pom.xml`文件中引入Spring Context的依赖

### 案例编写

- 添加相关的Spring依赖。在pom.xml文件中直接导入依赖即可。
- 创建自定义的Java类。
- 创建对应的配置文件。在resources目录下创建ApplicationContext.xml文件。
- 在配置文件中注册相关的类。使用<bean id="helloWorld" class="org.moro.spring.HelloWorld">标签来绑定类和id。
- 加载容器测试。

## 日志框架

为了便于分析程序的执行。日志框架在项目开发中还是非常重要的。因此引入Log4j2来记录日志。它是Apache的开源日志记录组件，使用非常广泛。

Log4j2主要有几个重要的组件构成：

(1) 日志信息的优先级，日志信息的优先级从低到高有TRACE < DEBUG < INFO < WARN < ERROR < FATAL

这些级别分别用来指定本条日志信息的重要程度；级别高的会自动屏蔽级别低的日志，例如设置了WARN的日志，则INFO和DEBUG级别的日志不会显示。

(2) 日志信息的输出目的地，日志信息的输出目的地指定了日志将打印到控制台还是文件中

(3) 日志信息的输出格式，输出格式控制了日志信息的显示内容

### 日志的使用

- 在`pom.xml`文件中添加Log4j2的依赖
- 在`resources`目录下创建一个Log4j2.xml的配置文件



# Spring核心之IOC

## 一、IOC概念介绍

### 1. IOC介绍

IOC(Inversion of Control)，控制反转，是一种设计思想，是一个重要的面向对象编程法则，能够指导我们如何设计出松耦合，更优良的程序。

Spring通过IOC容器来管理所有Java对象的实例化和初始化，控制对象与对象之间的依赖关系。我们将由IOC容器管理的Java对象称为*Spring Bean，它与使用关键词`new`创建的Java*对象没有区别。

IoC容器时Spring框架中最重要的核心组件之一，它贯穿了Spring从诞生到成长的整个过程。

控制反转，反转的是什么

- 创建对象的权利，交给第三方
- 对象之间的关系，交给第三方

控制反转常见的实现为：DI，依赖注入

### 2. DI介绍

DI(Dependency Injection)，依赖注入，IoC的具体实现。是指Spring创建对象的过程中，将依赖属性通过配置进行注入。

依赖注入的常见实现方式为：

- set注入
- 构造器注入

### 3. Spring中的IOC实现

![](..\img\SpringImpl.png)

Spring 的 IoC 容器就是 IoC思想的一个落地的产品实现。IoC容器中管理的组件也叫做 bean。在创建 bean 之前，首先需要创建IoC 容器。Spring 提供了IoC 容器的两种实现方式：

#### **BeanFactory**

这是 IoC 容器的基本实现，是 Spring 内部使用的接口。面向 Spring 本身，不提供给开发人员使用。

#### **ApplicationContext**

BeanFactory 的子接口，提供了更多高级特性。面向 Spring 的使用者，几乎所有场合都使用 ApplicationContext 而不是底层的 BeanFactory。

ApplicationContext的主要实现类:

| 类型名                          | 简介                                                         |
| ------------------------------- | ------------------------------------------------------------ |
| ClassPathXmlApplicationContext  | 通过读取类路径下的 XML 格式的配置文件创建 IOC 容器对象       |
| FileSystemXmlApplicationContext | 通过文件系统路径读取 XML 格式的配置文件创建 IOC 容器对象     |
| ConfigurableApplicationContext  | ApplicationContext 的子接口，包含一些扩展方法 refresh() 和 close() ，让 ApplicationContext 具有启动、关闭和刷新上下文的能力。 |
| WebApplicationContext           | 专门为 Web 应用准备，基于 Web 环境创建 IOC 容器对象，并将对象引入存入 ServletContext 域中。 |

## 二、基于XML的方式

### 1. 搭建项目

同之前的入门案例一致，先创建项目导入依赖，然后创建自定义类，接着在resources目录下创建`ApplicationContext.xml`配置文件。

### 2. 获取Bean的方式

#### 2.1 根据ID获取

可以在`ApplicationContext.xml`文件中，通过<bean>标签中定义的`id`属性来获取IoC容器中的对象。id属性具有唯一性，可以通过它精确地找到唯一的对象。

```java
<bean id="helloWorld" class="org.moroboshidan.spring.HelloWorld"/>
```

具体的测试代码如下：

```java
@Test
public void testID() {
    // 1. 获取Spring的IoC容器
    ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    // 2. 根据定义的id来获取容器中的Bean对象
    HelloWorld hello = (HelloWorld) ac.getBean("helloWorld");
    hello.sayHello();
    logger.info("通过ID获取Bean对象")；
}
```

#### 2.2 根据类型获取

根据id获取的是一个Object类型的对象，还需要强制类型转换为需要的类型。

因此，可以通过类型，即Class对象来获取IoC容器中的对象。

```java
@Test
public void testClass() {
    // 1. 获取Spring的IoC容器
    ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    // 2. 根据类型来获取容器中的Bean对象
    HelloWorld hello = ac.getBean(HelloWorld.class);
}
```

根据类型获取容器中的对象，存在一个比较大的问题，如果IoC容器中存在多个类型相同的对象，直接通过类型来获取对象就会存在问题。

```xml
<bean id="helloWorld" name="helloWorldName" class="org.moroboshidan.spring.HelloWorld"></bean>
<bean id="helloWorldDuplicate" class="org.moroboshidan.spring.HelloWorld"></bean>
<!-- 容器中注册了两个相同类型的Bean -->
```

> 这时再去通过类型获取Bean对象就会报错
>
> `expected single matching but found 2`

#### 2.3 根据id和类型获取

为了解决以上问题，通过组合的方式来获取Bean对象。

```java
@Test
public void testIdAndClass() {
    // 1. 获取Spring的IoC容器
    ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    // 2. 通过ID来获取容器中的Bean对象
    HelloWorld helloWorld = ac.getBean("helloWorld", HelloWorld.class);
    helloWorld.sayHello();
    logger.info("通过id和类型获取IoC容器中的Bean对象");
}
```

### 3. 依赖注入之Setter

我们前面的案例都只是直接创建了一个对象。并没有对相关的属性做对应的操作。我们可以通过依赖注入来完成相关的属性的初始化。我们可以创建一个简单的Bean。

```java
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
}
```

然后我们的配置文件`ApplicationContext.xml`中通过 `property`标签来完成setter注入：

```xml
<!-- 我们可以通过setter来完成属性的赋值操作 -->
<bean id="student1" class="com.boge.spring.bean.Student">
    <!--
        property标签：通过Bean中定义的setter方法来给组件做赋值
        name属性：指定的属性名称。setXxx() 方法来完成赋值
        value属性：setXxx(value) 属性值
     -->
    <property name="id" value="1"></property>
    <property name="name" value="波哥"></property>
    <property name="age" value="18"></property>
    <property name="gender" value="男" ></property>
</bean>
```

> <property>标签中的`name`的取值为Bean对象的成员属性名，且对应属性必须要有Setter方法，否则无法完成注入



### 4. 依赖注入之构造注入

针对上面的设置注入中的必要条件是对应的属性必须添加相关的setter方法。我们可以通过构造注入的方式来解决。

```java
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private String gender;

    public User(Integer id, String name, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public User() {
    }

}
```

在Bean对象中定义带参构造方法，然后在配置文件中通过<constructor-arg>标签来配置属性取值

```xml
<bean class="com.boge.spring.bean.User">
        <!--
            构造注入的实现
            constructor-arg标签：表示了对应Bean中的构造选项
        -->
        <!--<constructor-arg value="10086"></constructor-arg>
        <constructor-arg value="boge"></constructor-arg>
        <constructor-arg value="20"></constructor-arg>
        <constructor-arg value="女"></constructor-arg>-->
        <!-- name属性:指定的就是构造方法中的属性名称 -->
        <!--<constructor-arg name="id" value="10086"></constructor-arg>
        <constructor-arg name="name" value="boge"></constructor-arg>
        <constructor-arg name="age" value="20"></constructor-arg>
        <constructor-arg name="gender" value="女"></constructor-arg>-->
        <!-- index：表示该属性在构造方法中的位置。从0开始 -->
        <constructor-arg index="0" value="10086"></constructor-arg>
        <constructor-arg index="1" value="boge"></constructor-arg>
        <constructor-arg index="2" value="20"></constructor-arg>
        <constructor-arg index="3" value="女"></constructor-arg>

    </bean>
```

如果没有<name>和<index>的约束，标签的顺序就是形参传入顺序



### 5. 特殊值处理

#### 5.1 null值

针对属性赋值中的null的处理。我们不能直接在value中赋值。需要通过 <null> 标签来处理

```xml
<bean id="student1" class="com.boge.spring.bean.Student">
    <property name="name"> <null></null></property>
</bean>
```

#### 5.2 xml实体

针对我们赋值中有的特殊符号。比如 `< > ` 等。xml文件解析的时候会作为xml中的组成部分来解析。这时我们可以通过 xml实体或者CDATA来解决

![](..\img\xmlInstance.png)



### 6. 对象类型赋值

#### 6.1 引用外部Bean

在<property>标签中使用`ref`属性来引入在*配置文件中*定义的外部Bean对象

```xml
<bean class="org.moroboshidan.spring.Clazz" id="clazz">
    <property name="classId" value="1001"></property>
    <property name="className" value="软件1班"></property>
</bean>
<bean class="org.moroboshidan.spring.Student" id="student">
    <property name="id" value="18"></property>
    <property name="name" value="moro"></property>
    <property name="clazz" ref="clazz"></property>
</bean>
```

#### 6.2 定义内部类

如果需要赋值的Bean类仅仅只是在当前类中使用，可以直接在<property>标签中，通过内部<bean>标签的方式定义需要赋值的Bean。

即，赋值的Bean类，不会单独创建一个对象，仅仅只是会作为成员对象存在。

```xml
<bean class="org.moroboshidan.spring.Student" id="student2">
    <property name="id" value="18"></property>
    <property name="name" value="moroboshidan"></property>
    <property name="clazz" >
        <!-- 在一个bean的内部我们再声明一个内部bean -->
        <bean class="org.moroboshidan.spring.Clazz">
            <property name="classId" value="1002"></property>
            <property name="className" value="class two"></property>
        </bean>
    </property>
</bean>
```

#### 6.3 级联赋值

对于需要赋值的成员对象，可以在其Bean的声明中不进行赋值，然后在本类的赋值中采用级联赋值的方式进行赋值。

或者直接将其声明放在当前Bean的内部，然后级联赋值。

```xml
<bean class="org.morosboshidan.Clazz" id="clazz"></bean>
<bean class="com.boge.spring.Student" id="student3">
    <property name="id" value="18"></property>
    <property name="name" value="波哥"></property>
    <property name="clazz" ref="clazz"></property>
    <!-- 级联属性赋值 -->
    <property name="clazz.classId" value="1003"></property>
    <property name="clazz.className" value="软件3班" ></property>
</bean>

<bean class="com.boge.spring.Student" id="student4">
    <property name="id" value="18"></property>
    <property name="name" value="波哥"></property>
    <property name="clazz" >
        <!-- 在一个bean的内部我们再声明一个内部bean -->
        <bean class="com.boge.spring.Clazz"></bean>
    </property>
    <property name="clazz.classId" value="1004"></property>
    <property name="clazz.className" value="软件5班" ></property>
</bean>
```

### 7. 数组类型赋值

注入到容器中的Bean对象的属性可能是数组类型，这时可以通过<array>标签来完成赋值。

```xml
<bean id="student" class="org.moroboshidan.spring.Student">
    <property name="id" value="1"></property>
    <property name="name" value="moroboshidan"></property>
    <property name="hobbies">
        <array>
            <value>basketball</value>
            <value>football</value>
            <value>badminton</value>
        </array>
    </property>
    <property name="hobbiesDup">
        <list>
            <value>basketball</value>
            <value>football</value>
            <value>badminton</value>
        </list>
    </property>
</bean>
```

### 8. 集合类型赋值

注入到容器中的Bean对象的属性可能是数组类型，这时可以通过<list>标签。

具体代码见7。其中实例List内容为String类型，List的类型也可以是自定义类型，处理方式一致。

```xml
<bean id="student" class="org.moroboshidan.spring.Student">
    <property name="id" value="1"></property>
    <property name="name" value="moroboshidan"></property>
    <property name="clazzList">
        <list>
            <ref bean="clazz"></ref>
            <bean class="org.moroboshidan.spring.Clazz"></bean>
        </list>
    </property>
</bean>
```

还有一种情况是Map集合，则每个键值对需要使用一个<entry>标签来封装

```xml
<bean id="student" class="org.moroboshidan.spring.Student">
    <property name="id" value="1"></property>
    <property name="name" value="moroboshidan"></property>
    <property name="map">
        <map>
            <entry>
                <key>
                    <value>alpha</value>
                </key>
                <value>18</value>
            </entry>
            <entry>
                <key>
                    <value>beta</value>
                </key>
                <value>19</value>
            </entry>
        </map>
    </property>
</bean>
```

我们可以通过util标签来定义外部的集合数据。然后通过ref来引用就可以了。但是我们需要先声明util的schema。

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="http://www.springframework.org/schema/util
       http://www.springframework.org/schema/util/spring-util.xsd
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
```

然后进行具体操作

```xml
<util:list id="hobbyList">
    <value>h1</value>
    <value>h2</value>
    <value>h3</value>
</util:list>

<bean id="student" class="org.moroboshidan.spring.Student">
    <property name="id" value="1"></property>
    <property name="name" value="moroboshidan"></property>
    <property name="hobbyList" ref="hobbyList"></property>
</bean>
```

### 9. p命名空间

用来简化属性的赋值操作
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:p="http://www.springframework.org/schema/p"
       xsi:schemaLocation="http://www.springframework.org/schema/util
       http://www.springframework.org/schema/util/spring-util.xsd
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 外部定义的集合数据 -->
    <util:list id="studentHobbies">
        <value >h1</value>
        <value >h2</value>
        <value >h3</value>
    </util:list>
   <!-- p 属性 简化属性的赋值操作 -->
   <bean class="org.moroboshidan.spring.Student" id="student"
         p:id="666" p:name="波哥" p:hobbies2-ref="studentHobbies"></bean>
</beans>
```

> 注意，如果是自定义类型的成员对象，需要在属性名后加上`-ref`，才能引用别处的定义

### 10. 外部属性文件

为了实现配置信息内容的共享。我们可以把一些共享的信息单独的配置在一个独立的properties文件中。然后通过context标签来引入。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:util="http://www.springframework.org/schema/util"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/util
       http://www.springframework.org/schema/util/spring-util.xsd
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 引入外部的属性文件 -->
    <context:property-placeholder location="classpath:myProperties.properties"></context:property-placeholder>

    <!-- 外部定义的集合数据 -->
    <util:list id="studentHobbies">
        <value >${user.hobbies.h1}</value>
        <value >${user.hobbies.h2}</value>
        <value >h3</value>
    </util:list>
   <!-- p 属性 简化属性的赋值操作 -->
   <bean class="com.boge.spring.bean4.Student" id="student1"
         p:id="666" p:name="波哥" p:hobbies2-ref="studentHobbies"></bean>

</beans>
```

在`myProperties.proterties`文件中，做如下定义：

```properties
user.hobbies.h1 = basketball
user.hobbies.h2 = football
```

本质上就是进行映射，使用一个变量名来代替具体的取值


具体的步骤：

1. 定义属性文件
2. 添加context标签的schema
3. 通过context中的 property-placeholder引入属性文件
4. 然后通过${}表达式来使用属性文件中什么的信息



#### 10. 练习案例

对于普通的Spring项目来说，一般分为三层，`Controller` `Service` 和 `Dao`，后两者均有接口和其实现类。其中Controller中需要用到Service的实现类对象，Service中需要用到Dao层的实现类对象。

根据IoC的思想，需要将创建对象的权利交给IoC容器，而不是在类中直接使用`new`关键字显示地创建需要使用的对象。

因此，需要给`Controller`和`ServiceImpl`中添加`private Service service`和`private Dao dao`，即接口的对象，但是不赋值。而是提供setter或者构造器。

然后，在`ApplicationContext.xml`中分别将`DaoImpl` `ServiceImpl`和`Controller`注册为Bean，并在后两者中通过setter或者构造器的方式注入成员值。

在测试类中先获取容器对象，然后通过容器创建Controller对象。

```java
public void test() {
    // 1. 获取IoC容器对象
    ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    // 2. 通过id+类型的方式获取容器中的对象
    UserController userController = ac.getBean("userController", UserController.class);
    userController.queryAllUser();
}
```




## 三、基于注解的方式

Spring 从 2.5 版本开始提供了对注解技术的全面支持，我们可以使用注解来实现自动装配，简化 Spring 的 XML 配置。

Spring 通过注解实现自动装配的步骤如下：

1. 引入依赖
2. 开启组件扫描
3. 使用注解定义 Bean
4. 依赖注入



### 1. 创建项目

同上

### 2. 开启扫描

开启扫描需要添加`context`的schema，然后通过<context:component-scan>标签来指定扫描的路径。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 1. 引入context 的 schema
         2. 开启扫描
         3. 通过相关的注解实现注入 -->
    <context:component-scan base-package="org.moroboshidan"></context:component-scan>
</beans>
```

上面的扫描指定的路径是 org.moroboshidan 那么项目启动的时候就会去这个包下面加载所有被@Component 注解修饰的Java类。

### 3. 注解标识

在需要被Spring加载的类上添加`@Component`注解

```java
@Component
public class User {
    private Integer id;
    private String name;
}
```

### 4. 依赖注入问题

在上面的案例中。我们的controller service dao我们都可以通过@Component注解来完成对象的注入。但是controller对service的依赖，service对Dao的依赖。也就是 设值注入和构造注入是不能使用的。这时候我们可以通过@Autowired注解来解决这个问题

在setter方法和构造器上添加这个注解，就可以实现和基于XML一样的效果

### 5. 接口注入

上面我们虽然通过@Autowried注解解决了属性的依赖注入问题。但是在我们的实体中还是需要添加对应的setter和构造方法。会显得整个的代码结构不太简洁，这时我们可以通过接口注入的方式来处理。

```java
public class UserController {
    @Autowired
    private UserService userService;
    
    public void queryAllUsers() {
		List<User> list = userService.queryUser();
    }
}
```



### 6. 注解的多样性

Spring 提供了以下多个注解，这些注解可以直接标注在 Java 类上，将它们定义成 Spring Bean。

| 注解        | 说明                                                         |
| ----------- | ------------------------------------------------------------ |
| @Component  | 该注解用于描述 Spring 中的 Bean，它是一个泛化的概念，仅仅表示容器中的一个组件（Bean），并且可以作用在应用的任何层次，例如 Service 层、Dao 层等。  使用时只需将该注解标注在相应类上即可。 |
| @Repository | 该注解用于将数据访问层（Dao 层）的类标识为 Spring 中的 Bean，其功能与 @Component 相同。 |
| @Service    | 该注解通常作用在业务层（Service 层），用于将业务层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。 |
| @Controller | 该注解通常作用在控制层（如SpringMVC 的 Controller），用于将控制层的类标识为 Spring 中的 Bean，其功能与 @Component 相同。 |

> 这些标注都是标注在实现类上的，不是在接口的定义上



### 7. Autowired注解

@Autowired注解作用是完成对应的Bean依赖注入

```java
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

	/**
	 * Declares whether the annotated dependency is required.
	 * <p>Defaults to {@code true}.
	 */
	boolean required() default true;

}
```

通过源码的查看我们可以发现@Autowired注解的作用位置

* 构造方法--构造注入
* 方法上--setter方法上完成设值注入
* 形参上--接口注入
* 属性上
* 注解上

还有就是在源码中有一个 required 抽象方法。表示注入的bean是否是必须的。默认为true，表示在注入的bean必须是存在，如果不存在就报错，如果required设值为false。如果不存在就不会报错。



同一个接口有多个实现类，且都被标注为`@Component`就无法正确自动注入。针对这种情况。@Qualifier 可以实现基于name的查找注入。

@Autowired注解可以和@Qualifier注解一块去使用。@Autowired注解默认是基于类型类完成Bean的依赖注入的。



### 8. @Resource

@Resource注解也可以完成属性注入。那它和@Autowired注解有什么区别？

* @Resource注解是JDK扩展包中的，也就是说属于JDK的一部分。所以该注解是标准注解，更加具有通用性。(JSR-250标准中制定的注解类型。JSR是Java规范提案。)
* @Autowired注解是Spring框架自己的。
* @Resource注解默认根据名称装配byName，未指定name时，使用属性名作为name。通过name找不到的话会自动启动通过类型byType装配。
* @Autowired注解默认根据类型装配byType，如果想根据名称装配，需要配合@Qualifier注解一起用。
* @Resource注解用在属性上、setter方法上。
* @Autowired注解用在属性上、setter方法上、构造方法上、构造方法参数上。

@Resource注解属于JDK扩展包，所以不在JDK当中，需要额外引入以下依赖：【****如果是JDK8的话不需要额外引入依赖。高于JDK11或低于JDK8需要引入以下依赖。】

```
<dependency>
    <groupId>jakarta.annotation</groupId>
    <artifactId>jakarta.annotation-api</artifactId>
    <version>2.1.1</version>
</dependency>
```

![image.png](..\img\resource.png)

### 9. 基于Java配置类的方式

上面的介绍中基于注解的使用我们还是需要添加对应的配置文件。不是分方便。那么从Spring3.0开始提供的@Configuration注解。到Spring3.1 推出的@ComponentScan注解。那么我们完全可以脱离xml配置文件的使用方式了。 

使用方法：

- 创建一个SpringConfiguration类
- 在类上添加`@Configuration`注解，添加之后，这个类就相当于ApplicationContext.xml文件，起到配置作用
- 可以在配置类上添加`@ComponentScan(basePackages = "org.moroboshidan")`来指定扫描的路径

然后我们也可以通过@Bean注解实现对象的注入操作

```java
/**
 * Spring的配置类
 * 作用是替换调配置文件
 */
@Configuration // 加了这个注解 我们的这个配置类就相对于 applicationContext.xml 配置文件
@ComponentScan(basePackages = "com.boge")
public class SpringConfiguration {


    /**
     * 我们在相关的方法的头部添加 @Bean注解 可以实现讲改方法的返回对象注入到容器中
     * @return
     */
    @Bean
    public UserEntity userEntity(){
        UserEntity bean = new UserEntity(1, "波哥");
        return bean;
    }
}
```

使用了@Configuration注解的配置类后，获取IoC容器的方式为：

```java
ApplicationContext ac = new AnnotationConfigurationApplicationContext(SpringConfiguration.class);
UserController userController = ac.getBean(UserController.class);
```



## 四、IoC底层原理

### 1. XML解析技术读取配置文件

```xml
<bean id="testService" class="org.moroboshidan.service.impl.TestServiceImpl"></bean>
```

将类通过<bean>标签配置在xml配置文件中后，通过如DOM4J等技术，将配置文件读取至项目程序中。

获取了对象的id和对象的类的全路径名。



### 2. 反射技术实例化对象，存储在容器中

```java
// 获得类的字节码对象
Class clazz = Class.forName("org.moroboshidan.service.impl.TestServiceImpl");
// 通过字节码实例化对象
Object obj = clazz.newInstance();
```

先通过全路径名获取类的字节码对象，然后通过字节码的`newInstance()`方法来实例化对象。

```java
// 将实例化后的对象存储在map集合中
map.put("testService", obj);
```

IoC容器使用的是map集合来存储实例化对象的。其结构为`<"类的id", 对象>`



### 3. 工厂模式返回bean对象

 IoC容器的根接口为`BeanFactory`，规定了IoC容器的基本功能，是Spring内部使用的接口，我们在业务中一般不直接使用该接口。

常用的接口为`ApplicationContext`接口，它是`BeanFactory`接口的子接口，提供了更多更完善的功能。

在获取到IoC容器对象，即`ApplicationContext`接口的实现类对象之后，通过`getBean()`方法来获取容器中的对象。

```java
public Object getBean(String name) {
    if (map.containsKey(name)) {
        return map.get(name);
    }
}
```

通过bean的name来从容器中获取对象。



## 五、bean

### 1. bean工厂

对于普通的bean，在spring.xml文件中通过`<bean>`标签注册后，在通过IoC容器获取bean对象时，会返回其注册时所填写的全路径名对应的类对象。

但是，如果该路径名对应的对象为一个实现了`FactoryBean`接口的工厂类，那么通过IoC容器获取的对象，实际上是该工厂生产的对应的bean对象，而不是工厂类本身的对象。

因为，在向容器获取bean对象时，实际上调用的是工厂内部的`getObject()`方法。此时，`getBean()`获取的是该方法的返回值，也就是工厂生产的对应的bean对象。



### 2. bean生命周期

bean从创建到销毁，经历的各个阶段和每个阶段调用的方法：

| 阶段                      | 方法                                          |
| ------------------------- | --------------------------------------------- |
| 1. 通过构造器创建bean实例 | 执行构造器                                    |
| 2. 为bean属性赋值         | 执行set方法(如果是构造器注入，此步骤不会执行) |
| 后置处理器的方法          |                                               |
| 3. 初始化bean             | 调用bean的初始化方法，需要配置指定调用的方法  |
| 后置处理器的方法          |                                               |
| 4. bean的获取             | 容器对象调用getBean()方法                     |
| 5. 容器关闭，销毁bean     | 调用销毁方法，需要配置指定调用的方法          |

- 第三步，初始化bean，可以在<bean>标签中使用init-method来指定初始化方法。
- 第五步，销毁bean，同样在该标签中使用destroy-method来指定销毁bean之后执行的方法。

#### 后置处理器

在bean对象初始化之前和之后，都可以通过后置处理器来增加额外处理。

需要创建后置处理器类，实现`BeanPostProcessor`接口，重写两个方法，分别在bean对象初始化之前和之后运行。

且后置处理器是对所有的bean都有效的，任何bean在初始化之前都会执行后置处理器的方法。

两个方法的返回值为传入的bean对象。不能返回null，会将bean对象置为null。

需要将后置处理器在spring.xml文件中注册为bean。



### 3. bean自动装配

通过<property>标签可以手动给指定属性进行注入

也可以通过自动装配来完成属性的自动注入。可以简化D的配置。

具体如下：

​	当一个类的成员属性为另一个类的对象，在两个类都被注册为bean时，可以在<bean>标签中使用autowire属性，来让Spring自动查找容器中对应的对象来完成注入。

​	autowire属性有两种值，byName通过id来查找，和byType通过类型来查找。

​	根据类型装配时，目标类只能有一个。



# Spring核心之AOP

## 一、前置基础-代理

设计模式之代理模式。代理的作用是增强目标对象的功能。

其抽象过程为：

- 在执行目标对象的某个方法前，执行代理方法中的某功能
- 执行目标对象对象方法
- 返回代理方法继续执行

通常需要为目标对象创建一个代理类

![img.png](..\img\proxy.png)

### 1. 静态代理

若代理类在程序运行前就已经存在，那么这种代理方式被成为 静态代理 ，这种情况下的代理类通常都是我们在Java代码中定义的。 通常情况下， 静态代理中的代理类和目标类会*实现同一接口或是派生自相同的父类*。

公共接口

```java
public interface SomeService {
    String doSomethin();
}
```

定义目标类

```java
public class SomeServiceImpl implements SomeService {
	@Override
    public String doSomething() {
        sout("target instance is executing ...");
        return "Hello";
    }
}
```

定义代理类

```java
public class SomeProxy implements SomeService {
	// 代理对象持有的目标对象
    private SomeService targe;
    
    public SomeProxy(SomeService someService) {
        this.target = someService;
    }
    
    // 代理对象需要增强的方法
    @OVerride
    public String doSomething() {
        sout("before target instance starts ...");
        String msg = target.doSomething();
        sout("after target instance ends ...");
        return msg.toUpperCase();
    }
}
```

进行测试

```java
public void test() {
    SomeService target = new SomeServiceImpl();
    SomeProxy proxy = new SomeProxy(target);
    sout(proxy.doSomething());
}
```



### 2. 动态代理

代理类在程序运行时创建的代理方式被称为*动态代理*。 也就是说，这种情况下，代理类并不是在Java代码中定义的，而是在运行时根据我们在Java代码中的“指示”动态生成的。

代理类型与使用场景:

- JDK动态代理:如果目标对象实现了接口，采用JDK的动态代理
- CGLIB动态代理:如果目标对象没有实现了接口，必须采用CGLIB动态代理

![img.png](..\img\proxy2.png)

>* JDK动态代理动态生成的代理类会在com.sun.proxy包下，类名为$proxy1，和*目标类实现相同的接口*
>* cglib动态代理动态生成的代理类会和目标在在相同的包下，*会继承目标类*
>* 动态代理（InvocationHandler）：JDK原生的实现方式，需要被代理的目标类必须实现接口。因为这个技术要求代理对象和目标对象实现同样的接口（兄弟两个拜把子模式）。
>* cglib：通过继承被代理的目标类（认干爹模式）实现代理，所以不需要目标类实现接口。



#### JDK动态代理

如果目标类实现了接口，那么我们就不需要显式地定义代理类

目标类：

```java
public class SomeServiceImpl extends SomeService {
    public String doSomething() {
        sout("this is target");
        return "Hello";
    }
}
```

测试方法

```java
public void test() {
    SomeService target = new SomeServiceImpl(); // 获取目标对象
    SomeService proxy = (SomeService) Proxy.newProxyInstance(
        Test.class.getClassLoader(), // 获取类加载器
        target.getClass().getInterfaces(), // 获取目标对象实现的所有接口
        new InvocationHandler() { // 匿名内部类，直接重写接口的方法，然后返回一个这个匿名类的对象
            @Override
            // 本方法是代理对象用来执行目标对象方法的一个回调方法
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                sout("----executing------");
                // 调用目标对象的方法
                // String msg = target.doSomething();
                String msg = (String) method.invoke(target, args);
                return msg.toUpperCase();
            }
        }
    );
    // 通过代理对象来执行目标对象的方法
    sout("proxy is executing" + proxy.doSomething());
}
```

> 在回调方法中，没有像之前一样直接硬编码写为`target.doSomething()`，而是采用了反向代理的方式，使用`method.invoke()`，这样更有普适性
> 当目标类有多个方法时，都可以被代理，代理对象直接可以调用目标对象中的所有方法。

#### CGLIB代理

如果目标类并没有实现任何接口，只能通过CGLIB的方式来动态代理了。我们需要单独添加CGLIB的依赖

```xml
<!-- https://mvnrepository.com/artifact/cglib/cglib-nodep -->
<dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib-nodep</artifactId>
    <version>3.3.0</version>
</dependency>
```

定义目标对象(不实现任何接口)

```java
public class SomeService {
    public String doSomething() {
        sout("this is target");
        return "Hello";
    }
}
```

定义CGLIB的代理对象

```java
public class CglibProxy implements MethodInterceptor {
    private SomeService target;
    public CglibProxy(SomeService target) {this.target = target;}
    // 对外提供代理类对象的方法
    public SomeService createProxy() {
        Enhancer enhancer = new Enhancer(); // 创建CGLIB的增强器
        enhancer.setSuperclass(SomeService.class); // 指定父类
        enhancer.setCallBack(this);
        return (SomeService) enhancer.create();
    }
    @Override
    // 增强方法
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        sout("----start----");
        String msg = (String) method.invoke(target, objects);
        sout("-----end-----");
        return msg.toUpperCase();
    }
}
```

测试

```java
public void test() {
    SomeService target = new SomeService(); // 创建目标对象
    SomeService proxy = new CglibProxy(target).createProxy(); // 创建代理对象
    sout(proxy.doSomething());
}
```

## 二、AOP-面向切面编程

### 1.  AOP概述与相关概念

#### 1.1 AOP概述

AOP(Aspect Oriented Programming)是一种设计思想，是软件设计领域中的面向切面编程，它是面向对象编程OOP的一种补充和完善，它以通过预编译方式和运行期动态代理方式实现，在不修改源代码的情况下，给程序动态统一添加额外功能的一种技术。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。 日志、事务、安全检查等。

#### 1.2 AOP术语

在学习AOP中我们会涉及到如下的相关概念

| 术语          | 说明                                                         |
| ------------- | :----------------------------------------------------------- |
| 切面          | 切面泛指交叉业务逻辑。比如事务处理、日志处理就可以理解为切面。常用的切面有通知与顾问。实际就是对主业务逻辑的一种增强 |
| 织入          | 织入是指将切面代码插入到目标对象的过程。                     |
| 连接点        | 连接点指切面可以织入的位置。                                 |
| 切入点        | 切入点指切面具体织入的位置。                                 |
| 通知(Advice)  | 通知是切面的一种实现，可以完成简单织入功能（织入功能就是在这里完成的）。通知定义了增强代码切入到目标代码的时间点，是目标方法执行之前执行，还是之后执行等。通知类型不同，切入时间不同。 |
| 顾问(Advisor) | 顾问是切面的另一种实现，能够将通知以更为复杂的方式织入到目标对象中，是将通知包装为更复杂切面的装配器。 不仅指定了切入时间点,还可以指定具体的切入点 |

### 2. 基于注解实现

#### 2.1 基本介绍

对于AOP这种编程思想，很多框架都进行了实现。Spring就是其中之一，可以完成面向切面编程。然而，AspectJ也实现了AOP的功能，且其实现方式更为简捷，使用更为方便，而且还支持注解式开发。所以，Spring又将AspectJ的对于AOP的实现也引入到了自己的框架中。在Spring中使用AOP开发时，一般使用AspectJ的实现方式。

![](..\img\AOPAnno.png)

AspectJ：是AOP思想的一种实现。本质上是静态代理，将代理逻辑“织入”被代理的目标类编译得到的字节码文件，所以最终效果是动态的。weaver就是织入器。Spring只是借用了AspectJ中的注解。



#### 2.2 基本案例

在xml文件中加入schema，并开启aop代理

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop.xsd">
    <context:component-scan base-package="org.moroboshidan"></context:component-scan>
    <aop:aspectj-autoproxy/>
</beans>
```



首先定义对应的接口

```java
public interface Calculator {
	int add(int i, int j);
    int dec(int i, int j);
    int mul(int i, int j);
    int div(int i, int j);
}
```

然后创建接口的实现类

```java
@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {return i + j;}
    @Override
    public int dec(int i, int j) {return i - j;}
    @Override
    public int mul(int i, int j) {return i * j;}
    @Override
    public int div(int i, int j) {return i / j;}
}
```

创建对应的切面类(被切面拦截的方法是自动执行的，不需要像代理那样在回调函数里调用)

```java
@Aspect
@Component
public class LogAspect {
    // 前置通知
    @Before("execution(public int org.moroboshidan.service.impl.CalculatorImpl.*(...))")
    public void beforeMethod(JoinPoint joinPoint) {
        sout("pre advice is executing ...");
        String name = joinPoit.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        sout("执行方法的相关信息：" + name + "参数" + args);
    }
}
```

测试

```java
@Test
public void test() {
    ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    Calculator calc = ac.getBean(Calculator.class); // 注意是接口的类文件
    sout(calc.add(1, 2));
}
```



#### 2.3 其他通知

* 前置通知 `@Before(value = "joinPoint")`
* 后置通知 `@AfterReturning(value="joinPoint", res="name")`
* 环绕通知 `@Around(value="joinPoint")`
* 异常通知 `@AfterThrowing(value="joinPoint", throwing="name")`
* 最终通知 `@After(value="joinPoint")`

相关的通知的案例：

```java
@Aspect // 被该注解所修饰的Java类就是一个切面类
@Component
public class LogAspect {

    /**
     * 前置通知:@Before()
     */
    @Before("execution(public int com.boge.service.impl.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("前置通知执行了。。。。");
        String name = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("执行方法的相关信息：" + name + " 参数：" + args);
    }

    /**
     * 后置通知:可以获取目标方法的返回结果，一旦返回立即执行，即使目标方法返回值外还有执行语句
     */
    @AfterReturning(value = "execution(* com.boge.service.impl.*.*(..))",returning = "res")
    public void afterReturningMethod(JoinPoint joinPoint,Object res){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("后置通知：" + methodName + "  返回结果：" + res);
    }

    /**
     * 环绕通知
     */
    @Around("execution(* com.boge.service.impl.*.*(..))")
    public Object  aroundMethod(ProceedingJoinPoint joinPoint){
        Object obj = null;
        try {
            System.out.println("环绕通知执行之前....");
            obj =joinPoint.proceed(); // 执行目标对象的方法
            System.out.println("环绕通知执行之后....");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知执行异常....");
        }finally {
            System.out.println("环绕通知执行....最终完成");
        }
        return obj;
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "execution(* com.boge.service.impl.*.*(..))",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("异常通知：" + methodName + " " + ex);
    }

    /**
     * 最终通知
     */
    @After(value = "execution(* com.boge.service.impl.*.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("最终通知执行了..." + methodName);
    }
}

```

&emsp;&emsp;&emsp;&emsp;

#### 2.4 切入点表达式

切入点表达式要匹配的对象就是目标方法的方法名。所以，execution表达式中明显就是方法的签名。注意，表达式中加[ ]的部分表示可省略部分，各部分间用空格分开。在其中可以使用以下符号

![image.png](..\img\joinPoint1.png)

语法要求：

![image.png](..\img\joinPointSyntax.png)

> `execution(public * org.morosboshidan.service.impl.*.*(..))`
>
> 上述语句表示，切入点可以匹配`org.moroboshidan.service.impl`包下，public修饰的，任意类下的，参数为任意个数，任意方法名，且返回值类型为任意值的方法。

作用：

![image.png](..\img\joinPoint2.png)

细节介绍：

* 用*号代替“权限修饰符”和“返回值”部分表示“权限修饰符”和“返回值”不限
* 在包名的部分，一个“*”号只能代表包的层次结构中的一层，表示这一层是任意的。
  * 例如：*.Hello匹配com.Hello，不匹配com.boge.Hello
* 在包名的部分，使用“*..”表示包名任意、包的层次深度任意
* 在类名的部分，类名部分整体用*号代替，表示类名任意
* 在类名的部分，可以使用*号代替类名的一部分
  * **例如：*Service匹配所有名称以Service结尾的类或接口**
* 在方法名部分，可以使用*号表示方法名任意
* 在方法名部分，可以使用*号代替方法名的一部分
  * **例如：*Operation匹配所有方法名以Operation结尾的方法**
* 在方法参数列表部分，使用(..)表示参数列表任意
* 在方法参数列表部分，使用(int,..)表示参数列表以一个int类型的参数开头
* 在方法参数列表部分，基本数据类型和对应的包装类型是不一样的
  * 切入点表达式中使用 int 和实际方法中 Integer 是不匹配的
* 在方法返回值部分，如果想要明确指定一个返回值类型，那么必须同时写明权限修饰符
  * 例如：execution(public int *..*Service.*(.., int))	正确
    **例如：execution(* int *..*Service.*(.., int))**	错误

如果一个切入点表达式需要被重复的复用。那么我们可以通过@Pointcut注解来定义表达式。然后我们在通知调用即可：

```java
package com.boge.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类
 */
@Aspect // 被该注解所修饰的Java类就是一个切面类
@Component
public class LogAspect2 {

    /**
     * 定义一个切入点表达式
     */
    @Pointcut("execution(public int com.boge.service.impl.CalculatorImpl.*(..))")
    public void ponitCut(){

    }

    /**
     * 前置通知:@Before()
     */
    @Before("ponitCut()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("前置通知执行了。。。。");
        String name = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("执行方法的相关信息：" + name + " 参数：" + args);
    }

    /**
     * 后置通知:可以获取目标方法的返回结果
     */
    @AfterReturning(value = "ponitCut()",returning = "res")
    public void afterReturningMethod(JoinPoint joinPoint,Object res){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("后置通知：" + methodName + "  返回结果：" + res);
    }

    /**
     * 环绕通知
     */
    @Around("ponitCut()")
    public Object  aroundMethod(ProceedingJoinPoint joinPoint){
        Object obj = null;
        try {
            System.out.println("环绕通知执行之前....");
            obj =joinPoint.proceed(); // 执行目标对象的方法
            System.out.println("环绕通知执行之后....");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知执行异常....");
        }finally {
            System.out.println("环绕通知执行....最终完成");
        }
        return obj;
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "ponitCut()",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("异常通知：" + methodName + " " + ex);
    }

    /**
     * 最终通知
     */
    @After(value = "ponitCut()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("最终通知执行了22..." + methodName);
    }
}

```



### 3. 基于XML实现

在Spring中AOP还有基于XML的实现方式。当然这种不是我们常用的方案。但是我们还是需要了解下

先定义对应的切面类：

```java
/**
 * 切面类
 */
@Component
public class LogAspect3 {

    /**
     * 前置通知:@Before()
     */
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("前置通知执行了。。。。");
        String name = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("执行方法的相关信息：" + name + " 参数：" + args);
    }

    /**
     * 后置通知:可以获取目标方法的返回结果
     */
    public void afterReturningMethod(JoinPoint joinPoint,Object res){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("后置通知：" + methodName + "  返回结果：" + res);
    }

    /**
     * 环绕通知
     */
    public Object  aroundMethod(ProceedingJoinPoint joinPoint){
        Object obj = null;
        try {
            System.out.println("环绕通知执行之前....");
            obj =joinPoint.proceed(); // 执行目标对象的方法
            System.out.println("环绕通知执行之后....");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知执行异常....");
        }finally {
            System.out.println("环绕通知执行....最终完成");
        }
        return obj;
    }

    /**
     * 异常通知
     */
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("异常通知：" + methodName + " " + ex);
    }

    /**
     * 最终通知
     */
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("最终通知执行了..." + methodName);
    }
}

```

然后定义对应的配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
       http://www.springframework.org/schema/aop/spring-aop.xsd">

    <!-- 添加扫描路径 -->
    <context:component-scan base-package="com.boge.*"></context:component-scan>
    <!-- 基于XML的AOP实现 -->
    <aop:config>
        <!-- 配置切面 -->
        <aop:aspect ref="logAspect3">
            <!-- 定义切入点表达式 -->
            <aop:pointcut id="pointCut" expression="execution(* com.boge.service.impl.*.*(..))"/>
            <!-- 配置相关的通知 -->
            <aop:before method="beforeMethod" pointcut-ref="pointCut"></aop:before>
            <aop:after-returning method="afterReturningMethod" pointcut-ref="pointCut" returning="res"></aop:after-returning>
            <aop:around method="aroundMethod" pointcut-ref="pointCut"></aop:around>
            <aop:after-throwing method="afterThrowingMethod" pointcut-ref="pointCut" throwing="ex"></aop:after-throwing>
            <aop:after method="afterMethod" pointcut-ref="pointCut"></aop:after>
        </aop:aspect>
    </aop:config>
</beans>
```

然后测试即可

![image.png](..\img\aspectXml.png)

# Spring6.0新特性

## 一、Spring的发展历史

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/f78f52f0d13d41b8a26e3ec0413d1f8d.png)

## 二、AOT

&emsp;&emsp;AOT是Spring6.0提供的一个新特性，Ahead of Time 提前编译。

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/5ad47e20fae547d1aa10e2bdbcd0ccb9.png)

## 1.AOT概述

### 1.1 JIT和AOT的关系

#### 1.1.1 JIT

&emsp;&emsp; JIT(Just-in-time) 动态编译，即时编译，也就是边运行边编译，也就是在程序运行时，动态生成代码，启动比较慢，编译时需要占用运行时的资源。

#### 1.1.2 AOT

&emsp;&emsp;AOT,Ahead Of Time 指的是运行前编译，预先编译，AOT 编译能直接将源代码转化为机器码，内存占用低，启动速度快，可以无需 runtime 运行，直接将 runtime 静态链接至最终的程序中，但是无运行时性能加成，不能根据程序运行情况做进一步的优化，AOT 缺点就是在程序运行前编译会使程序安装的时间增加。

**简单来讲**：JIT即时编译的是在程序的运行过程中，将字节码转换为可在硬件上直接运行的机器码，并部署至托管环境中的过程。而 AOT 编译指的则是，在程序运行之前，便将字节码转换为机器码的过程。

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/b07dc88e2e454880aad5ae40843c2d96.png)

## 三、GraalVM

GraalVM即支持AOT也支持JIT。支持多种开发语言。

&emsp;&emsp;Spring6 支持的 AOT 技术，这个 GraalVM  就是底层的支持，Spring 也对 GraalVM 本机映像提供了一流的支持。GraalVM 是一种高性能 JDK，旨在加速用 Java 和其他 JVM 语言编写的应用程序的执行，同时还为 JavaScript、Python 和许多其他流行语言提供运行时。 GraalVM 提供两种运行 Java 应用程序的方法：在 HotSpot JVM 上使用 Graal 即时 (JIT) 编译器或作为提前 (AOT) 编译的本机可执行文件。 GraalVM 的多语言能力使得在单个应用程序中混合多种编程语言成为可能，同时消除了外语调用成本。GraalVM 向 HotSpot Java 虚拟机添加了一个用 Java 编写的高级即时 (JIT) 优化编译器。

GraalVM 具有以下特性：

（1）一种高级优化编译器，它生成更快、更精简的代码，需要更少的计算资源

（2）AOT 本机图像编译提前将 Java 应用程序编译为本机二进制文件，立即启动，无需预热即可实现最高性能

（3）Polyglot 编程在单个应用程序中利用流行语言的最佳功能和库，无需额外开销

（4）高级工具在 Java 和多种语言中调试、监视、分析和优化资源消耗

### 1.GraalVM安装

#### 1.1 下载GraalVM

下载地址：https://www.graalvm.org/downloads/![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/e338e9f6443c4625a79a30a7e1b38fb3.png)

下载社区版本即可，点击进入选择相关的版本：https://github.com/graalvm/graalvm-ce-builds/releases

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/b5bd6b0b848e43f7994516a4c2fc5b68.png)

下载好后解压缩出来

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/5306fe92e01c4aca9d4782c044577ed6.png)

#### 1.2 配置环境变量

添加：GRAALVM_HOME

编辑用户变量

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/beec6cd3bc8841ab9e6deca8b8f13d66.png)

把JAVA_HOME修改为graalvm的位置

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/07c04dde102c4ae19d3518927a6e25f5.png)

检查是否配置成功

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/66e630ed2fb449459dcb6877f6124325.png)

#### 1.3 安装native-image插件

使用命令 gu install native-image 下载安装插件，因为社区版默认不提供支持。需要手动下载

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/bd4febd41c204a38aa2ae71008da1eb9.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/b768615e0b40438b885e17e3e201a9d2.png)

#### 1.4 Native Image

&emsp;&emsp;Native image（本地镜像）是一种在Java平台上构建本地应用程序的技术。它将Java应用程序编译成本地机器代码，以便在不需要Java虚拟机（JVM）的情况下运行。这使得应用程序可以更快地启动，更高效地执行，并且占用更少的内存。

&emsp;&emsp;Native image使用GraalVM编译器技术，可以将Java应用程序转换为本地可执行文件，支持Windows、Linux和MacOS等多个操作系统平台。此外，Native image还可以将Java应用程序打包成单个可执行文件，从而方便部署和分发。

&emsp;&emsp;使用Native image，开发人员可以将Java应用程序作为本地应用程序来构建和部署，从而获得更好的性能和更好的用户体验。

### 2.安装C++的编译环境

#### 2.1 下载Visual Studio

[https://visualstudio.microsoft.com/zh-hans/downloads/](https://visualstudio.microsoft.com/zh-hans/downloads/)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/19046151d2ca474c99a2006fa2a77354.png)

同样我们下载社区版本即可

#### 2.2 安装Visual Studio

下载后双击直接安装即可

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/933f6005ff6d4fb29768c31a78ee7dd6.png)

等待在线下载

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/2dfbc250d97c4e0881a187cec26c73f9.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/7cc10245f27f483e9ee8516a79cee4b3.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/9bedc375b3014669acd8a9c001afed07.png)

注意安装选项，然后继续等待

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/993d1d742a0d4762bd26cb719227064a.png)

创建一个普通Hello.java文件

```java
public class Hello{

	public static void main(String[] args){
		System.out.println("Hello World ...");
	}
}
```

然后通过 javac Hello.java 编译

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/073f04a5a3a84aada095d8d8b1498c1c.png)

通过native-image Hello 执行

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/017a5c8c351f4f7cb1ed558c90a882f0.png)

通过 native-image 生成了 Hello.exe 文件，我们就可以直接生成了。

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/7b9e5cc580b749a0b4cb43d3e09339cc.png)

## 四、SpringBoot实战

&emsp;&emsp;我们同样可以在SpringBoot项目中通过AOT来提前编译我们的项目，新建一个Maven项目。然后添加相关的依赖

```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.0.2</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
```

同时我们还需要添加相关的SpringBoot插件

```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.graalvm.buildtools</groupId>
                <artifactId>native-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
```

然后我们编写一点简单的代码测试即可

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/5173c84db5e54ae7abe5f7fa0a1825eb.png)

然后我们打开 x64 Native Tools Command Prompt for VS 2019 。然后我们需要切换到工程目录下

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/74400c42fea44e4b99676f811411aa85.png)

然后执行 mvn -Pnative native:compile 进行编译就可以了，编译成功就会在target目录下生成 EXE 文件。后续执行该文件就可以了

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/c5d69ff42fc2463a89f6806a8003361f.png)

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/1d0fd4b7b5ed4d879a0c83a59b84d893.png)

编译成功

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/db69f0675986426985635cba5e57c9b4.png)

然后我们双击执行exe文件即可。你会发现速度会快很多

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/150cab91d7e447e0bcb06bb43b143602.png)

## 五、RuntimeHints

&emsp;&emsp;与常规 JVM 运行时相比，将应用程序作为本机映像运行需要额外的信息。例如，GraalVM 需要提前知道组件是否使用反射。同样，除非明确指定，否则类路径资源不会在本机映像中提供。因此，如果应用程序需要加载资源，则必须从相应的 GraalVM 原生图像配置文件中引用它。

API[`RuntimeHints`](https://docs.spring.io/spring-framework/docs/6.0.9/javadoc-api/org/springframework/aot/hint/RuntimeHints.html)在运行时收集反射、资源加载、序列化和 JDK 代理的需求。

### 1.案例分析

声明个普通的实体类型

```java
public class UserEntity {
    public String hello(){
        return "hello ...";
    }
}
```

然后我们在控制器中通过反射来操作处理

```java
    @GetMapping("/hello")
    public String hello(){
        String res = "hello";
        try {
            Method hello = UserEntity.class.getMethod("hello");
            res =  (String)hello.invoke(UserEntity.class.newInstance(),null);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        return res;
    }
```

然后通过命令编译为 exe 文件

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/1488471aa8994afe988fdf5e5f9a84e8.png)

运行exe文件后。我们通过浏览器发起请求

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/81bc9f42e09a4493ae2b0ff1fbf77085.png)

在HelloController中。我们通过反射的方式使用到了UserEntity的无参构造方法。如果不做任何处理。那么打成二进制可执行文件后是执行不了的。上面是具体的报错信息。针对这种情况。我们可以通过 Runtime Hints 机制来处理。

### 2. RuntimeHintsRegistrar

官网提供的解决方案。我们自定义一个RuntimeHintsRegistrar接口的实现类，然后把该实现类注入到Spring中

![image.png](https://fynotefile.oss-cn-zhangjiakou.aliyuncs.com/fynote/fyfile/1462/1683612311015/aee7a64697a84a8e8cc424e91f20e1fd.png)

我们自己的实现

```java
@RestController
@ImportRuntimeHints(HelloController.UserEntityRuntimeHints.class)
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        String res = "hello";
        try {
            Method hello = UserEntity.class.getMethod("hello");
            res =  (String)hello.invoke(UserEntity.class.newInstance(),null);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    static class UserEntityRuntimeHints implements RuntimeHintsRegistrar{

        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            try {
                hints.reflection().registerConstructor(UserEntity.class.getConstructor(), ExecutableMode.INVOKE);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
```

