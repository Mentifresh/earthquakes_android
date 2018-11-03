package com.dankildev.earthquakenews;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;


public class QuakeReportAdapter extends ArrayAdapter<QuakeReport> {

    public QuakeReportAdapter(Context context, ArrayList<QuakeReport> quakereport) {
        super(context, 0, quakereport);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.quakelistviewlayout, parent, false);
        }

        QuakeReport currentQuakeReport = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitudeTextView);
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.locationTextView);
        TextView kilometersTextView = (TextView) listItemView.findViewById(R.id.kilometersTextView);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.dateTextView);
        TextView hourTextView = (TextView) listItemView.findViewById(R.id.hourTextView);

        Date dateObject = new Date(currentQuakeReport.getTimeInMilliseconds());
        String fullLocation = currentQuakeReport.getLocation();

        //Setting magnitude textView
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(currentQuakeReport.getMagnitude());
        magnitudeTextView.setText(output);

        //Setting location TextViews
        if (fullLocation.indexOf("of") == -1) {
            locationTextView.setText(fullLocation);
            kilometersTextView.setText("Near of");
        } else {
            String[] locationSplitted = fullLocation.split("of", 2);
            String kmText = locationSplitted[0] + " of";

            locationTextView.setText(locationSplitted[1].trim());
            kilometersTextView.setText(kmText);
        }

        //Setting date & hour textViews
        dateTextView.setText(formatDate(dateObject));
        hourTextView.setText(formatTime(dateObject));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentQuakeReport.getMagnitude());

        Log.v("Chacho los colores", magnitudeColor + ",");
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(double magnitude) {
        int number = (int) Math.floor(magnitude);
        String search = String.valueOf(number);
        int color;

        switch (search) {
            case "0":
                color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case "1":
                color = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case "2":
                color = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case "3":
                color = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case "4":
                color = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case "5":
                color = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case "6":
                color = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case "7":
                color = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case "8":
                color = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case "9":
                color = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                color = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return color;
    }

}