import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class JavaEchoServerTest {

    private ByteArrayOutputStream stdOut;
    private ByteArrayInputStream stdIn;

    @Before
    public void setUp() throws Exception {
        stdOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOut));

    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
        System.setIn(null);
    }

    @Test
    public void asksForInput() {
        String[] args = {};
        stdIn = new ByteArrayInputStream("\n".getBytes());
        System.setIn(stdIn);

        JavaEchoServer.main(args);
        assertEquals("Please enter text to be echoed:", stdOut.toString());
    }

    @Test
    public void echoInputOnce() {
        String[] args = {};
        stdIn = new ByteArrayInputStream("Echo\n".getBytes());
        System.setIn(stdIn);

        JavaEchoServer.main(args);
        assertEquals("Please enter text to be echoed:Echo", stdOut.toString());


    }
}
