package netty.official;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.nio.charset.Charset;
import java.util.UUID;

public class NettyClient {
    private void connect(int port, String host) throws Exception {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        try {
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ClientHandlerInitializer())
                    .option(ChannelOption.TCP_NODELAY, true);
            // 此处会同步等待连接完成
            ChannelFuture future = bootstrap.connect(host, port).sync();
            // 发送消息到服务端，也可以在NettyClientHandler中发送
//            ByteBuf byteBuf = Unpooled.copiedBuffer(" 消息体：hello world!", Charset.defaultCharset());
//            future.channel().writeAndFlush(byteBuf);

            int version = 1;
            String sessionId = UUID.randomUUID().toString();
            String content = "I'm the custom protocol!";

            CustomDataHead customDataHead = new CustomDataHead(version, content.length(), sessionId);
            CustomData message = new CustomData(customDataHead, content);
            future.channel().writeAndFlush(message);

            future.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new NettyClient().connect(8088, "127.0.0.1");
    }
}
