import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class JavaEchoServer {

    public static void main(String args[]) {
        echoInput(new PrintStream(System.out), System.in);
    }

    public static void echoInput(PrintStream stdOut, InputStream stdIn) {
        stdOut.print("Please enter text to be echoed:");
        Scanner sc = new Scanner(stdIn);
        String echoText = sc.nextLine();
        stdOut.print(" " + echoText);
    }
}