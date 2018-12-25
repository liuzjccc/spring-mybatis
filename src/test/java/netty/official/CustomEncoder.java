package netty.official;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class CustomEncoder extends MessageToByteEncoder<CustomData> {

    @Override
    protected void encode(ChannelHandlerContext ctx, CustomData msg, ByteBuf out){
        // 将Message转换成二进制数据
        CustomDataHead customDataHead = msg.getLuckHeader();

        // 这里写入的顺序就是协议的顺序.

        // 写入Header信息
        out.writeInt(customDataHead.getVersion());
        out.writeInt(msg.getContent().length());
        out.writeBytes(customDataHead.getSessionId().getBytes());

        // 写入消息主体信息
        out.writeBytes(msg.getContent().getBytes());
    }
}
