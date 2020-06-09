package stack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("testCases.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("solutions.txt")));

        try(Scanner sc = new Scanner(file)){
            while(sc.hasNext()){
                String testCase = sc.nextLine();
                if(Utility.parenthesesMatching(testCase)){
                    int soln = Utility.evalPostfix(testCase);
                    bw.write(testCase + " = " + Integer.toString(soln));
                }
                else
                    bw.write(testCase + " = Invalid");
                bw.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        bw.close();

    }
}
