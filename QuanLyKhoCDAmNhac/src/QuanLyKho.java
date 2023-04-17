import java.sql.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.*;

public class QuanLyKho {

    ArrayList<CD> cds;

    public QuanLyKho() {
        cds = new ArrayList<>();
    }

    public void themDSCD(CD cd) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong can them: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Lan nhap thu " + i + ": ");
            if (cd instanceof CDNhacDuongDai) {
                cd = new CDNhacDuongDai();
                cd.nhapCD();
            } else if (cd instanceof CDNhacCoDien) {
                cd = new CDNhacCoDien();
                cd.nhapCD();
            }
            cds.add(cd);
        }
    }

    public void menuSuaDoi() {

        System.out.print("-------MENU-------\n" +
                "1.Sua thong tin CD\n" +
                "2.Xoa CD\n" +
                "3.Xoa tat ca\n" +
                "0.Thoat\n" +
                "Nhap lua chon: ");
    }

    public void suaDoiCD() {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            menuSuaDoi();
            n = sc.nextInt();
            if (n == 1) {
                System.out.print("Nhap ma CD can sua: ");
                sc.nextLine();
                String maCD = sc.nextLine();
                suaCD(maCD);
            } else if (n == 2) {
                System.out.print("Nhap ma CD muon xoa: ");
                sc.nextLine();
                String maCD = sc.nextLine();
                xoaCD(maCD);
            } else if (n == 3) {
                xoaCDall();
            }
        } while (n != 0);
    }

    public void suaCD(String maCD) {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        Iterator<CD> iterator = cds.iterator();
        while (iterator.hasNext()) {
            CD cd = iterator.next();
            if (cd.getMaCD().equalsIgnoreCase(maCD)) {
                if (cd instanceof CDNhacDuongDai) {
                    CDNhacDuongDai cdNhacRap = (CDNhacDuongDai) cd;
                    System.out.print("Nhap ten CD: ");
                    String ten = scanner.nextLine();
                    cdNhacRap.setTenCD(ten);
                    System.out.print("Nhap ten nghe si: ");
                    String tenNgheSi = scanner.nextLine();
                    cdNhacRap.setTenNgheSi(tenNgheSi);
                    System.out.print("Nhap nam phat hanh: ");
                    int namPhatHanh = scanner.nextInt();
                    cdNhacRap.setNamPhatHanh(namPhatHanh);
                    System.out.print("Nhap so luong: ");
                    int soLuong = scanner.nextInt();
                    cdNhacRap.setSoLuong(soLuong);
                    System.out.print("Nhap gia: ");
                    double gia = scanner.nextDouble();
                    cdNhacRap.setGia(gia);
                    System.out.printf("Nhap the loai: ");
                    scanner.nextLine();
                    String theLoai = scanner.nextLine();
                    found = true;
                    System.out.println("Sua doi CD thanh cong!");
                } else if (cd instanceof CDNhacCoDien) {
                    CDNhacCoDien cdNhacPop = (CDNhacCoDien) cd;
                    System.out.print("Nhap ten CD: ");
                    String ten = scanner.nextLine();
                    cdNhacPop.setTenCD(ten);
                    System.out.print("Nhap ten nghe si: ");
                    String tenNgheSi = scanner.nextLine();
                    cdNhacPop.setTenNgheSi(tenNgheSi);
                    System.out.print("Nhap nam phat hanh: ");
                    int namPhatHanh = scanner.nextInt();
                    cdNhacPop.setNamPhatHanh(namPhatHanh);
                    System.out.print("Nhap so luong: ");
                    int soLuong = scanner.nextInt();
                    cdNhacPop.setSoLuong(soLuong);
                    System.out.print("Nhap gia: ");
                    double gia = scanner.nextDouble();
                    cdNhacPop.setGia(gia);
                    System.out.printf("Nhap the loai");
                    scanner.nextLine();
                    String theLoai = scanner.nextLine();
                    found = true;
                    System.out.println("Sua doi CD thanh cong!");
                }
            }
        }
        if (!found) {
            System.out.println("Khong tim thay CD can sua doi!");
        }
    }


    public void xoaCD(String maCD) {
        Iterator<CD> iterator = cds.iterator();
        while (iterator.hasNext()) {
            CD cd = iterator.next();
            if (cd.getMaCD().equalsIgnoreCase(maCD)) {
                iterator.remove();
                System.out.println("Da xoa CD " + maCD);
                return;
            }
        }

        System.out.println("Khong tim thay CD " + maCD);
    }

    public void xoaCDall() {
        cds.clear();
        System.out.println("Da xoa tat ca CD ");
    }


    public void xuatDSCD() {
        System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|--------------------|");
        System.out.format("%-15s %-30s %-30s %-20s %-20s %-20s\n",
                "| Ma CD",
                "| Ten CD",
                "| Ten nghe si",
                "| Nam phat hanh",
                "| So luong",
                "| Gia (USD)          |" +
                        " The loai           |");
        System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|--------------------|");
        for (CD dscd : cds) {
            System.out.format("%-15s %-30s %-30s %-20s %-20s %-20s %-15s %-1s\n",
                    "| " + dscd.getMaCD(),
                    "| " + dscd.getTenCD(),
                    "| " + dscd.getTenNgheSi(),
                    "| " + dscd.getNamPhatHanh(),
                    "| " + dscd.getSoLuong(),
                    "| " + dscd.getGia(),
                    "| " + dscd.getTheLoai(),
                    "     |");
            System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|--------------------|");
        }
    }

    public void xuatDSCDDuongDai() {
        System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|--------------------|");
        System.out.format("%-15s %-30s %-30s %-20s %-20s %-20s \n",
                "| Ma CD",
                "| Ten CD",
                "| Ten nghe si",
                "| Nam phat hanh",
                "| So luong",
                "| Gia (USD)          |" +
                        " The loai           |");
        System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|--------------------|");
        for (CD dscd : cds) {
            if (dscd instanceof CDNhacDuongDai) {
                System.out.format("%-15s %-30s %-30s %-20s %-20s %-20s %-20s %-1s\n",
                        "| " + dscd.getMaCD(),
                        "| " + dscd.getTenCD(),
                        "| " + dscd.getTenNgheSi(),
                        "| " + dscd.getNamPhatHanh(),
                        "| " + dscd.getSoLuong(),
                        "| " + dscd.getGia(),
                        "| " + dscd.getTheLoai(),
                        "|");
                System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|--------------------|");
            }
        }
    }

    public void xuatDSCDCoDien() {
        System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|--------------------|");
        System.out.format("%-15s %-30s %-30s %-20s %-20s %-20s \n",
                "| Ma CD",
                "| Ten CD",
                "| Ten nghe si",
                "| Nam phat hanh",
                "| So luong",
                "| Gia (USD)          |" +
                        " The loai           |");
        System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|--------------------|");
        for (CD dscd : cds) {
            if (dscd instanceof CDNhacCoDien) {
                System.out.format("%-15s %-30s %-30s %-20s %-20s %-20s %-20s %-1s\n",
                        "| " + dscd.getMaCD(),
                        "| " + dscd.getTenCD(),
                        "| " + dscd.getTenNgheSi(),
                        "| " + dscd.getNamPhatHanh(),
                        "| " + dscd.getSoLuong(),
                        "| " + dscd.getGia(),
                        "| " + dscd.getTheLoai(),
                        "|");
                System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|--------------------|");
            }
        }
    }

    public void xuatDSNhapKho() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cd", "root", "admin123@");
            String sql = "SELECT pn.soPhieu, cds.tenCD, ncc.tenNCC, pn.soLuong, pn.donGia, pn.ngayNhap\n" +
                    "FROM cd.cdamnhac as cds\n" +
                    "inner join cd.phieunhap as pn on cds.maCD = pn.maCD\n" +
                    "inner join cd.nhacungcap as ncc on pn.maNCC = ncc.maNCC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|");
            System.out.format("%-15s %-30s %-30s %-20s %-20s %-20s\n",
                    "| So phieu",
                    "| Ten CD",
                    "| Ten NCC",
                    "| So luong",
                    "| Don gia",
                    "| Ngay xuat kho      |"
            );
            System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|");
            while (rs.next()) {
                String soPhieu = rs.getString("soPhieu");
                String tenCD = rs.getString("tenCD");
                String tenNCC = rs.getString("tenNCC");
                int soLuong = rs.getInt("soLuong");
                double donGia = rs.getDouble("donGia");
                LocalDate ngay = rs.getDate("ngayNhap").toLocalDate();
                System.out.format("%-15s %-30s %-30s %-20s %-20s %-20s %-1s\n",
                        "| " + soPhieu,
                        "| " + tenCD,
                        "| " + tenNCC,
                        "| " + soLuong,
                        "| " + donGia,
                        "| " + ngay,
                        "|");
                System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|");

            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void xuatDSXuatKho() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cd", "root", "admin123@");
            String sql = "SELECT px.soPhieu, cds.tenCD, ncc.tenNCC, px.soLuong, px.donGia, px.ngayXuat\n" +
                    "FROM cd.cdamnhac as cds\n" +
                    "inner join cd.phieuxuat as px on cds.maCD = px.maCD\n" +
                    "inner join cd.nhacungcap as ncc on px.maNCC = ncc.maNCC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|");
            System.out.format("%-15s %-30s %-30s %-20s %-20s %-20s\n",
                    "| So phieu",
                    "| Ten CD",
                    "| Ten NCC",
                    "| So luong",
                    "| Don gia",
                    "| Ngay xuat kho      |"
            );
            System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|");
            while (rs.next()) {
                String soPhieu = rs.getString("soPhieu");
                String tenCD = rs.getString("tenCD");
                String tenNCC = rs.getString("tenNCC");
                int soLuong = rs.getInt("soLuong");
                double donGia = rs.getDouble("donGia");
                LocalDate ngay = rs.getDate("ngayXuat").toLocalDate();
                System.out.format("%-15s %-30s %-30s %-20s %-20s %-20s %-1s\n",
                        "| " + soPhieu,
                        "| " + tenCD,
                        "| " + tenNCC,
                        "| " + soLuong,
                        "| " + donGia,
                        "| " + ngay,
                        "|");
                System.out.println("|---------------|------------------------------|------------------------------|--------------------|--------------------|--------------------|");

            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void sapXepCDTheoTenCD() {
        Collections.sort(this.cds, new Comparator<CD>() {
            @Override
            public int compare(CD o1, CD o2) {
                int i = o1.getTenCD().compareTo(o2.getTenCD());
                if (i < 0) {
                    return -1;
                } else if (i == 0) {
                    return 0;
                }
                return 1;
            }
        });
    }

    public void sapXepCDTheoTenNgheSi() {
        Collections.sort(this.cds, new Comparator<CD>() {
            @Override
            public int compare(CD o1, CD o2) {
                int i = o1.getTenNgheSi().compareTo(o2.getTenNgheSi());
                if (i < 0) {
                    return -1;
                } else if (i == 0) {
                    return 0;
                }
                return 1;
            }
        });
    }


    public void sapXepCDTheoNam() {
        Collections.sort(this.cds, new Comparator<CD>() {
            @Override
            public int compare(CD o1, CD o2) {
                int i = o1.getNamPhatHanh() - o2.getNamPhatHanh();
                if (i < 0) {
                    return -1;
                } else if (i == 0) {
                    return 0;
                }
                return 1;
            }
        });
    }

    public void sapXepCDTheoGia() {
        Collections.sort(this.cds, new Comparator<CD>() {
                    @Override
                    public int compare(CD o1, CD o2) {
                        int i = (int) (o1.getGia() - o2.getGia());
                        if (i < 0) {
                            return -1;
                        } else if (i == 0) {
                            return 0;
                        }
                        return 1;
                    }
                }
        );
    }

    public void sapXepCDTheoSoLuong() {
        Collections.sort(this.cds, new Comparator<CD>() {
            @Override
            public int compare(CD o1, CD o2) {
                int i = (o1.getSoLuong() - o2.getSoLuong());
                if (i < 0) {
                    return -1;
                } else if (i == 0) {
                    return 0;
                }
                return 1;
            }
        });
    }

    public void timCDTheoTenCD(String name) {
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
        System.out.format("%-30s %-30s %-20s %-20s %-15s\n",
                "| Ten CD",
                "| Ten nghe si",
                "| Nam phat hanh",
                "| So luong",
                "| Gia (USD)          |" +
                        " The loai      |");
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");

        for (CD cd : cds) {
            if (cd.getTenCD().contains(name)) {
                System.out.format("%-30s %-30s %-20s %-20s %-20s %-15s %-1s\n",
                        "| " + cd.getTenCD(),
                        "| " + cd.getTenNgheSi(),
                        "| " + cd.getNamPhatHanh(),
                        "| " + cd.getSoLuong(),
                        "| " + cd.getGia(),
                        "| " + cd.getTheLoai(),
                        "|");
                System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
            }
        }
    }

    public void timCDTheoTenNgheSi(String name) {
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
        System.out.format("%-30s %-30s %-20s %-20s %-15s\n",
                "| Ten CD",
                "| Ten nghe si",
                "| Nam phat hanh",
                "| So luong",
                "| Gia (USD)          |" +
                        " The loai      |");
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");

        for (CD cd : cds) {
            if (cd.getTenNgheSi().contains(name)) {
                System.out.format("%-30s %-30s %-20s %-20s %-20s %-15s %-1s\n",
                        "| " + cd.getTenCD(),
                        "| " + cd.getTenNgheSi(),
                        "| " + cd.getNamPhatHanh(),
                        "| " + cd.getSoLuong(),
                        "| " + cd.getGia(),
                        "| " + cd.getTheLoai(),
                        "|");
                System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
            }
        }
    }

    public void timCDTheoNam(int nam) {
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
        System.out.format("%-30s %-30s %-20s %-20s %-15s\n",
                "| Ten CD",
                "| Ten nghe si",
                "| Nam phat hanh",
                "| So luong",
                "| Gia (USD)          |" +
                        " The loai      |");
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");

        for (CD cd : cds) {
            if (cd.getNamPhatHanh() == nam) {
                System.out.format("%-30s %-30s %-20s %-20s %-20s %-15s %-1s\n",
                        "| " + cd.getTenCD(),
                        "| " + cd.getTenNgheSi(),
                        "| " + cd.getNamPhatHanh(),
                        "| " + cd.getSoLuong(),
                        "| " + cd.getGia(),
                        "| " + cd.getTheLoai(),
                        "|");
                System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
            }
        }
    }


    public void timCDTheoGia(double gia) {
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
        System.out.format("%-30s %-30s %-20s %-20s %-15s\n",
                "| Ten CD",
                "| Ten nghe si",
                "| Nam phat hanh",
                "| So luong",
                "| Gia (USD)          |" +
                        " The loai      |");
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");

        for (CD cd : cds) {
            if (cd.getGia() == gia) {
                System.out.format("%-30s %-30s %-20s %-20s %-20s %-15s %-1s\n",
                        "| " + cd.getTenCD(),
                        "| " + cd.getTenNgheSi(),
                        "| " + cd.getNamPhatHanh(),
                        "| " + cd.getSoLuong(),
                        "| " + cd.getGia(),
                        "| " + cd.getTheLoai(),
                        "|");
                System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
            }
        }
    }

    public void timCDTheoSoLuong(int soLuong) {
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
        System.out.format("%-30s %-30s %-20s %-20s %-15s\n",
                "| Ten CD",
                "| Ten nghe si",
                "| Nam phat hanh",
                "| So luong",
                "| Gia (USD)          |" +
                        " The loai      |");
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");

        for (CD cd : cds) {
            if (cd.getSoLuong() == soLuong) {
                System.out.format("%-30s %-30s %-20s %-20s %-20s %-15s %-1s\n",
                        "| " + cd.getTenCD(),
                        "| " + cd.getTenNgheSi(),
                        "| " + cd.getNamPhatHanh(),
                        "| " + cd.getSoLuong(),
                        "| " + cd.getGia(),
                        "| " + cd.getTheLoai(),
                        "|");
                System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
            }
        }
    }

    public void soLuong() {
        int maxSoLuong = Integer.MIN_VALUE;
        int minSoLuong = Integer.MAX_VALUE;
        CD cdMaxSoLuong = null;
        CD cdMinSoLuong = null;

        for (CD cd : cds) {
            if (cd.getSoLuong() > maxSoLuong) {
                maxSoLuong = cd.getSoLuong();
                cdMaxSoLuong = cd;
            }

            if (cd.getSoLuong() < minSoLuong) {
                minSoLuong = cd.getSoLuong();
                cdMinSoLuong = cd;
            }
        }

        System.out.println("CD co so luong nhieu nhat:");
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
        System.out.format("%-30s %-30s %-20s %-20s %-15s\n",
                "| Ten CD",
                "| Ten nghe si",
                "| Nam phat hanh",
                "| So luong",
                "| Gia (USD)          |" +
                        " The loai      |");
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
        System.out.format("%-30s %-30s %-20s %-20s %-20s %-15s %-1s\n",
                "| " + cdMaxSoLuong.getTenCD(),
                "| " + cdMaxSoLuong.getTenNgheSi(),
                "| " + cdMaxSoLuong.getNamPhatHanh(),
                "| " + cdMaxSoLuong.getSoLuong(),
                "| " + cdMaxSoLuong.getGia(),
                "| " + cdMaxSoLuong.getTheLoai(),
                "|");
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");

        System.out.println("CD co so luong it nhat:");
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");
        System.out.format("%-30s %-30s %-20s %-20s %-15s\n",
                "| Ten CD",
                "| Ten nghe si",
                "| Nam phat hanh",
                "| So luong",
                "| Gia (USD)          |" +
                        " The loai      |");
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");

        System.out.format("%-30s %-30s %-20s %-20s %-20s %-15s %-1s\n",
                "| " + cdMinSoLuong.getTenCD(),
                "| " + cdMinSoLuong.getTenNgheSi(),
                "| " + cdMinSoLuong.getNamPhatHanh(),
                "| " + cdMinSoLuong.getSoLuong(),
                "| " + cdMinSoLuong.getGia(),
                "| " + cdMinSoLuong.getTheLoai(),
                "|");
        System.out.println("|------------------------------|------------------------------|--------------------|--------------------|--------------------|---------------|");

        int tong = 0;
        for (CD cd : cds) {
            tong += cd.getSoLuong();
        }
        System.out.println("Tong CD trong kho: " + tong);
    }

    public void luuDuLieuXuongDatabase() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/cd";
        String username = "root";
        String password = "admin123@";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM cd.cdamnhac");
        for (CD cd : cds) {
            String sql = "INSERT INTO cdamnhac (maCD, tenCD, tenNgheSi, nam, soLuong, gia, theLoai,style) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cd.getMaCD());
            preparedStatement.setString(2, cd.getTenCD());
            preparedStatement.setString(3, cd.getTenNgheSi());
            preparedStatement.setInt(4, cd.getNamPhatHanh());
            preparedStatement.setInt(5, cd.getSoLuong());
            preparedStatement.setDouble(6, cd.getGia());
            preparedStatement.setString(7, cd.getTheLoai());
            preparedStatement.setString(8, cd.getStyle());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        connection.close();
        statement.close();
    }

    public void layDuLieuTuDatabase() {
        cds = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cd", "root", "admin123@");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cd.cdamnhac");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maCD = rs.getString("maCD");
                String tenCD = rs.getString("tenCD");
                String tenNgheSi = rs.getString("tenNgheSi");
                int nam = rs.getInt("nam");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                String theLoai = rs.getString("theLoai");
                String style = rs.getString("style");
                if (style != null && style.equalsIgnoreCase("DuongDai")) {
                    CDNhacDuongDai cd = new CDNhacDuongDai(maCD, tenCD, tenNgheSi, nam, soLuong, gia, theLoai);
                    cds.add(cd);
                } else if (style != null && style.equalsIgnoreCase("CoDien")) {
                    CDNhacCoDien cd = new CDNhacCoDien(maCD, tenCD, tenNgheSi, nam, soLuong, gia, theLoai);
                    cds.add(cd);
                }
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void nhapKho() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhap so phieu: ");
        String soPhieu = scanner.nextLine();
        System.out.print("Nhap ma CD: ");
        String maCD = scanner.nextLine();
        System.out.print("Nhap so luong: ");
        int soLuong = scanner.nextInt();
        System.out.print("Nhap ma NCC: ");
        scanner.nextLine();
        String maNCC = scanner.nextLine();
        LocalDate ngay = LocalDate.now();
        for (int i = 0; i < cds.size(); i++) {
            CD cd = cds.get(i);
            if (cd.getMaCD().equalsIgnoreCase(maCD)) {
                cd.setSoLuong(cd.getSoLuong() + soLuong);
                double donGia = soLuong * cd.getGia();
                System.out.println("Nhap kho thanh cong!");
                String url = "jdbc:mysql://127.0.0.1:3306/cd";
                String username = "root";
                String password = "admin123@";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (Exception e) {
                    System.out.println(e);
                }
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                String sql = "INSERT INTO phieunhap (soPhieu,maCD,maNCC,soLuong,donGia ,ngayNhap) VALUES (?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, soPhieu);
                preparedStatement.setString(2, maCD);
                preparedStatement.setString(3, maNCC);
                preparedStatement.setInt(4, soLuong);
                preparedStatement.setDouble(5, donGia);
                preparedStatement.setDate(6, Date.valueOf(ngay));
                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
                statement.close();
                return;
            }
        }
        System.out.println("Khong tim thay CD trong kho!");
    }

    public void xuatKho() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhap so phieu: ");
        String soPhieu = scanner.nextLine();
        System.out.print("Nhap ma CD: ");
        String maCD = scanner.nextLine();
        System.out.print("Nhap so luong: ");
        int soLuong = scanner.nextInt();
        System.out.print("Nhap ma NCC: ");
        scanner.nextLine();
        String maNCC = scanner.nextLine();
        LocalDate ngay = LocalDate.now();
        for (int i = 0; i < cds.size(); i++) {
            CD cd = cds.get(i);
            if (cd.getMaCD().equalsIgnoreCase(maCD)) {
                if (cd.getSoLuong() >= soLuong) {
                    cd.setSoLuong(cd.getSoLuong() - soLuong);
                    double donGia = soLuong * cd.getGia();
                    System.out.println("Xuat kho thanh cong!");
                    String url = "jdbc:mysql://127.0.0.1:3306/cd";
                    String username = "root";
                    String password = "admin123@";
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    Connection connection = DriverManager.getConnection(url, username, password);
                    Statement statement = connection.createStatement();
                    String sql = "INSERT INTO phieuxuat (soPhieu,maCD,maNCC,soLuong,donGia ,ngayXuat) VALUES (?,?,?,?,?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, soPhieu);
                    preparedStatement.setString(2, maCD);
                    preparedStatement.setString(3, maNCC);
                    preparedStatement.setInt(4, soLuong);
                    preparedStatement.setDouble(5, donGia);
                    preparedStatement.setDate(6, Date.valueOf(ngay));
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    connection.close();
                    statement.close();
                } else {
                    System.out.println("Khong du so luong trong kho!");
                }
                return;
            }
        }
        System.out.println("Khong tim thay CD trong kho!");
    }

    public void MENU() {
        System.out.printf("------QUAN LY KHO CD AM NHAC------\n" +
                "1.In danh sach\n" +
                "2.Them\n" +
                "3.Sua\n" +
                "4.Tim kiem\n" +
                "5.Sap xep \n" +
                "6.Luu du lieu xuong database\n" +
                "7.Doc du lieu tu database\n" +
                "8.Nhap/Xuat kho\n" +
                "9.Thong ke\n" +
                "0.Thoat khoi chuong trinh\n");
    }
}
