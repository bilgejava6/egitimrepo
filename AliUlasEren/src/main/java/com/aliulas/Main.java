package com.aliulas;

import com.aliulas.controller.PersonelController;
import com.aliulas.repository.entity.BuroPersoneli;
import com.aliulas.repository.entity.Personel;

import java.awt.desktop.SystemSleepEvent;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        PersonelController pc = new PersonelController();
        pc.anaMenu();

    }
}