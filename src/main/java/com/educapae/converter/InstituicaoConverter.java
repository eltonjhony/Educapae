package com.educapae.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.educapae.model.Instituicao;
import com.educapae.repository.Instituicoes;
import com.educapae.util.cdi.CDIServiceLocator;


@FacesConverter(forClass = Instituicao.class)
public class InstituicaoConverter implements Converter {

	
	private Instituicoes instituicoes;
	
	public InstituicaoConverter() {
		instituicoes = CDIServiceLocator.getBean(Instituicoes.class);
	}
	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Instituicao retorno = null;

		if (value != null) {
			System.out.println("converter saporra");
			Long id = new Long(value);
			retorno = instituicoes.porId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		Instituicao instituicaoVO = (Instituicao) value;
		if (value != null) {
			return (instituicaoVO.getCodigo() == null ? null : instituicaoVO.getCodigo().toString());
		}

		return "";
	}

}
