package com.simpals.map.md.utils;

import android.view.Gravity;

public enum MapGravity {
    TOPLEFT(Gravity.TOP | Gravity.START),
    TOPRIGHT(Gravity.TOP | Gravity.END),
    BOTTOMRIGHT(Gravity.BOTTOM | Gravity.END),
    BOTTOMLEFT(Gravity.BOTTOM | Gravity.START);

    private int gravity;

    MapGravity(int gravity) {
        this.gravity = gravity;
    }

    public int toGravity() {
        return gravity;
    }
}
