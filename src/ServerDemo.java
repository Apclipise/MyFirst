
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("############server######");
		BufferedReader in = null;
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(8888);
			
			Socket s = ss.accept();
			
			System.out.println("有客户端连接 IP地址" +s.getInetAddress().getHostAddress());
			System.out.println("有客户端连接 端口号 " +s.getPort());
			
			//s.getInputStream()
			in = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			String clientStr = in.readLine();
			System.out.println("客户端发送来的消息是 ："+clientStr);
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ss != null) {
				try {
					ss.accept();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

	}

}
