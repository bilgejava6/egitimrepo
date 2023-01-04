package com.aliakkulah;

import com.aliakkulah.controller.DepartmanController;
import com.aliakkulah.controller.PersonelController;
import com.aliakkulah.utility.Menu;

public class Main {
    public static void main(String[] args) {
        PersonelController pc = new PersonelController();
        DepartmanController dc = new DepartmanController();
        Menu menu = new Menu();
        dc.baslangicDepartmanlariEkle();
        pc.baslangicKisileriAtama();
        menu.runAna();
        System.out.println("yeni branch eklendi.");
    }
}