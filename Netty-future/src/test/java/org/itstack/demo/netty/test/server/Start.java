package org.itstack.demo.netty.test.server;

import org.itstack.demo.netty.server.ServerSocket;

/**
 * Created by fuzhengwei1 on 2016/10/20.
 */
public class Start {

    public static void main(String[] args) {
        System.out.println("启动服务端开始");
        Thread t = new Thread(new ServerSocket());
        t.start();
        System.out.println("启动服务端完成");
    }

}
