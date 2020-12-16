package cn.learn.architect.interview.design_pattern.thread_per_msg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/15
 * DESC: IO处理
 */
public class ServerHandler implements Runnable {
    private Socket socket;
    public ServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;
        String msg = null;
        try{
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(),true);
            while((msg = br.readLine()) != null && msg.length() != 0){
                System.out.println("server receiver: " + msg);
                pw.print("received~\n");
                pw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(pw != null){
                try {
                    pw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
