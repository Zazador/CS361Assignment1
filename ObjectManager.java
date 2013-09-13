import java.util.HashMap;

public class ObjectManager {

	public HashMap<String, SecurityLevel> ObjectManager() {
		return ReferenceMonitor.getObjectManager();
	}

}
