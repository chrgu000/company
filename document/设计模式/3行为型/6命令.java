/*����ģʽ
*
* �������װ�ɶ�����Ϊ��������ߺͽ����ߵ��н飻
*/

//�����߽�ɫ�࣬�ṩ���ֲ����Ľ����������
public class Receiver 
{
    //����ִ��������Ӧ�Ĳ���
    public void action()
	{
        System.out.println("ִ�в���");
    }
}

//���������ɫ��
public interface Command 
{
    //ִ�з���
    void execute();
}

//���������ɫ��
public class ConcreteCommand implements Command 
{
    //������Ӧ�Ľ����߶���
    private Receiver receiver = null;

    public ConcreteCommand(Receiver receiver)
	{
        this.receiver = receiver;
    }

    @Override
    public void execute() 
	{
        //ͨ����ת�������߶������Ӧ�������ý�����������ִ�й���
        receiver.action();
    }
}

//�����߽�ɫ��
public class Invoker 
{
    //�����������
    private Command command = null;
  
    public Invoker(Command command)
	{
        this.command = command;
    }

    public void action()
	{  
        command.execute();
    }
}

/*����������������������������������������������������������������������������������������*/

public class Client 
{
    public static void main(String[] args) 
	{
        //����������
        Receiver receiver = new Receiver();

        //������������趨���Ľ�����
        Command command = new ConcreteCommand(receiver);

        //���������ߣ�������������ý�ȥ
        Invoker invoker = new Invoker(command);

        //ִ�з���
        invoker.action();
    }

}