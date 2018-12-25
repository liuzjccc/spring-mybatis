package netty.official;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当有客户端连接的时候此方法就会触发，此时会记录客户端channel方便以后复用
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        System.out.println(ctx.channel());
    }

    /**
     * 当收到对方发来的数据后，就会触发
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        //Discard the received data silently
        //ByteBuf是一个引用计数对象实现ReferenceCounted，他就是在有对象引用的时候计数+1，无的时候计数-1，当为0对象释放内存
//        ByteBuf in = (ByteBuf)msg;
        CustomData customData = (CustomData)msg;
        System.out.println(customData.toString());
//        byte[] buff = new byte[in.readableBytes()];
//        try {
//            while(in.isReadable()){
//                in.readBytes(buff);
//                System.out.println("NettyServerHandler1：" + new String(buff));
//                System.out.flush();
//            }
            // 继续保持channelRead方法，否则接下的handler的channelRead方法不发触发
            ctx.fireChannelRead("下一个handler");
//        } finally {
            // 此处不释放，否则接下的handler接收不到信息
//            ReferenceCountUtil.release(msg);
//        }
    }

    /**
     * channelRead执行后触发
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ByteBuf byteBuf = Unpooled.copiedBuffer("服务端收到!", Charset.defaultCharset());
        ctx.channel().writeAndFlush(byteBuf);
    }

    /**
     * 出错时会触发，做一些错误处理
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
