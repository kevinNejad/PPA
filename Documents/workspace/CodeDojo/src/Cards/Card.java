
package Cards;

public class Card implements Comparable<Card>{
	private int value;
	private String type;

	public Card(int value, String type) {
		this.value = value;
		this.type = type;
	}

	public int getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	public String toString() {
		if (value == 14)
			return "[" + type + "  Ace" + "]";
		else if (value == 11)
			return"[" + type + "  Soldier"+ "]";
		else if (value == 12)
			return "[" +type + "  Queen"+ "]";
		else if (value == 13)
			return "[" +type + "  King"+ "]";
		else
			return "[" +type + " " + value+ "]";
	}

	
	public int compareTo(Card o) {
	    int result = type.compareToIgnoreCase(o.type);
	    if(result==0) {
	        return Integer.valueOf(value).compareTo(o.value);
	    }
	    else {
	        return result;
	    }
	}

}
