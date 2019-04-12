package com.example.movieposters.cinema;

import com.example.movieposters.model.ExpModel.KinoTeather;
import com.example.movieposters.model.ExpModel.Session_Zals_Time;

import java.util.ArrayList;

public class Model implements Contracter.model  {

    private final Contracter.view view;

    public Model(Contracter.view view){
        this.view = view ;
    }

    @Override
    public void ProcessData(String Data, String Poster, String Actors) {
        ArrayList<KinoTeather> kinoTeathers = sort(Data);
        String HDPoster = MakeNormalImg(Poster);

        String ActorsNorm = filtrActors(Actors);

        view.Display(HDPoster, kinoTeathers, ActorsNorm);
    }

    public String MakeNormalImg(String img){
        String[] image = img.split("sm_");
        img = image[0] + image[1];
        return img;
    }

    public String filtrActors(String cod){
        int startBig = 1040;
        int end = 1103;
        int orBig = 1025;
        int orSmoll = 1105;
        String s = "";
        for (int i = 0; i<cod.length() ; i++ ){

            if ((int)(cod.charAt(i))<=end && (int)(cod.charAt(i)) >=startBig || (int)(cod.charAt(i)) == orBig || (int)(cod.charAt(i)) == orSmoll){
                s += cod.charAt(i);
                if ((cod.charAt(i + 1) + "").equals("<")){
                    s += ", ";
                    i++;
                }
            }
            else if (((cod.charAt(i) + "").equals(" ")) && ((int)cod.charAt(i + 1))<=end && (int)(cod.charAt(i + 1)) >=startBig){
                s+= cod.charAt(i);
            }

        }
        return s;
    }

    public ArrayList<KinoTeather> sort(String Data){
        ArrayList<KinoTeather> kinoTeathers = new ArrayList<>();

        String[] str = Data.split("razdelitkinoteather");
        for (String string : str){
            if (!string.equals("")) {
                String[] zals = string.split("razdelitzal");
                ArrayList<Session_Zals_Time> session_zals_times = new ArrayList<>();
                for (int i = 2; i < zals.length; i++) {

                    String sessiansAndZals = "";
                    String[] seans = zals[i].split("razdelitvremi");
                    sessiansAndZals += "\t" + seans[0] + ":" + "\n";

                    for (int j = 1; j < seans.length; j++ ) {
                        sessiansAndZals += "\t\t" + seans[j] + "\n";
                    }
                    session_zals_times.add(new Session_Zals_Time(sessiansAndZals));
                }
                KinoTeather kinoTeather = new KinoTeather(zals[1], session_zals_times);
                kinoTeathers.add(kinoTeather);
            }
        }

        return kinoTeathers;
    }



}
