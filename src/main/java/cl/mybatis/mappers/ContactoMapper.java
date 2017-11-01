package cl.mybatis.mappers;


import java.util.List;
import cl.mybatis.pojos.Contacto;


public interface ContactoMapper {
	void insertarContacto(Contacto contacto);
	List<Contacto> getContactos();

}
