package cz.czechitas.ukol7.controller;

import com.jgoodies.binding.PresentationModel;
import cz.czechitas.ukol7.formbuilder.ActionBuilder;
import cz.czechitas.ukol7.model.PreferenceBean;

import javax.swing.*;


public class PreferenceController {
    private final PresentationModel<PreferenceBean> model;
    private final Action ulozitAction;

    public PreferenceController(PresentationModel<PreferenceBean> model, Action ulozitAction) {
        this.model = model;
        this.ulozitAction = ulozitAction;
    }

    public PreferenceController() {
        model = new PresentationModel<PreferenceBean>();
        ulozitAction = ActionBuilder.create("Uložit", this::handleUlozit);
        model.addBeanPropertyChangeListener(this::);

    }

    public PresentationModel<PreferenceBean> getModel() {
        return model;
    }

    public Action getUlozitAction() {
        return ulozitAction;
    }

    private void vypoctiStavAkci() {

        if (model.getBean().getPrezdivka() != null && model.getBean().getOblibenaBarva() != null) {
            ulozitAction.setEnabled(true);
        } else {
            ulozitAction.setEnabled(false);
        }
    }

    public void handleUlozit() {
        PreferenceBean bean = this.model.getBean();
        System.out.println("Prezdivka uživatele:" + bean.getPrezdivka());
        System.out.println("Oblíbená barva:" + bean.getOblibenaBarva());
    }
}

