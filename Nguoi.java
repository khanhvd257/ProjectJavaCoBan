package btl.btl_sv;

import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

public class Nguoi implements Serializable{ 
    protected String hoTen;
    protected int tuoi;
    protected int namSinh;
    protected String queQuan;
    protected String email;
    protected String soDienThoai;
    public static Scanner sc = new Scanner(System.in);
    
    public Nguoi() {
    }
    public Nguoi(String hoTen, int tuoi, int namSinh, String queQuan, String email, String soDienThoai) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }

    public String getHoTen() {
        return hoTen;
    } 

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamsinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
  
    public void input(){
        
        System.out.println("Nhap ho ten : ");
        this.setHoTen(sc.nextLine());
        System.out.println("Nhap nam sinh : ");
        this.setNamsinh(new Scanner(System.in).nextInt());
        System.out.println("Nhap que quan : ");      
        this.setQueQuan(sc.nextLine());
        System.out.println("Nhap email : ");
        this.setEmail(sc.nextLine());
        System.out.println("Nhap so dien thoai : ");
        this.setSoDienThoai(sc.nextLine());
               
    }
    public void show(){
        Date now = new Date();
        tuoi =( now.getYear() -  namSinh +1900);
        System.out.println("Ho ten: "+ hoTen);
        System.out.println("Nam sinh: "+ namSinh);
        System.out.println("Tuoi "+ tuoi);
        System.out.println("Que quan: "+ queQuan);
        System.out.println("Email: "+ email);
        System.out.println("So dien thoai: "+ soDienThoai);
    }
   
    public static void main(String[] args) {
        Nguoi n = new Nguoi();
        n.input();
        n.show();
    }
}