public class Tagihan_Listrik extends Pembayaran(){

         @Override
         public void menu_pembayaran(){
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
             if (minSaldo.getSaldo() < 50000) {
                 System.out.println("\tMaaf Saldo Anda tidak mencukupi.");
                    transaksiLagi();
             } else {
                 saldo -= jumlah;
                 if (saldo < minSaldo.minSaldo()) {
                     System.out.println("\tMaaf, jumlah pembayaran terlalu besar");
                     System.out.println("\t    Sisa saldo tidak mencukupi");
                        transaksiLagi();
                 } else {
                     minSaldo.setSaldo(saldo);
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
}
}
