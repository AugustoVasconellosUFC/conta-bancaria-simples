/**
 * @author bruno
 *
 */
public class Conta {

    private int num, op =0;

    private double sal;

    private double limite = 100;

    private double[] extrato = new double[10];

    public Conta(int numero, double saldo) {
        num=numero;
        sal=saldo;
    }

    
    public int getNumero() {
        return num;
    }
    
    public double getSaldo() {
        return sal+limite;
    }

    
    public double getLimite() {
        return limite;
    }
    
    public boolean sacar(double valor) {
        if(valor<0)
            return false;
        else if(valor>sal+limite)
            return false;
        else {
            extrato[op]=valor*-1;
            op++;
            if(valor>sal) {
                valor-=sal;
                sal=0;
                limite-=valor;
            }
            else
                sal-=valor;
            return true;
        }
    }

   
    public boolean depositar(double valor) {
        if(valor<0)
            return false;
        else {
            extrato[op]=valor;
            op++;
            if(limite<100) {
                sal+=Math.max(0,valor-100+limite);
                limite+=Math.min(valor,100-limite);
            }
            else
                sal+=valor;
            return true;
        }
    }

    
    public boolean transferir(Conta destino, double valor) {
        if(valor<0)
            return false;
        else if(valor>sal+limite)
            return false;
        else {
            extrato[op]=valor*-1;
            op++;
            destino.depositar(valor);
            if(valor>sal) {
                valor-=sal;
                sal=0;
                limite-=valor;
            }
            else
                sal-=valor;
            return true;
        }
    }


    public double[] verExtrato() {
        return extrato;
    }
}