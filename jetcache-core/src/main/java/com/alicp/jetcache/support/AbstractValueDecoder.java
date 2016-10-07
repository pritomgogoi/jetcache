package com.alicp.jetcache.support;

import com.alicp.jetcache.CacheException;

import java.util.function.Function;

/**
 * Created on 2016/10/4.
 *
 * @author <a href="mailto:yeli.hl@taobao.com">huangli</a>
 */
public abstract class AbstractValueDecoder implements Function<byte[], Object> {

    protected int parseHeader(byte[] buf){
        int x = 0;
        x = x & buf[0];
        x <<= 8;
        x = x & buf[1];
        x <<= 8;
        x = x & buf[2];
        x <<= 8;
        x = x & buf[3];
        return x;
    }

    protected void checkHeader(byte[] buf, int expectedHeader) {
        int x = parseHeader(buf);
        if(x != expectedHeader){
            throw new CacheException("unexpected header");
        }
    }
}