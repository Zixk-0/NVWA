
package avanue.nvwa;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class externalstorage {
    public static RemoteObject myClass;
	public externalstorage() {
	}
    public static PCBA staticBA = new PCBA(null, externalstorage.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _ion = RemoteObject.declareNull("Object");
public static RemoteObject _persistanturi = RemoteObject.createImmutable("");
public static RemoteObject _previousurifilename = RemoteObject.createImmutable("");
public static RemoteObject _ctxt = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _mcallback = RemoteObject.declareNull("Object");
public static RemoteObject _meventname = RemoteObject.createImmutable("");
public static RemoteObject _root = RemoteObject.declareNull("avanue.nvwa.externalstorage._externalfile");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static avanue.nvwa.main _main = null;
public static avanue.nvwa.starter _starter = null;
public static avanue.nvwa.xuiviewsutils _xuiviewsutils = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"ctxt",_ref.getField(false, "_ctxt"),"DateUtils",_ref.getField(false, "_dateutils"),"ion",_ref.getField(false, "_ion"),"mCallback",_ref.getField(false, "_mcallback"),"mEventName",_ref.getField(false, "_meventname"),"PersistantUri",_ref.getField(false, "_persistanturi"),"PreviousUriFileName",_ref.getField(false, "_previousurifilename"),"Root",_ref.getField(false, "_root")};
}
}