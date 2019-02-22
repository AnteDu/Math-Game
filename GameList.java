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
/**
 * Stored in a list of singly linked node data structures that is implemented by player
 * @author ante
 *
 * @param <Object>
 */
public class GameList{
  private GameNode list; // reference to the first GameNode in this list
  /**
   * initializes list to start out empty
   */
  public GameList() {
    this.list = null;
  } 
  /**
   * adds the new node to the end of this list
   * @param newNode
   */
  public void addNode(GameNode newNode) {
    if(this.list == null) {//check if it head empty
      this.list = newNode;
    }
    else {//head is not empty
      GameNode last = this.list;
      while(last.getNext() != null)//check begin from nextNode for head
        last = last.getNext();
      last.setNext(newNode); //add newNode after the last one
    }
  } 
  /**
   * only returns true when this list contains a node with the specified number
   * @param gameNode
   * @return
   */
  public boolean contains( int number) {
    GameNode target = this.list;
    while(target != null) {//check from head
      if(target.getNumber() == number) {// then next one after checked one
        return true;
      }
      target = target.getNext();
    }
    return false;
  } 
  /**
   * returns a string with each number in the list separated by " -> "s, and ending with " -> END"
   */
  public String toString() {
    String output = "";
    GameNode each = this.list;
    while(each != null) {// begin from head
      output = output + each.getNumber() + "->" ;// add Node number one by one
      each = each.getNext();
    } 
    return output + "END"; //output the result
  } 
  /**
   * this method scans through this list searching for the first occurrence of a node with the specified number
   * @param number
   * @param operator
   * @throws NullPointerException
   */
  public void applyOperatorToNumber(int number, GameOperator operator)throws NullPointerException {
    GameNode search = this.list;
    while(search != null) {
      if(search.getNumber() == number) {// check number if the specified number
        search.applyOperator(operator);// call method in GameNode
        break;
      }
      search = search.getNext(); //check the next one
    }
  }
}
