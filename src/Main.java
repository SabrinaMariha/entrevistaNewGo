import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Senha senha;

        Scanner sc = new Scanner(System.in);
        String ap = """
                    ● Tamanho mínimo: 10;
                    ● Tamanho máximo: 30;
                    ● Tem que ter ao menos uma letra maiúscula;
                    ● Tem que ter ao menos uma letra minúscula;
                    ● Tem que ter ao menos um número;
                    ● Tem que ter ao menos um símbolo (qualquer símbolo que não é
                    caractere nem dígito);\n
                    """;
        System.out.println(ap);
        boolean senhaValida=false;
        do {

            System.out.println("\n\nDigite a senha: ");
            senha = new Senha(sc.nextLine());
            senhaValida=senha.validaSenha();
        }while(!senhaValida);

        System.out.println("Força da senha: "+senha.forcaSenha());

    }
}