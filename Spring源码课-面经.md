# 1. 谈谈你对Spring IoC的理解，原理与实现？

回答问题采用总分结构，先总体阐述，然后分说重点

## 总：

​	首先，解释什么是IoC控制反转。是一种理论思想，原先是由对象的使用者来负责创建对象的，但是，这种方式耦合度太高。于是，控制反转是将对象的使用权和创建权分开，将后者交给容器来管理。在Spring中，我们可以将对象交给Spring来管理。

​	然后，介绍Spring中控制反转的思想是如何实现的。DI依赖注入，将具体的成员属性值注入到对象中来完成赋值。通过@Autowired，populateBean等方式来完成属性的注入。

​	IoC容器，用于存储对象。*使用map结构来存储，在Spring中一般存在三级缓存，常用singletonObject存储完整bean对象。*整个bean对象的生命周期，从创建到管理到销毁的过程都是由容器来管理的。

> 上述回答，可能被继续追问的问题
>
> - 三级缓存，是否存在循环依赖，如何解决
> - 常用的用来存储bean对象的map结构有哪些
> - bean对象的生命周期：如何创建、如何管理、如何销毁

## 分：

1. 一般聊IoC容器的时候要涉及到容器的创建过程。(beanFactory, DefaultListableBeanFactory)

​	容器最上层有一个根接口`beanFactory`，没有提供对应的实现类。在实际调用过程中，最常用的就是`DefaultListableBeanFactory`实现类。创建完bean工厂后，需要设置一些参数，如BeanPostProcessor, Aware接口的子类，等属性。

2. 加载解析bean对象，准备要创建对象的定义对象beaDefinition(涉及到xml，或注解的解析过程)
   1. beanFactoryPostProcesso的处理，此处是扩展点，如

# 2. 