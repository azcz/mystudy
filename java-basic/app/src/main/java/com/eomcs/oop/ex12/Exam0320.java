// 아규먼트에 람다(lambda) 활용 II - 파라미터와 리턴 값이 있는 람다 만들기
package com.eomcs.oop.ex12;

public class Exam0320 {

  static interface Calculator {
    int compute(int a, int b);
  }

  static void test(Calculator c) {
    System.out.println(c.compute(100, 200));
  }

  public static void main(String[] args) {

    // 람다
    // 파라미터와 리턴 값이 있는 메서드 구현하기
    test((a, b) -> a + b);

    // 다시 익명 클래스로 바꾸기
    test(new Calculator() {
      @Override
      public int compute(int a, int b) {
        return a + b;
      }
    });

    // 다시 람다식으로 바꾸기
    test((a, b) -> a + b);

  }

}


