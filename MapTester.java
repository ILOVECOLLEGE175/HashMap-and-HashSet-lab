import java.util.HashMap;
/**
 * Write a description of class MapTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapTester
{
    // instance variables - replace the example below with your own
    private HashMap <String, String> phoneBook;
    
    public MapTester() {
        phoneBook = new HashMap();
 }
    
     public void enterNumber(String name, String number) {
        phoneBook.put(name, number);
        System.out.println("Added " + name + ": " + number + " to the phone book.");
}
public String lookupNumber(String name) {
        String number = phoneBook.get(name);
        if (number != null) {
            System.out.println(name + "'s number is: " + number);
            return number;
        } else {
            System.out.println(name + " not found in the phone book.");
            return null;
        }
    }
}



 