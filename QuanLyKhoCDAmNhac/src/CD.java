import java.io.Serializable;
import java.util.Scanner;

public class CD implements Comparable<CD>, Serializable {
    private String maCD;
    private String tenCD;
    private String tenNgheSi;
    private int namPhatHanh;
    private int soLuong;
    private double gia;
    private String theLoai;
    private String style;
    public CD() {
    }

    public CD(String maCD, String tenCD, String tenNgheSi, int namPhatHanh, int soLuong, double gia, String theLoai) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.tenNgheSi = tenNgheSi;
        this.namPhatHanh = namPhatHanh;
        this.soLuong = soLuong;
        this.gia = gia;
        this.theLoai = theLoai;
    }

    public String getMaCD() {
        return maCD;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public String getTenNgheSi() {
        return tenNgheSi;
    }

    public void setTenNgheSi(String tenTacGia) {
        this.tenNgheSi = tenTacGia;
    }

    public int getNamPhatHanh() {
        return namPhatHanh;
    }

    public void setNamPhatHanh(int namPhatHanh) {
        this.namPhatHanh = namPhatHanh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void nhapCD(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma CD: ");
        maCD = sc.nextLine();
        System.out.print("Nhap ten CD: ");
        tenCD = sc.nextLine();
        System.out.print("Nhap ten nghe si: ");
        tenNgheSi = sc.nextLine();
        do {
            System.out.print("Nhap nam phat hanh: ");
            namPhatHanh = sc.nextInt();
            if (namPhatHanh <= 0 || namPhatHanh >= 2024) {
                System.out.printf("Khong hop le! ");
            }
        } while (namPhatHanh <= 0 || namPhatHanh >= 2024);
        do {
            System.out.print("Nhap so luong CD: ");
            soLuong = sc.nextInt();
            if (soLuong < 0) {
                System.out.printf("Khong hop le! ");
            }
        } while (soLuong <= 0);
        do {
            System.out.print("Nhap gia CD: ");
            gia = sc.nextDouble();
            if (gia < 0) {
                System.out.printf("Khong hop le! ");
            }
        } while (gia < 0);
        System.out.printf("Nhap the loai: ");
        sc.nextLine();
        theLoai = sc.nextLine();
    }

    public void xuatCD() {
        System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|---------------|");
        System.out.format("%-15s %-30s %-30s %-20s %-20s %-15s\n",
                "| Ma CD",
                "| Ten CD",
                "| Ten nghe si",
                "| Nam phat hanh",
                "| So luong",
                "| Gia (USD)          |" +
                        " The loai      |");
        System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|---------------|");
        System.out.format("%-15s %-30s %-30s %-20s %-20s %-20s %-1s\n",
                "| " + getMaCD(),
                "| " + getTenCD(),
                "| " + getTenNgheSi(),
                "| " + getNamPhatHanh(),
                "| " + getSoLuong(),
                "| " + getGia(),
                "| " + getTheLoai(),
                "|");
        System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|---------------|");
    }

    @Override
    public int compareTo(CD o) {
        return this.tenCD.compareTo(o.tenCD);
    }

}

