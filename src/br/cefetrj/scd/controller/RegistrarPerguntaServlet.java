package br.cefetrj.scd.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.scd.bean.PerguntaBeanRemote;
import br.cefetrj.scd.bean.TemaBeanRemote;
import br.cefetrj.scd.bean.UsuarioBeanRemote;

@WebServlet("/pergunta/registrar")
public class RegistrarPerguntaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PerguntaBeanRemote perguntaBeanRemote;
	
	@EJB
	private UsuarioBeanRemote usuarioBeanRemote;
	
	@EJB
	private TemaBeanRemote temaBeanRemote;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(perguntaBeanRemote.registrar(usuarioBeanRemote.getUsuarioEmail("r@h.com"), 
					temaBeanRemote.getTemaNome("Matematica"), "Qual é a fórmula de Baskaras?")) {
			response.getWriter().append(String.valueOf("Pergunta realizada com sucesso"));
		} else {
			response.getWriter().append(String.valueOf("Houve algum problema e a pergunta não foi salva"));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
