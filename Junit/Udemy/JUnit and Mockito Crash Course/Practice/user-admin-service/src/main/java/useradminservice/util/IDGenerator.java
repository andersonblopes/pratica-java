package useradminservice.util;

public final class IDGenerator {

	static int id;

	public static final int generateId() {
		return id++;
	}

}
