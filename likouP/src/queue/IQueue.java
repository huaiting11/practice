package queue;

public interface IQueue<T> {
    IQueue InitQueue();

    /**
     * ���ٶ���
     */
    IQueue DestroyQueue();

    /**
     * ��ն���
     */
    IQueue ClearQueue();

    /**
     * �����п�
     */
    Boolean isEmpty();

    /**
     * ���ض��г���
     */
    Integer QueueLength();

    /**
     * ���ض���ͷԪ��
     */
    T GetHead();

    /**
     * �����βԪ��
     */
    Boolean EnQueue(T e);

    /**
     * ɾ����ͷԪ��  ������
     */
    T DeQueue();

}
