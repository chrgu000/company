/*�۲���ģʽ
*
* �۲���ģʽ������һ��һ�Զ��������ϵ���ö���۲��߶���ͬʱ����ĳһ���������
* ������������״̬�Ϸ����仯ʱ����֪ͨ���й۲��߶���ʹ�����ܹ��Զ������Լ���
*/

/** ���ơ�ģʽ */

//���������ɫ��
public abstract class Subject 
{
    //��������ע��Ĺ۲��߶���
    private List<Observer> list = new ArrayList<Observer>();

    //ע��۲��߶���
    public void attach(Observer observer)
	{    
        list.add(observer);
        System.out.println("Attached an observer");
    }

    //ɾ���۲��߶���
    public void detach(Observer observer)
	{    
        list.remove(observer);
    }

    //֪ͨ����ע��Ĺ۲��߶���
    public void nodifyObservers(String newState)
	{     
        for(Observer observer : list)
		{
            observer.update(newState);
        }
    }
}

//���������ɫ��
public class ConcreteSubject extends Subject
{   
    private String state;
    
    public String getState() 
	{
        return state;
    }

    public void change(String newState)
	{
        state = newState;

        System.out.println("����״̬Ϊ��" + state);

        //״̬�����ı䣬֪ͨ�����۲���
        this.nodifyObservers(state);
    }
}

/*����������������������������������������������������������������������������������������*/

//����۲��߽�ɫ��
public interface Observer 
{
    //���½ӿ�
    public void update(String state);
}

//����۲��߽�ɫ��
public class ConcreteObserver implements Observer 
{
    //�۲��ߵ�״̬
    private String observerState;
    
    @Override
    public void update(String state) 
	{
        // ���¹۲��ߵ�״̬��ʹ����Ŀ���״̬����һ��
        observerState = state;
        System.out.println("״̬Ϊ��"+observerState);
    }

}

/*����������������������������������������������������������������������������������������*/

public class Client 
{
    public static void main(String[] args) 
	{
        //�����������
        ConcreteSubject subject = new ConcreteSubject();
        //�����۲��߶���
        Observer observer = new ConcreteObserver();

        //���۲��߶���Ǽǵ����������
        subject.attach(observer);
        //�ı���������״̬
        subject.change("new state");
    }

}

/*����������������������������������������������������������������������������������������������������������������������������������������������������������������������������*/

/** ������ģʽ */

//��ģ�͵ĳ���۲�����
//��ģ��ͨ�����ǰ�����������������ݡ�
public interface Observer 
{
    //���½ӿڣ�����������󣬷����ȡ��Ӧ����������״̬  
    public void update(Subject subject);
}

//��ģ�͵ľ���۲�����
public class ConcreteObserver implements Observer 
{
    //�۲��ߵ�״̬
    private String observerState;
    
    @Override
    public void update(Subject subject) 
	{
        //���¹۲��ߵ�״̬��ʹ����Ŀ���״̬����һ�� 
        observerState = ((ConcreteSubject)subject).getState();
        System.out.println("�۲���״̬Ϊ��"+observerState);
    }

}

/*����������������������������������������������������������������������������������������*/

//��ģ�͵ĳ���������
//��ģ�͵ĳ�����������Ҫ�ĸı���nodifyObservers()������
//��ѭ��֪ͨ�۲��ߵ�ʱ��Ҳ����ѭ�����ù۲��ߵ�update()������ʱ�򣬴���Ĳ�����ͬ�ˡ�
public abstract class Subject 
{
    //��������ע��Ĺ۲��߶���
    private    List<Observer> list = new ArrayList<Observer>();

    //ע��۲��߶���
    public void attach(Observer observer)
	{     
        list.add(observer);
        System.out.println("Attached an observer");
    }

    //ɾ���۲��߶���
    public void detach(Observer observer)
	{ 
        list.remove(observer);
    }

    //֪ͨ����ע��Ĺ۲��߶���
    public void nodifyObservers()
	{       
        for(Observer observer : list){
            observer.update(this);
        }
    }
}

//��ģ�͵ľ���������
//����ģ����ȣ���һ��仯�����ǵ���֪ͨ�۲��ߵķ�����ʱ�򣬲���Ҫ��������ˡ�
public class ConcreteSubject extends Subject
{   
    private String state;
    
    public String getState() 
	{
        return state;
    }

    public void change(String newState)
	{
        state = newState;
        System.out.println("����״̬Ϊ��" + state);

        //״̬�����ı䣬֪ͨ�����۲���
        this.nodifyObservers();
    }
}