package org.dao.usercap;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelo.usercap.Usercap;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class DaoImplUsercap implements DaoUsercap {
	
	@SessionTarget
	private Session session;
	
	@TransactionTarget
	private Transaction transaction;

	@Override
	public void addUsercap(Usercap usercap) {
		try {
			//System.out.println(usercap.getNombre());
			session.saveOrUpdate(usercap);
			
		} catch (Exception e) {
			System.out.println("Error el agregar");
			System.out.println("Exception: "+ e.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usercap> listUsercap() {
		List<Usercap> list = null;
		try {
			list = (List<Usercap>) session.createQuery("from Usercap").list();
		} catch (Exception e) { 
			System.out.println("Exception: "+ e.getMessage());
		}
		return list;
	}

	@Override
	public Usercap getUsercapById(int id) {
		Usercap usercap = null;
		try {
			usercap = (Usercap) session.get(Usercap.class, id);
		} catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}
		return usercap;
	}

	@Override
	public void deleteUsercap(int id) {
		Usercap usercap = null;
		try {
			usercap = (Usercap) session.get(Usercap.class, id);
			session.delete(usercap);
		} catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}

	}

}
