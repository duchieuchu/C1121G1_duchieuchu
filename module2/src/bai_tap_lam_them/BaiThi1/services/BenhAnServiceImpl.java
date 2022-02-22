package bai_tap_lam_them.BaiThi1.services;

import bai_tap_lam_them.BaiThi1.models.BenhAnCuaBenhNhan;
import bai_tap_lam_them.BaiThi1.models.BenhAnCuaBenhNhanVip;
import bai_tap_lam_them.BaiThi1.models.BenhAnCuaBenhThuong;
import bai_tap_lam_them.BaiThi1.utils.WriteFileAndReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BenhAnServiceImpl implements BenhAnService {
    private static final String BENH_AN_PATH = "src/bai_tap_lam_them/BaiThi1/data/BenhAnCuaBenhNhan.csv";
    Scanner scanner = new Scanner(System.in);
    List<BenhAnCuaBenhNhan> benhAnCuaBenhNhanThuongList = new ArrayList<>();
    List<BenhAnCuaBenhNhan> benhAnCuaBenhNhanVipList = new ArrayList<>();

    @Override
    public void themMoiBenhAnCuaBenhNhanThuong() {
        System.out.println("nhap soThuTuBenhAn");
        int soThuTuBenhAn = Integer.parseInt(scanner.nextLine());
        System.out.println("nhap maBenhAn");
        String maBenhAn = scanner.nextLine();
        System.out.println("nhap maBenhNhan");
        String maBenhNhan = scanner.nextLine();
        System.out.println("nhap tenBenhNhan");
        String tenBenhNhan = scanner.nextLine();
        System.out.println("nhap ngayNhapVien");
        String ngayNhapVien = scanner.nextLine();
        System.out.println("nhap ngayRaVien");
        String ngayRaVien = scanner.nextLine();
        System.out.println("nhap liDoNhapVien");//7 cai tinh tu 0
        String liDoNhapVien = scanner.nextLine();
        System.out.println("nhap phiNamVien");
        double phiNamVien = Double.parseDouble(scanner.nextLine());
        BenhAnCuaBenhThuong benhAnCuaBenhThuong = new BenhAnCuaBenhThuong(soThuTuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan,
                ngayNhapVien, ngayRaVien, liDoNhapVien, phiNamVien);
        benhAnCuaBenhNhanThuongList.add(benhAnCuaBenhThuong);
        WriteFileAndReadFile.writeListToCSVFile(benhAnCuaBenhNhanThuongList, BENH_AN_PATH, true);
    }

    @Override
    public void themMoiBenhAnCuaBenhNhanVip() {
        System.out.println("nhap soThuTuBenhAn");
        int soThuTuBenhAn = Integer.parseInt(scanner.nextLine());
        System.out.println("nhap maBenhAn");
        String maBenhAn = scanner.nextLine();
        System.out.println("nhap maBenhNhan");
        String maBenhNhan = scanner.nextLine();
        System.out.println("nhap tenBenhNhan");
        String tenBenhNhan = scanner.nextLine();
        System.out.println("nhap ngayNhapVien");
        String ngayNhapVien = scanner.nextLine();
        System.out.println("nhap ngayRaVien");
        String ngayRaVien = scanner.nextLine();
        System.out.println("nhap liDoNhapVien");//8 cai tinh tu 0
        String liDoNhapVien = scanner.nextLine();
        System.out.println("nhap loaiVip");
        String loaiVip = scanner.nextLine();
        System.out.println("nhap thoiHanVip");
        String thoiHanVip = scanner.nextLine();
        BenhAnCuaBenhNhanVip benhAnCuaBenhNhanVip = new BenhAnCuaBenhNhanVip(soThuTuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan,
                ngayNhapVien, ngayRaVien, liDoNhapVien, loaiVip, thoiHanVip);
        benhAnCuaBenhNhanVipList.add(benhAnCuaBenhNhanVip);
        WriteFileAndReadFile.writeListToCSVFile(benhAnCuaBenhNhanVipList, BENH_AN_PATH, true);
    }

    @Override
    public void xoa() {
        List<BenhAnCuaBenhNhan> benhAnCuaBenhNhanList = WriteFileAndReadFile.readBenhAnFromCSVFile(BENH_AN_PATH);
        for (BenhAnCuaBenhNhan benhAnCuaBenhNhan : benhAnCuaBenhNhanList) {
            System.out.println(benhAnCuaBenhNhan);
        }
        System.out.println("nhap ma benh an de xoa: ");
        String maBenhAnCanXoa = scanner.nextLine();
//        int index = 0;
        boolean check = false;
        for (int i = 0; i < benhAnCuaBenhNhanList.size(); i++) {
            if (benhAnCuaBenhNhanList.get(i).getMaBenhAn().equals(maBenhAnCanXoa)) {
//                index = i;
                check = true;
                benhAnCuaBenhNhanList.remove(i);
                System.out.println("xoa thanh cong");
            }
        }
        if (!check) {
            System.out.println("ko tim thay");
        }
        WriteFileAndReadFile.writeListToCSVFile(benhAnCuaBenhNhanList, BENH_AN_PATH, false);

    }

    @Override
    public void xemDanhSachCacBenhAn() {
        List<BenhAnCuaBenhNhan> benhAnCuaBenhNhanList = WriteFileAndReadFile.readBenhAnFromCSVFile(BENH_AN_PATH);
        for (BenhAnCuaBenhNhan benhAnCuaBenhNhan : benhAnCuaBenhNhanList) {
            System.out.println(benhAnCuaBenhNhan);

        }

    }
}
