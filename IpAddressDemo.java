package com.jkxy.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 演示IP对象的具体使用
 */
public class IpAddressDemo {
    public static void main(String[] argv) throws UnknownHostException {
        InetAddress ip = InetAddress.getByName("www.sina.com.cn");    // 构建IP对象
        System.out.println("ip地址: "+ip.getHostAddress());
        System.out.println("主机名: "+ip.getHostName());
    }
}
