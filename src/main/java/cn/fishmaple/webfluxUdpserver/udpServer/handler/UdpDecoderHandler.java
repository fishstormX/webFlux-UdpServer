package cn.fishmaple.webfluxUdpserver.udpServer.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UdpDecoderHandler extends MessageToMessageDecoder<DatagramPacket> implements UdpHandler{


    private static final Logger logger = LoggerFactory.getLogger(UdpDecoderHandler.class);

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> out){
        ByteBuf byteBuf = datagramPacket.content();
        byte[] data = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(data);
        try {

        }catch (Exception e){
            logger.error("消息解析异常");
       //     Cat.logError(e);
        }
    }

    @Override
    public String getHandlerName() {
        return "defaultDecoderHandler";
    }
}