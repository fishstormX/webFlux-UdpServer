// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: testMsg.proto

package cn.fishmaple.webfluxUdpserver.proto;

public final class TestMsgProto {
  private TestMsgProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface TestMsgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:TestMsg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     *{数据类型} {数据列名} = {数据id}
     * </pre>
     *
     * <code>optional int32 id = 1;</code>
     */
    int getId();

    /**
     * <code>optional string msgName = 2;</code>
     */
    String getMsgName();
    /**
     * <code>optional string msgName = 2;</code>
     */
    com.google.protobuf.ByteString
        getMsgNameBytes();
  }
  /**
   * <pre>
   *Proto实体名，不能与类名相同
   * </pre>
   *
   * Protobuf type {@code TestMsg}
   */
  public  static final class TestMsg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:TestMsg)
      TestMsgOrBuilder {
    // Use TestMsg.newBuilder() to construct.
    private TestMsg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private TestMsg() {
      id_ = 0;
      msgName_ = "";
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private TestMsg(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              id_ = input.readInt32();
              break;
            }
            case 18: {
              String s = input.readStringRequireUtf8();

              msgName_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return TestMsgProto.internal_static_TestMsg_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return TestMsgProto.internal_static_TestMsg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              TestMsgProto.TestMsg.class, TestMsgProto.TestMsg.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private int id_;
    /**
     * <pre>
     *{数据类型} {数据列名} = {数据id}
     * </pre>
     *
     * <code>optional int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }

    public static final int MSGNAME_FIELD_NUMBER = 2;
    private volatile Object msgName_;
    /**
     * <code>optional string msgName = 2;</code>
     */
    public String getMsgName() {
      Object ref = msgName_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        msgName_ = s;
        return s;
      }
    }
    /**
     * <code>optional string msgName = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMsgNameBytes() {
      Object ref = msgName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        msgName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (id_ != 0) {
        output.writeInt32(1, id_);
      }
      if (!getMsgNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, msgName_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (id_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, id_);
      }
      if (!getMsgNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, msgName_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof TestMsgProto.TestMsg)) {
        return super.equals(obj);
      }
      TestMsgProto.TestMsg other = (TestMsgProto.TestMsg) obj;

      boolean result = true;
      result = result && (getId()
          == other.getId());
      result = result && getMsgName()
          .equals(other.getMsgName());
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId();
      hash = (37 * hash) + MSGNAME_FIELD_NUMBER;
      hash = (53 * hash) + getMsgName().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static TestMsgProto.TestMsg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static TestMsgProto.TestMsg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static TestMsgProto.TestMsg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static TestMsgProto.TestMsg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static TestMsgProto.TestMsg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static TestMsgProto.TestMsg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static TestMsgProto.TestMsg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static TestMsgProto.TestMsg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static TestMsgProto.TestMsg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static TestMsgProto.TestMsg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(TestMsgProto.TestMsg prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * <pre>
     *Proto实体名，不能与类名相同
     * </pre>
     *
     * Protobuf type {@code TestMsg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:TestMsg)
        TestMsgProto.TestMsgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return TestMsgProto.internal_static_TestMsg_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return TestMsgProto.internal_static_TestMsg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                TestMsgProto.TestMsg.class, TestMsgProto.TestMsg.Builder.class);
      }

      // Construct using cn.fishmaple.webfluxUdpserver.proto.TestMsgProto.TestMsg.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        id_ = 0;

        msgName_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return TestMsgProto.internal_static_TestMsg_descriptor;
      }

      public TestMsgProto.TestMsg getDefaultInstanceForType() {
        return TestMsgProto.TestMsg.getDefaultInstance();
      }

      public TestMsgProto.TestMsg build() {
        TestMsgProto.TestMsg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public TestMsgProto.TestMsg buildPartial() {
        TestMsgProto.TestMsg result = new TestMsgProto.TestMsg(this);
        result.id_ = id_;
        result.msgName_ = msgName_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof TestMsgProto.TestMsg) {
          return mergeFrom((TestMsgProto.TestMsg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(TestMsgProto.TestMsg other) {
        if (other == TestMsgProto.TestMsg.getDefaultInstance()) return this;
        if (other.getId() != 0) {
          setId(other.getId());
        }
        if (!other.getMsgName().isEmpty()) {
          msgName_ = other.msgName_;
          onChanged();
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        TestMsgProto.TestMsg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (TestMsgProto.TestMsg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int id_ ;
      /**
       * <pre>
       *{数据类型} {数据列名} = {数据id}
       * </pre>
       *
       * <code>optional int32 id = 1;</code>
       */
      public int getId() {
        return id_;
      }
      /**
       * <pre>
       *{数据类型} {数据列名} = {数据id}
       * </pre>
       *
       * <code>optional int32 id = 1;</code>
       */
      public Builder setId(int value) {

        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *{数据类型} {数据列名} = {数据id}
       * </pre>
       *
       * <code>optional int32 id = 1;</code>
       */
      public Builder clearId() {

        id_ = 0;
        onChanged();
        return this;
      }

      private Object msgName_ = "";
      /**
       * <code>optional string msgName = 2;</code>
       */
      public String getMsgName() {
        Object ref = msgName_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          msgName_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string msgName = 2;</code>
       */
      public com.google.protobuf.ByteString
          getMsgNameBytes() {
        Object ref = msgName_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          msgName_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string msgName = 2;</code>
       */
      public Builder setMsgName(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }

        msgName_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string msgName = 2;</code>
       */
      public Builder clearMsgName() {

        msgName_ = getDefaultInstance().getMsgName();
        onChanged();
        return this;
      }
      /**
       * <code>optional string msgName = 2;</code>
       */
      public Builder setMsgNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);

        msgName_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:TestMsg)
    }

    // @@protoc_insertion_point(class_scope:TestMsg)
    private static final TestMsgProto.TestMsg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new TestMsgProto.TestMsg();
    }

    public static TestMsgProto.TestMsg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TestMsg>
        PARSER = new com.google.protobuf.AbstractParser<TestMsg>() {
      public TestMsg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new TestMsg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<TestMsg> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<TestMsg> getParserForType() {
      return PARSER;
    }

    public TestMsgProto.TestMsg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_TestMsg_descriptor;
  private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_TestMsg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rtestMsg.proto\"&\n\007TestMsg\022\n\n\002id\030\001 \001(\005\022\017" +
      "\n\007msgName\030\002 \001(\tB3\n#cn.fishmaple.webfluxU" +
      "dpserver.protoB\014TestMsgProtob\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_TestMsg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_TestMsg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_TestMsg_descriptor,
        new String[] { "Id", "MsgName", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}