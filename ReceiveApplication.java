package com.jkxy.demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveApplication implements Runnable{
    private DatagramSocket ds;

    public ReceiveApplication(DatagramSocket ds) {
        this.ds = ds;
    }
    @Override
    public void run() {
        try {
            while (true) {
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                ds.receive(dp);
                String ip = dp.getAddress().getHostAddress();
                String text = new String(dp.getData(), 0, dp.getLength());
                System.out.println("ip: " + ip + ", 发送数据: " + text);
                if ("886".equals(text)) {
                    System.out.println(ip + "退出了聊天室");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("接收端接收异常");
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}
