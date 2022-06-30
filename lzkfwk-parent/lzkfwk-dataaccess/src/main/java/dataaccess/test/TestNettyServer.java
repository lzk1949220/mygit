package dataaccess.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

@Service
public class TestNettyServer implements Runnable{

	@Autowired
	private TestNettyChannelInit chinit;
	
	@Override
	public void run() {
		ServerBootstrap boot = new ServerBootstrap();
		NioEventLoopGroup bossgroup = new NioEventLoopGroup();
		NioEventLoopGroup workgroup = new NioEventLoopGroup();
		boot.group(bossgroup, workgroup);
		boot.channel(NioServerSocketChannel.class);
		boot.childOption(ChannelOption.SO_BACKLOG, 1024);
		boot.childHandler(chinit);
		
		ChannelFuture future = null;
		try {
			future = boot.bind(10050).sync();
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			bossgroup.shutdownGracefully();
			workgroup.shutdownGracefully();
		}
	}

	
}
