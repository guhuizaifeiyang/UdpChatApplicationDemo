package com.jkxy.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 演示TCP客户端实现程序
 */
public class TcpSendDemo {
    public static void main(String[] argv) throws IOException {
        // 1. 创建客户端socket服务 指定目标地址及端口
        Socket s = new Socket("192.168.0.103", 10002);
        // 2. 通过socket对象向服务器写入数据
        OutputStream out = s.getOutputStream();
        out.write("Hello，服务器！！".getBytes());
        // 2.1 通过socket对象获取服务器返回的数据
        InputStream in = s.getInputStream();
        byte[] buff = new byte[1024];
        int len = in.read(buff);
        String str = new String(buff, 0, len);
        System.out.println("server: " + str);
        // 3. 关闭资源
        s.close();
    }
}
