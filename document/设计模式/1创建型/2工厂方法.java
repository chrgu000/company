/*��������ģʽ
*
* ���ֹ����̳���һ�����󹤳�������չ�Ժã�
*/

//����Ľ�������
public abstract class Decoder
{
	public abstract void decode(String fileName);
}  

//�����������
public class Mp3Decoder extends Decoder
{
	//@ override
	public void decode(String fileName){};
}

public class WmaDecoder extends Decoder
{
	//@ override
	public void decode(String filename){};
}

/*��������������������������������������������������������������������������������*/

//���󹤳���
public abstract class Factory
{
	public decoder createrDecoder();
}

//Mp3������
public class Mp3DecodeFactory extends Factory
{
	//@ override
	public Decoder createDecoder()
	{
		return new Mp3Decoder();
	}
}

//Wma������
public class WmaDecodeFactory extends Factory
{
	//@ override
	public Decoder createDecoder()
	{
		return new WmaDecoder();
	}
}

/*��������������������������������������������������������������������������������*/

//�ͻ���
public class Client
{
	public static void main(String[ ] arg)
	{
		String fileName = "����.mp3";

		//ѡ���˹�������ѡ���˲�Ʒ
		Factory factory = new Mp3DecoderFactory();

		Decoder decoder = factory.createDecoder();
		decoder.decode(fileName);
	}
}