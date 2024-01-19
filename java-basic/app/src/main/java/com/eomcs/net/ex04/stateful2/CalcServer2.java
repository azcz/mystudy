// stateful 방식의 이점 활용 - 계산기 서버 만들기
package com.eomcs.net.ex04.stateful2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer2 {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");

    ServerSocket ss = new ServerSocket(8888);

    while (true) {
      // stateful을 사용할 때 이점:
      // => 연결되어 있는 동안 클라이언트의 작업 결과를 계속 유지할 수 있다.
      try (Socket socket = ss.accept()) {
        OtherExecution 클라요청독립실행 = new OtherExecution(socket);
        클라요청독립실행.start();
        System.out.println("현재의 실행해서 분리하여 따로 run()메서드를 실행했습니다.");
      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
        System.out.println("다음 클라이언트의 요청을 처리합니다.");
      }
    }
    // ss.close();
  }

  static class OtherExecution extends Thread {

    Socket socket;

    public OtherExecution(Socket socket) {
      // TODO Auto-generated constructor stub
      this.socket = socket;
    }

    @Override
    public void run() {
      // TODO Auto-generated method stub
      try (Socket socket2 = socket;
          DataInputStream in = new DataInputStream(socket.getInputStream());
          PrintStream out = new PrintStream(socket.getOutputStream());) {

        // 작업 결과를 유지할 변수
        int result = 0;

        loop: while (true) {
          String op = in.readUTF();
          int a = in.readInt();

          switch (op) {
            case "+":
              result += a;
              break;
            case "-":
              result -= a;
              break;
            case "*":
              result *= a;
              break;
            case "/":
              result /= a;
              break;
            case "quit":
              break loop;
            default:
              out.println("해당 연산을 지원하지 않습니다.");
              continue;
          }

          out.printf("계산 결과: %d\n", result);
        }
        out.println("Goodbye!");
        super.run();

      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }

    static void processRequest(Socket socket) throws Exception {

    }
  }
}


