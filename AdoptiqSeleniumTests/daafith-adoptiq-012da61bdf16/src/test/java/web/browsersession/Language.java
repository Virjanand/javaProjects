package web.browsersession;

public enum Language {
	NL,
	EN;

	private Language() {}

	public static Language get(String language) {
		for (final Language l : Language.values()) {
			if (l.equals(language)) {
				return l;
			}
		}
		return null;
	}

	private boolean equals(String language) {
		return name().equalsIgnoreCase(language);
	}

	
}
