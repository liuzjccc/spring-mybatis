package netty.official;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * 当有客户端连接的时候此方法就会触发，此时会记录客户端channel方便以后复用
     * @param ctx
     */
//    @Override
//    public void channelActive(ChannelHandlerContext ctx){
//        ByteBuf buf = Unpooled.copiedBuffer("客户端接入中...".getBytes());
//        ctx.writeAndFlush(buf);
//    }

    /**
     * 当收到对方发来的数据后，就会触发
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf buf = (ByteBuf)msg;
        byte[] data = new byte[buf.readableBytes()];
        buf.readBytes(data);
        System.out.print(new String(data));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
