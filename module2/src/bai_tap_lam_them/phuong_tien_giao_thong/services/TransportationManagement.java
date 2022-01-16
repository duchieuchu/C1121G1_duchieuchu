package bai_tap_lam_them.phuong_tien_giao_thong.services;

import bai_tap_lam_them.phuong_tien_giao_thong.models.OTo;
import bai_tap_lam_them.phuong_tien_giao_thong.models.XeMay;
import bai_tap_lam_them.phuong_tien_giao_thong.models.XeTai;

import java.util.ArrayList;
import java.util.Scanner;

public class TransportationManagement implements ITransportationService{
    public static ArrayList<OTo> oToArrayList = new ArrayList<OTo>();
    public static ArrayList<XeTai> xeTaiArrayList = new ArrayList<XeTai>();
    public static ArrayList<XeMay> xeMayArrayList = new ArrayList<XeMay>();

    static {
        OTo oTo = new OTo("43A1998", "Mercedes-Benz", 2020, "Chu Duc Hieu", 5, "Mercedes-AMG G65");
        XeTai xeTai = new XeTai("43A1998", "Thaco", 2020, "Nguyen Van A", "18 tan");
        XeMay xeMay = new XeMay("43A1998", "Yamaha", 2020, "Chu Duc Hieu", "150cc");
        oToArrayList.add(oTo);
        xeTaiArrayList.add(xeTai);
        xeMayArrayList.add(xeMay);
    }

    public void add() {
        System.out.println("Thêm mới phương tiện:\n" + "1. Thêm xe tải,\n" +
                "2. Thêm ôtô, \n" +
                "3. Thêm  xe máy.\n");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Scanner input = new Scanner(System.in);
                System.out.println("nhap bien kiem soat: ");
                String bienKiemSoat = input.nextLine();
                System.out.println("nhap ten hang san xuat: ");
                String hangSanXuat = input.nextLine();
                System.out.println("nhap nam san xuat: ");
                int namSanXuat = Integer.parseInt(input.nextLine());
                System.out.println("nhap chu so huu: ");
                String chuSoHuu = input.nextLine();
                System.out.println("nhap trong tai: ");
                String trongTai = input.nextLine();
                XeTai xeTai = new XeTai(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, trongTai);
                xeTaiArrayList.add(xeTai);
                break;
            case 2:
                Scanner inputOTo = new Scanner(System.in);
                System.out.println("nhap bien kiem soat: ");
                String bienKiemSoatOTo = inputOTo.nextLine();
                System.out.println("nhap ten hang san xuat: ");
                String hangSanXuatOTo = inputOTo.nextLine();
                System.out.println("nhap nam san xuat: ");
                int namSanXuatOTo = Integer.parseInt(inputOTo.nextLine());
                System.out.println("nhap chu so huu: ");
                String chuSoHuuOTo = inputOTo.nextLine();
                System.out.println("nhap so cho ngoi: ");
                int soChoNgoiOTo = Integer.parseInt(inputOTo.nextLine());
                System.out.println("nhap kieu xe: ");
                String kieuXeOTo = inputOTo.nextLine();
                OTo oTo = new OTo(bienKiemSoatOTo, hangSanXuatOTo, namSanXuatOTo, chuSoHuuOTo, soChoNgoiOTo, kieuXeOTo);
                oToArrayList.add(oTo);
                break;
            case 3:
                Scanner inputXeMay = new Scanner(System.in);
                System.out.println("nhap bien kiem soat: ");
                String bienKiemSoatXeMay = inputXeMay.nextLine();
                System.out.println("nhap ten hang san xuat: ");
                String hangSanXuatXeMay = inputXeMay.nextLine();
                System.out.println("nhap nam san xuat: ");
                int namSanXuatXeMay = Integer.parseInt(inputXeMay.nextLine());
                System.out.println("nhap chu so huu: ");
                String chuSoHuuXeMay = inputXeMay.nextLine();
                System.out.println("nhap cong suat: ");
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
                    System.out.println(xeTaiArrayList);
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
    public void delete(){

    }


}
