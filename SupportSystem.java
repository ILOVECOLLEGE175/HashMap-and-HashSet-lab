import java.util.HashSet;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
/**
 * This class implements a technical support system. It is the top level class 
 * in this project. The support system communicates via text input/output 
 * in the text terminal.
 * 
 * This class uses an object of class InputReader to read input from the user,
 * and an object of class Responder to generate responses. It contains a loop
 * that repeatedly reads input and generates output until the users wants to 
 * leave.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 7.3
 */
public class SupportSystem
{
    private InputReader reader;
    private Responder responder;
    private Random random;
    /**
     * Creates a technical support system.
     */
    public SupportSystem()
    {
        reader = new InputReader();
        responder = new Responder();
    }

    /**
     * Start the technical support system. 
     * This will print a welcome message and enter
     * into a dialog with the user, until the user ends the dialog.
     */    
    public void start()
    {
        boolean finished = false;

        printWelcome();

        while(!finished) {
            HashSet<String> input = reader.getInput();

            if(input.contains("bye")) {
                finished = true;
            }
            else {
                String response = responder.generateResponse(input);
                System.out.println(response);
            }
        }
        printGoodbye();
    }

    /**
     * Print a welcome message to the screen.
     */
    private void printWelcome()
    {
        System.out.println("Welcome to the DodgySoft Technical Support System.");
        System.out.println();
        System.out.println("Please tell us about your problem.");
        System.out.println("We will assist you with any problem you might have.");
        System.out.println("Please type 'bye' to exit our system.");
    }

    /**
     * Print a good-bye message to the screen.
     */
    private void printGoodbye()
    {
        System.out.println("Nice talking to you. Bye...");
    }
    
    public class Responder {
    private HashMap<String, String> responseMap;
    private Random random;
    private String[] defaultResponses = {
        "I'm not sure I understand you.",
        "Can you please rephrase that?",
        "That's interesting. Tell me more.",
        "Let’s stay focused on your problem.",
        "Could you elaborate on that?"
    };

   
    public Responder() {
        responseMap = new HashMap<>();
        random = new Random();
        fillResponsesMap();
    }
    public String generateResponse(HashSet<String> input) {
        for (String word : input) {
            if (responseMap.containsKey(word)) {
                return responseMap.get(word);
            }
        }
        return pickDefaultResponse();
    }
    private void fillResponsesMap() {
        responseMap.put("slow", "Your system might be running too many programs. Try closing some.");
        responseMap.put("crash", "Crashes often happen due to faulty software or hardware issues.");
        responseMap.put("bug", "Please make sure you’ve updated to the latest version.");
        responseMap.put("internet", "Check your network cables or router. It might help to restart them.");
        responseMap.put("freeze", "If it freezes again, try rebooting and checking for software updates.");
        responseMap.put("password", "You can reset your password using the 'Forgot password' option.");
    }
    private String pickDefaultResponse() {
        int index = random.nextInt(defaultResponses.length);
        return defaultResponses[index];
    }
}
}
