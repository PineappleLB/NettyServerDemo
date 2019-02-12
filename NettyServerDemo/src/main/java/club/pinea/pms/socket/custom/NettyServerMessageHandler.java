package club.pinea.pms.socket.custom;

import club.pinea.pms.common.BaseServerHandler;
import club.pinea.pms.common.IOSession;
import club.pinea.pms.container.GlobalSessionContainer;
import club.pinea.pms.server.handler.ServerHandler;
import io.netty.channel.ChannelHandlerContext;

public class NettyServerMessageHandler extends BaseServerHandler<String>{


	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		logger.info("接收到客户端消息" + msg);
		IOSession session  = GlobalSessionContainer.getIOSession(ctx.hashCode());
		//处理心跳消息
//		if (msg.getCommand() == CmdType.C_S_HEART_VALUE) {
		//log.info("收到IP:" + session.getIp() +"的心跳消息");
		//TODO 返回用户心跳	
		//return;
//		}
		ServerHandler.createServerHandler().receiveMessage(msg, session);
	}
	
}
