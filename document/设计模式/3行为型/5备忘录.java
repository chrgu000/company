/*����¼ģʽ
*
* �ָ���֮ǰ�������״̬��
*/

/**���䱸��¼*/

//�����˽�ɫ�࣬�����˽�ɫ����һ���´����ı���¼�����Լ����ڲ�״̬�洢������
public class Originator 
{
    private String state;

    //��������������һ���µı���¼����
    public Memento createMemento()
	{
        return new Memento(state);
    }

    //�������˻ָ�������¼���������ص�״̬  
    public void restoreMemento(Memento memento)
	{
        this.state = memento.getState();
    }
    
    public String getState() 
	{
        return state;
    }
    
    public void setState(String state) 
	{
        this.state = state;
        System.out.println("��ǰ״̬��" + this.state);
    }
    
}

//����¼��ɫ�࣬����¼���󽫷����˶������״̬�洢������
public class Memento 
{    
    private String state;
    
    public Memento(String state)
	{
        this.state = state;
    }

    public String getState() 
	{
        return state;
    }

    public void setState(String state) 
	{
        this.state = state;
    }
    
}

//����Ա��ɫ�࣬���𱣴汸��¼���󣬵��ǴӲ��޸ģ��������鿴������¼��������ݡ�
public class Caretaker 
{
    private Memento memento;

    //����¼��ȡֵ����
    public Memento retrieveMemento()
	{
        return this.memento;
    }

    //����¼�ĸ�ֵ����
    public void saveMemento(Memento memento)
	{
        this.memento = memento;
    }
}

/*����������������������������������������������������������������������������������������*/

public class Client 
{
    public static void main(String[] args) 
	{      
        Originator o = new Originator();
        Caretaker c = new Caretaker();

        //�ı为���˶����״̬
        o.setState("On");

        //��������¼���󣬲��������˶����״̬��������
        c.saveMemento(o.createMemento());

        //�޸ķ����˵�״̬
        o.setState("Off");

        //�ָ������˶����״̬
        o.restoreMemento(c.retrieveMemento());
        
        System.out.println(o.getState());
    }

}