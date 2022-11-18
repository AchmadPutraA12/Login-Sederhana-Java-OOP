import java.util.Scanner;
import java.util.ArrayList;

public class Main {
   String email,password;
   Scanner input = new Scanner(System.in);
   Login lg = new Login();
   ArrayList<Login> data = new ArrayList<Login>();
   
   public void menu() {
        String pilih;
        do {
            System.out.println("""                 
                    1. Akun Baru
                    2. Login
                    3. Exit
                    """);
            System.out.print("Masukkan Pilihan = ");
            pilih = input.nextLine();
            switch (pilih) {
                case "1" -> akunBaru();
                case "2" -> login();
                case "3" -> System.out.println("exit");
                default -> System.err.print("inputan tidak ada");
            }
        }while (!pilih.equals("3"));
    }
   
   public void login(){
        if(data.isEmpty()){
            System.out.println("Tidak Ada akun yang Akan dilogin");
        }
        else{
            System.out.println();
            System.out.print("Masukkan Email anda :");
            email = input.nextLine();
            System.out.print("Masukkan Password anda :");
            password = input.nextLine();
            Login log = cariData(email,password);
            if (log!=null){
                System.out.println("Benar");
            }
            else{
                System.out.println("Salah");
            }
        }
    }

   public Login cariData (String email,String pasword){
        for (Login nama1 : data){
            if(nama1.getEmail().equals(email)&&nama1.getPassword().equals(pasword)){
                return nama1;
            }
        }
        return null;
    }
   
    public void akunBaru() {

        System.out.print("Masukkan email      = ");
        email = input.nextLine();
        System.out.print("Masukkan Password   = ");
        password = input.nextLine();
        lg = new Login(email,password);
        data.add(lg);
    }
    
    public static void main(String[] args){
        Main j = new Main();
        j.menu();
    }
}
