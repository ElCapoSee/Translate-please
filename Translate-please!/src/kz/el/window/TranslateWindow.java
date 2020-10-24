package kz.el.window;

public class TranslateWindow {
	
	private static final String SUCCESS_RESPONSE = "Right";
	private static final String ERROR_RESPONSE = "Not right";
	private static String RESPONSE;
	private static boolean ENG_RUS = true;
	private static boolean RUS_ENG = false;
	private static int SUCCESS;
	private static int ERROR;
	private static int scoreSUCCESS = 0;
	private static int scoreERROR = 0;
	private static int helpNum = 0;
	private static int totalNum = 0;
	private static int right¿ns = 0;

	public static String getSuccessResponse() {
		return SUCCESS_RESPONSE;
	}

	public static String getErrorResponse() {
		return ERROR_RESPONSE;
	}

	public static boolean isENG_RUS() {
		return ENG_RUS;
	}

	public static void setENG_RUS(boolean eNG_RUS) {
		ENG_RUS = eNG_RUS;
	}

	public static boolean isRUS_ENG() {
		return RUS_ENG;
	}

	public static void setRUS_ENG(boolean rUS_ENG) {
		RUS_ENG = rUS_ENG;
	}

	public static int getSUCCESS() {
		return SUCCESS;
	}

	public static void setSUCCESS(int sUCCESS) {
		SUCCESS = sUCCESS;
	}

	public static int getERROR() {
		return ERROR;
	}

	public static void setERROR(int eRROR) {
		ERROR = eRROR;
	}

	public static String getRESPONSE() {
		return RESPONSE;
	}

	public static void setRESPONSE(String rESPONSE) {
		RESPONSE = rESPONSE;
	}

	public static int getScoreSUCCESS() {
		return scoreSUCCESS;
	}

	public static void setScoreSUCCESS(int scoreSUCCESS) {
		TranslateWindow.scoreSUCCESS = scoreSUCCESS + 1;
	}

	public static int getScoreERROR() {
		return scoreERROR;
	}

	public static void setScoreERROR(int scoreERROR) {
		TranslateWindow.scoreERROR = scoreERROR + 1;
	}

	public static int getHelpNum() {
		return helpNum;
	}

	public static void setHelpNum(int helpNum) {
		TranslateWindow.helpNum = helpNum;
	}

	public static int getTotalNum() {
		return totalNum;
	}

	public static void setTotalNum(int totalNum) {
		TranslateWindow.totalNum = totalNum;
	}

	public static int getRight¿ns() {
		return right¿ns;
	}

	public static void setRight¿ns(int right¿ns) {
		TranslateWindow.right¿ns = right¿ns;
	}

}
