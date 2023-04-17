public class CDNhacDuongDai extends CD{
    public CDNhacDuongDai() {
    }

    public CDNhacDuongDai(String maCD, String tenCD, String tenNgheSi, int namPhatHanh, int soLuong, double gia, String theLoai) {
        super(maCD,tenCD, tenNgheSi, namPhatHanh, soLuong, gia,theLoai);

    }

    public String getStyle() {
        return "DuongDai";
    }

    @Override
    public void nhapCD() {
        super.nhapCD();
    }

    @Override
    public void xuatCD() {
        super.xuatCD();
    }
}
