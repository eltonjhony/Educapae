package com.educapae.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.educapae.model.Deficiencia;
import com.educapae.repository.Deficiencias;
import com.educapae.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Deficiencia.class)
public class DeficienciaConverter implements Converter {

	private Deficiencias deficiencias;
	
	public DeficienciaConverter() {
		deficiencias = CDIServiceLocator.getBean(Deficiencias.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Deficiencia retorno = null;

		if (value != null) {
			System.out.println("converter saporra");
			Long id = new Long(value);
			retorno = deficiencias.porId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		Deficiencia deficienciaVO = (Deficiencia) value;
		if (value != null) {
			return (deficienciaVO.getId() == null ? null : deficienciaVO.getId().toString());
		}

		return "";
	}

}
