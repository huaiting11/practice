package com.test.behavioralPatterns.commandPattern;

/**
 * ��ͼ����һ�������װ��һ�����󣬴Ӷ�ʹ�������ò�ͬ������Կͻ����в�������
 *
 * ��Ҫ�����������ϵͳ�У���Ϊ����������Ϊʵ����ͨ����һ�ֽ���ϵĹ�ϵ����ĳЩ���ϣ�������Ҫ����Ϊ���м�¼������������������ȴ���ʱ�������޷������仯�Ľ���ϵ���ƾͲ�̫���ʡ�
 *
 * ��ʱʹ�ã���ĳЩ���ϣ�����Ҫ����Ϊ����"��¼������/����������"�ȴ����������޷������仯�Ľ�����ǲ����ʵġ�����������£���ν�"��Ϊ������"��"��Ϊʵ����"�����һ����Ϊ����Ϊ���󣬿���ʵ�ֶ���֮�������ϡ�
 *
 * ��ν����ͨ�������ߵ��ý�����ִ�����˳�򣺵����ߡ������ߡ����
 *
 * �ؼ����룺����������ɫ��1��received ����������ִ�ж��� 2��Command 3��invoker ʹ�������������
 *
 * Ӧ��ʵ����struts 1 �е� action ���Ŀ����� ActionServlet ֻ��һ�����൱�� Invoker����ģ�Ͳ��������Ų�ͬ��Ӧ���в�ͬ��ģ���࣬�൱�ھ���� Command��
 *
 * �ŵ㣺 1��������ϵͳ��϶ȡ� 2���µ�������Ժ��������ӵ�ϵͳ��ȥ��
 *
 * ȱ�㣺ʹ������ģʽ���ܻᵼ��ĳЩϵͳ�й���ľ��������ࡣ
 */
//ʹ�� Broker �������ܲ�ִ�����
public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}