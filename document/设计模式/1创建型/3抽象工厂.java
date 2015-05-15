/*���󹤳�ģʽ
*
* һ������ͬʱ����һϵ���������Ƶ����Ļ����
* ֻ�Ǳȹ����������װ��һЩ������
*/

//������Ƶ��
public abstract class Audio
{
	public abstract void playback();
}  

//������Ƶ��
public class MandarinAudio extends Audio
{
	//@ override
	public void playback(){};
}

public class CantoneseAudio extends Audio
{
	//@ override
	public void playback(){};
}

/*��������������������������������������������������������������������������������*/

//������Ļ��
public abstract class Subtitle
{
	public abstract void show();
}  

//������Ļ��
public class MandarinSubtitle extends Subtitle
{
	//@ override
	public void show(){};
}

public class CantoneseSubtitle extends Subtitle
{
	//@ override
	public void show(){};
}

/*��������������������������������������������������������������������������������*/

//���󹤳���
public abstract class Factory
{
	public abstract Audio createAudio();
	public abstract Subtitle createSubtitle();
}

//���﹤����
public class MandarinFactory extends Factory
{
	//@ override
	public Audio createAudio()
	{
		return new MandarinAudio();
	}

	//@ override
	public Subtitle createSubtitle()
	{
		return new MandarinSubtitle();
	}
}

//���﹤����
public class CantoneseFactory extends Factory
{
	//@ override
	public Audio createAudio()
	{
		return new CantoneseAudio();
	}

	//@ override
	public Subtitle createSubtitle()
	{
		return new CantoneseSubtitle();
	}
}

/*��������������������������������������������������������������������������������*/

//�ͻ���
public class Client
{
	public static void main(String[ ] arg)
	{
		//ѡ���˹�������ѡ���˲�Ʒ
		Factory factory = new MandarinFactory();

		//��Ƶ����
		Audio audio = factory.createAudio();
		//��Ļ����
		Subtitle subtitle = factory.createSubtitle();

		audio.playback();
		subtitle.show();
	}
}