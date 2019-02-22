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
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 *  implement the game demonstrated in the log at the top of this write-up.
 * @author ante
 *
 */
public class GameApplication {
  Random r = new Random();// random r
  GameList a ;//GameList
  Scanner scnr = new Scanner(System.in);//scan in
  int count;// move count
  boolean over;// check if is over
  int goal;// target number
  String []sub = new String[2];// build string array to store number and operator sperately
  GameOperator n;// GameOperator
  public String m; 
  /**
   * Constructor which used to initial value
   */
  public GameApplication() {
    a = new GameList();
    count = 0;// initial move count
    over = false;
    goal = r.nextInt(89)+11; // build random target number
    for(int i = 0; i <7; i++) { //create 7 randomly number
      a.addNode(new GameNode(r));
    }

  }
  /**
   * main method used to call other method
   * @param args
   */
  public static void main(String[] args) {
    GameApplication s = new GameApplication();
    s.application();//call application method
  }
  /**
   * method used to let main method implement the game demonstrated in the log 
   */
  public void application() {
    String[]prompt = new String[] {"Welcome to the game: ","Goal:", "Moves Taken: ", 
        "Puzzle:", "Number and Operation [+,-,x,/,&,^] to Apply: "};
    System.out.println(prompt[0]);
    while(!over) {// check if it is can be run
      System.out.println(prompt[1] + goal);// get target number
      System.out.print(prompt[2] + count);// get move count
      System.out.println(prompt[3] + a.toString() );// get NodeList
      System.out.println(prompt[4]);
      try {
        while(!scnr.hasNextLine());//check if there is null pointer
        this.m = scnr.nextLine();//scan in
        over = Type();// call Type method
        if(over == true) {
          break;
        }
        n = GameOperator.getFromChar(sub[1].charAt(0));//get the operator
        Move();// call move method
      }
      catch(NullPointerException e) {// check and know if there exist problem
        e.printStackTrace();
        System.out.println("Warning: Null Pointer: "+e.getMessage());
      }
      over = End();//call End method
    } 
    /**
     * check if specified number exist, if it is call applyOperatorNumber method and add new Node,
     * then move count plus one
     */
  }
  public void Move() {
    if(a.contains(Integer.parseInt(sub[0]))){//check if specified number exist
      a.applyOperatorToNumber(Integer.parseInt(sub[0]),n);//add Node and next Node togethor
      a.addNode(new GameNode(r));// add new Node
      count++; 
    }  
    else {
      System.out.println("Warning: Number not exist. Please re-enter.");
    }
  }
  /**
   * Check if player want to leave
   * @return
   */
  public boolean Type() {
    if(m.toUpperCase().equals("QUIT")) {// to make sure each kind of character
      System.out.println("Goodbye!");
      return true;
    }
    else {
      int commandLength = m.length();//get command length
      sub[0]= m.substring(0,commandLength-1);//seperate the command to number and operator
      sub[1]= m.substring(commandLength-1, commandLength);
    }
    return false;
  }
  /**
   * check if player get the target number
   * @return
   */
  public boolean End() {
    if(a.contains(goal)) {//check if specifies number exist
      System.out.println("Congratulations, you win the game!");
      System.out.println("Solution: " + a.toString());//output the ListNode
      return true;
    }
    return false;
  }
}
