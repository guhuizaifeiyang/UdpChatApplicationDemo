package com.jkxy.demo;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatApplication {
    public static void main(String[] argv) throws SocketException {
        DatagramSocket send = new DatagramSocket();
        DatagramSocket rece = new DatagramSocket(10000);

        new Thread(new SendApplication((send))).start();
        new Thread(new ReceiveApplication((rece))).start();

    }
}
