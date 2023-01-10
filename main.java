package btl.btl_sv;
/*
*Tran Minh Duc 71DCTT22045 71DCTT23
*Du Tran Viet 71DCTT22178 71DCTT23
*Nguyen Thanh Phuong 71DCTT22130 71DCTT23
*Tran Sy Quang 71DCTT22134 71DCTT23
*/
import java.util.Scanner;

public class main {
    public static void main(String[] args) 
    {
    int luachon;
        do {            
        System.out.println("****************************MENU****************************");
        System.out.println("*              1. Dang nhap sinh vien                      *");
        System.out.println("*              2. Dang nhap giang vien                     *");
        System.out.println("*              3. Dang nhap nha truong                     *");
        System.out.println("*              0.Thoat chuong trinh                        *");
        System.out.println("************************************************************");
        System.out.println("       Moi ban lua chon:               ");
        try{
        luachon = new Scanner(System.in).nextInt();
        }catch(Exception e){
            luachon = -1;
        }
        switch(luachon){
            case 1:
                view_sinh_vien sv = new view_sinh_vien();
                sv.giao_dien_sinh_vien();
                break;        
            case 2:
                view_giang_vien gv = new view_giang_vien();
                gv.quanLy_giang_vien();
                break;
            case 3:
                view_truong_Dai_hoc dh = new view_truong_Dai_hoc();
                dh.quan_ly_nha_truong();
                break;
            case 0:
                System.out.println("Thoat chuong trinh!");
                break;
            default:
                System.out.println("Chuc nang khong ton tai, vui long nhap lai!");
                break;
           }
       } while (luachon != 0);     
    }
}