import java.util.Scanner;

public class JavaEchoServer {

    public static void main(String args[]) throws Exception{
        System.out.print("Please enter text to be echoed:");
        echoInput();
    }

    private static void echoInput() {
        Scanner sc = new Scanner(System.in);
        String echoText = sc.nextLine();
        System.out.print(echoText);
    }
}
