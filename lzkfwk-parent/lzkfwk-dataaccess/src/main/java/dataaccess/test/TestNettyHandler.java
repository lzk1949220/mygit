package dataaccess.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandler.Sharable;

@Sharable
@Component
public class TestNettyHandler extends SimpleChannelInboundHandler<String>{

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		TestCache.cachemap.put("123456789", ctx);
	}

	@Autowired
	private TestFeignDataAnalyseInf dataAnalyse;
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		String str = ctx.hashCode()+ctx.name()+"="+msg;
		System.out.println(str);
		ctx.writeAndFlush(msg);
		String value = dataAnalyse.dataAnalyse(str);
		System.out.println(value);
	}

}
