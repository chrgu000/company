/*״̬ģʽ
*
* ��һ�仰��������״̬ģʽ�����о��Ķ������Ϊ��װ�ڲ�ͬ��״̬�����
* ÿһ��״̬��������һ������״̬���һ�����ࡣ
* ״̬ģʽ����ͼ����һ�����������ڲ�״̬�ı��ʱ������ΪҲ��֮�ı䡣
*/

//������ɫ��
public class Context 
{
    //����һ��State���͵Ķ���ʵ��
    private State state;

    public void setState(State state) 
	{
        this.state = state;
    }

    //�û�����Ȥ�Ľӿڷ���
    public void request(String sampleParameter) 
	{
        //ת��state������
        state.handle(sampleParameter);
    }
}

/*����������������������������������������������������������������������������������������*/

//����״̬��
public interface State 
{
    //״̬��Ӧ�Ĵ���
    public void handle(String sampleParameter);
}

//����״̬��
public class ConcreteStateA implements State 
{
    @Override
    public void handle(String sampleParameter) 
	{ 
        System.out.println("ConcreteStateA handle ��" + sampleParameter);
    }

}

public class ConcreteStateB implements State 
{
    @Override
    public void handle(String sampleParameter) 
	{      
        System.out.println("ConcreteStateB handle ��" + sampleParameter);
    }

}

/*����������������������������������������������������������������������������������������*/

public class Client 
{
    public static void main(String[] args)
	{
        //����״̬
        State state = new ConcreteStateB();

        //��������
        Context context = new Context();

        //��״̬���õ�������
        context.setState(state);

        //����
        context.request("test");
    }
}