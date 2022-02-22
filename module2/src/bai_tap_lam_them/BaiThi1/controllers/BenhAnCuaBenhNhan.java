package bai_tap_lam_them.BaiThi1.controllers;

import bai_tap_lam_them.BaiThi1.services.BenhAnServiceImpl;
import bai_tap_lam_them.BaiThi1.utils.NotFoundMedicalRecordException;

import java.util.Scanner;

public class BenhAnCuaBenhNhan {
    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu() {
        BenhAnServiceImpl benhAnService= new BenhAnServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN–\n" +
                    "Chọn chức năng theo số (để tiếp tục):\n" +
                    "1. Thêm mới\n" +
                    "2. Xóa\n" +
                    "3. Xem danh sách các bệnh án\n" +
                    "4. Thoát\n" +
                    "Chọn chức năng:\n");
            Scanner scanner= new Scanner(System.in);
            switch (scanner.nextInt()){
                case 1:
                    chonThemMoi();
                    break;
                case 2:
                    try {
                        benhAnService.xoa();
                    }catch (NotFoundMedicalRecordException e){
                        System.out.println("benh an khong tim thay");
                    }
                    break;
                case 3:
                    benhAnService.xemDanhSachCacBenhAn();
                    break;
                case 4:
                    check=false;
                    break;
                default:
                    System.out.println("Error!!! hay chon lai chuc nang:");
                    displayMainMenu();
            }
        }
    }
    public static void chonThemMoi(){
        BenhAnServiceImpl benhAnService=new BenhAnServiceImpl();
        Scanner scanner= new Scanner(System.in);
        System.out.println("1.them moi benh nhan thuong\n" +
                "2.them moi benh nhan VIP");
        switch (scanner.nextInt()){
            case 1:
                benhAnService.themMoiBenhAnCuaBenhNhanThuong();
                break;
            case 2:
                benhAnService.themMoiBenhAnCuaBenhNhanVip();
                break;
            default:
                System.out.println("Error!!! chon lai chuc nang: ");
                chonThemMoi();
        }
    }
}
