package Persistence;

import java.io.RandomAccessFile;


/**
 * Esta classe implementa os métodos acessores para o RandomAcessFile referente ao índice
 * 
 * @author Leonardo Steinke e Rodrigo Valle
 * @since 09/06/2019
 * 
 */

public class ArquivoIndice {
    
    RandomAccessFile indices;

    public ArquivoIndice() throws Exception {

        indices = new RandomAccessFile("indices.dat", "rwd");

    }

    public RandomAccessFile getIndices() {
        return indices;
    }

    public void createFile() throws Exception {
        indices = new RandomAccessFile("indices.dat", "rwd");
    }

}
