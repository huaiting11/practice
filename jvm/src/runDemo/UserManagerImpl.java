package runDemo;

public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String userName, String password) {
        System.out.println("�����������ķ�����");
        System.out.println("�������Ϊ userName: "+userName+" password: "+password);
    }

    @Override
    public void delUser(String userName) {
        System.out.println("������ɾ���ķ�����");
        System.out.println("�������Ϊ userName: "+userName);
    }
}
