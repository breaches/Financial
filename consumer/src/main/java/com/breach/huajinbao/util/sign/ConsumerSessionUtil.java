package com.breach.huajinbao.util.sign;

import com.breach.common.entity.ConsumerAuths;
import com.breach.huajinbao.sysconst.ISystemConsts;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class ConsumerSessionUtil {

    private static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return session;
    }

    /**
     * 获取 servlet 请求
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }
    
    /**
     * 获取 session 中当前登陆的用户对象
     * @param
     * @return
     */
    public static ConsumerAuths getConsumer() {
        return (ConsumerAuths) getSession().getAttribute(ISystemConsts.CONSUMER_SESSION);
    }
    
    /***
     * 存储当前登陆用户到 session 中
     * @param consumerAccount
     */
    public static void setConsumer(ConsumerAuths consumerAccount) {
        getSession().setAttribute(ISystemConsts.CONSUMER_SESSION, consumerAccount);
    }

    /**
     * 清除 session
     */
    public static void removeConsumer() {
        HttpSession session = getSession();
        session.invalidate();
    }
    
}