package BaiThi.controllers;

import BaiThi.services.BenhAnServiceImpl;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        BenhAnServiceImpl benhAnService = new BenhAnServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN–\n" +
                    "Chọn chức năng theo số (để tiếp tục):\n" +
                    "1. Thêm mới\n" +
                    "2. Xóa\n" +
                    "3. Xem danh sách các bệnh án\n" +
                    "4. Thoát\n" +
                    "Chọn chức năng:\n" +
                    "\n");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    chonBenhAnCuaBenhNhan();
                    break;
                case 2:
                    benhAnService.xoa();
                    break;
                case 3:
                    benhAnService.xemDanhSachBenhAn();
                    break;
                case 4:
                    check = false;
                    break;
                default:
                    System.out.println("enter again!!!");
                    displayMainMenu();
            }
        }
    }

    public static void chonBenhAnCuaBenhNhan() {
        BenhAnServiceImpl benhAnService = new BenhAnServiceImpl();

        System.out.println("1.Them moi benh nhan thuong\n" +
                "2.Them moi benh nhan VIP");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1:
                benhAnService.themMoiBenhAnThuong();
                break;
            case 2:
                benhAnService.themMoiBenhAnVip();
                break;
            default:
                System.out.println("enter again!!!");
                chonBenhAnCuaBenhNhan();
        }
    }
}
