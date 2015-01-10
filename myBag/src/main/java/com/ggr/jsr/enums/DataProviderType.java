package com.ggr.jsr.enums;

/**
 * Created by stefan on 14-11-2.
 * <p/>
 * Enumerates data provider type.
 */
public enum DataProviderType {
    evernote, dropbox, google, mb;

    public String getName() {
        return name();
    }

    public String getLabel() {
        String label = "";
        switch (this) {
            case evernote:
                label = "Evenrnote";
                break;
            case dropbox:
                label = "Dropbox";
                break;
            case google:
                label = "Google drive";
                break;
            case mb:
                label = "MB database";
                break;
            default:
                break;
        }

        return label;
    }
}
