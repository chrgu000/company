/*������ģʽ
*
* ���磬������������������ļ��㷽����Ҫ������ı��ε������
*/

/*��������ģʽ*/

// �Ѵ��ڵġ��������⹦�ܡ������������Ǽ��еı�׼�ӿڵ���   
public class Adaptee 
{  
    public void specificRequest() 
	{  
        System.out.println("����������� ���⹦��...");  
    }  
}  
  
/*����������������������������������������������������������������������������������������*/

// Ŀ��ӿڣ����Ϊ��׼�ӿ�   
public interface Target 
{  
    public void request();  
}  
  
// ����Ŀ���ֻ࣬�ṩ��ͨ����   
class ConcreteTarget implements Target 
{  
    public void request() 
	{  
        System.out.println("��ͨ�� ���� ��ͨ����...");  
    }  
}   
  
// �������࣬�̳��˱������࣬ͬʱʵ�ֱ�׼�ӿ�   
class Adapter extends Adaptee implements Target
{  
    public void request() 
	{  
        super.specificRequest();  
    }  
}   
  
/*����������������������������������������������������������������������������������������*/
  
// ������   
public class Client 
{  
    public static void main(String[] args) 
	{  
        // ʹ����ͨ������   
        Target concreteTarget = new ConcreteTarget();  
        concreteTarget.request();  
          
        // ʹ�����⹦���࣬��������   
        Target adapter = new Adapter();  
        adapter.request();  
    }  
}  

/**��������������������������������������������������������������������������������������������������������������������������������������������������������������������*/

/*����������*/

// �������ֱ࣬�ӹ����������࣬ͬʱʵ�ֱ�׼�ӿ�   
public class Adapter implements Target
{  
    // ֱ�ӹ�����������   
    private Adaptee adaptee;  
     
    // ����ͨ�����캯�����������Ҫ����ı����������   
    public Adapter (Adaptee adaptee) 
    {  
       this.adaptee = adaptee;  
    }  
      
    public void request() 
	{  
        // ������ʹ��ί�еķ�ʽ������⹦��   
        this.adaptee.specificRequest();  
    }  
}  
  
/*����������������������������������������������������������������������������������������*/
  
// ������   
public class Client 
{  
    public static void main(String[] args) 
	{  
        // ʹ����ͨ������   
        Target concreteTarget = new ConcreteTarget();  
        concreteTarget.request();  
          
        // ʹ�����⹦���࣬�������࣬   
        // ��Ҫ�ȴ���һ����������Ķ�����Ϊ����   
        Target adapter = new Adapter(new Adaptee());  
        adapter.request();  
    }  
}  
