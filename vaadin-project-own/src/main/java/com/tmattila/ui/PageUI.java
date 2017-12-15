package com.tmattila.ui;

import com.tmattila.utils.StringUtils;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

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
	
	private VerticalLayout rootLayout;

	private Label headerLabel;

	@Override
	protected void init(VaadinRequest request) {
		
		rootLayout = new VerticalLayout();
		setContent(rootLayout);
		
		headerLabel = new Label(StringUtils.HEADER_TEXT.getString());
		rootLayout.addComponent(headerLabel);
		
	}
}
