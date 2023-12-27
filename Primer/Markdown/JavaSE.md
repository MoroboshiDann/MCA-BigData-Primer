# JavaSE初阶

## 初识Java

### 计算机语言的发展历史

计算机语言经过了三代发展

- 第一代：机器语言。直接使用机器码(二进制01串)变成
- 第二代：汇编语言。使用机器指令的助记符来编程
- 第三代：高级语言。语寻程序员使用接近自然语言的指令来编程
  - 面向过程：C，ADA
  - 面向对象：C++，Java，Python

### Java简史

#### 发明目的

SUN公司的Green项目，因为电视盒子这类的电子产品的出现，需要一款小巧紧凑能跨平台(与平台无关)的语言。

要求：语言本身中立，能跨平台

#### 经历阶段

- 2009年，甲骨文(Oracle)公司收购SUN公司
- 2014年推出Java 8

> 目前每半年更新一次Java的版本，但是企业中的主流仍然是7和8。

### Java体系结构

#### JavaSE

Java Standard Edition，标准版，定位在个人计算机上的应用。包括了支持Java应用程序开发和运行的核心类库以及虚拟机等核心组件。

#### JavaEE

Java Enterprise Edition，企业版，定位在五服务器端的应用。是JavaSE的扩展，增加了支持企业级应用开发和部署的标准和规范(Servlet、JSP、EJB、JDBC、JPA、JTA、JMS等)。

#### JavaME

Java Micro Edition，微型版，定位在消费性电子产品的应用上。

> JavaEE包含JavaSE，与JavaME有交集

### Java特性和优势

优势如下：

- 跨平台/可移植性
- 安全性
- 面向对象
- 简单性
- 高性能
- 分布式
- 多线程
- 健壮性

总结：Java很好，在服务端编程和跨平台客户端应用领域很有优势。

### 垃圾收集机制

垃圾收集的目的：清除不再使用的对象。

当对象建立的时候，垃圾收集器就开始监控对象的动态情况，垃圾收集主要是对内存的释放。

- 不再使用的内存空间应被回收

- Java消除了程序员回收无用内存空间的职责，提供一种**系统级线程**跟踪存储空间的分配情况。在JVM空闲时，检查并释放可被释放的内存空间。

- 垃圾收集在Java程序运行过程中自动运行，程序员无法精确控制和干预。
- GC的自动回收，提高了内存空间的利用效率，也提高了编程人员的效率，很大程度上减少了因为没有释放空间而导致的**内存泄漏**。
  - 内存泄漏：申请的空间没有释放，程序也失去了对该空间的访问权，导致空间一直被占用。
  - 内存溢出：申请的空间超出了系统能提供的空间。

> 后续：
>
> - 垃圾收集器的种类
> - 垃圾收集器的底层原理剖析
> - 垃圾收集器的算法与优化

### 跨平台原理

Java是半编译半解释型语言。`.java`源文件经过**编译**，得到`.class`字节码文件，字节码文件便可以在不同平台对应的JVM上进行解释运行。JVM可以将字节码文件翻译为对应平台的机器码。

一次编译，到处运行

> C语言的跨平台原理
>
> `.c`源文件，经过不同平台的编译器，编译为对应平台上可以运行的`.exe`可执行文件
>
> 实际上跨平台是指编译后的文件能否在不同平台上运行，因此C严格来说不是跨平台语言
>
> 不同的平台需要重新编译
>
> 效率对比：C语言效率高，因为`.exe`文件可以直接运行，不需要解释

### 常见DOS命令

常用命令：

- 创建文件夹（ md [盘符:] [路径名] 文件夹名称 ）make directory
- 删除文件夹（ rd [盘符:] [路径名] 文件夹名称 ）remove directory
- 创建文件（ copy con 文件名称.后缀名 ）（ 可以创建，但输入内容的问题还没有解决）
- 查看文件（ type 文件名称.后缀名 ）
- 删除文件（ del 文件名称.后缀名 ）delete
- 拷贝（复制）文件（ copy [源目录或文件] [目的目录或文件] ）

### 编译 执行

从编写到运行的过程：

- 编写`.java`源文件
- 在同目录下打开cmd，使用javac编译该文件，生成`.class`字节码文件
- 使用java运行生成的字节码文件，不需要`.class`后缀

### 常见错误

- 类名与文件名不一致
- 不区分大小写，Java是对大小写敏感的
- 一个文件中可以存在多个类，但是只有一个`public`修饰，且该类必须与源文件名一致
  - 如果一个文件包含了多个类，编译过后会产生独立的`.class`字节码文件，可以独立运行

### API

Application Programming Interface，应用程序编程接口，是一些预先定义好的方法

JDK帮助文档是SUN公司为JDK工具包提供的文档资料，记录了JDK所提供的类的信息



### 反编译工具的使用

反编译，将`.class`字节码文件转换为`.java`源文件

反编译工具：jd-gui.exe

### 扩展面试题

JDK > JRE > JVM

- JDK(Java Development Kit)，是功能齐全的JavaSDK，能够创建和编译Java程序。包含JRE、编译Java源码的编译器javac、文档注释工具javadoc、调试器jdb、可视化监控工具jconsole、反编译器javap
- JRE(Java Runtime Environment)，仅包含 Java 应用程序的运行时环境和必要的类库
- JVM(Java Virtual Machine)，是运行Java字节码的虚拟机，针对不同系统有不同的实现，但是给定相同的字节码可以运行出相同的结果，一次编译随处运行

> JVM并不是只有一种，只要符合JVM规范，每个组织都可以开发自己的JVM



## 数据类型

### 标识符

包、类、变量、方法等的命名就是标识符

定义规则：

- 四个可以：数组、字母、下划线、美元符号

- 两个不可以：不可以以数字开头，不可以使用Java中的关键字
- 见名知意
- 大小写敏感
- 驼峰命名：大驼峰和小驼峰
  - 类名：首字母大写
  - 方法名：首字母小写
  - 包名：不遵循驼峰命名，全部小写

### 关键字

被Java赋予了特殊含义的字符串

### 变量和常量

#### 变量

声明格式，Java是强类型语言，声明变量必须定义类型

```java
type varName [= value, varName [= value]];
```

变量的赋值

- 如果定义了一个变量，而没有给变量赋值，变量相当没有赋值，不会编译进字节码文件
- 如果没有赋值直接使用，会报错

**变量的内存**

- 基础类型变量，变量内存存储的是变量的值
  - 数值型：整数类型，byte，short，int，long；浮点类型，float，double
  - 字符型：char
  - 布尔型：boolean
- 引用类型变量，变量空间存储的是对象所在空间的地址
  - 类
  - 接口
  - 数组

变量作用域

变量起作用的范围，就是离他最近的花括号`{}`。在此范围内都有效，因此内部花括号内也不能重复声明。

局部变量，定义在方法中

成员变量，定义在类中，方法外



##### 整型

进制与范围

- 八进制：`0123`
- 十六进制：`0x123`
- 二进制：`0b101`
- long类型：`123L`。如果数值超出了int的上限，不加L就无法正常赋值给long类型

> 超范围赋值会报错

##### 浮点型

| 类型   | 符号位 | 阶码 | 尾数 | 总位数 |
| ------ | ------ | ---- | ---- | ------ |
| float  | 1      | 8    | 23   | 32     |
| double | 1      | 11   | 52   | 64     |

科学计数法

`double num = 3.14` = `double num = 314E-2`

> 最好不要进行浮点类型的比较，浮点型会丧失精度，甚至存储的数据也是近似相等的

##### 字符型

大小为2B，是按照Unicode码表进行存储的。

> 面试题：`char ch = '2' + 2;`
>
> 输出`ch`结果为：'4'。将'2'对应的数值加2，然后转换为char类型进行存储。

##### 布尔类型

大小为1位，不可以使用0或者非0整数进行赋值。

##### 类型转换

- 自动类型转换：如果转换有损失，就不能通过编译
  - 同一个表达式中有多种类型数据，会进行自动类型转换，自动转换成级别最高的
  - 多种类型数据进行计算，不能有boolean类型参加运算

- 强制类型转换

类型级别：byte, short, char --> int --> long --> float --> double

#### 常量

被final修饰的值被称为**符号常量**。一旦初始化之后，不能更改其值。

如1，2，'a', "abc"等被称为**字面常量**。

字面常量的类型：

- 整型常量 `1`
- 实型常量`1.11`
- 字符常量`'a'`
- 逻辑常量`true`
- 字符串常量`"abc"`

##### 符号常量

字符常量的命名需要全部大写，并用下划线分隔

**扫描器**

```java
Scanner sc = new Scanner(System.in);
sc.nextInt();
sc.nextLine();
```



## 运算符

Java支持如下运算符

- 算术运算符：`+, -, *, /, %, ++, --`
- 赋值运算符：`=`
- 扩展赋值运算符：`+=, -=, *=, /=`
- 关系运算符：`>, <, >=, <=, ==, !=`
- 逻辑运算符：`&&, ||, !, &, |, ^`
  - `&, |`需要把两个操作数都判断完才能确定结果
  - `&&, ||`效率高一些，第一个表达式false或第一个表达式为true就直接返回结果
  - `^`逻辑异或，两个boolean值进行异或
- 位运算符：`&, |, ^, ~, >>, <<, >>>`
  - `>>>`无符号右移
- 条件运算符：`?`，又称三元运算符

优先级：赋值<三目<逻辑<关系<算术<单目



## 流程控制

### 分支结构

#### if else if

#### switch case

```java
switch (value) {
    case 1: sout(1);break;
    case 2: sout(2);break;
    case 3 -> sout(3);
    default: sout("none");break;
}
```

### 循环结构

#### while

#### do while

#### for



## 方法

方法就是一段用来完成特定功能的代码片段

作用是提高代码的复用性

> 面试题：两个数交换是否成功
>
> ```java
> public void swap(int num1, int num2) {
>     int t = num1;
>     num1 = num2;
>     num2 = t;
> }
> public static void main(Stringp[] args) {
>     int a = 10, b = 20;
>     swap(a, b);
> }
> ```
>
> 两个数没有交换成功，因为**Java只能传值**，无论是基本数据类型还是引用数据类型的变量，传入方法时，方法内都会创建一个新的空间，将原变量的值复制一份。
>
> 因此，本例中只是将swap方法中的两个空间的值进行了交换

### 方法的重载

方法的重载是指一个类中可以定义多个方法名相同的，但是参数列表不同的方法。调用时会根据参数自动匹配对应算法。

> 重载本质上是不同的方法，只不过是方法名相同

构成方法重载的条件

- 形参类型不同，形参个数不同，形参顺序不同
  - `void func(int a, double b)`与`void func(doube a, int b)`构成重载
- 只有返回值类型不同无法构成重载
- 只有形参名称不同无法构成重载
- 与修饰符无关



## 数组

### 声明

`int[] arr;`  `int arr[];`

如果数组只声明，没有后续操作，相当于没有创建(不会被编译)。但是赋值为null，还是会在栈空间中开辟空间

### 创建

`int[] arr = new int[10];`

此时，数组才被分配空间，编译器会把声明和赋值合为一句话

使用`new`关键字，会在当前方法的堆空间开辟一块空间，又因为是数组，所以是连续空间，然后将起始地址存储在`arr`标记的栈空间中(即将堆内存地址存储在`arr`变量中)

数组有默认初始值：

- byte[]：0
- short[]：0
- int[]：0
- long[]：0
- float[]：0.0
- double[]：0.0
- char[]：'u\0000'
- boolean[]：false
- 引用数据类型数组：null

### 赋值

如果超出数组长度会出现异常`ArrayIndexOutOfBoundsException`

### 注意

- 数组长度是确定的，一旦被创建大小无法被改变
- 数组元素必须是相同类型的
- 数组类型可以是任意数据类型
- 数组变量属于引用数据类型(数组名对应的变量)，数组也是对象。数组中每个元素相当于该对象的成员变量，因此数组本身是存储在堆中的

### 初始化的方法

- 静态初始化：数组分配空间和赋值同步进行。`int[] arr = {1, 2, 3, 4};`或`int[] arr = new int[]{1, 2, 3};`
  - 注意，第二种写法不能在new后面指定数组长度
- 动态初始化：先声明，后赋值
- 默认初始化：直接new一个出来

### 详解main方法

程序的入口，同一个类中如果有多个成员方法，JVM会自动识别main方法，作为程序的入口。

格式是固定的。程序中可以有多个main方法，但是形参不能相同。

**实参**

- JVM默认情况下传入的是`new String[0]`
- 可以在执行字节码文件时，手动传入参数`java HelloWorld aa bb cc dd`

### 可变参数

允许方法传入数量不固定的参数，参数量可变，解决了方法的重载问题

e.g.

```java
public void exmple(int a, int b, int...nums) {}
```

方法内部对可变参数的处理与数组是一样的

注意：

- 可变参数与其他参数一同传入方法时，只能放在最后一个
- 建议不要使用可变参数

### Arrays工具类

- `static String toString(type[] arr)`
- `static type binarySearch(type[] arr, type target)`：二分查找。只能对有序数组使用才能得到正确结果。
- `static type[] copyOf(type[] original, int newLength)`：复制数组，将原数组复制到一个长度指定的新数组中。新长度可以原数组长度。
- `static type[] copyOfRange(type[] original, int from, int to)`：将指定范围复制到新数组。**包左不包右**
- `static boolean equals(type[] a, type[] b)`：判断两个数组的值是否相等。判断的不是内存地址，而是数组内的元素的值是否相等。
  - 如果使用`a == b`便只能判断两个数组是否在堆空间的内存地址是否一致
- `static void fill(type[] arr, int fromIndex, int toIndex, type val)`：将数组指定位置填充为指定数字。

### 数组的复制

将原数组中指定位置的几个元素，复制到目标数组的指定位置

```java
static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length);
```

- src：原数组
- srcPos：原数组开始复制的位置
- dest：目标数组
- destPos：目标数组开始写入的位置
- length：需要复制的长度

```java
System.arraycopy(srcArr, 1, destArr, 3, 3);
```

### 二维数组

定义一个二维数组arr\[a][b]，表示栈中开辟空间命名为arr，存储堆空间的一个数组的内存地址。该数组的每一个元素都存储一个数组的堆空间内存地址。

可以使用arr[a]来访问其中一个一维数组。

- arr.length，表示的是一维数组的个数，即arr所存储的数组长度

```java
for (int i = 0; i < arr.length; i++) {
	for (int num : arr[i]) {
        sout(num);
    }
}
for (int[] a : arr) {
    for (int num : a) {
        sout(num);
    }
}
```

#### 二维数组初始化方式

- 静态初始化：声明和赋值同时进行
  - `int[][] arr = {{1,2}, {1, 2, 3}}`
  - `int[][] arr = new int[][]{{1, 2}, {1, 2, 3}}`
- 动态初始化：声明与赋值分开进行
- 默认初始化：直接按照元素类型进行默认初始化











# JavaSE中阶

## 面向对象

### 类和对象

类是对事物的定义，对象是类的实例化。如：人类和一个具体的人之间的关系。

类是抽象的，对象是具体的。

### 面向对象三个阶段

- 面向对象分析OOA：Object Oriented Analysis
- 面向对象设计OOD：Object Oriented Design
- 面向对象编程OOP：Object Oriented Programming

### 创建类

新建类，书写类的代码

### 创建对象

第一次使用`new`关键字创建对象是，会使用`ClassLoader`类提供的`loadClass()`方法来加载类文件创建对象。再次创建类时，就不会再加载类文件了。

**类文件只会被加载一次**

### 局部变量和成员变量

- 代码中位置不同：成员变量在类中方法外，局部变量在方法中或代码块中
- 作用范围不同：成员变量可以在类中的所有方法中访问，局部变量只能在当前方法或代码块中使用
- 是否有默认值：成员变量有默认值，局部变量没有(不赋值直接使用会报错)
- 是否要初始化：成员变量不需要初始化，局部变量需要初始化
- **内存中位置不同**：成员变量在堆内存中，局部变量在栈内存中
  - 成员方法在类被实例化的时候，在堆中开辟内存
  - 局部变量随方法的调用而出现在栈中
- 生命周期不同：成员变量随对象的创建和销毁而存在和消失，局部变量与方法生命周期一致

### 构造器

 使用new关键字创建对象，是通过调用构造器来初始化对象的。如果没有写构造器，系统会默认分配一个构造方法。

调用构造器之前，对象就已经创建好了，成员属性也已经有初始化的值了，调用构造器只是对属性进行赋值

```java
public class Person {
    private int age;
    private String name;
    public Person() {}
    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    } 
}
```

当形参名字和属性名重复时，会根据就近原则，给最近的属性赋值。因此需要使用`this`指定给成员变量赋值

**构造器的重载**

空参构造和全参构造

> 如果构造器已经重载，此时没有写空参构造，系统也不会分配，因此空参创建对象会报错



### 内存分析(简单)

```java
public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public static void main(String[] args) {
        Person person = new Person("bob", 20);
    }
}
```

上述代码执行过程的内存分析

- 首先在*栈*中加载`main`方法的栈帧
- 然后因为是第一次创建Person对象，所以通过`ClassLoader`类将`Person.class`字节码文件加载到*方法区*
- 使用`new`关键字，根据`Person.class`提供的模板，在堆中创建Person对象，然后给成员属性进行默认赋值。并在对象所在空间内使用一个指针记录`Person.class`在方法区的内存地址。将对象地址返回
- 然后调用了`Person(String name, int age)`构造方法，于是在栈中加载`Person()`方法的栈帧
- 然后在栈帧中，依次入栈传入参数的副本。因为`name`属性为String类型，因此第一次遇到`"bob"`字符串，会在方法区中的*常量池*中寻找是否存在，不存在于是创建一个`"bob"`字符串，并将地址返回给Person的形参
- 然后使用栈帧中的局部变量，给`this`所指空间内的成员变量赋值
- `Person()`退栈，局部变量消失。但是`"bob"`有对象在使用，所以保留
- 在main的栈帧中创建局部变量`person`记录堆中对象的地址

### 内存分析(复杂)

```java
public class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setAge(int age) {this.age = age;}
}
pubilc class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int age = 40;
        Person tom = new Person("tom", 10);
        Person jack = new Person("jack", 20);
        test.changeAge(age);
        test.changeTom(tom);
        test.changeJack(jack);
        sout("id:"+jack.id+",age:"+jack.age);
    }
    public void changeAge(int age) {
        age = 3366;
    }
    public void changeTom(Person tom) {
        tom = new Person("bob", 2);
    }
    public void changeJack(Person jack) {
        jack.setAge(66);
    }
}
```

上述代码的内存分析：

- 在栈中加载`main()`的栈帧
- 第一次遇到`Test`于是将`Test.class`字节码文件加载到*方法区*
- 使用`new`关键字，根据其提供的模板在*堆*中创建对象，没有成员变量，直接将字节码文件的内存地址记录在对象空间中。然后将对象地址返回
- 调用了`Test()`构造方法，在栈中加载Test栈帧，又其内部没有操作，直接退栈
- 在main栈帧中创建`test`变量接收了堆中对象的地址
- 然后在main的栈帧中创建`age`局部变量，并赋值
- 第一次遇到`Person`于是将`Person.class`字节码文件加载到方法区
- 使用`new`关键字，根据字节码文件提供的模板创建对象，并对成员变量进行默认赋值，然后将字节码文件的内存地址存储到对象空间中
- 调用了`Person()`全参构造方法，在栈中创建Person栈帧，在栈帧中使用局部变量记录形参，分别入栈。由于`"tom"`字符串是第一次出现，字符串常量区找不到，所以在其中创建一个`"tom"`对象，并将地址返回给局部变量
- 通过`this`获取当前调用对象的地址，分别使用局部变量的值给成员变量赋值。Person退栈
- 在main的栈帧中创建`tom`接收对象的地址
- 直接根据字节码文件创建Person对象，并对成员变量进行默认赋值，然后将字节码文件的内存地址存储到对象空间中
- 调用了`Person()`全参构造方法，在栈中创建Person栈帧，在栈帧中使用局部变量记录形参，分别入栈。由于`"jack"`字符串是第一次出现，字符串常量区找不到，所以在其中创建一个`"jack"`对象，并将地址返回给局部变量
- 通过`this`获取当前调用对象的地址，分别使用局部变量的值给成员变量赋值。Person退栈
- 在main的栈帧中创建`jack`接收对象的地址
- 通过`test`对象的指针找到`Test.class`提供的模板，找到`changeAge()`方法，并在栈中创建栈帧
- 在chageAge栈帧中开辟空间接收传入的`age`的值(值传递)，并将开空间的值修改为`3366`，退栈
- 创建`changeTom`栈帧，并在栈帧中开辟空间使用局部变量存储`tom`对象的地址(即将main中tom的存储内容赋值给栈中的局部变量)
- 创建新的`Person`对象，过程不再赘述，并将对象的对内存地址返回给局部变量`tom`，退栈。新对象和`"bob"`等待被回收，因为已经没有引用指向这两个对象
- 创建`changeJack`栈帧，并使用局部变量接收`jack`对象，通过jack指向的堆内存空间，找到`Person.class`的地址，然后找到`setAge()`方法
- 创建`setAge`栈帧，并创建局部变量接收形参`66`，通过`this`指针找到当前调用对象，并赋值。退栈
- changeJack退栈
- 创建`println`栈帧，并传入字符串，进行打印输出

### this

记录调用当前方法的对象的地址

作用：

- 可以用来修饰属性。`this.age`相当于`person.age`，可以避免引起歧义，直接使用当前调用对象的成员属性
- 可以用来修饰方法，可以在避免调用方法时，出现同名方法
- 可以修饰构造方法，同一个类的构造方法之间可以相互调用，但是使用`this`调用构造方法必须放在第一

### static

#### static修饰属性

static修饰的成员属性是静态属性，为类所有，即所有对象所共有

静态属性存储在方法区中的*静态域*中，在类加载的时候，会将类的静态内容加载到静态域中。因此先于对象存在。静态内容是所有类的对象共享的

可以通过`ClassName.fieldName`来直接访问，也可以通过`对象名.属性名`来访问

应用场景：

某些特定的数据想要在内存中共享，可以将该该属性变为静态属性



#### static修饰方法

注意：

- 静态方法中不能访问非静态属性
  - 因为静态内容随着类的加载而加载，先于对象而存在，而非静态属性随着对象的创建才存在。在非静态属性存在之前已经可以使用静态方法，所以不能访问
- 静态方法中，不能访问非静态方法
  - 理由同上
- 静态方法中，不能使用`this`关键字
  - 因为静态内容可以使用`类名.方法名`来调用，此时并没有对象调用该方法

### 代码块

分类：

- 普通块：限制了局部变量的作用范围
- 构造块：在方法外的代码块。解决了在方法外写代码的问题
- 静态块：只能访问静态属性和静态方法。
  - 静态块是随着类的加载而加载的，会最先被执行，且只被执行一次
  - 一般用于执行一些全局性的初始化操作，如数据库的初始化，创建工厂等

执行顺序：静态块->构造块->构造器->普通块

### 包

作用：

- 为了解决重名问题。包实际上就是目录
- 解决权限问题

创建包

- 包名全部小写
- 中间使用`.`分隔，分隔后就是不同级别的文件夹
- 一般都是公司域名的反写
- 不能使用系统的关键字
- 包声明的位置，非注释代码的第一行`pakage com.moroboshidan.pojo.entity`

导包

为了定位代码中所使用的类

同一个包中的类互相使用不需要导包

### 三大特性

#### 封装

程序设计追求“高内聚，低耦合”

- 高内聚：类的内部数据操作细节，由类自己完成，不允许外界干涉
- 低耦合：仅对外暴露少量的方法用于使用

> 隐藏对象内部属性，只对外公开简单的接口，便于外界调用。从而提高系统的可维护性和可扩展性

封装的好处：提高代码的安全性

#### 继承

继承关系：

父类/基类/超类，子类/派生类。子类和父类在一定合理范围内进行继承

继承的优点：

- 提高了代码的复用性，父类定义的内容，子类可以直接继承得来，不需要重复定义
- 便于代码的扩展
- 是多态的前提

注意：

- 父类的`private`内容，子类也继承过来了
- 一个父类可以有多个子类，但是一个类只能继承一个父类。但是可以间接继承
- 继承具有传递性，所有的类都直接或间接地继承`Object`类

##### 内存分析

```java
public class Student extends Person {}
{
  Student stu = new Student();
  stu.setName("bob");
  stu.setAge(10);
}
```

上述代码的内存分析

- 第一次遇到`Student`类，通过`ClassLoader`将`Student.class`和其父类`Person.class`的字节码文件加载到方法区
- 然后根据模板在堆内存中创建Student对象，并对成员变量进行默认赋值，并将地址返回
- main的栈帧中创建变量`stu`来接收对象的地址
- 通过`stu`找到堆中的对象，然后根据其记录的地址找到字节码文件，调用成员方法

父类中所有的属性和方法都会被继承，方法也不例外。但是私有成员不能直接访问

#### 权限修饰符

权限修饰符的作用范围

| 修饰符    | 同一个类 | 同一个包 | 子类    | 所有类  |
| --------- | -------- | -------- | ------- | ------- |
| private   | &#10004  |          |         |         |
| default   | &#10004  | &#10004  |         |         |
| protected | &#10004  | &#10004  | &#10004 |         |
| public    | &#10004  | &#10004  | &#10004 | &#10004 |

#### 方法的重写

发生在子类和父类中，子类对父类中的方法进行重新实现

要求：

- 方法名必须一致
- 参数列表必须一致

重载和重写的区别：

- 重载(Overload)发生在同一个类中，方法名相同，参数列表不同
- 重写(Override)发生在子类和父类中，方法名相同，参数列表必须相同。父类中的返回值类型必须大于子类中的返回值类型。父类的权限修饰符必须低于子类的

#### Super

可以使用`super`关键字来调用父类中可以直接访问的内容

子类和父类成员重名时，想直接调用父类成员，必须要使用`super`关键字

#### super修饰构造器

子类的所有构造方法中，都会默认使用`super()`来调用父类构造方法，即使不写也会自动生成。但是构造器中显式地调用了父类构造方法，就不会自动生成

可以在带参构造器中调用父类的带参构造器，但只能放在第一行，而且不能再使用`this`使用其他构造方法

#### 继承条件下构造方法执行过程

- 加载字节码文件，创建对象，成员默认赋值
- 执行构造方法，调用父类构造方法，直到调用到`Object`类的构造器，返回，结束



#### Object类

##### toString()

`System.out.print(person)`，会被补全为`System.out.print(person.toString())`

`Object`类中的`toString()`方法默认返回包名+`HashCode`组成的字符串

```java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hasCode());
}
```

`getClass()`方法获取当前类的字节码文件，`hasCode()`将对象的堆内存地址计算哈希码，`toHexString()`将传入内容转换为十六进制数字符串

因为可读性较差，所以一般需要在类中重写`toString()`方法

##### equals()

对于引用数据类型使用`==`来进行比较，只会比较两个对象的地址是否相同

如果想比较对象具体内容是否相同，就需要使用Object类提供的`equals()`方法。但是其底层仍然使用的是`==`，因此子类需要重写`equals()`重写

逻辑：

- 先判断传入对象是否属于同一个类。`a instancof b`
- 然后将传入对象强转为当前类对象。因为传入的是`Object`类型的对象
- 再判断是否属性相同

#### 类和类之间的关系

- 实现关系
- 继承关系
- 依赖关系
  - 一个类可以作为另一个类方法的形参
- 关联关系
  - 一个类可以作为另一个类的成员类
- 组合关系
- 聚合关系



#### 多态

多态跟属性无关，多态指的是方法的多态

指的是一个方法调用，由于传入对象不同，实际执行的效果不同

可以提高代码的扩展性

开闭原则：扩展是开放的，修改是关闭的

多态三要素：

- 继承
- 重写。子类要对父类方法进行重写，这样实际执行时可以执行子类的方法
- 父类引用指向子类对象

常见场景：方法的形参为父类对象，然后调用时使用父类引用指向子类对象的变量传入

##### 多态的内存分析

```java
Pig pig = new Pig();
Animal animal = pig;
animal.shout();
```

上述代码的内存分析

- 加载字节码文件，创建对象，返回地址，使用`pig`接收引用
- 将`animal`指向内存中的Pig对象
- `animal`调用`shout()`方法，会根据`animal`所指的对象查找`shout()`方法，由于已经重写，所以直接调用子类中的方法

##### 向上转型和向下转型

如果使用`Animal animal = new Pig()`来使用父类引用指向了子类对象，如果使用父类引用`animal.age`访问子类的额外成员，就会报错，无法访问

两种解释：

- animal在编译阶段是`Animal`类型，而父类`Animal`中没有子类中扩展的成员，所以无法使用
- animal引用只能看到对象内存空间中，属于`Animal`的那部分

想要使用子类扩展内容，就需要*向下转型*`(Pig) animal.age`。

> `equals()`方法中，先将传入对象进行向下转型，然后再判断属性是否相等，就是因为这个原因。
>
> 不转型无法访问到当前对象的扩展内容，只能访问`Object`定义的部分

##### 简单工厂设计模式

```java
public class PetFactory {
    public static Animal getAnimal(String petName) {
        Animal animal = null;
        if ("cat".equals(petName)) {animal = new Cat();}
        if ("dog".equals(petName)) {animal = new Dog();}
        if ("pig".equals(petName)) {animal = new Pig();}
        return animal;
    }
}
{
    Animal animal = PetFactory.getAnimal("cat");
}
```

多态不仅可以使用父类对象做形参，还可以使用父类对象做方法返回值，可以返回任意子类类型的对象。

*工厂设计模式*：

- 定义一个`static`方法，可以通过类名直接调用
- 返回值类型是*父类类型*，返回的可以是任意子类类型
- 掺入一个字符串类型的参数，工厂根据参数创建对应的子类产品



#### final修饰符

final修饰变量

- final修饰基本数据类型变量，变量不可再次赋值
- final修饰引用数据类型变量，对象地址值不能改变，但是对象内部属性可以改变
- 方法的形参没有被修饰`public void func(Person person)`，而将常量传入，在方法中可以修改传入形参，因为没有对常量本身做修改
- 方法形参被final修饰`public void func(final Person person)`，那么在方法内部也不能修改该变量的指向

final修饰方法

- final修饰的方法，子类不能重写

final修饰类

- 该类不能被继承。一旦类被final修饰，里面的方法也没有必要用final修饰

> 如果构造器使用`private`修饰，那么该类不能被实例化，通常为工具类，如`java.lang.Math`



#### 抽象类

方法被`abstract`修饰并去掉方法体，该方法为抽象方法

如果一个类中有抽象方法，该类也要被`abstract`修饰，成为抽象类

- 一个抽象类中可以有0-N个抽象方法
  - 抽象类的子类要么成为抽象类，要么重写父类中的抽象方法
- 抽象类不能被实例化

抽象类的目的是为子类提供通用的模板

> 面试题
>
> 1. 抽象类不能实例化，那么是否有构造器？
>
>    答：抽象其中一定有构造器。因为，子类初始化对象时需要使用`super()`来调用父类构造器
>
> 2. 抽象类能否被`final`修饰？
>
>    答：不能，因为抽象类设计的初衷就是给子类继承用的，如果被final修饰，就不能被继承



### 接口

- 接口是接口，类是类，他们是同一个层次的概念
- 接口没有构造器
- 使用`interface`声明
- JDK1.8之后，接口中的内容如下：
  - 常量：固定修饰符`public static final`
  - 抽象方法：固定修饰符`public abstract`
  - 被`public default`修饰的非抽象方法。方法的默认实现，子类不重写也可以直接使用
    - `default`关键字必须加上，否则会报错
    - 实现类重写该方法不能加上该关键字
    - 实现类中使用该方法可以使用`Interface.super.methodName()`来调用
  - 静态方法
    - 静态方法不能重写
- 一个类实现了一个接口，那么实现类需要重写所有抽象方法。同时获得了接口中的常量
- 继承技能单继承，但实现可以多实现
- 接口不能创建对象，但是可以用接口的引用指向子类实现对象

接口的作用是定义规则，定义方法的模板，而实现类负责具体实现

多态的应用：

- 接口当作方法的形参，传入具体的实现类对象
- 接口当作方法的返回值，返回的是具体的实现类对象

> 为什么要在接口中加入非抽象方法？
>
> 因为如果接口中只能定义抽象方法的话，那么我们要修改接口中的内容，那么实现类的影响太大，所有实现类都会受到影响。在接口中加入非抽象方法，对实现类没有影响，有需求就可以使用，否则无需重写



### 内部类

成员内部类

- 定义在类中，方法外的类。包含静态和非静态

- 非静态内部类可以访问外部类的属性和方法。静态内部类只能放为外部类中的静态内容

- 外部类想要访问内部类的东西需要创建内部类的对象
- 定义内部类
  - 静态内部类：`TestOuter.Inner inner = new TestOuter.Inner();`
  - 非静态内部类：`TestOuter outer = new TestOuter(); TestOuter.Inner inner = new outer.Inner();`

局部内部类

定义在方法(代码块，构造器)中的类

- 局部内部类中只能访问到外部类中的常量，`final`修饰
- 如果内部类在整个项目中只使用一次，就没有必要新建一个类文件，使用内部类即可
- 匿名内部类



## 异常

Exception，程序运行过程中，发生了程序无法处理的问题，阻碍了程序进行，称为异常

可以通过报错时异常的类名来判断是何种异常，以及异常出现的位置来排查

解决方法：

- if - else ：对可能出问题的代码进行判断，然后处理
  - 代码臃肿，业务代码和处理异常的代码混在一起
  - 可读性差
  - 程序员需要花费大量精力来维护
  - 人力很难考虑到所有的情况
- try - catch - finally

### try catch 捕获异常

将可能出现异常的代码放入`try{}`中，然后使用`catch(Exception e) {}`来捕获，并在其中处理异常

执行情况分析：

- `try`中没有异常，`catch`中的代码不会被执行
- `try`中有异常，`catch`进行捕获
  - 如果`catch`中的形参异常类型和程序抛出的异常匹配的话，执行`catch`中的代码，进行处理
  - 如果类型不匹配，就没有捕获成功，程序就会中断

### catch 对异常的处理方法

- 不做任何处理。控制台也不会报错
- 自定义提示。`sout("there's an exception");`
- 打印异常信息。`sout(ex.getMessage());` `sout(ex.toString())`
  - `ex.printStackTrace()`将异常的完整信息输出在控制台，看起来和系统报错没有区别，但是程序不会中断
- 抛出异常。`throw new Exception();`
  - 如果上一级没有处理异常的逻辑，程序就会中断

### finally

以下操作会导致 try catch后的代码无法被执行

- 如果`catch`中抛出异常，且上级没有处理异常的逻辑，后续代码就无法执行
- `catch`没有捕获到异常
- 在`try`中使用了return

为了让 try catch后的代码无论如何都能被执行，可以使用`finally`关键字

> 如果在try中使用了return，那么return 和 finally的执行顺序？
>
> 先执行finally然后执行return

一般情况下，会将关闭数据库资源、关闭流、关闭IO资源的代码放入`finally`

只有一种情况会让`finally`中的代码无法执行，就是在`try`中使用`System.exit(0);`

- 该语句是终止当前虚拟机的运行

### 多重catch

可以在try catch中使用多个catch捕获多种类型的异常

出现异常时，会依次将异常类型与catch后的形参进行比对，比对成功便进入该处理逻辑

> 虽然catch是没有先后之分的，但是如果将一般化的异常(Exception等覆盖面比较广的)放在了前面，会导致后续的被包含的异常处理逻辑永远无法执行，进而报错
>
> 因此，先写子类异常，再写父类异常

JDK1.7之后，异常的新处理方式：在catch中使用`|`来并列放入多个类新的异常，`catch(RuntimeException|NullPointerException ex)`

### 异常的分类

- Object
  - Throwable
    - Error：错误，JVM系统内部错误，内存溢出等程序本身无法解决的错误
    - Exception：异常
      - CheckException：检查时异常，程序还未运行就提醒该代码可能会出现异常，需要进行防患于未然的处理
      - RuntimeException

> 程序中，语法错误，逻辑错误都不属于Throwable

检查时异常的处理方式：

- try catch中再包裹一个try catch
- 多重catch
- 外抛异常，给方法添加`throws`关键字抛出异常

### throws

throw关键字可以用于抛出异常，`throw new RuntimeException();`

但是如果抛出的异常不进行处理(try catch)，就需要给方法添加`throws RuntimeException`

表明该方法会出现异常，且不会主动处理，需要调用者处理

throw和throws区别

- 位置不同，throw在方法内，throws在方法声明处
- 内容不同，throw后面跟的是异常对象，throws后面跟的是异常类型，可以有多个类型
- 作用不同，throw制造异常，throws是告诉方法的调用者该方法可能会出现异常，调用者可以处理，或者继续抛出

### 异常的重载和重写

重载：异常不影响方法的重载，即抛出的异常不同，并不构成重载

重写：子类重写父类方法时，抛出的异常必须小于等于父类抛出的异常类型

### 自定义异常

- 命名，不能与系统预定的异常重复
- 需要继承某一个异常
  - 如果继承的是运行时异常，在使用时无需额外处理
  - 如果进程的是检查异常，使用时就是需要使用try catch处理或使用throws向上抛



## 常用类

### 包装类

对基本数据类型的封装，使其变为引用数据类型

对应关系

| 基本数据类型 | 包装类    | 继承关系           |
| ------------ | --------- | ------------------ |
| byte         | Byte      | -->Number-->Object |
| short        | Short     | -->Number-->Object |
| int          | Integer   | -->Number-->Object |
| long         | Long      | -->Number-->Object |
| float        | Float     | -->Number-->Object |
| double       | Double    | -->Number-->Object |
| char         | Character | -->Object          |
| boolean      | Boolean   | -->Object          |

作用：

- Java语言是面向对象的语言，万物皆对象。封装为引用数据类型，方便进行操作
- 集合只能填入引用数据类型的数据

#### Integer常用属性，常用构造器

包装类是`java.lang`包下的，可以直接使用，无需导包

- 已实现的接口：`Serializable`和`Comparable<Integer>`

- 属性：`Integer.MAX_VALUE` `Integer.MIN_VALUE` `public final int value`

- 构造器：`public Integer(int value)` 和 `public Integer(String s)`
  - 传入`int value`：将传入的值赋给常量属性`value`
  - 传入`String s`：调用`parseInt(String s)`来将字符串中的符号转为整型，然后赋给常量属性`value`
- 自动装箱：自动将基本数据类型转换为对应包装类，自动调用`valueOf`方法
- 自动拆箱：自动将包装类转换为对应基本数据类型，自动调用`intValue`方法

常用方法：

- `public int compareTo(Integer anotherInteger)`：比较大小，返回`-1 0 1`
  - 重写了`Comparable`中的`compareTo`方法
- `public boolean equals(Object obj)`：先判断是否是`Integer`的对象，然后强转再比较
  - 重写了`Object`中的`equals`
  - Integer为了优化，防止多次创建对象，所以使用静态内部类`IntegerCache`，其中有一个静态代码块，Integer类被加载时，会创建一个长度为`256`的`IntegerCache.cache[]`数组，存储值为`-128 - 127`的256个对象。
    - 当执行自动装箱时，如果传入值落在这个区间，就将对应的对象直接返回
    - 如果超出范围，就新建对象返回
    - 所以*自动装箱，如果数值一致且落在了`cache`的范围内，就会获取同样的对象*，即多个变量指向同一个地址
  - 如果自动装箱的值在`-128 ~ 128`之间，使用`==`就能判断是否相等，因为数值相同地址也相同
- `public int intValue()`：将封装的值返回
- `public int parseInt(String s)`：将字符串中的数字转换为整型



### 日期相关类

#### java.util.Date

- getYear()：1900年至今的年数
- getMonth()：返回值在0~11之间，需要加1
- getTime()：自1970年1月1日00:00至今的毫秒数
  - 通常使用`System.currentTImeMillis();`来获取，这是一个`static native`方法，不需要对象也可以使用，同时不是通过Java实现的

#### java.sql.Date

没有空参构造器，属性只有年月日

java.sql.Date继承自java.util.Date

二者可以转换

- 向下转型：`java.util.Date date = new java.sql.Date();` `java.sql.Date sqlDate = (java.sql.Date) date;`

  - > 父类向下转型，能成功的前提是，创建的对象本身就是子类对象，否则无法成功。因为，可能不只有一个类继承了该父类，如果创建的是父类对象，就不知道具体对应哪个子类

- 利用构造器：`java.sql.Date sqlDate = new Date(date.getTime());`

#### SimpleDateFormat

继承自`DateFormat`抽象类

可以将时间按照标准格式展示`SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")`

#### Calendar

是一个抽象类，常用子类`Calendar cal = new GeogorianCalendar();`

常用方法：

- `cal.get(Calendar.YEAR);`, `cal.get(Calendar.MONTH);`等，获取日期
- `cal.getActualMaximun(Calendar.DATE)`，获取当月日期的最大天数
- `cal.set(Calendar.YEAR, 1900)`，`cal.set(Calendar.MONTH, 3)`，修改日期

#### LocalDate, LocalTime, LocalDateTime

实例化：

`LocalDate localDate = LocalDate.now();` `LocalDate localDate = LocalDate.of(2010, 5, 6);`年月日

`LocalTime localTime = LocalTime.now();` `LocalTime localTime = LocalTime.of(12, 35, 56);`时分秒

`LocalDateTime localDateTime = LocalDateTime.now();` `LocalDateTime localDateTime = LocalDateTime.of(1999, 9, 19, 12, 56, 49);`年月日时分秒

##### LocalDateTime

常用方法：

- `localDateTime.getYear()` `localDateTime.getMonth()`等直接获取单个属性，且没有任何偏移
- 对LocalDateTime对象进行修改，该对象不会被更改，而是返回一个修改后的新的对象
  - 具有不可变性

#### DateTimeFormatter

提供格式化的时间

- 预定义的标准格式：`ISO_LOCAL_DATE_TIMME;ISO_LOCAL_DATE;ISO_LOCAL_TIME`
- 本地化相关的格式，如：`ofLocalizedDtaTime()`，参数有`FormatStyle.LONG`, `FormatStyle.MEDIUM`, `FormatStyle.SHORT`
- *自定义的格式*：`ofPattern("yyyy-MM-dd hh:mm:ss")`

```java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
LocalDateTime now = LocalDateTime.now();
String format = formatter.format(now); // 将时间按照formatter中固定的格式转换为字符串
sout(format);
```



### Math

final修饰，构造器private修饰，不能被继承，不能创建对象。

所有的成员都是用static修饰，直接使用类名调用

常用成员：

- `Math.random()`：获取[0.0, 1.0)的随机数
- `Math.abs()`
- `Math.ceil()`：向上取整，`Math.floor()`：向下取整，`Math.round()`：四舍五入
- `Math.max(a, b)`，取大值，`Math.min(a, b)`：取小值



### Random

构造器：`Random(long seed)`，根据传入的seed从随机数表中查询一个随机数，seed一致随机数就一致

所以，通常传入系统当前时间`Random random = new Random(Syste.currentTimeMillis());`使随机数不重复

空参构造`Random random = new Random();`，表面是是空参构造，实际上还是带参构造器

- `random.nextInt(int n)`，生成一个[0, 10)的均匀分布的随机数
- `random.nextDouble()`生成一个[0.0, 1.0)的随机数
  - `Math.random()`底层调用的还是这方法



## String



### String & StringBuilder & StringBuffer

#### 可变性

- `String`不可变
- `StringBuffer`和`StringBuilder`均继承自`AbstractStringBuilder`内部也采用字符数组来保存字符串，但是该数组没有使用`final`和`private`修饰，并且还提供如`append()`的修改方法

```java
abstract class AbstractStringBuilder() implements Appendable, CharSequence {
    char[] value;
    public AbstractStringBuilder append(String str) {
        if (str == null) 
            return appendNull();
        int len = str.length();
        ensureCapacityInternal(count+len);
        str.getChars(0, len, value, count);
        count+=len;
        return this;
    }
}
```

#### 线程安全性

- `String`是不可变的，可以理解为常量，因此线程安全
- `StringBuilder`和`StringBuffer`虽然是同一个公共父类，但是`StingBuffer`增加了同步锁，所以是线程安全的

#### 性能

- 每次对`String`对象进行更改时，都会产生一个新的`String`对象，性能不强。适合操作少量字符串
- `StringBuffer`每次都会对原来的对象本身进行操作。适合多线程操作大量字符串
- `StringBuilder`性能比前者提高10%~15%，但是线程不安全。适合单线程操作大量字符串

### 为什么String不可变

- 因为`String`内部用于存储的数组被`private final`修饰，私有成员且不提供访问方法
- `String`类被`final`修饰，导致其不能被继承，因此避免了子类对其不可变的破坏

```java
public final class String implements java.io.Serializable, Comparable<String>, CharSequence {
    private final byte[] value;
	//...
}
```

### 字符串拼接

`+`：两个`String`对象使用`+`进行拼接，编译器会先创建两个`StringBuilder`对象，然后调用`append()`方法。然后调用`toString()`返回一个`String`对象

> 但是编译器不会复用`StringBuilder`对象，而是每次`+`都会新创建一个。因此，建议使用`StringBuilder`进行字符串拼接

### String的equals()和Object的equals()

`String`中的`equals()`是被重写过的，只针对字符串的值是否相等。`Object`中的方法只能判断对象的地址是

#### 创建一个String对象

`String`类型内部用于存储字符串的是一个数组`private final char value[]`，不能访问且无法被更改

创建`String`对象的两种方式：

- `String str = "hello"`：这种方式创建的对象，存在于常量池中。如果在创建对象之前该字符串已经存在，则直接将`str`指向常量池中的该字符串对象；如果不存在则直接在常量池中创建对象。即多个对象引用的是同一个常量池中的对象。
- `String str = new String("hello")`：这种方式创建的对象，其对象本身存在于堆中(凡是`new`出来的对象都存在于堆中)。如果创建对象之前该字符串已经存在，则直接将对象中的`value[]`数组指向常量池中的字符串；如果不存在，则先在常量池中创建一个`"hello"`对象，然后再将堆中对象的`value[]`指向该字符串
- `byte[] arr = {97, 95, 98}; String str = new String(arr);`。字符串本身在常量池中，使用的就是字节数组存储的。因此，直接在堆中创建对象，然后将value指向该数组即可
- `char[] arr = {'a', 'b', 'c'}; String str = new String(arr);`。首先，将arr转换为byte[]数组，存储在常量池中，然后，在堆中创建String对象，将value指向该字节数组

### 常量池的作用

可以避免字符串的重复创建，提升性能节约内存空间

### String.intern()

`String.intern()`是一个native方法，作用是将指定的字符串对象的引用保存在字符串常量池中，可以分为两种情况：

- 如果字符串常量池中已经存在该字符串对象，直接返回该对象的引用
- 如果不存在，就在常量池中创建一个该字符串对象的引用并返回

> 简单来说，就是将常量池中字符串的引用返回

### String变量和常量使用`+`进行拼接

常量折叠，会将常量表达式的值求出来，嵌在最终代码中

```java
String str1 = "hello";
String str2 = "world";
String str3 = "hello" + "world";
String str4 = str1 + str2; // 在堆中创建对象 
```

对于`str3`，编译器会直接优化为`String str3="helloworld"`，因为在编译器就已经可以确定表达式中所有部分的值

但是对于引用变量，编译期间不能直接确定其值。所以对于`str4`仍然使用`StringBuilder`来实现

`String str4 = new StringBuilder().append("hello").append("world").toString()`

如果被`final`修饰，即变为常量。`str4`便被常量折叠优化成了`String str4 = "helloworld";`

```java
final String str1 = "hello";
final String str2 = "world";
String str3 = "hello" + "world"; 
String str4 = str1 + str2; // 在常量池中创建对象
```



#### StringBuilder

在`AbstractStringBuilder`中，核心属性如下

```java
byte[] value; int count;// 记录数组有效长度
```

- StringBuilder的空参构造`super(16)`，调用父类构造器，创建了一个长度为16的byte[]数组

- 带参构造`StringBuilder(int capacity)`，为value数组做初始化，长度为传入值

- `StringBuilder(String str)`，开辟空间(有盈余)，然后放入字符串，然后给count赋值

- 如果value数组超出长度，就会重新申请一块新的空间，然后将字符串复制进去



#### 理解可变和不可变字符串

- 不可变字符串。String类型的字符串，改变字符串或给字符串变量重新赋值，是无法在原来的地址上修改的，而是重新开辟空间赋值，然后将引用指向新空间
- 可变字符串。StringBuilder和StringBuffer，修改字符串时，对象的地址是不改变的，改变的只是value属性的引用

#### StringBuilder和StringBuffer常用方法

- `insert(int offset, String str)`，在offset位置插入字符串str
- `setCharAt(int index, char ch)`，将index位置的字符替换为ch
- `replace(int start, int end, String str)`，在[star, end)位置，替换字符串str
- `charAt(int index)`，查询对应位置上的字符
- `String substring(int start, int end)`，获取[start, end)位置上的子字符串

> StringBuffer和StringBuilder内容几乎一样，唯一的不同是`public synchronized StringBuffer append(String str){}`方法，该方法实现了线程同步，是线程安全的
>
> 因为StringBuilder线程不安全，所以性能更高，通常情况下应该优先考虑StringBuilder



## 集合

数组，集合都是对多个数据进行存储和操作的，简称为容器

> 这里的存储是指内存，而不是持久化存

数组的缺点

- 一旦指定了长度，就无法更改
- 增删元素效率低
- 数组中实际存储的元素数量是无法直接获取的
- 数组元素可重复
- 元素必须是同一类型的

集合的结构：

- Collection接口：一个一个地存储数据
  - List接口
    - ArrayList实现类
    - LinkedList实现类
  - Set接口
    - HashSet
    - TreeSet
- Map接口：一对一对地存储数据
  - HashMap实现类
  - TreeMap实现类

![image-20231225210200538](..\img\collection.png)





### Collection接口

#### 常用方法

| boolean add(E e), boolean addAll(Collection<? extends E> c)  | 增加元素，增加集合中的所有元素             |
| ------------------------------------------------------------ | ------------------------------------------ |
| boolean contains(Object obj), boolean containsAll(Collection<?> c) | 是否包含某对象，是否包含该集合中的所有元素 |
| Iterator<E> iterator()                                       | 返回在该集合上迭代的迭代器                 |
| boolean remove(Object obj), boolean removeAll(Collection<?> c) | 移除元素，移除交集元素                     |
| boolean retainAll(Collection<?> c)                           | 保留交集元素，其余全部删除                 |
| Object[] toArray(), <T> T[] toArray(T[] a)                   | 返回包含所有元素的数组；                   |

集合中只能存放引用数据类型，如果传入基本数据类型，会自动装箱

#### 遍历方式

增强for循环

```java
for (Object obj : collection) {sout(obj);}
```

迭代器遍历

```java
Iterator iterator = collection.iterator();
while(iterator.hasNext()) {
    sout(iterator.next());
}
```

> 通过`hasNext()`方法来判断是否有下一个元素，`next()`获取当前元素，并且将指针后移



#### List接口

常用方法

| void add(int index, E e)    | 将元素插入到指定位置           |
| --------------------------- | ------------------------------ |
| E get(int index)            | 获取指定位置元素               |
| E remove(int index)         | 删除指定位置元素，并返回该元素 |
| Object remove(Object obj)   | 删除列表中第一次出现的指定元素 |
| E set(int index, E element) | 将指定位置的元素进行替换       |

##### 遍历方式

普通for

```java
for (int i = 0; i < list.size(); i++) {
    sout(list.get(i));
}
```

增强for

迭代器遍历



##### ArrayList实现类

###### JDK 1.7 源码

继承`AbstractList`抽象类，实现了`List<E>`接口

重要属性：

- `private transient Object[] elementData;`：底层是Object类型的数组，所以可以放入任意类型的数据
- `private int size;`：记录实际元素数量

数组的初始默认大小为10，每次存入数据，size自增，添加成功返回`true`

- 当超出容量时，申请一个新数组，新数组大小为旧数组大小的`1.5`倍
- 然后将旧数组所有内容复制到新数组，再将`elementData`指向新数组

> `ensureCapacity(int minCapacity)`，如果当前容量小于输入值，会进行扩容，如果输入值大于当前容量的1.5倍，扩容至输入值，否则扩容1.5倍



###### JDK 1.8 源码

底层依旧是Object类型数组实现的

通过空参构造时，数组默认状态是空，即没有初始默认大小，直接为空数组

第一次调用`add()`方法时，会创建一个大小为`10`的数组

优点是在没有添加元素时，不占用空间，节省了内存



##### Vector实现类(已被淘汰)

重要属性：

- `protected Object[] elementData;`：Object类型数组
- `protected int size`：实际存储元素个数

与ArrayList区别：

- 数组默认初始长度为10，达到最大长度时，扩容两倍

- `add()`方法被`synchronized`修饰，是线程安全的。因此效率较低



##### LinkedList实现类

链式结构实现的顺序表

因为既是List接口的实现类，又实现了Deque接口。因此，类中既有List中的增删改查方法，还重写了Deque的增删改查相关方法，同一功能有多个近似方法。

常用方法(List接口的方法)：

| indexOf(Object o), lastIndexOf(Object o) | 获取该元素第一次/最后一次出现的位置，不存在返回-1 |
| ---------------------------------------- | ------------------------------------------------- |

常用方法(Deque接口的方法)：

| addFirst(E e), addLast(E e),     | 在队列头部插入，在队列尾部插入              |
| -------------------------------- | ------------------------------------------- |
| offerFirst(E e), offerFirst(E e) | 有boolean返回值，底层就是调用的add方法      |
| add(E e), offer(E e)             | 在链表中，两者是一致的                      |
| pollFirst(), pollLast()          | 将头部元素删除并返回，将尾部元素删除并返回  |
| poll()                           | 将第一个元素删除并返回                      |
| removeFirst(), removeLast()      | 删除头部/尾部元素，队列为空抛出异常         |
| peekFirst(), peekLast()          | 检索第一个/最后一个元素，不删除             |
| peek()                           | 检索第一个元素，不删除                      |
| element()                        | 与上述功能一致，但是链表为空时抛出异常      |
| getFirst(), getLast()            | 检索第一个/最后一个元素，不删除，空表抛异常 |



###### 底层原理

双向链表实现，内部有一个静态内部类Node，提供一个带参构造

```java
private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;
    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }  
}
```

然后需要两个成员属性，分别指向首结点和尾结点

```java
transient Node<E> first;
transient Node<E> last;
```

方法实现：

- 增

```java
public void add(E e) {
    Node<E> node = new Node<>(last, e, null);
    if (first == null) { // 此时链表为空，插入的是第一个元素
        first = node;
    } else {
        last.next = node;
    }
    last = node;
    this.size++;
}
```

- 查

```java
public E get(int index) {
    if (index >= size) return null;
    Node<E> p = first;
    while(index > 0) {
        p = p.next;
        index--;
    }
}
```



##### ListIterator迭代器

```java
ArrayList<Integer> list = new ArrayList<>();
Iterator<Integer> iterator = list.iterator();
while(iterator.hasNext()) {
	if (iterator.next().equals(100L)) {
        list.add(1000L);
    }
}
```

使用迭代器进行循环时，不能插入和删除元素，不然会抛出异常`ConcurrentModificationException`

原因是List对象list和迭代器同时操作了底层的数组

解决办法，引入新的迭代器ListIterator

把读取和写入交给一个对象来进行即可

```java
ArrayList<Integer> list = new ArrayList<>();
ListIterator<Integer> iterator = list.listIterator();
while(iterator.hasNext()) {
	if (iterator.next().equals(100L)) {
        iterator.add(1000L);
    }
}
```

特性：hasPrev();可以反向遍历



#### 面试题：iterator(), Iterator, Iterable关系

 

- Collection接口继承了Iterable接口
  - Iterable接口中定义了一个抽象方法`Iterator<T> iterator();`

- iterator()方法的返回值是Iterator接口的实现类对象
- Iterator是一个接口

对于ArrayList类来说，定义了一个内部类Itr，实现了Iterator接口，是该接口的实现类，对接口中的抽象方法进行了重写

ArrayList重写的iterator()方法返回值为该内部类的对象



#### hasNext() & next()

- hasNext()，判断cursor是否等于实际长度，如果是表示没有下一个元素，返回false
- next()，返回当前元素，并将cursor后移



#### Set接口

元素唯一，且无序(存入顺序和实际存储顺序无关)，没有跟索引相关的方法

遍历方式：

- 迭代器
- 增强for



##### HashSet实现类

特点：

- 元素唯一，不重复：添加重复元素会添加失败
  - 对于引用数据类型，如果没有重写hashCode()方法，对象属性相同但是计算得来的哈希值是不同的，所以可以重复存入
  - 为了让引用数据类型也能避免重复存入(根据属性值判断)，需要重写hasCode()方法
- 元素无序：遍历得出的顺序不是添加的顺序



###### 底层原理

根据数据的值计算哈希值，然后根据哈希值计算该元素在数组中的位置

然后查看数组该位置是否已经被占用(冲突)，如果没有冲突直接存入，如果冲突则采用对应的冲突解决方法

> 因此，对于引用数据类型，需要重写hashCode()方法，通过属性值计算哈希值
>
> ```java
> public int hashCode() {
>     return Objects.hash(age, name);
> }
> ```



###### 为什么需要同时重写hashCode()和equals()

如果只重写equals()方法，那么同一个类的两个对象，如果成员属性一致，则equals()方法会认为他们是同一个对象，即使地址值不同。

而如果将这两个对象存入Set集合中，他们却可以同时存入，违背了Set的不重复原则。这是因为没有重写hashCode()方法， 导致两个对象计算得来的哈希值不同。因此需要同时重写两个方法



###### LinkedHashSet

继承HashSet，在哈希表之外，额外支持了一个链表，使得其能够按照存入顺序输出。

###### HastSet底层原理

HashSet底层时通过HashMap实现的，创建HashSet对象时，构造器会创建HashMap对象

因为HashSet的元素是一个一个地存在的，且不允许重复，所以在底层就将存入的元素作为key值，value值为默认占位值



##### 比较器

- 内部比较器

e.g.

String类实现了Comparable<E>接口，接口中有一个compareTo()方法。可以按照字母的顺序来比较字符串的大小

如果需要能够比较自定义数据类型的大小，就需要实现Comparable<E>接口，重写compareTo()方法。在方法中实现自己的比较逻辑

- 外部比较器

e.g.

定义一个外部类，实现`Comparator<T>`接口，重写`compare()`方法，即可实现比较

```java
public class Student {
    private int age;
    private String name;
}
class StuComparetor implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) { return 0;}
}
public static void main(String[] args) {
    Comparator<Student> comp = new StuComparetor();
}
```

两种比较器中，外部比较器比较好，因为可以利用多态，接口引用指向实现类对象



##### TreeSet实现类

- 元素唯一，元素无法重复存入
- 元素按照升序排序

数据的逻辑结构是二叉排序树

因为需要根据升序来构造二叉排序树，所以需要用到比较器

如果不指定，使用的是内部比较器



如果要使用到外部比较器，需要在实例化TreeSet对象时，传入外部比较器。有如下形式

- 定义一个外部比较器类，实现Comparator接口，然后实例化比较其对象
- 使用匿名内部类的形式创建Comparator接口的对象
- 使用匿名内部类的形式，直接创建TreeSet

```java
// 1. 创建一个外部比较器对象，然后传入
Comparator<Student> compare = new StuComparator();
TreeSet<Student> set = new TreeSet<>(compare);
// 2. 通过匿名内部类的形式创建接口对象
Comparator<Student> compare = new Comparator() {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
TreeSet<Student> set = new TreeSet<>(compare);
// 3. 通过匿名内部类的形式创建TreeSet
TreeSet<Student> set = new TreeSet<>(new Comparator<Student>() {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
})
}
```

###### TreeSet底层原理

底层为TreeMap实现的，空参构造时，会创建一个TreeMap<E, Object>，存入的元素作为key

add()方法，调用的TreeMap.put()方法



#### Collections工具类

工具类，构造器私有化，不可创建对象。内部所有方法都为静态方法

常用方法：

- `Collections.addAll(Collection<? super T> c, T... elements)`：给集合中添加多个元素
- `Collections.binarySearch(c, T elements)`：二分查找，集合必须有序
- `Collections.sort(List<T> list)`：升序排序
- `Collections.copy(List dest, List src)`：将源集合复制到目标集合









### Map接口

元素按照键值对`<Key, Value>`的形式存储。因此需要两个泛型`Map<K, V>`

特点：

- 元素唯一，即key是唯一的，如果存入集合时key值重复，会将value覆盖

#### 常用方法

| V put(K key, V value), void putAll(Map<? extends K, ? extends V> m) | 存储键值对，或Map集合                                       |
| ------------------------------------------------------------ | ----------------------------------------------------------- |
| V remove(Object key), void clear()                           | 按照键删除值，清空集合                                      |
| V get(Object key), Set<K> keySet(), Collection<V> values()   | 按照键查值，返回所有的key的集合，返回所有值的Collection集合 |
| Set<Map.Entry<K, V>> entrySet()                              | 返回所有键值对的Set集合                                     |
| boolean contains(K key)                                      | 是否包含该键                                                |

- put(K key, V value)：如果key值不存在，直接存入该键值对，返回null；如果key存在，将value覆盖，返回原value值
- keySet()返回值为Set集合，是因为key是唯一的，不可重复。而valueSet返回值类型为Collection，是因为value是可能重复的
- Set<Map.Entry<K, V>> entrySet()：返回值是一个Set集合，内部每一个元素是Map中的Entry接口的实现类的对象。内部包含getKey() getValue()方法



#### HashMap实现类

特点：无序，唯一。按照key进行维护，底层key遵照哈希表的结构(数组+链表)，因此存入的元素需要重写equals()和hashCode()方法



##### 底层原理

- 哈希表的主数组存储的是*Entry<K, V>*的实现类对象Node<K, V>
  - Node<K, V>中的主要属性为`int hash` `K key` `V value` 以及一个指向下一个结点的指针
- 哈希表的冲突解决是使用拉链法实现的，即数组的每个位置都可以存储一个链表，当发生冲突时，新插入的结点，采用头插法，放到数组里，然后将next指针指向原来的头部即可。
  - 如果两个Node的哈希值一致，要先判断Key是否相同，如果相同需要将新的Value替换原来的Value，此时不会新创建Node对象
  - 如果Key不相同，才采用冲突消解方法，新创建Node对象然后插入链表
  - JDK7冲突消解使用的是头插法，JDK8采用的是尾插法

> 主数组的默认长度为16，最大长度为 `1<<30`，负载因子为0.75f
>
> 当容量超出`threshold`且当前发生了冲突，就会进行数组扩容，容量为原来两倍



##### 经典面试题

- 装填因子为什么是0.75f

>如果装填因子为1，只有元素数等于数组长度是才会扩容，空间利用率高。但是碰撞率会很高，所以链表的长度会较长，查询效率低
>
>如果装填因子为0.5，碰撞概率降低，容易扩容，所以链表长度不会很长，因此查询效率高
>
>因此权衡空间利用率和查询效率，选择了0.75f

- 主数组的容量，为什么一定是2的整数倍

>首先，数组容量的计算过程是循环执行`1 << 1`得来的，因此数量上一定是2的整数倍
>
>其次，在计算元素的数组下标时，计算公式为`h & (length - 1)`，只有当length为2的整数倍时，该公式才能等效为`h % length`
>
>再者，为了防止哈希冲突，因为数组下标计算是按照上式得来的，对length取余能够大大降低冲突概率



##### 对比Hashtable实现类和LinkedHashMap实现类

- HashMap出现晚，效率高，但是线程不安全
  - key值可以为空，但是多个key为空时，会按照key的唯一性，进行覆盖
- Hashtable出现早，效率低，线程安全
  - key值不可以为空，如果为空直接抛出空指针异常
- LinkedHashMap，在HashMap基础上额外维护了一个链表，使得元素能够按照输入顺序排序





#### TreeMap

特点：唯一，有序，按照升序或者降序排序。底层为红黑树 ，因此元素的key需要实现比较器(内部或外部)

外部比较器可以定义比较器类，或者通过匿名内部类的方式在创建集合时，直接传入



##### TreeMap底层原理

节点的成员属性

```java
K key;
V value;
Entry<K,V> left;
Entry<K,V> right;
Entry<K,V> parent;
boolean color = BLACK;
```

默认使用内部比较器，外部比较器需要传入Comparator实现类对象

如果传入的key出现了重复，使用新的value替换原来的value



















### 泛型

e.g.

- 如果在使用ArrayList时，没有指定类型，集合中就可以存入任意类型的数据，但是实际使用过程中基本都是存储相同类型的数据，所以没有类型约束也不是好事。
- 如果使用时指定了类型，加入不同类型数据，编译时就会报错，防止出现类型不一致

#### 自定义泛型结构-泛型类

定义类时，在类名后添加`<E>`，该类就是泛型类。其中`E`是一个占位符，表示类型待定(只能是引用类型)

```java
public class GenericClass<E> {
    E sex;
    public void a(E n) {}
    public void b(E[] m) {}
    public static void main(String[] args) {
		GenericClass gc = new GenericClass();
        gc.a("abc"); gc.a(123); gc.b(new String[]{"a", "b"});
    }
}
```

指定类型：

- 使用时，不指定类型，那么泛型会被认为时Object类型
- 实例化时指定泛型，会用指定类型替换泛型占位符E
- 定义类时指定父类泛型，子类自动确认类型`public class SubClass extends GClass<Integer>`
  - 父类不指定泛型，子类自动变成泛型类`public class SubClass<E> extends GClass<E>`
  - 

细节：

- 可以定义多个泛型

```java
public class Test<A, B, C> {
    A age; B name; C sex;
    public void a(A a, B b, C c) {}
}
```

- 泛型类的构造器不能加泛型。`public Test() {}`即可
- 不同的泛型的引用类型不可以相互赋值

```java
ArrayList<String> list_1 = null;
ArrayList<Integer> list_2 = null;
list_1 = list_2; // 此操作会报错，不能相互赋值
```

- 泛型如果不指定，就会被擦除，占位符默认为Oject类型
- 泛型类中的静态方法不能使用泛型
  - 因为静态方法先于对象的存在而存在
- 不能直接使用泛型创建数组。`A[] arr = new A[10];`会报错



#### 泛型方法

并不是形参中有泛型就是泛型方法，而是方法形参的泛型需要与类的泛型不同才是泛型方法。

泛型方法需要在方法声明时显示地定义泛型`public <T> void method(T t)`。如果显示给出，会认为T是一个类型，但是代码中找不到该类型，会报错。



#### 泛型参数存在继承关系的情况

```java
List<Object> list_1 = new ArrayList<>();
List<String> list_2 = new ArrayList<>();
list_1 = list_2; // 代码不成立，报错
```

在泛型类实例化时，指定不同的类型，即使类型之间存在继承关系，也是不能按照多态的方式赋值

因为泛型的类型之间不存在继承，指定类型后的对象，是并列关系



#### 通配符

在没有引入通配符之前，下面的方法属于重复定义，因为形参都是List的实现类对象

```java
public class Test {
	public void a(List<Object> list) {}
    public void a(Listz<String> list) {}
    public void a(List<Integer> list) {}
}
```

发现：A是B的父类，但是G<A>和G<B>不是继承关系

加入通配符后，G<?>就成了G<A>和G<B>的共同父类。上述方法可以定义为：

```java
public void a(List<?> list) {
    for (Object obj : list) 
        sout(obj);
}
obj.a(new ArrayList<Integer> list);
obj.a(new ArrayList<String> list);
```

使用时，可以传入任意类型的List实现类对象。

##### 细节

- 遍历：在方法中实际的类型可以使用Object类型进行遍历
- 写入操作：不能随意写入操作，只能添加null元素，`obj.add(null);`
- 读取操作：元素的类型也只能是Object



#### 泛型受限

可以通过通配符，限制泛型的类型。可以分为两种类型，某个类的子类或某个类的父类

- 子类及以下：`<? extends className>`
- 父类及以上：`<? super className>`

```java
List<Object> a = new ArrayList<>();
List<Person> b = new ArrayList<>();
List<Student> c = new ArrayList<>();
List<? extends Person> list1 = new ArrayList<Person>();
list1 = b;
list1 = c;
List<? super Person> list2= new ArrayList<Person>();
list2 = a;
```

这种情况下，指定不同的类型也可以赋值，如b, c那行













## I/O流

### File类

Java万物皆对象，将盘符上的文件/目录的各种信息进行封装，称为一个对象，然后操作对象

常用方法：

|   boolean canRead(), boolean canWrite()    | 文件是否可读，文件是否可写 |
| :----------------------------------------: | :------------------------: |
|              String getName()              |         获取文件名         |
|             String getParent()             |        获取上级目录        |
|           boolean isDirectory()            |         是否是目录         |
|    boolean isFile(), boolean isHidden()    |   是否是文件，是否被隐藏   |
|                int length()                |        获取文件长度        |
|              boolean exists()              |        文件是否存在        |
|          boolean createNewFile()           |          创建文件          |
| String getAbsolutePath(), String getPath() |   获取绝对路径、相对路径   |

File.separator，获取当前系统的分隔符

相对路径，相对的是当前main方法的文件夹

对目录操作和对文件操作大部分是一致的：

| boolean mkdir()    | 创建目录，如果目录不存在，试用其对象创建                 |
| ------------------ | -------------------------------------------------------- |
| boolean mkdirs()   | 创建多级目录，如果打开的路径中多级目录都不存在，都会创建 |
| boolean delete()   | 删除单级目录，里面含有内容就拒绝删除                     |
| String[] list()    | 返回目录下所有文件和目录的名称                           |
| File[] listFiles() | 返回目录下所有文件和目录的对象                           |



> File类对象只能获取文件和目录中一些基础信息，无法获取文件中的内容。
>
> 因此需要I/O流来读取和写入文件内容

### I/O流简介

程序和数据源之间交换信息的桥梁

- 按照方向分为：输入流和输出流
- 按照处理数据的单位分为：字节流和字符流

| 四种抽象基类 | 字节流       | 字符流 |
| ------------ | ------------ | ------ |
| 输入流       | InputStream  | Reader |
| 输出流       | OutputStream | Writer |

- 按照功能分为：节点流和处理流
  - 节点流：一个流就可以完成任务
  - 处理流：组合多个流使用(构造器嵌套)，需要通过节点流创建

### FileReader & FileWriter(字符流)

目标：将文件A复制到另一个位置

```java
public static void main(String[] args) {
    File origin = new File("origin/path"); // 获取原文件对象
    FileReader reader =  null // 将原文件放到流上
    FileWriter writer =  null;
//    int n = reader.read();
//    while (n != -1) { // 读取文件内容，读到文件结尾，读取到的内容为“-1”
//        n = reader.read();
//    }
    try {
        reader = new FileReader(origin);
        writer = new FileWriter(new File("duplicate/path"), false);
        char[] ch = new char[5];
    	int len = reader.read(ch);
        while(len != -1) {
//        for (char c : ch) {sout(c);} // 这样会把多余数据输出，是错误示范
  		for (int i = 0; i < len; i++) {sout(ch[i]);}      
        String str = new String(ch, 0, len); // 这种方式也是正确的
        writer.write(ch, 0, len);
        writer.write(str);
        len = reader.read(ch);
        }
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();    
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (writer != null) {
				writer.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException ex) {
			ex.printStackTrace();
        }
    }
}
```

读取时：

- 使用`read()`方法读取文件时，每次读取一个字符，无论中英文。读取到文件末尾时，返回-1
- 空参方法返回读取到的字符，使用`int read(char[] ch)`方法，可以每次读入该数组长度的字符数，存入该数组。读取完毕后，数组长度为-1
  - 该方法返回的是数组的实际使用长度，因为是重复覆盖的，所以数组的length变量一直为5，因此要使用返回的长度作为判断条件
- 流、数据库、网络资源，靠JVM本身是无法关闭的，需要程序员手动关闭
  - 先申请的后关闭

写入时：

- 如果目标文件不存在的话，会自动创建；目标文件存在的话，会将该文件覆盖。想要不覆盖，需要创建写入字符流的时候，加入参数`new FileWriter(file, true);`true表示对文件追加写入，false表示只覆盖不追加
- `write()`方法可以一次写入一个字符，也可以一次写入一个字符数组。需要注意写入长度为有效长度
- 也可以写入字符串



#### 不要用字符流去操作非文本文件

- 文本文件：.txt, .c, .java
- 非文本文件：.mp3, .doc, .ppt

无法正确解析内容



#### 使用try catch finally处理IO异常

- 将流对象的申请放到try中，并在try之前先对其进行初始化`FileReader reader = null;`
- 在finally中写关闭流的逻辑，但是要分别使用try catch 环绕，避免前面的流关闭出现异常，导致后续流无法正常关闭
- 关闭流的时候，需要判断空指针，否则会出现空指针异常



### FileInputSream & FileOutputStream(字节流)

#### 处理文本文件

- 如果文件时utf-8字符集的，英文占一个字节，中文占三个字节，所以使用字节流处理文本文件时会无法正确读取。因此建议文本文件使用字符流处理
- `read()`方法返回值为int，但是只读取一个字节，这是因为底层做了处理，让放回的数据都是正数，防止读取出-1时无法判断是正常字符还是文件结束

#### 处理非文本文件

将图像复制到目标文件

```java
public static void main(String[] args) {
    FileInputStream input = null;
    FileOutputStream output = null;
    try {
        input = new FileInputStream(new File("origin/path"));
        output = new FileOutputStream(new File("target/path"));
        byte[] buffer = byte[1024];
        int len = input.read(buffer);
        while (len != -1) {
            output.write(buffer, 0, len);
            len = input.read(buffer);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
		e.printStrackTrace();
    } finally {
        try {
            if (output != null) output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }  
        try {
            if (input != null) input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }      
    }
}
```



### BufferedInputStream & BufferedOutputStream (缓冲字节流)

虽然上面的例子中，已经使用了buffer数组来做缓冲，能够一次读出和写入多个字节，但是，还是需要多次IO

缓冲字节流在进行文件的读取和写入操作时，系统会分配两个缓冲区

- 从源文件读取时，会先存入缓冲区，然后等待程序来读取。(一次全部读入缓冲区，写满为止)
- 从程序中写入文件时，会先写入缓冲区，然后等待写入文件。(一次从缓冲区全部写入文件，写满为止)

程序可以从缓冲区中进行读取和写入，大大减少磁盘的IO次数

BufferedInputStream & BufferedOutputStream属于处理流，之前的流为节点流

- 缓冲区默认大小为8192B
- 底层自动执行缓冲区刷新操作

```java
public stati void main(String[] args) {
    BufferedInputStream bufferdInput = null;
    BufferedOutputStream bufferedOutput = nul;
    try {
        bufferedInput = new BufferedInputStream(new FileInputStream(new File("origin/path")));
        bufferedOutput = new BufferedOutputStream(new FileInputStream(new File("target/path")));
        byte[] buffer = byte[1024];
        int len = bufferedInput.read(buffer);
        while (len != -1) {
            bufferedOutput.write(buffer, 0, len);
            len = bufferedInput.read(buffer);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
		e.printStrackTrace();
    } finally {
        try {
            if (bufferedOutput != null) bufferedOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }  
        try {
            if (bufferedInput != null) bufferedInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }      
    }
}
```



### BufferedReader & BufferedWriter(缓冲字符流)

```java
public static void main(String[] args) {
    BufferedReader reader = null;
    BufferedWriter writer = null;
    try {
        reader = new BufferedReader(new FileReader(new File("origin/path")));
        writer = new BufferedWriter(new FileWriter(new File("origin/path")));
        char[] ch = new char[5];
    	int len = reader.read(ch);
        while(len != -1) {
            writer.write(ch, 0, len);
            len = reader.read(ch);
        }
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();    
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        try {
            if (writer != null) {
				writer.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException ex) {
			ex.printStackTrace();
        }
    }
}    
}
```



### InputStreamReader & OutputStreamWriter(转换流、字符流、处理流)

- InputStreamReader，将字节输入流转换为字符输入流
- OutputStreamWriter，将字节输出流转换为字符输出流

> 先使用字节流从文件中读取内容，然后通过转换流，将这个流变为字符流交给程序
>
> 输出时，先通过字符流传输给转换流，然后将字符流的内容转换为字节流写入程序

- 字节流与字符流转换时，需要给定字符集。
- 在程序中，ISR， OSW的使用同字符流一致

```java
public static void main(String[] args) {
    InputStreamReader reader = null;
    OutputStreamWriter writer = null;
    try {
        reader = new InputStreamReader(new FileInputStream(new File("origin/path")), "UTF-8");
        writer = new OutputStreamWriter(new FileOutputStream(new File("target/path")), "gbk");
        char[] ch = new char[10];
        int len = input.read(ch);
        while (len != -1) {
            writer.write(ch, 0, len);
            len = reader.read(ch);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
		e.printStrackTrace();
    } finally {
        try {
            if (writer != null) writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }  
        try {
            if (reader != null) reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }      
    }
}
```



### 数据流

用来操作基本数据类型和字符串的。是处理流

- DataInputStream：将文件中存储的基本数据类型和字符串写入内存的变量中
- DataOutputStream：将内存中的基本数据类型和字符串变量写出到文件中

写入到文件的内容，不具备可读性，人不能直接看懂

所以，写出的类型和读入的类型需要一致

```java
public static void main(String[] args) {
    DataOutputStream dos = new DataOutputStream(new FileOutputStream("d:\abc.txt"));
    dos.writeUTF("hello");
    dos.writeDouble(6.9);
    DataInputStream dis = new DateInputStream(new FileInputStream("d:\abc.txt"));
    String str = dis.readUTF();
    Double dou = dis.readDouble();
    dis.close();
    dos.close();
}
```





### 对象流

用来操作引用数据类型的处理流

- ObjectInputStream：当其他程序获取了这种二进制数据，可以恢复成原来的Java对象。(反序列化)
- ObjectOutputStream：把内存中的Java对象转换成*平台无关的*二进制数据。从而允许将二进制数据持久地保存在磁盘上，或者通过二进制数据传输到另一个网络节点。(序列化)

读取时使用的是`readObject()`方法

```java
public static void main(String[] args) {
	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\demo.txt"));
    oos.write("hello"); // 写出一个String对象
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\demo.txt"));
    Object obj = ois.readObject();
    obj = (String) obj;
    ois.close();
    oos.close();
}
```



### 序列化和反序列化

将对象转换为平台无关的二进制数据为序列化，将二进制数据转换为原对象为反序列化

类需要实现`Serializable`接口，其对象才能被序列化和反序列化

- Serializabe接口中没有内容，是一个*标识接口*，起到标识作用。只有实现了这个接口的类，其对象才能被序列化和反序列化

> Java中对象的序列化指的是将对象转换成以字节序列的形式来表示，这些字节序列包含了对象的数据和信息，一个序列化后的对象*可以被写到数据库或文件中*，也可用于*网络传输*。
>
> 一般，当我们使用*缓存cache*或者远程调用rpc时，需要让对象序列化



#### serialVersionUID

如果在序列化之后，对对象对应的类文件进行了修改，然后再反序列化将对象读回，此时就会报`InvalidClassException`异常，无法正确识别类

- 原因是，对类文件进行了修改，导致类型不匹配
- 解决方法，给类中加入序列号`serialVersionUID`

serialVersionUID，凡是实现Serializable接口的类，都有一个表示序列化版本标识的静态变量

- `private static final long serialVersionUID;`
- 用来表明类的不同版本间的兼容性，简言之，其目的就是以序列化对象进行版本控制，各版本反序列化时是否兼容
- 如果没有显示定义这个静态常量，它的值是Java运行时环境根据类的内部细节*自动生成的*，如果类的实例变量做了修改，就会发生变化，因此要显示定义
- 在反序列化时，JVM会将对象流中的serialVersionUID和本地类对应的常量进行对比，如果相同，就认为是一致的，可以进行反序列化，否则就会弧线序列版本不一致的异常

> IDEA中，在设置中Editor->Inspections->Serializable Class without 'serialVersionUID'勾选，即可自动生成



#### 序列化细节

- 被序列化的类，内部属性都要是可序列化的
  - 基本数据类型都是可序列化的
  - 成员是类时，该类也需要实现Serializable
- 被`static` 和 `transient`修饰的属性，不能被序列化







# JavaSE进阶实战

## Junit&注解&枚举

### Junit单元测试(白盒测试)

没有引入Junit之前，测试存在以下缺点：

- 测试一定要走`main`方法，它是程序的入口，`main`方法的格式必须不能写错
- 如果在同一个`main`方法中测试的话，不需要的代码需要注释起来
- 测试逻辑如果分开，就需要定义多个测试类



#### 使用方法

- 一般开发逻辑和测试逻辑是分开的，测试类一般放在公司域名反写+Test包下，测试类需要见名知意，一般使用***Test。

- 测试方法可以独立运行，不需要依托于main方法。一般为空参方法
- 方法上需要添加`@Test`注解。
  - 因为Junit不是Java语言自身的，而是一个测试框架，所以需要导入环境依赖

判定结果：

- 如果测试结果为红色，证明出现异常，程序一定有问题
- 如果测试结果为绿色，也不能保证程序没有问题
  - 需要加入断言来判断结果是否与真实结果一致

断言：`Assert.assertEquals(expected, result)`，来判断结果是否与预设好的结果一致



### 注解

注解(Annotation)，也称元数据

什么是注解，注解就是代码里的特殊标记，可以在编译，类加载，运行时被读取，并执行相应的处理。通过注解，可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息

> 一定程度上来说，框架=注解+反射+设计模式



#### Junit @Before & @After

使用该标注的方法，可以分别在测试方法执行前和执行后执行。而且是所有测试方法公用的

- 一般放在@Before中的是申请资源的代码，如申请数据库资源，申请IO资源，申请网络资源等
- 一般放在@After中的是释放资源的代码，如释放数据库资源，释放IO资源，释放网络资源



#### 文档注解

放在文档注释中，用来对类和方法进行解释和说明



#### JDK 内置注解

- @Override：限定重写父类方法，只能用于方法
- @Deprecated：废弃方法或过期方法的注解
- @SuppressWarnings：抑制编译器警告。如抑制变量未使用警告，可以在该变量前加`@SuppressWarnings("unused")`



#### 自定义注解(了解即可)

- 声明关键字`@interface`，但是与接口没有关系
- 以`@SuppressWarnings`为例，其内部为`String[] value();`，是一个成员属性，value为变量名
- 该成员属性为配置参数，只要定义了，使用时就必须要赋值。且如果变量名为value，赋值时可以省略
- `String[] value() default "abc";`如果使用default给出了默认值，可以不赋值直接使用
- 注解内部也可以不定义参数
  - 内部没有参数的注解，称为标记
  - 内部有参数的，称为元数据



#### 元注解

用来修饰其他注解的注解，就是元注解

JDK5提供了四种元注解：@Retention，@Target，@Document，@Inherited



##### @Retention

用于指定修饰的注解的生命周期，包含一个RetentionPolicy枚举类型的成员变量，使用注解时必须为该value成员变量指定值。默认`RetentionPolicy.CLASS`

内部定义了三个属性

- `RetentionPolicy.CLASS`：被注解的自定义注解，在`.class`文件中有效，保留在`.class`中，但是当运行Java程序时，就不会继续加载了，不会保留在内存中。即运行时方法上没有自定义注解。如果定义自定义注解时，没有添加@Retention元注解，就会默认这种注解
- `RententionPolicy.RUNTIME`：运行时有效，当Java程序运行时，JVM会保留注解，加载在内存中。*程序可以通过反射获取该注解*。
- `RetentionPolicy.SOURCE`：在源文件中有效，编译过后的字节码文件中没有该注解



@Target

用于指定修饰的注解可以修饰哪些程序元素(类，方法，变量)

```java
@Target(METHOD, CONSTRUCTOR, TYPE, ) // 添加一个就能多作用一种
```



@Document

用于指定该元注解修饰的注解类将被javadoc工具条提取成文档。默认情况下，javadoc是不包含注解的，但是加上了这个注解，生成的文档中就会带注解

即，使用一个注解修饰了一个方法，如果这个注解类定义时没有被`@Documented`修饰，那么javadoc生成api文档时，该方法上就不会标注被某注解修饰



@Inherited(极少使用)

修饰的注解类具有继承性，注解被修饰后，被该注解修饰的类的子类，也会自动被该注解修饰



### 枚举

如果一个类的对象的种类数是有限的，确定的，可以将这个类定义为枚举类。

如：星期，月份，性别等

#### 自定义枚举类

e.g.

```java
public class Season {
    private final String seasonName;
    private final String seasonDesc;
    
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc；
    }
    
    public static final Season SPRING = new Season("Spring", "Warm");
    public static final Season SUMMER = new Season("Summer", "Hot");
    public static final Season FALL = new Season("Fall", "Cool");
    public static final Season WINTER = new Season("Winter", "Cold");
    
    public String getSeasonName() { return this.seasonName;}
    public String getSeasonDesc() { return this.seasonDesc;}
    public String toString() { return "Season{" + "seasonName = '" + seasonName 
                             + '\'' + ", seasonDesc = '" + seasonDesc + '\'' + '}'}
}
```

构造方法私有化，属性全部为私有常量，在类的内部将所有可能的对象给出，只提供get方法。



#### JDK5之后使用enum关键字创建枚举类

enum关键字枚举类要求*对象(常量)*必须放在最开始定义

只需要写`对象名(value, value, ...)`定义，多个对象之间使用`,`分隔

```java
public enum Season {
    SPRING("Spring", "Warm"),
    SUMMER("Summer", "Hot"),
    FALL("Fall", "Cool"),
    WINTER("Winter", "Cold");
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc；
    }
    public String getSeasonName() { return this.seasonName;}
    public String getSeasonDesc() { return this.seasonDesc;}
    public String toString() { return "Season{" + "seasonName = '" + seasonName 
                             + '\'' + ", seasonDesc = '" + seasonDesc + '\'' + '}'}
	public static void main(String[] args) {
        Season winter = Season.WINTER; // 直接使用`类名.对象名`获取对象
    }
}
```

> - enum关键字定义的枚举类，上层父类是`java.lang.Enum`
>   - 使用默认的toString方法，输出的是对象名
>
> - 自定义枚举类的父类是`java.lang.Object`

 ##### 没有成员属性的枚举类

```java
public enum Season {
    SPRING,
    SUMMER,
    FALL,
    WINTER;
}
```

没有属性，不需要提供带参构造，不需要提供get方法，对象的申请的小括号可以删除



#### 常用方法

- `String toString()`：返回对象名
- `static Enum[] valus()`：将枚举对象全部返回
- `static Enum valueOf(Sting name)`：按照对象名返回对象



#### 枚举类实现接口

枚举类实现接口重写方法时，默认是所有对象都用同样的方法。

为了能让不同对象重写的方法不同，可以在对象定义时重写

```java
public enum Season implements TestInterface {
    SPRING {
    	@Override
        public void test() {
            sout("this is " + this.toString());
        }
    },
    SUMMER {
    	@Override
        public void test() {
            sout("this is summer");
        }
    },
    FALL,
    WINTER;    
}
```



#### 枚举类应用(性别类)

- 通过将属性变为枚举对象的方式，约束设置属性只能传入固定种类的对象。

```java
public enum Gender {
    MALE,
    FEMALE;
}
public class Person {
    private String name;
    private Gender sex;
    public String getName() { return this.name;}
    public Gender getSex() { return this.sex;}
    public void setName(String name) { return this.name = name;}
    public void setSex(Gender sex) { return this.sex = sex;}
    
    public static void main(String[] args) {
        Person person = new Person();
        person.setSex(Gender.MALE); // 只能传入特定对象
    }
}
```

- switch中可以使用枚举类型



## 网络编程

把分布在不同地理区域的计算机与专门的外部设备，用通信线路互连成一个规模大、功能强的网络系统，从而使众多的计算机可以方便地滑行传递信息、共享硬件、软件、数据等资源。

为了能够定位通信的双方，需要一个地址，一般为IP+端口号组成的套接字

中间还涉及到DNS域名解析，将网址解析为IP地址



### InetAddress & InetSocketAddress

- InetAddress封装了IP地址
- InetSocketAddress封装了网络套接字(IP+端口号)

```java
public static void main(String[] args) throws UnknownHostException {
    //封装IP://InetAddress ia = new InetAddress();不能直接创建对象，为InetAddress()被default修饰了
    InetAddress ia = InetAddress.getByName("192.168.199.217");
	System.out.printIn(ia);
    InetAddress ia2 = netAddress.etByName("localhost");//Localhost指代的是本机的p地址
    System.out.println(ia2);
	InetAddress ia3 = InetAddress.getByName("127.0.0.1");//127.0.0.1指代的是本机的p地址
    System.out.println(ia3);
    InetAddress ia4 = InetAddress.getByName("LAPTOP-CRIVSRRU");//封装计算机名
    System.out.println(ia4);
	InetAddress ia5 = InetAddress.getByName("www,mashibing.com");//封装域名
    System.out.printIn(ia5);
	System.out.println(ia5.getHostName());
    System.out.println(ia5.getHostAddress());
}
```

```java
public static void main(String[] args) {
	InetSocketAddress isa = new InetSocketAddress("192.168.0.1", 8080);
    isa.getHostName(); // 域名
    isa.getHostPort();
    InetAddress ia = isa.getAddress(); // 获取InetAddress对象
}
```



### Socket套接字

套接字的作用是，应用层获取传输层的协议

直观上来说，客户端之间传输数据是通过流来实现的`OutputStream` `InputStream`



### TCP通信

- 客户端创建 Socket对象，封装服务器的IP+端口号组成的套接字
- 服务端创建ServerSocket对象，封装程序运行监听的端口号

程序通过流的方式输出和输入数据



实例：模拟网站的登录，客户端录入账号密码，然后服务端进行验证

#### 功能分解一 单向通信

客户端发送数据到服务器



#### 功能分解二 双向通信

服务器收到消息后，向客户端输出消息

客户端

```java
public static void main(String[] args) throws IOException {
    // 创建套接字对象，指定服务器的IP和端口号
    Socket socket = new Socket("localhost", 8888);
    // 获取输出流
    OutputStream outputStream = socket.getOutputStream();
    // 因为获取的流没有传输字符串的方法，所以需要使用处理流
    DataOutputStream output = new DataOutputStream(outputStream);
    output.writeUTF("hello");
    // 接收服务器发来的消息
    InputStream inputStream = socket.getInputStream();
    DataInputStream input = new DataInputStream(inputStream);
    String msg = input.readUTF();
    System.out.println(msg);

    // 关闭流
    input.close();
    inputStream.close();
    output.close();
    outputStream.close();
    socket.close();
}
```

服务端

```java
public static void main(String[] args) throws IOException {
    // 创建套接字，指定服务器的端口号
    ServerSocket serverSocket = new ServerSocket(8888);
    // 等待客户端发来信息
    Socket accept = serverSocket.accept();// 阻塞发给发：什么时候接收到消息，什么时候继续进行
    // 阻塞方法返回值为Socket，就是客户端的Socket对象
    // 获取输入流
    InputStream inputStream = accept.getInputStream();
    DataInputStream input = new DataInputStream(inputStream);
    String msg = input.readUTF();
    System.out.println(msg);

    // 向客户端写回数据
    OutputStream outputStream = accept.getOutputStream();
    DataOutputStream output = new DataOutputStream(outputStream);
    output.writeUTF("message received");

    // 关闭流和关闭网络资源
    output.close();
    outputStream.close();
    input.close();
    inputStream.close();
    accept.close();
    serverSocket.close();
}
```



#### 功能实现

客户端

```java
public static void main(String[] args) {
    // 创建套接字对象，指定服务器的IP和端口号
    Socket socket = null;
    OutputStream outputStream = null;
    ObjectOutputStream userStream = null;
    try {
        socket = new Socket("localhost", 8888);
        outputStream = socket.getOutputStream();
        userStream = new ObjectOutputStream(outputStream);

        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("please input your username:");
        user.setUsername(scanner.next());
        System.out.println("please input your password:");
        user.setPassword(scanner.next());
        userStream.writeObject(user);
        // 接收服务器发来的消息
        InputStream inputStream = socket.getInputStream();
        DataInputStream input = new DataInputStream(inputStream);
        String msg = input.readUTF();
        System.out.println(msg);
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        // 关闭流
        try {
            if (userStream != null) {
                userStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

服务端

```java
public static void main(String[] args) {
    // 创建套接字，指定服务器的端口号
    ServerSocket serverSocket = null;
    Socket accept = null;
    InputStream inputStream = null;
    ObjectInputStream userStream = null;
    OutputStream outputStream = null;
    DataOutputStream output = null;
    try {
        serverSocket = new ServerSocket(8888);
        // 等待客户端发来信息
        accept = serverSocket.accept();// 阻塞发给发：什么时候接收到消息，什么时候继续进行
        // 阻塞方法返回值为Socket，就是客户端的Socket对象
        // 获取输入流
        inputStream = accept.getInputStream();
        userStream = new ObjectInputStream(inputStream);
        User user = (User) userStream.readObject();
        String msg = "";
        if (user.getUsername().equals("moro") && user.getPassword().equals("123123")) {
            msg = "login successfully";
        } else {
            msg = "username or password incorrect";
        }
        // 向客户端写回数据
        outputStream = accept.getOutputStream();
        output = new DataOutputStream(outputStream);
        output.writeUTF(msg);
    } catch (IOException | ClassNotFoundException e) {
        throw new RuntimeException(e);
    } finally {
        // 关闭流和关闭网络资源
        // 为了防止关闭出错，后续流无法关闭所以只能一个一个try
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (accept != null) {
                accept.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

- 为了防止关闭出错，后续流无法关闭所以只能一个一个try
- 为了防止空指针异常，每次关闭前都需要判断指针不为空



##### 遗留问题

目前服务器只能服务于一个客户，无法多线程



### UDP通信

通信双方是对等的，通过创建DatagramSocket对象来封装本机端口

发送的数据通过DatagramPacket来封装

通信双方都需要一个byte数组，用于封装要发送的数据和接收数据



实例：模拟网络聊天

```java
public static void main(String[] args) {
    // 1. 准备套接字
    DatagramSocket datagramSocket = null;
    try {
        datagramSocket = new DatagramSocket(9999);
        byte[] receiveBytes = new byte[1024];
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 接收
            DatagramPacket receivePacket = new DatagramPacket(receiveBytes, receiveBytes.length);
            datagramSocket.receive(receivePacket);
            byte[] data = receivePacket.getData();
            String receiveMsg = new String(data, 0, receivePacket.getLength());
            System.out.println(receiveMsg);
            System.out.print("> ");
            // 2. 准备数据包
            String sendMsg = scanner.next();
            byte[] sendBytes = sendMsg.getBytes();
            /*
            四个参数：字节数组形式的数据，数组长度，封装接收方的IP对象，接收方的端口号
             */
            DatagramPacket sendPacket = new DatagramPacket(sendBytes,
                    sendBytes.length, InetAddress.getByName("localhost"), 8888);
            datagramSocket.send(sendPacket);

        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        // 关闭流和网络资源
        assert datagramSocket != null;
        datagramSocket.close();
    }
}
```



## 多线程

- 进程是程序的一次执行过程，是资源分配的单位
- 线程是进程的细分，是处理机调度的单位

### 单核CPU与多核CPU

单核cpu，相当于只有一个处理机，进程会轮流获得处理机资源，轮流执行。因此只是表面上看起来像是进程同时进行。

多核cpu，内部包含多个处理机，可以同时运行多个进程，真正意义的同时进行

### 并行和并发

- 并行是同一时刻同时有多个进程在执行
- 并发是一个时间段内，有多个进程在执行



### 创建线程的三种方式

在接触到多线程之前的程序，实际上也是多线程的，一般的进程都包含处理异常的线程、main方法所在的线程和垃圾收集器线程等。只是其余的线程都感知不到，只能看到main方法所在的线程



#### 继承Thread类

主要步骤如下：

- 继承`Thread`类
- 重写`public void run()`方法，将线程的主要逻辑放在其中
  - run()方法不能直接调用，否则会被当作普通方法处理
- 在main方法中创建该类的对象，然后调用`start()`方法



##### 设置线程名字的方法

- 使用线程对象调用`setName(String name)`为该线程设置名字
- 在该线程中，使用Thread类提供的静态方法`Thread.currentThread()`获取当前线程对象，然后调用`getName(String name)`为本线程设置名字
  - 如果是继承Thread类，可以直接在类中使用`this.setName()`设置名字
- 通过构造器设置名字，Thread类有一个带参构造`public Thread(String name) {}`，因此可以在自己创建的线程类中设置一个带参构造器，在其中使用`super(name);`来调用Thread类的带参构造



##### 多线程实例--买火车票

假设有一百张票，然后设有三个窗口

```java
public class Thread01 extends Thread {
    private static int remain = 100;
    public Thread01(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (remain > 0) {
            System.out.println(this.getName() + " is selling " + (100 - remain + 1) + "th ticket");
            --remain;
        }
    }
    public static void main(String[] args) {
        Thread01 windows1 = new Thread01("windows-1");
        Thread01 windows2 = new Thread01("windows-2");
        Thread01 windows3 = new Thread01("windows-3");
        windows3.start();
        windows2.start();
        windows1.start();
    }
}
```



#### 实现Runnable接口

具体做法：

- 创建自定义线程类，实现`Runnable`接口
- 重写`public void run() {}`方法，将线程的逻辑放入其中

> 因为不是继承Thread类，就无法使用`getName()/setName()`等方法。只能使用Thread.currentThread()来获取和设置相关属性

- 创建自定义线程类对象，然后创建Thread类对象，将自定义类对象作为参数传入



##### 多线程实例--买火车票

```java
public class Thread02 implements Runnable {
    private int remain = 100;
    @Override
    public void run() {
        while (remain > 0) {
            System.out.println(Thread.currentThread().getName() + " is selling " + (100 - remain + 1) + "th ticket");
            --remain;
        }
    }

    public static void main(String[] args) {
        Thread windows1 = new Thread(new Thread02(), "windows-1");
        Thread windows2 = new Thread(new Thread02(), "windows-2");
        Thread windows3 = new Thread(new Thread02(), "windows-3");
        windows3.start();
        windows2.start();
        windows1.start();
    }
}
```



> 实际开发中，由于Java有单继承的特性，如果类继承了Thread类，就无法继承其他类。
>
> 并且，继承Thread类时，资源共享能力也会变弱，例如买票需要将成员属性变为静态属性才能共享

![image-20231227163953570](..\img\thread-1.png)



#### 实现Callable接口

> 对比前两种多线程实现方式，无论是哪种，都有两个缺点
>
> - run()方法没有返回值
> - run()方法不能使用`throws`关键字抛出异常
>   - 子类重写父类或方法中的接口，要么不抛出异常，要么异常抛出父类方法异常的子类异常
>
> 实现Callable接口的优缺点如下：
>
> - 有返回值
> - 能抛出异常
> - 线程创建比较繁琐

具体做法：

- 创建自定义线程类，实现`Callable`接口
- 重写`public T call() throws Exception{}`方法，将线程的逻辑放入其中
- 在main方法中创建自定义线程对象，然后创建FutureTask类对象，将自定义线程类对象传入
- 创建Thread类对象，将FutureTask对象传入
- 如果想获取call()方法的返回值，就需要使用FutureTask对象调用`get()`方法来获取



### 线程的生命周期

五状态模型：

![image-20231227180214438](..\img\threadLifespan.png)

- 阻塞状态：出现了阻塞事件，线程主动放弃了cpu的使用权
- 就绪状态：线程已经具备了能运行的所有资源，但是没有获取cpu的使用权
  - 从运行态到就绪态，线程是被迫放弃了cpu的使用权，如时间片用尽



### 线程常见方法

#### start()

启动当前线程对象，表面上是调用start()方法，底层是调用线程内部的run()方法

#### run()

线程类继承Thread类或者实现Runnable接口时，需要重写该方法。run()方法内部是线程需要执行的逻辑

#### currentThread()

Thread类中的静态方法，能够当前正在执行的线程(也就是说能够获取当前线程，因为只有线程在处理机上执行时，才能执行到该方法)

#### setName() & getName()

Thread类中提供的get和set方法，用于设置和获取线程对象的名称



#### setPriority() & getPriority()

设置线程的优先级

同优先级的线程之间，采用的是先到先服务，时间片轮转策略

如果线程优先级高，被CPU调度的概率就更高

Thread类中设计了几个优先级常量：

```java
public final static int MIN_PRIORITY = 1;
public final static int NORM_PRIORITY = 0;
public final static int MAX_PRIORITY = 10;
```

由此可见，默认优先级为5



#### join()

当一个线程调用了join()方法，这个线程就会被先执行，它*执行结束*以后才会轮到其他线程

> 必须先start再join()，否则是无效的

e.g.

```java
public class Test extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {sout(i);}
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            if (i == 5) {
                Test test = new Test("sub thread");
                test.start();
                test.join();
            }
            sout("main is printing " + i);
        }
    }
}
```

上例中，main方法所在线程输出到i==5时，创建了新的线程，并调用了join()方法，该线程会输出完1~100，然后才会恢复卖弄方法所在线程的执行



#### sleep()

手动制造阻塞事件，让正在执行的线程进入阻塞状态，到达设定的时间(单位为ms)后，被唤醒并进入就绪态



#### setDaemon()

设置伴随线程(守护线程)，当线程停止时，伴随线程也会停止，不会继续执行

在一个线程里，使用另一个线程对象调用该方法，会将该进程设置为当前进程的伴随线程

- 如在main方法中新建线程类对象，然后调用setDaemon()，该线程就成了main方法所在线程的伴随线程

> 先设置伴随进程setDaemon()，再执行，否则无效



#### stop()

手动结束线程，让线程进入结束状态



### 线程安全问题

















