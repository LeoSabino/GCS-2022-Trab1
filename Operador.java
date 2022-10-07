import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Operador {

      private ArrayList<Usuario> usuario;
      private ArrayList<Medico> medico = new ArrayList<>();
      private ArrayList<Paciente> paciente = new ArrayList<>();
      private ArrayList<Administrador> administrador = new ArrayList<>();
      private ArrayList<Authorization> authorizationsFeitas = new ArrayList<>();
      private ArrayList<Authorization> authorizations = new ArrayList<>();
      private Scanner in = new Scanner(System.in);
      private int id = 0;

      public boolean salvaDadosArquivo(String nomeArquivo) {
          String linha = "";
        try {
              FileWriter fw = new FileWriter(nomeArquivo);
              BufferedWriter bw = new BufferedWriter(fw);
              for (Authorization a : authorizations) {
                  linha = a.geraResumoAutorizacao();
                  bw.write(linha);
            }
            bw.close();
        } catch (IOException e) {
              System.err.println("Erro: " + e);
            return false;
        }
        return true;
    }

    public int contAdm(){
          return administrador.size();
    }

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
        while(dia<=0 || dia >31){
              System.out.println("Pro favor insira um dia valido");
            System.out.println("Insira o dia");
            dia = in.nextInt();
        }
        System.out.println("insira o mes");
        int mes = in.nextInt();
        while(mes<=0|| mes > 12){
              System.out.println("Por favor insira um mes valido!");
            System.out.println("insira o mes");
            mes = in.nextInt();
        }
        System.out.println("insira o ano");
        int ano = in.nextInt();
        while(ano < 2010|| ano > 2025){
              System.out.println("Por favor insira um ano entre 2010-2025!");
            System.out.println("insira o ano");
            ano = in.nextInt();
        }
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
        Authorization authorization = new Authorization(id, dia, mes, ano, medico.getNome(), paciente.getNome(), exame);
        authorizations.add(authorization);
    }

    public void printaAutorizacoes() {
          System.out.println("Escolha qual lista que voce deseja:");
        System.out.println("[1] Filtro Exames");
        System.out.println("[2] Filtro Paciente");
        int opcao = 0;
        opcao = in.nextInt();
        in.nextLine();
        switch (opcao) {
              case 1:
                  System.out.println("Digite o exame:"); //falta colocar por data
                String exame = in.nextLine();
                for (Authorization authorization : authorizations) {
                      if (authorization.getExam().equals(exame)) {
                          System.out.println("Autorizacao:"+ authorization.getId() + "," + authorization.getDia() + "-" +
                                authorization.getMes() + "-" + authorization.getAno() + ", Paciente: " + authorization.getPatientsName() +
                                ", Medico:" + authorization.getDoctorsName() + "," + authorization.getExam());
                    }
                }
                break;
            case 2:
                System.out.println("Digite o paciente"); //falta colocar por data
                String paciente = in.nextLine();

                dayOrderArray();

                for (Authorization authorization : authorizations) {
                      if (authorization.getPatientsName().equals(paciente)) {
                          System.out.println("Autorizacao: "+ authorization.getId() + ", " + authorization.getDia() + "-" +
                                authorization.getMes() + "-" + authorization.getAno() + ", Paciente: " + authorization.getPatientsName() +
                                ", Medico: " + authorization.getDoctorsName() + ", " + authorization.getExam());
                    }
                }
                break;
            default:
                System.out.println("Número inválido!");
                break;
        }
    }

    public void printaAutoNome(String nome) {
          dayOrderArray();
          for (Authorization authorization : authorizations) {
              if (authorization.getPatientsName().equalsIgnoreCase(nome)) {
                  System.out.println("Autorizacao: " + authorization.getPendente() + ", " + authorization.getId() + "," + authorization.getDia() + "-" +
                        authorization.getMes() + "-" + authorization.getAno() + ", Paciente: " + authorization.getPatientsName() +
                        ", Medico: " + authorization.getDoctorsName() + ", " + authorization.getExam());
                }
            if (authorization.getDoctorsName().equalsIgnoreCase(nome)) {
                  System.out.println("Autorizacao: " + authorization.getPendente() + ", " + authorization.getId() + ", " + authorization.getDia() + "-" +
                        authorization.getMes() + "-" + authorization.getAno() + ", Paciente: " + authorization.getPatientsName() +
                        ", Medico: " + authorization.getDoctorsName() + "," + authorization.getExam());
                }
            }

    }

    public void removeAutorizacao(int id, int ano, int mes, int dia){
          for (Authorization authorization:authorizations){

              if (authorization.getId()==(id)){
                  int diasBrutos = ano*365+mes*30+dia;
                  if(diasBrutos-authorization.getDiasBrutos()>30) System.out.println("A data expirou");
                else if(diasBrutos<authorization.getDiasBrutos()) System.out.println("Data inválida");
            }
            else System.out.println("não tem autorizacao com esse id");
        }
    }

    public void printaMedicos(){
          for (Medico medicos:medico){
              System.out.println("===================================");
            System.out.println("Nome: " + medicos.getNome());
            System.out.println("Tipo: " + medicos.getTipo());
            System.out.println("ID: " + medicos.getId());
            System.out.println("===================================");
        }
    }
    public double contaAutorizacoes() {
          return authorizations.size();
    }

    public double contaAutorizacoesFeitas() {

          return authorizationsFeitas.size();
    }
public int contMedico(){
          return medico.size();
    }
    public int contPaciente(){
          return paciente.size();
    }

    public void dayOrderArray () {  

          int n = authorizations.size();  
           for(int i=0; i < n; i++){  
                   for(int j=1; j < (n-i); j++){  
                              if(authorizations.get(j-1).getDiasBrutos() > authorizations.get(j).getDiasBrutos()){    
                                   Collections.swap(authorizations, j-1, j);
                            }

                 }  
        }
    }
}