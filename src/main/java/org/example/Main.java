package org.example;

import org.example.note.Note;
import org.example.note.NoteManager;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        // =====================================================
        // WINDOWS CLASSIC LOOK
        // =====================================================

        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        // =====================================================
        // NOTE MANAGER
        // =====================================================

        NoteManager noteManager = new NoteManager();

        // =====================================================
        // FRAME
        // =====================================================

        JFrame frame = new JFrame(
                "RetroNotes 2003 Professional Edition"
        );

        frame.setSize(950, 700);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLayout(new BorderLayout());

        frame.setResizable(false);

        frame.getContentPane().setBackground(
                new Color(192,192,192)
        );

        // =====================================================
        // FONTS
        // =====================================================

        Font uiFont =
                new Font("Tahoma", Font.PLAIN, 11);

        Font titleFont =
                new Font("Arial", Font.BOLD, 28);

        Font consoleFont =
                new Font("Courier New", Font.PLAIN, 12);

        // =====================================================
        // HEADER PANEL
        // =====================================================

        JPanel headerPanel = new JPanel(
                new BorderLayout()
        );

        headerPanel.setBackground(
                new Color(0,0,128)
        );

        headerPanel.setBorder(
                BorderFactory.createBevelBorder(
                        BevelBorder.RAISED
                )
        );

        JLabel title =
                new JLabel(
                        " RETRONOTES 2003"
                );

        title.setForeground(Color.WHITE);

        title.setFont(titleFont);

        JLabel build =
                new JLabel(
                        "Build 1.0.3"
                );

        build.setForeground(Color.WHITE);

        build.setFont(uiFont);

        build.setBorder(
                BorderFactory.createEmptyBorder(
                        0,0,0,10
                )
        );

        headerPanel.add(title, BorderLayout.WEST);

        headerPanel.add(build, BorderLayout.EAST);

        // =====================================================
        // MENU BAR
        // =====================================================

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu toolsMenu = new JMenu("Tools");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(toolsMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);

        // =====================================================
        // TOOLBAR
        // =====================================================

        JToolBar toolBar = new JToolBar();

        toolBar.setFloatable(false);

        JButton addButton =
                new JButton("NEW");

        JButton deleteButton =
                new JButton("DELETE");

        JButton saveButton =
                new JButton("SAVE");

        JButton infoButton =
                new JButton("INFO");

        Dimension buttonSize =
                new Dimension(90,25);

        addButton.setPreferredSize(buttonSize);

        deleteButton.setPreferredSize(buttonSize);

        saveButton.setPreferredSize(buttonSize);

        infoButton.setPreferredSize(buttonSize);

        toolBar.add(addButton);

        toolBar.add(deleteButton);

        toolBar.add(saveButton);

        toolBar.addSeparator();

        toolBar.add(infoButton);

        toolBar.setBorder(
                BorderFactory.createBevelBorder(
                        BevelBorder.RAISED
                )
        );

        // =====================================================
        // NOTE LIST
        // =====================================================

        DefaultListModel<String> listModel =
                new DefaultListModel<>();

        JList<String> noteList =
                new JList<>(listModel);

        noteList.setFont(uiFont);

        noteList.setBackground(
                new Color(245,245,245)
        );

        JScrollPane listScrollPane =
                new JScrollPane(noteList);

        listScrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(),
                        "Stored Notes"
                )
        );

        // =====================================================
        // TITLE FIELD
        // =====================================================

        JTextField titleField =
                new JTextField();

        titleField.setFont(uiFont);

        titleField.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(),
                        "Title"
                )
        );

        // =====================================================
        // TEXT AREA
        // =====================================================

        JTextArea textArea =
                new JTextArea();

        textArea.setFont(consoleFont);

        textArea.setBackground(
                new Color(250,250,250)
        );

        textArea.setCaretColor(Color.BLACK);

        JScrollPane textScrollPane =
                new JScrollPane(textArea);

        textScrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(),
                        "Content Viewer"
                )
        );

        // =====================================================
        // CONTENT PANEL
        // =====================================================

        JPanel contentPanel =
                new JPanel(new BorderLayout());

        contentPanel.add(
                titleField,
                BorderLayout.NORTH
        );

        contentPanel.add(
                textScrollPane,
                BorderLayout.CENTER
        );

        // =====================================================
        // SPLIT PANE
        // =====================================================

        JSplitPane splitPane =
                new JSplitPane(
                        JSplitPane.HORIZONTAL_SPLIT,
                        listScrollPane,
                        contentPanel
                );

        splitPane.setDividerLocation(250);

        splitPane.setBorder(
                BorderFactory.createLoweredBevelBorder()
        );

        // =====================================================
        // LOG PANEL
        // =====================================================

        JTextArea logArea =
                new JTextArea();

        logArea.setEditable(false);

        logArea.setFont(consoleFont);

        logArea.setBackground(Color.BLACK);

        logArea.setForeground(
                new Color(0,255,0)
        );

        logArea.append(
                "[INFO] RetroNotes initialized...\n"
        );

        logArea.append(
                "[INFO] Ready.\n"
        );

        JScrollPane logScroll =
                new JScrollPane(logArea);

        logScroll.setPreferredSize(
                new Dimension(100,120)
        );

        logScroll.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(),
                        "System Log"
                )
        );

        // =====================================================
        // STATUS BAR
        // =====================================================

        JLabel statusBar =
                new JLabel(
                        " READY"
                );

        statusBar.setBorder(
                BorderFactory.createLoweredBevelBorder()
        );

        // =====================================================
        // CENTER PANEL
        // =====================================================

        JPanel centerPanel =
                new JPanel(new BorderLayout());

        centerPanel.add(
                splitPane,
                BorderLayout.CENTER
        );

        centerPanel.add(
                logScroll,
                BorderLayout.SOUTH
        );

        // =====================================================
        // MAIN PANEL
        // =====================================================

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        mainPanel.add(
                centerPanel,
                BorderLayout.CENTER
        );

        // =====================================================
        // ADD COMPONENTS
        // =====================================================

        frame.add(
                toolBar,
                BorderLayout.NORTH
        );

        frame.add(
                mainPanel,
                BorderLayout.CENTER
        );

        frame.add(
                statusBar,
                BorderLayout.SOUTH
        );

        // =====================================================
        // BUTTON LOGIC
        // =====================================================

        addButton.addActionListener(e -> {

            String titleText =
                    titleField.getText();

            String contentText =
                    textArea.getText();

            if(titleText.isEmpty()
                    || contentText.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Title or content missing.",
                        "RetroNotes 2003",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            Note note =
                    new Note(
                            titleText,
                            contentText
                    );

            noteManager.addNote(note);

            listModel.addElement(titleText);

            logArea.append(
                    "[ADD] "
                            + titleText
                            + "\n"
            );

            statusBar.setText(
                    " Added note: "
                            + titleText
            );

            titleField.setText("");

            textArea.setText("");
        });

        deleteButton.addActionListener(e -> {

            int selected =
                    noteList.getSelectedIndex();

            if(selected != -1) {

                String deleted =
                        listModel.get(selected);

                listModel.remove(selected);

                noteManager.removeNote(selected);

                logArea.append(
                        "[DELETE] "
                                + deleted
                                + "\n"
                );

                statusBar.setText(
                        " Deleted note: "
                                + deleted
                );

                titleField.setText("");

                textArea.setText("");
            }
        });

        saveButton.addActionListener(e -> {

            int selected =
                    noteList.getSelectedIndex();

            if(selected != -1) {

                Note note =
                        noteManager
                                .getNotes()
                                .get(selected);

                note.title =
                        titleField.getText();

                note.content =
                        textArea.getText();

                listModel.set(
                        selected,
                        note.title
                );

                logArea.append(
                        "[SAVE] Updated note: "
                                + note.title
                                + "\n"
                );

                statusBar.setText(
                        " Saved: "
                                + note.title
                );

                JOptionPane.showMessageDialog(
                        frame,
                        "Note updated successfully.",
                        "RetroNotes 2003",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        infoButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "RetroNotes 2003\nBuild 1.0.3\n\nClassic desktop note manager.",
                    "About",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // =====================================================
        // NOTE SELECTION
        // =====================================================

        noteList.addListSelectionListener(e -> {

            int selected =
                    noteList.getSelectedIndex();

            if(selected != -1) {

                Note note =
                        noteManager
                                .getNotes()
                                .get(selected);

                titleField.setText(
                        note.title
                );

                textArea.setText(
                        note.content
                );

                statusBar.setText(
                        " Viewing: "
                                + note.title
                );

                logArea.append(
                        "[OPEN] "
                                + note.title
                                + "\n"
                );
            }
        });

        // =====================================================
        // STARTUP MESSAGE
        // =====================================================

        JOptionPane.showMessageDialog(
                frame,
                "RetroNotes 2003 initialized successfully.",
                "System",
                JOptionPane.INFORMATION_MESSAGE
        );

        // =====================================================
        // SHOW FRAME
        // =====================================================

        frame.setVisible(true);
    }
}