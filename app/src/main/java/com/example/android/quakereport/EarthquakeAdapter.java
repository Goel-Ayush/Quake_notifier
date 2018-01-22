package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Ayush Goel on 12/24/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter {
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if(listitemView == null){
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_adapter,parent,false);
        }
        Earthquake currentData = (Earthquake) getItem(position);

//        NumberFormat nm = NumberFormat.getNumberInstance();

        TextView magnitudeView=(TextView)listitemView.findViewById(R.id.magn);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentData.getmagn());
        magnitudeCircle.setColor(magnitudeColor);
        magnitudeView.setText(Formatmag(currentData.getmagn()));

        Date dateobject = new Date(currentData.getDdate());
        String formattedDate = formatDate(dateobject);

        String formattedTime = formatTime(dateobject);

        String nearinkm = disnear(currentData.getPlace());
        TextView disnearkm =(TextView)listitemView.findViewById(R.id.disnear);
        disnearkm.setText(nearinkm);

        TextView PlaceView = (TextView)listitemView.findViewById(R.id.palce);
        PlaceView.setText(placeExact(nearinkm,currentData.getPlace()));

        TextView dateView =(TextView)listitemView.findViewById(R.id.date);
        dateView.setText((formattedDate));

        TextView TimeView =(TextView)listitemView.findViewById(R.id.time);
        TimeView.setText((formattedTime));

        return listitemView;
    }

    EarthquakeAdapter(Context context,  ArrayList<Earthquake> earthqukakes){

        super(context,0,earthqukakes);
    }

    public String formatDate(Date dateobject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateobject);
    }

    public String formatTime(Date dateobject){
        SimpleDateFormat timeformat = new SimpleDateFormat("h:mm a");
        return timeformat.format(dateobject);
    }

    public String disnear(String ab){
        int len = ab.length();
        if(ab.contains("of ")){
            int i = ab.indexOf("of ");
            String abc =ab.substring(0,i+3);
            ab=abc;

        }
        else
            ab="Near the";

        return ab;
    }

    public String placeExact(String ab, String xy){
        return xy.substring(ab.length(),xy.length());
    }

    public String Formatmag(double ab){
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        return decimalFormat.format(ab);

    }
    public int getMagnitudeColor(Double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
