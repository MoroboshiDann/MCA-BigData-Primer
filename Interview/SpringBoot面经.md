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

## 4. SpringBoot启动过程

​	`SpringApplication`是SpringBoot的一个类，其内部最主要的方法为`run()`，一个静态方法。启动类调用这个方法，并将启动类的字节码传入。在`run()`方法中，需要做如下操作：

- 获取一个Spring容器：由于SpringBoot的配置是基于注解实现的，所以通常会获取一个`AnnotationConfigWebApplicationContext`容器。
- 根据配置类的字节码文件来设置Spring容器：调用`applicationContext.register(clazz)`方法，并将启动类的字节码文件传入。为Spring容器指定相应的SpringBean的信息。
- 启动容器：通过容器调用`applicationContext.refresh()`方法，来启动容器。
- 创建并启动WebServer服务器

## 5. SpringBoot包扫描路径修改

在启动类上添加`@ComponentScan`来指定包路径，或者指定某个类。

## 6. 布隆过滤器优缺点

优点：

1. 空间占用极小，因为本身不存储数据而是用比特位表示数据是否存在，某种程度有保密的效果。
2. 插入与查询时间复杂度均为 O(k)，常数级别，k 表示散列函数执行次数
3. 散列函数之间可以相互独立，可以在硬件指令层加速计算

缺点：

1. 误差（假存在性）
2. 无法删除

误判了怎么办：

- 调整布隆过滤器的参数：调整哈希函数的数量和位数组的大小。
- 使用多个布隆过滤器。
