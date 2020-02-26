package com.javaentrenamientos.ws.client;

import java.rmi.RemoteException;

import com.javaentrenamientos.ws.bean.BeanLogin;
import com.javaentrenamientos.ws.service.ImplLogin;
import com.javaentrenamientos.ws.service.ImplLoginProxy;

public class Principal {

	public static void main(String[] args) {

		ImplLogin iface = new ImplLoginProxy(
				"http://localhost:8080/ValidaCredenciales/services/ImplLogin");
		BeanLogin obj = new BeanLogin();
		obj.setUsuario("srios");
		obj.setPassword("rios");

		try {
			obj = iface.validaLogin(obj);
			if(obj.getStatus() != null){
				System.out.println("welcome...");
			} else {
				System.out.println(obj.getMensaje());
			}
		} catch (RemoteException re) {
			re.printStackTrace();
		}

	}
}
