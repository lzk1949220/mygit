package devices.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class TestDevice {
	public static void main(String[] args) {
		TestDevice ec = new TestDevice();
		ec.start("127.0.0.1", 10050);
	}
	
	private void start(String inetHost,int inetPort) {
		Bootstrap boot = new Bootstrap();
		NioEventLoopGroup group = new NioEventLoopGroup();
		boot.group(group);
		boot.channel(NioSocketChannel.class);
		boot.option(ChannelOption.SO_KEEPALIVE, true);
		boot.handler(new ChannelClientInit());
		ChannelFuture future = null;
		try {
			future = boot.connect(inetHost, inetPort).sync();
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}
		
	}
}

class ChannelClientInit extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast(new StringEncoder());
		ch.pipeline().addLast(new StringDecoder());
		ch.pipeline().addLast(new EchoClientHandler());
	}
	
}

class EchoClientHandler extends SimpleChannelInboundHandler<String>{

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ChannelFuture cf = ctx.writeAndFlush("hello");
		cf.addListener(new ChannelFutureListener(){//监听消息是否被写完
			public void operationComplete(ChannelFuture future) throws Exception {
				if(future.isSuccess()) {
					System.out.println("write success");
				}else {
					System.out.println("write failed");
					future.cause().printStackTrace();
				}
			}
			
		});
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println(msg);
	}
	
}
