import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class JavaEchoServerTest {

    private ByteArrayOutputStream stdOut;

    @Before
    public void setUp() throws Exception {
        stdOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stdOut));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @Test
    public void serverCanWriteInput() {
        String[] args = {};
        JavaEchoServer.main(args);
        assertEquals("Hello", stdOut.toString());
    }
}
