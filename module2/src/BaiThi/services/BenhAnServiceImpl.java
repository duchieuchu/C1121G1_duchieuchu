package BaiThi.services;

import BaiThi.models.BenhNhan;
import BaiThi.models.BenhNhanThuong;
import BaiThi.models.BenhNhanVip;
import BaiThi.utils.WriteFileAndReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BenhAnServiceImpl implements BenhAnService {
    private static final String BENH_AN_FILE = "src/BaiThi/data/benhAnCuaBenhNhan.csv";

    Scanner scanner = new Scanner(System.in);

    @Override
    public void themMoiBenhAnThuong() {
        List<BenhNhan> benhNhanThuongList = new ArrayList<>();
        List<String> stringBenhNhanThuongList;
        System.out.print("nhập mã bệnh án: ");
        String maBenhAn = scanner.nextLine();
        System.out.print("nhập mã bệnh nhân: ");
        String maBenhNhan = scanner.nextLine();
        System.out.print("nhập tên bệnh nhân: ");
        String tenBenhNhan = scanner.nextLine();
        System.out.print("nhập ngày ra viện: ");
        String ngayRaVien = scanner.nextLine();
        System.out.print("nhập ngày xuất viện: ");
        String ngayXuatVien = scanner.nextLine();
        System.out.print("nhập lí do nhập viện: ");
        String liDoNhapVien = scanner.nextLine();

        System.out.print("nhập phí nằm viện: ");
        double phiNamVien = Double.parseDouble(scanner.nextLine());

        benhNhanThuongList.add(new BenhNhanThuong(maBenhAn, maBenhNhan, tenBenhNhan, ngayRaVien, ngayXuatVien, liDoNhapVien, phiNamVien));
        stringBenhNhanThuongList = WriteFileAndReadFile.convertBenhAnListToStringList(benhNhanThuongList);

        WriteFileAndReadFile.writeStringListIntoCSVFile(BENH_AN_FILE, stringBenhNhanThuongList, true);

    }

    @Override
    public void themMoiBenhAnVip() {
        List<BenhNhan> benhNhanVIPList = new ArrayList<>();
        List<String> stringBenhNhanVIPList;
        System.out.print("nhập mã bệnh án: ");
        String maBenhAn = scanner.nextLine();
        System.out.print("nhập mã bệnh nhân: ");
        String maBenhNhan = scanner.nextLine();
        System.out.print("nhập tên bệnh nhân: ");
        String tenBenhNhan = scanner.nextLine();
        System.out.print("nhập ngày ra viện: ");
        String ngayRaVien = scanner.nextLine();
        System.out.print("nhập ngày xuất viện: ");
        String ngayXuatVien = scanner.nextLine();
        System.out.print("nhập lí do nhập viện: ");
        String liDoNhapVien = scanner.nextLine();
        System.out.print("nhập loại VIP: ");
        String loaiVip = scanner.nextLine();
        System.out.print("nhập thời hạn VIP: ");
        String thoiHanVip = scanner.nextLine();

        benhNhanVIPList.add(new BenhNhanVip(maBenhAn, maBenhNhan, tenBenhNhan, ngayRaVien, ngayXuatVien, liDoNhapVien, loaiVip, thoiHanVip));
        stringBenhNhanVIPList = WriteFileAndReadFile.convertBenhAnListToStringList(benhNhanVIPList);

        WriteFileAndReadFile.writeStringListIntoCSVFile(BENH_AN_FILE, stringBenhNhanVIPList, true);
    }

    @Override
    public void xoa() {
        xemDanhSachBenhAn();
        System.out.print("Chọn mã benh an muon  xoá: ");
        String maBenhAn = scanner.nextLine();
        if (maBenhAn.trim().equals("")) {
            System.out.println("Nhập sai!!! Hãy nhập lại!");
        } else {
            List<String> stringList = WriteFileAndReadFile.readFileCSVToStringList(BENH_AN_FILE);
            List<BenhNhan> benhNhanList = WriteFileAndReadFile.convertStringListToBenhAnList(stringList);
            boolean flag = false;
            for (BenhNhan benhNhan : benhNhanList) {
                if (benhNhan.getMaBenhAn().equals(maBenhAn)) {
                    int xacNhan;
                    try {
                        System.out.println("Bạn có xác nhận xoá benh an cua benh nhan co ma benh nhan là: " + maBenhAn);
                        System.out.println("1. Có");
                        System.out.println("2. Không");
                        System.out.print("Bạn chọn: ");
                        xacNhan = Integer.parseInt(scanner.nextLine());
                        switch (xacNhan) {
                            case 1:
                                benhNhanList.remove(benhNhan);
                                stringList = WriteFileAndReadFile.convertBenhAnListToStringList(benhNhanList);
                                WriteFileAndReadFile.writeStringListIntoCSVFile(BENH_AN_FILE, stringList, false);
                                System.out.println("Bạn đã xoá thành công!!!");
                                break;
                            case 2:
                                System.out.println("Bạn đã huỷ xoá!");
                                break;
                            default:
                                System.out.println("Bạn chọn sai!!! Hãy nhập lại!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Nhập sai định dạng!!! Hãy nhập lại!");
                    }
                }
            }
        }
    }

    @Override
    public void xemDanhSachBenhAn() {
        List<String> stringList = WriteFileAndReadFile.readFileCSVToStringList(BENH_AN_FILE);
        List<BenhNhan> benhNhanList = WriteFileAndReadFile.convertStringListToBenhAnList(stringList);

        System.out.println("danh sach benh an cua benh nhan: ");
        for (BenhNhan benhNhan : benhNhanList) {
            System.out.println(benhNhan.toStringToFileCSV());
        }
    }
}
