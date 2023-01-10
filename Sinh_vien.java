
package btl.btl_sv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sinh_vien extends Nguoi implements Serializable{
    private String ma_sinh_vien, lop, khoa;
    private mon_hoc mhoc;
    private float hoc_phi;
    private List<mon_hoc> danh_Sach_mon;
    

    public Sinh_vien() {
        danh_Sach_mon = new ArrayList<>();
    }

    public float getHoc_phi() {
        return hoc_phi;
    }

    public void setHoc_phi(float hoc_phi) {
        this.hoc_phi = hoc_phi;
    }

    public String getMa_sinh_vien() {
        return ma_sinh_vien;
    }

    public void setMa_sinh_vien(String msv) {
        ma_sinh_vien = msv;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public mon_hoc getMhoc() {
        return mhoc;
    }

    public void setMhoc(mon_hoc mhoc) {
        this.mhoc = mhoc;
    }
     
    public Sinh_vien(String ma_sinh_vien, String lop, String khoa, String hoTen, int tuoi, int namSinh, String queQuan, String email, String soDienThoai) {
        super(hoTen, tuoi, namSinh, queQuan, email, soDienThoai);
        this.ma_sinh_vien = ma_sinh_vien;
        this.lop = lop;
        this.khoa = khoa;
    }
    public int tinh_tong_tin(){
        int tong_tin = 0;
        for(mon_hoc mh : danh_Sach_mon){
            tong_tin += mh.getSo_tin_chi();
        }
        return tong_tin; 
    }
    public void hoc_phi(){
        System.out.println("Ma sinh vien: "+ma_sinh_vien);
        System.out.println("Ten sinh vien: "+ hoTen);
        System.out.println("Khoa: "+ khoa);
        System.out.println("Lop: "+ lop);
        System.out.println("Tong so tin da hoc: "+ tinh_tong_tin()+" (380,000 VND/1 TIN)");        
        System.out.println("Tong hoc phi la: "+ tinh_tong_tin()*380000+" VND") ;
    }
    
    public void nhap_thong_tin_ca_nhan(){
        
        System.out.println("Nhap ma sinh vien: ");
        Scanner sc = new Scanner(System.in);
        ma_sinh_vien = sc.nextLine();        
        System.out.println("Nhap khoa theo hoc: ");
        khoa = sc.nextLine();
        System.out.println("Nhap lop hoc: ");
        lop = sc.nextLine();
        super.input(); 
    }
    public void nhap_thong_tin_mon_hoc(){
        int i=1;
        while(true)
        {            
            System.out.println("nhap thong tin mon hoc :"+i);
            mhoc= new mon_hoc();
            mhoc.nhap_du_lieu();
            danh_Sach_mon.add(mhoc);
            i++;
            System.out.println("Ban co muon nhap them mon khong?(Y/N)?");
            String tra_loi = (new Scanner(System.in).nextLine());
            if(tra_loi.equalsIgnoreCase("n")){
                
                break;
            }
        }
    }
    public void sua_diem_mon_hoc(){
        System.out.println("nhap ma mon can sua: ");
        String search = (new Scanner(System.in).nextLine());
        int check=0;
        for(mon_hoc mh: danh_Sach_mon){              
                if(mh.getMa_ma_hocString().equalsIgnoreCase(search)){
                    mh.sua_diem_thi();
                    check =1;
                    System.out.println("sua thanh cong!");
                    break;
                }               
        }
        if(check == 0){
            System.out.println("khong tim thay ma mon");
        }
    }
    public void table(){
        System.out.println("============================================BANG DIEM============================================");
        System.out.printf("| %-10s | %-20s | %-8s | %-10s | %-6s | %-6s | %-6s | %-6s |\n", "Ma mon", "Ten mon","So tin" ,"Tinh trang", "C.Can","G.Ky","C.Ky","Tr.B");
        System.out.println("=================================================================================================");
    }
     public void xuat_thong_tin(){
        System.out.println("=====THONG TIN SINH VIEN=====");
        System.out.println("Ma sinh vien: "+ma_sinh_vien );
        System.out.println("Khoa theo hoc: "+ khoa);
        System.out.println("Lop: "+ lop);
        super.show();
        table();
        for(mon_hoc mh: danh_Sach_mon){
        mh.hien_thi_du_lieu();
        }
     
     
    }
    public static void main(String[] args) {
        Sinh_vien s= new Sinh_vien();
        s.nhap_thong_tin_ca_nhan();
        s.nhap_thong_tin_mon_hoc();
        s.xuat_thong_tin();
        
    }
}
