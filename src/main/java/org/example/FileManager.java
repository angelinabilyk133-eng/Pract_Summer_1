package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FileManager {

    public static void saveToPNG(Component parent, EmbroideryModel model, CanvasPanel canvas) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (!file.getName().toLowerCase().endsWith(".png")) {
                file = new File(file.getAbsolutePath() + ".png");
            }

            BufferedImage img = new BufferedImage(
                    model.getCols() * model.getCellSize(),
                    model.getRows() * model.getCellSize(),
                    BufferedImage.TYPE_INT_ARGB
            );
            Graphics2D g2d = img.createGraphics();
            canvas.paintComponent(g2d);
            g2d.dispose();

            try {
                ImageIO.write(img, "png", file);
                JOptionPane.showMessageDialog(parent, "Збережено!", "Успіх", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(parent, "Помилка: " + ex.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void loadFromPNG(Component parent, EmbroideryModel model, CanvasPanel canvas) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage img = ImageIO.read(fileChooser.getSelectedFile());
                int cellW = img.getWidth() / model.getCols();
                int cellH = img.getHeight() / model.getRows();

                for (int r = 0; r < model.getRows(); r++) {
                    for (int c = 0; c < model.getCols(); c++) {
                        int centerX = c * cellW + (cellW / 2);
                        int centerY = r * cellH + (cellH / 2);

                        if (centerX < img.getWidth() && centerY < img.getHeight()) {
                            Color color = new Color(img.getRGB(centerX, centerY), true);
                            if (isBackground(color, model.getBackgroundColor())) {
                                model.setCellColorDirectly(r, c, null);
                            } else {
                                model.setCellColorDirectly(r, c, color);
                            }
                        }
                    }
                }
                canvas.repaint();
                JOptionPane.showMessageDialog(parent, "Вишиванку завантажено!", "Успіх", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(parent, "Помилка: " + ex.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static boolean isBackground(Color c, Color bg) {
        return Math.abs(c.getRed() - bg.getRed()) < 20 &&
                Math.abs(c.getGreen() - bg.getGreen()) < 20 &&
                Math.abs(c.getBlue() - bg.getBlue()) < 20;
    }
}
