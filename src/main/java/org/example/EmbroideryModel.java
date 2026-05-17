package org.example;
import java.awt.Color;

public class EmbroideryModel {
    private final int rows = 40;
    private final int cols = 40;
    private final int cellSize = 16;
    private final Color[][] grid;

    private Color currentColor = Color.RED;
    private final Color backgroundColor = new Color(245, 245, 230);

    private boolean symHorizontal = false;
    private boolean symVertical = false;

    public EmbroideryModel() {
        grid = new Color[rows][cols];
        generateNamePattern();
    }

    public void addStitch(int r, int c) {
        if (r >= 0 && r < rows && c >= 0 && c < cols) {
            grid[r][c] = currentColor;
            if (symHorizontal) grid[r][cols - 1 - c] = currentColor;
            if (symVertical) grid[rows - 1 - r][c] = currentColor;
            if (symHorizontal && symVertical) grid[rows - 1 - r][cols - 1 - c] = currentColor;
        }
    }

    public void setCellColorDirectly(int r, int c, Color color) {
        if (r >= 0 && r < rows && c >= 0 && c < cols) {
            grid[r][c] = color;
        }
    }

    private void generateNamePattern() {
        int midC = cols / 2;
        for (int r = 10; r < 30; r++) {
            grid[r][midC] = new Color(180, 0, 0);
            if (r % 4 == 0) {
                grid[r][midC - 1] = Color.BLACK;
                grid[r][midC + 1] = Color.BLACK;
            }
        }
    }

    public void clearGrid() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = null;
            }
        }
    }

    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }
    public int getCellSize() {
        return cellSize;
    }
    public Color[][] getGrid() {
        return grid;
    }
    public Color getCurrentColor() {
        return currentColor;
    }
    public void setCurrentColor(Color c) {
        this.currentColor = c;
    }
    public Color getBackgroundColor() {
        return backgroundColor;
    }
    public void setSymHorizontal(boolean sym) {
        this.symHorizontal = sym;
    }
    public void setSymVertical(boolean sym) {
        this.symVertical = sym;
    }
}