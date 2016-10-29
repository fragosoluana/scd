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

@WebServlet("/forumServlet")
public class ForumServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private UsuarioBeanRemote usuarioBeanRemote;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario("Luana", 21);
		usuario = usuarioBeanRemote.insert(usuario);
		response.getWriter().append("Served at: ").append(usuario.getId().toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
