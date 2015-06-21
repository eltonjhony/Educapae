package com.educapae.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educapae.util.jsf.FacesUtil;

@Named
@SessionScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private HttpServletRequest request;
	
	@Inject
	private HttpServletResponse response;
	
	private String nome;
	
	public void preRender() {
		if("true".equals(request.getParameter("invalid"))) {
			FacesUtil.addErrorMessage("Usuário ou senha inválidos!");
		}
	}
	
	public void login() throws ServletException, IOException {
		RequestDispatcher dispacher = request.getRequestDispatcher("/j_spring_security_check");
		dispacher.forward(request, response);
		
		facesContext.responseComplete();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

}
