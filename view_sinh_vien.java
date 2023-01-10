
package btl.btl_sv;

import static btl.btl_sv.view_giang_vien.List_qlsv;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class view_sinh_vien {
    public static List<Sinh_vien> List_qlsv = new ArrayList<>();
    public static List<giang_vien> List_Giang_Vien = new ArrayList<>();
    
    public void tra_cuu_diem(){
        System.out.println("Nhap ten sinh vien can tra cuu: ");
        String search = new Scanner(System.in).nextLine();
        int check_sinh_vien = 0;
        for(Sinh_vien sv : List_qlsv){
            if(sv.getHoTen().equalsIgnoreCase(search)){
                sv.xuat_thong_tin();
                check_sinh_vien =1;
                break;
            }           
        }
        if(check_sinh_vien ==0){
            System.out.println("khong tim thay ma sinh vien");
        }
    }
    public void tra_cuu_giang_vien(){
        for(giang_vien gv: List_Giang_Vien){
                gv.xuat_thong_tin_g_vien();      
        }
    }
    public void tra_cuu_hoc_phi(){
        System.out.println("Nhap ma sinh vien can tra cuu hoc phi: ");
        String search = new Scanner(System.in).nextLine();
        int check_sinh_vien = 0;
        for(Sinh_vien sv : List_qlsv){
            if(sv.getMa_sinh_vien().equalsIgnoreCase(search)){
                System.out.println("=====THONG TIN SINH VIEN=====");
                sv.hoc_phi();
                check_sinh_vien =1;
                break;
            }           
        }
        if(check_sinh_vien ==0){
            System.out.println("khong tim thay ma sinh vien");
        }
    }
    public void readToFile_sinh_vien() {
        ObjectInputStream ois = null; 
        try {
            ois = new ObjectInputStream(new FileInputStream("sinhvien.dat"));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                try {
                    List_qlsv.add((Sinh_vien) obj);
                } catch (Exception e) {
                    obj = null;
                }
            }
        } catch (Exception e) {
            //  e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
            }
        }
    }
    
    public void readToFile_giang_vien() {
        ObjectInputStream ois = null; 
        try {
            ois = new ObjectInputStream(new FileInputStream("giangvien.dat"));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                try {
                    List_Giang_Vien.add((giang_vien) obj);
                } catch (Exception e) {
                    obj = null;
                }
            }
        } catch (Exception e) {
            //  e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (Exception e) {
            }
        }
    }
    public void giao_dien_sinh_vien(){
        Sinh_vien sv = new Sinh_vien();
        giang_vien gv = new giang_vien();
        readToFile_sinh_vien();
        readToFile_giang_vien();
        int luachon1;
        do {

            System.out.println("**********************TRA CUU SINH VIEN*********************");
            System.out.println("*              0.Quay lai                                  *");
            System.out.println("*              1.Tra cuu diem thi                          *");
            System.out.println("*              2.Tra cuu hoc phi                           *");
            System.out.println("*              3.Tra cuu giang vien                        *");
            System.out.println("************************************************************");
            System.out.println("Vui long lua chon : ");
            try{
            luachon1 = new Scanner(System.in).nextInt();
            }catch(Exception e){
                luachon1 = -1;
            }
            switch (luachon1) {

                
                case 0:
                    System.out.println("Tro ve menu!");
                    break;
                case 1:
                    tra_cuu_diem();
                    break;
                case 2:
                    tra_cuu_hoc_phi();
                    break;
                case 3:
                    tra_cuu_giang_vien();
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
                    break;
            }
        } while (luachon1 != 0);
    }
    public static void main(String[] args) {
        view_sinh_vien sv = new view_sinh_vien();
        sv.giao_dien_sinh_vien();
    }
}

