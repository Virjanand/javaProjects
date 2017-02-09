package web.browsersession;

public enum Browser {

	FIREFOX,
	CHROME;

	private Browser() {}

	public static Browser get(String browser) {
		for (final Browser b : Browser.values()) {
			if (b.equals(browser)) {
				return b;
			}
		}
		return null;
	}

	private boolean equals(String browser) {
		return name().equalsIgnoreCase(browser);
	}

}
