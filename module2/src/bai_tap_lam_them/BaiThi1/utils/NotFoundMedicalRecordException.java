package bai_tap_lam_them.BaiThi1.utils;

public class NotFoundMedicalRecordException extends Exception {
    public NotFoundMedicalRecordException() {
    }
    public NotFoundMedicalRecordException(String message){
        super(message);
    }
}
