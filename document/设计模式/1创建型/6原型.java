/*ԭ��ģʽ
*
* Ϊ������ͬ������ʵ���Ĵ����ṩ��¡�Ѵ���ʵ���ķ�����
*/

//ʵ��Cloneable�ӿڡ�
//��java������һ��Cloneable�ӿڣ���������ֻ��һ����
//����������ʱ֪ͨ��������԰�ȫ����ʵ���˴˽ӿڵ�����ʹ��clone������
//��java������У�ֻ��ʵ��������ӿڵ���ſ��Ա�������
//����������ʱ���׳�CloneNotSupportedException�쳣��
class Prototype implements Cloneable 
{  
    public Prototype clone()
	{   
        Prototype prototype = null;  

        try
		{  
            prototype = (Prototype)super.clone();  
        }
		catch(CloneNotSupportedException e)
		{  
            e.printStackTrace();  
        }  

        return prototype;   
    }  
}  
  
//����ԭ��
class ConcretePrototype  extends Prototype
{  
    public void show()
	{  
        System.out.println("ԭ��ģʽʵ����");  
    }  
}  
  
/*��������������������������������������������������������������������������������*/

public class Client 
{  
    public static void main(String[] args)
	{  
        ConcretePrototype cp = new ConcretePrototype();
		
        for(int i=0; i< 10; i++)
		{  
            ConcretePrototype clonecp = (ConcretePrototype)cp.clone();  
            clonecp.show();  
        }  
    }  
}  

/**����������������������������������������������������������������������������������������������������������������������������������������������������������������*/

//Object���clone����ֻ�´�������еĻ������������ͣ�
//�������顢�����������ö���ȶ����´���������ǳ������
//���Ҫʵ����������뽫ԭ��ģʽ�е����顢�����������ö�������п�����
public class Prototype implements Cloneable 
{  
    private ArrayList list =  new ArrayList();  

    public Prototype clone(){  
        Prototype prototype = null;  

        try
		{  
            prototype = (Prototype)super.clone();  
			//java��������Ҳ�ṩ�˿�¡����
            prototype.list = (ArrayList)this.list.clone();  
        }
		catch(CloneNotSupportedException e)
		{  
            e.printStackTrace();  
        }  

        return prototype;   
    }  
}  
