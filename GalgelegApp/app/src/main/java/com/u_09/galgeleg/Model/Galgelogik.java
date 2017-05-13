package com.u_09.galgeleg.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Galgelogik {

    private ArrayList<String> muligeOrd = new ArrayList<>();
    private String ordet;
    private ArrayList<String> brugteBogstaver = new ArrayList<>();
    private String synligtOrd;
    private int antalForkerteBogstaver;
    private boolean sidsteBogstavVarKorrekt;
    private boolean spilletErVundet;
    private boolean spilletErTabt;

    public Galgelogik() {
        nulstil();
    }

    public static String hentUrl(String url) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        StringBuilder sb = new StringBuilder();
        String linje = br.readLine();
        while (linje != null) {
            sb.append(linje + "\n");
            linje = br.readLine();
        }
        return sb.toString();
    }

    public ArrayList<String> getBrugteBogstaver() {

        return brugteBogstaver;
    }

    public String getSynligtOrd() {

        return synligtOrd;
    }

    public String getOrdet() {

        return ordet;
    }

    public void setOrdet(int i) {
        this.ordet = muligeOrd.get(i);
    }

    public int getAntalForkerteBogstaver() {

        return antalForkerteBogstaver;
    }

    public void setAntalForkerteBogstaver(int antalForkerteBogstaver) {
        this.antalForkerteBogstaver = antalForkerteBogstaver;
    }

    public boolean erSidsteBogstavKorrekt() {

        return sidsteBogstavVarKorrekt;
    }

    public boolean erSpilletVundet() {

        return spilletErVundet;
    }

    public boolean erSpilletTabt() {

        return spilletErTabt;
    }

    public boolean erSpilletSlut() {

        return spilletErTabt || spilletErVundet;
    }

    public void nulstil() {

        brugteBogstaver.clear();
        antalForkerteBogstaver = 0;
        spilletErVundet = false;
        spilletErTabt = false;
    }

    public void opdaterSynligtOrd() {

        synligtOrd = "";
        spilletErVundet = true;
        for (int n = 0; n < ordet.length(); n++) {
            String bogstav = ordet.substring(n, n + 1);
            if (brugteBogstaver.contains(bogstav)) {
                synligtOrd = synligtOrd + bogstav;
            } else {
                synligtOrd = synligtOrd + "*";
                spilletErVundet = false;
            }
        }
    }

    public void gætBogstav(String bogstav) {

        if (bogstav.length() != 1) return;
        System.out.println("Der gættes på bogstavet: " + bogstav);
        if (brugteBogstaver.contains(bogstav)) return;
        if (spilletErVundet || spilletErTabt) return;

        brugteBogstaver.add(bogstav);

        if (ordet.contains(bogstav)) {
            sidsteBogstavVarKorrekt = true;
            System.out.println("Bogstavet var korrekt: " + bogstav);
        } else {
            // Vi gættede på et bogstav der ikke var i ordet.
            sidsteBogstavVarKorrekt = false;
            System.out.println("Bogstavet var IKKE korrekt: " + bogstav);
            antalForkerteBogstaver = antalForkerteBogstaver + 1;
            if (antalForkerteBogstaver > 6) {
                spilletErTabt = true;
            }
        }
        opdaterSynligtOrd();
    }

    public void logStatus() {

        System.out.println("---------- ");
        System.out.println("- ordet (skult) = " + ordet);
        System.out.println("- synligtOrd = " + synligtOrd);
        System.out.println("- forkerteBogstaver = " + antalForkerteBogstaver);
        System.out.println("- brugeBogstaver = " + brugteBogstaver);
        if (spilletErTabt) System.out.println("- SPILLET ER TABT");
        if (spilletErVundet) System.out.println("- SPILLET ER VUNDET");
        System.out.println("---------- ");
    }

    public void hentOrdFraDr() throws Exception {

        String data = hentUrl("http://dr.dk");
        System.out.println("data = " + data);

//      data = data.replaceAll("<.+?>", " ").toLowerCase().replaceAll("[^a-zæøå]", " ");
        data = data.substring(data.indexOf("<body")).
                replaceAll("<.+?>", " ").toLowerCase().replaceAll("[^a-zæøå]", " ").
                replaceAll(" [a-zæøå] ", " "). // fjern 1-bogstavsord
                replaceAll(" [a-zæøå][a-zæøå] ", " "); // fjern 2-bogstavsord
        System.out.println("data = " + data);
        muligeOrd.clear();
        muligeOrd.addAll(new HashSet<>(Arrays.asList(data.split(" "))));

        System.out.println("muligeOrd = " + muligeOrd);
//        nulstil();
    }

    public ArrayList<String> getMuligeOrd() {
        return muligeOrd;
    }
}
