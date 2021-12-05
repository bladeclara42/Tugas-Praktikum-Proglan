import java.util.Scanner;

class Password {
    protected int pin = 23072001;
    protected int nomorRekening = 90006755;
    
    public void setPin(int password) {
        this.pin = password;
    }

    public void setNorek(int rekening) {
        this.nomorRekening = rekening;
    }
    
    public int getPin() {
        return pin;
    } 

    public int getNorek() {
        return nomorRekening;
    } 
}
