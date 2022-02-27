import java.util.ArrayList;
import java.util.Scanner;

public class assignment {

    static boolean lights = false;

    static String yikes = "This is program is to test the string method to find comments\n" +
            "this is not a comment\n" +
            "/* this is a comment */\n" +
            "this is not a comment\n" +
            "/*\n" +
            "this is a broken comment into four lines\n" +
            "and it has a second line in between\n" +
            "*/\n" +
            "/* */";


    public static void main(String[] args){
        Scanner sc = new Scanner(yikes);
        ArrayList<String> finalList = new ArrayList<>();
        ArrayList<String> currentCom = new ArrayList<>();


        while(sc.hasNext()){
            readCComment(sc.nextLine(), finalList, currentCom);
        }
        System.out.println(finalList);
        System.out.println("Comment Count: " + finalList.size());


    }


    public static void readCComment(String input, ArrayList<String> list, ArrayList<String> currComm){
        if(input.startsWith("/*")){
            if (input.endsWith("*/")){
                list.add(input.substring(2, input.length() - 2));
            }
            else{
                lights = true;
                currComm.add(input.substring(2));
            }
        }
        else if(lights){
            if (input.endsWith("*/")) {
                currComm.add(input.substring(0, input.length()-2));
                StringBuilder curr = new StringBuilder();
                for (String x : currComm){
                    curr.append(x).append(" ");
                }
                currComm.clear();
                list.add(curr.toString());
                lights = false;
            }
            else{
                currComm.add(input);
            }
        }
    }
}
