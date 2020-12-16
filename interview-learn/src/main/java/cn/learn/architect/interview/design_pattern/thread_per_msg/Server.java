package cn.learn.architect.interview.design_pattern.thread_per_msg;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * architect-learn
 * User: Fly365
 * Date: 2020/12/15
 * DESC: Socket启动服务
 */
public class Server {
    private static int DEFAULT_PORT = 12345;
    private static ServerSocket server;
    public static void start() throws IOException {
        start(DEFAULT_PORT);
    }
    public static void start(int port) throws IOException {
        if(server != null){
            return;
        }
        try {
            server = new ServerSocket(port);
            while(true){
                Socket socket = server.accept();
                //当有新客户端接入时，会执行下面代码
                long start = System.currentTimeMillis();
                new Thread(new ServerHandler(socket)).start();
                long end = System.currentTimeMillis();
                System.out.println("Spend time is  " + (end - start));
            }
        } finally {
            if(server != null){
                System.out.println("server closed");
                server.close();
            }
        }
    }
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
