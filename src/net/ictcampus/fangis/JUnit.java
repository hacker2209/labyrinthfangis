package net.ictcampus.fangis;

import java.util.ArrayList;

public class JUnit {
    private ArrayList tiere = new ArrayList();
    public static void main(String[] args){
        JUnit j = new JUnit();
        j.addToList("Bär");
        j.addToList("Hund");
        System.out.println("Bär: "+j.findInList("Bär"));
        System.out.println("Hund: "+j.findInList("Hund"));
    }
    public void addToList(String eintrag) {
        tiere.add(eintrag);
    }

    public int findInList(String eintrag) {
        int position = 0;
        int finalPos =0;
        boolean founded = false;
        for (Object i : tiere) {
            if (i.equals(eintrag)) {
                finalPos = position;
                founded=true;
            } else {
                position++;
                founded=false;
            }
        }
        if (founded){
            return finalPos;
        }
        else {
            return 99;
        }
    }
}
