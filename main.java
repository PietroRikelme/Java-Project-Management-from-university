import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Usuario {
    String nome;
    String email;
    String cargo;

    Usuario(String nome, String email, String cargo) {
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return nome + " (" + cargo + ") - " + email;
    }
}

class Projeto {
    String nome;
    String descricao;
    LocalDate dataInicio;
    LocalDate dataFim;
    Usuario gerente;

    Projeto(String nome, String descricao, LocalDate inicio, LocalDate fim, Usuario gerente) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = inicio;
        this.dataFim = fim;
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Projeto: " + nome + " | Gerente: " + gerente.nome +
               " | Início: " + dataInicio + " | Fim: " + dataFim;
    }
}

class Equipe {
    String nome;
    List<Usuario> membros = new ArrayList<>();

    Equipe(String nome) {
        this.nome = nome;
    }

    void adicionarMembro(Usuario u) {
        membros.add(u);
    }

    @Override
    public String toString() {
        return "Equipe " + nome + " com " + membros.size() + " membros";
    }
}

// os nomes e emails são exemplos

public class main {
    public static void main(String[] args) {
        
        Usuario gerente = new Usuario("Ana Silva", "ana@email.com", "Gerente");
        Usuario dev1 = new Usuario("Carlos Souza", "carlos@email.com", "Desenvolvedor");
        Usuario dev2 = new Usuario("Marina Costa", "marina@email.com", "Analista");

        Equipe equipe = new Equipe("Equipe Backend");
        equipe.adicionarMembro(dev1);
        equipe.adicionarMembro(dev2);

        Projeto projeto = new Projeto(
                "Sistema de Gestão",
                "Sistema para gerenciar usuários, equipes e projetos",
                LocalDate.now(),
                LocalDate.now().plusMonths(2),
                gerente
        );

        System.out.println(projeto);
        System.out.println(equipe);
        System.out.println("Membros da equipe:");
        for (Usuario u : equipe.membros) {
            System.out.println(" - " + u);
        }
    }
}
