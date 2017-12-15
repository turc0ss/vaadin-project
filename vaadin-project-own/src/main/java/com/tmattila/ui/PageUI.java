package com.tmattila.ui;

import java.util.ArrayList;
import java.util.List;

import com.tmattila.model.ChaCreation;
import com.tmattila.utils.StringUtils;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI(path = PageUI.PATH)
@Theme(PageUI.THEME)
@Title(PageUI.TITLE_TEXT)
public class PageUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String PATH = "/ui";
	
	public static final String TITLE_TEXT = "Character Creation Page";
	
	public static final String THEME = "valo";
	
	private HorizontalLayout rootLayout;

	private Label headerLabel;

	private TextField nameField;

	private TextField typeField;

	private TextField wealthField;

	private Label headerInformation;

	private ComboBox<String> sexCombo;
	
	@Override
	protected void init(VaadinRequest request) {

		rootLayout = new HorizontalLayout();
		rootLayout.setMargin(true);
		rootLayout.setSizeFull();
		setContent(rootLayout);

		Panel panel = new Panel("");
		panel.setSizeFull();

		Panel panel2 = new Panel("");
		panel2.setSizeFull();

		rootLayout.addComponent(panel);
		rootLayout.addComponent(panel2);

		/*
		 * Panel 1
		 */

		FormLayout characterLayout = new FormLayout();
		characterLayout.setSizeUndefined();
		characterLayout.setMargin(true);

		headerLabel = new Label("<h2><b>" + StringUtils.HEADER_TEXT.getString() + "</b></h2>", ContentMode.HTML);
		characterLayout.addComponent(headerLabel);

		nameField = new TextField("Name: ");
		characterLayout.addComponent(nameField);

		List<String> sexSelection = new ArrayList<>();
		sexSelection.add("Male");
		sexSelection.add("Female");

		sexCombo = new ComboBox<String>("Sex: ");
		sexCombo.setItems(sexSelection);
		characterLayout.addComponent(sexCombo);

		typeField = new TextField("Type: ");
		characterLayout.addComponent(typeField);

		wealthField = new TextField("Wealth: ");
		characterLayout.addComponent(wealthField);

		Button saveButton = new Button("Save");
		saveButton.setWidth("160px");
		saveButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
		characterLayout.addComponent(saveButton);

		saveButton.addClickListener(e -> {

			dataSaved();
		});

		/*
		 * Panel 2
		 */

		FormLayout informationLayout = new FormLayout();
		informationLayout.setSizeUndefined();
		informationLayout.setMargin(true);

		headerInformation = new Label("<h2><b>" + StringUtils.INFORMATION_HEADER.getString() + "</b></h2>",
				ContentMode.HTML);
		informationLayout.addComponent(headerInformation);

		rootLayout.setComponentAlignment(panel, Alignment.MIDDLE_LEFT);
		panel.setContent(characterLayout);

		rootLayout.setComponentAlignment(panel2, Alignment.MIDDLE_RIGHT);
		panel2.setContent(informationLayout);
		
	}

	public void dataSaved() {

		boolean notClicked = true;
		ChaCreation p = new ChaCreation();
		
		int wealth = 0;
		if(wealthField.getValue() == "") {
			System.out.println("wealth is empty");
		} else {
			wealth = Integer.parseInt(wealthField.getValue());
		}
		
		while (notClicked) {

			p.setName(nameField.getValue());
			p.setSex(sexCombo.getValue());
			p.setType(typeField.getValue());
			p.setWealth(wealth);

			System.out.println(p.toString());

			notClicked = false;
		}

		nameField.clear();
		sexCombo.clear();
		typeField.clear();
		wealthField.clear();
	}
}
