import java.nio.file.Files;
import java.nio.file.Paths;

public static void imprimirXMLSAT() throws java.io.IOException{
    // Função para imprimir XML SAT

    if (conexaoAberta){
        try{

            // Nesta variavel será gerada uma nova String apartir do Bytes do arquivo lido
            String dadosXML = new String(Files.readAllBytes(Paths.get("C:/Users/mathe/Downloads/Projeto Java/XMLSAT.xml")));

            // Fução que irá imprimir o cupom fiscal
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLSAT(dadosXML,0);
            ImpressoraDLL.INSTANCE.Corte(5);

            //Verificação se a impressão foi feita com sucesso
            if (retorno==0){
                System.out.println("XML SAT impresso com sucesso");
            }
            else {
                System.out.println("Erro ao imprimir XML SAT Código: "+ retorno);
            }

        }catch(Exception e){
            System.out.println("Erro ao ler ou imprimir o arquivo XML: "+e.getMessage());
        }
    }
    else{
        System.out.println("Erro: Conexão não está aberta");
    }
}