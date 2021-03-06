package smcenter.lisenter;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.netflix.appinfo.InstanceInfo;

@Component
public class EurekaStateChangeListener {

	@EventListener
	public void listen(EurekaInstanceCanceledEvent event) {
		System.err.println(event.getServerId() + "\t" + event.getAppName() + "服务下线");
	}

	@EventListener
	public void listen(EurekaInstanceRegisteredEvent event) {
		InstanceInfo instanceinfo = event.getInstanceInfo();
		System.err.println(instanceinfo.getAppName() + "进行注册 ");

	}

	@EventListener
	public void sten(EurekaInstanceRenewedEvent event) {
		System.err.println(event.getServerId() + " \t " + event.getAppName() + "服务进行续约");
	}

	@EventListener
	public void listen(EurekaRegistryAvailableEvent event) {
		System.err.println("注册中心启动");
	}

	@EventListener
	public void listen(EurekaServerStartedEvent event) {
		System.err.println("EurekaServer 启动");
	}
}
