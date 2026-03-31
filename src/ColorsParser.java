import java.awt.Color;

public class ColorsParser {
    public java.awt.Color colorFromString(String s) {
        if (s.startsWith("color(RGB")) {
            // Format: color(RGB(r,g,b))
            String content = s.substring(s.indexOf('(') + 1, s.lastIndexOf(')')); // RGB(r,g,b)
            content = content.substring(content.indexOf('(') + 1, content.lastIndexOf(')')); // r,g,b
            String[] parts = content.split(",");
            return new Color(Integer.parseInt(parts[0].trim()),
                    Integer.parseInt(parts[1].trim()),
                    Integer.parseInt(parts[2].trim()));
        } else if (s.startsWith("color(")) {
            // Format: color(Blue)
            String colorName = s.substring(s.indexOf('(') + 1, s.lastIndexOf(')'));
            try {
                // Reflection to get color by name
                java.lang.reflect.Field field = Color.class.getField(colorName);
                return (Color) field.get(null);
            } catch (Exception e) {
                return Color.BLACK;
            }
        }
        return Color.BLACK;
    }
}