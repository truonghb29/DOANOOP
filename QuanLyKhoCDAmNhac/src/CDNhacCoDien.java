public class CDNhacCoDien extends CD{


    public CDNhacCoDien() {
    }

    public CDNhacCoDien(String maCD, String tenCD, String tenNgheSi, int namPhatHanh, int soLuong, double gia, String theLoai) {
        super(maCD,tenCD, tenNgheSi, namPhatHanh, soLuong, gia,theLoai);
    }

    public String getStyle() {
        return "CoDien";
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
