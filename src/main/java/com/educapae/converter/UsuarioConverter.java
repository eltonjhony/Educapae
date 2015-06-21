package com.educapae.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.educapae.model.Usuario;
import com.educapae.repository.Usuarios;
import com.educapae.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	private Usuarios usuarios;
	
	public UsuarioConverter() {
		usuarios = CDIServiceLocator.getBean(Usuarios.class);
	}


	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Usuario retorno = null;

		if (value != null) {
			System.out.println("converter saporra");
			Long id = new Long(value);
			retorno = usuarios.porId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		Usuario usuarioVO = (Usuario) value;
		if (value != null) {
			return (usuarioVO.getId() == null ? null : usuarioVO.getId().toString());
		}

		return "";
	}

}
