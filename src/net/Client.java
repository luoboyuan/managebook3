package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import util.Protocol;
import view.UIOfMenu;
/**
 * 数据连接服务器端接口
 * @author Administrator
 * @Time 2016年4月
 *
 */
public class Client {

	   byte[] buffer=new byte[2567];
	   static InputStream in=null;
	   static OutputStream out=null;
       static Socket tcpConnection = null;
	public void ClientConnectionServer() {
		try {
			tcpConnection = new Socket("127.0.0.1",2333);
			
			System.out.println("接上服务器了");
			
			
	         out=tcpConnection.getOutputStream();
		     in=tcpConnection.getInputStream();
            
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String sendMessageToServer(String message)
	{
		String message_1="";
		try {
			out.write(message.getBytes());
			int count=in.read(buffer);
			message_1=new String(buffer, 0, count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message_1;
	}
public void closeConnectin(String message){
		try {
			out.write(message.getBytes());
			int count=in.read();
			String message_1=new String(buffer, 0, count);
			out.close();
			in.close();
			tcpConnection.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	new Client();	
   
	}

}

