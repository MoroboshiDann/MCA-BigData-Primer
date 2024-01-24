# 一、Singleton 单例

只需要一个实例，比如各种Mgr和Factory。在使用过程中只需要一个实例对象就能满足需求。此设计模式可以在代码层面阻止使用者申请多个实例。

共有八种写法：

- 饿汉式



## 1. 饿汉式

类加载到内存后，就实例化一个单例，JVM保证线程安全。

优点：简单实用，推荐使用

唯一缺点：不管代码中是否会被用到，类加载时都会被实例化，占用内存空间。(但是不使用时也不会将类加载到内存中，所以不算是缺点)

```java
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01() {} // 构造方法私有化，不能创建对象
    public static Mgr01 getInstance() {return INSTANCE;}
    public void m() {System.out.println("m");}

    public static void main(String[] args) {
        Mgr01 instance1 = Mgr01.getInstance();
        Mgr01 instance2 = Mgr01.getInstance();
        System.out.println(instance2 == instance1); // 输出true
    }
}
```

解析：

- 类中提供一个静态常量`INSTANCE`，会在类加载时实例化一个对象。这就是唯一可以获取的对象。
- 构造方法`private`修饰，不能通过`new`关键字创建。只能通过提供的静态方法`getInstance()`方法获取类的对象。

## 2. 饿汉式-静态代码块

原理同上，但是静态常量对象的初始化放在一个静态代码块中。起到做的效果是一致的

```java
public class Mgr02 {
    private static final Mgr02 INSTANCE;
    static {INSTANCE = new Mgr02();}

    private Mgr02() {} // 构造方法私有化，不能创建对象
    public static Mgr02 getInstance() {return INSTANCE;}
}
```

解析：

- 静态代码块只会在类被加载时执行一次，所以可以将常量的初始化放在其中。



## 3. 懒汉式

懒汉式(Lazy Loading)，只有被用到时才会实例化对象。

缺点：线程不安全

```java
public class Mgr03 {
    private static Mgr03 INSTANCE;
    private Mgr03() {}

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public static void m() {System.out.println("m");}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr03.getInstance().hashCode());
            }).start(); // 输出了多个实例化对象
        }
    }
}
```

> `main()`方法中使用了匿名内部类。即创建了一个`Thread`接口的实现类对象，这个实现类重写了接口中的`Runnable()`方法，方法中调用了`getInstance()`方法获取了Mgr03的一个实例化对象，并输出了该对象的hashcode。

解析：

- 有一个本类的静态成员变量，没有初始化。当第一次被使用到时才会实例化一个对象，赋给这个静态变量
- 构造方法私有化，外界不能创建对象，只能通过`getInstance()`方法来获取对象
- 每次调用`getInstance()`都会判断静态成员`INSTANCE`是否已经被赋值，如果是直接返回当前值，否则实例化一个对象并赋值。

> 由于`getInstance()`方法中判断是否为第一次调用不是原子操作，因此多线程访问时是不安全的，可能会实例化多个对象。



## 4. 懒汉式-线程安全(方法加锁)

为了解决上述写法中，线程不安全的问题，给`getInstance()`方法加锁

缺点：执行效率低

```java
public class Mgr04 {
    private static Mgr04 INSTANCE;
    private Mgr04() {}

    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public static void m() {System.out.println("m");}

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr04.getInstance().hashCode());
            }).start(); // 输出了多个实例化对象
        }
    }
}
```

解析：

- 给`getInstance()`加锁后，不会出现实例化了多个对象的问题。但是会出现效率低的问题。



## 5. 饿汉式-线程安全(同步代码块)

上述写法给整个`getInstance()`方法都加锁同步，导致效率低。因此，减少被加锁的代码量来增加效率。

```java
public class Mgr05 {
    private static volatile Mgr05 INSTANCE;

    private Mgr05() {
    }

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr05.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    INSTANCE = new Mgr05();
                }
            }
        }
        return INSTANCE;
    }
}
```

解析：

- 在上锁之前做了一次判断，本次判断是有必要的。因为，如果没有这次判断，所有调用本方法的线程都会先等待锁，然后再判断是否对象为空。加上这次判断，就可以减少等待的线程数量。
- 静态变量需要被`volatile`关键字修饰。用于禁止指令重排，如果采用了JIT，可能会将Java源代码编译为其他语言的汇编代码，导致语句顺序发生变化，出现未初始化便返回给调用者。



## 6. 静态内部类

将实例化的静态常量对象作为一个静态内部类的成员变量。加载外部类的时候，不会加载内部类，实现了懒加载。

```java
public class Mgr06 {
    private Mgr06() {}

    private static class Mgr06Holder {
        private static final Mgr06 INSTANCE = new Mgr06();
    }

    public static Mgr06 getInstance() {
        return Mgr06Holder.INSTANCE;
    }

    public static void main(String[] args) {
        Mgr06 instance1 = Mgr06.getInstance();
        Mgr06 instance2 = Mgr06.getInstance();
        System.out.println(instance1 == instance2);
    }
}
```



## 7. 枚举

```java
public enum Mgr07 {
    INSTANCE;
    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr07.INSTANCE.hashCode());
            }).start();
        }
    }
}
```

解析：

- 通过枚举类的方式，不仅解决了线程同步，还可以防止反序列化(因为没有构造方法)。



# 二、Strategy 策略



