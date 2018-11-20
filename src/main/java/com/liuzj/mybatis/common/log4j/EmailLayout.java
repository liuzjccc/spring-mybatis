package com.liuzj.mybatis.common.log4j;

import org.apache.log4j.Layout;
import org.apache.log4j.spi.LoggingEvent;

public class EmailLayout extends Layout {

    private StringBuffer sbuf;

    public EmailLayout(){
        sbuf = new StringBuffer(128);
    }

    @Override
    public String format(LoggingEvent event) {
        sbuf.append("错误等级："+event.getLevel().toString()+"<br>");
        sbuf.append("错误原因："+event.getMessage().toString()+"<br>");
        sbuf.append("错误的类："+event.getLocationInformation().getClassName()+"<br>");
        sbuf.append("错误方法："+event.getLocationInformation().getMethodName()+"<br>");
        sbuf.append("错误位置："+event.getLocationInformation().getLineNumber()+"行");
        return sbuf.toString();
    }

    @Override
    public boolean ignoresThrowable() {
        return false;
    }

    @Override
    public void activateOptions() {
    }

    @Override
    public String getContentType()
    {
        return "text/html;charset=utf-8";
    }
}
