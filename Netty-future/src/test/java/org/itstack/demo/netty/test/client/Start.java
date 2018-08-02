package org.itstack.demo.netty.test.client;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelFuture;
import org.itstack.demo.netty.client.ClientSocket;
import org.itstack.demo.netty.future.SyncWrite;
import org.itstack.demo.netty.msg.Request;
import org.itstack.demo.netty.msg.Response;

/**
 * Created by fuzhengwei1 on 2016/10/20.
 * 测试过程先启动服务端 org.itstack.demo.netty.test.server.Start
 */
public class Start {

    private static ChannelFuture future;

    public static void main(String[] args) throws InterruptedException {
        ClientSocket client = new ClientSocket();
        Thread thread = new Thread(client);
        thread.start();
        while (true) {
            try {
                //获取future，线程有等待处理时间
                if (null == future){
                    future = client.getFuture();
                    Thread.sleep(500);
                    continue;
                }
                //构建发送参数
                Response response = new Response();
                response.setResult("查询用户信息");
                SyncWrite s = new SyncWrite();
                Request request = s.writeAndSync(future.channel(), response, 1000);
                System.out.println("调用结果："+JSON.toJSON(request));
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

}
