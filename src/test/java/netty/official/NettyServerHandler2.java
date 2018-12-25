package netty.official;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class NettyServerHandler2 extends ChannelInboundHandlerAdapter {

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
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        //Discard the received data silently
        //ByteBuf是一个引用计数对象实现ReferenceCounted，他就是在有对象引用的时候计数+1，无的时候计数-1，当为0对象释放内存
        String info = (String)msg;
        try {
            System.out.println("NettyServerHandler2:" + info);
        } finally {
            ReferenceCountUtil.release(msg);
        }
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
