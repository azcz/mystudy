package bitcamp.myapp.handler.assignment;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.vo.Assignment;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class AssignmentAddHandler extends AbstractMenuHandler {

  private ArrayList<Assignment> objectRepository;


  public AssignmentAddHandler(ArrayList<Assignment> objectRepository, Prompt prompt) {
    super(prompt);
    this.objectRepository = objectRepository;
  }

  @Override
  protected void action() {

    try {
//    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
      //AbstractMenuHandler에 선언된 action() 추상 메서드를 구현한다.
      Assignment assignment = new Assignment();
      assignment.setTitle(this.prompt.input("과제명? "));
      assignment.setContent(this.prompt.input("내용? "));
      assignment.setDeadline(this.prompt.inputDate("제출 마감일? (YYYY-MM-DD): "));

      this.objectRepository.add(assignment);
    } catch (Exception e) {
      System.out.println("과제입력중오류발생했읍니다. 마감일을제대로입력하시기바랍니다.");
    }

  }
}
