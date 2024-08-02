package org.dao.usercap;

import java.util.List;

import org.modelo.usercap.Usercap;

public interface DaoUsercap {

	public void addUsercap(Usercap usercap);
	public List<Usercap> listUsercap();
	public Usercap getUsercapById(int id);
	public void deleteUsercap(int id);
}
