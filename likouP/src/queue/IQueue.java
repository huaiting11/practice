package queue;

public interface IQueue<T> {
    IQueue InitQueue();

    /**
     * 销毁队列
     */
    IQueue DestroyQueue();

    /**
     * 清空队列
     */
    IQueue ClearQueue();

    /**
     * 队列判空
     */
    Boolean isEmpty();

    /**
     * 返回队列长度
     */
    Integer QueueLength();

    /**
     * 返回队列头元素
     */
    T GetHead();

    /**
     * 插入队尾元素
     */
    Boolean EnQueue(T e);

    /**
     * 删除队头元素  即出队
     */
    T DeQueue();

}
