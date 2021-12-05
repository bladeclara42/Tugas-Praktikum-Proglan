import java.io.*;
import java.util.Scanner;
import java.text.*;
import java.util.*;
 
public class AutomatedTellerMachineProgram extends Password{
		Password pass = new Password();
		Login log = new Login();
		Saldo2 Sal = new Saldo2();
		int pil;
 
    public static void main(String[] args){
        AutomatedTellerMachineProgram program = new AutomatedTellerMachineProgram();
        program.initSaldo(0);
        program.login();

    }
    public void initSaldo(double saldo) {
        Sal.setSaldo(saldo);
    }
    	
    public void menu() {
	int pil;	

        System.out.println("=========================================================");
        System.out.print("\t 	 ATM BANK RAKYAT PATI");
        System.out.println();
        System.out.println("=========================================================");
        System.out.print("|");
        System.out.print("\t           Pilih Transaksi                   	|");
        System.out.println();
	System.out.print("|							|");
	System.out.println();
        System.out.print("|");
        System.out.print("\t 1. Cek Saldo       	  2. Transfer        	|");
        System.out.println();
        System.out.print("|");
        System.out.print("\t 3. Penarikan     	  4. Pembayaran       	|");
        System.out.println();
        System.out.print("|");
        System.out.println("\t 5. Tambah Saldo	  6. Keluar        	|");
        System.out.println("=========================================================");
	System.out.println();
	System.out.println("Masukkan Pilihan Anda :");
	Scanner input = new Scanner(System.in);
	pil = input.nextInt();
	System.out.println();
	
        switch (pil) {
            case 1:
                lihatSaldo();
                break;
            case 2:
                transfer();
                break;
            case 3:
                tarik();
                break;
            case 4:
                pembayaran();
                break;
	    case 5:
		tambah();
		break;
            case 6:
                System.out.println("=======================================================");
                System.out.println("\tTerimakasih telah menggunakan layanan kami.");
                break;
            default:
                System.out.println("Pilihan Yang Anda masukan salah. Silahkan Login kembali.");
                login();
                break;
        }
    }

    public void ulangPin() {
	int angka = 1;
	int i;   
	int pin;

		for (i=0; i<angka; i+=1) { 
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("Masukkan pin kembali : ");
		pin = scan.nextInt();
		System.out.println();
		if (i != angka && pass.getPin() == pin ) {
            			menu();
			}else{
				System.out.println("Atm Terblokir, Silahkan membuka rekening kembali");
		}
	
	}
   }

    public void login() {		
	int PIN;

		tambahNasabah();
		log.login();
		Scanner scan = new Scanner(System.in);
		System.out.println("Masukkan pin : ");
		PIN = scan.nextInt();
        if (pass.getPin() == PIN ) {
            menu();
        } else {	
             	System.out.println();
		System.out.println("Pin salah");
	     	System.out.println();
	   		ulangPin();
        }
    }

	
 
    public void tambahNasabah() {
	String nama, alamat, jeniskelamin, tempatlahir, agama;
	int umur;
	double nomerKTP;
		System.out.println();
		log.login();
		System.out.println("Silahkan melakukan pembukaan rekening terlebih dahulu ");
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Nama : ");
		nama = input.nextLine();
		System.out.println();
		System.out.println("Alamat : ");
		alamat = input.nextLine();
		System.out.println();
		System.out.println("Jenis Kelamin : ");
		jeniskelamin = input.nextLine();
		System.out.println();
		System.out.println("Umur : ");
		umur = input.nextInt();
		System.out.println();
		Scanner scan = new Scanner(System.in);
		System.out.println("Tempat Lahir : ");
		tempatlahir = scan.nextLine();
		System.out.println();
		System.out.println("Agama : ");
		agama = scan.nextLine();
		System.out.println();
		System.out.println("No KTP : ");
		nomerKTP = scan.nextDouble();
		System.out.println();
		System.out.println("Data berhasil masuk");
		System.out.println("Berikut informasi data diri anda");
		System.out.println();
		System.out.println("Nama : "+ nama);
		System.out.println("Alamat : "+ alamat);
		System.out.println("Jenis Kelamin : "+ jeniskelamin);
		System.out.println("Umur : "+ umur);
		System.out.println("Tempat Lahir : "+ tempatlahir);
		System.out.println("Agama : "+ agama);
		System.out.println("Nomer KTP : "+ nomerKTP);
		System.out.println("Nomer Rekening : "+ getNorek());
		System.out.println("Pin Atm : "+ getPin());
		System.out.println(); 
   }
   
    public void lihatSaldo() {
        System.out.println("=========================================================");
        System.out.println("\t                      Saldo                     ");
        System.out.println("=========================================================");
        System.out.println("Sisa Saldo yang Anda miliki adalah sebesar Rp " + Sal.getSaldo());
        transaksiLagi();
	
    }
 
    public void transfer() {
        double rekening;
        double nom;
        System.out.println("=========================================================");
        System.out.print("|");
        System.out.print("\t                 Transfer                       |");
        System.out.println();
        System.out.println("=========================================================");
        Scanner input = new Scanner(System.in);
	System.out.println();
      	System.out.println("Masukkan Nomor Rekening Tujuan : ");
	rekening = input.nextDouble();
	System.out.println();
	System.out.println("Masukkan Nominal yang ingin di Transfer : ");
	nom = input.nextInt();
        System.out.println();

        transferNominal(nom,rekening);
    }
 
    public void transferNominal(double nom, double rekening) {
        double saldo = Sal.getSaldo();
		if (Sal.getSaldo() < 50000) {
            System.out.println("\tMaaf Saldo Anda tidak mencukupi");
		transaksiLagi();
        } else if (nom < 50000) {
	    System.out.println("\tMaaf minimal transfer yaitu Rp 50000");
		transaksiLagi();
	} else {
            saldo -= nom;
            if (saldo < Sal.minSaldo()) {
                System.out.println("\tMaaf, jumlah transfer terlalu besar");
                System.out.println("\t    Sisa saldo Anda tidak mencukupi");
		transaksiLagi();
            } else {
                Sal.setSaldo(saldo);
                System.out.println("Anda telah berhasil melakukan transfer sebesar Rp " + nom + "  Ke nomor rekening " + rekening);
                System.out.println("\t       Sisa Saldo adalah Rp " + saldo);
            }
            transaksiLagi();
	    
		
		}
	}

    public void tarik() {
        double penarikan;
	int pil;
	double total;
 
        System.out.println("=========================================================");
        System.out.print("|");
        System.out.print("\t             Penarikan 	                    	|");
        System.out.println();
        System.out.println("=========================================================");
        System.out.print("|");
        System.out.print("\t            Pilih Nominal                   	|");
        System.out.println();
	System.out.print("|							|");
	System.out.println();
        System.out.print("|");
        System.out.print("\t[1] Rp. 100.000           [2] Rp. 200.000       |");
        System.out.println();
        System.out.print("|");
        System.out.print("\t[3] Rp. 500.000           [4] Rp. 1000.0000     |");
        System.out.println();
        System.out.print("|");
        System.out.println("\t[5] Rp. 2000.0000         [6] Lainnya       	|");
        System.out.println("=========================================================");
        System.out.print("\t         Masukan pilihan Anda : ");
	System.out.println();
        Scanner input = new Scanner(System.in);
	pil = input.nextInt();
        System.out.println("=========================================================");
        switch (pil) {
            case 1:
                tarikNominal(100000);
                break;
            case 2:
                tarikNominal(200000);
                break;
            case 3:
                tarikNominal(500000);
                break;
            case 4:
                tarikNominal(1000000);
                break;
            case 5:
                tarikNominal(2000000);
                break;
            case 6:
                System.out.println("\t         Masukan Nominal ");
                System.out.println("=========================================================");
                System.out.print("Jumlah Penarikan Rp ");
		System.out.println();
		total = input.nextDouble();
		tarikNominal(total);
                break;
            default:
                System.out.println("\tPilihan Yang Anda masukan salah");
                tarik();
		
        }
    }
 
    public void tarikNominal(double nominal) {
        double saldo = Sal.getSaldo();
        if (Sal.getSaldo() < 50000) {
            System.out.println("\tMaaf Saldo Anda tidak mencukupi.");
	    transaksiLagi();
        } else if (nominal < 50000) {
	    System.out.println("\tMaaf minimal penarikan yaitu Rp 50000");
	    transaksiLagi();
        } else {
	    saldo -= nominal;
            if (saldo < Sal.minSaldo()) {
		System.out.println();
                System.out.println("\tMaaf, jumlah penarikan terlalu besar");
                System.out.println("\t    Sisa saldo tidak mencukupi");
		transaksiLagi();
            } else {
                Sal.setSaldo(saldo);
		System.out.println();
                System.out.println("Anda telah berhasil melakukan penarikan sebesar Rp " + nominal);
                System.out.println("\t       Sisa Saldo adalah Rp " + saldo);
            }
            transaksiLagi();
	    
        }
    }
 
    public void pembayaran() {
        String warn;
	int kode;
	int jumlah;
	int pil;
        double saldo = Sal.getSaldo();
	Scanner scan = new Scanner(System.in);
        System.out.println("=========================================================");
        System.out.print("|");
        System.out.print("\t             Pembayaran                         |");
        System.out.println();
        System.out.println("=========================================================");
        System.out.print("|");
        System.out.print("\t        Pilih Transaksi                     	|");
        System.out.println();
	System.out.print("|							|");
	System.out.println();
	System.out.print("|");
        System.out.print(" [1] Tagihan Listrik           [2] Tagihan Telepon     |");
        System.out.println();
        System.out.println("=========================================================");
        System.out.print("\t         Masukan pilihan Anda : ");
	System.out.println();
        pil = scan.nextInt();
        switch (pil) {
	case 1:
                System.out.println("=========================================================");
                System.out.print("|");
                System.out.print("\t             Tagihan Listrik                    |");
                System.out.println();
                System.out.println("=========================================================");
                System.out.println("Masukkan Kode Pembayaran : ");
		kode = scan.nextInt();
		System.out.println();
		System.out.println("Masukkan total Pembayaran : ");
		jumlah = scan.nextInt();
		System.out.println();
		System.out.println("Kode Pembayaran :"+ kode);
		System.out.println("Jumlah Pembayaran Rp "+ jumlah);
		Date Today = new Date( );
      		SimpleDateFormat time = new SimpleDateFormat ("E dd.MM.yyyy 'pada' hh:mm:ss");
		System.out.println("Tanggal dan Waktu Pembayaran : " + time.format(Today));
                System.out.println("\t      Lakukan Pembayaran ? [y/n] ");
		Scanner listrik = new Scanner(System.in);	
                warn = listrik.nextLine();
		System.out.println();
                if (warn.equalsIgnoreCase("y")) {
                    if (Sal.getSaldo() < 50000) {
                        System.out.println("\tMaaf Saldo Anda tidak mencukupi.");
			transaksiLagi();
                    } else {
                        saldo -= jumlah;
                        if (saldo < Sal.minSaldo()) {
                            System.out.println("\tMaaf, jumlah pembayaran terlalu besar");
                            System.out.println("\t    Sisa saldo tidak mencukupi");
			    transaksiLagi();
                        } else {
                            Sal.setSaldo(saldo);
                            System.out.println("Anda telah berhasil melakukan pembayaran sebesar Rp "+ jumlah);
                            System.out.println("\t       Sisa Saldo adalah Rp " + saldo);
                        }
                        transaksiLagi();
			
                    }
                } else if (warn.equalsIgnoreCase("n")) {
                    System.out.println("=========================================================");
                    System.out.println("\tPembayaran telah dibatalkan");
                }
                break;

            case 2:
                System.out.println("=========================================================");
                System.out.print("|");
                System.out.print("\t             Tagihan Telephon                    |");
                System.out.println();
                System.out.println("=========================================================");
                System.out.println("Masukkan Kode Pembayaran : ");
		kode = scan.nextInt();
		System.out.println();
		System.out.println("Masukkan total Pembayaran : ");
		jumlah = scan.nextInt();
		System.out.println();
		System.out.println("Kode Pembayaran :"+ kode);
		System.out.println("Jumlah Pembayaran Rp "+ jumlah);
		Date today = new Date( );
		SimpleDateFormat waktu = new SimpleDateFormat ("E dd.MM.yyyy 'pada' hh:mm:ss");
		System.out.println("Tanggal dan Waktu Pembayaran : " + waktu.format(today));
                System.out.println("\t      Lakukan Pembayaran ? [y/n] ");
		Scanner telepon = new Scanner(System.in);
		warn = telepon.nextLine();
		System.out.println();
                if (warn.equalsIgnoreCase("y")) {
                    if (Sal.getSaldo() < 50000) {
                        System.out.println("\tMaaf Saldo Anda tidak mencukupi.");
			transaksiLagi();
                    } else {
                        saldo -= jumlah;
                        if (saldo <Sal.minSaldo()) {
                            System.out.println("\tMaaf, jumlah pembayaran terlalu besar");
                            System.out.println("\t    Sisa saldo tidak mencukupi");
				transaksiLagi();
                        } else {
                            Sal.setSaldo(saldo);
                            System.out.println("Anda telah berhasil melakukan pembayaran sebesar Rp "+ jumlah);
                            System.out.println("\t       Sisa Saldo adalah :" + saldo);
                        }
                        transaksiLagi();
			menu();
                    }
                } else if (warn.equalsIgnoreCase("n")) {
                    System.out.println("=========================================================");
                    System.out.println("\tAnda Telah melakukan Pembayaran");
                    System.out.println("\t      Silahkan Ambil kartu Anda.");
                }
                break;
        }
    }

    public void tambah() {
	double penambahan;
	double total;

	System.out.println("=========================================================");
        System.out.print("|");
        System.out.print("\t             Penambahan 	                |");
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("\t         Masukan Nominal ");
        System.out.println("=========================================================");
        System.out.print("Jumlah Penambahan Rp ");
	System.out.println();
	Scanner input = new Scanner(System.in);
	total = input.nextDouble();
	tambahNominal(total);
  }
	
   public void tambahNominal(double nominal) {
        double saldo = Sal.getSaldo();
       	if (nominal < 50000) {
           	System.out.println("\tMaaf minimal penambahan saldo yaitu Rp 50000");
		transaksiLagi();
        } else {
            	saldo += nominal;
	    	Sal.setSaldo(saldo);
		System.out.println();
                System.out.println("Anda telah berhasil melakukan penambahan sebesar Rp " + nominal);
                System.out.println("\t       Saldo Sekarang adalah Rp " + saldo);
		transaksiLagi();
		
  	}
  }
	
 
    public void transaksiLagi() {
        String warn;
		transaksiLagi trans = new transaksiLagi();
        Scanner scan = new Scanner(System.in);
	trans.transaksiLagi();
	warn = scan.nextLine();
        System.out.println();
        if (warn.equalsIgnoreCase("y")) {
		menu();
        } else if (warn.equalsIgnoreCase("n")) {
            System.out.println("=========================================================");
            System.out.println("\tTerimakasih telah menggunakan layanan kami.");
        }
    }
}
