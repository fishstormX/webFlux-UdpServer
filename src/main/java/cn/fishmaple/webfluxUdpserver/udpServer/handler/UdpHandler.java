package cn.fishmaple.webfluxUdpserver.udpServer.handler;

import io.netty.channel.ChannelHandler;
import org.springframework.stereotype.Component;

/**
 * @author fishmaple
 * */
@Component
public interface UdpHandler extends ChannelHandler {
    /**
     * 标示HandlerName
     * */
    public String getHandlerName();
}
