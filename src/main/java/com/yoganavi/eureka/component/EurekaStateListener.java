package com.yoganavi.eureka.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EurekaStateListener {
    @EventListener
    public void serverStarted(EurekaServerStartedEvent event) {
        log.info("유레카 서버 시작됨");
    }

    @EventListener
    public void registryAvailable(EurekaRegistryAvailableEvent event) {
        log.info("유레카 registry 사용 가능");
    }

    @EventListener
    public void instanceRegistered(EurekaInstanceRegisteredEvent event) {
        log.info("서비스 등록됨: {}",
                event.getInstanceInfo().getAppName());
    }

    @EventListener
    public void instanceCanceled(EurekaInstanceCanceledEvent event) {
        log.info("서비스 등록 취소됨: {} ({})",
                event.getAppName(),
                event.getServerId());
    }

    @EventListener
    public void instanceRenewed(EurekaInstanceRenewedEvent event) {
        log.debug("서비스 갱신됨: {} ({})",
                event.getAppName(),
                event.getServerId());
    }
}
