package netty.official;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;


public class ClientHandlerInitializer extends ChannelInitializer<Channel> {

    private static final CustomEncoder ENCODER = new CustomEncoder();

    @Override
    protected void initChannel(Channel ch){
        ChannelPipeline pipeline = ch.pipeline();

        // 添加编解码器, 由于ByteToMessageDecoder的子类无法使用@Sharable注解,
        // 这里必须给每个Handler都添加一个独立的Decoder.
        pipeline.addLast(ENCODER);
        pipeline.addLast(new CustomDecoder());

        // 添加逻辑控制层
        pipeline.addLast(new NettyClientHandler());
    }
}
