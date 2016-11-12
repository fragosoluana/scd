package br.cefetrj.scd.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.scd.bean.TemaBeanRemote;

@WebServlet("/tema/registrar")
public class RegistrarTemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	TemaBeanRemote temaBeanRemote;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(temaBeanRemote.registrar("Matematica")) {
			response.getWriter().append(String.valueOf("Cadastro realizado com sucesso"));
		} else {
			response.getWriter().append(String.valueOf("Tema já existe"));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
