package com.hyperosa5pro;
import android.content.Context;
public final class ThemeStore {
 private static final String P="hyperos_theme";
 public static int get(Context c,String k,int d){return c.getSharedPreferences(P,0).getInt(k,d);}
 public static void set(Context c,String k,int v){c.getSharedPreferences(P,0).edit().putInt(k,v).apply();}
 public static boolean dark(Context c){return c.getSharedPreferences(P,0).getBoolean("dark",false);}
 public static void dark(Context c,boolean v){c.getSharedPreferences(P,0).edit().putBoolean("dark",v).apply();}
}
