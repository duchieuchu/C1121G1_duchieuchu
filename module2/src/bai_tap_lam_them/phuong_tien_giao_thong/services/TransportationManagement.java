package bai_tap_lam_them.phuong_tien_giao_thong.services;

import bai_tap_lam_them.phuong_tien_giao_thong.models.OTo;
import bai_tap_lam_them.phuong_tien_giao_thong.models.XeMay;
import bai_tap_lam_them.phuong_tien_giao_thong.models.XeTai;

import java.util.ArrayList;
import java.util.Scanner;

public class TransportationManagement implements ITransportationService {
    public static ArrayList<OTo> oToArrayList = new ArrayList<OTo>();
    public static ArrayList<XeTai> xeTaiArrayList = new ArrayList<XeTai>();
    public static ArrayList<XeMay> xeMayArrayList = new ArrayList<XeMay>();

    static {
        OTo oTo = new OTo("43A1998", "Mercedes-Benz", 2020, "Chu Duc Hieu", 5, "Mercedes-AMG G65");
        XeTai xeTai = new XeTai("1111AA", "Thaco", 2020, "Nguyen Van A", "180kg");
        XeMay xeMay = new XeMay("2222AA", "Yamaha", 2020, "Chu Duc Hieu", "150cc");
        oToArrayList.add(oTo);
        xeTaiArrayList.add(xeTai);
        xeMayArrayList.add(xeMay);
    }

    public void add() {
        System.out.println("Thêm mới phương tiện:\n" +
                "1. Thêm xe tải,\n" +
                "2. Thêm ôtô, \n" +
                "3. Thêm  xe máy.\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Scanner inputXeTai = new Scanner(System.in);
                System.out.print("nhap bien kiem soat: ");
                String bienKiemSoat = inputXeTai.nextLine();
                System.out.print("nhap ten hang san xuat: ");
                String hangSanXuat = inputXeTai.nextLine();
                System.out.print("nhap nam san xuat: ");
                int namSanXuat = Integer.parseInt(inputXeTai.nextLine());
                System.out.print("nhap chu so huu: ");
                String chuSoHuu = inputXeTai.nextLine();
                System.out.print("nhap trong tai: ");
                String trongTai = inputXeTai.nextLine();
                XeTai xeTai = new XeTai(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, trongTai);
                xeTaiArrayList.add(xeTai);
                break;
            case 2:
                Scanner inputOTo = new Scanner(System.in);
                System.out.print("nhap bien kiem soat: ");
                String bienKiemSoatOTo = inputOTo.nextLine();
                System.out.print("nhap ten hang san xuat: ");
                String hangSanXuatOTo = inputOTo.nextLine();
                System.out.print("nhap nam san xuat: ");
                int namSanXuatOTo = Integer.parseInt(inputOTo.nextLine());
                System.out.print("nhap chu so huu: ");
                String chuSoHuuOTo = inputOTo.nextLine();
                System.out.print("nhap so cho ngoi: ");
                int soChoNgoiOTo = Integer.parseInt(inputOTo.nextLine());
                System.out.print("nhap kieu xe: ");
                String kieuXeOTo = inputOTo.nextLine();
                OTo oTo = new OTo(bienKiemSoatOTo, hangSanXuatOTo, namSanXuatOTo, chuSoHuuOTo, soChoNgoiOTo, kieuXeOTo);
                oToArrayList.add(oTo);
                break;
            case 3:
                Scanner inputXeMay = new Scanner(System.in);
                System.out.print("nhap bien kiem soat: ");
                String bienKiemSoatXeMay = inputXeMay.nextLine();
                System.out.print("nhap ten hang san xuat: ");
                String hangSanXuatXeMay = inputXeMay.nextLine();
                System.out.print("nhap nam san xuat: ");
                int namSanXuatXeMay = Integer.parseInt(inputXeMay.nextLine());
                System.out.print("nhap chu so huu: ");
                String chuSoHuuXeMay = inputXeMay.nextLine();
                System.out.print("nhap cong suat: ");
                String congSuatXeMay = inputXeMay.nextLine();
                XeMay xeMay = new XeMay(bienKiemSoatXeMay, hangSanXuatXeMay, namSanXuatXeMay, chuSoHuuXeMay, congSuatXeMay);
                xeMayArrayList.add(xeMay);
                break;
        }
    }

    public void show() {
        System.out.println("1. Hiện thị xe tải.\n" +
                "2. Hiện thị ôtô. \n" +
                "3. Hiện  xe máy.\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                for (XeTai xetai : xeTaiArrayList
                ) {
                    System.out.println(xetai);
                }
                break;
            case 2:
                for (OTo oto : oToArrayList
                ) {
                    System.out.println(oto);
                }
                break;
            case 3:
                for (XeMay xemay : xeMayArrayList
                ) {
                    System.out.println(xemay);
                }
                break;
        }
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Xoa xe tai\n" +
                "2.Xoa O to\n" +
                "3.Xoa xe may");
        System.out.println("xoa xe j ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                xoaXetai();
                break;
            case 2:
                xoaOto();
                break;
            case 3:
                xoaXeMay();
                break;
        }
    }

    public void xoaXetai() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập biển kiểm soát");
        String bienKiemXoaCanXoa = scanner.nextLine();
        boolean check = false;//tao check
        for (int i = 0; i < xeTaiArrayList.size(); i++) {//duyet mang
            if (xeTaiArrayList.get(i).getBienKiemSoat().equals(bienKiemXoaCanXoa)) {//neu bien kiem soat trong list == bks can xoa//danh cho kieu string
                check = true;
                System.out.println("Bạn đã xoá phương tiện có biển kiếm soát " + xeTaiArrayList.get(i).getBienKiemSoat() + " thành công");
                xeTaiArrayList.remove(i);//thi xoa
                break;
            }
        }
        if (!check) {
            System.out.println("không tìm thấy!");
        }
    }

    public void xoaOto() {
        Scanner scanner = new Scanner(System.in);
        String bienKiemSoatCanXoa = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < oToArrayList.size(); i++) {
            if (oToArrayList.get(i).getBienKiemSoat().equals(bienKiemSoatCanXoa)) {
                check = true;
                System.out.println("Bạn đã xoá phương tiện có biển kiếm soát " + oToArrayList.get(i).getBienKiemSoat() + " thành công");
                oToArrayList.remove(i);
                break;
            }
        }
        if (!check) {
            System.out.println("không tìm thấy!");
        }
    }

    public void xoaXeMay() {
        Scanner scanner = new Scanner(System.in);
        String bienKiemSoatCanXoa = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < xeMayArrayList.size(); i++) {
            if (xeMayArrayList.get(i).getBienKiemSoat().equals(bienKiemSoatCanXoa)) {
                check = true;
                System.out.println("Bạn đã xoá phương tiện có biển kiếm soát " + xeMayArrayList.get(i).getBienKiemSoat() + " thành công");
                xeMayArrayList.remove(i);
                break;
            }

        }
        if (!check) {
            System.out.println("không tìm thấy!");
        }
    }

}
