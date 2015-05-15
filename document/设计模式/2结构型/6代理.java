/*����ģʽ
*
* ��������ʹ��java�ṩ��proxy���ö�̬Ȩ�ޣ���
* http://blog.csdn.net/shuangde800/article/details/10381495��
*/

//��������ɫ
public abstract class AbstractObject 
{
    //����
    public abstract void operation();
}

//Ŀ������ɫ
public class RealObject extends AbstractObject 
{
    @Override
    public void operation() 
	{
        //һЩ����
        System.out.println("һЩ����");
    }
}

//��������ɫ
public class ProxyObject extends AbstractObject
{
    RealObject realObject = new RealObject();

    @Override
    public void operation() 
	{
        //����Ŀ�����֮ǰ��������ز���
        System.out.println("before"); 
		
        realObject.operation(); 
		
        //����Ŀ�����֮���������ز���
        System.out.println("after");
    }
}

/*����������������������������������������������������������������������������������������*/

public class Client 
{
    public static void main(String[] args) 
	{
        AbstractObject obj = new ProxyObject();
        obj.operation();
    }
}
