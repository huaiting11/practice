package dp.string;

import java.util.HashMap;

public class Q76 {
    public String minWindow(String s, String t) {

        int left, right, count, minLen= Integer.MAX_VALUE;
        int start=0,end=0;

        //needs�洢t��<�ַ�,���ִ���>,windows�洢<s����t���ַ���ͬ���ַ�,���ִ���>
        HashMap<Character,Integer> needs = new HashMap<>();
        HashMap<Character,Integer> windows = new HashMap<>();

        //��ʼ��needs
        for(int i=0;i<t.length();i++){
            //needs.getOrDefault(t.charAt(i),0)+1 �����ǣ�needs�������t.charAt(i)��
            //��ȡ��ֵ+1;������ȡ0+1
            needs.put(t.charAt(i),needs.getOrDefault(t.charAt(i),0)+1);
        }
        left = right = count = 0;
        while(right <s.length()){
            //��ȡ�ַ�
            char temp=s.charAt(right);
            //�����t���ַ�����windows����ӣ��ۼƳ��ִ���
            if(needs.containsKey(temp)){
                windows.put(temp,windows.getOrDefault(temp,0)+1);
                //ע�⣺Integer������==�Ƚϣ�Ҫ��compareTo
                if(windows.get(temp).compareTo(needs.get(temp))==0 ){
                    //�ַ�temp���ִ�������Ҫ��count�������Ҫ����ַ�����
                    count++;
                }
            }
            //�Ż��������������right����ǰ���ҿ��н�
            right++;
            //����Ҫ����ַ�����������t�������ַ������һ�����н�
            while(count==needs.size()){
                //���½��
                if(right-left<minLen){
                    start=left;
                    end=right;
                    minLen=end-left;
                }
                //��ʼ�����Ż�������С���䣬ɾ��s[left],
                char c=s.charAt(left);

                //��ǰɾ�����ַ�������t,����Windows�ж�Ӧ���ֵĴ�����������º�Ĵ���<t�г��ֵĴ���������Ҫ����ַ�����1���´��ж�count==needs.size()ʱ�����������
                if(needs.containsKey(c)){
                    windows.put(c,windows.getOrDefault(c,1)-1);
                    if(windows.get(c)<needs.get(c)){
                        count--;
                    }
                }
                left++;
            }

        }
        //���ظ��ǵ���С��
        return minLen==Integer.MAX_VALUE ? "":s.substring(start,end);

    }
}
