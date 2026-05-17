package org.example;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final EmbroideryModel model;
    private final CanvasPanel canvas;

    public MainFrame() {
        setTitle("Піксельна вишивка - Автор: Aнгеліна Білик");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        model = new EmbroideryModel();
        canvas = new CanvasPanel(model);
        PalettePanel palettePanel = new PalettePanel(model);

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton btnSave = new JButton("Зберегти PNG");
        btnSave.addActionListener(e -> FileManager.saveToPNG(this, model, canvas));

        JButton btnLoad = new JButton("Відкрити PNG");
        btnLoad.addActionListener(e -> FileManager.loadFromPNG(this, model, canvas));

        JButton btnClear = new JButton("Очистити полотно");
        btnClear.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Ви впевнені, що хочете очистити все полотно? Всі незбережені зміни будуть втрачені.",
                    "Підтвердження очистки",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {
                model.clearGrid();
                canvas.repaint();
            }
        });

        JCheckBox symHor = new JCheckBox("Горизонтальна симетрія");
        symHor.addActionListener(e -> model.setSymHorizontal(symHor.isSelected()));

        JCheckBox symVer = new JCheckBox("Вертикальна симетрія");
        symVer.addActionListener(e -> model.setSymVertical(symVer.isSelected()));

        controlPanel.add(btnSave);
        controlPanel.add(btnLoad);
        controlPanel.add(btnClear);
        controlPanel.add(new JSeparator(SwingConstants.VERTICAL));
        controlPanel.add(symHor);
        controlPanel.add(symVer);

        topPanel.add(controlPanel, BorderLayout.NORTH);
        topPanel.add(palettePanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(canvas), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }
}
