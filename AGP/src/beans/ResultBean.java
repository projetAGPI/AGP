package beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;


@ManagedBean
@RequestScoped
public class ResultBean {
	public ResultBean() {
		
	}
	
	public String getOffersResult(){
		return "";
	}
	
	public void setOffersResult(String offers){
	}



}

