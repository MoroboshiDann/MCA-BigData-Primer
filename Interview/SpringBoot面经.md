## 1. SpringBoot自动装配

自动装配就是，SpringBoot在启动时，会自动扫描`META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`中指明的自动配置类，根据条件来装配对应的jar包。

## 2. SpringBoot自动装配原理

SpringBoot核心注解`@SpringBootApplication`。

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
<1.>@SpringBootConfiguration
<2.>@ComponentScan
<3.>@EnableAutoConfiguration
public @interface SpringBootApplication {

}

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration //实际上它也是一个配置类
public @interface SpringBootConfiguration {
}
```

其中比较关键的是`@Configuration` `@EnableAutoConfiguration` 和 `@ComponentScan`。
- `@Configuration`：表明当前类是一个Spring配置类，允许在上下文中注册额外的Bean或导入其他配置类。
- `@ComponentScan`：指定扫描`@Component`注解修饰的类，默认会扫描当前类所在路径下所有的类和包。
- `@EnableAutoConfiguration`：启用SpringBoot的自动装配。

### @EnableAutoConfiguration实现自动装配的核心注解

`@EnableAutoConfiguration`只是一个简单的注解，自动装配核心功能的实现实际是通过`AutoConfigurationImportSelector`类。

### AutoConfigurationImportSelector加载自动装配类

`AutoConfigurationImportSelector` 类实现了 `ImportSelector`接口，也就实现了这个接口中的 `selectImports()`方法，该方法主要用于获取所有符合条件的类的全限定类名，这些类需要被加载到IoC容器中。

其核心逻辑就是：判断是否启用自动装配，如果启用就到指定文件中获取所有需要自动装配的所有配置类。然后，根据条件(一般是是否存在某个Class对象)来判断是否将某个类加载到IoC容器中。

### 总结

SpringBoot为一个Web应用的各个部分，如Web服务器，都提供了默认实现，但是也支持用户自己使用指定的实现。于是，将每部分都设置了设置类，设置类会根据导入的依赖来加载对应的Bean。

SpringBoot将配置类的路径维护在文件中，当启动时就加载该文件获取所有需要自动配置的类，然后根据条件进行装配。 

## 3. 自动配置文件的加载顺序

默认通过`resources/spring.factories`文件来读取。

但是，SpringBoot支持四种位置来存放该文件，优先级从低到高：
- `/config`目录，根目录下的config包中
- `/`根目录中
- `resources/config`
- `resources`

SpringBoot启动时会依次尝试从以上位置加载自动配置类，高优先级的加载结果会覆盖低优先级的。
