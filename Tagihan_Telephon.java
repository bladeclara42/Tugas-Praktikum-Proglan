public class Tagihan_Telephon extends Pembayaran{

         @Override
         public void menu_pembayaran(){
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
                     if (minSaldo.getSaldo() < 50000) {
                         System.out.println("\tMaaf Saldo Anda tidak mencukupi.");
                            transaksiLagi();
                     } else {
                         saldo -= jumlah;
                         if (saldo <minSaldo.minSaldo()) {
                             System.out.println("\tMaaf, jumlah pembayaran terlalu besar");
                             System.out.println("\t    Sisa saldo tidak mencukupi");
                                     transaksiLagi();
                         } else {
                             minSaldo.setSaldo(saldo);
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