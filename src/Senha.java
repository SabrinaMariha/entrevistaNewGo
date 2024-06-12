import java.util.Scanner;

public class Senha {
    private String conteudo;
    private Scanner sc = new Scanner(System.in);

    public Senha(String conteudo) {
        this.conteudo = conteudo;

    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    public boolean validaSenha(){
        boolean valida=false;
        boolean letraMaiuscula=false;
        boolean letraMinuscula=false;
        boolean letra=false;
        boolean simbolo=false;
        boolean numero=false;
        do{
            if (conteudo.length()<10 || conteudo.length()>30) {
                System.out.println("Tamanho mínimo: 10; Tamanho máximo: 30;");
                return false;
            }else{
                for (int i=0;i<conteudo.length();i++){
                    if(Character.isUpperCase(conteudo.charAt(i))){
                        letraMaiuscula=true;
                    }
                    if (Character.isLowerCase(conteudo.charAt(i))){
                       letraMinuscula=true;
                    }
                    if(Character.isLetter(conteudo.charAt(i))){
                        letra=true;
                    }
                    if (!Character.isLetterOrDigit(conteudo.charAt(i))){
                        simbolo=true;
                    }
                    if (Character.isDigit(conteudo.charAt(i))){
                        numero=true;
                    }
                }
                if (letraMaiuscula==true && letraMinuscula==true && letra==true && simbolo==true && numero==true){
                    valida=true;
                }else{
                    System.out.println("A senha deve ter ao menos : \n1.  letra maiúscula; \n2. Uma letra minúscula; \n3. Um número; \n4. Um símbolo");
                    return false;
                }
            }
        }while(valida==false);
        return true;
    }
    public int forcaSenha(){
        int forca=100;
        String comparacao;
        int ocorrenciaPadrao = 0;

        if (conteudo.length()==10 ) {
            forca-=20;

        }else if (conteudo.length()>10 && conteudo.length()<30){
            int diferenca=30-conteudo.length();
            forca-=diferenca;

        }

        for (int i=0;i<conteudo.length();i++){
            comparacao=conteudo.substring(i,i+1);
            if(conteudo.contains("abc") || conteudo.contains("123") || conteudo.contains("senha") || conteudo.contains("senha123") || conteudo.contains("senha@123") || conteudo.contains("senha@123")){
                forca-=1;

            }
            if (conteudo.contains(comparacao)) {
                ocorrenciaPadrao += 1;
            }

        }
        if (ocorrenciaPadrao>1) forca-=1;

        return forca;
    }
}
