package Control;

import Model.Cidade;
import Persistence.ArquivoDados;
import Persistence.ArquivoIndice;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 * Esta classe implementa os métodos de controle e manipulação de arquivos
 *
 * @author Leonardo Steinke e Rodrigo Valle
 * @since 09/06/2019
 *
 */
public class ControleDados {

    //Instanciando RandomAccessFile para Dados e Indices
    private ArquivoDados arqDado;
    private ArquivoIndice arqIndice;

    //Instanciando classe modelo Cidade
    private Cidade cidade;

    //Definindo tamanho dos registros
    private final int TAMREGdados = 36;
    private final int TAMREGindice = 34;

    //Construtor
    public ControleDados() throws Exception {
        arqDado = new ArquivoDados();
        arqIndice = new ArquivoIndice();
    }

    /**
     * Este método lê o arquivo, aplica a ordenação e salva os dados
     */
    public void Ordenar() throws Exception {

        String[] dados = new String[(int) arqIndice.getIndices().length() / TAMREGindice];
        for (int i = 0; i < dados.length; i++) {
            arqIndice.getIndices().seek(i * TAMREGindice);

            String anome = "";
            for (int j = 0; j < 30; j++) {

                anome += (char) arqIndice.getIndices().read();
            }

            String d = anome + "%" + arqIndice.getIndices().readInt();

            dados[i] = d;
        }
        Arrays.sort(dados);
        arqIndice.getIndices().seek(0);
        for (int j = 0; j < dados.length; j++) {

            String[] campos = dados[j].split("%");

            char[] cidadeNome = Arrays.copyOf(campos[0].toCharArray(), 30);
            for (char a : cidadeNome) {
                arqIndice.getIndices().write(a);
            }
            arqIndice.getIndices().writeInt(Integer.parseInt(campos[1]));

        }

    }

    /**
     * Este método recebe um nome(campo), busca esse nome no arquivo de indices
     * após encontrar lê o valor da posição do registro para recuperar os dados
     * no arquivo de dados
     *
     * @param cNome
     * @return A posição em que se encontra o registro no arquivo de dados
     */
    public int buscarPosEmIndice(String cNome) throws Exception {
        int pos = 0;
        boolean r = true;
        do {
            String nome = "";
            arqIndice.getIndices().seek(pos * TAMREGindice);

            for (int x = 0; x < 30; x++) {
                nome += (char) arqIndice.getIndices().read();
            }
            if (nome.contains(cNome)) {
                r = false;
            } else {
                nome = "";
                pos++;
            }
            if (pos >= arqDado.getDados().length() / TAMREGdados) {
                return -1;
            }
        } while (r);
        return arqIndice.getIndices().readInt();
    }

    /**
     * Esse método busca em qual posição esta cada registro do arquivo de índice
     *
     * @param cNome nome a ser buscado
     * @return Posição do registro no arquivo de índice
     */
    public int buscarPosDoIndice(String cNome) throws Exception {
        int pos = 0;
        boolean r = true;
        do {
            String nome = "";
            arqIndice.getIndices().seek(pos * TAMREGindice);

            for (int x = 0; x < 30; x++) {
                nome += (char) arqIndice.getIndices().read();
            }
            if (nome.contains(cNome)) {
                r = false;
            } else {
                nome = "";
                pos++;
            }
            if (pos >= arqDado.getDados().length() / TAMREGdados) {
                return -1;
            }
        } while (r);
        return pos;
    }

    /**
     * Este método aplica a busca no arquivo de dados utilizando como parâmetro
     * uma String "nome"
     *
     * @param cNome
     * @return A posição no arquivo de dados
     */
    public int buscarPosEmDados(String cNome) throws Exception {
        int pos = 0;
        boolean r = true;
        do {
            String nome = "";
            arqDado.getDados().seek(pos * TAMREGdados);

            for (int x = 0; x < 30; x++) {
                nome += (char) arqDado.getDados().read();
            }
            if (nome.contains(cNome)) {
                r = false;
            } else {
                nome = "";
                pos++;
            }
            if (pos >= arqDado.getDados().length() / TAMREGdados) {
                return -1;
            }
        } while (r);
        return (pos);
    }

    /**
     * Este método é responsável por criar o objeto cidade que posteriormente
     * irá ser inserido no arquivo, utilizando os dados inseridos na interface
     *
     * @param tfNome
     * @param tfCEP
     * @param UF
     * @return Modelo de tabela para ser atualizada na tela
     */
    public DefaultTableModel criarCidadeTELA(String tfNome, int tfCEP, String UF) throws Exception {

        if (buscarPosEmIndice(tfNome) == -1) {
            cidade = new Cidade();
            cidade.setNome(tfNome);
            cidade.setCEP(tfCEP);
            cidade.setUF(UF);

            arqDado.getDados().seek(arqDado.getDados().length());
            arqIndice.getIndices().seek(arqIndice.getIndices().length());
            char[] cidadeNome = Arrays.copyOf(cidade.getNome().toCharArray(), 30);
            char[] cidadeUF = Arrays.copyOf(cidade.getUF().toCharArray(), 2);

            for (char a : cidadeNome) {
                arqDado.getDados().write(a);
                arqIndice.getIndices().write(a);
            }
            arqIndice.getIndices().writeInt((int) arqDado.getDados().length() / TAMREGdados);
            arqDado.getDados().writeInt(cidade.getCEP());

            for (char c : cidadeUF) {
                arqDado.getDados().write(c);
            }
            Ordenar();

            return listar();

        } else {
            throw new Exception();
        }

    }

    /**
     * Este método percorre o arquivo e printa os dados em linhas dentro de uma
     * Table
     *
     * @return A lista de dados inseridos no arquivo diretamente para uma Table
     */
    public DefaultTableModel listar() throws Exception {
        String colunas[] = {"Cidade", "CEP", "UF"};
        DefaultTableModel table = new DefaultTableModel(colunas, 0);

        arqDado.getDados().seek(0);
        arqIndice.getIndices().seek(0);

        for (int i = 0; i < (arqIndice.getIndices().length() / TAMREGindice); i++) {
            for (int j = 0; j < TAMREGindice - 4; j++) {
                arqIndice.getIndices().read();
            }

            arqDado.getDados().seek(arqIndice.getIndices().readInt() * TAMREGdados);
//Nome da Cidade
            String a = "";
            for (int x = 0; x < 30; x++) {
                a += (char) arqDado.getDados().read();
            }

            int cep = arqDado.getDados().readInt();

//UF            
            String b = "";
            for (int y = 0; y < 2; y++) {
                b += (char) arqDado.getDados().read();
            }
            table.addRow(new String[]{a, "" + cep, b});
        }
        return table;
    }

    /**
     * Este método chama o buscarPosEmIndice passando um nome para dar um seek
     * na posição em que as informações dele se encontram, e posteriormente
     * salva elas em um array
     *
     * @param nome
     * @return Um array com as informações respectivas (Cidade, CEP, UF)
     */
    public String[] buscarDados(String nome) throws Exception {
        arqDado.getDados().seek(buscarPosEmIndice(nome) * TAMREGdados);
        String[] dados = new String[3];

        String a = "";
        for (int x = 0; x < 30; x++) {
            a += (char) arqDado.getDados().read();
        }
        dados[0] = a;

        int cep = arqDado.getDados().readInt();
        dados[1] = "" + cep;

        String b = "";
        for (int y = 0; y < 2; y++) {
            b += (char) arqDado.getDados().read();
        }
        dados[2] = b;

        return dados;
    }

    /**
     * Este método permite alterar os dados com base em um get nos campos
     * selecionados na interface.
     *
     * @param nome
     * @param CEP
     * @param UF
     * @param pos
     */
    public void alterarDados(String nome, String CEP, String UF, int pos) throws Exception {

        arqIndice.getIndices().seek(pos * TAMREGindice);
        char[] cidadeNome = Arrays.copyOf(nome.toCharArray(), 30);
        char[] cidadeUF = Arrays.copyOf(UF.toCharArray(), 2);

        for (char a : cidadeNome) {
            arqIndice.getIndices().write(a);
        }

        arqDado.getDados().seek(arqIndice.getIndices().readInt() * TAMREGdados);

        for (char a : cidadeNome) {
            arqDado.getDados().write(a);
        }
        arqDado.getDados().writeInt(Integer.parseInt(CEP));
        for (char a : cidadeUF) {
            arqDado.getDados().write(a);
        }
        Ordenar();
    }

    /**
     * Este método dá um seek na posição encontrada pelo metodo
     * buscarPosDoIndice e marca o arquivo como EXCLUÍDO
     *
     * @param pos
     */
    public void excluirDados(int pos) throws Exception {
        arqIndice.getIndices().seek(pos * TAMREGindice);
        char[] cidadeNome = Arrays.copyOf("EXCLUIDO".toCharArray(), 30);
        for (char a : cidadeNome) {
            arqIndice.getIndices().write(a);
        }
        recriar();

    }

    /**
     * Este método permite recriar os arquivos de índice e dados, eliminando
     * dados marcados como EXCLUIDO de ambos os arquivos além disso, faz uma
     * ordenação
     *
     */
    public void recriar() throws Exception {
        //Listas para salvar os dados dos arquivos
        List<String> indice = new ArrayList<>();
        List<String> dados = new ArrayList<>();
        arqDado.getDados().seek(0);
        arqIndice.getIndices().seek(0);

        /**
         * Esse for percorre todo o arquivo e salva todos os dados nas listas
         * ignorando dados marcados com EXCLUIDO
         */
        for (int i = 0; i < (arqIndice.getIndices().length() / TAMREGindice); i++) {
            String anome = "";
            for (int j = 0; j < 30; j++) {
                anome += (char) arqIndice.getIndices().read();
            }
            if (anome.contains("EXCLUIDO")) {
                arqIndice.getIndices().readInt();
            } else {
                indice.add(anome);
                int l = arqIndice.getIndices().readInt();
                arqDado.getDados().seek(l * TAMREGdados);

                String a = "";
                for (int k = 0; k < 30; k++) {
                    a += (char) arqDado.getDados().read();
                }
                dados.add(a);

                String b = "";
                dados.add("" + arqDado.getDados().readInt());
                for (int k = 0; k < 2; k++) {

                    b += (char) arqDado.getDados().read();
                }
                dados.add(b);

            }
        }
        /**
         * Close na instancia do RandomAccessFile para o programa permitir fazer
         * a exclusão utilizando a classe File e o Método delete()
         */
        arqDado.getDados().close();
        arqIndice.getIndices().close();

        File fileD = new File("dados.dat");
        File fileI = new File("indices.dat");

        fileD.delete();
        fileI.delete();

        /**
         * Nova instancia do RandomAccessFile para recriar os arquivos
         */
        arqDado.createFile();
        arqIndice.createFile();

        /**
         * Após recriar os arquivos todos os dados são escritos novamente
         */
        for (int i = 0; i < dados.size(); i += 3) {

            char[] cidadeNome = Arrays.copyOf(dados.get(i).toCharArray(), 30);
            char[] cidadeUF = Arrays.copyOf(dados.get(i + 2).toCharArray(), 2);
            for (char a : cidadeNome) {
                arqDado.getDados().write(a);
            }
            arqDado.getDados().writeInt(Integer.parseInt(dados.get(i + 1)));

            for (char c : cidadeUF) {
                arqDado.getDados().write(c);
            }
        }
        for (int i = 0; i < indice.size(); i++) {
            char[] cidadeNome = Arrays.copyOf(indice.get(i).toCharArray(), 30);
            String nome = "";
            for (char a : cidadeNome) {
                arqIndice.getIndices().write(a);
                nome += a;
            }
            
            /*
             * Como agora que o arquivo de dados esta com menos registros, a posição
             * dos registros mudou, então o metodo buscarPosEmDados() encontra a nova
             * posição desses registros e escreve no arquivo de indice
             */
            arqIndice.getIndices().writeInt(buscarPosEmDados(nome));

        }
    }

}
