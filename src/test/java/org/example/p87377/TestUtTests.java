package org.example.p87377;

import org.example.TestUt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class TestUtTests {
    @Test
    @DisplayName("getAge")
    void t1() {
        int age = TestUt.call(new Person(), "getAge");
        assertThat(age).isEqualTo(10);
    }

    @Test
    @DisplayName("getAge(10)")
    void t2() {
        int age = TestUt.call(new Person(), "getAge", 10);
        assertThat(age).isEqualTo(20);
    }

    @Test
    @DisplayName("getAge(10, 20)")
    void t3() {
        int age = TestUt.call(new Person(), "getAge", 10, 20);
        assertThat(age).isEqualTo(40);
    }

    @Test
    @DisplayName("getAge(\"100\")")
    void t4() {
        int age = TestUt.call(new Person(), "getAge", "100");
        assertThat(age).isEqualTo(110);
    }

    @Test
    @DisplayName("getName()")
    void t5() {
        String name = TestUt.call(new Person(), "getName");
        assertThat(name).isEqualTo("폴");
    }

    @Test
    @DisplayName("getName(\"님\")")
    void t6() {
        String name = TestUt.call(new Person(), "getName", "님");
        assertThat(name).isEqualTo("폴님");
    }

    @Test
    @DisplayName("getMe()")
    void t7() {
        Person p = new Person();
        Person me = TestUt.call(p, "getMe");
        assertThat(me).isEqualTo(p);
    }
}

class Person {
    private int age = 10;
    private String name = "폴";

    private int getAge() {
        return age;
    }

    private int getAge(Integer no1) {
        return age + no1;
    }

    private int getAge(Integer no1, Integer no2) {
        return age + no1 + no2;
    }

    private int getAge(String no1) {
        return age + Integer.parseInt(no1);
    }

    private String getName() {
        return name;
    }

    private String getName(String subfix) {
        return name + subfix;
    }

    private Person getMe() {
        return this;
    }
}