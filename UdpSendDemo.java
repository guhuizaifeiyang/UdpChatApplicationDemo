package com.jkxy.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 演示UDP传输协议的发送端程序
 */
public class UdpSendDemo {
    public static void main(String[] argv) throws IOException {
        // 建立udp socket服务
        DatagramSocket socket = new DatagramSocket(8888);

        // 准备需要发送的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            byte[] buff = line.getBytes(); // 数据转换成字节数组
            // 将需要发送的数据封装成数据包
            DatagramPacket dp = new DatagramPacket(buff, buff.length, InetAddress.getByName("192.168.0.103"),9527);
            // 调用send方法将数据包发送
            socket.send(dp);
            if ("886".equals(line)) {
                break;
            }
        }

        // 关闭资源
        socket.close();
    }
}
