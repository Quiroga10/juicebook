package com.quiroga.jugueria.network;

import android.content.res.Resources;
import  android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.quiroga.jugueria.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

public class JugoEntry implements Parcelable {
    private static final String TAG = JugoEntry.class.getSimpleName();

    public  String title;
    public  Uri dynamicUrl;
    public  String url;
    public  String description;
    public  String category;

    public static final Parcelable.Creator<JugoEntry> CREATOR = new Parcelable.Creator<JugoEntry>(){
        @Override
        public JugoEntry createFromParcel(Parcel source) {
            return new JugoEntry(source);
        }

        @Override
        public JugoEntry[] newArray(int size) {
            return new JugoEntry[size];
        }
    };

    public JugoEntry(Parcel parcel) {
        this.title = parcel.readString();
        this.dynamicUrl = Uri.parse(parcel.readString());
        this.url = parcel.readString();
        this.description = parcel.readString();
        this.category = parcel.readString();

    }

    public JugoEntry(String title, String dynamicUrl, String url, String description, String category) {
        this.title = title;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.description = description;
        this.category = category;
    }

    public static List<JugoEntry> initJugoEntryList (Resources resources) {
        InputStream inputStream = resources.openRawResource(R.raw.categorias);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0 , pointer);
            }
        } catch (IOException exception){
            Log.e(TAG, "Hubo un error al momento de leer y escribir el archivo JSON.", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                Log.e(TAG, "Hubo error al cerrar el input stream", exception);
            }
        }

        String jsonJugueriaString = writer.toString();
        Gson gson = new Gson();
        Type jugoListType = new TypeToken<ArrayList<JugoEntry>>(){
        }.getType();

        return gson.fromJson(jsonJugueriaString, jugoListType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.dynamicUrl==null?"":this.dynamicUrl.toString());
        dest.writeString(this.url);
        dest.writeString(this.description);
        dest.writeString(this.category);
    }
}
