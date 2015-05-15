/*�򵥹���ģʽ
*
* ͨ������һ��ר�Ÿ��𴴽��������Ĺ����࣬ʹ�ÿͻ��˲���Ҫ�˽��������й�ϸ�ڼ������ɸ����ʵ��;
* �����ڲ����ݲ�ͬ��������������ʲô����;
* ������"����-���"ԭ���¼����Ʒ�����Ҫ�޸Ĺ�������;
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

//�򵥹����࣬������������ݴ���Ĳ���������Ӧ�Ľ���������
public class DecodeFactory
{
	public static Decoder createDecoder(String fileName)
	{
		//��ȡ�ļ���չ��
		String fileNameExt = ...getExtension(fileName);
		switch(fileNameExt)
		{
			case ".mp3":
				return new Mp3Decoder();
			case ".wma":
				return new WmaDecoder();
			default:
				return null;
		}
	}
}

/*��������������������������������������������������������������������������������*/

//�ͻ���
public class Client
{
	public static void main(String[ ] arg)
	{
		String fileName = "����.mp3";

		//��̬����
		Decoder decoder = DecoderFactory.createDecoder(fileName);
		decoder.decode(fileName);
	}
}