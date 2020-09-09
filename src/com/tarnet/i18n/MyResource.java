package com.tarnet.i18n;

import java.util.ListResourceBundle;

public class MyResource  extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{{"price","10"},{"currency","EUR"}};
    }
}
