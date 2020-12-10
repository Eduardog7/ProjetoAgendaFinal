/*package br.com.acme.agenda.service;
import java.util.ArrayList;
import java.util.List;
import br.com.acme.agenda.model.Usuario;
import br.com.acme.agenda.service.ServiceLogin;

public class UsuarioService {
	
	public class ServiceLogin {
		
		public static List<Usuario> usuarios = new ArrayList<Usuario>();
		
		public static boolean login(String nome, String senha) {
			for(Usuario usuario : ServiceLogin.usuarios) {
				if((usuario.getNome().equals(nome)) && (usuario.getSenha().equals(senha))) {
					return true;
				}
		
			}
			return false;
			
		}
	
	
		public static void adicionarUsuario() {
			if (!ServiceLogin.login("angelo", "123")) {
				usuarios.add(new Usuario("angelo","angelo@iesp.edu.br","32233203","aaaaaaa 520","123"));
			}
		}
}


	public class ServiceLogin {
		
		public static List<Usuario> usuarios = new ArrayList<Usuario>();
		
		public static boolean login(String nome, String senha) {
			for(Usuario usuario : ServiceLogin.usuarios) {
				if((usuario.getNome().equals(nome)) && (usuario.getSenha().equals(senha))) {
					return true;
				}
		
			}
			return false;
			
		}
		
		public static void adicionarUsuario() {
			if (!ServiceLogin.login("angelo", "123")) {
				usuarios.add(new Usuario("angelo","angelo@iesp.edu.br","32233203","aaaaaaa 520","123"));
			}
		}
		
		//public void removerUsuario() {
		//	
		//}
		/*
		public static boolean removeUsuario(String nome) {
		    for(Usuario u:usuarios) {
		        if(u.getNome().equals(nome))
		        usuarios.remove(u);
		        return true;
		    }
		    return false;
		}
		
		public static void removendoUsuario(String nome) {
			for(int i = 0; i < usuarios.size(); i++)
		    {
		        Usuario u = usuarios.get(i);
		
		        if(u.getNome().equals(nome))
		        {
		            
		
		            // Remove.
		            usuarios.remove(u);
		
		          
		            break;
		        }
		    }
		}
	
}
	*/	

