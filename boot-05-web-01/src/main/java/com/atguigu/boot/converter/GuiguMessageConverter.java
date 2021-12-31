package com.atguigu.boot.converter;

import com.atguigu.boot.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 自定义的Converter
 */
public class GuiguMessageConverter implements HttpMessageConverter<Person> {
    /**
     * 对某个类型的数据进行读操作
     * @param aClass
     * @param mediaType
     * @return
     */
    @Override
    public boolean canRead(Class<?> aClass, MediaType mediaType) {
        return false;
    }

    /**
     * 对某个类型的数据进行写操作
     * @param aClass
     * @param mediaType
     * @return
     */
    @Override
    public boolean canWrite(Class<?> aClass, MediaType mediaType) {
        //判断方法返回的值类型是Person类型
        return aClass.isAssignableFrom(Person.class);
    }

    /**
     * 获取所有支持的媒体类型
     *
     * 服务器要统计所有MessageConverter都能写出哪些内容类型
     *
     * application/x-guigu
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        //吧字符串解析成媒体类型集合
        return MediaType.parseMediaTypes("application/x-guigu");
    }

    @Override
    public List<MediaType> getSupportedMediaTypes(Class<?> clazz) {
        return HttpMessageConverter.super.getSupportedMediaTypes(clazz);
    }

    /**
     * 读
     * @param aClass
     * @param httpInputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    public Person read(Class<? extends Person> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    /**
     * 自定义协议数据的写出
     * @param person
     * @param mediaType
     * @param httpOutputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    public void write(Person person, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        //自定义协议的数据写出
        String data = person.getUserName()+";"+person.getAge()+";"+person.getBirth();

        //写出去
        OutputStream body = httpOutputMessage.getBody();
        body.write(data.getBytes(StandardCharsets.UTF_8));
    }
}
