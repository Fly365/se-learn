package errectivejava.chapter02.item09;

import java.io.*;

/**
 * effective-java-errectivejava.chapter02.item09
 */
public class TryWithResourceLearn {

    private static final int BUFFER_SIZE = 8 * 1024;

    public static void copy(String src, String dist) throws IOException {
        try(InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dist)){
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0){
                out.write(buf,0,n);
            }
        }
    }


    public static String firstLineOfFile(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            return br.readLine();
        }
    }

}
