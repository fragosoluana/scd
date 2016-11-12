package br.cefetrj.scd.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.scd.bean.PerguntaBeanRemote;
import br.cefetrj.scd.bean.RespostaBeanRemote;
import br.cefetrj.scd.bean.UsuarioBeanRemote;

@WebServlet("/resposta/registrar")
public class RegistrarRespostaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	RespostaBeanRemote respostaBeanRemote;

	@EJB
	PerguntaBeanRemote perguntaBeanRemote;

	@EJB
	UsuarioBeanRemote usuarioBeanRemote;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(respostaBeanRemote.registrar(usuarioBeanRemote.getUsuarioEmail("r@h.com"), 
				perguntaBeanRemote.getPerguntaId("4"), "Procura no google, po")) {

			response.getWriter().append(String.valueOf("Resposta realizada com sucesso"));
		} else {
			response.getWriter().append(String.valueOf("Houve algum problema e a resposta não foi salva"));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
