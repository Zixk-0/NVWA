package avanue.nvwa;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class externalstorage_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private ion As Object";
externalstorage._ion = RemoteObject.createNew ("Object");__ref.setField("_ion",externalstorage._ion);
 //BA.debugLineNum = 4;BA.debugLine="Private PersistantUri As String";
externalstorage._persistanturi = RemoteObject.createImmutable("");__ref.setField("_persistanturi",externalstorage._persistanturi);
 //BA.debugLineNum = 5;BA.debugLine="Public PreviousUriFileName As String = \"Persistan";
externalstorage._previousurifilename = BA.ObjectToString("PersistantUri");__ref.setField("_previousurifilename",externalstorage._previousurifilename);
 //BA.debugLineNum = 6;BA.debugLine="Private ctxt As JavaObject";
externalstorage._ctxt = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");__ref.setField("_ctxt",externalstorage._ctxt);
 //BA.debugLineNum = 7;BA.debugLine="Private mCallback As Object";
externalstorage._mcallback = RemoteObject.createNew ("Object");__ref.setField("_mcallback",externalstorage._mcallback);
 //BA.debugLineNum = 8;BA.debugLine="Private mEventName As String";
externalstorage._meventname = RemoteObject.createImmutable("");__ref.setField("_meventname",externalstorage._meventname);
 //BA.debugLineNum = 9;BA.debugLine="Public Root As ExternalFile";
externalstorage._root = RemoteObject.createNew ("avanue.nvwa.externalstorage._externalfile");__ref.setField("_root",externalstorage._root);
 //BA.debugLineNum = 10;BA.debugLine="Type ExternalFile (Name As String, Length As Long";
;
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _createnewdir(RemoteObject __ref,RemoteObject _parent,RemoteObject _name) throws Exception{
try {
		Debug.PushSubsStack("CreateNewDir (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,68);
if (RapidSub.canDelegate("createnewdir")) { return __ref.runUserSub(false, "externalstorage","createnewdir", __ref, _parent, _name);}
Debug.locals.put("Parent", _parent);
Debug.locals.put("Name", _name);
 BA.debugLineNum = 68;BA.debugLine="Public Sub CreateNewDir (Parent As ExternalFile, N";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 69;BA.debugLine="Return DocumentFileToExternalFile(Parent.Native.R";
Debug.JustUpdateDeviceLine();
if (true) return __ref.runClassMethod (avanue.nvwa.externalstorage.class, "_documentfiletoexternalfile" /*RemoteObject*/ ,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _parent.getField(false,"Native" /*RemoteObject*/ ).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("createDirectory")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_name)})))));
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createnewfile(RemoteObject __ref,RemoteObject _parent,RemoteObject _name) throws Exception{
try {
		Debug.PushSubsStack("CreateNewFile (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,63);
if (RapidSub.canDelegate("createnewfile")) { return __ref.runUserSub(false, "externalstorage","createnewfile", __ref, _parent, _name);}
Debug.locals.put("Parent", _parent);
Debug.locals.put("Name", _name);
 BA.debugLineNum = 63;BA.debugLine="Public Sub CreateNewFile (Parent As ExternalFile,";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 64;BA.debugLine="Return DocumentFileToExternalFile(Parent.Native.R";
Debug.JustUpdateDeviceLine();
if (true) return __ref.runClassMethod (avanue.nvwa.externalstorage.class, "_documentfiletoexternalfile" /*RemoteObject*/ ,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _parent.getField(false,"Native" /*RemoteObject*/ ).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("createFile")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {RemoteObject.createImmutable(("")),(_name)})))));
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _deletefile(RemoteObject __ref,RemoteObject _ef) throws Exception{
try {
		Debug.PushSubsStack("DeleteFile (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,73);
if (RapidSub.canDelegate("deletefile")) { return __ref.runUserSub(false, "externalstorage","deletefile", __ref, _ef);}
Debug.locals.put("EF", _ef);
 BA.debugLineNum = 73;BA.debugLine="Public Sub DeleteFile (EF As ExternalFile) As Bool";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 74;BA.debugLine="If EF.IsInitialized = False Then Return False";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",_ef.getField(true,"IsInitialized" /*RemoteObject*/ ),externalstorage.__c.getField(true,"False"))) { 
if (true) return externalstorage.__c.getField(true,"False");};
 BA.debugLineNum = 75;BA.debugLine="Return EF.Native.RunMethod(\"delete\", Null)";
Debug.JustUpdateDeviceLine();
if (true) return BA.ObjectToBoolean(_ef.getField(false,"Native" /*RemoteObject*/ ).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("delete")),(Object)((externalstorage.__c.getField(false,"Null")))));
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _documentfiletoexternalfile(RemoteObject __ref,RemoteObject _documentfile) throws Exception{
try {
		Debug.PushSubsStack("DocumentFileToExternalFile (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,108);
if (RapidSub.canDelegate("documentfiletoexternalfile")) { return __ref.runUserSub(false, "externalstorage","documentfiletoexternalfile", __ref, _documentfile);}
RemoteObject _ef = RemoteObject.declareNull("avanue.nvwa.externalstorage._externalfile");
Debug.locals.put("DocumentFile", _documentfile);
 BA.debugLineNum = 108;BA.debugLine="Private Sub DocumentFileToExternalFile (DocumentFi";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 109;BA.debugLine="Dim ef As ExternalFile";
Debug.JustUpdateDeviceLine();
_ef = RemoteObject.createNew ("avanue.nvwa.externalstorage._externalfile");Debug.locals.put("ef", _ef);
 BA.debugLineNum = 110;BA.debugLine="If DocumentFile.IsInitialized = False Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",_documentfile.runMethod(true,"IsInitialized"),externalstorage.__c.getField(true,"False"))) { 
 BA.debugLineNum = 111;BA.debugLine="Return ef";
Debug.JustUpdateDeviceLine();
if (true) return _ef;
 };
 BA.debugLineNum = 113;BA.debugLine="ef.Initialize";
Debug.JustUpdateDeviceLine();
_ef.runVoidMethod ("Initialize");
 BA.debugLineNum = 114;BA.debugLine="ef.Name = DocumentFile.RunMethod(\"getName\", Null)";
Debug.JustUpdateDeviceLine();
_ef.setField ("Name" /*RemoteObject*/ ,BA.ObjectToString(_documentfile.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getName")),(Object)((externalstorage.__c.getField(false,"Null"))))));
 BA.debugLineNum = 115;BA.debugLine="ef.Length = DocumentFile.RunMethod(\"length\", Null";
Debug.JustUpdateDeviceLine();
_ef.setField ("Length" /*RemoteObject*/ ,BA.numberCast(long.class, _documentfile.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("length")),(Object)((externalstorage.__c.getField(false,"Null"))))));
 BA.debugLineNum = 116;BA.debugLine="ef.IsFolder = DocumentFile.RunMethod(\"isDirectory";
Debug.JustUpdateDeviceLine();
_ef.setField ("IsFolder" /*RemoteObject*/ ,BA.ObjectToBoolean(_documentfile.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("isDirectory")),(Object)((externalstorage.__c.getField(false,"Null"))))));
 BA.debugLineNum = 117;BA.debugLine="ef.Native = DocumentFile";
Debug.JustUpdateDeviceLine();
_ef.setField ("Native" /*RemoteObject*/ ,_documentfile);
 BA.debugLineNum = 118;BA.debugLine="ef.LastModified = DocumentFile.RunMethod(\"lastMod";
Debug.JustUpdateDeviceLine();
_ef.setField ("LastModified" /*RemoteObject*/ ,BA.numberCast(long.class, _documentfile.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("lastModified")),(Object)((externalstorage.__c.getField(false,"Null"))))));
 BA.debugLineNum = 119;BA.debugLine="Return ef";
Debug.JustUpdateDeviceLine();
if (true) return _ef;
 BA.debugLineNum = 120;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _finddirorcreate(RemoteObject __ref,RemoteObject _parent,RemoteObject _name) throws Exception{
try {
		Debug.PushSubsStack("FindDirOrCreate (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,98);
if (RapidSub.canDelegate("finddirorcreate")) { return __ref.runUserSub(false, "externalstorage","finddirorcreate", __ref, _parent, _name);}
RemoteObject _f = RemoteObject.declareNull("avanue.nvwa.externalstorage._externalfile");
Debug.locals.put("Parent", _parent);
Debug.locals.put("Name", _name);
 BA.debugLineNum = 98;BA.debugLine="Public Sub FindDirOrCreate(Parent As ExternalFile,";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 99;BA.debugLine="Dim f As ExternalFile = FindFile(Parent, Name)";
Debug.JustUpdateDeviceLine();
_f = __ref.runClassMethod (avanue.nvwa.externalstorage.class, "_findfile" /*RemoteObject*/ ,(Object)(_parent),(Object)(_name));Debug.locals.put("f", _f);Debug.locals.put("f", _f);
 BA.debugLineNum = 100;BA.debugLine="If f.IsInitialized = False Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",_f.getField(true,"IsInitialized" /*RemoteObject*/ ),externalstorage.__c.getField(true,"False"))) { 
 BA.debugLineNum = 101;BA.debugLine="Return CreateNewDir(Parent, Name)";
Debug.JustUpdateDeviceLine();
if (true) return __ref.runClassMethod (avanue.nvwa.externalstorage.class, "_createnewdir" /*RemoteObject*/ ,(Object)(_parent),(Object)(_name));
 }else {
 BA.debugLineNum = 103;BA.debugLine="Return f";
Debug.JustUpdateDeviceLine();
if (true) return _f;
 };
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _findfile(RemoteObject __ref,RemoteObject _parent,RemoteObject _name) throws Exception{
try {
		Debug.PushSubsStack("FindFile (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,57);
if (RapidSub.canDelegate("findfile")) { return __ref.runUserSub(false, "externalstorage","findfile", __ref, _parent, _name);}
RemoteObject _f = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("Parent", _parent);
Debug.locals.put("Name", _name);
 BA.debugLineNum = 57;BA.debugLine="Public Sub FindFile (Parent As ExternalFile, Name";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 58;BA.debugLine="Dim f As JavaObject = Parent.Native.RunMethod(\"fi";
Debug.JustUpdateDeviceLine();
_f = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_f = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _parent.getField(false,"Native" /*RemoteObject*/ ).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("findFile")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_name)}))));Debug.locals.put("f", _f);Debug.locals.put("f", _f);
 BA.debugLineNum = 59;BA.debugLine="Return DocumentFileToExternalFile(f)";
Debug.JustUpdateDeviceLine();
if (true) return __ref.runClassMethod (avanue.nvwa.externalstorage.class, "_documentfiletoexternalfile" /*RemoteObject*/ ,(Object)(_f));
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _findfileorcreate(RemoteObject __ref,RemoteObject _parent,RemoteObject _name) throws Exception{
try {
		Debug.PushSubsStack("FindFileOrCreate (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,88);
if (RapidSub.canDelegate("findfileorcreate")) { return __ref.runUserSub(false, "externalstorage","findfileorcreate", __ref, _parent, _name);}
RemoteObject _f = RemoteObject.declareNull("avanue.nvwa.externalstorage._externalfile");
Debug.locals.put("Parent", _parent);
Debug.locals.put("Name", _name);
 BA.debugLineNum = 88;BA.debugLine="Public Sub FindFileOrCreate (Parent As ExternalFil";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 89;BA.debugLine="Dim f As ExternalFile = FindFile(Parent, Name)";
Debug.JustUpdateDeviceLine();
_f = __ref.runClassMethod (avanue.nvwa.externalstorage.class, "_findfile" /*RemoteObject*/ ,(Object)(_parent),(Object)(_name));Debug.locals.put("f", _f);Debug.locals.put("f", _f);
 BA.debugLineNum = 90;BA.debugLine="If f.IsInitialized = False Then";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",_f.getField(true,"IsInitialized" /*RemoteObject*/ ),externalstorage.__c.getField(true,"False"))) { 
 BA.debugLineNum = 91;BA.debugLine="Return CreateNewFile(Parent, Name)";
Debug.JustUpdateDeviceLine();
if (true) return __ref.runClassMethod (avanue.nvwa.externalstorage.class, "_createnewfile" /*RemoteObject*/ ,(Object)(_parent),(Object)(_name));
 }else {
 BA.debugLineNum = 93;BA.debugLine="Return f";
Debug.JustUpdateDeviceLine();
if (true) return _f;
 };
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getba(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetBA (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,159);
if (RapidSub.canDelegate("getba")) { return __ref.runUserSub(false, "externalstorage","getba", __ref);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
 BA.debugLineNum = 159;BA.debugLine="Private Sub GetBA As Object";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 160;BA.debugLine="Dim jo As JavaObject = Me";
Debug.JustUpdateDeviceLine();
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), __ref);Debug.locals.put("jo", _jo);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 161;BA.debugLine="Return jo.RunMethod(\"getBA\", Null)";
Debug.JustUpdateDeviceLine();
if (true) return _jo.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getBA")),(Object)((externalstorage.__c.getField(false,"Null"))));
 BA.debugLineNum = 162;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getpickeddir(RemoteObject __ref,RemoteObject _uri) throws Exception{
try {
		Debug.PushSubsStack("GetPickedDir (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,145);
if (RapidSub.canDelegate("getpickeddir")) { return __ref.runUserSub(false, "externalstorage","getpickeddir", __ref, _uri);}
RemoteObject _documentfilestatic = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _treeuri = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _pickeddir = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("uri", _uri);
 BA.debugLineNum = 145;BA.debugLine="Private Sub GetPickedDir (uri As String) As JavaOb";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 146;BA.debugLine="Dim DocumentFileStatic As JavaObject";
Debug.JustUpdateDeviceLine();
_documentfilestatic = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("DocumentFileStatic", _documentfilestatic);
 BA.debugLineNum = 147;BA.debugLine="Dim treeUri As Uri";
Debug.JustUpdateDeviceLine();
_treeuri = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");Debug.locals.put("treeUri", _treeuri);
 BA.debugLineNum = 148;BA.debugLine="treeUri.Parse(uri)";
Debug.JustUpdateDeviceLine();
_treeuri.runVoidMethod ("Parse",(Object)(_uri));
 BA.debugLineNum = 149;BA.debugLine="Dim PickedDir As JavaObject = DocumentFileStatic.";
Debug.JustUpdateDeviceLine();
_pickeddir = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_pickeddir = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _documentfilestatic.runMethod(false,"InitializeStatic",(Object)(RemoteObject.createImmutable("androidx.documentfile.provider.DocumentFile"))).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("fromTreeUri")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(__ref.getField(false,"_ctxt" /*RemoteObject*/ ).getObject()),(_treeuri.getObject())}))));Debug.locals.put("PickedDir", _pickeddir);Debug.locals.put("PickedDir", _pickeddir);
 BA.debugLineNum = 150;BA.debugLine="Return PickedDir";
Debug.JustUpdateDeviceLine();
if (true) return _pickeddir;
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _callback,RemoteObject _eventname) throws Exception{
try {
		Debug.PushSubsStack("Initialize (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,13);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "externalstorage","initialize", __ref, _ba, _callback, _eventname);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Callback", _callback);
Debug.locals.put("EventName", _eventname);
 BA.debugLineNum = 13;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 14;BA.debugLine="mCallback = Callback";
Debug.JustUpdateDeviceLine();
__ref.setField ("_mcallback" /*RemoteObject*/ ,_callback);
 BA.debugLineNum = 15;BA.debugLine="mEventName = EventName";
Debug.JustUpdateDeviceLine();
__ref.setField ("_meventname" /*RemoteObject*/ ,_eventname);
 BA.debugLineNum = 16;BA.debugLine="ctxt.InitializeContext";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_ctxt" /*RemoteObject*/ ).runVoidMethod ("InitializeContext",__ref.getField(false, "ba"));
 BA.debugLineNum = 17;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ion_event(RemoteObject __ref,RemoteObject _methodname,RemoteObject _args) throws Exception{
try {
		Debug.PushSubsStack("ion_Event (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,127);
if (RapidSub.canDelegate("ion_event")) { return __ref.runUserSub(false, "externalstorage","ion_event", __ref, _methodname, _args);}
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _treeuri = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _takeflags = RemoteObject.createImmutable(0);
RemoteObject _temp = RemoteObject.declareNull("Object");
Debug.locals.put("MethodName", _methodname);
Debug.locals.put("Args", _args);
 BA.debugLineNum = 127;BA.debugLine="Private Sub ion_Event (MethodName As String, Args(";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 128;BA.debugLine="If -1 = Args(0) Then 'resultCode = RESULT_OK";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",RemoteObject.createImmutable(-(double) (0 + 1)),BA.numberCast(double.class, _args.getArrayElement(false,BA.numberCast(int.class, 0))))) { 
 BA.debugLineNum = 129;BA.debugLine="Dim i As Intent = Args(1)";
Debug.JustUpdateDeviceLine();
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");
_i = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.IntentWrapper"), _args.getArrayElement(false,BA.numberCast(int.class, 1)));Debug.locals.put("i", _i);Debug.locals.put("i", _i);
 BA.debugLineNum = 130;BA.debugLine="Dim jo As JavaObject = i";
Debug.JustUpdateDeviceLine();
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _i.getObject());Debug.locals.put("jo", _jo);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 131;BA.debugLine="Dim treeUri As Uri = jo.RunMethod(\"getData\", Nul";
Debug.JustUpdateDeviceLine();
_treeuri = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
_treeuri = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper"), _jo.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getData")),(Object)((externalstorage.__c.getField(false,"Null")))));Debug.locals.put("treeUri", _treeuri);Debug.locals.put("treeUri", _treeuri);
 BA.debugLineNum = 132;BA.debugLine="Dim takeFlags As Int = Bit.And(i.Flags, 3)";
Debug.JustUpdateDeviceLine();
_takeflags = externalstorage.__c.getField(false,"Bit").runMethod(true,"And",(Object)(_i.runMethod(true,"getFlags")),(Object)(BA.numberCast(int.class, 3)));Debug.locals.put("takeFlags", _takeflags);Debug.locals.put("takeFlags", _takeflags);
 BA.debugLineNum = 133;BA.debugLine="ctxt.RunMethodJO(\"getContentResolver\", Null).Run";
Debug.JustUpdateDeviceLine();
__ref.getField(false,"_ctxt" /*RemoteObject*/ ).runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getContentResolver")),(Object)((externalstorage.__c.getField(false,"Null")))).runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("takePersistableUriPermission")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_treeuri.getObject()),(_takeflags)})));
 BA.debugLineNum = 134;BA.debugLine="Dim temp As Object = treeUri";
Debug.JustUpdateDeviceLine();
_temp = (_treeuri.getObject());Debug.locals.put("temp", _temp);Debug.locals.put("temp", _temp);
 BA.debugLineNum = 135;BA.debugLine="PersistantUri = temp";
Debug.JustUpdateDeviceLine();
__ref.setField ("_persistanturi" /*RemoteObject*/ ,BA.ObjectToString(_temp));
 BA.debugLineNum = 136;BA.debugLine="File.WriteString(File.DirInternal, PreviousUriFi";
Debug.JustUpdateDeviceLine();
externalstorage.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(externalstorage.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(__ref.getField(true,"_previousurifilename" /*RemoteObject*/ )),(Object)(__ref.getField(true,"_persistanturi" /*RemoteObject*/ )));
 BA.debugLineNum = 137;BA.debugLine="Log(PersistantUri)";
Debug.JustUpdateDeviceLine();
externalstorage.__c.runVoidMethod ("LogImpl","98847370",__ref.getField(true,"_persistanturi" /*RemoteObject*/ ),0);
 BA.debugLineNum = 138;BA.debugLine="SetPickedDir";
Debug.JustUpdateDeviceLine();
__ref.runClassMethod (avanue.nvwa.externalstorage.class, "_setpickeddir" /*RemoteObject*/ );
 };
 BA.debugLineNum = 140;BA.debugLine="Return Null";
Debug.JustUpdateDeviceLine();
if (true) return externalstorage.__c.getField(false,"Null");
 BA.debugLineNum = 141;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _listfiles(RemoteObject __ref,RemoteObject _folder) throws Exception{
try {
		Debug.PushSubsStack("ListFiles (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,45);
if (RapidSub.canDelegate("listfiles")) { return __ref.runUserSub(false, "externalstorage","listfiles", __ref, _folder);}
RemoteObject _files = null;
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _o = RemoteObject.declareNull("Object");
RemoteObject _f = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("Folder", _folder);
 BA.debugLineNum = 45;BA.debugLine="Public Sub ListFiles (Folder As ExternalFile) As L";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 46;BA.debugLine="Dim files() As Object = Folder.Native.RunMethod(\"";
Debug.JustUpdateDeviceLine();
_files = (_folder.getField(false,"Native" /*RemoteObject*/ ).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("listFiles")),(Object)((externalstorage.__c.getField(false,"Null")))));Debug.locals.put("files", _files);Debug.locals.put("files", _files);
 BA.debugLineNum = 47;BA.debugLine="Dim res As List";
Debug.JustUpdateDeviceLine();
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("res", _res);
 BA.debugLineNum = 48;BA.debugLine="res.Initialize";
Debug.JustUpdateDeviceLine();
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 49;BA.debugLine="For Each o As Object In files";
Debug.JustUpdateDeviceLine();
{
final RemoteObject group4 = _files;
final int groupLen4 = group4.getField(true,"length").<Integer>get()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_o = group4.getArrayElement(false,RemoteObject.createImmutable(index4));Debug.locals.put("o", _o);
Debug.locals.put("o", _o);
 BA.debugLineNum = 50;BA.debugLine="Dim f As JavaObject = o";
Debug.JustUpdateDeviceLine();
_f = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_f = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _o);Debug.locals.put("f", _f);Debug.locals.put("f", _f);
 BA.debugLineNum = 51;BA.debugLine="res.Add(DocumentFileToExternalFile(f))";
Debug.JustUpdateDeviceLine();
_res.runVoidMethod ("Add",(Object)((__ref.runClassMethod (avanue.nvwa.externalstorage.class, "_documentfiletoexternalfile" /*RemoteObject*/ ,(Object)(_f)))));
 }
}Debug.locals.put("o", _o);
;
 BA.debugLineNum = 53;BA.debugLine="Return res";
Debug.JustUpdateDeviceLine();
if (true) return _res;
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _openinputstream(RemoteObject __ref,RemoteObject _ef) throws Exception{
try {
		Debug.PushSubsStack("OpenInputStream (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,83);
if (RapidSub.canDelegate("openinputstream")) { return __ref.runUserSub(false, "externalstorage","openinputstream", __ref, _ef);}
Debug.locals.put("EF", _ef);
 BA.debugLineNum = 83;BA.debugLine="Public Sub OpenInputStream(EF As ExternalFile) As";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 84;BA.debugLine="Return ctxt.RunMethodJO(\"getContentResolver\", Nul";
Debug.JustUpdateDeviceLine();
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper"), __ref.getField(false,"_ctxt" /*RemoteObject*/ ).runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getContentResolver")),(Object)((externalstorage.__c.getField(false,"Null")))).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("openInputStream")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {_ef.getField(false,"Native" /*RemoteObject*/ ).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getUri")),(Object)((externalstorage.__c.getField(false,"Null"))))}))));
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _openoutputstream(RemoteObject __ref,RemoteObject _ef) throws Exception{
try {
		Debug.PushSubsStack("OpenOutputStream (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,79);
if (RapidSub.canDelegate("openoutputstream")) { return __ref.runUserSub(false, "externalstorage","openoutputstream", __ref, _ef);}
Debug.locals.put("EF", _ef);
 BA.debugLineNum = 79;BA.debugLine="Public Sub OpenOutputStream(EF As ExternalFile) As";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 80;BA.debugLine="Return ctxt.RunMethodJO(\"getContentResolver\", Nul";
Debug.JustUpdateDeviceLine();
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper"), __ref.getField(false,"_ctxt" /*RemoteObject*/ ).runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getContentResolver")),(Object)((externalstorage.__c.getField(false,"Null")))).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("openOutputStream")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {_ef.getField(false,"Native" /*RemoteObject*/ ).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getUri")),(Object)((externalstorage.__c.getField(false,"Null"))))}))));
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _selectdir(RemoteObject __ref,RemoteObject _usepreviouslyselectedifavailable) throws Exception{
try {
		Debug.PushSubsStack("SelectDir (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,21);
if (RapidSub.canDelegate("selectdir")) { return __ref.runUserSub(false, "externalstorage","selectdir", __ref, _usepreviouslyselectedifavailable);}
RemoteObject _list = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _uripermission = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _u = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _temp = RemoteObject.declareNull("Object");
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
Debug.locals.put("UsePreviouslySelectedIfAvailable", _usepreviouslyselectedifavailable);
 BA.debugLineNum = 21;BA.debugLine="Public Sub SelectDir (UsePreviouslySelectedIfAvail";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 22;BA.debugLine="If UsePreviouslySelectedIfAvailable And File.Exis";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean(".",_usepreviouslyselectedifavailable) && RemoteObject.solveBoolean(".",externalstorage.__c.getField(false,"File").runMethod(true,"Exists",(Object)(externalstorage.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(__ref.getField(true,"_previousurifilename" /*RemoteObject*/ ))))) { 
 BA.debugLineNum = 23;BA.debugLine="PersistantUri = File.ReadString(File.DirInternal";
Debug.JustUpdateDeviceLine();
__ref.setField ("_persistanturi" /*RemoteObject*/ ,externalstorage.__c.getField(false,"File").runMethod(true,"ReadString",(Object)(externalstorage.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(__ref.getField(true,"_previousurifilename" /*RemoteObject*/ ))));
 BA.debugLineNum = 24;BA.debugLine="Dim list As List = ctxt.RunMethodJO(\"getContentR";
Debug.JustUpdateDeviceLine();
_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_list = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.List"), __ref.getField(false,"_ctxt" /*RemoteObject*/ ).runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getContentResolver")),(Object)((externalstorage.__c.getField(false,"Null")))).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getPersistedUriPermissions")),(Object)((externalstorage.__c.getField(false,"Null")))));Debug.locals.put("list", _list);Debug.locals.put("list", _list);
 BA.debugLineNum = 25;BA.debugLine="If list.IsInitialized Then";
Debug.JustUpdateDeviceLine();
if (_list.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 26;BA.debugLine="For Each uripermission As JavaObject In list";
Debug.JustUpdateDeviceLine();
_uripermission = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
{
final RemoteObject group5 = _list;
final int groupLen5 = group5.runMethod(true,"getSize").<Integer>get()
;int index5 = 0;
;
for (; index5 < groupLen5;index5++){
_uripermission = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), group5.runMethod(false,"Get",index5));Debug.locals.put("uripermission", _uripermission);
Debug.locals.put("uripermission", _uripermission);
 BA.debugLineNum = 27;BA.debugLine="Dim u As Uri = uripermission.RunMethod(\"getUri";
Debug.JustUpdateDeviceLine();
_u = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
_u = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper"), _uripermission.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getUri")),(Object)((externalstorage.__c.getField(false,"Null")))));Debug.locals.put("u", _u);Debug.locals.put("u", _u);
 BA.debugLineNum = 28;BA.debugLine="Dim temp As Object = u";
Debug.JustUpdateDeviceLine();
_temp = (_u.getObject());Debug.locals.put("temp", _temp);Debug.locals.put("temp", _temp);
 BA.debugLineNum = 29;BA.debugLine="Dim s As String = temp";
Debug.JustUpdateDeviceLine();
_s = BA.ObjectToString(_temp);Debug.locals.put("s", _s);Debug.locals.put("s", _s);
 BA.debugLineNum = 30;BA.debugLine="If s = PersistantUri And uripermission.RunMeth";
Debug.JustUpdateDeviceLine();
if (RemoteObject.solveBoolean("=",_s,__ref.getField(true,"_persistanturi" /*RemoteObject*/ )) && RemoteObject.solveBoolean("=",_uripermission.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("isWritePermission")),(Object)((externalstorage.__c.getField(false,"Null")))),(externalstorage.__c.getField(true,"True")))) { 
 BA.debugLineNum = 31;BA.debugLine="Log(\"Can use persistant uri!\")";
Debug.JustUpdateDeviceLine();
externalstorage.__c.runVoidMethod ("LogImpl","98060938",RemoteObject.createImmutable("Can use persistant uri!"),0);
 BA.debugLineNum = 32;BA.debugLine="SetPickedDir";
Debug.JustUpdateDeviceLine();
__ref.runClassMethod (avanue.nvwa.externalstorage.class, "_setpickeddir" /*RemoteObject*/ );
 BA.debugLineNum = 33;BA.debugLine="Return";
Debug.JustUpdateDeviceLine();
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("uripermission", _uripermission);
;
 };
 };
 BA.debugLineNum = 38;BA.debugLine="Dim i As Intent";
Debug.JustUpdateDeviceLine();
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 39;BA.debugLine="i.Initialize(\"android.intent.action.OPEN_DOCUMENT";
Debug.JustUpdateDeviceLine();
_i.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("android.intent.action.OPEN_DOCUMENT_TREE")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 40;BA.debugLine="i.PutExtra(\"android.content.extra.SHOW_ADVANCED\",";
Debug.JustUpdateDeviceLine();
_i.runVoidMethod ("PutExtra",(Object)(BA.ObjectToString("android.content.extra.SHOW_ADVANCED")),(Object)((externalstorage.__c.getField(true,"True"))));
 BA.debugLineNum = 41;BA.debugLine="StartActivityForResult(i)";
Debug.JustUpdateDeviceLine();
__ref.runClassMethod (avanue.nvwa.externalstorage.class, "_startactivityforresult" /*RemoteObject*/ ,(Object)(_i));
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setpickeddir(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("SetPickedDir (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,122);
if (RapidSub.canDelegate("setpickeddir")) { return __ref.runUserSub(false, "externalstorage","setpickeddir", __ref);}
 BA.debugLineNum = 122;BA.debugLine="Private Sub SetPickedDir";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 123;BA.debugLine="Root = DocumentFileToExternalFile(GetPickedDir(Pe";
Debug.JustUpdateDeviceLine();
__ref.setField ("_root" /*RemoteObject*/ ,__ref.runClassMethod (avanue.nvwa.externalstorage.class, "_documentfiletoexternalfile" /*RemoteObject*/ ,(Object)(__ref.runClassMethod (avanue.nvwa.externalstorage.class, "_getpickeddir" /*RemoteObject*/ ,(Object)(__ref.getField(true,"_persistanturi" /*RemoteObject*/ ))))));
 BA.debugLineNum = 124;BA.debugLine="CallSubDelayed(mCallback, mEventName & \"_External";
Debug.JustUpdateDeviceLine();
externalstorage.__c.runVoidMethod ("CallSubDelayed",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_mcallback" /*RemoteObject*/ )),(Object)(RemoteObject.concat(__ref.getField(true,"_meventname" /*RemoteObject*/ ),RemoteObject.createImmutable("_ExternalFolderAvailable"))));
 BA.debugLineNum = 125;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _startactivityforresult(RemoteObject __ref,RemoteObject _i) throws Exception{
try {
		Debug.PushSubsStack("StartActivityForResult (externalstorage) ","externalstorage",3,__ref.getField(false, "ba"),__ref,153);
if (RapidSub.canDelegate("startactivityforresult")) { return __ref.runUserSub(false, "externalstorage","startactivityforresult", __ref, _i);}
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("i", _i);
 BA.debugLineNum = 153;BA.debugLine="Private Sub StartActivityForResult(i As Intent)";
Debug.JustUpdateDeviceLine();
 BA.debugLineNum = 154;BA.debugLine="Dim jo As JavaObject = GetBA";
Debug.JustUpdateDeviceLine();
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), __ref.runClassMethod (avanue.nvwa.externalstorage.class, "_getba" /*RemoteObject*/ ));Debug.locals.put("jo", _jo);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 155;BA.debugLine="ion = jo.CreateEvent(\"anywheresoftware.b4a.IOnAct";
Debug.JustUpdateDeviceLine();
__ref.setField ("_ion" /*RemoteObject*/ ,_jo.runMethod(false,"CreateEvent",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("anywheresoftware.b4a.IOnActivityResult")),(Object)(BA.ObjectToString("ion")),(Object)(externalstorage.__c.getField(false,"Null"))));
 BA.debugLineNum = 156;BA.debugLine="jo.RunMethod(\"startActivityForResult\", Array As O";
Debug.JustUpdateDeviceLine();
_jo.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("startActivityForResult")),(Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {__ref.getField(false,"_ion" /*RemoteObject*/ ),(_i.getObject())})));
 BA.debugLineNum = 157;BA.debugLine="End Sub";
Debug.JustUpdateDeviceLine();
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}