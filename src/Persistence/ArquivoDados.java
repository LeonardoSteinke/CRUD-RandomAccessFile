package Persistence;

import java.io.RandomAccessFile;
/**
 *  Esta classe implementa os métodos acessores para o RandomAcessFile referente aos dados
 * 
 * @author Leonardo Steinke e Rodrigo Valle
 * @since 09/06/2019
 * 
 */
public class ArquivoDados {

    RandomAccessFile dados;

    public ArquivoDados() throws Exception {

        dados = new RandomAccessFile("dados.dat", "rwd");

    }

    public RandomAccessFile getDados() {
        return dados;
    }

    public void createFile() throws Exception {
        dados = new RandomAccessFile("dados.dat", "rwd");
    }

}
