package dataaccess.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

@Sharable
@Component
public class TestNettyChannelInit extends ChannelInitializer<Channel>{
	@Autowired
	private TestNettyHandler hander;
	
	@Override
	protected void initChannel(Channel ch) throws Exception {
		ch.pipeline().addLast(new StringEncoder());
		ch.pipeline().addLast(new StringDecoder());
		ch.pipeline().addLast(hander);
	}

}
