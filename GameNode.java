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
 * represents a single number within this linked list and must include exactly the following 
 * private fields and public methods and constructors
 * @author ante
 *
 */
public class GameNode {

  private int number;    // the number held within this node
  private GameNode next; // the next GameNode in the list, or null for the last node
  /**
   * initializes number to random 1-9 value, and next to null
   * @param rng
   */
  public GameNode(Random rng) {
    rng = new Random();
    this.number = rng.nextInt(9) + 1;
    next = null;
  } 
  /**
   * accessor for the number field
   * @return
   */
  public int getNumber() {
    return this.number;
  } 
  /**
   * accessor for the next field
   * @return
   */
  public GameNode getNext() {
    return this.next;
  } 
  /**
   * mutator for the next field
   * @param next
   */
  public void setNext(GameNode next) {
    this.next = next;
  } 
  /**
   * Call this method on a GameNode changes that nodes number and next fields.  
   * @param operator
   * @throws NullPointerException
   */
  public void applyOperator(GameOperator operator)throws NullPointerException {
    if(this.next != null) {
      int nextNode = this.next.getNumber();
      number = operator.apply(this.getNumber(), nextNode);// call method in GameOperator
      this.setNext(this.getNext().getNext());// remove second Node number
    }
    else {
      throw new NullPointerException();
    }

  } 

}
