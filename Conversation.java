import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/* Conversation chat box, allow input of number of rounds from user 
and continues to chat with them */

class Conversation {
  public static void main(String[] arguments) {
    //Creating a transcript
    ArrayList<String> transcipt = new ArrayList<String>(); // Create an ArrayList object for transcript

    // Create a Scanner object
    Scanner userInput = new Scanner(System.in);

    //  It will first ask the user to choose a number of rounds of conversation. 
    String rounds = "How many rounds?: ";
    System.out.println(rounds);
    int numRounds = userInput.nextInt();
    userInput.nextLine(); 
        
    // You will start the conversation here.
    String greeting = "Hi there!  What's on your mind?";
    System.out.println(greeting);
    transcipt.add(greeting); //adds the greeting to the transcript

    // loop for number of rounds

    int i = 0; //iterator
    String conversation = ""; //empty strig to hold the chat

    for (int count = 0; count <= numRounds; count++){

        String userResponse = userInput.nextLine();
        transcipt.add(userResponse);

        conversation = "";
        String [] splitWords = userResponse.split(" ");
        String [] userPronouns = {"I", "me", "you", "my", "your", "am", "are"};
        String [] replacePronouns = {"you", "you", "me", "your", "my", "are", "am"};
         //Array of canned responses
        String[] canned = {"Uh-huh", "Interesting!", "Oh wow!", "Mmm-hm.", "Tell me more!"};
        
        Random random = new Random();
        int randomIndex = random.nextInt(canned.length);
        String randomResponse = canned[randomIndex];

        for (int count2 = 0; count2 < splitWords.length; count2++){
            String word = "";

            for (int count3 = 0; count3 < userPronouns.length; count3 ++){
                if (splitWords[count2].equalsIgnoreCase(userPronouns[count3])){
                    i++;
                    word = replacePronouns[count3];
                }
            }
            if (word.equals("")){
                conversation += splitWords + " ";
            } else {
                conversation += word + " ";
            }

        }
        if (i > 0) {
            System.out.println(conversation);
            transcipt.add(conversation); 
        }
        if (i <= 0){
            System.out.println(randomResponse);
            transcipt.add(randomResponse);
    }
        }
        userInput.close();

    System.out.println("Bye Bye!");
    System.out.print(transcipt);
    }
}

//* Sources: .https://www.w3schools.com/java/java_arraylist.asp *//
// https://www.baeldung.com/string/split#:~:text=split(),-Last%20updated%3A%20August&text=The%20method%20split()%20splits,which%20contains%20the%20split%20Strings.
// https://www.w3schools.com/java/ref_string_equalsignorecase.asp#:~:text=The%20equalsIgnoreCase()%20method%20compares,strings%20lexicographically%2C%20ignoring%20case%20differences.
