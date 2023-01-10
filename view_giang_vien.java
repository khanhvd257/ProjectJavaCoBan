
package btl.btl_sv;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class view_giang_vien {
    public static List<Sinh_vien> List_qlsv = new ArrayList<>();
    public void them_sinh_vien(){
        
       Sinh_vien sv = new Sinh_vien();
        System.out.println("Nhap thong tin ca nhan: ");
        sv.nhap_thong_tin_ca_nhan();
        int i=1;
        sv.nhap_thong_tin_mon_hoc();
        List_qlsv.add(sv);
        saveToFile();       
        System.out.println("Them thanh cong sinh vien "+ sv.getHoTen()+"!!! ");
    }
    public void nhap_diem_sinh_vien(){
        System.out.println("nhap ma sinh vien can nhap diem");
        String search = new Scanner(System.in).nextLine();
        int check_sinh_vien =0;
        for(Sinh_vien sv : List_qlsv){            
            if(sv.getMa_sinh_vien().equalsIgnoreCase(search)){
                  sv.nhap_thong_tin_mon_hoc();
                  List_qlsv.add(sv);
                  saveToFile();
                  check_sinh_vien =1;
                  System.out.println("nhap diem thanh cong!");
                  break;
            }
        }
        if(check_sinh_vien ==0){
            System.out.println("khong tim thay ma sinh vien");
        }
    }

    public void sua_diem(){
        System.out.println("nhap ma sinh vien can sua diem: ");
        String search = new Scanner(System.in).nextLine();
        int check_sinh_vien = 0;
        for(Sinh_vien sv : List_qlsv){            
            if(sv.getMa_sinh_vien().equalsIgnoreCase(search)){
                  sv.sua_diem_mon_hoc();
                  saveToFile();
                  check_sinh_vien =1;
                  break;
            }
        }
        if(check_sinh_vien ==0){
            System.out.println("khong tim thay ma sinh vien");
        }
    }
    public void delete_sinh_vien(){
        System.out.println("nhap ma sinh vien can xoa: ");
        String delete = (new Scanner(System.in).nextLine());
         int check_sinh_vien = 0;
        for(Sinh_vien sv : List_qlsv){
            if(sv.getMa_sinh_vien().equalsIgnoreCase(delete)){
                List_qlsv.remove(sv);
                System.out.println("Da xoa sinh vien "+ sv.getHoTen());
                saveToFile();
                check_sinh_vien =1;
                break;
            }
        }
        if(check_sinh_vien ==0){
                System.out.println("khong tim thay ma sinh vien");
            }
    }
    public void tim_kiem_sinh_vien(){
            System.out.println("Nhap ma sinh vien can tim: ");
            String search = new Scanner(System.in).nextLine();
            int check_sinh_vien = 0;
            for(Sinh_vien sv : List_qlsv){
                if(sv.getMa_sinh_vien().equalsIgnoreCase(search)){
                    sv.xuat_thong_tin();
                    check_sinh_vien =1;
                    break;
                }           
            }
            if(check_sinh_vien ==0){
                System.out.println("khong tim thay ma sinh vien");
            }
    }
    public void table(){
        System.out.println("===============================================BANG DIEM============================================");
        System.out.printf("| %-10s | %-20s | %-8s | %-10s | %-6s | %-6s | %-6s | %-6s |\n", "Ma mon", "Ten mon", "So tin", "Tinh trang", "C.Can","G.Ky","C.Ky","Tr.B");
        System.out.println("==================================================================================================================================");
    }
    public void hien_thi_sinh_vien(){
        for(Sinh_vien sv : List_qlsv){
            System.out.println("=========THONG TIN SINH  VIEN========");
            sv.xuat_thong_tin();
        }
    }
    public void saveToFile() { //
        ObjectOutputStream oos = null; 
        try {
            oos = new ObjectOutputStream(new FileOutputStream("sinhvien.dat")); // mo luong file
            for (Sinh_vien sv : List_qlsv) {
                oos.writeObject(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close(); // dong file
            } catch (Exception e) {
            }
        }
    }

    public void readToFile() {
        ObjectInputStream ois = null; 
        try {
            ois = new ObjectInputStream(new FileInputStream("sinhvien.dat")); //mo file de doc
                   
            Object obj = null;
            while ((obj = ois.readObject()) != null) { // vid: sinh vien A kieu du lieu object
                try {
                    List_qlsv.add((Sinh_vien) obj); // do lisst_qlsv co kieu du lieu danh sach la Sinh_vien
                } catch (Exception e) {
                    obj = null;
                }
            }
        } catch (Exception e) {
            //  e.printStackTrace();
        } finally {
            try {
                ois.close(); // dong file
            } catch (Exception e) {
            }
        }
    }
    public void quanLy_giang_vien() {
        Sinh_vien sv = new Sinh_vien();
        readToFile();
        int luachon1;
        do {

            System.out.println("**********************QUAN LY SINH VIEN**********************");
            System.out.println("*              0.Quay lai                                   *");
            System.out.println("*              1.Them sinh vien                             *");
            System.out.println("*              2.Nhap diem sinh vien                        *");
            System.out.println("*              3.Sua diem sinh vien                         *");
            System.out.println("*              4.Xoa sinh vien                              *");
            System.out.println("*              5.Tim kiem sinh vien                         *");
            System.out.println("*              6.Hien thi danh sach sinh vien               *");
            System.out.println("************************************************************");
            System.out.println("Vui long lua chon : ");
            try{
            luachon1 = new Scanner(System.in).nextInt();
            }catch(Exception e){
                luachon1 = -1;
            }
            switch (luachon1) {

                case 1:
                    System.out.println("");
                    them_sinh_vien();
                    break;
                case 2:
                    nhap_diem_sinh_vien();
                    break;
                case 3:
                   sua_diem();
                    break;
                case 4:
                    delete_sinh_vien();
                    break;
                case 5:
                    tim_kiem_sinh_vien();
                    break;
                case 6:
                    if(List_qlsv.isEmpty()){
                        System.out.println("Danh sach rong!!!");
                    } else{
                      hien_thi_sinh_vien();
                    }
                    break;
                case 0:
                    System.out.println("Tro ve menu!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
                    break;
            }
        } while (luachon1 != 0);
    }
    public static void main(String[] args) {
       
        view_giang_vien gv = new view_giang_vien();
        gv.quanLy_giang_vien();
        
    }
}
