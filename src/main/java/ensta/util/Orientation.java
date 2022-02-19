package ensta.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Orientation {
	SOUTH("s"), NORTH("n"), WEST("w"), EAST("e");
	private String value;
	private static final List<Orientation> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	private int increment;
	
	public String getValue() 
    {
        return this.value;
    }
	
	public String toString()
    {
        return this.value;
    }

	public static Orientation fromString(String value) {
        for (Orientation o : Orientation.values()) {
            if (o.toString().equals(value)) {
                return o;
            }
        }
        return null;
    }
	
	private Orientation(String value) 
    { 
        this.value = value; 
    }

	private Orientation(int increment) {
		this.increment = increment;
	}
	
	public int getIncrement() {
		return increment;
	}

	public static Orientation randomOrientation() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
