## 1. SpringBoot自动装配原理

### 什么是自动装配

​	开发Spring程序时，如果需要引入第三方依赖，通常需要手动通过配置类来配置Bean的相关属性，还需要通过XML文件来注册Bean，十分繁琐。而SpringBoot程序只需要导入相关Starter依赖即可做到开箱即用。

​	这是因为SpringBoot为相关的组件都提供了Starter依赖(Starter机制)，在其中为组件涉及到的Bean都做了约定俗成的默认配置，放置在自动配置类文件中。在每个Starter的`resources/META_INF`文件夹下的`spring.factories`文件中存储了自动配置类文件的全路径名。SpringBoot程序在启动时会将涉及到的自动配置类加载进内存，然后根据该条件判断是否加载其中配置好的Bean。由此以来，SpringBoot程序只需要导入Starter依赖即可做到开箱即用，无需额外配置。

### @SpringBootApplication

​	SpringBoot程序的核心注解，作用在启动类上。主要由三个注解构成：

- `@Configuration`：表明启动类也是一个Spring配置类，允许在上下文创建和配置Bean。
- `@ComponentScan`：包扫描路径，默认为启动类路径下，及其子包。
- `@EnableAutoConfiguration`：自动装配的核心注解，表明开启自动装配。基本上是一个空注解，其通过`@Import(AutoConfigurationImportSelector.class)`来实现自动装配。

### AutoConfigurationImportSelector

​	其中的`selectImports()`方法，默认从`resources/META_INF/spring.factories`中，将需要自动装配的组件的*自动配置类*全路径名读取出来。然后，根据条件加载自动配置类。

​	在SpringBoot-AutoConfigure的`META_INF/spring.factories`中将所有Starter的自动配置类全路径都已经给出，但是，不是所有的自动配置类都会生效，而是根据条件注解来判断是否生效。例如，是否导入了对应的jar包，是否存在某个Class类。



## 2. 自动配置文件的加载顺序

默认通过`resources/spring.factories`文件来读取。

但是，SpringBoot支持四种位置来存放该文件，优先级从低到高：
- `/config`目录，根目录下的config包中
- `/`根目录中
- `resources/config`
- `resources`

SpringBoot启动时会依次尝试从以上位置加载自动配置类，高优先级的加载结果会覆盖低优先级的。



## 3. SpringBoot启动过程

​	`SpringApplication`是SpringBoot的一个类，其内部最主要的方法为`run()`，一个静态方法。启动类调用这个方法，并将启动类的字节码传入。在`run()`方法中，需要做如下操作：

- 获取一个Spring容器：由于SpringBoot的配置是基于注解实现的，所以通常会获取一个`AnnotationConfigWebApplicationContext`容器。
- 根据配置类的字节码文件来设置Spring容器：调用`applicationContext.register(clazz)`方法，并将启动类的字节码文件传入。为Spring容器指定相应的SpringBean的信息。
- 启动容器：通过容器调用`applicationContext.refresh()`方法，来启动容器。
- 创建并启动WebServer服务器



## 4. SpringBoot包扫描路径修改

在启动类上添加`@ComponentScan`来指定包路径，或者指定某个类。

