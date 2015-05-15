/*�Ž�ģʽ
*
* �ڶ�Զ�Ĺ�ϵ��ʵ�ֳ�����ʵ�ַ��룬�����Ͳ����������������ͣ�����ը����
*/

//ʹ��A��B����ģ���ӡ��������˶ʿ����ѧλ֤

public abstract class IStudent
{
	protected PrintWithTemplateImpl templateImpl;

	public void setTemplateImpl(PrintWithTemplateImpl templateImpl)
	{
		this.templateImpl = templateImpl;
	}

	public void printStudent(String student)
	{
		templateImpl.printTemplate(student);
	}
}

//������
public class Bachelor extends IStudent
{
	public void printStudent(String student)
	{
		super.templateImpl.printTemplate(student);
	}
}

//˶ʿ��
public class Master extends IStudent
{
	public void printStudent(String student)
	{
		super.templateImpl.printTemplate(student);
	}
}

/*����������������������������������������������������������������������������������������*/

public abstract class PrintTemplateImpl
{
	public void printTemplate(String msg);
}

public class PrintWithTemplateA extends PrintTemplateImpl
{
	@Override
	public void printTemplate(String msg)
	{
		System.out.println("ʹ������A��ӡ" + msg + "ѧλ֤");
	}
}

public class PrintWithTemplateB extends PrintTemplateImpl
{
	@Override
	public void printTemplate(String msg)
	{
		System.out.println("ʹ������B��ӡ" + msg + "ѧλ֤");
	}
}

/*����������������������������������������������������������������������������������������*/

public class Client 
{  
	public static void main(String[] args) 
	{  
		//������A��ӡ������ѧλ֤
		IStudent a = new Bachelor();
		a.setTemplateImpl(new PrintWithTemplateA());
		a.printStudent("������");
    }  
}  
