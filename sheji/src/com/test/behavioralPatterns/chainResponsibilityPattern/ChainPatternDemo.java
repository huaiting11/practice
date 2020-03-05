package com.test.behavioralPatterns.chainResponsibilityPattern;

/**
 *��ͼ��������������������������һ���ö�������п��ܽ������󣬽���Щ�������ӳ�һ����������������������������ֱ���ж�������Ϊֹ��
 *
 * ��Ҫ�����ְ�����ϵĴ����߸��������󣬿ͻ�ֻ��Ҫ�������͵�ְ�����ϼ��ɣ������������Ĵ���ϸ�ں�����Ĵ��ݣ�����ְ����������ķ����ߺ�����Ĵ����߽����ˡ�
 *
 * ��ʱʹ�ã��ڴ�����Ϣ��ʱ���Թ��˺ܶ����
 *
 * ��ν�������ص��඼ʵ��ͳһ�ӿڡ�
 *
 * �ؼ����룺Handler ����ۺ����Լ����� HandlerRequest ���ж��Ƿ���ʣ����û�ﵽ���������´��ݣ���˭����֮ǰ set ��ȥ��
 *
 * Ӧ��ʵ���� 1����¥���е�"���Ĵ���"�� 2��JS �е��¼�ð�ݡ� 3��JAVA WEB �� Apache Tomcat �� Encoding �Ĵ���Struts2 ����������jsp servlet �� Filter��
 */
//������ͬ���͵ļ�¼�����������ǲ�ͬ�Ĵ��󼶱𣬲���ÿ����¼����������һ����¼����ÿ����¼���е���һ����¼�������������һ���֡�
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}
