//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           MATH GAME
// Files:           GameNode, GameList, GameTests, GameApplication
// Course:          300, fall, 2018
//
// Author:          Ante Du
// Email:           adu3@wisc.edu
// Lecturer's Name: Gary
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         None
// Online Sources:  None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Random;
/**
 * used to test GameNode and GameList 
 * @author ante
 *
 */
public class GameTests {
  /**
   * test addNode method
   * @return
   */
  public static boolean test1() {
    boolean pass = false;
    Random rng = new Random();//generate random number
    GameList test1 = new GameList();
    System.out.println(test1);
    test1.addNode(new GameNode(rng));// add to List
    test1.addNode(new GameNode(rng));
    test1.addNode(new GameNode(rng));
    System.out.println(test1);
    return true;
  }
  /**
   * test toString method
   * @return
   */
  public static boolean test2() {
    boolean pass = false;
    Random rng = new Random(123);//generate random number
    GameList test2 = new GameList();
    test2.addNode(new GameNode(rng));// add to List
    test2.addNode(new GameNode(rng));
    test2.addNode(new GameNode(rng));
    System.out.println(test2.toString());// call to String method
    return true;
  }


  /**
   * test setNext method
   * @return
   */
  public static boolean test3() {
    boolean pass = false;
    Random r = new Random(123);
    GameNode test3 = new GameNode(r);
    test3.setNext(test3);
    return true;
  }
  /**
   * test applyOperator Method
   * @return
   */
  public static boolean test4() {
    boolean pass = false;
    Random r = new Random(123);// generate random number
    GameNode test4 = new GameNode(r);
    GameOperator b = null;
    try{
      test4.applyOperator(b);
    }catch(NullPointerException e) {//check null pointer situation
      return true;
    }
    return false;
  }
  /**
   * call the test method
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(test1());
    System.out.println(test2());
    System.out.println(test3());
    System.out.println(test4());
  }

}
