import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("############client######");
		Socket s = null;
		PrintWriter out = null;
		try {
			//�������ӵĹ���
			s = new Socket("127.0.0.1",8888);
			System.out.println("����������� " + s.getInetAddress().getHostAddress());
			System.out.println("�пͻ������� �˿ں� " +s.getPort());
			
			System.out.println("�ͻ����������ݣ���������˷���");
			Scanner sc = new Scanner(System.in);
			String clientStr = sc.nextLine();
			
			//s.getOutputStream()���socket�������
			out = new PrintWriter(
					new OutputStreamWriter(s.getOutputStream()));
			out.write(clientStr);
			out.flush();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(out != null) {
				out.close();
			}
			if(s != null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

