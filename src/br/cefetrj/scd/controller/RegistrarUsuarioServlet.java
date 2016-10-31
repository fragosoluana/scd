package br.cefetrj.scd.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.scd.bean.UsuarioBeanRemote;
import br.cefetrj.scd.entity.Usuario;

@WebServlet("/registrar")
public class RegistrarUsuarioServlet extends HttpServlet {
	
	@EJB
	private UsuarioBeanRemote usuarioBeanRemote;
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = usuarioBeanRemote.registrar(new Usuario("Luana", "teste", "l@h.com", true));
		response.getWriter().append(msg);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
