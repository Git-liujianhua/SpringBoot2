package com.atguigu.admin;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


/**
 * //@ExtendWith类似于junit5以前版本的@RunWith
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith(SpringExtension.class),引用扩展，定制测试开发
 */
//@SpringBootTest：一旦对接springboot的单元测试，就会加载SpringBoot的整个容器过程
//@SpringBootTest
@DisplayName("Junit5功能测试类")
public class Junit5Test {

    @DisplayName("DisplayName的测试")
    @Test
    void testDisplayName(){
        System.out.println(1);
    }

    @Disabled
    @DisplayName("测试方法2")
    @Test
    void testDisabled(){
        System.out.println(2);
    }
    @BeforeEach
    void testBeforeEach(){
        System.out.println("Junit5测试开始执行了.......");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("Junit5测试结束了.......");
    }

    /**
     * @BeforeAll method 'void com.atguigu.admin.Junit5Test.testBeforeAll()' must be static unless the test class is annotated with @TestInstance(Lifecycle.PER_CLASS).
     * 必须标注静态static，或者标注@TestInstance说明这个测试方法有个实例，因为所有方法执行之前会调用改方法，这个方法只会被调用一次
     * @AfterEach和@BeforeEach就不需要，因为每个测试方法都会调用它会多次执行
     */
    @AfterAll
    static void testAfterAll(){
        System.out.println("Junit5的所有测试方法结束了....");
    }

    /**
     * 重复测试，告诉这个测试方法要重复运行几次，模拟一个功能多次测试
     */
    @RepeatedTest(5)
    @Test
    void testRepeatedTest(){
        System.out.println(5);
    }

    /**
     * 同上BeforeAll的一样
     */
    @BeforeAll
    static void testBeforeAll(){
        System.out.println("Junit5的所有测试方法开始执行.....");
    }

    /**
     * 规定方法超时时间，超出时间测试出异常【5.7以后才有的】
     * @throws InterruptedException
     */
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }


    /**
     * 断言：前面断言失败，后面的所有代码就不会执行
     * 第一个参数传的是期望值，第二个参数传的是实际运行后返回来的值，每个断言都可以自定义错误信息
     */
    @DisplayName("简单断言")
    @Test
    void testSimpleAssertions(){
        Integer call = call(2, 3);
        assertEquals(5,call,"返回值与预期值不一致，执行失败！");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2,"返回的对象与预期对象不一致，执行失败！");
        assertTrue(1 > 2,"返回false，执行失败");
        assertFalse(1 < 2,"返回true，执行失败");
    }

    Integer call(int i, int j){
        int b = i + j;
        return b;
    }

    @DisplayName("数组断言")
    @Test
    void testArrayAssertion(){
        assertArrayEquals(new int[]{2,2},new int[]{1,2},"数组不一致执行失败！");
    }

    @DisplayName("组合断言")
    @Test
    void testAllAssertion(){
        assertAll("test",() -> assertEquals(2,2,"期望值与返回结果不一致"),
                () -> assertTrue( true && 1 > 2,"返回false,非true"));
    }

    /**
     * 计算成功抛出异常，失败不抛证明断言成功
     */
    @DisplayName("异常断言")
    @Test
    void testExceptionAssertion(){
        //扔出断言异常
        assertThrows(ArithmeticException.class,() -> {int i = 10/0;},"业务逻辑居然执行成功了！");
    }

    @DisplayName("超时断言")
    @Test
    void testTimeoutAssertion(){
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

    @Test
    @DisplayName("快速失败")
    void shouldFail() {
        if (1 == 2){
            fail("测试失败");
        }
    }

    /**
     * 测试前置条件
     */
    @Test
    @DisplayName("测试前置条件")
    void testAssumptionsAssertion(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println(1111);
    }
}
