# 新手班

## 输出整数的二进制表示

Java中`Integer`类型为32位整数，对于每一位上的二进制表示，只需要拿到当前位为`1`，其余位为`0`的数，与整数进行与操作，即可得到当前位的二进制表示。

只需要判断与操作后的结果是否为`0`，即可输出当前位的`0 1`

```java
public class Code06_PrintBinary {
    public static void main(String[] args) {
        int num = 4;
        print(4);
        print(4 << 1);
        print(4 << 2);
        print(4 << 16);
    }
    public static void print(int num) {
        for (int i = 31; i >=0; i--) {
            System.out.print((num & (1<<i)) == 0 ? '0' : '1');
        }
        System.out.println();
    }
}
```

补充概念：

`Integer`类型为有符号整数，最高位为符号位，整体按照补码表示。

> 补码：正数按照实际表示，负数需要将除*符号位外*整体取反再加一才能得到负数的绝对值
>
> 如果想得到一个数的相反数，只需要将其取反加一即可`int a = 5; int b = (~a + 1);`



## 通过随机数获得[A, B]上的整数

- `Math.random()`能获取`[0, 1)`上的随机浮点数
- `(int)(Math.random() * 5) + 1`可以等概率获取`1~5`的整数
- 然后利用以下代码可以等概率获取`0 1`

```java
public static int a(){return (int)(Math.random() * 5) + 1};
public static int zeroOrOne() {
	int result = 0;
    do {
        result = a();
    } while(result == 3);
    return result < 3 ? 0 : 1;
}
```

- 然后计算`B-A`需要几位二进制数表示，假设需要三位

```java
public static int b() {
    return ((zeroOrOne() << 2) + (zeroOrOne() << 1) + zeroOrOne()) + A;
}
```

