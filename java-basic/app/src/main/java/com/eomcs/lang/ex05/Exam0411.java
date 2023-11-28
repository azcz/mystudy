package com.eomcs.lang.ex05;

// # 비트 이동 연산자 : >>, >>>, <<
//
public class Exam0411 {
  public static void main(String[] args) {
    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);

    // 0111 1111 1111 1111 1111 1111 1111 1010 = 21_4748_3642
    // 1000 0000 0000 0000 0000 0000 0000 0110 = -21_4748_3642

    // 음수를 왼쪽으로 이동할 때는 부호비트에 상관없이 무조건 이동
    int a = -0x7f_ff_ff_fa; // -21_4748_3642
    System.out.println(a); // [10000000000000000000000000000110]
    System.out.println(a << 1); // 1[00000000000000000000000000001100] = 12
    System.out.println(a << 2); // 10[00000000000000000000000000011000] = 24
    System.out.println(a << 3); // 100[00000000000000000000000000110000] = 48
    System.out.println(a << 4); // 1000[00000000000000000000000001100000] = 96

    // 결론!
    // 왼쪽으로 x 만큼 비트를 이동시키는 것은 주어진 양수 대해 2**x 로 곱한 것과 같다.
    // 주의!
    // 음수의 경우는 양수로 바뀔 수 있다.
  }
}


