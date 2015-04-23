package chat.practice.util;

import chat.practice.model.Message;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public final class MessageUtil {
	private static final String TN = "TN";
	private static final String EN = "EN";
	private static final String ID = "id";
	private static final String AUTHOR = "author";
	private static final String TEXT = "text";

	public static String getToken(int index) {
		Integer number = index * 8 + 11;
		return TN + number + EN;
	}

	public static int getIndex(String token) {
		return (Integer.valueOf(token.substring(2, token.length() - 2)) - 11) / 8;
	}

	public static JSONObject stringToJson(String data) throws ParseException {
		JSONParser parser = new JSONParser();
		return (JSONObject) parser.parse(data.trim());
	}

	public static Message jsonToMessage(JSONObject json) {
		Object id = json.get(ID);
		Object author = json.get(AUTHOR);
		Object text = json.get(TEXT);
		return new Message(id.toString(), author.toString(), text.toString());
	}
}
