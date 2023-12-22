// 인터페이스 - 호출 규칙(사용 규칙)을 정의하는 문법
package com.eomcs.oop.ex09.a2.after;

// 인터페이스
// => 사용자(클래스)와 도구(클래스) 사이의 호출 규칙을 정의할 때 사용한다.
// => 도구를 사용하기 위해 어떤 메서드를 호출해야 하는지 정의하는 것이다.
//
public interface Spec {

  // 호출 규칙을 정의할 때,
  // => 규칙은 공개되어야 하기 때문에 무조건 public 이다.
  // => 규칙이기 때문에 당장 구현할 필요는 없다. 그래서 추상 메서드이다.
  public abstract void m1();

  // 물론 다음과 같이 public 과 abstract를 모두 생략할 수 있다.
  // void m2();
}


