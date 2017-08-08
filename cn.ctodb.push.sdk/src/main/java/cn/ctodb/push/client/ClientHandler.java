package cn.ctodb.push.client;

import java.io.IOException;

import cn.ctodb.push.dto.Command;
import cn.ctodb.push.dto.Packet;
import io.netty.channel.ChannelInboundHandlerAdapter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;

@Sharable
public class ClientHandler extends ChannelInboundHandlerAdapter {

	/**
	 * tcp链路简历成功后调用
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("成功连接服务器");
		// TextMessage message = new TextMessage();
		// message.setMessage("test");
		// sendMsg(message);
	}

	/**
	 * 收到消息后调用
	 *
	 * @throws IOException
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws IOException {
		Packet packet = (Packet) msg;
		System.out.println(Command.toCMD(packet.getCmd()));
	}

	/**
	 * 发生异常时调用
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		System.err.println("与服务器断开连接:" + cause);
		ctx.close();
	}

}