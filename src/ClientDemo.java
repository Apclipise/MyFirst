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
			//建立连接的过程
			s = new Socket("127.0.0.1",8888);
			System.out.println("与服务器连接 " + s.getInetAddress().getHostAddress());
			System.out.println("有客户端连接 端口号 " +s.getPort());
			
			System.out.println("客户端输入数据，向服务器端发送");
			Scanner sc = new Scanner(System.in);
			String clientStr = sc.nextLine();
			
			//s.getOutputStream()获得socket的输出流
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


