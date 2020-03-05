package com.test.structuralPatterns.proxyPattern.jingtai;

public class Client1 {
    public static void main(String[] args) {
        UserService userServiceImpl = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy(userServiceImpl);

        proxy.select();
        proxy.update();
    }
}
