package dfsbfs;

public class demo {
         void  Bfs()
        {
           /* 1. ������ʼ���裬���г�ʼ��
            2. ���������е�ÿһ�ֿ��ܣ�whlie(���в�Ϊ��)
            {
                ͨ����ͷԪ�ش�����һ�������п��ܣ������������
                {
                    �жϵ�ǰ����Ƿ���Ŀ�꣺����Ŀ��Ҫ�����߼�
                }
                �������������е�ʣ�����
            }*/
           //BFS�Ļ���ʵ������Ҫ��������Ƕ���,ͨ�����п��Խ�ÿһ����������������������,Ȼ��ͨ�����������ͳ��ӵ�ǰ������ϵ�����õ���Ӧ�Ľ��	,��Ӧ�����
            /**
             *  queue = []
             *  queue.append([start])
             *  visited,add (start)
             *  while queue:
             *     node = queue.pop , // can we add more intelligence here
             *     visited.add(node)
             *     process(node)
             *     nodes = generate_relate_nodes(node)
             *     queue.push(nodes)
             */
            /**
             *   queue = []
             *   queue.append([start])
             *   visited.add(start)
             *   while queue:
             *      node = queue.pop;
             *      process(node)
             *      visited(node)
             *      nodes = generate_relate_nodes;
             *      queue.append(nodes)
             *
             */
        }

}
