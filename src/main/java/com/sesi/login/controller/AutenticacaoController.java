package com.sesi.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sesi.login.model.Usuario;
import com.sesi.login.repository.PapelRepository;
import com.sesi.login.repository.UsuarioRepository;

@Controller
public class AutenticacaoController {
	
	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	@Autowired
	private PapelRepository papelRepositorio;
	
	@Autowired
	private BCryptPasswordEncoder encoderSenha;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registrar")
	public String mostrarFormularioRegistro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registrar";
		
	}
	
	public String registrarUsuario(Usuario usuario, Model modelo) {
		if(usuarioRepositorio.findByNomeUsuario(usuario.getNomeUsuario()) != null) {
			modelo.addAttribute("mensagem","Nome do usuario já existe");
		}
			return "registrar";
	}
}
