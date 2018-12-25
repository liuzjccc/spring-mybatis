package netty.official;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class CustomDecoder extends ByteToMessageDecoder {

     @Override
     protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out){
         // 获取协议的版本
         int version = buffer.readInt();
         // 获取消息长度
         int contentLength = buffer.readInt();
         // 获取SessionId
         byte[] sessionByte = new byte[36];
         buffer.readBytes(sessionByte);
         String sessionId = new String(sessionByte);

         // 组装协议头
         CustomDataHead customDataHead = new CustomDataHead(version, contentLength, sessionId);

         // 读取消息内容
         byte[] data = new byte[buffer.readableBytes()];
         buffer.readBytes(data);

         CustomData message = new CustomData(customDataHead, new String(data));

         out.add(message);
     }
 }
