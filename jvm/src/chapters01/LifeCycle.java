package chapters01;

/**
 * 虚拟机的启动：
 * Java 虚拟机的启动时通过引导类加载器
 * （bootstrap class loader）创建一个初始类（initial class）
 * 来完成的，这个类是由虚拟机的具体实现指定的。
 * 虚拟机的执行：
 * 一个运行中的Java 虚拟机有着一个清晰的任务，执行Java 程序。
 * 程序开始执行时它才运行，程序结束时他就停止。
 * 执行一个所谓的Java 程序的时候，真真正正在执行的是一个叫做Java 虚拟机的进程
 * 虚拟机的退出：
 * 有如下的几种情况:
 * 程序正常执行结束
 * 程序在执行过程中遇到了异常或错误而异常终止
 * 由于操作系统出现错误而导致Java 虚拟机进程终止
 * 某线程调用RunTime类或System类的exit 方法，或Runtime类的halt 方法，并且
 * Java 安全管理器也允许这次exitexit 或者 halt 操作
 *
 * 除此之后，INI 规范描述了用JNI Invocation API 来加载或卸载 Java 虚拟机时，Java
 * 虚拟机的退出情况
 *
 * 名称中的HotSpot指的就是它的热点代码探测技术。
 *  通过计数器找到最具编译价值代码，触发即时编译或栈上替换。
 *  通过编译器与解释器协同工作，在最优化的程序响应时间与最佳执行性能中取得平衡
 *
 *  虚拟机的类别： 发展历史
 *  Classic vm
         *  HotSot 目前
         *  EBA JRockit JRockit JVM是世界上最快JVM
 *          IBM 的J9
         */
public class LifeCycle {
    public static void main(String[] args) {
        System.out.println("ddddddd");
    }
}
