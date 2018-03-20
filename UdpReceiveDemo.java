package com.jkxy.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 演示UDP传输协议的接收端程序
 */
public class UdpReceiveDemo {
    public static void main(String[] argv) throws IOException {
        DatagramSocket socket = new DatagramSocket(9527);
        while(true){
            byte[] buff = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buff, buff.length);
            socket.receive(dp);
            String ip = dp.getAddress().getHostAddress();
            String text = new String(dp.getData(), 0, dp.getLength());
            System.out.println("ip:" + ip + "; 发送内容：" + text + "; 端口：" + dp.getPort());
        }
    }
}
