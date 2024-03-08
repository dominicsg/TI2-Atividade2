package com.ti2cc;

import java.util.Scanner;

public class Principal {

	public static Scanner Sc = new Scanner(System.in);

	public static Usuario InsertUser() {

		Usuario user = new Usuario();

		System.out.println("Digite o codigo do usuario: ");
		user.setCodigo(Sc.nextInt());
		Sc.nextLine();
		System.out.println("Digite o login: ");
		user.setLogin(Sc.nextLine());
		System.out.println("Digite a senha: ");
		user.setSenha(Sc.nextLine());
		System.out.println("Digite o sexo: ");
		user.setSexo(Sc.nextLine().charAt(0));


		return user;
	};
	
	public static Usuario UpdateUser(int codigo) {

		Usuario user = new Usuario();
		user.setCodigo(codigo);
		System.out.println("Digite o login: ");
		user.setLogin(Sc.nextLine());
		System.out.println("Digite a senha: ");
		user.setSenha(Sc.nextLine());
		System.out.println("Digite o sexo: ");
		user.setSexo(Sc.nextLine().charAt(0));


		return user;
	};

	public static void main(String[] args) {
		DAO dao = new DAO();
		dao.conectar();
		boolean status;

		int opcao;

		System.out.println("1 - Criar Usuario\n"
				+ "2 - Buscar Usuario\n"
				+ "3 - Atualizar Usuario\n"
				+ "4 - Deletar Usuario\n"
				+ "5 - Buscar todos os Usuarios");

		opcao = Sc.nextInt();

		switch(opcao) {
		case 1:
			Usuario usuario = InsertUser();
			status = dao.inserirUsuario(usuario);
			if (status ==true) {
				System.out.println("Usuario cadastrado com sucesso!");
			}
			break;
		case 2:
			int num;
			Usuario user = null;
			System.out.println("Digite o ID do usuario: ");
			num = Sc.nextInt();
			user = dao.getUsuarioID(num);
			System.out.println(user);
			break;
		case 3:
			int num_att;
			Usuario user_att = null;
			System.out.println("Digite o ID do usuario que deseja atualizar: ");
			num_att = Sc.nextInt();
			Sc.nextLine();
			user_att = UpdateUser(num_att);
			status = dao.atualizarUsuario(user_att);
			if (status ==true) {
				System.out.println("Usuario deletado com sucesso!");
			}
			break;
		case 4:
			int num_delete;
			System.out.println("Digite o ID do usuario: ");
			num_delete = Sc.nextInt();
			status = dao.excluirUsuario(num_delete);
			if (status ==true) {
				System.out.println("Usuario deletado com sucesso!");
			}
			break;
		case 5:
			dao.getUsuarios();
			break;
			}








		dao.close();
	}		


}
