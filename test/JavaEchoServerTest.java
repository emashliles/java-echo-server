import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class JavaEchoServerTest {

    @Test
    public void endToEnd() throws IOException {
        Process server = Runtime.getRuntime().exec("java -cp out JavaEchoServer");

        BufferedInputStream serverOutput = new BufferedInputStream(server.getInputStream());
        BufferedInputStream errorOutput = new BufferedInputStream(server.getErrorStream());
        BufferedOutputStream stdIn = new BufferedOutputStream(server.getOutputStream());

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdIn));

        writer.write("Hello");
        writer.flush();
        writer.close();

        int outRead = 0;
        int errorRead = 0;
        byte[] error = new byte[1024];
        byte[] out = new byte[1024];

        while ((errorRead = errorOutput.read(error)) != -1 ){

            String content = new String(error, 0, errorRead);
            assertEquals("?",content );

        }

        while ((outRead = serverOutput.read(out)) != -1 ){

            String content = new String(out, 0, outRead);
            assertEquals("Please enter text to be echoed:Hello",content );

        }
    }
}