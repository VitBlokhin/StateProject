package org.itstep.pps2701.blokhin;

import org.itstep.pps2701.blokhin.grantstate.GrantState;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Vit on 17.05.2017.
 */
public class MainFrame extends JFrame {
    private GrantApplication grantApp;

    private JScrollPane listScroller;
    private JPanel controlPanel;

    private JList<Grant> lstGrants;
    private JButton editBtn;
    private JButton addBtn;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        grantApp = new GrantApplication();

        buildGUI();
    }

    private void buildGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setLocationRelativeTo(null);
        setResizable(false);

        controlPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,5,5));

        editBtn = new JButton("Редактировать");
        addBtn = new JButton("Добавить");

        lstGrants = new JList(grantApp.getGrantList().toArray());
        lstGrants.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstGrants.setLayoutOrientation(JList.VERTICAL);
        lstGrants.setVisibleRowCount(-1);

        lstGrants.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {
                    if (lstGrants.getSelectedIndex() == -1) {
                        editBtn.setEnabled(false);
                    } else {
                        editBtn.setEnabled(true);
                    }
                }
            }
        });

        listScroller = new JScrollPane(lstGrants, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        editBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Grant selectedGrant = lstGrants.getSelectedValue();
                    if(selectedGrant == null) throw new NullPointerException("Не выделен элемент для редактирования");

                    Object[] availableStates = selectedGrant.getCurrentGrantState().getAvailableStates().toArray();
                    Object selectedState = JOptionPane.showInputDialog(null,
                            "Выберите состояние заказа для " + selectedGrant.getGrantName(),
                            "Изменение состояния заказа", JOptionPane.INFORMATION_MESSAGE, null,
                            availableStates, availableStates[0]);
                    if(selectedState != null) {
                        selectedGrant.setCurrentGrantState((GrantState)selectedState);

                        lstGrants = new JList(grantApp.getGrantList().toArray());
                        lstGrants.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        lstGrants.setLayoutOrientation(JList.VERTICAL);
                        lstGrants.setVisibleRowCount(-1);

                        getContentPane().remove(listScroller);
                        listScroller = new JScrollPane(lstGrants, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

                        getContentPane().add(listScroller);

                        getContentPane().revalidate();
                        getContentPane().repaint();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addBtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String newGrantName = JOptionPane.showInputDialog("Введите имя:");
                    if(newGrantName != null) {
                        grantApp.addGrant(newGrantName);

                        lstGrants = new JList(grantApp.getGrantList().toArray());
                        lstGrants.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        lstGrants.setLayoutOrientation(JList.VERTICAL);
                        lstGrants.setVisibleRowCount(-1);

                        getContentPane().remove(listScroller);
                        listScroller = new JScrollPane(lstGrants, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

                        getContentPane().add(listScroller);

                        getContentPane().revalidate();
                        getContentPane().repaint();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        controlPanel.add(editBtn);
        controlPanel.add(addBtn);

        getContentPane().add(listScroller);
        getContentPane().add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

} // class MainFrame
