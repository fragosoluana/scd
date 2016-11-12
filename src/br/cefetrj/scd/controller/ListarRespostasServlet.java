package br.cefetrj.scd.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefetrj.scd.bean.RespostaBeanRemote;
import br.cefetrj.scd.entity.Resposta;

@WebServlet("/pergunta/respostas")
public class ListarRespostasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private RespostaBeanRemote respostaBeanRemote;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for (Resposta resposta : respostaBeanRemote.getRespostas("4")) {
			response.getWriter().append(resposta.getDescricao());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
