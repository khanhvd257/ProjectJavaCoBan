package btl.btl_sv;

import java.io.Serializable;
import java.util.Scanner;

public class mon_hoc implements  Serializable{
    private String ten_mon_hoc, ma_ma_hoc,trang_thai_mon;
    private int so_tin_chi;
    private float diem_chuyen_Can, diem_giua_ki, diem_cuoi_ki;
    private float diem_trung_binh;
    
public static Scanner sc = new Scanner(System.in);

    public mon_hoc(String ten_mon_hocString, String ma_ma_hocString, float diem_chuyen_Can, float diem_giua_ki, float diem_cuoi_ki, String trang_thai_mon) {
        this.ten_mon_hoc = ten_mon_hocString;
        this.ma_ma_hoc = ma_ma_hocString;
        this.diem_chuyen_Can = diem_chuyen_Can;
        this.diem_giua_ki = diem_giua_ki;
        this.diem_cuoi_ki = diem_cuoi_ki;
        this.trang_thai_mon = trang_thai_mon;
    }

    public mon_hoc() {
    }

    public String getTen_mon_hocString() {
        return ten_mon_hoc;
    }

    public void setTen_mon_hocString(String ten_mon_hocString) {
        this.ten_mon_hoc = ten_mon_hocString;
    }

    public String getMa_ma_hocString() {
        return ma_ma_hoc;
    }

    public void setMa_ma_hocString(String ma_ma_hocString) {
        this.ma_ma_hoc = ma_ma_hocString;
    }

    public float getDiem_chuyen_Can() {
        return diem_chuyen_Can;
    }

    public void setDiem_chuyen_Can(float diem_chuyen_Can) {
        this.diem_chuyen_Can = diem_chuyen_Can;
    }

    public float getDiem_giua_ki() {
        return diem_giua_ki;
    }

    public void setDiem_giua_ki(float diem_giua_ki) {
        this.diem_giua_ki = diem_giua_ki;
    }

    public float getDiem_cuoi_ki() {
        return diem_cuoi_ki;
    }

    public void setDiem_cuoi_ki(float diem_cuoi_ki) {
        this.diem_cuoi_ki = diem_cuoi_ki;
    }

    public int getSo_tin_chi() {
        return so_tin_chi;
    }

    public void setSo_tin_chi(int so_tin_chi) {
        this.so_tin_chi = so_tin_chi;
    }

    public String getTrang_thai_mon() {
        return trang_thai_mon;
    }

    public void setTrang_thai_mon(String trang_thai_mon) {
        this.trang_thai_mon = trang_thai_mon;
    }
    public void sua_diem_thi(){       
        System.out.println("nhap diem chuyen can: ");
        diem_chuyen_Can = sc.nextFloat();       
        System.out.println("nhap diem giua ky: ");
        diem_giua_ki = sc.nextFloat();
        System.out.println("nhap diem cuoi ky: ");
        diem_cuoi_ki = sc.nextFloat();
    }
    
    public void nhap_du_lieu(){
        System.out.println("nhap ma mon hoc: ");       
        ma_ma_hoc= (new Scanner(System.in).nextLine());
        System.out.println("nhap ten mon: ");
        ten_mon_hoc = ( new Scanner(System.in).nextLine());
        System.out.println("nhap vao so tin chi: ");
        so_tin_chi = ( new Scanner(System.in).nextInt());
        sua_diem_thi();
    }
    
   public void hien_thi_du_lieu(){
        diem_trung_binh = (diem_chuyen_Can *1 + diem_giua_ki * 2 + diem_cuoi_ki*7)/10 ;
       if(diem_trung_binh <= 4){
            trang_thai_mon = "Hoc lai";
       } 
       else{
           trang_thai_mon= "dat";
       }
       System.out.printf("| %-10s | %-20s | %-8s | %-10s | %-6.1f | %-6.1f | %-6.1f | %-6.1f |\n",ma_ma_hoc,ten_mon_hoc,so_tin_chi,trang_thai_mon,diem_chuyen_Can,diem_giua_ki,diem_cuoi_ki,diem_trung_binh);
       System.out.println("=================================================================================================");
    }
    public static void main(String[] args) {
        mon_hoc s = new mon_hoc();
        s.nhap_du_lieu();
        s.hien_thi_du_lieu();
    }
}