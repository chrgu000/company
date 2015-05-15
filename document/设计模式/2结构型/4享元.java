/*��Ԫģʽ
*
* ��Ԫģʽ����һ���������������ӵ����ͬ���ݶ���Ŀ�����
* ��Ԫ��������������Ĺؼ�����������״̬(Internal State)������״̬(External State)��
*     һ������״̬�Ǵ洢����Ԫ�����ڲ��ģ������ǲ����滷���ĸı��������ͬ��
* ��ˣ�һ����Ԫ���Ծ�������״̬�����Թ���
*���� һ������״̬���滷���ĸı���ı�ġ������Թ���ġ�
* ��Ԫ���������״̬�����ɿͻ��˱��棬������Ԫ���󱻴���֮������Ҫʹ�õ�ʱ���ٴ��뵽��Ԫ�����ڲ���
* ����״̬������Ӱ����Ԫ���������״̬���������໥�����ġ�
*/

//������Ԫ��ɫ��
public interface Flyweight 
{
    //һ��ʾ���Է���������state������״̬
    public void operation(String state);
}

public class ConcreteFlyweight implements Flyweight 
{
    private Character intrinsicState = null;

    //���캯��������״̬��Ϊ��������
    public ConcreteFlyweight(Character state)
	{
        this.intrinsicState = state;
    }
    
    
    //����״̬��Ϊ�������뷽���У��ı䷽������Ϊ�����ǲ����ı���������״̬��
    @Override
    public void operation(String state)
	{
        System.out.println("Intrinsic State = " + this.intrinsicState);
        System.out.println("Extrinsic State = " + state);
    }

}

/*����������������������������������������������������������������������������������������*/

//��Ԫ������ɫ�࣬����ָ�����ǣ��ͻ��˲�����ֱ�ӽ�������Ԫ��ʵ������������ͨ��һ��������������һ��factory()�����õ���Ԫ����
//һ����ԣ���Ԫ��������������ϵͳ��ֻ��һ�������Ҳ����ʹ�õ���ģʽ��
public class FlyweightFactory 
{
    private Map<Character,Flyweight> files = new HashMap<Character,Flyweight>();
    
    public Flyweight factory(Character state)
	{
        //�ȴӻ����в��Ҷ���
        Flyweight fly = files.get(state);

        if(fly == null)
		{
            //������󲻴����򴴽�һ���µ�Flyweight����
            fly = new ConcreteFlyweight(state);

            //������µ�Flyweight������ӵ�������
            files.put(state, fly);
        }
        return fly;
    }
}

/*����������������������������������������������������������������������������������������*/

public class Client {

    public static void main(String[] args) 
	{
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight fly = factory.factory(new Character('a'));
        fly.operation("First Call");
        
        fly = factory.factory(new Character('b'));
        fly.operation("Second Call");
        
        fly = factory.factory(new Character('a'));
        fly.operation("Third Call");
    }

} 