/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package giatoc;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class TinhLinhTimThuoc extends GiaToc{
    private int slLinhChi = 0;
    private int slHaThuO = 0;
    private int slNhanSam = 0;
    private int slThatTamLien = 0;
    public TinhLinhTimThuoc(){
        try{
            DocFile();
        }
        catch(IOException e){
            System.out.println("Loi xay ra: " + e.getMessage());
        }
}
    @Override
    public void Nhap()throws SoLoaiException{
        super.Nhap();
        chungtoc = "Tinh Linh";
        nghenghiep = "Tim Thuoc";
        int loai = 0;
        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Nhap loai thuoc tim duoc, hay nhap so tuong ung: (1)Linh Chi, (2)Ha Thu O, (3)Nhan Sam, (4)That Tam Lien, (0)Ket Thuc Viec Nhap...");
            try{
                loai = Integer.parseInt(scan.nextLine());
                if(loai < 0 || loai > 5){
                    throw new SoLoaiException();
                }
            }
            catch(NumberFormatException e){
                loai = 5;
                System.out.println("So khong hop le !");
            }
            catch(SoLoaiException e){
                System.out.println(e.getMessage());
            }
            switch(loai)
            {
                case 1:
                        System.out.print("Nhap so luong Linh Chi: ");
                        try{
                            slLinhChi += Integer.parseInt(scan.nextLine());
                            if(slLinhChi < 0)
                                throw new SoLoaiException();
                        }
                        catch(SoLoaiException e){
                            System.out.println(e.getMessage());
                        }
                        catch(NumberFormatException e){
                            System.out.println("So khong hop le!");
                        }
                        break;
                case 2:
                        System.out.print("Nhap so luong Ha Thu O: ");
                        try{
                            slHaThuO += Integer.parseInt(scan.nextLine());
                            if(slHaThuO < 0)
                                throw new SoLoaiException();
                        }
                        catch(SoLoaiException e){
                            System.out.println(e.getMessage());
                        }
                        catch(NumberFormatException e){
                            System.out.println("So khong hop le!");
                        }
                        break;
                case 3:
                        System.out.print("Nhap so luong Nhan Sam: ");
                        try{
                            slNhanSam += Integer.parseInt(scan.nextLine());
                            if(slNhanSam < 0)
                                throw new SoLoaiException();
                        }
                        catch(SoLoaiException e){
                            System.out.println(e.getMessage());
                        }
                        catch(NumberFormatException e){
                            System.out.println("So khong hop le!");
                        }
                        break;
                case 4:
                        System.out.print("Nhap so luong That Tam Lien: ");
                        try{
                            slThatTamLien += Integer.parseInt(scan.nextLine());
                            if(slThatTamLien < 0)
                                throw new SoLoaiException();
                        }
                        catch(SoLoaiException e){
                            System.out.println(e.getMessage());
                        }
                        catch(NumberFormatException e){
                            System.out.println("So khong hop le!");
                        }
                        break;
                case 5:
                        break;
                case 0: exit = true;
            }
           } while(exit == false);
    }
    @Override
    public void Xuat(){
        TinhDiemCH();
        TinhCuBet();
        TinhTienThuong();
        super.Xuat();
        System.out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        System.out.print("\nThanh qua lao dong: Linh chi " + slLinhChi + ", Ha thu o " + slHaThuO + ", Nhan sam " + slNhanSam + ", That tam lien " + slThatTamLien);
        System.out.print("\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Thu nhap: " + tientongcong);
        System.out.print("\n-------------------------------------------------------------------------\n");
    }@Override
    public void Write() throws IOException{
        TinhDiemCH();
        TinhCuBet();
        TinhTienThuong();
        super.Write();
        PrintWriter out = new PrintWriter(new BufferedWriter( new FileWriter("dsthanhvien.txt", true)));
        out.print("  |Chung toc: " + chungtoc + "  |Nghe nghiep: " + nghenghiep);
        out.print("\r\nCubet: " + cubet + ", Diem cong hien: " + diemconghien + ", Tien thuong: " + tienthuong + ", Thu nhap: " + tientongcong);
        out.print("\r\n-------------------------------------------------------------------------\r\n");
        out.close();
        PrintWriter p = new PrintWriter(new BufferedWriter( new FileWriter("thanhqualaodong.txt", true)));
        p.print("  MaTV: " + getMTV());
        p.print("   Thanh qua lao dong: Linh chi " + slLinhChi + ", Ha thu o " + slHaThuO + ", Nhan sam " + slNhanSam + ", That tam lien project" + slThatTamLien);
        p.print("\r\n--------------------------------------------------------------------------------------------\r\n");
        p.close();
    }
    @Override
    protected void TinhDiemCH(){
        diemconghien = slLinhChi * giaLinhChi + slHaThuO * giaHaThuO + slNhanSam * giaNhanSam + slThatTamLien * giaThatTamLien;
    }
    @Override
    protected void TinhCuBet(){
        TinhTienThuong();
         cubet = slLinhChi * DCHLinhChi + slHaThuO * DCHHaThuO + slNhanSam * DCHNhanSam + slThatTamLien * DCHThatTamLien + tienthuong;
    }
    private int giaLinhChi, DCHLinhChi;
    private int giaHaThuO,DCHHaThuO;
    private int giaNhanSam, DCHNhanSam;
    private int giaThatTamLien, DCHThatTamLien;

    private void DocFile() throws FileNotFoundException, IOException{
        // TODO code application logic here
        //Vi du doc du lieu tu file
        class Struct {
        private String ten = "";
        private String gia = "";
        private String DCH = "";
    }
        ArrayList<Struct> arr = new ArrayList<Struct>();
        FileReader in = new FileReader("banggiatimthuoc.txt");
        char[] a = new char[300];
        in.read(a);
        Struct object = new Struct();
        int tab = 0;
        for(int i = 0; i < a.length; i++){
            if (tab == 0)
            {
                if(String.valueOf(a[i]).equals("\t")){ 
                    tab = 1; i++;}
                else
                    object.ten += String.valueOf(a[i]);
            }
            if(tab == 1){
                if(String.valueOf(a[i]).equals("\t")){ tab = 2; i++;}
                else
                    object.gia += String.valueOf(a[i]);
            }
            if(tab == 2){
                if(String.valueOf(a[i]).equals("\n")){
                    arr.add(object);
                    object = new Struct();
                    tab = 0;
                } else
                    if(String.valueOf(a[i]) == null){
                    arr.add(object);
                    object = new Struct();
                    } else
                        object.DCH += String.valueOf(a[i]);
            }
        }
        for(Struct ob: arr){
            if(ob.ten.trim().equalsIgnoreCase("LinhChi")){
                giaLinhChi = Integer.parseInt(ob.gia);
                DCHLinhChi = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.trim().equalsIgnoreCase("HaThuO")){
                giaHaThuO = Integer.parseInt(ob.gia);
                DCHHaThuO = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.trim().equalsIgnoreCase("NhanSam")){
                giaNhanSam = Integer.parseInt(ob.gia);
                DCHNhanSam = Integer.parseInt(ob.DCH.trim());
            }
            if(ob.ten.trim().equalsIgnoreCase("ThatTamLien")){
                giaThatTamLien = Integer.parseInt(ob.gia);
                DCHThatTamLien = Integer.parseInt(ob.DCH.trim());
            }
        }
        //in.close();
    }
}
