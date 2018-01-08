package com.apidemo.baseclass;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

public class AppiumServer {
	
	public static void startServer(String batFileName) throws IOException{
		File f=new File("batFileFolder");
		File fs=new File(f,batFileName);
		Runtime.getRuntime().exec("cmd /c start "+fs.getAbsolutePath());
	}
  
	public static Boolean stopServer(){
		Runtime run=Runtime.getRuntime();
		try{
			System.out.println("killing the server..........");
			run.exec("taskkill /F /IM node.exe");
			run.exec("taskkill /F /IM cmd.exe");
			return true;
		}catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static Boolean checkServerIsRunning(int port){
		boolean isServerRunning=false;
		ServerSocket server;
		try{
			
			server=new ServerSocket(port);
			System.out.println("now its running on port "+port);
			server.close();
		}catch(IOException e){
			//If control comes here, then it means that the port is in use
			e.printStackTrace();
			System.out.println("sever is running");
			isServerRunning=true;
		}finally {
			server=null;
		}
		return isServerRunning;
	}
}
