package club.pinea.socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import club.pinea.common.IOSession;
import club.pinea.common.IOSession.SessionType;
import club.pinea.container.GlobalSessionContainer;
import club.pinea.server.handler.ServerHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class NettyServerMessageHandler extends SimpleChannelInboundHandler<String>{

	public static Logger logger = LogManager.getLogger(NettyServerMessageHandler.class);
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		logger.info("有一个客户端连接上来了");
		IOSession session  = GlobalSessionContainer.getIOSession(ctx.hashCode());
		if(session == null){
			session = this.createIOSession(ctx);
			GlobalSessionContainer.addIOSession(session);
		}
	}

	@Override
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
	
	@Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		IOSession session  = GlobalSessionContainer.getIOSession(ctx.hashCode());
		if(session == null){
			session = this.createIOSession(ctx);
			GlobalSessionContainer.addIOSession(session);
		}
		//TODO 处理用户掉线
    }

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error("{}", cause);
		super.exceptionCaught(ctx, cause);
	}
	
	private IOSession createIOSession(ChannelHandlerContext ctx){
		IOSession session = new IOSession();
		session.setContext(ctx);
		session.setType(SessionType.SOCKET);
		return session;
	}
	
}
