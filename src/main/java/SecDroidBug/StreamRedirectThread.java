/*

It is declared by me that I used some code from https://docs.oracle.com/javase/8/docs/technotes/guides/jpda/trace.html
in this file

*/


package SecDroidBug;

import java.io.*;


class StreamRedirectThread extends Thread {

    private final Reader in;
    private final Writer out;

    private static final int BUFFER_SIZE = 2048;

    /**
     * Set up for copy.
     * @param name  Name of the thread
     * @param in    Stream to copy from
     * @param out   Stream to copy to
     */
    StreamRedirectThread(String name, InputStream in, OutputStream out) {
        super(name);
        this.in = new InputStreamReader(in);
        this.out = new OutputStreamWriter(out);
        setPriority(Thread.MAX_PRIORITY-1);
    }

    /**
     * Copy.
     */
    @Override
    public void run() {
        try {
            char[] cbuf = new char[BUFFER_SIZE];
            int count;
            while ((count = in.read(cbuf, 0, BUFFER_SIZE)) >= 0) {
                out.write(cbuf, 0, count);
            }
            out.flush();
        } catch(IOException exc) {
            System.err.println("Child I/O Transfer - " + exc);
        }
    }
}
