/*������ģʽ
*
* �������ϵ�ְ����������
*/

/**����ۺ�+�������*/

public interface Iterator
{
    public Object first();

    public Object next();

	//�õ���ǰ����
    public Object currentItem();

	//�Ƿ��˽�β
    public boolean isDone();
}

//���������
public class ConcreteIterator implements Iterator
{
    private int currentIndex = 0;

	//����һ�����弯�϶���
    private Aggregate aggregate = null;

    public ConcreteIterator(Aggregate aggregate)
    {
        this.aggregate = aggregate;
    }

	//��д���෽��
    @Override
    public Object first()
    {
        currentIndex = 0;
        return vector.get(currentIndex);
    }

    @Override
    public Object next()
    {
		if(currentIndex < aggregate.count())
			currentIndex++;
        return vector.get(currentIndex);
    }

    @Override
    public Object currentItem()
    {
        return aggregate.getAt(currentIndex);
    }

    @Override
    public boolean isDone()
    {
		return (currentIndex >= aggregate.count());
    }
}

/*����������������������������������������������������������������������������������������*/

//����ۺ�Ҫ�󼯺���������ṩ�����Լ��ڲ�Ԫ�صĽӿ�
public interface Aggregat
{
    public Iterator createIterator();

	//��ȡ�����ڲ�Ԫ������
	public int count();

	//��ȡָ��λ��Ԫ��
	public Object getAt(int index);
}

/*����������������������������������������������������������������������������������������*/

//����ļ�����
public class ConcreteAggregat implements Aggregat
{
    private Vector vector = null;

    public Vector getVector()
    {
        return vector;
    }

    public void setVector(final Vector vector)
    {
        this.vector = vector;
    }

    public ConcreteAggregat()
    {
        vector = new Vector();
        vector.add("item 1");
        vector.add("item 2");
    }

	//��ȡ�����ڲ�Ԫ������
	@Override
	public int count()
	{
		return vector.size();
	}

	//��ȡָ��λ��Ԫ��
	@Override
	public Object getAt(int index)
	{
		if(0 <= index && index < vector.size())
			return vector[index];
		else
			return null;
	}

	//����һ��������������󣬲��Ѹü��϶����������õ�����
    @Override
    public Iterator createIterator()
    {
		//�������ʹ�ü򵥹���ģʽ
        return new ConcreteIterator(this);
    }
}

/*����������������������������������������������������������������������������������������*/

public class Client
{
    public static void main(final String[] args)
    {
        Aggregat agg = new ConcreteAggregat();
        final Iterator iterator = agg.createIterator();

        System.out.println(iterator.first());

        while (!iterator.isDone())
        {
			//Item item = (Item)iterator.currentItem();
            System.out.println(iterator.next());
        }
    }
}


