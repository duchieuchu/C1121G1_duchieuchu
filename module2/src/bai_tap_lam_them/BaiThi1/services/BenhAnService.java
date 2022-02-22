package bai_tap_lam_them.BaiThi1.services;

import bai_tap_lam_them.BaiThi1.utils.NotFoundMedicalRecordException;

public interface BenhAnService {
    void themMoiBenhAnCuaBenhNhanThuong();

    void themMoiBenhAnCuaBenhNhanVip();

    void xoa() throws NotFoundMedicalRecordException;

    void xemDanhSachCacBenhAn();

}
