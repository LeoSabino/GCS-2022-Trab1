import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Sistema {

    private Operador operador;
    private Usuario usuario;

    private Scanner in;

    public Sistema() {
        operador = new Operador();
        in = new Scanner(System.in);
    }
    public String[] leArquivo(String nome) {
        String[] linhas = new String[100];
        int contador = 1;
        try {
            FileReader fr;
            fr = new FileReader(nome);
            BufferedReader bf;
            bf = new BufferedReader(fr);
            String linha = bf.readLine();
            linhas[0] = linha;
            while (linha != null) {
                linha = bf.readLine();
                linhas[contador] = linha;
                contador++;
            }
        } catch (Exception e) {
            System.out.println("arquivo não encontrado");
        }
        return linhas;
    }

    public void cadastra() {
        String[] linhas = leArquivo("GCS.txt");
        String id;
        String nome;
        String tipo;
        for (int i = 0; i < 15; i++) {
            id = linhas[i].split(",")[0];
            nome = linhas[i].split(",")[1];
            tipo = linhas[i].split(",")[2];
            if (tipo.equals("Medico")) {
                Medico medico = new Medico(id, nome, tipo);
                operador.cadastraUsuario(medico);
            }
            if (tipo.equals("Paciente")) {
                Paciente paciente = new Paciente(id, nome, tipo);
                operador.cadastraUsuario(paciente);
            }
            if (tipo.equals("Administrador")) {
                Administrador administrador = new Administrador(id, nome, tipo);
                operador.cadastraUsuario(administrador);
            }
        }
    }

    public void menuUser() {
        int opcao = 0;
        do {
            System.out.println("===============================");
            System.out.println("Escolha seu Usuarios");
            System.out.println("[1] Escolher Usuario");
            System.out.println("[2] Ver lista de Usuarios");
            System.out.println("[3] Sair");
            System.out.println("===============================");
            System.out.print("Digite a opcao desejada: ");
            opcao = in.nextInt();
            in.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite seu ID: ");
                    try {
                        usuario = operador.escolheUser(in.nextLine());
                        if (usuario.getTipo().equals("Medico")) {
                            Medico medico = (Medico) usuario;
                            menuMedico(medico);
                        }
                        if (usuario.getTipo().equals("Paciente")) {
                            Paciente paciente = (Paciente) usuario;
                            menuPaciente(paciente);
                        }
                        if (usuario.getTipo().equals("Administrador")) {
                            Administrador administrador = (Administrador) usuario;
                            menuADM(administrador);
                        }
                    }
                    catch (Exception e){
                        System.out.println("usuario não existe");
                    }
                    break;
                case 2:
                    operador.listaUser();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcao invalida!");

            }
        } while (opcao != 3);
    }

    public void menuMedico(Medico medico){
        int opcao=0;
        do {

            System.out.println("===============================");
            System.out.println("[1] Criar Autorizacao");
            System.out.println("[2] Lista de Autorizacoes");
            System.out.println("[3] Trocar Usuario");
            System.out.println("[4] Salvar autorizacoes em arquivo");
            System.out.println("[5] Ver médicos existentes.");
            System.out.println("[6] Sair");
            System.out.println("===============================");
            System.out.print("Digite a opcao desejada: ");
            opcao = in.nextInt();
            in.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Crie sua autorizacao");
                    System.out.println("=====================");
                    System.out.println("Escolha o Paciente");
                    operador.printaPaciente();
                    System.out.println("Digite a ID do paciente:");
                    Paciente paciente=operador.getPaciente(in.nextLine());
                    operador.criaAutorizacao(medico,paciente);
                    break;
                case 2:
                    operador.printaAutorizacoes();
                    break;
                case 3:
                    menuUser();
                    break;
                case 4: System.out.print("Nome do arquivo: ");
                        String nomeArquivo = in.nextLine();
                        try{
                            if(operador.salvaDadosArquivo(nomeArquivo))
                            System.out.println("Arquivo gravado");
                        }
                        catch(Exception e){
                            System.out.println("Erro na gravação do arquivo");
                        }

                case 5: operador.printaMedicos();
                break;

                default:
                    System.out.println("Numero invalido");
            }
        }while (opcao!=6);
    }

    public void menuPaciente(Paciente paciente) {
        int opcao = 0;
        do {
            System.out.println("===============================");
            System.out.println("[1] Marcar exame como realizado");
            System.out.println("[2] Ver autorizacoes de exame");
            System.out.println("[3] Trocar Usuario");
            System.out.println("[4] Sair");
            System.out.println("===============================");
            System.out.print("Digite a opcao desejada: ");
            opcao = in.nextInt();
            in.nextLine();
            switch (opcao) {
                case 1:
                    operador.printaAutoNome(paciente.getNome());
                    System.out.println("Digite a data de realização do exame: ");
                    System.out.println("Insira o ano");
                    int ano = in.nextInt();
                    System.out.println("Insira o mes");
                    int mes = in.nextInt();
                    System.out.println("Insira o dia");
                    int dia = in.nextInt();
                    System.out.println("Digite o id do exame realizado:");
                    operador.removeAutorizacao(in.nextInt(), ano, mes, dia);
                    break;
                case 2:
                    operador.printaAutoNome(paciente.getNome());
                case 3:
                    menuUser();
                case 4:
                    break;
            }
        } while (opcao != 4);
    }



    public void menuADM(Administrador administrador){
        int opcao = 0;
        do {
            System.out.println("===============================");
            System.out.println("[1] Criar novo Usuario");
            System.out.println("[2] Trocar Usuario");
            System.out.println("[3] Estatísticas Gerais");
            System.out.println("[4] Sair");
            System.out.println("===============================");
            System.out.print("Digite a opcao desejada: ");
            opcao = in.nextInt();
            in.nextLine();
            switch (opcao) {
                case 1: System.out.println("Digito o ID do usuario");
                String id= in.nextLine();
                System.out.println("Digite o Nome do usuario");
                String nome= in.nextLine();
                System.out.println("Digite o tipo (Medico/Paciente/Administrador");
                String tipo= in.nextLine();
                if (tipo.equals("Medico")) {
                Medico medico = new Medico(id, nome, tipo);
                operador.cadastraUsuario(medico);
                }
                if (tipo.equals("Paciente")) {
                Paciente paciente = new Paciente(id, nome, tipo);
                operador.cadastraUsuario(paciente);
                }
                if (tipo.equals("Administrador")) {
                Administrador adm = new Administrador(id, nome, tipo);
                operador.cadastraUsuario(adm);
                }
                break;
                case 2:
                    menuUser(); 
                    break;
                case 3:
                 System.out.println("Numero de Medicos:");
                    System.out.println(operador.contMedico());
                    System.out.println("=========================");
                    System.out.println("Numero de Pacientes");
                    System.out.println(operador.contPaciente());
                    System.out.println("=========================");
                    System.out.println("=========================");
                    System.out.println("Numero de autorizacoes emitidas");
                    System.out.println(operador.contaAutorizacoes());
                    System.out.println("=========================");
                    System.out.println("% de autorizacoes realizadas");
                    System.out.println((operador.contaAutorizacoesFeitas()/(operador.contaAutorizacoes()))*100+" %");
                    System.out.println("Numero Administradores");
                    System.out.println(operador.contAdm());
                    break;
                default: break;
            }
        } while (opcao != 4);
    }

}
