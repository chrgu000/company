/*װ��ģʽ
*
* ��̬����͸�������ӻ����ĳЩ�����ְ�ܣ�
*/

 
//����ӿڣ��淶׼�����ո������εĶ��� 
public interface Component 
{  
    public void operation();  
}

//���ո�������, �����͵�������ж��, ֻ��Ӧһ��Decorator�� 
public class ConcreteComponent implements Component 
{  
	public ConcreteComponent()
	{
	}  

    public void operation()  
    {  
		System.out.println("�ܿ���");  
    }  
}

//װ�ν�ɫ������һ��������Component�������ʵ����������һ������󹹼��ӿ�һ�µĽӿ�
public class Decorator implements Component 
{  
	private Component component;  

    public Decorator()
	{
	}  
  
    public Decorator(Component component)  
    {  
		this.component = component;  
    }  
  
    public void operation() 
	{  
		component.operation();  
    }  
}  

//��Ӹ�������
public class ConcreteDecorator extends Decorator 
{  
	public ConcreteDecorator()
	{
	}  
  
    public ConcreteDecorator(Component component)  
    {  
         super(component);  
    }  
  
    public void operation()  
    {  
         this.addedOperation();  
         super.operation();  
    }  
  
    public void addedOperation()  
    {  
         System.out.println("������");  
    }  
}  

/*����������������������������������������������������������������������������������������*/

public class Client 
{  
	public static void main(String[] args) 
	{  
		Component component = new ConcreteComponent();  
		Decorator decorator = new ConcreteDecorator(component);  

		//�ͻ��˲���, ��������������  
		decorator.operation();                 
    }  
}  
