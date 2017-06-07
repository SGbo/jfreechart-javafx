package utils;

public class FxUtils {
    public static javafx.scene.paint.Color fromAwtColor(java.awt.Color awtColor) {
        javafx.scene.paint.Color fxColor = javafx.scene.paint.Color.rgb(awtColor.getRed(),
                awtColor.getGreen(),
                awtColor.getBlue(),
                awtColor.getAlpha() / 255.0);

        return fxColor;
    }

    public static java.awt.Color toAwtColor(javafx.scene.paint.Color fx) {
        java.awt.Color awt = new java.awt.Color((float) fx.getRed(),
                (float) fx.getGreen(),
                (float) fx.getBlue(),
                (float) fx.getOpacity());

        return awt;
    }
}
