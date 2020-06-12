package stack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("testCases.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("solutions.txt")));

        try(Scanner sc = new Scanner(file)){    
            while(sc.hasNext()){                    
                String testCase = sc.nextLine();    //reads textfile specified for test cases
                if(Utility.parenthesesMatching(testCase)){
                    int soln = Utility.evalPostfix(testCase);
                    bw.write(testCase + " = " + Integer.toString(soln));    //writes test cases and solutiosn to new text file 
                }
                else
                    bw.write(testCase + " = Invalid");  //if epxression is invalid writes testcase and invlaid to new text file
                bw.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        bw.close();

    }
}
