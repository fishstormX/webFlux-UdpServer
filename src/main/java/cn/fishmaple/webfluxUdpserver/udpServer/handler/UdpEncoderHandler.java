package cn.fishmaple.webfluxUdpserver.udpServer.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UdpEncoderHandler extends MessageToMessageEncoder implements UdpHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(UdpEncoderHandler.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, Object o, List list) throws Exception {

    }


    @Override
    public String getHandlerName() {
        return null;
    }
}
