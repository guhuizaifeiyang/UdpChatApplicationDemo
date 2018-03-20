package com.jkxy.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SendApplication implements Runnable{
    private DatagramSocket ds;

    public SendApplication(DatagramSocket ds) {
        this.ds = ds;
    }
    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = br.readLine()) != null) {
                byte[] buf = line.getBytes();
                DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.255"), 10000);
                ds.send(dp);

                if ("886".equals(line)) {
                    break;
                }
            }
            ds.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("发送端异常");
        } finally {
            if (ds != null) {
                ds.close();
            }
        }

    }
}
