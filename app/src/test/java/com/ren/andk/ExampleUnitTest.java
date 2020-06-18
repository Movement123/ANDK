package com.ren.andk;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    private volatile int i = 0;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);

        new B();
        ArrayList<A> arrayList = new ArrayList<>();
        arrayList.contains(new A());
    }



}


class A {

    static {

        System.out.println("FFFFF静态代码块");
    }


    {
        System.out.println("FFFFF非静态代码块");
    }

    public A(){
        System.out.println("父类构造");

    }
}


class B extends A{


    public B(){
        super();
        System.out.println("子类构造");
    }

    static {

        System.out.println("静态代码块");
    }


    {
        System.out.println("非静态代码块");
    }
}