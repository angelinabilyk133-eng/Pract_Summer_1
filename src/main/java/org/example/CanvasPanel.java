package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CanvasPanel extends JPanel {
    private final EmbroideryModel model;

    public CanvasPanel(EmbroideryModel model) {
        this.model = model;
        setPreferredSize(new Dimension(model.getCols() * model.getCellSize(), model.getRows() * model.getCellSize()));
        setBackground(model.getBackgroundColor());

        MouseAdapter mouseController = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { processDraw(e); }
            @Override
            public void mouseDragged(MouseEvent e) { processDraw(e); }
        };
        addMouseListener(mouseController);
        addMouseMotionListener(mouseController);
    }

    private void processDraw(MouseEvent e) {
        int c = e.getX() / model.getCellSize();
        int r = e.getY() / model.getCellSize();
        model.addStitch(r, c);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int rows = model.getRows();
        int cols = model.getCols();
        int cellSize = model.getCellSize();
        Color[][] grid = model.getGrid();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] != null) {
                    g.setColor(grid[r][c]);
                    g.fillRect(c * cellSize, r * cellSize, cellSize, cellSize);
                }
            }
        }

        g.setColor(new Color(215, 215, 195));
        for (int i = 0; i <= rows; i++) {
            g.drawLine(0, i * cellSize, cols * cellSize, i * cellSize);
        }
        for (int i = 0; i <= cols; i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, rows * cellSize);
        }
    }
}
