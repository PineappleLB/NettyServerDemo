package club.pinea.pms.message;

public interface NetMessageHandler<T> {
	
	/**
	 * 处理消息的API
	 * @param msg
	 */
	public void doMessage(T msg);

}
