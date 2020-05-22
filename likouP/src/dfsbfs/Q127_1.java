package dfsbfs;

import java.util.*;

/**
 * �����������ʣ�beginWord?�� endWord����һ���ֵ䣬�ҵ���?beginWord ��?endWord �����ת�����еĳ��ȡ�ת������ѭ���¹���
 *
 * ÿ��ת��ֻ�ܸı�һ����ĸ��
 * ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
 * ˵��:
 *
 * ���������������ת�����У����� 0��
 * ���е��ʾ�����ͬ�ĳ��ȡ�
 * ���е���ֻ��Сд��ĸ��ɡ�
 * �ֵ��в������ظ��ĵ��ʡ�
 * ����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
 *
 * ����:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * ���: 5
 *
 * ����: һ�����ת�������� "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      �������ĳ��� 5��

 */
public class Q127_1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set dic = new HashSet(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()){
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                String temp = queue.poll();
                if(temp.equals(endWord)){
                    return level+1;
                }
                for (int j = 0; j < temp.length(); j++) {
                    char[] chars = temp.toCharArray();
                    for (char  k = 'a'; k <= 'z'  ; k++) {
                        chars[j] = k;
                        String check = new String(chars);
                        if(dic.contains(check) && !check.equals(temp)){
                            queue.add(check);
                            dic.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
