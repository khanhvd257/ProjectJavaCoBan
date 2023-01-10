
package btl.btl_sv;

import static btl.btl_sv.view_giang_vien.List_qlsv;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class view_truong_Dai_hoc {
    public List<giang_vien> List_gvien = new ArrayList<>();
    
    public void them_giang_vien(){
        giang_vien gv = new giang_vien();
        gv.nhap_thong_tin_giang_vien();
        List_gvien.add(gv);
        saveToFile();
        System.out.println("them thanh cong giang vien " + gv.getHoTen());
    }
    public void delete_giang_vien(){
        System.out.println("nhap ma giang vien can xoa: ");
        String delete = (new Scanner(System.in).nextLine());
        int check_tim_kiem = 0;
        for(giang_vien gv : List_gvien){
            if(gv.getMa_giang_vien().equalsIgnoreCase(delete)){
                List_gvien.remove(gv);
                System.out.println("Da xoa giang vien "+ gv.getHoTen());
                saveToFile();
                check_tim_kiem =1;
                break;
            }
        }
        if(check_tim_kiem == 0){
            System.out.println("khong tim thay ma giang vien!");
            
        }
    }
    public void edit_giang_vien(){
        System.out.println("nhap ma giang vien can sua: ");
        String editString = (new Scanner(System.in).nextLine());
        int check_tim_kiem = 0;
        for(giang_vien gv : List_gvien){
            if(gv.getMa_giang_vien().equalsIgnoreCase(editString)){
                gv.edit_giang_vien();
                List_gvien.add(gv);
                check_tim_kiem = 1;
                saveToFile();
                break;
            }                   
        }
        if(check_tim_kiem == 0){
            System.out.println("khong tim thay ma giang vien!");
        }
    }
    public void tim_kiem_giang_vien(){
            System.out.println("Nhap ma giang vien can tim: ");
            String search = new Scanner(System.in).nextLine();
            int check_tim_kiem = 0;
            for(giang_vien gv : List_gvien){
                if(gv.getMa_giang_vien().equalsIgnoreCase(search)){
                    gv.xuat_thong_tin_g_vien();
                    check_tim_kiem =1;
                    break;
                }           
            }
            if(check_tim_kiem ==0){
                System.out.println("khong tim thay ma giang vien");
            }
    }
    public void hien_thi_gv(){
        for(giang_vien gv : List_gvien){
            System.out.println("=============THONG TIN GIANG VIEN============");
            gv.xuat_thong_tin_g_vien();
        }
    }
    public void saveToFile() {
        ObjectOutputStream oos = null;  
        try {
            oos = new ObjectOutputStream(new FileOutputStream("giangvien.dat"));
            for (giang_vien gv : List_gvien) {
                oos.writeObject(gv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (Exception e) {
            }
        }
    }
    public void readToFile() {
        ObjectInputStream ois = null; 
        try {
            ois = new ObjectInputStream(new FileInputStream("giangvien.dat"));
            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                try {
                    List_gvien.add((giang_vien) obj);
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
    public void quan_ly_nha_truong(){
        giang_vien gv = new giang_vien();
        readToFile();
        int luachon1;
        do {

            System.out.println("*********************QUAN LY GIANG VIEN*********************");
            System.out.println("*              0.Quay lai                                  *");
            System.out.println("*              1.Them giang vien                           *");
            System.out.println("*              2.Sua thong tin giang vien                  *");
            System.out.println("*              3.Xoa giang vien                            *");
            System.out.println("*              4.Tim kiem giang vien                       *");
            System.out.println("*              5.Hien thi danh sach giang vien             *");
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
                    them_giang_vien();
                    break;
                case 2:
                    edit_giang_vien();
                    break;
                case 3:
                   delete_giang_vien();
                    break;
                case 4:
                    tim_kiem_giang_vien();
                    break;           
                case 5:
                    if(List_gvien.isEmpty()){
                        System.out.println("Danh sach rong!!!");
                    } else{
                    hien_thi_gv();
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
        view_truong_Dai_hoc th= new view_truong_Dai_hoc();
        th.quan_ly_nha_truong();
    }
}