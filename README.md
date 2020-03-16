# webFlux-UdpServer introduction 1.0.0
[English Documentation](https://github.com/fishstormX/webFlux-UdpServer/blob/master/README-EN.md)

基于netty容器快速创建udp服务，并利用protobuf序列化
## Quick start
基于此项目，可以快速启动一个udp服务器实例
1. 编辑一个Handler并实现UdpHandler方法，为getHandlerName()返回一个表示Handler name的String，可以参考handler包下的示例。
2. 

## Do it self
1. 引入相关依赖，可以直接引入webflux的starter，本项目基于reactor项目，原则上只要引入reactor依赖即可：
   ```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
   ```
2. 定义proto的数据类型，编写相关的proto文件，以此项目为例：
    src/main/proto/testMsg.proto
    ```proto
    syntax = "proto3"; // 指定使用 proto3 语法
    option java_package = "proto";    //构建的proto类生成的包,因为构建在target目录，所以此目录无所谓
    option java_outer_classname = "TestMsgProto";        //构建的类名
    message TestMsg {                    //Proto实体名，不能与类名相同
        int32 id = 1;              //{数据类型} {数据列名} = {数据id}
        string msgName = 2;
    }
    ```
    引入protobuf依赖和proto构建插件
    ```xml
            <dependency>
                <groupId>com.google.protobuf</groupId>
                <artifactId>protobuf-java</artifactId>
                <version>3.11.4</version>
            </dependency>
            <!--      ……      -->
            <build>
                    <extensions>
                        <extension>
                            <groupId>kr.motd.maven</groupId>
                            <artifactId>os-maven-plugin</artifactId>
                            <version>1.4.1.Final</version>
                        </extension>
                    </extensions>
                    <plugins>
                        <plugin>
                            <groupId>org.xolstice.maven.plugins</groupId>
                            <artifactId>protobuf-maven-plugin</artifactId>
                            <version>0.5.0</version>
                            <configuration>
                                <protocArtifact>
                                    com.google.protobuf:protoc:3.1.0:exe:${os.detected.classifier}
                                </protocArtifact>
                                <pluginId>grpc-java</pluginId>
                            </configuration>
                            <executions>
                                <execution>
                                    <goals>
                                        <goal>compile</goal>
                                        <goal>compile-custom</goal>
                                    </goals>
                                </execution>
                            </executions>
                        </plugin>
                    </plugins>
             </build>
    ```
3. 利用插件（上文中pom中的插件）或是直接利用可执行文件生成相应的Java类：
    执行 mavn protubuf:compile , 并在target/generated-sources/protobuf/java目录下找到生成的Java类，并移动到指定目录下
4. 创建udpServer相应的Handler,注册为bean例如:
    ```java
       @Service
       public class UdpCommonHandler  extends ChannelInboundHandlerAdapter implements UdpHandler{
           Logger log = LoggerFactory.getLogger(this.getClass());
           @Override
           public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
               String  preHandlerAfferentMsg = (String)msg; //得到消息后，可根据消息类型分发给不同的service去处理数据
               log.info("{}preHandler传入的数据{}"+preHandlerAfferentMsg);
               log.info("channelRead");
               ctx.writeAndFlush("test Msg"); //返回数据给UDP Client
           }
       
           @Override
           public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
               log.info("channelRegistered");
               ctx.fireChannelRegistered();
           }
       
           @Override
           public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
               log.info("channelUnregistered");
               ctx.fireChannelUnregistered();
           }
       
           @Override
           public void channelActive(ChannelHandlerContext ctx) throws Exception {
               log.info("channelActive");
               ctx.fireChannelActive();
           }
       
           @Override
           public void channelInactive(ChannelHandlerContext ctx) throws Exception {
               log.info("channelInactive");
               ctx.fireChannelInactive();
           }
       
           @Override
           public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
               log.info("channelReadComplete");
               ctx.fireChannelReadComplete();
           }
       
           @Override
           public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
               log.info("userEventTriggered");
               ctx.fireUserEventTriggered(evt);
           }
       
           @Override
           public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
               log.info("channelWritabilityChanged");
               ctx.fireChannelWritabilityChanged();
           }
       
           @Override
           public String getHandlerName() {
               return "commonHandler";
           }
       }
    ```
5. 创建一个最基础的udpServer，例如：
   ```java
   @Configuration
   public class UdpServer {
       @Autowired
       UdpHandler udpHandler;
       String udpPort = 8888;
   
       Logger logger = LoggerFactory.getLogger(this.getClass());
       @Bean
       CommandLineRunner serverRunner(UdpHandler udpHandler) {
           return strings -> {
               createUdpServer(udpHandler);
           };
       }
   
       /**
        *
        * 创建UDP Server，传入创建的Handler
        */
       private void createUdpServer(UdpHandler udpHandler) {
   
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
                                     logger.info("publish a handler:default");
                                     conn.addHandler("default", udpHandler);
                               }
                       )
                       .bindNow(Duration.ofSeconds(30));
           } catch (UnknownHostException e) {
               logger.error("non host");
           }
       }
   }

   ```