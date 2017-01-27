import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class JavaEchoServerTest {

    @Test
    public void canEchoInput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream outPrint = new PrintStream(out);

        ByteArrayInputStream in = new ByteArrayInputStream("Echo".getBytes());

        JavaEchoServer.echoInput(new PrintStream(outPrint), in);
        assertEquals("Please enter text to be echoed: Echo", out.toString());
    }
}
