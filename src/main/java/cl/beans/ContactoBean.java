package cl.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.ibatis.session.SqlSession;
import cl.mybatis.MyBatisUtil;
import cl.mybatis.pojos.Contacto;
import java.util.List;

@ManagedBean
@RequestScoped


public class ContactoBean {
	
	private Contacto contacto;

	public ContactoBean() {
		contacto = new Contacto();
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	
//************************************************************	
	public String guardar() {
		//Asignar un id por defecto
		contacto.setId(-1);
		SqlSession session = new MyBatisUtil().getSession();
		if(session != null) {
			try {
				 session.insert("Contacto.insertarContacto", contacto);
				 session.commit();
			}finally{
				session.close();
			}
		}else {
			System.out.println("ERROR");
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","contacto Creado"));
		return "index"; 
	}
	

	
//*********************************************************************	

	
	public List<Contacto> getContactos(){
		
		List<Contacto> lista = null;
				
		SqlSession session = new MyBatisUtil().getSession();
		if(session != null){
			try{
					lista = session.selectList("Contacto.getContactos");
						
					//	session.commit();							
					//	session.delete("Contacto.deleteContactos",contacto);
				
				System.out.println("esto es "+ contacto.getNombre());
				session.commit();				
				
				System.out.println("Error");
				
				System.out.println("esto es "+ contacto.getNombre());
			}finally{
				session.close();
				
			}
			
			
		}else{
			
			System.out.println("Error");
			
			
		}
		
		return lista;
				
		
		
		
		
	}
	
	
//******************************************************************************	
	
public String eliminar(){
		
		
		System.out.println("Error6666666888");
		
		//asignar un id por defecto
		contacto.setId(-1);
		SqlSession session = new MyBatisUtil().getSession();
		if(session != null){
			try{
			//	session.insert("Contacto.insertarContacto",contacto);
			//	session.commit();
				
				
					session.delete("Contacto.deleteContactos",contacto);
				
				System.out.println("esto es "+ contacto.getNombre());
				session.commit();
				
				
				System.out.println("Error");
				
				System.out.println("esto es "+ contacto.getNombre());
			}finally{
				session.close();
				
			}
			
			
		}else{
			
			System.out.println("Error");
			
			
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso contacto creado",null));
		return "index";
		
	}
	

	
		
	
}
