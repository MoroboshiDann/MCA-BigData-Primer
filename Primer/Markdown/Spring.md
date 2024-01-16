# Spring Framework介绍

## 官方文档

https://www.spring.io

## Spring的发展历史

宇宙

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





## 三、基于注解的方式

