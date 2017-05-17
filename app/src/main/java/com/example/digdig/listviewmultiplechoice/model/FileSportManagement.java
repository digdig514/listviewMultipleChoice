package com.example.digdig.listviewmultiplechoice.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by digdig on 17-05-17.
 */

public class FileSportManagement {

    public static ArrayList<Sports> readFile(Context context, String fileName)
    {
        ArrayList<Sports> listOfSports =  new ArrayList<Sports>();
        AssetManager assetManager = context.getResources().getAssets();
        try
        {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));
            BufferedReader br =  new BufferedReader(isr);
            String online;
            while ((online=br.readLine())!=null)
            {
                StringTokenizer st =  new StringTokenizer(online,",");
                int sportId = Integer.valueOf(st.nextToken());
                String sportName = st.nextToken();
                Sports sport = new Sports(sportId,sportName);
                listOfSports.add(sport);
            }
            br.close();
            isr.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();;
        }
        return listOfSports;
    }
}
