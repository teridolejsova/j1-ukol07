package cz.czechitas.ukol7.view;

import cz.czechitas.ukol7.Aplikace;
import cz.czechitas.ukol7.Barva;
import cz.czechitas.ukol7.controller.PreferenceController;
import cz.czechitas.ukol7.formbuilder.FormBuilder;
import cz.czechitas.ukol7.formbuilder.FormBuilderWithContainer;
import cz.czechitas.ukol7.model.PreferenceBean;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.EnumMap;

public class HlavniOkno extends JFrame {

    private final PreferenceController controller;


    public HlavniOkno(PreferenceController controller) throws HeadlessException {
        super("Preference");
        this.controller = controller;
        this.init();

    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right, 100]rel[50:75:250,grow,fill]unrel[right, 100]rel[50:75:250,grow,fill]"));
        setMinimumSize(new Dimension(400, 200));

        FormBuilderWithContainer<PreferenceBean> formbuilder = FormBuilder.create(controller.getModel())
                .container(this);
        formbuilder
                .label("Přezdívka")
                .textField("prezdivka")
                .add();


        formbuilder
                .radioButton("Tyrkysová", "oblibenaBarva", Barva.tyrkysova.name())
                .add("left,span");
        formbuilder
                .radioButton("Modrá", "oblibenaBarva", Barva.modra.name())
                .add("left,span");
        formbuilder
                .radioButton("Zelená", "oblibenaBarva", Barva.zelena.name())
                .add("left,span");
        formbuilder
                .radioButton("Žlutá", "oblibenaBarva", Barva.zluta.name())
                .add("left,span");
        formbuilder
                .radioButton("Fialová", "oblibenaBarva", Barva.fialova.name())
                .add("left,span");
        formbuilder
                .radioButton("Růžová", "oblibenaBarva", Barva.ruzova.name())
                .add("left,span");


        formbuilder
                .panel(panel -> {
                    JButton ulozitButton = new JButton(controller.getUlozitAction());

                    getRootPane().setDefaultButton(ulozitButton);

                    panel.add(ulozitButton);
                })
                .add("span");

        pack();
    }
}
