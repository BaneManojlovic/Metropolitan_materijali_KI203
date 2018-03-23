/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadatak01;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author manojlovic
 */
public class Zadatak1 {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        try{
              //kreiram tabelu
            DBUtil.createTable();
           
            System.out.println("Tabela kreirana!\n");
            System.out.println("---- MENI ----");
            System.out.println("1. Dodaj novi auto u bazu");
            System.out.println("2. Ispisi automobile iz baze");
            System.out.println("3. Obrisi auto iz baze");
            System.out.println("4. Izmeni auto u bazi");
            System.out.println("5. Filtriraj automobile starije od 2000 godista");
            System.out.println("6. Izlaz iz programa");
            int izbor = 0;
            System.out.println("Izaberite zeljenu opciju:");
            izbor = sc.nextInt();
            switch (izbor) {
                case 1:
                    //dodajem novi automobil u bazu
//                  Automobili auto = new Automobili(1, "BMW 520i", 2001, 3500);
                    Automobili auto = new Automobili();
                    System.out.println("Unesite model automobila:");
                    String model = sc.next();
                    auto.setModel(model);
                    System.out.println("Unesite godiste automobila:");
                    int godiste = sc.nextInt();
                    auto.setGodiste(godiste);
                    System.out.println("Unesite cenu automobila:");
                    double cena = sc.nextDouble();
                    auto.setCena(cena);
                    DBUtil.addAuto(auto);
                    System.out.println("Auto upisan u bazu!");
                    break;
                case 2:
                    //pozivam ispis iz baze
                    List<Automobili> kola = DBUtil.getAll();
                    for (Automobili a : kola) {
                        System.out.println(a);
                    }
                    break;
                case 3:
                     //pozivam brisanje automobila iz baze koji se nalazi na rednom broju 1 u bazi
                    System.out.println("Unasite koji auto po redu zelite da obrisete:");
                    int a = sc.nextInt();
                    DBUtil.deleteAuto(a);                   
                    System.out.println("Auto na poziciji: " + a + ", je uspesno obrisan.");
                    break;
                case 4:
                    //pozivam metodu za azururanje podataka iz baze
      /*              List<Automobili> kola2 = DBUtil.getAll();
                    System.out.println("Unesite redni broj automobila u bazi:");
                    int redBroj = sc.nextInt();
                    Automobili k = kola2.get(redBroj);
                    System.out.println("Unesite novu cenu: ");
                    int novaCena = sc.nextInt();
                    k.setCena(novaCena);
                    DBUtil.editAuto(k);*/
                    break;
                case 5:
                    //pozivam metodu za filtriranje podataka u bazi po zadatom kriterijumu.
                    System.out.println(DBUtil.getGodisteIzmedju1990i2000());
                    break;
                case 6:
                    System.out.println("Kraj programa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Izabrali ste nepostojecu opciju!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
