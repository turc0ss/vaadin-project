package com.tmattila.utils;

public enum StringUtils {

	HEADER_TEXT("Add Character Informations"),
	INFORMATION_HEADER("Informations");;

	private final String string;

	private StringUtils(String string) {
		this.string = string;
	}

	public String getString() {
		return string;
	}

}
