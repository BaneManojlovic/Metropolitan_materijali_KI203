import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ilove
 */
public class Zadatak4 {
    //Zadatak 4 Napisati program koji prikazuje sve cele brojeve u intervalu čije granice unosi korisnik koji su deljivi brojevima 5 ili 6. 
    public static void main (String [] args){
            
              Scanner ulaz = new Scanner(System.in);
              
              System.out.print("Unesi prvi borj intervala: ");
              int prviBroj = ulaz.nextInt();
              
              System.out.print("Unesi drugi borj intervala: ");
              int drugiBroj = ulaz.nextInt();
              
              for(; prviBroj<=drugiBroj; prviBroj++){
                  
                  if (prviBroj % 5 == 0 || prviBroj % 6 == 0 ){
                      
                      System.out.println(prviBroj);
                      
                  }
              }
            
        }
    
}

