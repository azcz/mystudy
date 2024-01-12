package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Assignment;
import java.util.List;

public interface AssignmentDao {

  public void add(Assignment assignment);

  public int delete(int no);

  public List<Assignment> findAll();

  public Assignment findBy(int no);

  public int update(Assignment assignment);

  //private int indexOf(int no);

}
