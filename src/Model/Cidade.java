package Model;
/**
 *  Esta classe define o objeto Cidade e implementa os métodos acessores respectivos
 * 
 * @author Leonardo Steinke e Rodrigo Valle
 * @since 25/06/2019
 * 
 */
public class Cidade {

    private String Nome;
    private int CEP;
    private String UF;

    public Cidade() {
    }
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
    
    
}
