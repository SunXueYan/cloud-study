package com.spring.config;/**
 * Created by sunxueyan on 2020/5/19.
 */

/**
 * @ClassName JavaChallenge2
 * @Description: TODO
 * @Author sunxueyan
 * @Date 2020/5/19
 * @Version V1.0
 **/
public class JavaChallenge2 {
//    static  String finalResult = "";
//    public static void main(String... args){
//        executeAction(1, true);//object。。。
//        executeAction();//StackOverflowError。。。 继承object
//        executeAction(new int[]{1,2,3},1);//Object。。。
//        executeAction(1L);//double 不选择Long 是因为引用类型
//        executeAction(1);//double
//        executeAction(Double.valueOf(1));//Object 不选择double是因为参数为引用类型Double
//
//        System.out.println(finalResult);
//    }
//
//    static void executeAction(Object o){finalResult += "1";}
//    static void executeAction(Object... o){finalResult += "2";}
//    static void executeAction(StackOverflowError... i){finalResult += "3";}
//    static void executeAction(Long l){finalResult += "4";}
//    static void executeAction(double d){finalResult += "5";}




    static String x = "";
    public static void main(String... doYourBest) {
        executeAction3(1);
        executeAction1(1.0);
//        executeAction2(Double.valueOf("5"));
//        executeAction3(1L);

        System.out.println(x);
    }
    static void executeAction(int ... var) {x += "a"; }
    static void executeAction(Integer var) {x += "b"; }
    static void executeAction2(Object var) {x += "c"; }
    static void executeAction(short var) {x += "d"; }
    static void executeAction3(float var) {x += "e"; }
    static void executeAction1(double var) {x += "f"; }
}
