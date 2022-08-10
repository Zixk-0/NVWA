package avanue.nvwa;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,125);
if (RapidSub.canDelegate("activity_create")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 125;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 126;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(536870912);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 128;BA.debugLine="Storage.Initialize (Me, \"Storage\")";
Debug.ShouldStop(-2147483648);
main._storage.runClassMethod (avanue.nvwa.externalstorage.class, "_initialize" /*RemoteObject*/ ,main.processBA,(Object)(main.getObject()),(Object)(RemoteObject.createImmutable("Storage")));
 BA.debugLineNum = 129;BA.debugLine="Parents_Dir.Initialize";
Debug.ShouldStop(1);
main._parents_dir.runVoidMethod ("Initialize");
 BA.debugLineNum = 130;BA.debugLine="Base = Activity";
Debug.ShouldStop(2);
main.mostCurrent._base = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), main.mostCurrent._activity.getObject());
 BA.debugLineNum = 131;BA.debugLine="TagDialog.Initialize (Base)";
Debug.ShouldStop(4);
main.mostCurrent._tagdialog.runClassMethod (avanue.nvwa.b4xdialog.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(main.mostCurrent._base));
 BA.debugLineNum = 132;BA.debugLine="TagDialog.Title = \"选择题目类别\"";
Debug.ShouldStop(8);
main.mostCurrent._tagdialog.setField ("_title" /*RemoteObject*/ ,RemoteObject.createImmutable(("选择题目类别")));
 BA.debugLineNum = 133;BA.debugLine="options.Initialize";
Debug.ShouldStop(16);
main.mostCurrent._options.runClassMethod (avanue.nvwa.b4xlisttemplate.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 134;BA.debugLine="options.AllowMultiSelection = True";
Debug.ShouldStop(32);
main.mostCurrent._options.setField ("_allowmultiselection" /*RemoteObject*/ ,main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 135;BA.debugLine="options.Resize(300dip,200dip)";
Debug.ShouldStop(64);
main.mostCurrent._options.runClassMethod (avanue.nvwa.b4xlisttemplate.class, "_resize" /*RemoteObject*/ ,(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))));
 BA.debugLineNum = 136;BA.debugLine="InputTag.Initialize";
Debug.ShouldStop(128);
main.mostCurrent._inputtag.runClassMethod (avanue.nvwa.b4xinputtemplate.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 138;BA.debugLine="Activity.LoadLayout(\"main\")";
Debug.ShouldStop(512);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 145;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_READ_EXTERNAL_S";
Debug.ShouldStop(65536);
main.mostCurrent._rp.runVoidMethod ("CheckAndRequest",main.processBA,(Object)(main.mostCurrent._rp.getField(true,"PERMISSION_READ_EXTERNAL_STORAGE")));
 BA.debugLineNum = 146;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_";
Debug.ShouldStop(131072);
main.mostCurrent._rp.runVoidMethod ("CheckAndRequest",main.processBA,(Object)(main.mostCurrent._rp.getField(true,"PERMISSION_WRITE_EXTERNAL_STORAGE")));
 BA.debugLineNum = 147;BA.debugLine="rp.GetAllSafeDirsExternal (\"\")";
Debug.ShouldStop(262144);
main.mostCurrent._rp.runVoidMethod ("GetAllSafeDirsExternal",(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 148;BA.debugLine="If File.Exists(File.DirDefaultExternal ,\"nvwa.db";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("nvwa.db"))),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 149;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 150;BA.debugLine="File.Copy(File.DirAssets,\"nvwa.db\",File.DirDef";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("nvwa.db")),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.createImmutable("nvwa.db")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e19) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e19.toString()); BA.debugLineNum = 152;BA.debugLine="Msgbox2Async(\"Copy error\", \"ERR\", \"OK\", \"\", \"\"";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Copy error")),(Object)(BA.ObjectToCharSequence("ERR")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 154;BA.debugLine="Msgbox2Async(\"nvwa not exits\", \"DEST\", \"OK\", \"\"";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("nvwa not exits")),(Object)(BA.ObjectToCharSequence("DEST")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 157;BA.debugLine="If SQL1.IsInitialized = False Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main.mostCurrent._sql1.runMethod(true,"IsInitialized"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 158;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 159;BA.debugLine="SQL1.Initialize(File.DirDefaultExternal, \"nvwa";
Debug.ShouldStop(1073741824);
main.mostCurrent._sql1.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(BA.ObjectToString("nvwa.db")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e27) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e27.toString()); BA.debugLineNum = 161;BA.debugLine="Msgbox2Async(\"DB Init Error\", \"ERR\", \"OK\", \"\",";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("DB Init Error")),(Object)(BA.ObjectToCharSequence("ERR")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 };
 };
 BA.debugLineNum = 175;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,192);
if (RapidSub.canDelegate("activity_pause")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 192;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 193;BA.debugLine="If camEx.IsInitialized Then";
Debug.ShouldStop(1);
if (main.mostCurrent._camex.runMethod(true,"IsInitialized" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 194;BA.debugLine="camEx.Release";
Debug.ShouldStop(2);
main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_release" /*RemoteObject*/ );
 };
 BA.debugLineNum = 196;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_permissionresult(RemoteObject _permission,RemoteObject _result) throws Exception{
try {
		Debug.PushSubsStack("Activity_PermissionResult (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,182);
if (RapidSub.canDelegate("activity_permissionresult")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","activity_permissionresult", _permission, _result);}
Debug.locals.put("Permission", _permission);
Debug.locals.put("Result", _result);
 BA.debugLineNum = 182;BA.debugLine="Sub Activity_PermissionResult (Permission As Strin";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 183;BA.debugLine="If Result=False Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_result,main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 184;BA.debugLine="Msgbox2Async(\"Permission Denied\", \"PD\", \"OK\", \"\"";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Permission Denied")),(Object)(BA.ObjectToCharSequence("PD")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 186;BA.debugLine="CallSubDelayed(Me, \"permission_done\")";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed",main.processBA,(Object)(main.getObject()),(Object)(RemoteObject.createImmutable("permission_done")));
 };
 BA.debugLineNum = 189;BA.debugLine="Log(Permission)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2393223",_permission,0);
 BA.debugLineNum = 190;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,177);
if (RapidSub.canDelegate("activity_resume")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 177;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(65536);
 BA.debugLineNum = 180;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_tag_add_click() throws Exception{
try {
		Debug.PushSubsStack("add_tag_add_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,842);
if (RapidSub.canDelegate("add_tag_add_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","add_tag_add_click");}
int _i = 0;
 BA.debugLineNum = 842;BA.debugLine="Private Sub add_tag_add_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 844;BA.debugLine="If add_tag_edit.Text = \"\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",main.mostCurrent._add_tag_edit.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 845;BA.debugLine="Msgbox2Async(\"还没有填标签名称呢！！\", \"ERR\", \"OK\", \"\", \"\",";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("还没有填标签名称呢！！")),(Object)(BA.ObjectToCharSequence("ERR")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 846;BA.debugLine="Return";
Debug.ShouldStop(8192);
if (true) return RemoteObject.createImmutable("");
 }else {
 BA.debugLineNum = 848;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM tags WHE";
Debug.ShouldStop(32768);
main.mostCurrent._cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main.mostCurrent._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tags WHERE subject = '"),main.mostCurrent._tag_subject,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 849;BA.debugLine="For i = 0 To cursor1.RowCount - 1";
Debug.ShouldStop(65536);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._cursor1.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 850;BA.debugLine="cursor1.Position = i";
Debug.ShouldStop(131072);
main.mostCurrent._cursor1.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 851;BA.debugLine="If add_tag_edit.Text = cursor1.GetString(\"tag_n";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",main.mostCurrent._add_tag_edit.runMethod(true,"getText"),main.mostCurrent._cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tag_name"))))) { 
 BA.debugLineNum = 852;BA.debugLine="Msgbox2Async(\"标签名重了！！\", \"ERR\", \"OK\", \"\", \"\", N";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("标签名重了！！")),(Object)(BA.ObjectToCharSequence("ERR")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 853;BA.debugLine="Return";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.createImmutable("");
 };
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 857;BA.debugLine="SQL1.ExecNonQuery(\"INSERT INTO tags (tag_name,sub";
Debug.ShouldStop(16777216);
main.mostCurrent._sql1.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO tags (tag_name,subject) VALUES ('"),main.mostCurrent._add_tag_edit.runMethod(true,"getText"),RemoteObject.createImmutable("','"),main.mostCurrent._tag_subject,RemoteObject.createImmutable("')"))));
 BA.debugLineNum = 858;BA.debugLine="ToastMessageShow( tag_subject & \" label '\" & add";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(main.mostCurrent._tag_subject,RemoteObject.createImmutable(" label '"),main.mostCurrent._add_tag_edit.runMethod(true,"getText"),RemoteObject.createImmutable("' added successfully")))),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 859;BA.debugLine="add_tag_edit.Text = \"\"";
Debug.ShouldStop(67108864);
main.mostCurrent._add_tag_edit.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 860;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_tag_biology_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("add_tag_biology_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,836);
if (RapidSub.canDelegate("add_tag_biology_checkedchange")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","add_tag_biology_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 836;BA.debugLine="Private Sub add_tag_biology_CheckedChange(Checked";
Debug.ShouldStop(8);
 BA.debugLineNum = 837;BA.debugLine="If Checked = True Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_checked,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 838;BA.debugLine="tag_subject = \"biology\"";
Debug.ShouldStop(32);
main.mostCurrent._tag_subject = BA.ObjectToString("biology");
 };
 BA.debugLineNum = 840;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_tag_chemistry_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("add_tag_chemistry_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,830);
if (RapidSub.canDelegate("add_tag_chemistry_checkedchange")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","add_tag_chemistry_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 830;BA.debugLine="Private Sub add_tag_chemistry_CheckedChange(Checke";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 831;BA.debugLine="If Checked = True Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_checked,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 832;BA.debugLine="tag_subject = \"chemistry\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._tag_subject = BA.ObjectToString("chemistry");
 };
 BA.debugLineNum = 834;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_tag_chinese_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("add_tag_chinese_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,806);
if (RapidSub.canDelegate("add_tag_chinese_checkedchange")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","add_tag_chinese_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 806;BA.debugLine="Private Sub add_tag_chinese_CheckedChange(Checked";
Debug.ShouldStop(32);
 BA.debugLineNum = 807;BA.debugLine="If Checked = True Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_checked,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 808;BA.debugLine="tag_subject = \"chinese\"";
Debug.ShouldStop(128);
main.mostCurrent._tag_subject = BA.ObjectToString("chinese");
 };
 BA.debugLineNum = 810;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_tag_english_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("add_tag_english_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,818);
if (RapidSub.canDelegate("add_tag_english_checkedchange")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","add_tag_english_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 818;BA.debugLine="Private Sub add_tag_english_CheckedChange(Checked";
Debug.ShouldStop(131072);
 BA.debugLineNum = 819;BA.debugLine="If Checked = True Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_checked,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 820;BA.debugLine="tag_subject = \"english\"";
Debug.ShouldStop(524288);
main.mostCurrent._tag_subject = BA.ObjectToString("english");
 };
 BA.debugLineNum = 822;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_tag_maths_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("add_tag_maths_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,812);
if (RapidSub.canDelegate("add_tag_maths_checkedchange")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","add_tag_maths_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 812;BA.debugLine="Private Sub add_tag_maths_CheckedChange(Checked As";
Debug.ShouldStop(2048);
 BA.debugLineNum = 813;BA.debugLine="If Checked = True Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_checked,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 814;BA.debugLine="tag_subject = \"maths\"";
Debug.ShouldStop(8192);
main.mostCurrent._tag_subject = BA.ObjectToString("maths");
 };
 BA.debugLineNum = 816;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_tag_physics_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("add_tag_physics_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,824);
if (RapidSub.canDelegate("add_tag_physics_checkedchange")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","add_tag_physics_checkedchange", _checked);}
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 824;BA.debugLine="Private Sub add_tag_physics_CheckedChange(Checked";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 825;BA.debugLine="If Checked = True Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_checked,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 826;BA.debugLine="tag_subject = \"physics\"";
Debug.ShouldStop(33554432);
main.mostCurrent._tag_subject = BA.ObjectToString("physics");
 };
 BA.debugLineNum = 828;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addtag_click() throws Exception{
try {
		Debug.PushSubsStack("addtag_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,794);
if (RapidSub.canDelegate("addtag_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","addtag_click");}
 BA.debugLineNum = 794;BA.debugLine="Private Sub addtag_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 795;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(67108864);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 796;BA.debugLine="Activity.LoadLayout(\"add_tag\")";
Debug.ShouldStop(134217728);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("add_tag")),main.mostCurrent.activityBA);
 BA.debugLineNum = 797;BA.debugLine="add_tag_chinese.Checked = True";
Debug.ShouldStop(268435456);
main.mostCurrent._add_tag_chinese.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 798;BA.debugLine="add_tag_maths.Checked = False";
Debug.ShouldStop(536870912);
main.mostCurrent._add_tag_maths.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 799;BA.debugLine="add_tag_english.Checked = False";
Debug.ShouldStop(1073741824);
main.mostCurrent._add_tag_english.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 800;BA.debugLine="add_tag_physics.Checked = False";
Debug.ShouldStop(-2147483648);
main.mostCurrent._add_tag_physics.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 801;BA.debugLine="add_tag_chemistry.Checked = False";
Debug.ShouldStop(1);
main.mostCurrent._add_tag_chemistry.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 802;BA.debugLine="add_tag_biology.Checked = False";
Debug.ShouldStop(2);
main.mostCurrent._add_tag_biology.runMethodAndSync(true,"setChecked",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 803;BA.debugLine="tag_subject = \"chinese\"";
Debug.ShouldStop(4);
main.mostCurrent._tag_subject = BA.ObjectToString("chinese");
 BA.debugLineNum = 804;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _answer_click() throws Exception{
try {
		Debug.PushSubsStack("answer_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,576);
if (RapidSub.canDelegate("answer_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","answer_click");}
 BA.debugLineNum = 576;BA.debugLine="Private Sub answer_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 577;BA.debugLine="A_Name = now_string";
Debug.ShouldStop(1);
main.mostCurrent._a_name = _now_string();
 BA.debugLineNum = 578;BA.debugLine="T_Name = A_Name";
Debug.ShouldStop(2);
main.mostCurrent._t_name = main.mostCurrent._a_name;
 BA.debugLineNum = 579;BA.debugLine="camEx.TakePicture";
Debug.ShouldStop(4);
main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_takepicture" /*RemoteObject*/ );
 BA.debugLineNum = 580;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _back_click() throws Exception{
try {
		Debug.PushSubsStack("back_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,207);
if (RapidSub.canDelegate("back_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","back_click");}
 BA.debugLineNum = 207;BA.debugLine="Private Sub back_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 208;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(32768);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 209;BA.debugLine="Activity.LoadLayout(\"main\")";
Debug.ShouldStop(65536);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("main")),main.mostCurrent.activityBA);
 BA.debugLineNum = 210;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _back_rev_click() throws Exception{
try {
		Debug.PushSubsStack("back_rev_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,756);
if (RapidSub.canDelegate("back_rev_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","back_rev_click");}
 BA.debugLineNum = 756;BA.debugLine="Private Sub back_rev_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 757;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(1048576);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 758;BA.debugLine="Activity.LoadLayout(\"subjects_rev\")";
Debug.ShouldStop(2097152);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("subjects_rev")),main.mostCurrent.activityBA);
 BA.debugLineNum = 759;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _back_rule_click() throws Exception{
try {
		Debug.PushSubsStack("back_rule_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,786);
if (RapidSub.canDelegate("back_rule_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","back_rule_click");}
 BA.debugLineNum = 786;BA.debugLine="Private Sub back_rule_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 788;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(524288);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 789;BA.debugLine="Activity.LoadLayout(\"review\")";
Debug.ShouldStop(1048576);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("review")),main.mostCurrent.activityBA);
 BA.debugLineNum = 790;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _biology_click() throws Exception{
try {
		Debug.PushSubsStack("biology_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,343);
if (RapidSub.canDelegate("biology_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","biology_click");}
 BA.debugLineNum = 343;BA.debugLine="Private Sub biology_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 344;BA.debugLine="tag_subject= \"biology\"";
Debug.ShouldStop(8388608);
main.mostCurrent._tag_subject = BA.ObjectToString("biology");
 BA.debugLineNum = 345;BA.debugLine="CameraClick";
Debug.ShouldStop(16777216);
_cameraclick();
 BA.debugLineNum = 346;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _biology_imp_click() throws Exception{
try {
		Debug.PushSubsStack("biology_imp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,400);
if (RapidSub.canDelegate("biology_imp_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","biology_imp_click");}
 BA.debugLineNum = 400;BA.debugLine="Private Sub biology_imp_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 401;BA.debugLine="tag_subject= \"biology\"";
Debug.ShouldStop(65536);
main.mostCurrent._tag_subject = BA.ObjectToString("biology");
 BA.debugLineNum = 402;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(131072);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 403;BA.debugLine="Activity.LoadLayout(\"record_import\")";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("record_import")),main.mostCurrent.activityBA);
 BA.debugLineNum = 404;BA.debugLine="QuesFileName = \" \"";
Debug.ShouldStop(524288);
main.mostCurrent._quesfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 405;BA.debugLine="AnsFileName = \" \"";
Debug.ShouldStop(1048576);
main.mostCurrent._ansfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 406;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _biology_rev_click() throws Exception{
try {
		Debug.PushSubsStack("biology_rev_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,671);
if (RapidSub.canDelegate("biology_rev_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","biology_rev_click");}
 BA.debugLineNum = 671;BA.debugLine="Private Sub biology_rev_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 672;BA.debugLine="tag_subject= \"biology\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._tag_subject = BA.ObjectToString("biology");
 BA.debugLineNum = 673;BA.debugLine="RevClick";
Debug.ShouldStop(1);
_revclick();
 BA.debugLineNum = 674;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnflash_click() throws Exception{
try {
		Debug.PushSubsStack("btnFlash_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,556);
if (RapidSub.canDelegate("btnflash_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","btnflash_click");}
RemoteObject _f = null;
RemoteObject _flashmodes = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _flash = RemoteObject.createImmutable("");
 BA.debugLineNum = 556;BA.debugLine="Private Sub btnFlash_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 557;BA.debugLine="Dim f() As Float = camEx.GetFocusDistances";
Debug.ShouldStop(4096);
_f = main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_getfocusdistances" /*RemoteObject*/ );Debug.locals.put("f", _f);Debug.locals.put("f", _f);
 BA.debugLineNum = 558;BA.debugLine="Log(f(0) & \", \" & f(1) & \", \" & f(2))";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("LogImpl","22293762",RemoteObject.concat(_f.getArrayElement(true,BA.numberCast(int.class, 0)),RemoteObject.createImmutable(", "),_f.getArrayElement(true,BA.numberCast(int.class, 1)),RemoteObject.createImmutable(", "),_f.getArrayElement(true,BA.numberCast(int.class, 2))),0);
 BA.debugLineNum = 559;BA.debugLine="Dim flashModes As List = camEx.GetSupportedFlashM";
Debug.ShouldStop(16384);
_flashmodes = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_flashmodes = main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_getsupportedflashmodes" /*RemoteObject*/ );Debug.locals.put("flashModes", _flashmodes);Debug.locals.put("flashModes", _flashmodes);
 BA.debugLineNum = 560;BA.debugLine="If flashModes.IsInitialized = False Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_flashmodes.runMethod(true,"IsInitialized"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 561;BA.debugLine="ToastMessageShow(\"Flash not supported.\", False)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Flash not supported.")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 562;BA.debugLine="Return";
Debug.ShouldStop(131072);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 564;BA.debugLine="Dim flash As String = flashModes.Get((flashModes.";
Debug.ShouldStop(524288);
_flash = BA.ObjectToString(_flashmodes.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {_flashmodes.runMethod(true,"IndexOf",(Object)((main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_getflashmode" /*RemoteObject*/ )))),RemoteObject.createImmutable(1)}, "+",1, 1)),_flashmodes.runMethod(true,"getSize")}, "%",0, 1))));Debug.locals.put("flash", _flash);Debug.locals.put("flash", _flash);
 BA.debugLineNum = 565;BA.debugLine="camEx.SetFlashMode(flash)";
Debug.ShouldStop(1048576);
main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_setflashmode" /*RemoteObject*/ ,(Object)(_flash));
 BA.debugLineNum = 566;BA.debugLine="ToastMessageShow(flash, False)";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(_flash)),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 567;BA.debugLine="camEx.CommitParameters";
Debug.ShouldStop(4194304);
main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_commitparameters" /*RemoteObject*/ );
 BA.debugLineNum = 569;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnimpans_click() throws Exception{
try {
		Debug.PushSubsStack("btnImpAns_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,427);
if (RapidSub.canDelegate("btnimpans_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","btnimpans_click");}
RemoteObject _answ = RemoteObject.createImmutable(0);
 BA.debugLineNum = 427;BA.debugLine="Private Sub btnImpAns_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 428;BA.debugLine="Dim Answ As Int";
Debug.ShouldStop(2048);
_answ = RemoteObject.createImmutable(0);Debug.locals.put("Answ", _answ);
 BA.debugLineNum = 430;BA.debugLine="FileDialog1.FilePath = AnsFilePath";
Debug.ShouldStop(8192);
main.mostCurrent._filedialog1.runMethod(true,"setFilePath",main.mostCurrent._ansfilepath);
 BA.debugLineNum = 431;BA.debugLine="Answ = FileDialog1.Show(\"Databases\",\"Load\",\"Cance";
Debug.ShouldStop(16384);
_answ = main.mostCurrent._filedialog1.runMethod(true,"Show",(Object)(BA.ObjectToCharSequence("Databases")),(Object)(BA.ObjectToString("Load")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("")),main.mostCurrent.activityBA,(Object)((main.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("Answ", _answ);
 BA.debugLineNum = 433;BA.debugLine="Select Answ";
Debug.ShouldStop(65536);
switch (BA.switchObjectToInt(_answ,main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE"),main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"CANCEL"))) {
case 0: {
 BA.debugLineNum = 435;BA.debugLine="AnsFileName = FileDialog1.ChosenName";
Debug.ShouldStop(262144);
main.mostCurrent._ansfilename = main.mostCurrent._filedialog1.runMethod(true,"getChosenName");
 BA.debugLineNum = 436;BA.debugLine="AnsFilePath = FileDialog1.FilePath";
Debug.ShouldStop(524288);
main.mostCurrent._ansfilepath = main.mostCurrent._filedialog1.runMethod(true,"getFilePath");
 BA.debugLineNum = 437;BA.debugLine="ScrAns.Panel.SetBackgroundImage(LoadBitmap(AnsF";
Debug.ShouldStop(1048576);
main.mostCurrent._scrans.runMethod(false,"getPanel").runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent._ansfilepath),(Object)(main.mostCurrent._ansfilename)).getObject())));
 BA.debugLineNum = 438;BA.debugLine="BitmapAns.Initialize(AnsFilePath, AnsFileName)";
Debug.ShouldStop(2097152);
main.mostCurrent._bitmapans.runVoidMethod ("Initialize",(Object)(main.mostCurrent._ansfilepath),(Object)(main.mostCurrent._ansfilename));
 BA.debugLineNum = 439;BA.debugLine="ScrAns.Panel.SetBackgroundImage(BitmapAns)";
Debug.ShouldStop(4194304);
main.mostCurrent._scrans.runMethod(false,"getPanel").runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent._bitmapans.getObject())));
 BA.debugLineNum = 440;BA.debugLine="ScrAns.Panel.Height = Floor(BitmapAns.Height /";
Debug.ShouldStop(8388608);
main.mostCurrent._scrans.runMethod(false,"getPanel").runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._bitmapans.runMethod(true,"getHeight"),RemoteObject.createImmutable(5)}, "/",0, 0))),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "*",0, 0)));
 BA.debugLineNum = 441;BA.debugLine="ScrAns.Panel.Width = Floor(BitmapAns.Width / 5)";
Debug.ShouldStop(16777216);
main.mostCurrent._scrans.runMethod(false,"getPanel").runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._bitmapans.runMethod(true,"getWidth"),RemoteObject.createImmutable(5)}, "/",0, 0))),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "*",0, 0)));
 break; }
case 1: {
 break; }
}
;
 BA.debugLineNum = 445;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnimpcomplete_click() throws Exception{
try {
		Debug.PushSubsStack("btnImpComplete_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,447);
if (RapidSub.canDelegate("btnimpcomplete_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","btnimpcomplete_click");}
RemoteObject _td = RemoteObject.createImmutable("");
RemoteObject _level = RemoteObject.createImmutable(0);
RemoteObject _newid = RemoteObject.createImmutable(0);
RemoteObject _quesfilenamenew = RemoteObject.createImmutable("");
RemoteObject _ansfilenamenew = RemoteObject.createImmutable("");
 BA.debugLineNum = 447;BA.debugLine="Private Sub btnImpComplete_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 448;BA.debugLine="If QuesFileName = \" \" Or AnsFileName = \" \" Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",main.mostCurrent._quesfilename,BA.ObjectToString(" ")) || RemoteObject.solveBoolean("=",main.mostCurrent._ansfilename,BA.ObjectToString(" "))) { 
 BA.debugLineNum = 449;BA.debugLine="Msgbox2Async(\"没选完呢！！\", \"ERR\", \"OK\", \"\", \"\", Null";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("没选完呢！！")),(Object)(BA.ObjectToCharSequence("ERR")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 450;BA.debugLine="Return";
Debug.ShouldStop(2);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 452;BA.debugLine="Dim td As String";
Debug.ShouldStop(8);
_td = RemoteObject.createImmutable("");Debug.locals.put("td", _td);
 BA.debugLineNum = 453;BA.debugLine="td = now_string";
Debug.ShouldStop(16);
_td = _now_string();Debug.locals.put("td", _td);
 BA.debugLineNum = 454;BA.debugLine="Dim level As Int";
Debug.ShouldStop(32);
_level = RemoteObject.createImmutable(0);Debug.locals.put("level", _level);
 BA.debugLineNum = 455;BA.debugLine="level = 1";
Debug.ShouldStop(64);
_level = BA.numberCast(int.class, 1);Debug.locals.put("level", _level);
 BA.debugLineNum = 456;BA.debugLine="Dim NewID As Int = 0";
Debug.ShouldStop(128);
_newid = BA.numberCast(int.class, 0);Debug.locals.put("NewID", _newid);Debug.locals.put("NewID", _newid);
 BA.debugLineNum = 457;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT ID FROM \" & tag_";
Debug.ShouldStop(256);
main.mostCurrent._cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main.mostCurrent._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT ID FROM "),main.mostCurrent._tag_subject,RemoteObject.createImmutable("_bank")))));
 BA.debugLineNum = 458;BA.debugLine="NewID = cursor1.RowCount + 1 ' add 1 to the ID nu";
Debug.ShouldStop(512);
_newid = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._cursor1.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("NewID", _newid);
 BA.debugLineNum = 494;BA.debugLine="Dim QuesFileNameNew As String = td & \"_1.\" & FT.F";
Debug.ShouldStop(8192);
_quesfilenamenew = RemoteObject.concat(_td,RemoteObject.createImmutable("_1."),main.mostCurrent._ft.runMethod(true,"_fileextension",(Object)(main.mostCurrent._quesfilename)));Debug.locals.put("QuesFileNameNew", _quesfilenamenew);Debug.locals.put("QuesFileNameNew", _quesfilenamenew);
 BA.debugLineNum = 495;BA.debugLine="Dim AnsFileNameNew As String = td & \"_2.\" & FT.Fi";
Debug.ShouldStop(16384);
_ansfilenamenew = RemoteObject.concat(_td,RemoteObject.createImmutable("_2."),main.mostCurrent._ft.runMethod(true,"_fileextension",(Object)(main.mostCurrent._ansfilename)));Debug.locals.put("AnsFileNameNew", _ansfilenamenew);Debug.locals.put("AnsFileNameNew", _ansfilenamenew);
 BA.debugLineNum = 496;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 497;BA.debugLine="File.Copy(QuesFilePath,QuesFileName,File.DirDefa";
Debug.ShouldStop(65536);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent._quesfilepath),(Object)(main.mostCurrent._quesfilename),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(_quesfilenamenew));
 BA.debugLineNum = 498;BA.debugLine="File.Copy(AnsFilePath,AnsFileName,File.DirDefaul";
Debug.ShouldStop(131072);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent._ansfilepath),(Object)(main.mostCurrent._ansfilename),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(_ansfilenamenew));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e18) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e18.toString()); BA.debugLineNum = 500;BA.debugLine="Msgbox2Async(\"未能成功复制文件\", \"ERR\", \"OK\", \"\", \"\", Nu";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("未能成功复制文件")),(Object)(BA.ObjectToCharSequence("ERR")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 501;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("LogImpl","22031670",BA.ObjectToString(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA)),0);
 };
 BA.debugLineNum = 503;BA.debugLine="SQL1.ExecNonQuery(\"INSERT INTO \" & tag_subject &";
Debug.ShouldStop(4194304);
main.mostCurrent._sql1.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO "),main.mostCurrent._tag_subject,RemoteObject.createImmutable("_bank"),RemoteObject.createImmutable(" (ID,Time_Create,Valid,Level,Question_Image,Answer_Image)  VALUES('"),_newid,RemoteObject.createImmutable("','"),_td,RemoteObject.createImmutable("','"),_td,RemoteObject.createImmutable("','"),_level,RemoteObject.createImmutable("','"),_quesfilenamenew,RemoteObject.createImmutable("','"),_ansfilenamenew,RemoteObject.createImmutable("')"))));
 BA.debugLineNum = 506;BA.debugLine="QuesFileName = \" \"";
Debug.ShouldStop(33554432);
main.mostCurrent._quesfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 507;BA.debugLine="AnsFileName = \" \"";
Debug.ShouldStop(67108864);
main.mostCurrent._ansfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 508;BA.debugLine="QuesFileNameNew = \" \"";
Debug.ShouldStop(134217728);
_quesfilenamenew = BA.ObjectToString(" ");Debug.locals.put("QuesFileNameNew", _quesfilenamenew);
 BA.debugLineNum = 509;BA.debugLine="AnsFileNameNew = \" \"";
Debug.ShouldStop(268435456);
_ansfilenamenew = BA.ObjectToString(" ");Debug.locals.put("AnsFileNameNew", _ansfilenamenew);
 BA.debugLineNum = 512;BA.debugLine="ScrQues.Panel.SetBackgroundImage(LoadBitmap(File.";
Debug.ShouldStop(-2147483648);
main.mostCurrent._scrques.runMethod(false,"getPanel").runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("import_empty.jpg"))).getObject())));
 BA.debugLineNum = 513;BA.debugLine="ScrAns.Panel.SetBackgroundImage(LoadBitmap(File.D";
Debug.ShouldStop(1);
main.mostCurrent._scrans.runMethod(false,"getPanel").runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("import_empty.jpg"))).getObject())));
 BA.debugLineNum = 514;BA.debugLine="ScrQues.Panel.Height = 220dip";
Debug.ShouldStop(2);
main.mostCurrent._scrques.runMethod(false,"getPanel").runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 220))));
 BA.debugLineNum = 515;BA.debugLine="ScrQues.Panel.Width = 220dip";
Debug.ShouldStop(4);
main.mostCurrent._scrques.runMethod(false,"getPanel").runMethod(true,"setWidth",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 220))));
 BA.debugLineNum = 516;BA.debugLine="ScrAns.Panel.Height = 220dip";
Debug.ShouldStop(8);
main.mostCurrent._scrans.runMethod(false,"getPanel").runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 220))));
 BA.debugLineNum = 517;BA.debugLine="ScrAns.Panel.Width = 220dip";
Debug.ShouldStop(16);
main.mostCurrent._scrans.runMethod(false,"getPanel").runMethod(true,"setWidth",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 220))));
 BA.debugLineNum = 518;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnimpques_click() throws Exception{
try {
		Debug.PushSubsStack("btnImpQues_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,408);
if (RapidSub.canDelegate("btnimpques_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","btnimpques_click");}
RemoteObject _answ = RemoteObject.createImmutable(0);
 BA.debugLineNum = 408;BA.debugLine="Private Sub btnImpQues_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 409;BA.debugLine="Dim Answ As Int";
Debug.ShouldStop(16777216);
_answ = RemoteObject.createImmutable(0);Debug.locals.put("Answ", _answ);
 BA.debugLineNum = 411;BA.debugLine="FileDialog1.FilePath = QuesFilePath '弹出选择窗口";
Debug.ShouldStop(67108864);
main.mostCurrent._filedialog1.runMethod(true,"setFilePath",main.mostCurrent._quesfilepath);
 BA.debugLineNum = 412;BA.debugLine="Answ = FileDialog1.Show(\"Databases\",\"Load\",\"Cance";
Debug.ShouldStop(134217728);
_answ = main.mostCurrent._filedialog1.runMethod(true,"Show",(Object)(BA.ObjectToCharSequence("Databases")),(Object)(BA.ObjectToString("Load")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("")),main.mostCurrent.activityBA,(Object)((main.mostCurrent.__c.getField(false,"Null"))));Debug.locals.put("Answ", _answ);
 BA.debugLineNum = 414;BA.debugLine="Select Answ";
Debug.ShouldStop(536870912);
switch (BA.switchObjectToInt(_answ,main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE"),main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"CANCEL"))) {
case 0: {
 BA.debugLineNum = 416;BA.debugLine="QuesFileName = FileDialog1.ChosenName";
Debug.ShouldStop(-2147483648);
main.mostCurrent._quesfilename = main.mostCurrent._filedialog1.runMethod(true,"getChosenName");
 BA.debugLineNum = 417;BA.debugLine="QuesFilePath = FileDialog1.FilePath";
Debug.ShouldStop(1);
main.mostCurrent._quesfilepath = main.mostCurrent._filedialog1.runMethod(true,"getFilePath");
 BA.debugLineNum = 418;BA.debugLine="BitmapQues.Initialize(QuesFilePath, QuesFileNam";
Debug.ShouldStop(2);
main.mostCurrent._bitmapques.runVoidMethod ("Initialize",(Object)(main.mostCurrent._quesfilepath),(Object)(main.mostCurrent._quesfilename));
 BA.debugLineNum = 419;BA.debugLine="ScrQues.Panel.SetBackgroundImage(BitmapQues)";
Debug.ShouldStop(4);
main.mostCurrent._scrques.runMethod(false,"getPanel").runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent._bitmapques.getObject())));
 BA.debugLineNum = 420;BA.debugLine="ScrQues.Panel.Height = Floor(BitmapQues.Height";
Debug.ShouldStop(8);
main.mostCurrent._scrques.runMethod(false,"getPanel").runMethod(true,"setHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._bitmapques.runMethod(true,"getHeight"),RemoteObject.createImmutable(5)}, "/",0, 0))),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "*",0, 0)));
 BA.debugLineNum = 421;BA.debugLine="ScrQues.Panel.Width = Floor(BitmapQues.Width /";
Debug.ShouldStop(16);
main.mostCurrent._scrques.runMethod(false,"getPanel").runMethod(true,"setWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"Floor",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._bitmapques.runMethod(true,"getWidth"),RemoteObject.createImmutable(5)}, "/",0, 0))),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "*",0, 0)));
 break; }
case 1: {
 break; }
}
;
 BA.debugLineNum = 425;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btntakepicture_click() throws Exception{
try {
		Debug.PushSubsStack("btnTakePicture_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,537);
if (RapidSub.canDelegate("btntakepicture_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","btntakepicture_click");}
 BA.debugLineNum = 537;BA.debugLine="Sub btnTakePicture_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 539;BA.debugLine="Q_Name = now_string";
Debug.ShouldStop(67108864);
main.mostCurrent._q_name = _now_string();
 BA.debugLineNum = 540;BA.debugLine="T_Name = Q_Name";
Debug.ShouldStop(134217728);
main.mostCurrent._t_name = main.mostCurrent._q_name;
 BA.debugLineNum = 541;BA.debugLine="camEx.TakePicture";
Debug.ShouldStop(268435456);
main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_takepicture" /*RemoteObject*/ );
 BA.debugLineNum = 542;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _camera1_focusdone(RemoteObject _success) throws Exception{
try {
		Debug.PushSubsStack("Camera1_FocusDone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,225);
if (RapidSub.canDelegate("camera1_focusdone")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","camera1_focusdone", _success);}
Debug.locals.put("Success", _success);
 BA.debugLineNum = 225;BA.debugLine="Sub Camera1_FocusDone(Success As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 226;BA.debugLine="Msgbox2Async(\"Mamera focus down\", \"FD\", \"OK\", \"\",";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Mamera focus down")),(Object)(BA.ObjectToCharSequence("FD")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 227;BA.debugLine="If Success Then";
Debug.ShouldStop(4);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 228;BA.debugLine="Msgbox2Async(\"Camera focus down\", \"Focus DONE\",";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("Camera focus down")),(Object)(BA.ObjectToCharSequence("Focus DONE")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 230;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _camera1_picturetaken(RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("Camera1_PictureTaken (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,522);
if (RapidSub.canDelegate("camera1_picturetaken")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","camera1_picturetaken", _data);}
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
Debug.locals.put("Data", _data);
 BA.debugLineNum = 522;BA.debugLine="Sub Camera1_PictureTaken (Data() As Byte)";
Debug.ShouldStop(512);
 BA.debugLineNum = 524;BA.debugLine="Dim out As OutputStream";
Debug.ShouldStop(2048);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("out", _out);
 BA.debugLineNum = 527;BA.debugLine="camEx.SavePictureToFile(Data, File.DirDefaultExte";
Debug.ShouldStop(16384);
main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_savepicturetofile" /*RemoteObject*/ ,(Object)(_data),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.concat(main.mostCurrent._t_name,RemoteObject.createImmutable(".jpg"))));
 BA.debugLineNum = 528;BA.debugLine="camEx.StartPreview 'restart preview";
Debug.ShouldStop(32768);
main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_startpreview" /*RemoteObject*/ );
 BA.debugLineNum = 530;BA.debugLine="ToastMessageShow(\"Image saved: \" & File.Combine(F";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Image saved: "),main.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(RemoteObject.concat(main.mostCurrent._t_name,RemoteObject.createImmutable(".jpg"))))))),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 531;BA.debugLine="btnTakePicture.Enabled = True";
Debug.ShouldStop(262144);
main.mostCurrent._btntakepicture.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 533;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _camera1_ready(RemoteObject _success) throws Exception{
try {
		Debug.PushSubsStack("Camera1_Ready (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,212);
if (RapidSub.canDelegate("camera1_ready")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","camera1_ready", _success);}
Debug.locals.put("Success", _success);
 BA.debugLineNum = 212;BA.debugLine="Sub Camera1_Ready (Success As Boolean)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 213;BA.debugLine="If Success Then";
Debug.ShouldStop(1048576);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 214;BA.debugLine="camEx.SetJpegQuality(90)";
Debug.ShouldStop(2097152);
main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_setjpegquality" /*RemoteObject*/ ,(Object)(BA.numberCast(int.class, 90)));
 BA.debugLineNum = 215;BA.debugLine="camEx.SetContinuousAutoFocus";
Debug.ShouldStop(4194304);
main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_setcontinuousautofocus" /*RemoteObject*/ );
 BA.debugLineNum = 216;BA.debugLine="camEx.CommitParameters";
Debug.ShouldStop(8388608);
main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_commitparameters" /*RemoteObject*/ );
 BA.debugLineNum = 217;BA.debugLine="camEx.StartPreview";
Debug.ShouldStop(16777216);
main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_startpreview" /*RemoteObject*/ );
 BA.debugLineNum = 218;BA.debugLine="Log(camEx.GetPreviewSize)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("LogImpl","2720902",BA.ObjectToString(main.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_getpreviewsize" /*RemoteObject*/ )),0);
 }else {
 BA.debugLineNum = 220;BA.debugLine="ToastMessageShow(\"Cannot open camera.\", True)";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Cannot open camera.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 222;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cameraclick() throws Exception{
try {
		Debug.PushSubsStack("CameraClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,293);
if (RapidSub.canDelegate("cameraclick")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","cameraclick");}
 BA.debugLineNum = 293;BA.debugLine="Sub CameraClick";
Debug.ShouldStop(16);
 BA.debugLineNum = 295;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(64);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 297;BA.debugLine="Activity.LoadLayout (\"record\")";
Debug.ShouldStop(256);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("record")),main.mostCurrent.activityBA);
 BA.debugLineNum = 298;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 299;BA.debugLine="InitializeCamera";
Debug.ShouldStop(1024);
_initializecamera();
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e6.toString()); BA.debugLineNum = 301;BA.debugLine="Msgbox2Async(\"camera init err\", \"err\", \"OK\", \"\",";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("camera init err")),(Object)(BA.ObjectToCharSequence("err")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 303;BA.debugLine="q_count.Text = \"总题数：\" & refresh_count(tag_subject";
Debug.ShouldStop(16384);
main.mostCurrent._q_count.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("总题数："),_refresh_count(main.mostCurrent._tag_subject))));
 BA.debugLineNum = 316;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cancel_click() throws Exception{
try {
		Debug.PushSubsStack("cancel_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,615);
if (RapidSub.canDelegate("cancel_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","cancel_click");}
 BA.debugLineNum = 615;BA.debugLine="Private Sub cancel_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 616;BA.debugLine="A_Name = \"\"";
Debug.ShouldStop(128);
main.mostCurrent._a_name = BA.ObjectToString("");
 BA.debugLineNum = 617;BA.debugLine="Q_Name = \"\"";
Debug.ShouldStop(256);
main.mostCurrent._q_name = BA.ObjectToString("");
 BA.debugLineNum = 618;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _change_rules_click() throws Exception{
try {
		Debug.PushSubsStack("change_rules_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,765);
if (RapidSub.canDelegate("change_rules_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","change_rules_click");}
 BA.debugLineNum = 765;BA.debugLine="Private Sub change_rules_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 766;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM \" & tag_s";
Debug.ShouldStop(536870912);
main.mostCurrent._cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main.mostCurrent._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),main.mostCurrent._tag_subject,RemoteObject.createImmutable("_bank")))));
 BA.debugLineNum = 768;BA.debugLine="If cursor1.RowCount < 1 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("<",main.mostCurrent._cursor1.runMethod(true,"getRowCount"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 769;BA.debugLine="Msgbox2Async(\"找不到题目呢\", \"ERR\", \"OK\", \"\", \"\", Null";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("找不到题目呢")),(Object)(BA.ObjectToCharSequence("ERR")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 770;BA.debugLine="Return (\"\")";
Debug.ShouldStop(2);
if (true) return (RemoteObject.createImmutable(""));
 };
 BA.debugLineNum = 773;BA.debugLine="random_num = Rnd(0,cursor1.RowCount)";
Debug.ShouldStop(16);
main._random_num = main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent._cursor1.runMethod(true,"getRowCount")));
 BA.debugLineNum = 774;BA.debugLine="cursor1.Position = random_num";
Debug.ShouldStop(32);
main.mostCurrent._cursor1.runMethod(true,"setPosition",main._random_num);
 BA.debugLineNum = 776;BA.debugLine="Current_ID = cursor1.GetInt(\"ID\")";
Debug.ShouldStop(128);
main._current_id = main.mostCurrent._cursor1.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("ID")));
 BA.debugLineNum = 777;BA.debugLine="Current_Correct_Times = cursor1.GetInt(\"Correct_T";
Debug.ShouldStop(256);
main._current_correct_times = main.mostCurrent._cursor1.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("Correct_Times")));
 BA.debugLineNum = 778;BA.debugLine="Current_Last_Time = cursor1.GetString(\"Last_Time\"";
Debug.ShouldStop(512);
main.mostCurrent._current_last_time = main.mostCurrent._cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Last_Time")));
 BA.debugLineNum = 780;BA.debugLine="Return(cursor1.GetString(\"Question_Image\"))";
Debug.ShouldStop(2048);
if (true) return (main.mostCurrent._cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Question_Image"))));
 BA.debugLineNum = 781;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(4096);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 782;BA.debugLine="Activity.LoadLayout(\"select_rule\")";
Debug.ShouldStop(8192);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("select_rule")),main.mostCurrent.activityBA);
 BA.debugLineNum = 784;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chemistry_click() throws Exception{
try {
		Debug.PushSubsStack("chemistry_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,338);
if (RapidSub.canDelegate("chemistry_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","chemistry_click");}
 BA.debugLineNum = 338;BA.debugLine="Private Sub chemistry_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 339;BA.debugLine="tag_subject= \"chemistry\"";
Debug.ShouldStop(262144);
main.mostCurrent._tag_subject = BA.ObjectToString("chemistry");
 BA.debugLineNum = 340;BA.debugLine="CameraClick";
Debug.ShouldStop(524288);
_cameraclick();
 BA.debugLineNum = 341;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chemistry_imp_click() throws Exception{
try {
		Debug.PushSubsStack("chemistry_imp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,392);
if (RapidSub.canDelegate("chemistry_imp_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","chemistry_imp_click");}
 BA.debugLineNum = 392;BA.debugLine="Private Sub chemistry_imp_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 393;BA.debugLine="tag_subject= \"chemistry\"";
Debug.ShouldStop(256);
main.mostCurrent._tag_subject = BA.ObjectToString("chemistry");
 BA.debugLineNum = 394;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(512);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 395;BA.debugLine="Activity.LoadLayout(\"record_import\")";
Debug.ShouldStop(1024);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("record_import")),main.mostCurrent.activityBA);
 BA.debugLineNum = 396;BA.debugLine="QuesFileName = \" \"";
Debug.ShouldStop(2048);
main.mostCurrent._quesfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 397;BA.debugLine="AnsFileName = \" \"";
Debug.ShouldStop(4096);
main.mostCurrent._ansfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 398;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chemistry_rev_click() throws Exception{
try {
		Debug.PushSubsStack("chemistry_rev_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,666);
if (RapidSub.canDelegate("chemistry_rev_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","chemistry_rev_click");}
 BA.debugLineNum = 666;BA.debugLine="Private Sub chemistry_rev_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 667;BA.debugLine="tag_subject= \"chemistry\"";
Debug.ShouldStop(67108864);
main.mostCurrent._tag_subject = BA.ObjectToString("chemistry");
 BA.debugLineNum = 668;BA.debugLine="RevClick";
Debug.ShouldStop(134217728);
_revclick();
 BA.debugLineNum = 669;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chinese_click() throws Exception{
try {
		Debug.PushSubsStack("chinese_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,318);
if (RapidSub.canDelegate("chinese_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","chinese_click");}
 BA.debugLineNum = 318;BA.debugLine="Private Sub chinese_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 319;BA.debugLine="tag_subject= \"chinese\"";
Debug.ShouldStop(1073741824);
main.mostCurrent._tag_subject = BA.ObjectToString("chinese");
 BA.debugLineNum = 320;BA.debugLine="CameraClick";
Debug.ShouldStop(-2147483648);
_cameraclick();
 BA.debugLineNum = 321;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chinese_imp_click() throws Exception{
try {
		Debug.PushSubsStack("chinese_imp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,360);
if (RapidSub.canDelegate("chinese_imp_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","chinese_imp_click");}
 BA.debugLineNum = 360;BA.debugLine="Private Sub chinese_imp_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 361;BA.debugLine="tag_subject= \"chinese\"";
Debug.ShouldStop(256);
main.mostCurrent._tag_subject = BA.ObjectToString("chinese");
 BA.debugLineNum = 362;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(512);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 363;BA.debugLine="Activity.LoadLayout(\"record_import\")";
Debug.ShouldStop(1024);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("record_import")),main.mostCurrent.activityBA);
 BA.debugLineNum = 364;BA.debugLine="QuesFileName = \" \"";
Debug.ShouldStop(2048);
main.mostCurrent._quesfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 365;BA.debugLine="AnsFileName = \" \"";
Debug.ShouldStop(4096);
main.mostCurrent._ansfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 366;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _chinese_rev_click() throws Exception{
try {
		Debug.PushSubsStack("chinese_rev_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,646);
if (RapidSub.canDelegate("chinese_rev_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","chinese_rev_click");}
 BA.debugLineNum = 646;BA.debugLine="Private Sub chinese_rev_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 647;BA.debugLine="tag_subject= \"chinese\"";
Debug.ShouldStop(64);
main.mostCurrent._tag_subject = BA.ObjectToString("chinese");
 BA.debugLineNum = 648;BA.debugLine="RevClick";
Debug.ShouldStop(128);
_revclick();
 BA.debugLineNum = 649;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _correct_click() throws Exception{
try {
		Debug.PushSubsStack("correct_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,676);
if (RapidSub.canDelegate("correct_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","correct_click");}
RemoteObject _tn = RemoteObject.createImmutable("");
RemoteObject _table_name = RemoteObject.createImmutable("");
 BA.debugLineNum = 676;BA.debugLine="Private Sub correct_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 677;BA.debugLine="Dim tn As String";
Debug.ShouldStop(16);
_tn = RemoteObject.createImmutable("");Debug.locals.put("tn", _tn);
 BA.debugLineNum = 678;BA.debugLine="Dim table_name As String";
Debug.ShouldStop(32);
_table_name = RemoteObject.createImmutable("");Debug.locals.put("table_name", _table_name);
 BA.debugLineNum = 679;BA.debugLine="table_name = tag_subject & \"_bank\"";
Debug.ShouldStop(64);
_table_name = RemoteObject.concat(main.mostCurrent._tag_subject,RemoteObject.createImmutable("_bank"));Debug.locals.put("table_name", _table_name);
 BA.debugLineNum = 682;BA.debugLine="Current_Correct_Times = Current_Correct_Times +1";
Debug.ShouldStop(512);
main._current_correct_times = RemoteObject.solve(new RemoteObject[] {main._current_correct_times,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 683;BA.debugLine="SQL1.ExecNonQuery(\"UPDATE '\"& table_name &\"' SET";
Debug.ShouldStop(1024);
main.mostCurrent._sql1.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE '"),_table_name,RemoteObject.createImmutable("' SET Correct_Times = '"),main._current_correct_times,RemoteObject.createImmutable("' WHERE  ID = '"),main._current_id,RemoteObject.createImmutable("' "))));
 BA.debugLineNum = 684;BA.debugLine="tn = select_question(tag_subject)";
Debug.ShouldStop(2048);
_tn = _select_question(main.mostCurrent._tag_subject);Debug.locals.put("tn", _tn);
 BA.debugLineNum = 686;BA.debugLine="If tn = \"\" Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_tn,BA.ObjectToString(""))) { 
 BA.debugLineNum = 687;BA.debugLine="Return";
Debug.ShouldStop(16384);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 689;BA.debugLine="Refresh_question(random_num)";
Debug.ShouldStop(65536);
_refresh_question(main._random_num);
 BA.debugLineNum = 690;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _dbload() throws Exception{
try {
		Debug.PushSubsStack("DBload (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,111);
if (RapidSub.canDelegate("dbload")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","dbload");}
 BA.debugLineNum = 111;BA.debugLine="Sub DBload";
Debug.ShouldStop(16384);
 BA.debugLineNum = 114;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM \" & tag_s";
Debug.ShouldStop(131072);
main.mostCurrent._cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main.mostCurrent._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),main.mostCurrent._tag_subject,RemoteObject.createImmutable("_bank")))));
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _english_click() throws Exception{
try {
		Debug.PushSubsStack("english_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,328);
if (RapidSub.canDelegate("english_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","english_click");}
 BA.debugLineNum = 328;BA.debugLine="Private Sub english_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 329;BA.debugLine="tag_subject= \"english\"";
Debug.ShouldStop(256);
main.mostCurrent._tag_subject = BA.ObjectToString("english");
 BA.debugLineNum = 330;BA.debugLine="CameraClick";
Debug.ShouldStop(512);
_cameraclick();
 BA.debugLineNum = 331;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _english_imp_click() throws Exception{
try {
		Debug.PushSubsStack("english_imp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,376);
if (RapidSub.canDelegate("english_imp_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","english_imp_click");}
 BA.debugLineNum = 376;BA.debugLine="Private Sub english_imp_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 377;BA.debugLine="tag_subject= \"english\"";
Debug.ShouldStop(16777216);
main.mostCurrent._tag_subject = BA.ObjectToString("english");
 BA.debugLineNum = 378;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(33554432);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 379;BA.debugLine="Activity.LoadLayout(\"record_import\")";
Debug.ShouldStop(67108864);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("record_import")),main.mostCurrent.activityBA);
 BA.debugLineNum = 380;BA.debugLine="QuesFileName = \" \"";
Debug.ShouldStop(134217728);
main.mostCurrent._quesfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 381;BA.debugLine="AnsFileName = \" \"";
Debug.ShouldStop(268435456);
main.mostCurrent._ansfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 382;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _english_rev_click() throws Exception{
try {
		Debug.PushSubsStack("english_rev_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,656);
if (RapidSub.canDelegate("english_rev_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","english_rev_click");}
 BA.debugLineNum = 656;BA.debugLine="Private Sub english_rev_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 657;BA.debugLine="tag_subject= \"english\"";
Debug.ShouldStop(65536);
main.mostCurrent._tag_subject = BA.ObjectToString("english");
 BA.debugLineNum = 658;BA.debugLine="RevClick";
Debug.ShouldStop(131072);
_revclick();
 BA.debugLineNum = 659;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _get_tags(RemoteObject _subject) throws Exception{
try {
		Debug.PushSubsStack("get_tags (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,232);
if (RapidSub.canDelegate("get_tags")) { avanue.nvwa.main.remoteMe.runUserSub(false, "main","get_tags", _subject); return;}
ResumableSub_get_tags rsub = new ResumableSub_get_tags(null,_subject);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_get_tags extends BA.ResumableSub {
public ResumableSub_get_tags(avanue.nvwa.main parent,RemoteObject _subject) {
this.parent = parent;
this._subject = _subject;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
avanue.nvwa.main parent;
RemoteObject _subject;
RemoteObject _duplicatetest = RemoteObject.createImmutable(false);
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _tag = null;
RemoteObject _result = RemoteObject.createImmutable(0);
int step9;
int limit9;
int step33;
int limit33;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("get_tags (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,232);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("subject", _subject);
 BA.debugLineNum = 233;BA.debugLine="Do While True";
Debug.ShouldStop(256);
if (true) break;

case 1:
//do while
this.state = 41;
while (parent.mostCurrent.__c.getField(true,"True").<Boolean>get().booleanValue()) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 234;BA.debugLine="Dim DuplicateTest As Boolean = False";
Debug.ShouldStop(512);
_duplicatetest = parent.mostCurrent.__c.getField(true,"False");Debug.locals.put("DuplicateTest", _duplicatetest);Debug.locals.put("DuplicateTest", _duplicatetest);
 BA.debugLineNum = 235;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM tags wher";
Debug.ShouldStop(1024);
parent.mostCurrent._cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), parent.mostCurrent._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tags where Subject =  '"),_subject,RemoteObject.createImmutable("' ")))));
 BA.debugLineNum = 237;BA.debugLine="If cursor1.RowCount < 1 Then";
Debug.ShouldStop(4096);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("<",parent.mostCurrent._cursor1.runMethod(true,"getRowCount"),BA.numberCast(double.class, 1))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 238;BA.debugLine="Msgbox2Async(\"当前科目还没有任何tag\", \"Warning\", \"OK\", \"\"";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("当前科目还没有任何tag")),(Object)(BA.ObjectToCharSequence("Warning")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 7:
//C
this.state = 8;
;
 BA.debugLineNum = 240;BA.debugLine="Dim i As Int";
Debug.ShouldStop(32768);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 241;BA.debugLine="Dim tag(cursor1.RowCount) As String";
Debug.ShouldStop(65536);
_tag = RemoteObject.createNewArray ("String", new int[] {parent.mostCurrent._cursor1.runMethod(true,"getRowCount").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("tag", _tag);
 BA.debugLineNum = 242;BA.debugLine="For i = 0 To cursor1.RowCount - 1";
Debug.ShouldStop(131072);
if (true) break;

case 8:
//for
this.state = 11;
step9 = 1;
limit9 = RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._cursor1.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
Debug.locals.put("i", _i);
this.state = 42;
if (true) break;

case 42:
//C
this.state = 11;
if ((step9 > 0 && _i.<Integer>get().intValue() <= limit9) || (step9 < 0 && _i.<Integer>get().intValue() >= limit9)) this.state = 10;
if (true) break;

case 43:
//C
this.state = 42;
_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step9)) ;
Debug.locals.put("i", _i);
if (true) break;

case 10:
//C
this.state = 43;
 BA.debugLineNum = 243;BA.debugLine="cursor1.Position = i";
Debug.ShouldStop(262144);
parent.mostCurrent._cursor1.runMethod(true,"setPosition",_i);
 BA.debugLineNum = 244;BA.debugLine="tag(i) = cursor1.GetString(\"tag_name\")";
Debug.ShouldStop(524288);
_tag.setArrayElement (parent.mostCurrent._cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tag_name"))),_i);
 if (true) break;
if (true) break;

case 11:
//C
this.state = 12;
Debug.locals.put("i", _i);
;
 BA.debugLineNum = 247;BA.debugLine="options.Initialize";
Debug.ShouldStop(4194304);
parent.mostCurrent._options.runClassMethod (avanue.nvwa.b4xlisttemplate.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 248;BA.debugLine="options.AllowMultiSelection = True";
Debug.ShouldStop(8388608);
parent.mostCurrent._options.setField ("_allowmultiselection" /*RemoteObject*/ ,parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 249;BA.debugLine="options.Resize(300dip,200dip)";
Debug.ShouldStop(16777216);
parent.mostCurrent._options.runClassMethod (avanue.nvwa.b4xlisttemplate.class, "_resize" /*RemoteObject*/ ,(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 200)))));
 BA.debugLineNum = 250;BA.debugLine="options.Options = tag";
Debug.ShouldStop(33554432);
parent.mostCurrent._options.setField ("_options" /*RemoteObject*/ ,parent.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(_tag)));
 BA.debugLineNum = 252;BA.debugLine="Wait For (TagDialog.ShowTemplate(options, \"OK\", \"";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "get_tags"), parent.mostCurrent._tagdialog.runClassMethod (avanue.nvwa.b4xdialog.class, "_showtemplate" /*RemoteObject*/ ,(Object)((parent.mostCurrent._options)),(Object)(RemoteObject.createImmutable(("OK"))),(Object)(RemoteObject.createImmutable(("ADD"))),(Object)((RemoteObject.createImmutable("CANCEL")))));
this.state = 44;
return;
case 44:
//C
this.state = 12;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 253;BA.debugLine="Select Result";
Debug.ShouldStop(268435456);
if (true) break;

case 12:
//select
this.state = 40;
switch (BA.switchObjectToInt(_result,parent._xui.getField(true,"DialogResponse_Positive"),parent._xui.getField(true,"DialogResponse_Negative"),parent._xui.getField(true,"DialogResponse_Cancel"))) {
case 0: {
this.state = 14;
if (true) break;
}
case 1: {
this.state = 16;
if (true) break;
}
case 2: {
this.state = 39;
if (true) break;
}
}
if (true) break;

case 14:
//C
this.state = 40;
 BA.debugLineNum = 255;BA.debugLine="TagDialog.Show($\"选择的类别： ${options.SelectedItems}";
Debug.ShouldStop(1073741824);
parent.mostCurrent._tagdialog.runClassMethod (avanue.nvwa.b4xdialog.class, "_show" /*RemoteObject*/ ,(Object)(((RemoteObject.concat(RemoteObject.createImmutable("选择的类别： "),parent.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((parent.mostCurrent._options.getField(false,"_selecteditems" /*RemoteObject*/ ).getObject()))),RemoteObject.createImmutable(""))))),(Object)(RemoteObject.createImmutable(("OK"))),(Object)(RemoteObject.createImmutable((""))),(Object)((RemoteObject.createImmutable(""))));
 BA.debugLineNum = 256;BA.debugLine="Return";
Debug.ShouldStop(-2147483648);
if (true) return ;
 BA.debugLineNum = 257;BA.debugLine="Exit";
Debug.ShouldStop(1);
this.state = 40;
if (true) break;
 if (true) break;

case 16:
//C
this.state = 17;
 BA.debugLineNum = 259;BA.debugLine="InputTag.Initialize";
Debug.ShouldStop(4);
parent.mostCurrent._inputtag.runClassMethod (avanue.nvwa.b4xinputtemplate.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA);
 BA.debugLineNum = 260;BA.debugLine="InputTag.lblTitle.Text = \"添加标签\"";
Debug.ShouldStop(8);
parent.mostCurrent._inputtag.getField(false,"_lbltitle" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToCharSequence("添加标签"));
 BA.debugLineNum = 261;BA.debugLine="Wait For (TagDialog.ShowTemplate(InputTag, \"OK\",";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","complete", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "get_tags"), parent.mostCurrent._tagdialog.runClassMethod (avanue.nvwa.b4xdialog.class, "_showtemplate" /*RemoteObject*/ ,(Object)((parent.mostCurrent._inputtag)),(Object)(RemoteObject.createImmutable(("OK"))),(Object)(RemoteObject.createImmutable((""))),(Object)((RemoteObject.createImmutable("CANCEL")))));
this.state = 45;
return;
case 45:
//C
this.state = 17;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 262;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
Debug.ShouldStop(32);
if (true) break;

case 17:
//if
this.state = 37;
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent._xui.getField(true,"DialogResponse_Positive")))) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
 BA.debugLineNum = 263;BA.debugLine="If InputTag.Text = \"\" Then";
Debug.ShouldStop(64);
if (true) break;

case 20:
//if
this.state = 33;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._inputtag.getField(true,"_text" /*RemoteObject*/ ),BA.ObjectToString(""))) { 
this.state = 22;
}else {
this.state = 24;
}if (true) break;

case 22:
//C
this.state = 33;
 BA.debugLineNum = 264;BA.debugLine="Msgbox2Async(\"还没有填标签名称呢！！\", \"ERR\", \"OK\", \"\", \"";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("还没有填标签名称呢！！")),(Object)(BA.ObjectToCharSequence("ERR")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 265;BA.debugLine="Continue";
Debug.ShouldStop(256);
this.state = 40;
if (true) break;;
 if (true) break;

case 24:
//C
this.state = 25;
 BA.debugLineNum = 267;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM tags W";
Debug.ShouldStop(1024);
parent.mostCurrent._cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), parent.mostCurrent._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tags WHERE subject = '"),parent.mostCurrent._tag_subject,RemoteObject.createImmutable("'")))));
 BA.debugLineNum = 268;BA.debugLine="For i = 0 To cursor1.RowCount - 1";
Debug.ShouldStop(2048);
if (true) break;

case 25:
//for
this.state = 32;
step33 = 1;
limit33 = RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._cursor1.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
Debug.locals.put("i", _i);
this.state = 46;
if (true) break;

case 46:
//C
this.state = 32;
if ((step33 > 0 && _i.<Integer>get().intValue() <= limit33) || (step33 < 0 && _i.<Integer>get().intValue() >= limit33)) this.state = 27;
if (true) break;

case 47:
//C
this.state = 46;
_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step33)) ;
Debug.locals.put("i", _i);
if (true) break;

case 27:
//C
this.state = 28;
 BA.debugLineNum = 269;BA.debugLine="cursor1.Position = i";
Debug.ShouldStop(4096);
parent.mostCurrent._cursor1.runMethod(true,"setPosition",_i);
 BA.debugLineNum = 270;BA.debugLine="If InputTag.Text = cursor1.GetString(\"tag_nam";
Debug.ShouldStop(8192);
if (true) break;

case 28:
//if
this.state = 31;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._inputtag.getField(true,"_text" /*RemoteObject*/ ),parent.mostCurrent._cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("tag_name"))))) { 
this.state = 30;
}if (true) break;

case 30:
//C
this.state = 31;
 BA.debugLineNum = 271;BA.debugLine="Msgbox2Async(\"标签名重了！！\", \"ERR\", \"OK\", \"\", \"\",";
Debug.ShouldStop(16384);
parent.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("标签名重了！！")),(Object)(BA.ObjectToCharSequence("ERR")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), parent.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(parent.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 272;BA.debugLine="DuplicateTest = True";
Debug.ShouldStop(32768);
_duplicatetest = parent.mostCurrent.__c.getField(true,"True");Debug.locals.put("DuplicateTest", _duplicatetest);
 BA.debugLineNum = 273;BA.debugLine="Continue";
Debug.ShouldStop(65536);
this.state = 47;
if (true) break;;
 if (true) break;

case 31:
//C
this.state = 47;
;
 if (true) break;
if (true) break;

case 32:
//C
this.state = 33;
Debug.locals.put("i", _i);
;
 if (true) break;
;
 BA.debugLineNum = 277;BA.debugLine="If Not(DuplicateTest) Then";
Debug.ShouldStop(1048576);

case 33:
//if
this.state = 36;
if (parent.mostCurrent.__c.runMethod(true,"Not",(Object)(_duplicatetest)).<Boolean>get().booleanValue()) { 
this.state = 35;
}if (true) break;

case 35:
//C
this.state = 36;
 BA.debugLineNum = 278;BA.debugLine="SQL1.ExecNonQuery(\"INSERT INTO tags (tag_name,";
Debug.ShouldStop(2097152);
parent.mostCurrent._sql1.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO tags (tag_name,subject) VALUES ('"),parent.mostCurrent._inputtag.getField(true,"_text" /*RemoteObject*/ ),RemoteObject.createImmutable("','"),parent.mostCurrent._tag_subject,RemoteObject.createImmutable("')"))));
 BA.debugLineNum = 279;BA.debugLine="ToastMessageShow( tag_subject & \" label '\" & I";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(parent.mostCurrent._tag_subject,RemoteObject.createImmutable(" label '"),parent.mostCurrent._inputtag.getField(true,"_text" /*RemoteObject*/ ),RemoteObject.createImmutable("' added successfully")))),(Object)(parent.mostCurrent.__c.getField(true,"False")));
 if (true) break;

case 36:
//C
this.state = 37;
;
 if (true) break;

case 37:
//C
this.state = 40;
;
 if (true) break;

case 39:
//C
this.state = 40;
 BA.debugLineNum = 283;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return ;
 BA.debugLineNum = 284;BA.debugLine="Exit";
Debug.ShouldStop(134217728);
this.state = 40;
if (true) break;
 if (true) break;

case 40:
//C
this.state = 1;
;
 if (true) break;

case 41:
//C
this.state = -1;
;
 BA.debugLineNum = 287;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _complete(RemoteObject _result) throws Exception{
}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private camEx As CameraExClass";
main.mostCurrent._camex = RemoteObject.createNew ("avanue.nvwa.cameraexclass");
 //BA.debugLineNum = 27;BA.debugLine="Dim TouchImageView1 As TouchImageView";
main.mostCurrent._touchimageview1 = RemoteObject.createNew ("uk.co.martinpearman.b4a.touchimageview.TouchImageViewWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Dim ID As String";
main.mostCurrent._id = RemoteObject.createImmutable("");
 //BA.debugLineNum = 29;BA.debugLine="Dim SQL1 As SQL";
main.mostCurrent._sql1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");
 //BA.debugLineNum = 30;BA.debugLine="Dim cursor1 As Cursor";
main.mostCurrent._cursor1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim now As Long";
main._now = RemoteObject.createImmutable(0L);
 //BA.debugLineNum = 32;BA.debugLine="Public rp As RuntimePermissions";
main.mostCurrent._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 33;BA.debugLine="Public tag_subject As String";
main.mostCurrent._tag_subject = RemoteObject.createImmutable("");
 //BA.debugLineNum = 35;BA.debugLine="Dim Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Dim btnTakePicture As Button";
main.mostCurrent._btntakepicture = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private MyTaskIndex As Int";
main._mytaskindex = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 39;BA.debugLine="Public rp As RuntimePermissions";
main.mostCurrent._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");
 //BA.debugLineNum = 40;BA.debugLine="Dim q_count As Label";
main.mostCurrent._q_count = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Dim Q_Name , A_Name,T_Name  As String";
main.mostCurrent._q_name = RemoteObject.createImmutable("");
main.mostCurrent._a_name = RemoteObject.createImmutable("");
main.mostCurrent._t_name = RemoteObject.createImmutable("");
 //BA.debugLineNum = 42;BA.debugLine="Dim random_num  As Int";
main._random_num = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 43;BA.debugLine="Dim ImageView1 As ImageView";
main.mostCurrent._imageview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Dim Current_ID As Int";
main._current_id = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 45;BA.debugLine="Dim Current_Time_Create As String";
main.mostCurrent._current_time_create = RemoteObject.createImmutable("");
 //BA.debugLineNum = 46;BA.debugLine="Dim Current_Time_Modify As String";
main.mostCurrent._current_time_modify = RemoteObject.createImmutable("");
 //BA.debugLineNum = 47;BA.debugLine="Dim Current_Time_Delete As String";
main.mostCurrent._current_time_delete = RemoteObject.createImmutable("");
 //BA.debugLineNum = 48;BA.debugLine="Dim Current_Valid As Int";
main._current_valid = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 49;BA.debugLine="Dim Current_Subject As String";
main.mostCurrent._current_subject = RemoteObject.createImmutable("");
 //BA.debugLineNum = 50;BA.debugLine="Dim Current_Leval As Int";
main._current_leval = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 51;BA.debugLine="Dim Current_Grade As Int";
main._current_grade = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 52;BA.debugLine="Dim Current_Tags As String";
main.mostCurrent._current_tags = RemoteObject.createImmutable("");
 //BA.debugLineNum = 53;BA.debugLine="Dim Current_Question_Image As String";
main.mostCurrent._current_question_image = RemoteObject.createImmutable("");
 //BA.debugLineNum = 54;BA.debugLine="Dim Current_Answer_Image As String";
main.mostCurrent._current_answer_image = RemoteObject.createImmutable("");
 //BA.debugLineNum = 55;BA.debugLine="Dim Current_Correct_Times As Int";
main._current_correct_times = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 56;BA.debugLine="Dim Current_Incorrect_Times As Int";
main._current_incorrect_times = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 57;BA.debugLine="Dim Current_Last_Time As String";
main.mostCurrent._current_last_time = RemoteObject.createImmutable("");
 //BA.debugLineNum = 58;BA.debugLine="Dim QA_S As Int";
main._qa_s = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 59;BA.debugLine="Dim rule_never_do As Int = 1";
main._rule_never_do = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 60;BA.debugLine="Dim rule_correct As Int = 0";
main._rule_correct = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 61;BA.debugLine="Dim rule_incorrect As Int =1";
main._rule_incorrect = BA.numberCast(int.class, 1);
 //BA.debugLineNum = 62;BA.debugLine="Dim tags As String";
main.mostCurrent._tags = RemoteObject.createImmutable("");
 //BA.debugLineNum = 65;BA.debugLine="Dim FileDialog1 As FileDialog";
main.mostCurrent._filedialog1 = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs2.InputDialog.FileDialog");
 //BA.debugLineNum = 66;BA.debugLine="Dim QuesFilePath As String = File.DirRootExternal";
main.mostCurrent._quesfilepath = main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal");
 //BA.debugLineNum = 67;BA.debugLine="Dim QuesFileName As String = \" \"";
main.mostCurrent._quesfilename = BA.ObjectToString(" ");
 //BA.debugLineNum = 68;BA.debugLine="Dim AnsFilePath As String = File.DirRootExternal";
main.mostCurrent._ansfilepath = main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirRootExternal");
 //BA.debugLineNum = 69;BA.debugLine="Dim AnsFileName As String = \" \"";
main.mostCurrent._ansfilename = BA.ObjectToString(" ");
 //BA.debugLineNum = 70;BA.debugLine="Dim BitmapQues As Bitmap";
main.mostCurrent._bitmapques = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 71;BA.debugLine="Dim BitmapAns As Bitmap";
main.mostCurrent._bitmapans = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 //BA.debugLineNum = 74;BA.debugLine="Private ScrAns As ScrollView2D";
main.mostCurrent._scrans = RemoteObject.createNew ("flm.b4a.scrollview2d.ScrollView2DWrapper");
 //BA.debugLineNum = 75;BA.debugLine="Private ScrQues As ScrollView2D";
main.mostCurrent._scrques = RemoteObject.createNew ("flm.b4a.scrollview2d.ScrollView2DWrapper");
 //BA.debugLineNum = 78;BA.debugLine="Private btnImpAns As Button";
main.mostCurrent._btnimpans = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 79;BA.debugLine="Private btnImpComplete As Button";
main.mostCurrent._btnimpcomplete = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 80;BA.debugLine="Private btnImpQues As Button";
main.mostCurrent._btnimpques = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 83;BA.debugLine="Private add_tag_biology As RadioButton";
main.mostCurrent._add_tag_biology = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 84;BA.debugLine="Private add_tag_chemistry As RadioButton";
main.mostCurrent._add_tag_chemistry = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 85;BA.debugLine="Private add_tag_chinese As RadioButton";
main.mostCurrent._add_tag_chinese = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 86;BA.debugLine="Private add_tag_english As RadioButton";
main.mostCurrent._add_tag_english = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 87;BA.debugLine="Private add_tag_maths As RadioButton";
main.mostCurrent._add_tag_maths = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 88;BA.debugLine="Private add_tag_physics As RadioButton";
main.mostCurrent._add_tag_physics = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
 //BA.debugLineNum = 90;BA.debugLine="Private add_tag_edit As EditText";
main.mostCurrent._add_tag_edit = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 92;BA.debugLine="Dim FT As FileTools";
main.mostCurrent._ft = RemoteObject.createNew ("com.mathew.mmtools.filetools");
 //BA.debugLineNum = 94;BA.debugLine="Dim options As B4XListTemplate";
main.mostCurrent._options = RemoteObject.createNew ("avanue.nvwa.b4xlisttemplate");
 //BA.debugLineNum = 95;BA.debugLine="Private TagDialog As B4XDialog";
main.mostCurrent._tagdialog = RemoteObject.createNew ("avanue.nvwa.b4xdialog");
 //BA.debugLineNum = 96;BA.debugLine="Private Base As B4XView";
main.mostCurrent._base = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
 //BA.debugLineNum = 97;BA.debugLine="Private InputTag As B4XInputTemplate";
main.mostCurrent._inputtag = RemoteObject.createNew ("avanue.nvwa.b4xinputtemplate");
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _incorrect_click() throws Exception{
try {
		Debug.PushSubsStack("incorrect_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,731);
if (RapidSub.canDelegate("incorrect_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","incorrect_click");}
RemoteObject _tn = RemoteObject.createImmutable("");
RemoteObject _table_name = RemoteObject.createImmutable("");
 BA.debugLineNum = 731;BA.debugLine="Private Sub incorrect_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 732;BA.debugLine="Dim tn As String";
Debug.ShouldStop(134217728);
_tn = RemoteObject.createImmutable("");Debug.locals.put("tn", _tn);
 BA.debugLineNum = 733;BA.debugLine="Dim table_name As String";
Debug.ShouldStop(268435456);
_table_name = RemoteObject.createImmutable("");Debug.locals.put("table_name", _table_name);
 BA.debugLineNum = 734;BA.debugLine="table_name = tag_subject & \"_bank\"";
Debug.ShouldStop(536870912);
_table_name = RemoteObject.concat(main.mostCurrent._tag_subject,RemoteObject.createImmutable("_bank"));Debug.locals.put("table_name", _table_name);
 BA.debugLineNum = 736;BA.debugLine="Current_Incorrect_Times = Current_Incorrect_Times";
Debug.ShouldStop(-2147483648);
main._current_incorrect_times = RemoteObject.solve(new RemoteObject[] {main._current_incorrect_times,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 737;BA.debugLine="SQL1.ExecNonQuery(\"UPDATE '\"& table_name &\"' SET";
Debug.ShouldStop(1);
main.mostCurrent._sql1.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE '"),_table_name,RemoteObject.createImmutable("' SET Incorrect_Times = '"),main._current_incorrect_times,RemoteObject.createImmutable("' WHERE  ID = '"),main._current_id,RemoteObject.createImmutable("' "))));
 BA.debugLineNum = 739;BA.debugLine="tn = select_question(tag_subject)";
Debug.ShouldStop(4);
_tn = _select_question(main.mostCurrent._tag_subject);Debug.locals.put("tn", _tn);
 BA.debugLineNum = 741;BA.debugLine="Refresh_question(random_num)";
Debug.ShouldStop(16);
_refresh_question(main._random_num);
 BA.debugLineNum = 742;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _initializecamera() throws Exception{
try {
		Debug.PushSubsStack("InitializeCamera (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,545);
if (RapidSub.canDelegate("initializecamera")) { avanue.nvwa.main.remoteMe.runUserSub(false, "main","initializecamera"); return;}
ResumableSub_InitializeCamera rsub = new ResumableSub_InitializeCamera(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_InitializeCamera extends BA.ResumableSub {
public ResumableSub_InitializeCamera(avanue.nvwa.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
avanue.nvwa.main parent;
RemoteObject _permission = RemoteObject.createImmutable("");
RemoteObject _result = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("InitializeCamera (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,545);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 546;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_CAMERA)";
Debug.ShouldStop(2);
parent.mostCurrent._rp.runVoidMethod ("CheckAndRequest",main.processBA,(Object)(parent.mostCurrent._rp.getField(true,"PERMISSION_CAMERA")));
 BA.debugLineNum = 547;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","activity_permissionresult", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "main", "initializecamera"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_permission = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Permission", _permission);
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 548;BA.debugLine="If Result Then";
Debug.ShouldStop(8);
if (true) break;

case 1:
//if
this.state = 6;
if (_result.<Boolean>get().booleanValue()) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 549;BA.debugLine="camEx.Initialize(Panel1, frontCamera, Me, \"Camer";
Debug.ShouldStop(16);
parent.mostCurrent._camex.runClassMethod (avanue.nvwa.cameraexclass.class, "_initialize" /*RemoteObject*/ ,main.mostCurrent.activityBA,(Object)(parent.mostCurrent._panel1),(Object)(parent._frontcamera),(Object)(main.getObject()),(Object)(RemoteObject.createImmutable("Camera1")));
 BA.debugLineNum = 550;BA.debugLine="frontCamera = camEx.Front";
Debug.ShouldStop(32);
parent._frontcamera = parent.mostCurrent._camex.getField(true,"_front" /*RemoteObject*/ );
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 552;BA.debugLine="ToastMessageShow(\"No permission!!!\", True)";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No permission!!!")),(Object)(parent.mostCurrent.__c.getField(true,"True")));
 if (true) break;

case 6:
//C
this.state = -1;
;
 BA.debugLineNum = 554;BA.debugLine="End Sub";
Debug.ShouldStop(512);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _maths_click() throws Exception{
try {
		Debug.PushSubsStack("maths_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,323);
if (RapidSub.canDelegate("maths_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","maths_click");}
 BA.debugLineNum = 323;BA.debugLine="Private Sub maths_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 324;BA.debugLine="tag_subject= \"maths\"";
Debug.ShouldStop(8);
main.mostCurrent._tag_subject = BA.ObjectToString("maths");
 BA.debugLineNum = 325;BA.debugLine="CameraClick";
Debug.ShouldStop(16);
_cameraclick();
 BA.debugLineNum = 326;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _maths_imp_click() throws Exception{
try {
		Debug.PushSubsStack("maths_imp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,368);
if (RapidSub.canDelegate("maths_imp_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","maths_imp_click");}
 BA.debugLineNum = 368;BA.debugLine="Private Sub maths_imp_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 369;BA.debugLine="tag_subject= \"maths\"";
Debug.ShouldStop(65536);
main.mostCurrent._tag_subject = BA.ObjectToString("maths");
 BA.debugLineNum = 370;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(131072);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 371;BA.debugLine="Activity.LoadLayout(\"record_import\")";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("record_import")),main.mostCurrent.activityBA);
 BA.debugLineNum = 372;BA.debugLine="QuesFileName = \" \"";
Debug.ShouldStop(524288);
main.mostCurrent._quesfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 373;BA.debugLine="AnsFileName = \" \"";
Debug.ShouldStop(1048576);
main.mostCurrent._ansfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 374;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _maths_rev_click() throws Exception{
try {
		Debug.PushSubsStack("maths_rev_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,651);
if (RapidSub.canDelegate("maths_rev_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","maths_rev_click");}
 BA.debugLineNum = 651;BA.debugLine="Private Sub maths_rev_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 652;BA.debugLine="tag_subject= \"maths\"";
Debug.ShouldStop(2048);
main.mostCurrent._tag_subject = BA.ObjectToString("maths");
 BA.debugLineNum = 653;BA.debugLine="RevClick";
Debug.ShouldStop(4096);
_revclick();
 BA.debugLineNum = 654;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _now_string() throws Exception{
try {
		Debug.PushSubsStack("now_string (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,101);
if (RapidSub.canDelegate("now_string")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","now_string");}
RemoteObject _nows = RemoteObject.createImmutable("");
 BA.debugLineNum = 101;BA.debugLine="Private Sub now_string As String";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="now  = DateTime.Now";
Debug.ShouldStop(32);
main._now = main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow");
 BA.debugLineNum = 103;BA.debugLine="Dim nows As String";
Debug.ShouldStop(64);
_nows = RemoteObject.createImmutable("");Debug.locals.put("nows", _nows);
 BA.debugLineNum = 104;BA.debugLine="DateTime.DateFormat = \"YYYYMMdd.\"";
Debug.ShouldStop(128);
main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"setDateFormat",BA.ObjectToString("YYYYMMdd."));
 BA.debugLineNum = 106;BA.debugLine="DateTime.SetTimeZone(8)";
Debug.ShouldStop(512);
main.mostCurrent.__c.getField(false,"DateTime").runVoidMethod ("SetTimeZone",(Object)(BA.numberCast(double.class, 8)));
 BA.debugLineNum = 107;BA.debugLine="nows = DateTime.Date(now) & DateTime.Time(now)";
Debug.ShouldStop(1024);
_nows = RemoteObject.concat(main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Date",(Object)(main._now)),main.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"Time",(Object)(main._now)));Debug.locals.put("nows", _nows);
 BA.debugLineNum = 108;BA.debugLine="Return nows";
Debug.ShouldStop(2048);
if (true) return _nows;
 BA.debugLineNum = 109;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _physics_click() throws Exception{
try {
		Debug.PushSubsStack("physics_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,333);
if (RapidSub.canDelegate("physics_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","physics_click");}
 BA.debugLineNum = 333;BA.debugLine="Private Sub physics_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 334;BA.debugLine="tag_subject= \"physics\"";
Debug.ShouldStop(8192);
main.mostCurrent._tag_subject = BA.ObjectToString("physics");
 BA.debugLineNum = 335;BA.debugLine="CameraClick";
Debug.ShouldStop(16384);
_cameraclick();
 BA.debugLineNum = 336;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _physics_imp_click() throws Exception{
try {
		Debug.PushSubsStack("physics_imp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,384);
if (RapidSub.canDelegate("physics_imp_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","physics_imp_click");}
 BA.debugLineNum = 384;BA.debugLine="Private Sub physics_imp_Click";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 385;BA.debugLine="tag_subject= \"physics\"";
Debug.ShouldStop(1);
main.mostCurrent._tag_subject = BA.ObjectToString("physics");
 BA.debugLineNum = 386;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(2);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 387;BA.debugLine="Activity.LoadLayout(\"record_import\")";
Debug.ShouldStop(4);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("record_import")),main.mostCurrent.activityBA);
 BA.debugLineNum = 388;BA.debugLine="QuesFileName = \" \"";
Debug.ShouldStop(8);
main.mostCurrent._quesfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 389;BA.debugLine="AnsFileName = \" \"";
Debug.ShouldStop(16);
main.mostCurrent._ansfilename = BA.ObjectToString(" ");
 BA.debugLineNum = 390;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _physics_rev_click() throws Exception{
try {
		Debug.PushSubsStack("physics_rev_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,661);
if (RapidSub.canDelegate("physics_rev_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","physics_rev_click");}
 BA.debugLineNum = 661;BA.debugLine="Private Sub physics_rev_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 662;BA.debugLine="tag_subject= \"physics\"";
Debug.ShouldStop(2097152);
main.mostCurrent._tag_subject = BA.ObjectToString("physics");
 BA.debugLineNum = 663;BA.debugLine="RevClick";
Debug.ShouldStop(4194304);
_revclick();
 BA.debugLineNum = 664;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
xuiviewsutils_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("avanue.nvwa.main");
cameraexclass.myClass = BA.getDeviceClass ("avanue.nvwa.cameraexclass");
starter.myClass = BA.getDeviceClass ("avanue.nvwa.starter");
externalstorage.myClass = BA.getDeviceClass ("avanue.nvwa.externalstorage");
animatedcounter.myClass = BA.getDeviceClass ("avanue.nvwa.animatedcounter");
anotherprogressbar.myClass = BA.getDeviceClass ("avanue.nvwa.anotherprogressbar");
b4xbreadcrumb.myClass = BA.getDeviceClass ("avanue.nvwa.b4xbreadcrumb");
b4xcolortemplate.myClass = BA.getDeviceClass ("avanue.nvwa.b4xcolortemplate");
b4xcombobox.myClass = BA.getDeviceClass ("avanue.nvwa.b4xcombobox");
b4xdatetemplate.myClass = BA.getDeviceClass ("avanue.nvwa.b4xdatetemplate");
b4xdialog.myClass = BA.getDeviceClass ("avanue.nvwa.b4xdialog");
b4xfloattextfield.myClass = BA.getDeviceClass ("avanue.nvwa.b4xfloattextfield");
b4ximageview.myClass = BA.getDeviceClass ("avanue.nvwa.b4ximageview");
b4xinputtemplate.myClass = BA.getDeviceClass ("avanue.nvwa.b4xinputtemplate");
b4xlisttemplate.myClass = BA.getDeviceClass ("avanue.nvwa.b4xlisttemplate");
b4xloadingindicator.myClass = BA.getDeviceClass ("avanue.nvwa.b4xloadingindicator");
b4xlongtexttemplate.myClass = BA.getDeviceClass ("avanue.nvwa.b4xlongtexttemplate");
b4xplusminus.myClass = BA.getDeviceClass ("avanue.nvwa.b4xplusminus");
b4xradiobutton.myClass = BA.getDeviceClass ("avanue.nvwa.b4xradiobutton");
b4xsearchtemplate.myClass = BA.getDeviceClass ("avanue.nvwa.b4xsearchtemplate");
b4xseekbar.myClass = BA.getDeviceClass ("avanue.nvwa.b4xseekbar");
b4xsignaturetemplate.myClass = BA.getDeviceClass ("avanue.nvwa.b4xsignaturetemplate");
b4xswitch.myClass = BA.getDeviceClass ("avanue.nvwa.b4xswitch");
b4xtimedtemplate.myClass = BA.getDeviceClass ("avanue.nvwa.b4xtimedtemplate");
madewithlove.myClass = BA.getDeviceClass ("avanue.nvwa.madewithlove");
b4xformatter.myClass = BA.getDeviceClass ("avanue.nvwa.b4xformatter");
roundslider.myClass = BA.getDeviceClass ("avanue.nvwa.roundslider");
scrollinglabel.myClass = BA.getDeviceClass ("avanue.nvwa.scrollinglabel");
swiftbutton.myClass = BA.getDeviceClass ("avanue.nvwa.swiftbutton");
xuiviewsutils.myClass = BA.getDeviceClass ("avanue.nvwa.xuiviewsutils");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
main._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
 //BA.debugLineNum = 19;BA.debugLine="Private frontCamera As Boolean = False";
main._frontcamera = main.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 20;BA.debugLine="Private Storage As ExternalStorage";
main._storage = RemoteObject.createNew ("avanue.nvwa.externalstorage");
 //BA.debugLineNum = 21;BA.debugLine="Private Parents_Dir As ExternalFile";
main._parents_dir = RemoteObject.createNew ("avanue.nvwa.externalstorage._externalfile");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _quit_click() throws Exception{
try {
		Debug.PushSubsStack("quit_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,198);
if (RapidSub.canDelegate("quit_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","quit_click");}
 BA.debugLineNum = 198;BA.debugLine="Private Sub quit_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 199;BA.debugLine="ExitApplication";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("ExitApplication");
 BA.debugLineNum = 200;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _r_return_click() throws Exception{
try {
		Debug.PushSubsStack("r_return_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,620);
if (RapidSub.canDelegate("r_return_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","r_return_click");}
 BA.debugLineNum = 620;BA.debugLine="Private Sub r_return_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 621;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(4096);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 622;BA.debugLine="Activity.LoadLayout(\"subjects\")";
Debug.ShouldStop(8192);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("subjects")),main.mostCurrent.activityBA);
 BA.debugLineNum = 623;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _record_camera_click() throws Exception{
try {
		Debug.PushSubsStack("record_camera_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,350);
if (RapidSub.canDelegate("record_camera_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","record_camera_click");}
 BA.debugLineNum = 350;BA.debugLine="Private Sub record_camera_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 351;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(1073741824);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 352;BA.debugLine="Activity.LoadLayout (\"subjects\")";
Debug.ShouldStop(-2147483648);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("subjects")),main.mostCurrent.activityBA);
 BA.debugLineNum = 353;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _record_click() throws Exception{
try {
		Debug.PushSubsStack("record_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,202);
if (RapidSub.canDelegate("record_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","record_click");}
 BA.debugLineNum = 202;BA.debugLine="Private Sub record_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 203;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(1024);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 204;BA.debugLine="Activity.LoadLayout(\"record_choice\")";
Debug.ShouldStop(2048);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("record_choice")),main.mostCurrent.activityBA);
 BA.debugLineNum = 205;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _record_import_click() throws Exception{
try {
		Debug.PushSubsStack("record_import_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,355);
if (RapidSub.canDelegate("record_import_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","record_import_click");}
 BA.debugLineNum = 355;BA.debugLine="Private Sub record_import_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 356;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(8);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 357;BA.debugLine="Activity.LoadLayout(\"subjects_imp\")";
Debug.ShouldStop(16);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("subjects_imp")),main.mostCurrent.activityBA);
 BA.debugLineNum = 358;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _refresh_count(RemoteObject _subs) throws Exception{
try {
		Debug.PushSubsStack("refresh_count (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,571);
if (RapidSub.canDelegate("refresh_count")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","refresh_count", _subs);}
Debug.locals.put("subs", _subs);
 BA.debugLineNum = 571;BA.debugLine="Private Sub refresh_count(subs As String) As Int";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 572;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM \" & subs";
Debug.ShouldStop(134217728);
main.mostCurrent._cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main.mostCurrent._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),_subs,RemoteObject.createImmutable("_bank")))));
 BA.debugLineNum = 573;BA.debugLine="Return cursor1.RowCount";
Debug.ShouldStop(268435456);
if (true) return main.mostCurrent._cursor1.runMethod(true,"getRowCount");
 BA.debugLineNum = 574;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _refresh_question(RemoteObject _cn) throws Exception{
try {
		Debug.PushSubsStack("Refresh_question (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,712);
if (RapidSub.canDelegate("refresh_question")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","refresh_question", _cn);}
RemoteObject _question_file = RemoteObject.createImmutable("");
RemoteObject _bitmap1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("cn", _cn);
 BA.debugLineNum = 712;BA.debugLine="Private Sub Refresh_question(cn As Int)";
Debug.ShouldStop(128);
 BA.debugLineNum = 713;BA.debugLine="Dim Question_file As String";
Debug.ShouldStop(256);
_question_file = RemoteObject.createImmutable("");Debug.locals.put("Question_file", _question_file);
 BA.debugLineNum = 715;BA.debugLine="TouchImageView1.MinScale=0.25			'	default is 0.5";
Debug.ShouldStop(1024);
main.mostCurrent._touchimageview1.runMethod(true,"setMinScale",BA.numberCast(float.class, 0.25));
 BA.debugLineNum = 716;BA.debugLine="TouchImageView1.MaxScale=2				'	default is 1.5";
Debug.ShouldStop(2048);
main.mostCurrent._touchimageview1.runMethod(true,"setMaxScale",BA.numberCast(float.class, 2));
 BA.debugLineNum = 717;BA.debugLine="TouchImageView1.TranslatePadding=128dip	'	default";
Debug.ShouldStop(4096);
main.mostCurrent._touchimageview1.runMethod(true,"setTranslatePadding",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 128))));
 BA.debugLineNum = 719;BA.debugLine="Question_file = File.Combine(File.DirDefaultExter";
Debug.ShouldStop(16384);
_question_file = main.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(main.mostCurrent._cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Question_Image")))));Debug.locals.put("Question_file", _question_file);
 BA.debugLineNum = 722;BA.debugLine="Dim Bitmap1 As Bitmap";
Debug.ShouldStop(131072);
_bitmap1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("Bitmap1", _bitmap1);
 BA.debugLineNum = 723;BA.debugLine="Bitmap1.Initialize(File.DirDefaultExternal,cursor";
Debug.ShouldStop(262144);
_bitmap1.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(main.mostCurrent._cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Question_Image")))));
 BA.debugLineNum = 725;BA.debugLine="TouchImageView1.SetBitmap(Bitmap1)";
Debug.ShouldStop(1048576);
main.mostCurrent._touchimageview1.runVoidMethod ("SetBitmap",main.mostCurrent.activityBA,(Object)((_bitmap1.getObject())));
 BA.debugLineNum = 727;BA.debugLine="QA_S = 0";
Debug.ShouldStop(4194304);
main._qa_s = BA.numberCast(int.class, 0);
 BA.debugLineNum = 728;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _revclick() throws Exception{
try {
		Debug.PushSubsStack("RevClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,631);
if (RapidSub.canDelegate("revclick")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","revclick");}
RemoteObject _tn = RemoteObject.createImmutable("");
 BA.debugLineNum = 631;BA.debugLine="Sub RevClick";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 632;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(8388608);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 633;BA.debugLine="Activity.LoadLayout(\"review\")";
Debug.ShouldStop(16777216);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("review")),main.mostCurrent.activityBA);
 BA.debugLineNum = 634;BA.debugLine="Dim tn As String";
Debug.ShouldStop(33554432);
_tn = RemoteObject.createImmutable("");Debug.locals.put("tn", _tn);
 BA.debugLineNum = 635;BA.debugLine="tn = select_question(tag_subject)";
Debug.ShouldStop(67108864);
_tn = _select_question(main.mostCurrent._tag_subject);Debug.locals.put("tn", _tn);
 BA.debugLineNum = 636;BA.debugLine="If tn = \"\" Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",_tn,BA.ObjectToString(""))) { 
 BA.debugLineNum = 637;BA.debugLine="Msgbox2Async(\"没题啊\", \"ERR\", \"OK\", \"\", \"\", Null, T";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("没题啊")),(Object)(BA.ObjectToCharSequence("ERR")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 638;BA.debugLine="Return";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 641;BA.debugLine="TouchImageView1.Initialize(\"TouchImageView1\")";
Debug.ShouldStop(1);
main.mostCurrent._touchimageview1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("TouchImageView1")));
 BA.debugLineNum = 642;BA.debugLine="Activity.AddView(TouchImageView1, 0, 0, 100%x, 10";
Debug.ShouldStop(2);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._touchimageview1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 643;BA.debugLine="Refresh_question(random_num)";
Debug.ShouldStop(4);
_refresh_question(main._random_num);
 BA.debugLineNum = 644;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _review_click() throws Exception{
try {
		Debug.PushSubsStack("review_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,625);
if (RapidSub.canDelegate("review_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","review_click");}
 BA.debugLineNum = 625;BA.debugLine="Private Sub review_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 626;BA.debugLine="Activity.RemoveAllViews";
Debug.ShouldStop(131072);
main.mostCurrent._activity.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 627;BA.debugLine="Activity.LoadLayout(\"subjects_rev\")";
Debug.ShouldStop(262144);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("subjects_rev")),main.mostCurrent.activityBA);
 BA.debugLineNum = 629;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _select_question(RemoteObject _subject) throws Exception{
try {
		Debug.PushSubsStack("select_question (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,692);
if (RapidSub.canDelegate("select_question")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","select_question", _subject);}
RemoteObject _table_name = RemoteObject.createImmutable("");
Debug.locals.put("subject", _subject);
 BA.debugLineNum = 692;BA.debugLine="private Sub select_question(subject As String) As";
Debug.ShouldStop(524288);
 BA.debugLineNum = 693;BA.debugLine="Dim table_name As String";
Debug.ShouldStop(1048576);
_table_name = RemoteObject.createImmutable("");Debug.locals.put("table_name", _table_name);
 BA.debugLineNum = 694;BA.debugLine="table_name = subject & \"_bank\"";
Debug.ShouldStop(2097152);
_table_name = RemoteObject.concat(_subject,RemoteObject.createImmutable("_bank"));Debug.locals.put("table_name", _table_name);
 BA.debugLineNum = 695;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM \" & table";
Debug.ShouldStop(4194304);
main.mostCurrent._cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main.mostCurrent._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM "),_table_name))));
 BA.debugLineNum = 697;BA.debugLine="If cursor1.RowCount < 1 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("<",main.mostCurrent._cursor1.runMethod(true,"getRowCount"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 698;BA.debugLine="Msgbox2Async(\"找不到题目呢\", \"ERR\", \"OK\", \"\", \"\", Null";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("找不到题目呢")),(Object)(BA.ObjectToCharSequence("ERR")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 699;BA.debugLine="Return (\"\")";
Debug.ShouldStop(67108864);
if (true) return (RemoteObject.createImmutable(""));
 };
 BA.debugLineNum = 701;BA.debugLine="random_num = Rnd(0,cursor1.RowCount)";
Debug.ShouldStop(268435456);
main._random_num = main.mostCurrent.__c.runMethod(true,"Rnd",(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent._cursor1.runMethod(true,"getRowCount")));
 BA.debugLineNum = 702;BA.debugLine="cursor1.Position = random_num";
Debug.ShouldStop(536870912);
main.mostCurrent._cursor1.runMethod(true,"setPosition",main._random_num);
 BA.debugLineNum = 704;BA.debugLine="Current_ID = cursor1.GetInt(\"ID\")";
Debug.ShouldStop(-2147483648);
main._current_id = main.mostCurrent._cursor1.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("ID")));
 BA.debugLineNum = 705;BA.debugLine="Current_Correct_Times = cursor1.GetInt(\"Correct_T";
Debug.ShouldStop(1);
main._current_correct_times = main.mostCurrent._cursor1.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("Correct_Times")));
 BA.debugLineNum = 706;BA.debugLine="Current_Last_Time = cursor1.GetString(\"Last_Time\"";
Debug.ShouldStop(2);
main.mostCurrent._current_last_time = main.mostCurrent._cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Last_Time")));
 BA.debugLineNum = 708;BA.debugLine="Return(cursor1.GetString(\"Question_Image\"))";
Debug.ShouldStop(8);
if (true) return (main.mostCurrent._cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Question_Image"))));
 BA.debugLineNum = 710;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _submit_click() throws Exception{
try {
		Debug.PushSubsStack("submit_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,582);
if (RapidSub.canDelegate("submit_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","submit_click");}
RemoteObject _table_name = RemoteObject.createImmutable("");
RemoteObject _td = RemoteObject.createImmutable("");
RemoteObject _level = RemoteObject.createImmutable(0);
RemoteObject _newid = RemoteObject.createImmutable(0);
 BA.debugLineNum = 582;BA.debugLine="Private Sub submit_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 583;BA.debugLine="If  A_Name = \"\" Or Q_Name = \"\" Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",main.mostCurrent._a_name,BA.ObjectToString("")) || RemoteObject.solveBoolean("=",main.mostCurrent._q_name,BA.ObjectToString(""))) { 
 BA.debugLineNum = 584;BA.debugLine="Msgbox2Async(\"请先拍题目再拍答案\", \"ERR\", \"OK\", \"\", \"\", N";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("Msgbox2Async",(Object)(BA.ObjectToCharSequence("请先拍题目再拍答案")),(Object)(BA.ObjectToCharSequence("ERR")),(Object)(BA.ObjectToString("OK")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), main.mostCurrent.__c.getField(false,"Null")),main.processBA,(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 585;BA.debugLine="Return";
Debug.ShouldStop(256);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 587;BA.debugLine="Dim table_name As String";
Debug.ShouldStop(1024);
_table_name = RemoteObject.createImmutable("");Debug.locals.put("table_name", _table_name);
 BA.debugLineNum = 588;BA.debugLine="table_name = tag_subject & \"_bank\"";
Debug.ShouldStop(2048);
_table_name = RemoteObject.concat(main.mostCurrent._tag_subject,RemoteObject.createImmutable("_bank"));Debug.locals.put("table_name", _table_name);
 BA.debugLineNum = 589;BA.debugLine="Dim td As String";
Debug.ShouldStop(4096);
_td = RemoteObject.createImmutable("");Debug.locals.put("td", _td);
 BA.debugLineNum = 590;BA.debugLine="td = now_string";
Debug.ShouldStop(8192);
_td = _now_string();Debug.locals.put("td", _td);
 BA.debugLineNum = 591;BA.debugLine="Dim level As Int";
Debug.ShouldStop(16384);
_level = RemoteObject.createImmutable(0);Debug.locals.put("level", _level);
 BA.debugLineNum = 592;BA.debugLine="level = 1";
Debug.ShouldStop(32768);
_level = BA.numberCast(int.class, 1);Debug.locals.put("level", _level);
 BA.debugLineNum = 593;BA.debugLine="Dim NewID As Int = 0";
Debug.ShouldStop(65536);
_newid = BA.numberCast(int.class, 0);Debug.locals.put("NewID", _newid);Debug.locals.put("NewID", _newid);
 BA.debugLineNum = 594;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT ID FROM \" & tabl";
Debug.ShouldStop(131072);
main.mostCurrent._cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.sql.SQL.CursorWrapper"), main.mostCurrent._sql1.runMethod(false,"ExecQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT ID FROM "),_table_name))));
 BA.debugLineNum = 604;BA.debugLine="NewID = cursor1.RowCount + 1 ' add 1 to the ID nu";
Debug.ShouldStop(134217728);
_newid = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._cursor1.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("NewID", _newid);
 BA.debugLineNum = 605;BA.debugLine="get_tags(tag_subject)";
Debug.ShouldStop(268435456);
_get_tags(main.mostCurrent._tag_subject);
 BA.debugLineNum = 608;BA.debugLine="SQL1.ExecNonQuery(\"INSERT INTO \" & table_name &\"";
Debug.ShouldStop(-2147483648);
main.mostCurrent._sql1.runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO "),_table_name,RemoteObject.createImmutable("  (ID,Time_Create,Valid,Level,Question_Image,Answer_Image)  VALUES('"),_newid,RemoteObject.createImmutable("','"),_td,RemoteObject.createImmutable("','"),_td,RemoteObject.createImmutable("','"),_level,RemoteObject.createImmutable("','"),main.mostCurrent._q_name,RemoteObject.createImmutable(".jpg"),RemoteObject.createImmutable("','"),main.mostCurrent._a_name,RemoteObject.createImmutable(".jpg"),RemoteObject.createImmutable("')"))));
 BA.debugLineNum = 609;BA.debugLine="A_Name = \"\"";
Debug.ShouldStop(1);
main.mostCurrent._a_name = BA.ObjectToString("");
 BA.debugLineNum = 610;BA.debugLine="Q_Name = \"\"";
Debug.ShouldStop(2);
main.mostCurrent._q_name = BA.ObjectToString("");
 BA.debugLineNum = 612;BA.debugLine="q_count.Text = \"总题数：\" & refresh_count(tag_subject";
Debug.ShouldStop(8);
main.mostCurrent._q_count.runMethod(true,"setText",BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("总题数："),_refresh_count(main.mostCurrent._tag_subject))));
 BA.debugLineNum = 613;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _switch_qa_click() throws Exception{
try {
		Debug.PushSubsStack("switch_qa_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,744);
if (RapidSub.canDelegate("switch_qa_click")) { return avanue.nvwa.main.remoteMe.runUserSub(false, "main","switch_qa_click");}
RemoteObject _bitmap1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 BA.debugLineNum = 744;BA.debugLine="Private Sub switch_qa_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 745;BA.debugLine="Dim Bitmap1 As Bitmap";
Debug.ShouldStop(256);
_bitmap1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("Bitmap1", _bitmap1);
 BA.debugLineNum = 746;BA.debugLine="If QA_S =0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",main._qa_s,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 747;BA.debugLine="QA_S = 1";
Debug.ShouldStop(1024);
main._qa_s = BA.numberCast(int.class, 1);
 BA.debugLineNum = 748;BA.debugLine="Bitmap1.Initialize(File.DirDefaultExternal,curso";
Debug.ShouldStop(2048);
_bitmap1.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(main.mostCurrent._cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Answer_Image")))));
 }else {
 BA.debugLineNum = 750;BA.debugLine="QA_S = 0";
Debug.ShouldStop(8192);
main._qa_s = BA.numberCast(int.class, 0);
 BA.debugLineNum = 751;BA.debugLine="Bitmap1.Initialize(File.DirDefaultExternal,curso";
Debug.ShouldStop(16384);
_bitmap1.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirDefaultExternal")),(Object)(main.mostCurrent._cursor1.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("Question_Image")))));
 };
 BA.debugLineNum = 753;BA.debugLine="TouchImageView1.SetBitmap(Bitmap1)";
Debug.ShouldStop(65536);
main.mostCurrent._touchimageview1.runVoidMethod ("SetBitmap",main.mostCurrent.activityBA,(Object)((_bitmap1.getObject())));
 BA.debugLineNum = 754;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}