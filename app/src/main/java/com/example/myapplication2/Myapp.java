package com.example.myapplication2;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class Myapp extends Application {
static ArrayList<String>contacts;
static String current_contact;
static String current_sound;
static ArrayList<String>sounds;
    @Override
    public void onCreate() {
        super.onCreate();
         contacts = new ArrayList<>();
        contacts.add("Jan Kowalski");
        contacts.add("Zuzanna Domaracka");
        contacts.add("Katarzyna Kowalska");
        contacts.add("Piotr Kowal");
        contacts.add("Jerzy Pol");
        current_contact = contacts.get(0);
     sounds= new ArrayList<>();
     sounds.add("Sound1");
     sounds.add("Sound2");
     current_sound=sounds.get(0);
    }
}
