/*����ģʽ
*
* ��֤һ�������һ��ʵ����
*/

public class Singleton
{ 
����private static Singleton sqlInstance;

	//˽�еĹ��캯�����������ⲿnew
	private Singleton();

	//��̬�������þ�̬ʵ����ע���̰߳�ȫ��
	public static synchronized Singleton getInstance()
	{
		//���ʵ���Ƿ����
		if(sqlInstance == null)
		{
			sqlInstance = new Singleton();
		}
		else
		{
			System.out.println("��ʵ���Ѿ����ڣ������Ѵ���ʵ��");
		}

		return sqlInstance;
	}
}

/*��������������������������������������������������������������������������������*/

//�ͻ���
public class Client
{
	public static void main(String[ ] arg)
	{
		//ʹ�þ�̬��������ʵ��
		Singleton link = Singleton.getInstance(); 
	}
} 

