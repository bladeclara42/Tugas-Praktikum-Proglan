import java.util.Scanner;

class Password {
    protected int pin = 23072001;
    protected int norek = 90006755;
    
    public void setPin(int password) {
        this.pin = password;
    }

    public void setNorek(int rekening) {
        this.norek = rekening;
    }
    
    public int getPin() {
        return pin;
    } 

    public int getNorek() {
        return norek;
    } 
}
