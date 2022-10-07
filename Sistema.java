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
        String[] linhas = leArquivo("GSC.txt");
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

}
