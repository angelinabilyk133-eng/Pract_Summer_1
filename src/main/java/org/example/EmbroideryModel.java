package org.example;
import java.awt.Color;

public class EmbroideryModel {
    private final int rows = 40;
    private final int cols = 40;
    private final int cellSize = 16;
    private final Color[][] grid;

    private Color currentColor = Color.BLACK;
    private final Color backgroundColor = new Color(253, 245, 230);

    public static final Color PATTERN_RED   = new Color(215, 25, 45);
    public static final Color PATTERN_BLACK = Color.BLACK;

    private boolean symHorizontal = false;
    private boolean symVertical   = false;

    public EmbroideryModel() {
        grid = new Color[rows][cols];
        generateNamePattern();
    }

    public void addStitch(int r, int c) {
        if (r >= 0 && r < rows && c >= 0 && c < cols) {
            grid[r][c] = currentColor;
            if (symHorizontal) grid[r][cols - 1 - c] = currentColor;
            if (symVertical)   grid[rows - 1 - r][c] = currentColor;
            if (symHorizontal && symVertical) grid[rows - 1 - r][cols - 1 - c] = currentColor;
        }
    }

    public void setCellColorDirectly(int r, int c, Color color) {
        if (r >= 0 && r < rows && c >= 0 && c < cols) grid[r][c] = color;
    }

    public void clearGrid() {
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = null;
    }

    private void put4(int r, int c, Color color) {
        set(r,          c,          color);
        set(r,          39 - c,     color);
        set(39 - r,     c,          color);
        set(39 - r,     39 - c,     color);
    }

    private void put8(int r, int c, Color color) {
        put4(r, c, color);
        put4(c, r, color);
    }

    private void set(int r, int c, Color color) {
        if (r >= 0 && r < rows && c >= 0 && c < cols) grid[r][c] = color;
    }

    private void generateNamePattern() {
        Color R = PATTERN_RED;
        Color B = PATTERN_BLACK;

        set(4, 19, B);
        set(5, 18, B);
        set(5, 19, B);
        set(5, 20, B);
        set(6, 17, B);
        set(6, 19, B);
        set(6, 21, B);
        set(8, 19, B);
        set(9, 19, B);
        set(10, 12, R);
        set(10, 13, R);
        set(10, 19, B);
        set(10, 25, R);
        set(10, 26, R);
        set(11, 13, R);
        set(11, 14, R);
        set(11, 17, B);
        set(11, 19, B);
        set(11, 21, B);
        set(11, 24, R);
        set(11, 25, R);
        set(12, 10, R);
        set(12, 12, R);
        set(12, 14, R);
        set(12, 17, B);
        set(12, 18, B);
        set(12, 19, B);
        set(12, 20, B);
        set(12, 21, B);
        set(12, 24, R);
        set(12, 26, R);
        set(12, 28, R);
        set(13, 10, R);
        set(13, 11, R);
        set(13, 13, R);
        set(13, 14, R);
        set(13, 15, R);
        set(13, 18, B);
        set(13, 20, B);
        set(13, 23, R);
        set(13, 24, R);
        set(13, 25, R);
        set(13, 27, R);
        set(13, 28, R);
        set(14, 11, R);
        set(14, 12, R);
        set(14, 13, R);
        set(14, 14, R);
        set(14, 16, R);
        set(14, 18, B);
        set(14, 19, B);
        set(14, 20, B);
        set(14, 22, R);
        set(14, 24, R);
        set(14, 25, R);
        set(14, 26, R);
        set(14, 27, R);
        set(15, 13, R);
        set(15, 15, R);
        set(15, 16, R);
        set(15, 17, R);
        set(15, 18, B);
        set(15, 19, R);
        set(15, 20, B);
        set(15, 21, R);
        set(15, 22, R);
        set(15, 23, R);
        set(15, 25, R);
        set(16, 14, R);
        set(16, 15, R);
        set(16, 16, R);
        set(16, 18, R);
        set(16, 19, R);
        set(16, 20, R);
        set(16, 22, R);
        set(16, 23, R);
        set(16, 24, R);
        set(17, 6, B);
        set(17, 11, B);
        set(17, 12, B);
        set(17, 15, R);
        set(17, 17, R);
        set(17, 21, R);
        set(17, 23, R);
        set(17, 26, B);
        set(17, 27, B);
        set(17, 32, B);
        set(18, 5, B);
        set(18, 12, B);
        set(18, 13, B);
        set(18, 14, B);
        set(18, 15, B);
        set(18, 16, R);
        set(18, 22, R);
        set(18, 23, B);
        set(18, 24, B);
        set(18, 25, B);
        set(18, 26, B);
        set(18, 33, B);
        set(19, 4, B);
        set(19, 5, B);
        set(19, 6, B);
        set(19, 8, B);
        set(19, 9, B);
        set(19, 10, B);
        set(19, 11, B);
        set(19, 12, B);
        set(19, 14, B);
        set(19, 15, R);
        set(19, 16, R);
        set(19, 22, R);
        set(19, 23, R);
        set(19, 24, B);
        set(19, 26, B);
        set(19, 27, B);
        set(19, 28, B);
        set(19, 29, B);
        set(19, 30, B);
        set(19, 32, B);
        set(19, 33, B);
        set(19, 34, B);
        set(20, 5, B);
        set(20, 12, B);
        set(20, 13, B);
        set(20, 14, B);
        set(20, 15, B);
        set(20, 16, R);
        set(20, 22, R);
        set(20, 23, B);
        set(20, 24, B);
        set(20, 25, B);
        set(20, 26, B);
        set(20, 33, B);
        set(21, 6, B);
        set(21, 11, B);
        set(21, 12, B);
        set(21, 15, R);
        set(21, 17, R);
        set(21, 21, R);
        set(21, 23, R);
        set(21, 26, B);
        set(21, 27, B);
        set(21, 32, B);
        set(22, 14, R);
        set(22, 15, R);
        set(22, 16, R);
        set(22, 18, R);
        set(22, 19, R);
        set(22, 20, R);
        set(22, 22, R);
        set(22, 23, R);
        set(22, 24, R);
        set(23, 13, R);
        set(23, 15, R);
        set(23, 16, R);
        set(23, 17, R);
        set(23, 18, B);
        set(23, 19, R);
        set(23, 20, B);
        set(23, 21, R);
        set(23, 22, R);
        set(23, 23, R);
        set(23, 25, R);
        set(24, 11, R);
        set(24, 12, R);
        set(24, 13, R);
        set(24, 14, R);
        set(24, 16, R);
        set(24, 18, B);
        set(24, 19, B);
        set(24, 20, B);
        set(24, 22, R);
        set(24, 24, R);
        set(24, 25, R);
        set(24, 26, R);
        set(24, 27, R);
        set(25, 10, R);
        set(25, 11, R);
        set(25, 13, R);
        set(25, 14, R);
        set(25, 15, R);
        set(25, 18, B);
        set(25, 20, B);
        set(25, 23, R);
        set(25, 24, R);
        set(25, 25, R);
        set(25, 27, R);
        set(25, 28, R);
        set(26, 10, R);
        set(26, 12, R);
        set(26, 14, R);
        set(26, 17, B);
        set(26, 18, B);
        set(26, 19, B);
        set(26, 20, B);
        set(26, 21, B);
        set(26, 24, R);
        set(26, 26, R);
        set(26, 28, R);
        set(27, 13, R);
        set(27, 14, R);
        set(27, 17, B);
        set(27, 19, B);
        set(27, 21, B);
        set(27, 24, R);
        set(27, 25, R);
        set(28, 12, R);
        set(28, 13, R);
        set(28, 19, B);
        set(28, 25, R);
        set(28, 26, R);
        set(29, 19, B);
        set(30, 19, B);
        set(32, 17, B);
        set(32, 19, B);
        set(32, 21, B);
        set(33, 18, B);
        set(33, 19, B);
        set(33, 20, B);
        set(34, 19, B);
    }

    public int getRows()              { return rows; }
    public int getCols()              { return cols; }
    public int getCellSize()          { return cellSize; }
    public Color[][] getGrid()        { return grid; }
    public Color getCurrentColor()    { return currentColor; }
    public void setCurrentColor(Color c) { this.currentColor = c; }
    public Color getBackgroundColor() { return backgroundColor; }
    public void setSymHorizontal(boolean sym) { this.symHorizontal = sym; }
    public void setSymVertical(boolean sym)   { this.symVertical   = sym; }
}