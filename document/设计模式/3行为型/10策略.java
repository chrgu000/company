/*����ģʽ
*
* ��ͬ�㷨�����໥�����
* �ñ��̵���ڲ�ͬ�Ļ�Ա�в�ͬ���ۿ۰��ţ�
*/

//һ���㷨�ӿ�  
public interface Calculate 
{  
    public int calculate(int a, int b);  
}  
  
//һ���ӷ������࣬ʵ���㷨�ӿ�  
public class AddCalculate implements Calculate  
{  
    public int calculate(int a, int b)  
    {  
        return a + b;  
    }  
}  

//һ�����������࣬ʵ���㷨�ӿ�  
public class DivideCalculate implements Calculate  
{  
    public int calculate(int a, int b)  
    {  
        return a / b;  
    }  
}  

/*����������������������������������������������������������������������������������������*/

//һ��������ɫ�࣬���жԽӿڵ�����  
public class Environment  
{  
    private Calculate cal;  
       
    public Environment(Calculate cal)  
    {  
        this.cal = cal;  
    }  
   
    public Calculate getCalculate()  
    {  
        return cal;  
    }  
 
    public void setCalculate(Calculate cal)  
    {  
        this.cal = cal;  
    }  

	//������ɫ�еĽӿڷ�����������������ڲ�������ָ��ľ�����Խ�ɫ����  
    public int calculate(int a ,int b)  
    {  
        return cal.calculate(a , b);  
    }  
}  

/*����������������������������������������������������������������������������������������*/
  
public class Client  
{  
    public static void main(String[] args)  
    {  
        AddCalculate add = new AddCalculate();  
        Environment environment = new Environment(add);  
        System.out.println(environment.calculate(3, 4));  
  
        DivideCalculate divide = new DivideCalculate();   
        Environment environment = new Environment(divide);   
        System.out.println(environment.calculate(3, 4));        
    }  
} 
