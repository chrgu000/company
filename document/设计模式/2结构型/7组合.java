/*���ģʽ
*
* ����ͨ��ʵ�֣��̳У�ͳһ�Ľӿڣ������ࣩ�������߶Ե�һ�������϶���Ĳ�������һ���ԣ�
*/

public interface Node
{   
    public void copy(); //����ͳһ�Ľӿڣ�����   
}   
  
public class Folder implements Node
{   
    private String folderName;   
    private ArrayList nodeList =new ArrayList(); //���ڴ洢�ļ����µ��ļ��л��ļ�����Ϣ  
  
    public Folder(String folderName)
	{   
        this.folderName = folderName;   
    }   
  
	//�����ļ����ļ���
    public void add(Node node)
	{    
        nodeList.add(node);   
    }   

	//�ļ��и��Ʋ���ʵ�ֵݹ�
    public void copy()
	{     
        System.out.println("�����ļ��У�" + folderName);  
		
        for(int i=0;i < nodeList.size(); i++)
		{
            Node node = (Node)nodeList.get(i);   
            node.copy();   
        }   
    }   
}   
  
public class File implements Node
{   
    private String fileName;   
  
    public File(String fileName)
	{   
        this.fileName = fileName;   
    }   
  
    public void copy()
	{   
        System.out.println("�����ļ���" + fileName);   
    }   
}   

/*����������������������������������������������������������������������������������������*/

public class Client
{   
    public static void main(String[] args)
	{   
        Folder document = new Folder("�ҵ�����"); //�ҵ������ļ���   
        File book = new File("Java���˼��.pdf");  //�ĵ��ļ�  
		
        Folder music = new Folder("�ҵ�����");   //�ҵ������ļ���   
        File music1 = new File("�����ҵ���.mp3");   //�����ļ�1   
        File music2 = new File("Without You.mp3");  //�����ļ�2   

        //ȷ�����νṹ��ϵ   
        document.add(book);   
        document.add(music);   
        music.add(music1);   
        music.add(music2);   
  
        document.copy(); //���ơ��ҵ����ϡ��ļ��У��ݹ�ظ��������������ļ��к��ļ���  
    }   
 
}  

//���н�����£�
//�����ļ��У��ҵ�����   
//�����ļ���Java���˼��.pdf   
//�����ļ��У��ҵ�����   
//�����ļ��������ҵ���.mp3   
//�����ļ���Without You.mp3  