package bai_tap_lam_them.BaiThi1.services;

import bai_tap_lam_them.BaiThi1.models.BenhAnCuaBenhNhan;
import bai_tap_lam_them.BaiThi1.models.BenhAnCuaBenhNhanVip;
import bai_tap_lam_them.BaiThi1.models.BenhAnCuaBenhThuong;
import bai_tap_lam_them.BaiThi1.utils.NotFoundMedicalRecordException;
import bai_tap_lam_them.BaiThi1.utils.RegexData;
import bai_tap_lam_them.BaiThi1.utils.WriteFileAndReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BenhAnServiceImpl implements BenhAnService {
    private static final String BENH_AN_PATH = "src/bai_tap_lam_them/BaiThi1/data/BenhAnCuaBenhNhan.csv";
    Scanner scanner = new Scanner(System.in);
    List<BenhAnCuaBenhNhan> benhAnCuaBenhNhanThuongList = new ArrayList<>();
    List<BenhAnCuaBenhNhan> benhAnCuaBenhNhanVipList = new ArrayList<>();

    private static final String REGEX_MA_BENH_AN = "^BA-\\d{3}$";
    private static final String REGEX_MA_BENH_NHAN = "^BN-\\d{3}$";
    private static final String REGEX_LOAI_VIP = "^VIP\\s(I|II|III)$";
    private static final String REGEX_NGAY = "^(?:(?:31(-)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(-)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(-)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(-)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    @Override
    public void themMoiBenhAnCuaBenhNhanThuong() {
        List<BenhAnCuaBenhNhan> benhAnCuaBenhNhanList = WriteFileAndReadFile.readBenhAnFromCSVFile(BENH_AN_PATH);

        int soThuTuBenhAn;
        if (benhAnCuaBenhNhanList.isEmpty()) {
            soThuTuBenhAn = 1;
        } else {
            soThuTuBenhAn = benhAnCuaBenhNhanList.get(benhAnCuaBenhNhanList.size() - 1).getSoThuTuBenhAn() + 1;
        }
//        System.out.println("nhap maBenhAn");
//        String maBenhAn = scanner.nextLine();
        String maBenhAn = inputMaBenhAn();
        String maBenhNhan = inputMaBenhNhan();
//        System.out.println("nhap maBenhNhan");
//        String maBenhNhan = scanner.nextLine();
        System.out.println("nhap tenBenhNhan");
        String tenBenhNhan = scanner.nextLine();
//        System.out.println("nhap ngayNhapVien");
//        String ngayNhapVien = scanner.nextLine();
        String ngayNhapVien = inputNgayNhapVien();
        String ngayRaVien = inputNgayRaVien();
//        System.out.println("nhap ngayRaVien");
//        String ngayRaVien = scanner.nextLine();
        System.out.println("nhap liDoNhapVien");//7 cai tinh tu 0
        String liDoNhapVien = scanner.nextLine();
        System.out.println("nhap phiNamVien");
        double phiNamVien = Double.parseDouble(scanner.nextLine());
        BenhAnCuaBenhThuong benhAnCuaBenhThuong = new BenhAnCuaBenhThuong(soThuTuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan,
                ngayNhapVien, ngayRaVien, liDoNhapVien, phiNamVien);
        benhAnCuaBenhNhanThuongList.add(benhAnCuaBenhThuong);
        WriteFileAndReadFile.writeListToCSVFile(benhAnCuaBenhNhanThuongList, BENH_AN_PATH, true);
    }

    private String inputMaBenhAn() {
        System.out.println("nhap maBenhAn");
        return RegexData.regexString(scanner.nextLine(), REGEX_MA_BENH_AN, "ma dinh dang phai co BA-XXX,X la so ");
    }

    private String inputMaBenhNhan() {
        System.out.println("nhap maBenhNhan");
        return RegexData.regexString(scanner.nextLine(), REGEX_MA_BENH_NHAN, "ma dinh dang phai BN-XXX,X la so");
    }

    private String inputLoaiVip() {
        System.out.println("nhap loaiVip");
        return RegexData.regexString(scanner.nextLine(), REGEX_LOAI_VIP, "chi nhap duoc VIP I,VIP II,VIP III");
    }

    private String inputNgayNhapVien() {
        System.out.println("nhap ngayXuatVien");
        return RegexData.regexString(scanner.nextLine(), REGEX_NGAY, "phải đúng định dạng dd-MM-yyyy");
    }

    private String inputNgayRaVien() {
        System.out.println("nhap ngayRaVien");
        return RegexData.regexString(scanner.nextLine(), REGEX_NGAY, "phải đúng định dạng dd-MM-yyyy");
    }

    @Override
    public void themMoiBenhAnCuaBenhNhanVip() {
        List<BenhAnCuaBenhNhan> benhAnCuaBenhNhanList = WriteFileAndReadFile.readBenhAnFromCSVFile(BENH_AN_PATH);

        int soThuTuBenhAn;
        if (benhAnCuaBenhNhanList.isEmpty()) {
            soThuTuBenhAn = 1;
        } else {
            soThuTuBenhAn = benhAnCuaBenhNhanList.get(benhAnCuaBenhNhanList.size() - 1).getSoThuTuBenhAn() + 1;
        }
//        System.out.println("nhap maBenhAn");
//        String maBenhAn = scanner.nextLine();
        String maBenhAn = inputMaBenhAn();
        String maBenhNhan = inputMaBenhNhan();
//        System.out.println("nhap maBenhNhan");
//        String maBenhNhan = scanner.nextLine();
        System.out.println("nhap tenBenhNhan");
        String tenBenhNhan = scanner.nextLine();
//        System.out.println("nhap ngayNhapVien");
//        String ngayNhapVien = scanner.nextLine();
        String ngayNhapVien = inputNgayNhapVien();
        String ngayRaVien = inputNgayRaVien();
//        System.out.println("nhap ngayRaVien");
//        String ngayRaVien = scanner.nextLine();
        System.out.println("nhap liDoNhapVien");//8 cai tinh tu 0
        String liDoNhapVien = scanner.nextLine();
//        System.out.println("nhap loaiVip");
//        String loaiVip = scanner.nextLine();
        String loaiVip = inputLoaiVip();
        System.out.println("nhap thoiHanVip");
        String thoiHanVip = scanner.nextLine();
        BenhAnCuaBenhNhanVip benhAnCuaBenhNhanVip = new BenhAnCuaBenhNhanVip(soThuTuBenhAn, maBenhAn, maBenhNhan, tenBenhNhan,
                ngayNhapVien, ngayRaVien, liDoNhapVien, loaiVip, thoiHanVip);
        benhAnCuaBenhNhanVipList.add(benhAnCuaBenhNhanVip);
        WriteFileAndReadFile.writeListToCSVFile(benhAnCuaBenhNhanVipList, BENH_AN_PATH, true);
    }

    @Override
    public void xoa() throws NotFoundMedicalRecordException {
        List<BenhAnCuaBenhNhan> benhAnCuaBenhNhanList = WriteFileAndReadFile.readBenhAnFromCSVFile(BENH_AN_PATH);
        for (BenhAnCuaBenhNhan benhAnCuaBenhNhan : benhAnCuaBenhNhanList) {
            System.out.println(benhAnCuaBenhNhan);
        }
        System.out.println("nhap ma benh an de xoa: ");
        String maBenhAnCanXoa = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < benhAnCuaBenhNhanList.size(); i++) {
            if (benhAnCuaBenhNhanList.get(i).getMaBenhAn().equals(maBenhAnCanXoa)) {
                check = true;
                boolean choose = true;
                while (choose) {
                    System.out.println("ban co chac chan muon xoa\n" +
                            "1.YES\n" +
                            "2.NO");
                    switch (scanner.nextInt()) {
                        case 1:
                            benhAnCuaBenhNhanList.remove(i);
                            System.out.println("xoa thanh cong");
                            choose = false;
                            break;
                        case 2:
                            System.out.println("da chap nhan khong xoa va quay lai menu");
                            choose = false;
                            break;
                        default:
                            System.out.println("hay chon lai YES hoac NO");
                            break;
                    }
                }
            }
        }
        if (!check) {
            throw new NotFoundMedicalRecordException();
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
