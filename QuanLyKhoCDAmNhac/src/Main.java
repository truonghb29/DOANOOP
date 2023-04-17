import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        QuanLyKho a = new QuanLyKho();
        CD cd;
        int luaChon = 0;
        Scanner sc = new Scanner(System.in);
        do {
            a.MENU();
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            if (luaChon == 1) {
                System.out.println("[1]In DSCD");
                System.out.printf("1.In tat ca CD\n" +
                        "2.In CD nhac Duong Dai\n" +
                        "3.In CD nhac Co Dien\n" +
                        "Nhap lua chon: ");
                int i = sc.nextInt();
                if (i == 1) {
                    a.xuatDSCD();
                } else if (i == 2) {
                    a.xuatDSCDDuongDai();
                } else if (i == 3){
                    a.xuatDSCDCoDien();
                }
            } else if (luaChon == 2) {
                System.out.println("[2]Them CD");
                System.out.printf("1.Them CD nhac duong dai\n" +
                        "2.Them CD nhac co dien\n" +
                        "Nhap lua chon: ");
                int i = sc.nextInt();
                if (i == 1) {
                    cd = new CDNhacDuongDai();
                    a.themDSCD(cd);
                } else if (i == 2) {
                    cd = new CDNhacCoDien();
                    a.themDSCD(cd);
                }
            } else if (luaChon == 3) {
                System.out.println("[3] Sua thong tin");
                a.suaDoiCD();
            } else if (luaChon == 4) {
                System.out.println("[4] Tim CD");
                System.out.printf(
                        "1.Tim theo ten CD\n" +
                                "2.Tim theo ten nghe si\n" +
                                "3.Tim theo nam phat hanh\n" +
                                "4.Tim theo gia thanh\n" +
                                "5.Tim theo so luong\n");
                int i = sc.nextInt();
                sc.nextLine();
                if (i == 1) {
                    System.out.printf("Nhap ten CD: ");
                    String ten = sc.nextLine();
                    System.out.println("Ket qua tim kiem: ");
                    a.timCDTheoTenCD(ten);
                } else if (i == 2) {
                    System.out.printf("Nhap ten nghe si: ");
                    String ten = sc.nextLine();
                    System.out.println("Ket qua tim kiem: ");
                    a.timCDTheoTenNgheSi(ten);
                } else if (i == 3) {
                    System.out.printf("Nhap nam phat hanh: ");
                    int nam = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ket qua tim kiem: ");
                    a.timCDTheoNam(nam);
                } else if (i == 4) {
                    System.out.printf("Nhap gia: ");
                    double gia = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Ket qua tim kiem: ");
                    a.timCDTheoGia(gia);
                } else if (i == 5) {
                    System.out.printf("Nhap so luong: ");
                    int soLuong = sc.nextInt();
                    System.out.println("Ket qua tim kiem: ");
                    a.timCDTheoSoLuong(soLuong);
                }
            } else if (luaChon == 5) {
                System.out.println("[5] Sap xep");

                System.out.printf(
                        "1.Sap xep theo ten CD\n" +
                                "2.Sap xep theo ten nghe si\n" +
                                "3.Sap xep theo nam phat hanh\n" +
                                "4.Sap xep theo gia thanh\n" +
                                "5.Sap xep theo so luong\n");
                int i = sc.nextInt();
                if (i == 1) {
                    a.sapXepCDTheoTenCD();
                    a.xuatDSCD();
                } else if (i == 2) {
                    a.sapXepCDTheoTenNgheSi();
                    a.xuatDSCD();
                } else if (i == 3) {
                    a.sapXepCDTheoNam();
                    a.xuatDSCD();
                } else if (i == 4) {
                    a.sapXepCDTheoGia();
                    a.xuatDSCD();
                } else {
                    a.sapXepCDTheoSoLuong();
                    a.xuatDSCD();
                }
            } else if (luaChon == 6) {
                a.luuDuLieuXuongDatabase();
                System.out.println("Du lieu da duoc luu xuong database");

            } else if (luaChon == 7) {
                a.layDuLieuTuDatabase();
                a.xuatDSCD();
            } else if (luaChon == 8) {
                int i = 0;
                do {
                    System.out.printf(
                            "1.Nhap kho\n" +
                                    "2.Xuat kho\n" +
                                    "0.Thoat\n");
                    System.out.print("Nhap lua chon: ");
                    i = sc.nextInt();
                    if (i == 1) {
                        System.out.println("[1] Nhap kho");
                        a.nhapKho();
                    } else if (i == 2) {
                        System.out.println("[2] Xuat kho");
                        a.xuatKho();
                    }
                } while (i != 0);
            } else if (luaChon == 9) {
                int i = 0;
                do {
                    System.out.printf(
                            "1.Xuat danh sach nhap kho\n" +
                                    "2.Xuat danh sach xuat kho\n" +
                                    "3.Xuat so luong CD trong kho\n" +
                                    "0.Thoat\n");
                    System.out.print("Nhap lua chon: ");
                    i = sc.nextInt();
                    if (i == 1) {
                        System.out.println("[1] Xuat danh sach nhap kho");
                        a.xuatDSNhapKho();
                    } else if (i == 2) {
                        System.out.println("[2] Xuat danh sach xuat kho");
                        a.xuatDSXuatKho();
                    }else if( i == 3){
                        System.out.println("[3] Xuat so luong CD trong kho");
                        a.soLuong();
                    }
                } while (i != 0);
            }
        } while (luaChon != 0);
    }
}
