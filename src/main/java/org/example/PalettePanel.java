package org.example;
import javax.swing.*;
import java.awt.*;

public class PalettePanel extends JPanel {
    private final EmbroideryModel model;
    private final JPanel colorPreview;

    public PalettePanel(EmbroideryModel model) {
        this.model = model;
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Палітра кольорів"));

        Color topPanelColor = new Color(235, 225, 205);
        setBackground(topPanelColor);

        colorPreview = new JPanel();
        colorPreview.setPreferredSize(new Dimension(25, 25));
        colorPreview.setBackground(model.getCurrentColor());
        colorPreview.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel previewContainer = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        previewContainer.setBackground(topPanelColor);
        previewContainer.add(new JLabel("Поточний колір: "));
        previewContainer.add(colorPreview);
        add(previewContainer, BorderLayout.EAST);

        JPanel gridColors = new JPanel(new GridLayout(2, 11, 4, 4));
        gridColors.setBackground(topPanelColor);

        Color[] colors = {
                new Color(180, 0, 0), new Color(220, 20, 60), new Color(255, 69, 0), new Color(139, 0, 0), new Color(255, 105, 180),
                Color.BLACK, new Color(40, 40, 40), new Color(90, 90, 90), new Color(139, 69, 19), new Color(160, 160, 160),
                new Color(0, 0, 139), new Color(0, 0, 255), new Color(30, 144, 255), new Color(135, 206, 250),
                new Color(0, 100, 0), new Color(34, 139, 34), new Color(50, 205, 50), new Color(107, 142, 35),
                new Color(218, 165, 32), new Color(255, 215, 0), new Color(255, 140, 0),
                model.getBackgroundColor(), null
        };

        for (Color c : colors) {
            JButton colorBtn = new JButton();
            colorBtn.setPreferredSize(new Dimension(28, 28));
            if (c == model.getBackgroundColor()) {
                colorBtn.setText("🧽");
                colorBtn.setBackground(Color.WHITE);
                colorBtn.addActionListener(e -> updateColor(null));
            } else if (c == null) {
                colorBtn.setText("🎨");
                colorBtn.setBackground(Color.LIGHT_GRAY);
                colorBtn.addActionListener(e -> {
                    Color chosen = JColorChooser.showDialog(this, "Оберіть колір", model.getCurrentColor());
                    if (chosen != null) updateColor(chosen);
                });
            } else {
                colorBtn.setBackground(c);
                colorBtn.setContentAreaFilled(false);
                colorBtn.setOpaque(true);
                colorBtn.addActionListener(e -> updateColor(c));
            }
            gridColors.add(colorBtn);
        }
        add(gridColors, BorderLayout.CENTER);
    }

    private void updateColor(Color c) {
        model.setCurrentColor(c);
        colorPreview.setBackground(c == null ? model.getBackgroundColor() : c);
    }
}
