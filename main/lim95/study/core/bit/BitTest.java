package main.lim95.study.core.bit;

/**
 * Created by lim9527 on 5/11 0011.
 */
public class BitTest {

    public static void main(String[] args){
        //method();
        method2();
    }


    public static void method(){
        int a = 1>>2;
        int b = -1>>2;
        int c = 1<<2;
        int d = -1<<2;
        int e = 3>>>2;

        System.out.println("a" + a);//0
        System.out.println("b" + b);//-1
        System.out.println("c" + c);//4
        System.out.println("d" + d);//-4
        System.out.println("e" + e);//0
    }

    public static void method2(){
        int a = ~2;
        int b = 2&3;
        int c = 2|3;
        int d = ~-8;
        int e = 3^2;

        System.out.println("a" + a);//  -3
        System.out.println("b" + b);//   2
        System.out.println("c" + c);//   3
        System.out.println("d" + d);//   -2:1, -5:4, -8:7
        System.out.println("e" + e);//   1
    }

}
