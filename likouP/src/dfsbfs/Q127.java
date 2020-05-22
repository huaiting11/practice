package dfsbfs;

import com.sun.javafx.scene.text.HitInfo;

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
public class Q127 {

    // ���� bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.remove();
                if(cur.equals(endWord)){ return level + 1;}
                for(int j = 0; j < cur.length(); j++){
                    char[] word = cur.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        word[j] = ch;
                        String check = new String(word);
                        if(!check.equals(cur) && dict.contains(check)){
                            queue.add(check);
                            dict.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public int ladderLength01(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1;
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            return step + 1;
                        }
                        if (!visited.contains(target) && dict.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            step++;
        }
        return 0;
    }

}
