package club.pinea.pms.message.proto;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import club.pinea.pms.Application;
import club.pinea.pms.message.MessageCTX;
import club.pinea.pms.message.NetMessageHandler;
import club.pinea.pms.message.proto.ProtoBufMessage.Message;
import club.pinea.pms.message.proto.ProtoBufMessage.Message.Builder;
import io.netty.channel.ChannelFutureListener;

public class ProtoBufNetMessageHandler implements NetMessageHandler<MessageCTX> {
	Logger logger = LogManager.getLogger(ProtoBufNetMessageHandler.class);
	public void doMessage(MessageCTX msg) {
		Message message = (ProtoBufMessage.Message)msg.getMessasge();
		long id = message.getId();
		String str = message.getMsg();
		Builder builder = Message.newBuilder();
		builder.setId(id);
		builder.setMsg(str);
		msg.getSession().getContext().writeAndFlush(builder.build()).addListener(ChannelFutureListener.CLOSE);
		int result = Application.flag.incrementAndGet();
		logger.info("当前接收第" + result + "条消息");
	}
}
