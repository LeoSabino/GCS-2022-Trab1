import java.util.ArrayList;
import java.util.Scanner;

public class Operador {

    private ArrayList<Usuario> usuario;
    private ArrayList<Medico> medico= new ArrayList<>();
    private ArrayList<Paciente> paciente= new ArrayList<>();
    private ArrayList<Administrador> administrador = new ArrayList<>();

    private ArrayList<Authorization> authorizations = new ArrayList<>();
    private Scanner in = new Scanner(System.in);
    private int id=0;



    public Operador() {
        usuario = new ArrayList<Usuario>();
    }

    public void cadastraUsuario(Usuario user){
        usuario.add(user);
        if (user.getTipo().equals("Medico")){
            this.medico.add((Medico) user);
        }
        if (user.getTipo().equals("Paciente")){
            this.paciente.add((Paciente) user);
        }
        if (user.getTipo().equals("Administrador")){
            this.administrador.add((Administrador) user);
        }
    }

    public Usuario escolheUser(String id){
        for (Usuario usuarios: usuario ){
            if (usuarios.getId().equals(id)){
                return usuarios;
            }
        }
        return null;
    }

    public void listaUser() {
        for (Usuario usuarios : usuario) {
            System.out.println(usuarios.getId()+","+usuarios.getNome()+ ","+usuarios.getTipo());
        }
    }

    public Paciente getPaciente(String id) {
        for (Paciente pacientes: paciente) {
            if (pacientes.getId().equals(id)) {
                return pacientes;
            }
        }
        return null;
    }

    public void printaPaciente(){
        for (Paciente pacientes:paciente){
            System.out.println(pacientes.getId()+","+pacientes.getNome());
        }
    }

    public void criaAutorizacao(Medico medico, Paciente paciente) {
        id++;
        System.out.println("=====================");
        System.out.println("Insira o dia");
        int dia = in.nextInt();
        System.out.println("insira o mes");
        int mes = in.nextInt();
        System.out.println("insira o ano");
        int ano = in.nextInt();
        System.out.println("=====================");
        System.out.println("Escolha o Exame:");
        System.out.println("------------------");
        System.out.println("[1] Raio-x");
        System.out.println("[2] Tomografia");
        System.out.println("[3] Sangue");
        System.out.println("[4] Prostata");
        System.out.println("[5] Endoscopia");
        System.out.println("[6] Colonoscopia");
        System.out.println("[7] Urina");
        System.out.println("[8] Ecocardiograma");
        System.out.println("[9] Ultrasonografia");
        System.out.println("[10] Eletrocardiograma");
        int opcao = in.nextInt();
        String exame = "";
        switch (opcao) {
            case 1:
                exame = "Raio-x";
                break;
            case 2:
                exame = "Tomografia";
                break;
            case 3:
                exame = "Sangue";
                break;
            case 4:
                exame = "Prostata";
                break;
            case 5:
                exame = "Endoscopia";
                break;
            case 6:
                exame = "Colonoscopia";
                break;
            case 7:
                exame = "Urina";
                break;
            case 8:
                exame = "Ecocardiograma";
                break;
            case 9:
                exame = "Ultasonografia";
                break;
            case 10:
                exame = "Eletrocardigrama";
                break;
            default:
                System.out.println("numero invalido");
        }
        Authorization authorization = new Authorization(id, ano, mes, dia, medico.getNome(), paciente.getNome(), exame);
        authorizations.add(authorization);

    }

}