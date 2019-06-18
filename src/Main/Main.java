package Main;

import View.Tela;
/**
 *  Esta classe chama o construtor de tela para iniciar a interface
 * 
 * @author Leonardo Steinke e Rodrigo Valle
 * @since 09/06/2019
 * 
 */
public class Main {

    public static void main(String[] args) throws Exception {

        //Singleton 
        Tela tela = Tela.getInstance();

    }

}
