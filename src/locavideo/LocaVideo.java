package locavideo;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import locavideo.Classes.Cliente;
import locavideo.Classes.Fita;
import locavideo.Classes.Serialization;
import locavideo.Classes.Database;

public class LocaVideo {
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        input.useDelimiter("\n");
        System.out.println("**BEM VINDO**");
        displayEscolhas();
    }
    
    public static void displayEscolhas() {
        int option = 0;

        do{
            System.out.println("Escolha uma Opção");
            System.out.println("1 - Cadastra Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Cadastra Fita");
            System.out.println("4 - Listar Fitas");
            System.out.println("5 - Locar");
            System.out.println("6 - Devolver");
            System.out.println("7 - Sair");

            System.out.print("-> ");
            
            option = input.nextInt();
            
            if(option == 1 ){
                cadastrarCliente();
                break;
            }
            else if(option == 2){
                listarClientes();
                break;
            }
            else if(option == 3 ){
                cadastrarFita();
                break;
            }
            else if(option == 4 ){
                listarFitas();
                break;
            }
            else if(option == 5 ){
                locarFita();
                break;
            }
            else if(option == 6 ){
                devolverFita();
                break;
            }
            else if(option == 7 ){
                break;
            }
            else{
                System.out.println("**Comando invalido**");
            }

        }while(option != 0 );
    }
    
    public static void limparDisplay(){
        for (int i = 0; i < 5; ++i) System.out.println ();
    }
    
    public static void cadastrarCliente(){
        Database database = new Database();
        boolean exists = (new File("clientes.ser")).exists();
        if(exists){
            database = (Database)Serialization.read("clientes.ser");
        }
        
        ArrayList<Cliente> Clientes = database.getClientes();
        
        System.out.println("*Cadastro de Cliente*");
        String nomeCliente;
        String cpfCliente;
        String telefoneCliente;
        
        System.out.println("Informe o Nome: ");
        nomeCliente = input.next();

        System.out.println("Informe o CPF: ");
        cpfCliente = input.next();
        
        System.out.println("Informe o Telefone: ");
        telefoneCliente = input.next();
        
        Cliente cli = new Cliente(nomeCliente, cpfCliente, telefoneCliente);
        Clientes.add(cli);
        
        Serialization.write(database, "clientes.ser");
        
        System.out.println("Cliente Cadastrado com Sucesso!");
        System.out.println(nomeCliente+", "+cpfCliente);
        limparDisplay();
        displayEscolhas();
    }
    
    private static void listarClientes() {
        Database database = (Database)Serialization.read("clientes.ser");
        ArrayList<Cliente> Clientes = database.getClientes();
        
        if(Clientes.isEmpty()){
            System.out.println("Não Possui Clientes Dadastrados!");
            limparDisplay();
            displayEscolhas();
        }
        else
        {
            System.out.println("*Listagem de Clientes*");
            for(Cliente cli : Clientes){
                System.out.println("Nome: " + cli.getNome() + " Cpf: " + cli.getCpf() + " Telefone: " + cli.getTelefone());
            }
            limparDisplay();
            displayEscolhas();
        }
    }
    
    public static void cadastrarFita(){
        Database database = new Database();
        boolean exists = (new File("fitas.ser")).exists();
        if(exists){
            database = (Database)Serialization.read("fitas.ser");
        }
        
        ArrayList<Fita> Fitas = database.getFitas();
        
        System.out.println("*Cadastro de Fita*");
        
        System.out.println("Informe o Nome: ");
        String nomeFita = input.next();
        
        System.out.println("Informe o Genero: ");
        String generoFita = input.next();
        
        int opcaoCategoria = 0; String categoriaFita = "";
        System.out.println("Informe a Categoria: ");
        do{
            System.out.println("1 - Lançamento, 8.99, 1 dia");
            System.out.println("2 - Novo, 5.99, 3 dia");
            System.out.println("3 - Normal, 3.99, 5 dia");
            opcaoCategoria = input.nextInt();
            
            if(opcaoCategoria == 1){
                categoriaFita = "Lançamento";
                break;
            }
            else if(opcaoCategoria == 2){
                categoriaFita = "Novo";
                break;
            }
            else if(opcaoCategoria == 3){
                categoriaFita = "Normal";
                break;
            }
            else
                System.out.println("**Opção Invalida!**");
        }while(opcaoCategoria != 0 );
        
        Fita fita = new Fita(nomeFita, generoFita, categoriaFita);
        Fitas.add(fita);
        
        Serialization.write(database, "fitas.ser");
        
        System.out.println("Fita Cadastrada com Sucesso!");
        System.out.println(nomeFita+", "+categoriaFita);
        limparDisplay();
        displayEscolhas();
    }
    
    private static void listarFitas() {
        Database database = (Database)Serialization.read("fitas.ser");
        ArrayList<Fita> Fitas = database.getFitas();
        
        if(Fitas.isEmpty()){
            System.out.println("Não Possui Fitas Cadastrados!");
            limparDisplay();
            displayEscolhas();
        }
        else
        {
            for(Fita fita : Fitas){
                System.out.println("Nome: " + fita.getNome() + " Genero: " + fita.getGenero() + " Categoria: " + fita.getCategoria());
            }
            limparDisplay();
            displayEscolhas();
        }
    }
      
    public static void locarFita(){
        System.out.println("*Cadastro de Locação de Fita*");
        
        System.out.println("Informe o CPF do cliente: ");
        String cpfClienteLocacao = input.next();
        
        System.out.println("Informe o NOME da fita: ");
        String idFitaLocacao = input.next();
        
        System.out.println("Fita Alugada com Sucesso!");
        limparDisplay();
        displayEscolhas();
    }
    
    public static void devolverFita(){
        System.out.println("*Cadastro de Devolução de Fita*");
        
        System.out.println("Informe o CPF do cliente: ");
        String cpfClienteDevolucao = input.next();
        
        System.out.println("Informe o NOME da fita: ");
        String idFitaDevolucao = input.next();
        
        System.out.println("Fita Devolvida com Sucesso!");
        limparDisplay();
        displayEscolhas();
    }
}
