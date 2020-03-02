package lisr.kis.base.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *  服务上下线监控，可以实现邮件通知等
 * @author admin
 *
 */
@Component
public class EurekaStateChangeListener {
	
	private final Logger loger = LoggerFactory.getLogger(EurekaStateChangeListener.class);
	
	/**
	 * 服务下线事件
	 * @param event
	 */
	@EventListener
	public void listen(EurekaInstanceCanceledEvent event) {
		loger.info(event.getServerId() + " : " + event.getAppName() + "服务下线");
	}
	
	/**
	 * 服务注册事件
	 * @param event
	 */
	@EventListener
	public void listen(EurekaInstanceRegisteredEvent event) {
		loger.info(event.getInstanceInfo().getAppName()+ "进行注册");
	}
	
	/**
	 * 服务续约事件
	 * @param event
	 */
	@EventListener
	public void listen(EurekaInstanceRenewedEvent event) {
		loger.info(event.getServerId() + " : " + event.getAppName() + "进行续约");
	}
	
	/**
	 * 注册中心启动事件
	 * @param event
	 */
	@EventListener
	public void listen(EurekaRegistryAvailableEvent event) {
		loger.info("注册中心启动");
	}
	
	/**
	 * EurekaServer启动事件
	 * @param event
	 */
	@EventListener
	public void listen(EurekaServerStartedEvent event) {
		loger.info("EurekaServer启动");
	}
	
}
