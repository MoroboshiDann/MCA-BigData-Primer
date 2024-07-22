# Spring基础

## 1. 什么是Spring

Spring是一款轻量级的Java开发框架，旨在提高开发效率和系统可维护性。Spring支持IoC和AOP，可以很方便地和数据库交互，可以很方便地集成第三方插件，对单元测试也比较友好。

## 2. Spring包含哪些模块

Core Container
- spring-core：Spring框架的核心工具类。
- spring-beans：Spring对bean的创建、配置和管理功能的支持。
- spring-context：提供对国际化、事件传播、资源加载等功能的支持。
- spring-expression：提供对表达式语言的支持。

AOP
- spring-aspects：为与AspectsJ的集成提供支持。
- spring-aop：提供了面向切面编程的实现。
- spring-instrument：提供了为JVM添加代理(agent)的功能。

DataAccess/Integration
- spring-jdbc：提供对数据库访问的抽象JDBC，不同数据库有自己的独立API，但是Java程序只需要JDBC API交互即可。
- spring-tx：提供对事务的支持。
- spring-orm：提供对Hibernate、iBatis等ORM(Object Relation Mapping)框架的支持。
- spring-oxm：提供一个抽象层支持OXM(Object-to-XML-Mapping)。
- spring-jms：提供对spring-messaging模块的继承。

Spring Web
- spring-web：对web功能的实现提供一些最基础的支持。
- spring-webmvc：提供对SpringMVC的支持。
- spring-websocket：提供对WebSocket的支持。WebSocket可以让客户端和服务端进行双向通信。
- spring-flux：提供对WebFlux的支持，新的响应式框架。

Messaging
- spring-messaging：为Spring框架集成一些最基础的报文传送应用。

Spring Test
- 有了IoC的支持，单元测试和集成测试变得十分轻松。


## 3. Spring、SpringMVC和SpringBoot的关系

Spring中包含了很多模块，其中spring-core是最核心的模块，其他模块都依赖于它。

SpringMVC是其中很重要的一个模块，赋予了Spring框架快速构建MVC架构的Web应用的能力。MVC是模型(Model)、视图(View)、控制器(Controller)的简写，其核心思想是将业务逻辑、数据以及显示分开处理。

SpringBoot是Spring框架的一个应用。使用Spring进行业务开发时，需要手动通过XML文件进行大量的配置，十分繁琐。SpringBoot提供的自动装配功能简化了项目的配置方式，使得其可以做到开箱即用。但是，它只是简化了配置，当需要开发MVC应用时，还是需要使用SpringMVC作为MVC框架。


# Spring IoC

## 1. 谈谈自己对IoC的理解

IoC(Inversion of Control)控制反转，是一种设计思想而不是具体的实现。IoC思想就是将对象的使用权和控制权分离，并将程序控制对象的权力交给Spring框架的IoC容器。控制反转中的反转，就是将控制权交给外部环境。

IoC在Spring中是通过DI(Domain Inject)领域注入来实现的。将对象之间的依赖关系交给IoC容器管理，并由其完成依赖的注入。程序只需做好配置即可，不需要关心对象什么时候被创建。IoC会负责管理对象的生命周期，并在合适的时机将依赖对象注入。

一开始，我们通过XML文件来配置Bean，但是这样的方式过于繁琐，后来大都采用注解的方式来配置Bean。


## 2. 什么是Spring Bean

在Java种Bean就是被管理的对象，因此Spring Bean就是被Spring IoC容器管理的对象。当我们需要让Spring IoC容器管理某个类的对象时，就需要将其注册为Spring Bean，如在XML文件中通过标签来指定Bean的信息。


## 3. 将一个类注册为Spring Bean的方式有哪些

首先是通过XML文件来注册，即通过`<bean>`标签来给定Bean的信息。

其次，可以通过注解的方式，有如下注解：
- `@Component`：通用的注解，可以将任意类标记为Bean。
- `@Service`：对应服务层，主要涉及一些复杂的处理逻辑。
- `@Controller`：对应控制层，接受用户请求，并处调用service进行处理。
- `@Repository`：对应持久层，负责数据库相关操作。


## 4. @Component和@Bean的区别

- `@Component`作用在类上，而`@Bean`作用在方法上。
- `@Component`一般是通过类路径扫描来自动侦测并自动装配到Spring容器中。可以通过`@ComponentScan`注解来指定扫描路径。
- `@Bean`注解通常是将在被该注解修饰的方法的返回值注册为Bean，通知Spring这个返回值是一个Bean，在需要时获取。
- `@Bean`注解比`@Component`注解自定义性更强，比如我们需要用到第三方库中的类，就只能通过`@Bean`注解。


## 5. 注入Bean的方式

- `@Autowired`：Spring内置的注解，是通过类型来匹配。
  - 如果一个接口有多个实现类，就不能正确注入，因此需要通过`@Qualifier`来指定名称。
- `@Resource`：Java提供的注解，通过名称来匹配需要注入的实现类对象。
  - 如果一个接口有多个实现类，只需要将变量名改为对应的实现类名就能正常注入，但是不推荐，一般可以在注解中通过`name`属性指定。
- `@Inject`


## 6. Bean的作用域

Spring中Bean的作用域通常有下面几个：
- singleton：单例模式，IoC容器里面只有唯一的Bean实例。Spring中默认就是单例模式。
- prototype：每次获取Bean都会创建一个新的实例。也就是说连续两次`getBean()`获取的都是不同的实例。
- request：仅Web应用可用。每一次HTTP请求都会实例化一个新的Bean。Bean仅在当前的HTTP请求中有效。
- session：仅Web应用可用。每个session一个Bean实例。
- application/global-session：仅Web应用可用。Web应用启动时实例化一个Bean实例。作用域就是当前运行时间。
- websocket：每一个websocket产生一个Bean。

Bean的作用域可以通过XML的`scope`属性或者通过`@Scope`注解来指定。


## 7. Bean是否线程安全

Bean是否线程安全，取决于作用域。

在prototype模式下，每次获取Bean都会创建新的实例，因此线程之间不会存在竞争问题，所以也不会有线程安全问题。

singleton模式下，一个Bean只会有一个实例化对象，线程之间需要竞争。如果Bean对象中有可变的成员对象变量就会存在线程安全问题。

该模式下线程安全问题的解决方式：
- 尽量避免定义可变的成员变量。
- 在类中定义一个`ThreadLocal`成员变量，将可变成员都放在其中。


## 8. Bean的生命周期

1. 创建Bean实例：Spring根据配置找到Bean的定义，然后通过Java的反射API来实例化Bean。
2. Bean对象的属性填充：为Bean对象设置相关的属性值或依赖，如通过`@Autowired`注入的依赖和`@Value`注入的值。
3. Bean的初始化：
   - 如果Bean实现了`*Aware`接口，就调用相应的方法设置值。
4. 销毁Bean：不是立即销毁Bean对象，而是将Bean的销毁方法记录下来，等到需要销毁Bean或销毁容器时再调用，释放资源。
   - 如果Bean实现了`DisposableBean`接口，执行`destory()`方法。
   - 如果Bean的配置文件中设置了`destroy-method`属性，执行指定的销毁方法。


# Spring AOP

## 1. 谈谈自己对Spring AOP的理解

AOP(Aspect Oriented Programming)面向切面编程。能够将与业务无关，但是为业务模块提供公共逻辑的代码抽取出来，减少系统代码，降低模块之间的耦合，利于未来的扩展和维护。

AOP是通过动态带来实现的，如果代理的类实现了某个接口，就可以通过JDK Proxy来代理；如果代理的类没有实现接口，就只能通过CGLib Proxy来代理。
- JDK Proxy：代理类实现被代理类实现的接口。
- CGLib Proxy：为被代理类生成一个子类来代理。

## 2. Spring AOP原理

通过动态代理，给连接点所在的类生成一个代理对象，当执行到连接点方法时，就会调用切面中的通知方法。

Spring AOP要么通过JDK代理，要么通过CGLib代理。所以，被代理的类要么实现了接口，要么可以被继承。

SpringAOP失效场景：

- 非Spring管理的对象：SpringAOP只能拦截SpringIoC容器中的对象，如果连接点在一个非SpringBean的类中，就无法拦截。
- 同一个Bean中方法调用：以JDK代理为例，会给被拦截的对象生成一个代理对象，假设对象中有A、B两个方法，B为连接点。执行被拦截对象的方法时，都会调用`InvocationHandler#invoke`方法，在其中会判断是否为满足切点，不满足直接通过`Method#invoke`来调用执行，而不拦截。如果A中调用了B，那么就无法拦截，因为A调用B不是通过代理对象调用的。
- 类被final修饰，从而不能被继承。方法被static修饰不能重写。


# Spring MVC

## 1. 说说自己对Spring MVC的理解

MVC即模型、视图和控制器，其核心思想是将业务逻辑、数据和显示分离开来组织代码。

Spring MVC一般将代码分为：Service层、Dao层、Entity层和Controller层。


## 2. Spring MVC的核心组件

- DispatcherServlet：核心的中央处理器，负责接受请求、分发，并返回响应。
- HandlerMapping：处理器映射器，根据URL来匹配对应的Handler，并会将请求涉及到的拦截器和Handler一起封装。
- HandlerAdapter：处理器适配器，根据映射器找到的Handler，适配执行Handler。
- Handler：请求处理器，处理请求。
- ViewResolver：视图解析器，根据Handler返回的数据解析真正的视图，并传递给DispatcherServlet响应给前端。


## 3. Spring MVC工作流程

![](../img/springmvc-process.png)

1. DispatcherServlet接收到Web服务器传入的请求URL，调用HandlerMapping来匹配对应的Handler。
2. HandlerMapping将找到的Handler返回，DispatcherServlet传递给HandlerAdapter来适配调用。
3. HandlerAdapter适配调用对应的Handler。
4. Handler处理完成后，将结果ModelAndView返回给HandlerAdapter，HandlerAdapter将结果返回给DispatcherServlet。
5. DishpatcherServlet将处理结果交给ViewResolver来解析。
6. ViewResolver根据逻辑View匹配到实际的View。
7. DispatcherServlet将Model交给View渲染。
8. 渲染完成后将页面返回给前端。


## 4. 统一异常处理怎么做

通过`@ControllerAdvice`和`@ExceptionHandler`注解来实现。定义一个异常处理类，并用`@ControllerAdvice`修饰。在类中对不同的异常定义不同的方法来处理，并在方法上添加`@ExceptionHandler`来指定处理哪个异常。



# Spring框架中的设计模式

- 工厂模式：Spring通过BeanFactory和ApplicationContext分别获取Bean对象和IoC容器实例。
- 代理模式：SpringAOP的实现。
- 单例模式：SpringIoC容器中的Bean默认都是单例的。
- 模板方法模式：Spring中jdbcTemplate等以Template结尾的对数据库操作的类，都用到了模板方法模式。

# Spring中的循环依赖

## 1. Spring中如何解决循环依赖

循环依赖是指Bean对象之间循环引用。Spring通过三级缓存来解决循环依赖。

三级缓存其实就是三个Map集合。
- 一级缓存(singletonObjects)：存放最终形态的Bean(已经被实例化、属性填充、初始化)，是单例池。一帮情况下获取的Bean对象就是从这里获取的。但是也不是所有的Bean都储存在这里，prototype模式下的Bean就不在其中。
- 二级缓存(earlySingletonObjects)：用来存储半成品Bean，也就是从三级缓存中的Factory生产出来的对象。与三级缓存配合使用。
- 三级缓存(singletonFactories)：存放`ObjectFactory`，即Bean的工厂对象，可以生成原始Bean对象或代理对象。三级缓存只对单例模式生效。

Spring创建对象的流程：
- 先去一级缓存获取，存在就返回。
- 如果不存在或者正在创建中，就去二级缓存中获取。
- 如果二级缓存中还是没有，就去三级缓存中获取工厂对象，通过执行Factory的`getObject()`方法就可以获取该对象。获取成功后，会将三级缓存中的工厂对象移除，并将该对象加入到二级缓存。

如何解决循环依赖：

如果Spring允许循环依赖，会将刚刚创建、还没有初始化完成的Bean提前暴露出去，即通过`addSingletonFactory()`方法在三级缓存中添加一个工厂对象。该工厂对象就可以获取到这个没有初始化完成的对象。

对于以下代码:
```java
class A {
    private B b;
}
class B {
    private A a;
}
```
- Spring创建A之后，发现A依赖了B，就去创建B
- 创建B时，发现B依赖A，又会去获取A，由于此时A没有初始化完成，因此一二级缓存都找不到A。
- Spring会通过三级缓存中的工厂对象获取到提前暴露的A对象。此时的A对象只存在于运行时内存，还没有存放到三级缓存中的任意一个中。
- 然后，将A的工厂对象移除，并将提前暴露的A放入二级缓存。此时，B中就成功注入了A对象，B创建完成，初始化完成。
- 继续对二级缓存中的A进行初始化，A于是也成功注入了创建完成的B对象。

### 只有两级缓存可以吗

如果没有AOP，确实可以只通过一级和三级缓存来解决循环依赖。但是，当涉及到 AOP 时，二级缓存就显得非常重要了，因为它确保了即使在 Bean 的创建过程中有多次对早期引用的请求，也始终只返回同一个代理对象，从而避免了同一个 Bean 有多个代理对象的问题。


## 2. @Lazy能否解决循环依赖

@Lazy注解用来标识是否懒加载，如果被标记为懒加载，IoC容器启动时不会立即加载该Bean，而是第一次请求时才会实例化。

当给A的构造器标注了@Lazy，Spring创建A的时候会给B创建一个代理对象，将之注入到A中。此时A就完成了创建。

当创建B的时候，A已经完成实例化，就可以直接注入。


# Spring事务

## 1. Spring的事务管理方式

- 编程式事务：在代码中硬编码实现，通过TransactionTemplate或TransactionManager来实现。事务范围过大会出现事务未提交导致超时，因此事务的粒度要比锁的粒度小。
- 声明式事务：通过`@Transacntional`注解来声明，是通过AOP实现的。


## 2. Spring事务中的传播行为

事务传播行为是为了解决业务层方法之间互相调用的事务问题。当事务方法被另一个事务方法调用时，必须指定事务应该如何传播。

正确的事务传播行为如下：
- TransactionDefinition.PROPAGATION_REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。使用的最多的一个事务传播行为，我们平时经常使用的@Transactional注解默认使用就是这个事务传播行为。
- TransactionDefinition.PROPAGATION_REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
- TransactionDefinition.PROPAGATION_NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。
- TransactionDefinition.PROPAGATION_MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。


## 3. 事务的隔离级别

- TransactionDefinition.ISOLATION_DEFAULT：使用后端数据库默认的隔离级别，MySQL 默认采用的 REPEATABLE_READ 隔离级别 Oracle 默认采用的 READ_COMMITTED 隔离级别.
- TransactionDefinition.ISOLATION_READ_UNCOMMITTED：最低的隔离级别，使用这个隔离级别很少，因为它允许读取尚未提交的数据变更，可能会导致脏读、幻读或不可重复读
- TransactionDefinition.ISOLATION_READ_COMMITTED：允许读取并发事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生
- TransactionDefinition.ISOLATION_REPEATABLE_READ：对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，但幻读仍有可能发生。
- TransactionDefinition.ISOLATION_SERIALIZABLE：最高的隔离级别，完全服从 ACID 的隔离级别。所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。但是这将严重影响程序的性能。通常情况下也不会用到该级别。
