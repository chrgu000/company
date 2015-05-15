/*������ģʽ
*
* ʹ�ö�������л��ᴦ�����󣬴Ӷ���������ķ����ߺͽ�����֮�����Ϲ�ϵ 
*������һ��URL��HTTP�����������ˣ������δ��ݸ�FTP����������
*/

//�������߽�ɫ
public abstract class Handler {
    
    //���к�̵����ζ���
    protected Handler successor;

    //ʾ�⴦������ķ�������Ȼ���ʾ�ⷽ����û�д��������
    //��ʵ���ǿ��Դ�������ģ����ݾ�����Ҫ��ѡ���Ƿ񴫵ݲ���
    public abstract void handleRequest();

    //ȡֵ����
    public Handler getSuccessor() 
	{
        return successor;
    }

    //��ֵ���������ú�̵����ζ���
    public void setSuccessor(Handler successor) 
	{
        this.successor = successor;
    } 
}

//���崦����
public class ConcreteHandler extends Handler {

    //�����������ô˷�����������
    @Override
    public void handleRequest() 
	{
        //�ж��Ƿ��к�̵����ζ���
        //����У���ת���������̵����ζ������û�У���������
        if(getSuccessor() != null)
        {            
            System.out.println("��������");
            getSuccessor().handleRequest();            
        }else
        {            
            System.out.println("��������");
        }
    }

}

/*����������������������������������������������������������������������������������������*/

public class Client {

    public static void main(String[] args) 
	{
        //��װ������
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);

        //�ύ����
        handler1.handleRequest();
    }

}