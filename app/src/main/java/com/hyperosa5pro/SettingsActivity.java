
package com.hyperosa5pro;

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.*;
import android.widget.*;

public class SettingsActivity extends Activity {
    int dp(float n) {
        return (int)(n * getResources().getDisplayMetrics().density + .5f);
    }

    GradientDrawable shape(int c) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(c);
        d.setCornerRadius(dp(22));
        return d;
    }

    TextView label(String s, int z, int c, boolean b) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextSize(z);
        t.setTextColor(c);
        if (b) t.setTypeface(null, 1);
        return t;
    }

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        render();
    }

    void render() {
        boolean dark = ThemeStore.dark(this);
        int bg = dark ? 0xFF0D0F13 : 0xFFF4F5F9;
        int fg = dark ? Color.WHITE : 0xFF17191F;
        int card = dark ? 0xFF202228 : Color.WHITE;

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(1);
        root.setPadding(dp(20), dp(28), dp(20), dp(20));
        root.setBackgroundColor(bg);
        setContentView(root);

        TextView back = label("‹   Ajustes", 28, fg, true);
        back.setOnClickListener(v -> finish());
        root.addView(back);

        root.addView(label(
            "Personaliza tu experiencia",
            14, 0xFF858A96, false
        ));

        LinearLayout mode = new LinearLayout(this);
        mode.setGravity(Gravity.CENTER_VERTICAL);
        mode.setPadding(dp(18), dp(15), dp(14), dp(15));
        mode.setBackground(shape(card));

        TextView txt = label(
            "Modo oscuro\nCambiar apariencia",
            16, fg, true
        );
        mode.addView(txt, new LinearLayout.LayoutParams(0, -2, 1));

        Switch sw = new Switch(this);
        sw.setChecked(dark);
        mode.addView(sw);
        sw.setOnCheckedChangeListener(
            (v, c) -> ThemeStore.dark(this, c)
        );

        LinearLayout.LayoutParams mp =
            new LinearLayout.LayoutParams(-1, -2);
        mp.setMargins(0, dp(25), 0, dp(12));
        root.addView(mode, mp);

        TextView themes = label(
            "Paletas y temas     ›", 17, fg, true
        );
        themes.setPadding(dp(18), dp(22), dp(18), dp(22));
        themes.setBackground(shape(card));
        themes.setOnClickListener(
            v -> startActivity(new Intent(this, ThemesActivity.class))
        );
        root.addView(themes);

        TextView info = label(
            "HYPEROS A5 PRO FINAL\n" +
            "Launcher inspirado en HyperOS. " +
            "No modifica la ROM ni el panel del sistema.",
            13, 0xFF858A96, false
        );
        info.setPadding(dp(5), dp(25), dp(5), dp(5));
        root.addView(info);
    }
}
