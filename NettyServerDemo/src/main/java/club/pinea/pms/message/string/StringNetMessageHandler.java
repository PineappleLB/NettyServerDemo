package club.pinea.pms.message.string;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import club.pinea.pms.Application;
import club.pinea.pms.message.MessageCTX;
import club.pinea.pms.message.NetMessageHandler;
import io.netty.channel.ChannelFutureListener;

public class StringNetMessageHandler implements NetMessageHandler<MessageCTX> {

	Logger logger = LogManager.getLogger(StringNetMessageHandler.class);
	
	public void doMessage(MessageCTX message) {
		Object str = message.getMessasge();
		//返回消息并关闭通道
		message.getSession().getContext().writeAndFlush(str).addListener(ChannelFutureListener.CLOSE);
		int result = Application.flag.incrementAndGet();
		logger.info("当前接收第" + result + "条消息");
	}

}
