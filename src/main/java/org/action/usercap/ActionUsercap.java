package org.action.usercap;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dao.usercap.DaoImplUsercap;
import org.dao.usercap.DaoUsercap;
import org.modelo.usercap.Usercap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@SuppressWarnings("serial")
public class ActionUsercap extends ActionSupport implements ModelDriven<Usercap>{
	
	private Usercap usercap = new Usercap();
	private DaoUsercap dao = new DaoImplUsercap();
	private List<Usercap> listaUsercaps = new ArrayList<Usercap>();
	
	public String execute() {
		return SUCCESS;
	}
	
	public String add() {
		dao.addUsercap(usercap);
		return SUCCESS;
	}
	
	public String list() {
		setListaUsercaps(dao.listUsercap());
		return SUCCESS;
	}
	
	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		usercap = dao.getUsercapById(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}
	
	public String delite() {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		dao.deleteUsercap(Integer.parseInt(request.getParameter("id")));
		return SUCCESS;
	}
	
	@Override
	public Usercap getModel() {
		return usercap;
	}
	
	//GETTERS AND SETTER OF USERCAP AND LISTUSERCAP
	public Usercap getUsercap() {
		return usercap;
	}
	public void setUsercap(Usercap usercap) {
		this.usercap = usercap;
	}
	public List<Usercap> getListaUsercaps() {
		return listaUsercaps;
	}
	public void setListaUsercaps(List<Usercap> listaUsercaps) {
		this.listaUsercaps = listaUsercaps;
	}

}
