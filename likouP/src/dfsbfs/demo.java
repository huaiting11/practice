package dfsbfs;

public class demo {
         void  Bfs()
        {
           /* 1. 建立起始步骤，队列初始化
            2. 遍历队列中的每一种可能，whlie(队列不为空)
            {
                通过队头元素带出下一步的所有可能，并且依次入队
                {
                    判断当前情况是否达成目标：按照目标要求处理逻辑
                }
                继续遍历队列中的剩余情况
            }*/
           //BFS的基本实现最重要的组件便是队列,通过队列可以将每一步的所有情况都存入队列中,然后通过入队新情况和出队当前分析完毕的情况得到相应的结果	,对应这道题
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
