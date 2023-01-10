package btl.btl_sv;

import java.io.Serializable;
import java.util.Scanner;

public class giang_vien extends Nguoi implements Serializable{
    private String ma_giang_vien, khoa_cong_tac, mon_Day;
    private int tham_niem;
    public static Scanner sc = new Scanner(System.in);

    public giang_vien() {
    }

    public giang_vien(String ma_giang_vien, String khoa_cong_tac, int tham_niem, String mon_Day, String hoTen, int tuoi, int namSinh, String queQuan, String email, String soDienThoai) {
        super(hoTen, tuoi, namSinh, queQuan, email, soDienThoai);
        this.ma_giang_vien = ma_giang_vien;
        this.khoa_cong_tac = khoa_cong_tac;
        this.tham_niem = tham_niem;
        this.mon_Day = mon_Day;
    }

    public String getMa_giang_vien() {
        return ma_giang_vien;
    }

    public void setMa_giang_vien(String ma_giang_vien) {
        this.ma_giang_vien = ma_giang_vien;
    }

    public String getKhoa_cong_tac() {
        return khoa_cong_tac;
    }

    public void setKhoa_cong_tac(String khoa_cong_tac) {
        this.khoa_cong_tac = khoa_cong_tac;
    }

    public int getTham_niem() {
        return tham_niem;
    }

    public void setTham_niem(int tham_niem) {
        this.tham_niem = tham_niem;
    }

    public String getMon_Day() {
        return mon_Day;
    }

    public void setMon_Day(String mon_Day) {
        this.mon_Day = mon_Day;
    }
    public void edit_giang_vien(){
        super.input();
        System.out.println("nhap vao Khoa cong tac: ");
        khoa_cong_tac = (new Scanner(System.in).nextLine());
        System.out.println("nhap vao mon day: ");
        mon_Day = sc.nextLine();
        System.out.println("nhap vao tham niem: ");
        tham_niem = sc.nextInt();
      
    }
    public void nhap_thong_tin_giang_vien(){
        System.out.println("nhap vao ma giang vien: ");
        ma_giang_vien = (new Scanner(System.in).nextLine());
        edit_giang_vien();
    }
    public void xuat_thong_tin_g_vien(){
        System.out.println("=====THONG TIN GIANG VIEN=====");
        System.out.println("Ma giang vien: "+ ma_giang_vien);
        super.show();
        System.out.println("khoa cong tac: "+ khoa_cong_tac);
        System.out.println("Mon day: "+ mon_Day);
        System.out.println("tham nien: "+ tham_niem);
    }
}