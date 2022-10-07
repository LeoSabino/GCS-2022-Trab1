import java.util.ArrayList;

public class Operador {

    private ArrayList<Usuario> usuario;
    private ArrayList<Medico> medico= new ArrayList<>();
    private ArrayList<Paciente> paciente= new ArrayList<>();
    private ArrayList<Administrador> administrador = new ArrayList<>();

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

}
