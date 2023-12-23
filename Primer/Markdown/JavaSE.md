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
|修饰符|同一个类|同一个包|子类|所有类|
|---|---|---|---|---|
|private|&#10004||||
|default|&#10004|&#10004|||
|protected|&#10004|&#10004|&#10004||
|public|&#10004|&#10004|&#10004|&#10004|

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
>

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









# JavaSE中阶

# JavaSE高阶
