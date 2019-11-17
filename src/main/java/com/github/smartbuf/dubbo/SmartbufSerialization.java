package com.github.smartbuf.dubbo;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.serialize.ObjectInput;
import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.alibaba.dubbo.common.serialize.Serialization;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author sulin
 * @since 2019-11-15 14:42:02
 */
public class SmartbufSerialization implements Serialization {

    private static final byte CONTENT_TYPE = 10;

    public byte getContentTypeId() {
        return CONTENT_TYPE;
    }

    public String getContentType() {
        return "x-application/smartbuf";
    }

    public ObjectOutput serialize(URL url, OutputStream outputStream) {
        return new SmartbufObjectOutput(url, outputStream);
    }

    public ObjectInput deserialize(URL url, InputStream inputStream) {
        return new SmartbufObjectInput(url, inputStream);
    }

}
