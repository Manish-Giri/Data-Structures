package Chap_4;


/**
 * Created by Manish on 8/30/2015.
 * this is a delimiter matching program that works by reading characters from the string one at a time and placing opening
 * delimiters (when it finds them) on a stack. When it reads a closing delimiters from the input, it pops out the
 * opening delimiter from the top of the stack and attempts to match it with the closing delimiter. If they're not the same type,
 * an error is thrown. Also, for any opening delimiter that does not have a matching opening one, an error is thrown. An unmatched
 * delimiter will always remain in the stack because all matching delimiters would be popped out. Characters that are
 * not delimiters are not pushed on the stack
 * An example of a correct expression: a{b(c[d]e)f}
 * A stack is a good DS to use here because pairs of delimiters that are opened last should be closed first - LIFO!
 */

//Reuse Class StackX1 from ReverseApp.java

import java.io.IOException;

/**
 * Class Bracketchecker is the meat of the application. It uses a stack to read a line of text from the user,
 * creates a bracketchecker object with the text string as arg and uses the check() to parse the string and look for any mismatch
 * in the delimiters. check() reports the number of the character where it finds an error(a mismatch) if any.
 */

class BracketChecker {
    //input string
    private String input;
    //---------------------------------------------------------------------
    //constructor
    public BracketChecker(String in) {
        input = in;
    }

    //---------------------------------------------------------------------
    //the check()
    public void check() {

        //create stack of length = input string
        int stackSize = input.length();
        StackX1 sx1 = new StackX1(stackSize);

        //extract characters from input string one by one
        for(int i = 0; i < stackSize; i++) {

            //obtain current character and evaluate it accordingly
            char ch = input.charAt(i);

            switch (ch) {
                //opening delimiters
                case '{':
                case '[':
                case '(': sx1.push(ch); //push any of these opening delimiters
                          break;

                //closing delimiters
                case '}':
                case ']':
                case ')': //if stack is not currently empty, pop from top and check
                          if(!sx1.isEmpty()) {
                              char chX = sx1.pop();
                              if ((ch == '}' && chX != '{') || (ch == ']' && chX != '[') || (ch == ')' && chX != '(')) {
                                  System.out.println("Error: " + ch + " at position " + i);
                              }

                          }
                          else {
                              //stack prematurely empty
                              System.out.println("Error: " + ch + " at position " + i);
                          }
                          break;
                default: //no action on other characters ie: non delimiters
                         break;
            }
        }

        //all characters have been processed so far, and if the stack is still not empty, there's a missing delimiter in input
        if(!sx1.isEmpty()) {
            System.out.println("Error: Missing right delimiter");
        }

    }
}

public class BracketsApp {

    public static void main(String[] args) throws IOException{
        String input;
        while(true) {
            System.out.println("Enter string containing delimiters");
            System.out.flush();
            //read string from kbd
            input = ReverseApp.getString();
            if(input.equals("")) {
                //quit if [enter]
                break;
            }

            System.out.println("You entered: " + input);

            //create bracketchecker object & check brackets
            BracketChecker checker = new BracketChecker(input);
            checker.check();
        }

    }
}

/*
  Sample output
 "C:\Program Files\Java\jdk1.8.0_60\bin\java" -Didea.launcher.port=7537 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA 14.1.4\bin" -Dfile.encoding=windows-1252 -classpath "C:\Program Files\Java\jdk1.8.0_60\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\rt.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_60\jre\lib\ext\zipfs.jar;C:\Users\Manish\Dropbox\Development\Java\Books\DSA_Robert_Lafore\out\production\Data_Struct_Robert_Lafore;C:\Program Files (x86)\JetBrains\IntelliJ IDEA 14.1.4\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain Chap_4.BracketsApp
 Enter string containing delimiters
 a{b(c)d}
 You entered: a{b(c)d}
 Enter string containing delimiters
 a{b(c]d}e
 You entered: a{b(c]d}e
 Error: ] at position 5
 Enter string containing delimiters


 Process finished with exit code 0
 */