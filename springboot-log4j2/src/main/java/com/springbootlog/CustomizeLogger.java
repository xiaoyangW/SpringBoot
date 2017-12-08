package com.springbootlog;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.message.MessageFactory;

/**
 * 自定义日志级别
 * @author wxy
 */
public class CustomizeLogger extends Logger{

    private static final Level TRADE = Level.getLevel("Customize");

    protected CustomizeLogger(LoggerContext context, String name, MessageFactory messageFactory) {
        super(context, name, messageFactory);
    }

    /**
     * 输出自定义日志
     * @param message
     */
    public void customize(String message) {
        super.log(TRADE, message);
    }
}
