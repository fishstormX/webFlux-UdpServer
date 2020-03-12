package cn.fishmaple.webfluxUdpserver.udpServer;

import cn.fishmaple.webfluxUdpserver.udpServer.handler.UdpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.List;
@Configuration
public class UdpServer {
    private final String LOCALHOST_ADDRESS = "127.0.0.1";

    @Value("${config.udp-host:default}")
    String udpHost;
    @Value("${config.udp-port:8888}")
    int udpPort;
    @Autowired
    List<UdpHandler> udpHandler;

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Bean
    CommandLineRunner serverRunner(UdpHandler... udpHandler) {
        return strings -> {
            createUdpServer(udpHandler);
        };
    }

    /**
     *
     * 创建UDP Server，传入创建的Handler
     */
    private void createUdpServer(UdpHandler... udpHandlers) {
        String hostAddress = udpHost;

        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.warn("Automatic host is  unavailable,use {}",LOCALHOST_ADDRESS);
            hostAddress = LOCALHOST_ADDRESS;
        }

        try {
            logger.info("Start udp server at {}:{}", hostAddress,udpPort);
            reactor.netty.udp.UdpServer.create()
                    .handle((in, out) -> {
                        in.receive()
                                .asByteArray()
                                .subscribe();
                        return Flux.never();
                    })
                    .host(InetAddress.getLocalHost().getHostAddress())
                    .port(udpPort)
                    .doOnBound(conn -> {
                                for (UdpHandler udpHandler : udpHandlers) {
                                    logger.info("publish a handler:{}",udpHandler.getHandlerName());
                                    conn.addHandler("decoder", udpHandler);
                                 }
                            }
                    )
                    .bindNow(Duration.ofSeconds(30));
        } catch (UnknownHostException e) {
            logger.error("non host");
        }
    }
}
