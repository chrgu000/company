/*������ģʽ
*
* �����е�������µĲ���������ף���ͬ�ķ����߶Ա��������в�ͬ�Ĳ�������
*/

//��������ߣ����ڴ���Ĳ�ͬ�Ĳ�����ȡ��ͬ�ķ��ʷ�ʽ����̬���ɣ���̬��
public interface Visitor 
{
    //��Ӧ��NodeA�ķ��ʲ���
    public void visit(NodeA node);

    //��Ӧ��NodeB�ķ��ʲ���
    public void visit(NodeB node);
}

//���������VisitorA��
public class VisitorA implements Visitor 
{
    //��Ӧ��NodeA�ķ��ʲ���
    @Override
    public void visit(NodeA node) 
	{
        System.out.println(node.operationA());
    }

    //��Ӧ��NodeB�ķ��ʲ���
    @Override
    public void visit(NodeB node) 
	{
        System.out.println(node.operationB());
    }

}

//���������VisitorB��
public class VisitorB implements Visitor 
{
    //��Ӧ��NodeA�ķ��ʲ���
    @Override
    public void visit(NodeA node) 
	{
        System.out.println(node.operationA());
    }

    //��Ӧ��NodeB�ķ��ʲ���
    @Override
    public void visit(NodeB node) 
	{
        System.out.println(node.operationB());
    }

}

/*����������������������������������������������������������������������������������������*/

//����ڵ���
public abstract class Node 
{
    //���ܲ���
    public abstract void accept(Visitor visitor);
}

/*˫��ί�ɣ�//�������߽��Լ���ȫ�����˷����ߣ�Ҫ��ô�����Լ������ڷ����ߣ�
* public void accept(Visitor visitor) //����һ��������
* {
*	visitor.visit(this); //���Լ�ί�ɸ�������
* }
*/

//����ڵ���NodeA
public class NodeA extends Node
{
    //���ܲ���
    @Override
    public void accept(Visitor visitor) 
	{
        visitor.visit(this);
    }

    //NodeA���еķ���
    public String operationA()
	{
        return "NodeA";
    }

}

//����ڵ���NodeB
public class NodeB extends Node
{
    //���ܷ���
    @Override
    public void accept(Visitor visitor) 
	{
        visitor.visit(this);
    }

    // NodeB���еķ���
    public String operationB()
	{
        return "NodeB";
    }
}

/*����������������������������������������������������������������������������������������*/

//�ṹ�����ɫ�࣬����ṹ�����ɫ����һ���ۼ�����������ṩadd()������Ϊ�Ծۼ��Ĺ��������
//ͨ������������������Զ�̬������һ���µĽڵ㡣
public class ObjectStructure 
{ 
    private List<Node> nodes = new ArrayList<Node>();
    
    //ִ�з�������
    public void action(Visitor visitor)
	{   
        for(Node node : nodes)
        {
            node.accept(visitor);
        }
        
    }

    //���һ����Ԫ��
    public void add(Node node)
	{
        nodes.add(node);
    }
}

/*����������������������������������������������������������������������������������������*/

//�ͻ�����
public class Client 
{
    public static void main(String[] args) 
	{
        //����һ���ṹ����
        ObjectStructure os = new ObjectStructure();

        //���ṹ����һ���ڵ�
        os.add(new NodeA());
        //���ṹ����һ���ڵ�
        os.add(new NodeB());

        //����һ��������
        Visitor visitor = new VisitorA();

        os.action(visitor);
    }

}

