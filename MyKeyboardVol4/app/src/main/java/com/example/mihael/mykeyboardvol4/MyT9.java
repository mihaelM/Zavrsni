package com.example.mihael.mykeyboardvol4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mihael on 12.5.2016..
 */
public class MyT9 {
    public static class ParSI implements Comparable<ParSI>{
        String s1;
        Integer s2;

        public ParSI(String _s1, Integer _s2) {
            s1 = _s1;
            s2 = _s2;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ParSI))
                return false;
            ParSI other = (ParSI) obj;
            return this.s1.equals(other.s1) && this.s2.equals(other.s2);
        }


        @Override
        public int compareTo(ParSI drugi) {
            return this.s2.compareTo(drugi.s2); //samo po broju usporedimo
        }
    }


    public static List<String> getSuggestions(String searchWord){
        List <String> svi = ListKeeper.svi;
        List <Integer> freq = ListKeeper.freq;

        int size = svi.size();

        int down = 0;
        int up = size - 1;
        int mid;

        //naci cemo apsolutno sve moguce od 1 i 2 s pripadnim frekvencijama i stavljati u hashmapu, a zatim odabrati najmanjih pet na kraju

        HashMap<String, Integer> ponuda = new HashMap<>();
        ArrayList <String> finalPonuda = new ArrayList<>();

        //ako je ima ta rijec sta onda ???.. tbc, a nista ,startamo algo al ne racunamo kao rj.
        while (down != up){
            mid = (down + up)/2;

            String currWord = svi.get(mid);

            if (currWord.startsWith(searchWord)){
                //vrijeme je da startamo, tbc
                //prvo ovog gledamo
                if (currWord.length() > searchWord.length()){

                    //treba ipak naci real start i onda lupit while.., da imamo freqv il nesto bilo bi bolje al ono...

                    int currInd = mid - 1;
                    while (currInd >= 0){
                        String word = svi.get(currInd);
                        boolean startsWith = word.startsWith(searchWord);
                        if (!startsWith){
                            break;
                        }
                        currInd -= 1;
                    }

                    currInd += 1;
                    while (currInd <= size - 1){
                        String word = svi.get(currInd);
                        boolean startsWith = word.startsWith(searchWord);
                        if (startsWith && !word.equals(searchWord)){
                            //word.substring(searchWord.length(), searchWord.length() + 2);
                            if (searchWord.length() + 1 <= word.length()){
                                String sp = word.substring(searchWord.length(),  searchWord.length()+1);
                                if (ponuda.containsKey(sp)){
                                    ponuda.put(sp, Math.min(ponuda.get(sp), freq.get(currInd)));
                                }
                                else {
                                    ponuda.put(sp,  freq.get(currInd) );
                                }
                            }
                            if (searchWord.length() + 2 <= word.length()){
                                String sp = word.substring(searchWord.length(),  searchWord.length()+2);
                                if (ponuda.containsKey(sp)){
                                    ponuda.put(sp, Math.min(ponuda.get(sp), freq.get(currInd)));
                                }
                                else{
                                    ponuda.put(sp,  freq.get(currInd) );
                                }
                            }

                        }
                        if (!startsWith){
                            break;
                        }
                        currInd += 1;

                    }

                }
                //tu sad trazimo tih pet
                ArrayList <ParSI> help = new ArrayList<>();
                for (Map.Entry<String, Integer> entry : ponuda.entrySet()){
                    help.add(new ParSI(entry.getKey(), entry.getValue()));
                    //System.out.println(entry.getKey() + " " + entry.getValue());

                }

                Collections.sort(help);

                for (int t=0; t<Math.min(help.size(), 5); t++){
                    finalPonuda.add(help.get(t).s1);
                }


                break;

            }
            else if (currWord.compareTo(searchWord) > 0){
                up = mid;
            }
            else {
                down = mid + 1;
            }

        }
        return finalPonuda;
    }


}
