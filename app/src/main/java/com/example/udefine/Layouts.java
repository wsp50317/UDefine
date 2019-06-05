package com.example.udefine;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;

public class Layouts {
    @PrimaryKey(autoGenerate = true)
    private int mIndex = 1;

    @ColumnInfo(name = "LayoutID")
    private int mLayoutID;

    @ColumnInfo(name = "LayoutName")
    private String mLayoutName;

    @ColumnInfo(name = "Format")
    private int mFormat;

    public Layouts(int LayoutID, String LayoutName, int Format) {
        this.mLayoutID = LayoutID;
        this.mLayoutName = LayoutName;
        this.mFormat = Format;
    }

    //public void setLayoutID(String LayoutID){this.mLayoutID = LayoutID;}
    public int getIndex(){return this.mIndex;}
    public int getLayoutID(){return this.mLayoutID;}
    public String getLayoutName(){return this.mLayoutName;}
    public int getFormat(){return this.mFormat;}
}
