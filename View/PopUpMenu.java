package View;

import Controller.PopupButtonListener;
import Controller.PopupSliderListener;
import Model.Config;

import javax.swing.*;
import java.awt.*;

public class PopUpMenu {

    private JPopupMenu popup_file, popup_brush, popup_size, popup_clear, popup_symmetry;

    public PopUpMenu() {

        //Initialize Config
        Config config = new Config();

        //Initialize popup menus
        popup_file = new JPopupMenu();
        popup_brush = new JPopupMenu();
        popup_size = new JPopupMenu();
        popup_clear = new JPopupMenu();
        popup_symmetry = new JPopupMenu();

        //------------------------------------ Setup File Popup ---------------------------------------

        //Load icons
        ImageIcon icon_save = new ImageIcon(this.getClass().getResource("/Assets/save.png"));
        ImageIcon icon_load = new ImageIcon(this.getClass().getResource("/Assets/load.png"));
        ImageIcon icon_export = new ImageIcon(this.getClass().getResource("/Assets/export.png"));
        ImageIcon icon_close = new ImageIcon(this.getClass().getResource("/Assets/close.png"));

        //Setup Buttons
        JButton btn_fnew, btn_fsave, btn_fload, btn_fexport,btn_fclose;
        btn_fnew = new JButton("New", icon_load);
        btn_fsave = new JButton("Save",icon_save);
        btn_fload = new JButton("Load",icon_load);
        btn_fexport = new JButton("Export",icon_export);
        btn_fclose = new JButton("Close",icon_close);

        //Button Alignment
        btn_fnew.setHorizontalAlignment(SwingConstants.LEFT);
        btn_fsave.setHorizontalAlignment(SwingConstants.LEFT);
        btn_fload.setHorizontalAlignment(SwingConstants.LEFT);
        btn_fexport.setHorizontalAlignment(SwingConstants.LEFT);
        btn_fclose.setHorizontalAlignment(SwingConstants.LEFT);

        //Button Color
        btn_fnew.setBackground(Color.LIGHT_GRAY);
        btn_fsave.setBackground(Color.LIGHT_GRAY);
        btn_fload.setBackground(Color.LIGHT_GRAY);
        btn_fexport.setBackground(Color.LIGHT_GRAY);
        btn_fclose.setBackground(Color.LIGHT_GRAY);

        //Label
        JLabel label_file = new JLabel("File Option:");
        label_file.setFont(new Font("Serif",Font.BOLD,25));

        //Set Layout
        popup_file.setLayout(new GridLayout(5,1));

        //Add to popup
        //popup_file.add(label_file);
        popup_file.add(btn_fnew);
        popup_file.add(btn_fsave);
        popup_file.add(btn_fload);
        popup_file.add(btn_fexport);
        popup_file.add(btn_fclose);

        //------------------------------------ Setup Brush Popup ---------------------------------------

        //Setup Icons
        ImageIcon icon_brush1 = new ImageIcon(this.getClass().getResource("/Assets/save.png"));
        ImageIcon icon_brush2 = new ImageIcon(this.getClass().getResource("/Assets/load.png"));
        ImageIcon icon_brush3 = new ImageIcon(this.getClass().getResource("/Assets/export.png"));
        ImageIcon icon_brush4 = new ImageIcon(this.getClass().getResource("/Assets/close.png"));

        //Setup buttons
        JButton btn_brush1, btn_brush2, btn_brush3, btn_brush4;
        btn_brush1 = new JButton("1",icon_brush1);
        btn_brush2 = new JButton("2",icon_brush2);
        btn_brush3 = new JButton("3",icon_brush3);
        btn_brush4 = new JButton("4",icon_brush4);

        //Button Properties
        btn_brush1.setVerticalTextPosition(JButton.BOTTOM);
        btn_brush1.setHorizontalTextPosition(JButton.CENTER);
        btn_brush2.setVerticalTextPosition(JButton.BOTTOM);
        btn_brush2.setHorizontalTextPosition(JButton.CENTER);
        btn_brush3.setVerticalTextPosition(JButton.BOTTOM);
        btn_brush3.setHorizontalTextPosition(JButton.CENTER);
        btn_brush4.setVerticalTextPosition(JButton.BOTTOM);
        btn_brush4.setHorizontalTextPosition(JButton.CENTER);

        //Button Color
        btn_brush1.setBackground(Color.LIGHT_GRAY);
        btn_brush2.setBackground(Color.LIGHT_GRAY);
        btn_brush3.setBackground(Color.LIGHT_GRAY);
        btn_brush4.setBackground(Color.LIGHT_GRAY);

        //Set layout
        popup_brush.setLayout(new GridLayout(2,2));
        popup_brush.add(btn_brush1);
        popup_brush.add(btn_brush2);
        popup_brush.add(btn_brush3);
        popup_brush.add(btn_brush4);

        //------------------------------------ Setup Size Popup ---------------------------------------

        //Slider for size input
        JSlider slider_size = new JSlider(JSlider.HORIZONTAL, 1, 50, 5);

        //Label to show current size
        JLabel label_size = new JLabel("Current size : 5");
        label_size.setFont(new Font("Open Sans",Font.PLAIN,20));
        label_size.setHorizontalAlignment(JLabel.CENTER);

        //Button to complete
        JButton btn_size = new JButton("Done");
        btn_size.setBackground(Color.LIGHT_GRAY);

        //Add to popup size
        popup_size.setLayout(new GridLayout(3,1));
        popup_size.add(slider_size);
        popup_size.add(label_size);
        popup_size.add(btn_size);

        //------------------------------------ Setup Symmetry Popup ------------------------------------

        //Set Icons
        ImageIcon icon_hr = new ImageIcon(this.getClass().getResource("/Assets/close.png"));
        ImageIcon icon_vr = new ImageIcon(this.getClass().getResource("/Assets/close.png"));
        ImageIcon icon_cr = new ImageIcon(this.getClass().getResource("/Assets/close.png"));

        //Set Buttons
        JButton btn_hr = new JButton("Horizontal", icon_hr);
        JButton btn_vr = new JButton("Vertical", icon_vr);
        JButton btn_cr = new JButton("Cross", icon_cr);
        JButton btn_close = new JButton("Close",icon_close);

        //Button Properties
        btn_hr.setVerticalTextPosition(JButton.BOTTOM);
        btn_hr.setHorizontalTextPosition(JButton.CENTER);
        btn_vr.setVerticalTextPosition(JButton.BOTTOM);
        btn_vr.setHorizontalTextPosition(JButton.CENTER);
        btn_cr.setVerticalTextPosition(JButton.BOTTOM);
        btn_cr.setHorizontalTextPosition(JButton.CENTER);
        btn_close.setVerticalTextPosition(JButton.BOTTOM);
        btn_close.setHorizontalTextPosition(JButton.CENTER);

        //Button Color
        btn_hr.setBackground(Color.LIGHT_GRAY);
        btn_vr.setBackground(Color.LIGHT_GRAY);
        btn_cr.setBackground(Color.LIGHT_GRAY);
        btn_close.setBackground(Color.LIGHT_GRAY);

        //Add to popup menu
        popup_symmetry.setLayout(new GridLayout(4,1));
        popup_symmetry.add(btn_hr);
        popup_symmetry.add(btn_vr);
        popup_symmetry.add(btn_cr);
        popup_symmetry.add(btn_close);

        //------------------------------------ Setup Popup properties ----------------------------------

        //Set color for popups
        Color popup_color = new Color(238, 250, 250);
        popup_file.setBackground(popup_color);
        popup_brush.setBackground(popup_color);
        popup_symmetry.setBackground(popup_color);

        //Set size for popups
        int width = 300;
        int height = 300;
        popup_size.setPopupSize(width, height);
        popup_clear.setPopupSize(width, height);
        popup_brush.setPopupSize(width, height);
        popup_file.setPopupSize(width, height);
        popup_symmetry.setPopupSize(width,height);

        //Initialize popup location
        int x = config.getPosition().x + 450;
        int y = config.getPosition().y + 300;
        //Set location for popups
        popup_size.setLocation(x, y);
        popup_clear.setLocation(x, y);
        popup_brush.setLocation(x, y);
        popup_file.setLocation(x,y);
        popup_symmetry.setLocation(x,y);

        //Add action listeners for buttons
        btn_size.addActionListener(new PopupButtonListener(this));
        btn_brush1.addActionListener(new PopupButtonListener(this));
        btn_brush2.addActionListener(new PopupButtonListener(this));
        btn_brush3.addActionListener(new PopupButtonListener(this));
        btn_brush4.addActionListener(new PopupButtonListener(this));
        btn_fnew.addActionListener(new PopupButtonListener(this));
        btn_fsave.addActionListener(new PopupButtonListener(this));
        btn_fload.addActionListener(new PopupButtonListener(this));
        btn_fexport.addActionListener(new PopupButtonListener(this));
        btn_fclose.addActionListener(new PopupButtonListener(this));
        btn_hr.addActionListener(new PopupButtonListener(this));
        btn_vr.addActionListener(new PopupButtonListener(this));
        btn_cr.addActionListener(new PopupButtonListener(this));
        btn_close.addActionListener(new PopupButtonListener(this));

        //Add action listeners for sliders and colors
        slider_size.addChangeListener(new PopupSliderListener(slider_size, label_size));
    }

    //Popup appear functions

    public void popup_file_show(boolean b) { popup_file.setVisible(b); }

    public void popup_size_show(boolean b) { popup_size.setVisible(b); }

    public void popup_brush_show(boolean b) { popup_brush.setVisible(b); }

    public void popup_symmetry_show(boolean b) { popup_symmetry.setVisible(b); }


}
