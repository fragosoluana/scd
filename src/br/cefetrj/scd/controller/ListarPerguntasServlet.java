package br.cefetrj.scd.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.scd.bean.PerguntaBeanRemote;
import br.cefetrj.scd.entity.Pergunta;

@WebServlet("/perguntas")
public class ListarPerguntasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PerguntaBeanRemote perguntaBeanRemote;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for (Pergunta pergunta : perguntaBeanRemote.getPerguntas()) {
			response.getWriter().append(pergunta.getDescricao());
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
