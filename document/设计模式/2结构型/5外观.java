/*���ģʽ
*
* ��ν���ģʽ����Ҫ��һ����ϵͳ���ⲿ�����ڲ���ͨ�ű���ͨ��һ��ͳһ�Ķ�����н�����
* ���ģʽ�ṩһ���߲�εĽӿ�ʹ����ϵͳ������ʹ�ã�
*/

//subSystem
public class Camara 
{  
	public void turnOn()  
    {  
		System.out.println("��������ͷ��");  
    }  
     
    public void turnOff()  
    {  
        System.out.println("�ر�����ͷ��");  
    }  
}  

//subSystem
public class Light 
{  
	public void turnOn()  
    {  
        System.out.println("���ƣ�");  
    }  
     
    public void turnOff()  
    {  
        System.out.println("�صƣ�");  
    }  
}  
  
//subSystem
public class Sensor 
{  
	public void activate()  
    {  
		System.out.println("������Ӧ����");  
    }  
     
    public void deactivate()  
    {  
        System.out.println("�رո�Ӧ����");  
    }  
}  

/*����������������������������������������������������������������������������������������*/

//����࣬����ʵ��һ��interface
public class MyFacade 
{  
    private static Camara c1, c2;  
    private static Light l1, l2, l3;  
    private static Sensor s;  
      
	public MyFacade()
	{
		c1 = new Camara();  
        c2 = new Camara();  
        l1 = new Light();  
        l2 = new Light();  
        l3 = new Light();  
        s = new Sensor();
	}  
    
	//�����ͻ����ṩ��ͳһ�ӿ�
    public void activate()  
    {  
        c1.turnOn();  
        c2.turnOn();  
          
        l1.turnOn();  
        l2.turnOn();  
        l3.turnOn();  
          
        s.activate();  
    }  
      
	//�����ͻ����ṩ��ͳһ�ӿ�
    public void deactivate()  
    {  
        c1.turnOff();  
        c2.turnOff();  
          
        l1.turnOff();  
        l2.turnOff();  
        l3.turnOff();  
          
        s.deactivate();  
    } 
}  

/*����������������������������������������������������������������������������������������*/

public class Client 
{
    public static void main(String[] args) 
	{
        MyFacade facade = new MyFacade();

		//�ͻ��˵���һ������������һϵ�в���
		facade.activate();

		facade.deactivate();
    }
}

