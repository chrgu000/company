/*������ģʽ
*
* ��Ʒ���ڲ��ṹ��������ָ������ɣ�
* ��Ʒ�и��������໥������ָ���߿���ǿ������˳��
* ����б䶯��������Ҫ���Ŀͻ��˵Ĵ��룬ֻ��Ҫ�޸�ָ�����ڲ��Ĵ��룻
*/

public interface Product { }
public interface Part { }

/*��������������������������������������������������������������������������������*/

//��������
public interface Builder 
{ 
	void buildPartA(); 
	void buildPartB();  
����
	Product getResult(); 
} 

//���彨�칤��
public class ConcreteBuilder implements Builder 
{ 
����Part partA, partB; 

����public void buildPartA() 
	{
��������//�����Ǿ�����ι���partA�Ĵ���
����}; 

����public void buildPartB() 
	{ 
��������//�����Ǿ�����ι���partB�Ĵ���
����}; 

����public Product getResult() 
	{ 
��������//���������װ��Ʒ���
����}; 
}

/*��������������������������������������������������������������������������������*/

//������
public class Director 
{
����private Builder builder; 
����
����public Director( Builder builder ) 
	{ 
��������this.builder = builder; 
����} 

����public Object construct() 
	{ 
��������builder.buildPartA();
��������builder.buildPartB();

		return builder.getResult();
����} 
} 

/*��������������������������������������������������������������������������������*/

//�ͻ���
public class Client
{
	public static void main(String[ ] arg)
	{
		//builder�ڲ��ṹ���ڿͻ���������ȫδ֪
����	Director director = new Director(new ConcreteBuilder()); 
����
����	Product product = director.construct(); 
	}
}