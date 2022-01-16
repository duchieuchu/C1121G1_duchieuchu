package bai_tap_lam_them.phuong_tien_giao_thong.controllers;


import bai_tap_lam_them.phuong_tien_giao_thong.services.TransportationManagement;

import java.util.Scanner;

public class MainTransportation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransportationManagement transportationManagement = new TransportationManagement();
        boolean check = true;
        while (check) {
            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới phương tiện.\n" +
                    "2. Hiển thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát\n" +
                    "\n");
            System.out.println("Enter your choice");
            int choice= scanner.nextInt();
            switch (choice){
                case 1:
                    transportationManagement.add();
                    break;
                case 2:
                    transportationManagement.show();
                    break;
                case 3:
                    transportationManagement.delete();
                    break;
                case 4:
                    check=false;
            }
        }


    }
}
