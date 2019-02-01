import java.io.PrintWriter;

public class CaesarCipher {
  public static void main(String[] args) throws Exception {
  
    if (args.length != 2)
    {
      System.err.println("Incorrect number of parameters. ");
      System.exit(2);
    }
    String action = args[0];
    String input = args[1];
    if (action.equals("encode") == false || action.equals("encode") == false)
    {
      System.err.println("Invalid command. Please enter \"encode\" or \"decode\".");
      System.exit(1);
    }
    
    char[] str = input.toCharArray();
    if (action.equals("encode")) {
      encode(str);
    }
    if (action.equals("decode")) {
      decode(str);
    }
  }
  
  /*
   * Procedure: encode Parameters: str, a character array Produces: void Purpose: Create all 26
   * permutations of Preconditions: str should not be empty
   * 
   * Postconditions:
   * 
   */

  public static void encode(char[] str) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < 26; i++) {
      // Looked up how to copy contents of array into a new one from
      // https://stackoverflow.com/questions/5785745/make-copy-of-an-array
      char[] tempArr = str.clone();

      for (int j = 0; j < tempArr.length; j++) {
        int current = (int) tempArr[j];
        current -= 97;
        current = ((current + i) % 26);
        current += 97;
        tempArr[j] = (char) current;
      }
      String output = new String(tempArr);
      pen.println("n = " + i + ": " + output);
    }
  }

  public static void decode(char[] str) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < 26; i++) {
      char[] tempArr = str.clone();
      for (int j = 0; j < str.length; j++) {
        int current = tempArr[j] - i;
        if (current < 97) {
          current += 26;
        }
        tempArr[j] = (char) current;
      }
      String output = new String(tempArr);
      pen.println("n = " + i + ": " + output);
    }
  }
}
