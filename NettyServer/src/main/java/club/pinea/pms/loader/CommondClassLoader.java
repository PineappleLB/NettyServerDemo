package club.pinea.pms.loader;

import club.pinea.pms.annotation.Head;
import club.pinea.pms.clazz.ClassUtils;
import club.pinea.pms.message.NetMessageHandler;
import club.pinea.pms.spring.SpringBeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈加载不同的情景指令〉
 *
 * @author pineapple
 * @create 2019/2/18
 * @since 1.0.0
 */
public class CommondClassLoader {

    /**
     * 指令表
     * <P>
     * 指令号--指令类
     */
    private Map<Long, NetMessageHandler<?>> commandMap = new ConcurrentHashMap<>();

//    private Map<ConstantCmdEnum, IHttpJSONMessage> httpCommandMap = new ConcurrentHashMap<ConstantCmdEnum, IHttpJSONMessage>();

    /** 指令工作包 */
    private String packageName;

    private static Logger log = LoggerFactory.getLogger(CommondClassLoader.class);

    public void destory() {
        commandMap.clear();
//        httpCommandMap.clear();
    }

    /**
     * 获取某个指令
     *
     * @param commandID
     * @return
     */
    public NetMessageHandler<?> get(long commandID) {
        // 查找指令表
        return commandMap.get(commandID);
    }

    /** 加载指令集
     * @throws Exception */
    @SuppressWarnings("unlikely-arg-type")
    public void loadCommands() throws Exception {
        log.debug("加载包：【" + this.packageName +"】下的数据");
        List<Class<?>> _classes = ClassUtils.getClasses(this.packageName);
        for (Class<?> _class : _classes) {
            if (_class.isInterface()) {
                continue;
            }
            // 指令逻辑类
            int index = _class.getName().lastIndexOf(".");
            String beanId = _class.getName().substring(index + 1);
            String firstC = ("" + beanId.charAt(0)).toLowerCase();// 转成小写
            beanId = firstC + beanId.substring(1);
            //	log.error("beanId::"+beanId);
            Object obj = SpringBeanFactory.getInstance().getSpringBean(beanId);
            if ((obj instanceof NetMessageHandler)) {
                NetMessageHandler<?> commandClass = (NetMessageHandler<?>) obj;
                // 指令号
                Long commandID = Long.valueOf(0);
                Annotation defCommandID = _class.getAnnotation(Head.class);
                if (defCommandID != null) {
                    Head info = (Head) defCommandID;
                    commandID = Long.valueOf(info.value());
                } else {
                    if (defCommandID == null) {
                        log.error("指令有错误:::" + _class);
                    }
                }

                if(commandMap.containsKey(commandID)){
                    throw new Exception("协议号【"+commandID+"】已被【"+commandMap.get(commandID).getClass().getName()+"】处理");
                }
                // 添加到指令表
                commandMap.put(commandID, commandClass);
                String msg = "[加载指令] 指令号=" + commandID + ", 处理类=" + commandClass.getClass().getSimpleName();
                log.info(msg);
            }else{
                continue;
            }
        }
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

}
