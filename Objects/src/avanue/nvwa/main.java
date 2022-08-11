package avanue.nvwa;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "avanue.nvwa", "avanue.nvwa.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "avanue.nvwa", "avanue.nvwa.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "avanue.nvwa.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (main) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public static boolean _frontcamera = false;
public static avanue.nvwa.externalstorage _storage = null;
public static avanue.nvwa.externalstorage._externalfile _parents_dir = null;
public avanue.nvwa.cameraexclass _camex = null;
public uk.co.martinpearman.b4a.touchimageview.TouchImageViewWrapper _touchimageview1 = null;
public static String _id = "";
public anywheresoftware.b4a.sql.SQL _sql1 = null;
public anywheresoftware.b4a.sql.SQL.CursorWrapper _cursor1 = null;
public static long _now = 0L;
public anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public static String _tag_subject = "";
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btntakepicture = null;
public static int _mytaskindex = 0;
public anywheresoftware.b4a.objects.LabelWrapper _q_count = null;
public static String _q_name = "";
public static String _a_name = "";
public static String _t_name = "";
public static int _random_num = 0;
public anywheresoftware.b4a.objects.ImageViewWrapper _imageview1 = null;
public static int _current_id = 0;
public static String _current_time_create = "";
public static String _current_time_modify = "";
public static String _current_time_delete = "";
public static int _current_valid = 0;
public static String _current_subject = "";
public static int _current_leval = 0;
public static int _current_grade = 0;
public static String _current_tags = "";
public static String _current_question_image = "";
public static String _current_answer_image = "";
public static int _current_correct_times = 0;
public static int _current_incorrect_times = 0;
public static String _current_last_time = "";
public static int _qa_s = 0;
public static int _rule_never_do = 0;
public static int _rule_correct = 0;
public static int _rule_incorrect = 0;
public static String _tags = "";
public anywheresoftware.b4a.agraham.dialogs2.InputDialog.FileDialog _filedialog1 = null;
public static String _quesfilepath = "";
public static String _quesfilename = "";
public static String _ansfilepath = "";
public static String _ansfilename = "";
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmapques = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmapans = null;
public flm.b4a.scrollview2d.ScrollView2DWrapper _scrans = null;
public flm.b4a.scrollview2d.ScrollView2DWrapper _scrques = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnimpans = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnimpcomplete = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnimpques = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _add_tag_biology = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _add_tag_chemistry = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _add_tag_chinese = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _add_tag_english = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _add_tag_maths = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _add_tag_physics = null;
public anywheresoftware.b4a.objects.EditTextWrapper _add_tag_edit = null;
public com.mathew.mmtools.filetools _ft = null;
public avanue.nvwa.b4xlisttemplate _options = null;
public avanue.nvwa.b4xdialog _tagdialog = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _base = null;
public avanue.nvwa.b4xinputtemplate _inputtag = null;
public b4a.example.dateutils _dateutils = null;
public avanue.nvwa.starter _starter = null;
public avanue.nvwa.xuiviewsutils _xuiviewsutils = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 125;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 126;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
 //BA.debugLineNum = 128;BA.debugLine="Storage.Initialize (Me, \"Storage\")";
_storage._initialize /*String*/ (processBA,main.getObject(),"Storage");
 //BA.debugLineNum = 129;BA.debugLine="Parents_Dir.Initialize";
_parents_dir.Initialize();
 //BA.debugLineNum = 130;BA.debugLine="Base = Activity";
mostCurrent._base = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._activity.getObject()));
 //BA.debugLineNum = 131;BA.debugLine="TagDialog.Initialize (Base)";
mostCurrent._tagdialog._initialize /*String*/ (mostCurrent.activityBA,mostCurrent._base);
 //BA.debugLineNum = 132;BA.debugLine="TagDialog.Title = \"选择题目类别\"";
mostCurrent._tagdialog._title /*Object*/  = (Object)("选择题目类别");
 //BA.debugLineNum = 133;BA.debugLine="options.Initialize";
mostCurrent._options._initialize /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 134;BA.debugLine="options.AllowMultiSelection = True";
mostCurrent._options._allowmultiselection /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 135;BA.debugLine="options.Resize(300dip,200dip)";
mostCurrent._options._resize /*String*/ (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
 //BA.debugLineNum = 136;BA.debugLine="InputTag.Initialize";
mostCurrent._inputtag._initialize /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 138;BA.debugLine="Activity.LoadLayout(\"main\")";
mostCurrent._activity.LoadLayout("main",mostCurrent.activityBA);
 //BA.debugLineNum = 145;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_READ_EXTERNAL_S";
mostCurrent._rp.CheckAndRequest(processBA,mostCurrent._rp.PERMISSION_READ_EXTERNAL_STORAGE);
 //BA.debugLineNum = 146;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_";
mostCurrent._rp.CheckAndRequest(processBA,mostCurrent._rp.PERMISSION_WRITE_EXTERNAL_STORAGE);
 //BA.debugLineNum = 147;BA.debugLine="rp.GetAllSafeDirsExternal (\"\")";
mostCurrent._rp.GetAllSafeDirsExternal("");
 //BA.debugLineNum = 148;BA.debugLine="If File.Exists(File.DirDefaultExternal ,\"nvwa.db";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"nvwa.db")==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 149;BA.debugLine="Try";
try { //BA.debugLineNum = 150;BA.debugLine="File.Copy(File.DirAssets,\"nvwa.db\",File.DirDef";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"nvwa.db",anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"nvwa.db");
 } 
       catch (Exception e19) {
			processBA.setLastException(e19); //BA.debugLineNum = 152;BA.debugLine="Msgbox2Async(\"Copy error\", \"ERR\", \"OK\", \"\", \"\"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Copy error"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 154;BA.debugLine="Msgbox2Async(\"nvwa not exits\", \"DEST\", \"OK\", \"\"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("nvwa not exits"),BA.ObjectToCharSequence("DEST"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 157;BA.debugLine="If SQL1.IsInitialized = False Then";
if (mostCurrent._sql1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 158;BA.debugLine="Try";
try { //BA.debugLineNum = 159;BA.debugLine="SQL1.Initialize(File.DirDefaultExternal, \"nvwa";
mostCurrent._sql1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"nvwa.db",anywheresoftware.b4a.keywords.Common.False);
 } 
       catch (Exception e27) {
			processBA.setLastException(e27); //BA.debugLineNum = 161;BA.debugLine="Msgbox2Async(\"DB Init Error\", \"ERR\", \"OK\", \"\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("DB Init Error"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 };
 };
 };
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 192;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 193;BA.debugLine="If camEx.IsInitialized Then";
if (mostCurrent._camex.IsInitialized /*boolean*/ ()) { 
 //BA.debugLineNum = 194;BA.debugLine="camEx.Release";
mostCurrent._camex._release /*String*/ ();
 };
 //BA.debugLineNum = 196;BA.debugLine="End Sub";
return "";
}
public static String  _activity_permissionresult(String _permission,boolean _result) throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Sub Activity_PermissionResult (Permission As Strin";
 //BA.debugLineNum = 183;BA.debugLine="If Result=False Then";
if (_result==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 184;BA.debugLine="Msgbox2Async(\"Permission Denied\", \"PD\", \"OK\", \"\"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Permission Denied"),BA.ObjectToCharSequence("PD"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 186;BA.debugLine="CallSubDelayed(Me, \"permission_done\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,main.getObject(),"permission_done");
 };
 //BA.debugLineNum = 189;BA.debugLine="Log(Permission)";
anywheresoftware.b4a.keywords.Common.LogImpl("1393223",_permission,0);
 //BA.debugLineNum = 190;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 177;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 180;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_add_click() throws Exception{
int _i = 0;
 //BA.debugLineNum = 846;BA.debugLine="Private Sub add_tag_add_Click";
 //BA.debugLineNum = 848;BA.debugLine="If add_tag_edit.Text = \"\" Then";
if ((mostCurrent._add_tag_edit.getText()).equals("")) { 
 //BA.debugLineNum = 849;BA.debugLine="Msgbox2Async(\"还没有填标签名称呢！！\", \"ERR\", \"OK\", \"\", \"\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("还没有填标签名称呢！！"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 850;BA.debugLine="Return";
if (true) return "";
 }else {
 //BA.debugLineNum = 852;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM tags WHE";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT * FROM tags WHERE subject = '"+mostCurrent._tag_subject+"'")));
 //BA.debugLineNum = 853;BA.debugLine="For i = 0 To cursor1.RowCount - 1";
{
final int step6 = 1;
final int limit6 = (int) (mostCurrent._cursor1.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 854;BA.debugLine="cursor1.Position = i";
mostCurrent._cursor1.setPosition(_i);
 //BA.debugLineNum = 855;BA.debugLine="If add_tag_edit.Text = cursor1.GetString(\"tag_n";
if ((mostCurrent._add_tag_edit.getText()).equals(mostCurrent._cursor1.GetString("tag_name"))) { 
 //BA.debugLineNum = 856;BA.debugLine="Msgbox2Async(\"标签名重了！！\", \"ERR\", \"OK\", \"\", \"\", N";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("标签名重了！！"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 857;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 };
 //BA.debugLineNum = 861;BA.debugLine="SQL1.ExecNonQuery(\"INSERT INTO tags (tag_name,sub";
mostCurrent._sql1.ExecNonQuery("INSERT INTO tags (tag_name,subject) VALUES ('"+mostCurrent._add_tag_edit.getText()+"','"+mostCurrent._tag_subject+"')");
 //BA.debugLineNum = 862;BA.debugLine="ToastMessageShow( tag_subject & \" label '\" & add";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(mostCurrent._tag_subject+" label '"+mostCurrent._add_tag_edit.getText()+"' added successfully"),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 863;BA.debugLine="add_tag_edit.Text = \"\"";
mostCurrent._add_tag_edit.setText(BA.ObjectToCharSequence(""));
 //BA.debugLineNum = 864;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_biology_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 840;BA.debugLine="Private Sub add_tag_biology_CheckedChange(Checked";
 //BA.debugLineNum = 841;BA.debugLine="If Checked = True Then";
if (_checked==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 842;BA.debugLine="tag_subject = \"biology\"";
mostCurrent._tag_subject = "biology";
 };
 //BA.debugLineNum = 844;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_chemistry_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 834;BA.debugLine="Private Sub add_tag_chemistry_CheckedChange(Checke";
 //BA.debugLineNum = 835;BA.debugLine="If Checked = True Then";
if (_checked==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 836;BA.debugLine="tag_subject = \"chemistry\"";
mostCurrent._tag_subject = "chemistry";
 };
 //BA.debugLineNum = 838;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_chinese_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 810;BA.debugLine="Private Sub add_tag_chinese_CheckedChange(Checked";
 //BA.debugLineNum = 811;BA.debugLine="If Checked = True Then";
if (_checked==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 812;BA.debugLine="tag_subject = \"chinese\"";
mostCurrent._tag_subject = "chinese";
 };
 //BA.debugLineNum = 814;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_english_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 822;BA.debugLine="Private Sub add_tag_english_CheckedChange(Checked";
 //BA.debugLineNum = 823;BA.debugLine="If Checked = True Then";
if (_checked==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 824;BA.debugLine="tag_subject = \"english\"";
mostCurrent._tag_subject = "english";
 };
 //BA.debugLineNum = 826;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_maths_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 816;BA.debugLine="Private Sub add_tag_maths_CheckedChange(Checked As";
 //BA.debugLineNum = 817;BA.debugLine="If Checked = True Then";
if (_checked==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 818;BA.debugLine="tag_subject = \"maths\"";
mostCurrent._tag_subject = "maths";
 };
 //BA.debugLineNum = 820;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_physics_checkedchange(boolean _checked) throws Exception{
 //BA.debugLineNum = 828;BA.debugLine="Private Sub add_tag_physics_CheckedChange(Checked";
 //BA.debugLineNum = 829;BA.debugLine="If Checked = True Then";
if (_checked==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 830;BA.debugLine="tag_subject = \"physics\"";
mostCurrent._tag_subject = "physics";
 };
 //BA.debugLineNum = 832;BA.debugLine="End Sub";
return "";
}
public static String  _addtag_click() throws Exception{
 //BA.debugLineNum = 798;BA.debugLine="Private Sub addtag_Click";
 //BA.debugLineNum = 799;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 800;BA.debugLine="Activity.LoadLayout(\"add_tag\")";
mostCurrent._activity.LoadLayout("add_tag",mostCurrent.activityBA);
 //BA.debugLineNum = 801;BA.debugLine="add_tag_chinese.Checked = True";
mostCurrent._add_tag_chinese.setChecked(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 802;BA.debugLine="add_tag_maths.Checked = False";
mostCurrent._add_tag_maths.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 803;BA.debugLine="add_tag_english.Checked = False";
mostCurrent._add_tag_english.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 804;BA.debugLine="add_tag_physics.Checked = False";
mostCurrent._add_tag_physics.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 805;BA.debugLine="add_tag_chemistry.Checked = False";
mostCurrent._add_tag_chemistry.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 806;BA.debugLine="add_tag_biology.Checked = False";
mostCurrent._add_tag_biology.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 807;BA.debugLine="tag_subject = \"chinese\"";
mostCurrent._tag_subject = "chinese";
 //BA.debugLineNum = 808;BA.debugLine="End Sub";
return "";
}
public static String  _answer_click() throws Exception{
 //BA.debugLineNum = 579;BA.debugLine="Private Sub answer_Click";
 //BA.debugLineNum = 580;BA.debugLine="A_Name = now_string";
mostCurrent._a_name = _now_string();
 //BA.debugLineNum = 581;BA.debugLine="T_Name = A_Name";
mostCurrent._t_name = mostCurrent._a_name;
 //BA.debugLineNum = 582;BA.debugLine="camEx.TakePicture";
mostCurrent._camex._takepicture /*String*/ ();
 //BA.debugLineNum = 583;BA.debugLine="End Sub";
return "";
}
public static String  _back_click() throws Exception{
 //BA.debugLineNum = 207;BA.debugLine="Private Sub back_Click";
 //BA.debugLineNum = 208;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 209;BA.debugLine="Activity.LoadLayout(\"main\")";
mostCurrent._activity.LoadLayout("main",mostCurrent.activityBA);
 //BA.debugLineNum = 210;BA.debugLine="End Sub";
return "";
}
public static String  _back_rev_click() throws Exception{
 //BA.debugLineNum = 760;BA.debugLine="Private Sub back_rev_Click";
 //BA.debugLineNum = 761;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 762;BA.debugLine="Activity.LoadLayout(\"subjects_rev\")";
mostCurrent._activity.LoadLayout("subjects_rev",mostCurrent.activityBA);
 //BA.debugLineNum = 763;BA.debugLine="End Sub";
return "";
}
public static String  _back_rule_click() throws Exception{
 //BA.debugLineNum = 790;BA.debugLine="Private Sub back_rule_Click";
 //BA.debugLineNum = 792;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 793;BA.debugLine="Activity.LoadLayout(\"review\")";
mostCurrent._activity.LoadLayout("review",mostCurrent.activityBA);
 //BA.debugLineNum = 794;BA.debugLine="End Sub";
return "";
}
public static String  _biology_click() throws Exception{
 //BA.debugLineNum = 344;BA.debugLine="Private Sub biology_Click";
 //BA.debugLineNum = 345;BA.debugLine="tag_subject= \"biology\"";
mostCurrent._tag_subject = "biology";
 //BA.debugLineNum = 346;BA.debugLine="CameraClick";
_cameraclick();
 //BA.debugLineNum = 347;BA.debugLine="End Sub";
return "";
}
public static String  _biology_imp_click() throws Exception{
 //BA.debugLineNum = 401;BA.debugLine="Private Sub biology_imp_Click";
 //BA.debugLineNum = 402;BA.debugLine="tag_subject= \"biology\"";
mostCurrent._tag_subject = "biology";
 //BA.debugLineNum = 403;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 404;BA.debugLine="Activity.LoadLayout(\"record_import\")";
mostCurrent._activity.LoadLayout("record_import",mostCurrent.activityBA);
 //BA.debugLineNum = 405;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
 //BA.debugLineNum = 406;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
 //BA.debugLineNum = 407;BA.debugLine="End Sub";
return "";
}
public static String  _biology_rev_click() throws Exception{
 //BA.debugLineNum = 675;BA.debugLine="Private Sub biology_rev_Click";
 //BA.debugLineNum = 676;BA.debugLine="tag_subject= \"biology\"";
mostCurrent._tag_subject = "biology";
 //BA.debugLineNum = 677;BA.debugLine="RevClick";
_revclick();
 //BA.debugLineNum = 678;BA.debugLine="End Sub";
return "";
}
public static String  _btnflash_click() throws Exception{
float[] _f = null;
anywheresoftware.b4a.objects.collections.List _flashmodes = null;
String _flash = "";
 //BA.debugLineNum = 559;BA.debugLine="Private Sub btnFlash_Click";
 //BA.debugLineNum = 560;BA.debugLine="Dim f() As Float = camEx.GetFocusDistances";
_f = mostCurrent._camex._getfocusdistances /*float[]*/ ();
 //BA.debugLineNum = 561;BA.debugLine="Log(f(0) & \", \" & f(1) & \", \" & f(2))";
anywheresoftware.b4a.keywords.Common.LogImpl("12293762",BA.NumberToString(_f[(int) (0)])+", "+BA.NumberToString(_f[(int) (1)])+", "+BA.NumberToString(_f[(int) (2)]),0);
 //BA.debugLineNum = 562;BA.debugLine="Dim flashModes As List = camEx.GetSupportedFlashM";
_flashmodes = new anywheresoftware.b4a.objects.collections.List();
_flashmodes = mostCurrent._camex._getsupportedflashmodes /*anywheresoftware.b4a.objects.collections.List*/ ();
 //BA.debugLineNum = 563;BA.debugLine="If flashModes.IsInitialized = False Then";
if (_flashmodes.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 564;BA.debugLine="ToastMessageShow(\"Flash not supported.\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Flash not supported."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 565;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 567;BA.debugLine="Dim flash As String = flashModes.Get((flashModes.";
_flash = BA.ObjectToString(_flashmodes.Get((int) ((_flashmodes.IndexOf((Object)(mostCurrent._camex._getflashmode /*String*/ ()))+1)%_flashmodes.getSize())));
 //BA.debugLineNum = 568;BA.debugLine="camEx.SetFlashMode(flash)";
mostCurrent._camex._setflashmode /*String*/ (_flash);
 //BA.debugLineNum = 569;BA.debugLine="ToastMessageShow(flash, False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_flash),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 570;BA.debugLine="camEx.CommitParameters";
mostCurrent._camex._commitparameters /*String*/ ();
 //BA.debugLineNum = 572;BA.debugLine="End Sub";
return "";
}
public static String  _btnimpans_click() throws Exception{
int _answ = 0;
 //BA.debugLineNum = 428;BA.debugLine="Private Sub btnImpAns_Click";
 //BA.debugLineNum = 429;BA.debugLine="Dim Answ As Int";
_answ = 0;
 //BA.debugLineNum = 431;BA.debugLine="FileDialog1.FilePath = AnsFilePath";
mostCurrent._filedialog1.setFilePath(mostCurrent._ansfilepath);
 //BA.debugLineNum = 432;BA.debugLine="Answ = FileDialog1.Show(\"Databases\",\"Load\",\"Cance";
_answ = mostCurrent._filedialog1.Show(BA.ObjectToCharSequence("Databases"),"Load","Cancel","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 434;BA.debugLine="Select Answ";
switch (BA.switchObjectToInt(_answ,anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE,anywheresoftware.b4a.keywords.Common.DialogResponse.CANCEL)) {
case 0: {
 //BA.debugLineNum = 436;BA.debugLine="AnsFileName = FileDialog1.ChosenName";
mostCurrent._ansfilename = mostCurrent._filedialog1.getChosenName();
 //BA.debugLineNum = 437;BA.debugLine="AnsFilePath = FileDialog1.FilePath";
mostCurrent._ansfilepath = mostCurrent._filedialog1.getFilePath();
 //BA.debugLineNum = 438;BA.debugLine="ScrAns.Panel.SetBackgroundImage(LoadBitmap(AnsF";
mostCurrent._scrans.getPanel().SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(mostCurrent._ansfilepath,mostCurrent._ansfilename).getObject()));
 //BA.debugLineNum = 439;BA.debugLine="BitmapAns.Initialize(AnsFilePath, AnsFileName)";
mostCurrent._bitmapans.Initialize(mostCurrent._ansfilepath,mostCurrent._ansfilename);
 //BA.debugLineNum = 440;BA.debugLine="ScrAns.Panel.SetBackgroundImage(BitmapAns)";
mostCurrent._scrans.getPanel().SetBackgroundImageNew((android.graphics.Bitmap)(mostCurrent._bitmapans.getObject()));
 //BA.debugLineNum = 441;BA.debugLine="ScrAns.Panel.Height = Floor(BitmapAns.Height /";
mostCurrent._scrans.getPanel().setHeight((int) (anywheresoftware.b4a.keywords.Common.Floor(mostCurrent._bitmapans.getHeight()/(double)5)*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
 //BA.debugLineNum = 442;BA.debugLine="ScrAns.Panel.Width = Floor(BitmapAns.Width / 5)";
mostCurrent._scrans.getPanel().setWidth((int) (anywheresoftware.b4a.keywords.Common.Floor(mostCurrent._bitmapans.getWidth()/(double)5)*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
 break; }
case 1: {
 break; }
}
;
 //BA.debugLineNum = 446;BA.debugLine="End Sub";
return "";
}
public static String  _btnimpcomplete_click() throws Exception{
String _td = "";
int _level = 0;
int _newid = 0;
String _quesfilenamenew = "";
String _ansfilenamenew = "";
 //BA.debugLineNum = 448;BA.debugLine="Private Sub btnImpComplete_Click";
 //BA.debugLineNum = 449;BA.debugLine="If QuesFileName = \" \" Or AnsFileName = \" \" Then";
if ((mostCurrent._quesfilename).equals(" ") || (mostCurrent._ansfilename).equals(" ")) { 
 //BA.debugLineNum = 450;BA.debugLine="Msgbox2Async(\"没选完呢！！\", \"ERR\", \"OK\", \"\", \"\", Null";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("没选完呢！！"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 451;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 453;BA.debugLine="Dim td As String";
_td = "";
 //BA.debugLineNum = 454;BA.debugLine="td = now_string";
_td = _now_string();
 //BA.debugLineNum = 455;BA.debugLine="Dim level As Int";
_level = 0;
 //BA.debugLineNum = 456;BA.debugLine="level = 1";
_level = (int) (1);
 //BA.debugLineNum = 457;BA.debugLine="Dim NewID As Int = 0";
_newid = (int) (0);
 //BA.debugLineNum = 458;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT ID FROM \" & tag_";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT ID FROM "+mostCurrent._tag_subject+"_bank")));
 //BA.debugLineNum = 459;BA.debugLine="NewID = cursor1.RowCount + 1 ' add 1 to the ID nu";
_newid = (int) (mostCurrent._cursor1.getRowCount()+1);
 //BA.debugLineNum = 495;BA.debugLine="Dim QuesFileNameNew As String = td & \"_1.\" & FT.F";
_quesfilenamenew = _td+"_1."+mostCurrent._ft._fileextension(mostCurrent._quesfilename);
 //BA.debugLineNum = 496;BA.debugLine="Dim AnsFileNameNew As String = td & \"_2.\" & FT.Fi";
_ansfilenamenew = _td+"_2."+mostCurrent._ft._fileextension(mostCurrent._ansfilename);
 //BA.debugLineNum = 497;BA.debugLine="Try";
try { //BA.debugLineNum = 498;BA.debugLine="File.Copy(QuesFilePath,QuesFileName,File.DirDefa";
anywheresoftware.b4a.keywords.Common.File.Copy(mostCurrent._quesfilepath,mostCurrent._quesfilename,anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),_quesfilenamenew);
 //BA.debugLineNum = 499;BA.debugLine="File.Copy(AnsFilePath,AnsFileName,File.DirDefaul";
anywheresoftware.b4a.keywords.Common.File.Copy(mostCurrent._ansfilepath,mostCurrent._ansfilename,anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),_ansfilenamenew);
 } 
       catch (Exception e18) {
			processBA.setLastException(e18); //BA.debugLineNum = 501;BA.debugLine="Msgbox2Async(\"未能成功复制文件\", \"ERR\", \"OK\", \"\", \"\", Nu";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("未能成功复制文件"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 502;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("12031670",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
 //BA.debugLineNum = 504;BA.debugLine="SQL1.ExecNonQuery(\"INSERT INTO \" & tag_subject &";
mostCurrent._sql1.ExecNonQuery("INSERT INTO "+mostCurrent._tag_subject+"_bank"+" (ID,Time_Create,Valid,Level,Question_Image,Answer_Image)  VALUES('"+BA.NumberToString(_newid)+"','"+_td+"','"+_td+"','"+BA.NumberToString(_level)+"','"+_quesfilenamenew+"','"+_ansfilenamenew+"')");
 //BA.debugLineNum = 506;BA.debugLine="get_tags(tag_subject)'添加标签";
_get_tags(mostCurrent._tag_subject);
 //BA.debugLineNum = 509;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
 //BA.debugLineNum = 510;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
 //BA.debugLineNum = 511;BA.debugLine="QuesFileNameNew = \" \"";
_quesfilenamenew = " ";
 //BA.debugLineNum = 512;BA.debugLine="AnsFileNameNew = \" \"";
_ansfilenamenew = " ";
 //BA.debugLineNum = 515;BA.debugLine="ScrQues.Panel.SetBackgroundImage(LoadBitmap(File.";
mostCurrent._scrques.getPanel().SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"import_empty.jpg").getObject()));
 //BA.debugLineNum = 516;BA.debugLine="ScrAns.Panel.SetBackgroundImage(LoadBitmap(File.D";
mostCurrent._scrans.getPanel().SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"import_empty.jpg").getObject()));
 //BA.debugLineNum = 517;BA.debugLine="ScrQues.Panel.Height = 220dip";
mostCurrent._scrques.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (220)));
 //BA.debugLineNum = 518;BA.debugLine="ScrQues.Panel.Width = 220dip";
mostCurrent._scrques.getPanel().setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (220)));
 //BA.debugLineNum = 519;BA.debugLine="ScrAns.Panel.Height = 220dip";
mostCurrent._scrans.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (220)));
 //BA.debugLineNum = 520;BA.debugLine="ScrAns.Panel.Width = 220dip";
mostCurrent._scrans.getPanel().setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (220)));
 //BA.debugLineNum = 521;BA.debugLine="End Sub";
return "";
}
public static String  _btnimpques_click() throws Exception{
int _answ = 0;
 //BA.debugLineNum = 409;BA.debugLine="Private Sub btnImpQues_Click";
 //BA.debugLineNum = 410;BA.debugLine="Dim Answ As Int";
_answ = 0;
 //BA.debugLineNum = 412;BA.debugLine="FileDialog1.FilePath = QuesFilePath '弹出选择窗口";
mostCurrent._filedialog1.setFilePath(mostCurrent._quesfilepath);
 //BA.debugLineNum = 413;BA.debugLine="Answ = FileDialog1.Show(\"Databases\",\"Load\",\"Cance";
_answ = mostCurrent._filedialog1.Show(BA.ObjectToCharSequence("Databases"),"Load","Cancel","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 415;BA.debugLine="Select Answ";
switch (BA.switchObjectToInt(_answ,anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE,anywheresoftware.b4a.keywords.Common.DialogResponse.CANCEL)) {
case 0: {
 //BA.debugLineNum = 417;BA.debugLine="QuesFileName = FileDialog1.ChosenName";
mostCurrent._quesfilename = mostCurrent._filedialog1.getChosenName();
 //BA.debugLineNum = 418;BA.debugLine="QuesFilePath = FileDialog1.FilePath";
mostCurrent._quesfilepath = mostCurrent._filedialog1.getFilePath();
 //BA.debugLineNum = 419;BA.debugLine="BitmapQues.Initialize(QuesFilePath, QuesFileNam";
mostCurrent._bitmapques.Initialize(mostCurrent._quesfilepath,mostCurrent._quesfilename);
 //BA.debugLineNum = 420;BA.debugLine="ScrQues.Panel.SetBackgroundImage(BitmapQues)";
mostCurrent._scrques.getPanel().SetBackgroundImageNew((android.graphics.Bitmap)(mostCurrent._bitmapques.getObject()));
 //BA.debugLineNum = 421;BA.debugLine="ScrQues.Panel.Height = Floor(BitmapQues.Height";
mostCurrent._scrques.getPanel().setHeight((int) (anywheresoftware.b4a.keywords.Common.Floor(mostCurrent._bitmapques.getHeight()/(double)5)*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
 //BA.debugLineNum = 422;BA.debugLine="ScrQues.Panel.Width = Floor(BitmapQues.Width /";
mostCurrent._scrques.getPanel().setWidth((int) (anywheresoftware.b4a.keywords.Common.Floor(mostCurrent._bitmapques.getWidth()/(double)5)*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
 break; }
case 1: {
 break; }
}
;
 //BA.debugLineNum = 426;BA.debugLine="End Sub";
return "";
}
public static String  _btntakepicture_click() throws Exception{
 //BA.debugLineNum = 540;BA.debugLine="Sub btnTakePicture_Click";
 //BA.debugLineNum = 542;BA.debugLine="Q_Name = now_string";
mostCurrent._q_name = _now_string();
 //BA.debugLineNum = 543;BA.debugLine="T_Name = Q_Name";
mostCurrent._t_name = mostCurrent._q_name;
 //BA.debugLineNum = 544;BA.debugLine="camEx.TakePicture";
mostCurrent._camex._takepicture /*String*/ ();
 //BA.debugLineNum = 545;BA.debugLine="End Sub";
return "";
}
public static String  _camera1_focusdone(boolean _success) throws Exception{
 //BA.debugLineNum = 225;BA.debugLine="Sub Camera1_FocusDone(Success As Boolean)";
 //BA.debugLineNum = 226;BA.debugLine="Msgbox2Async(\"Mamera focus down\", \"FD\", \"OK\", \"\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Mamera focus down"),BA.ObjectToCharSequence("FD"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 227;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 228;BA.debugLine="Msgbox2Async(\"Camera focus down\", \"Focus DONE\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Camera focus down"),BA.ObjectToCharSequence("Focus DONE"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 230;BA.debugLine="End Sub";
return "";
}
public static String  _camera1_picturetaken(byte[] _data) throws Exception{
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 525;BA.debugLine="Sub Camera1_PictureTaken (Data() As Byte)";
 //BA.debugLineNum = 527;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
 //BA.debugLineNum = 530;BA.debugLine="camEx.SavePictureToFile(Data, File.DirDefaultExte";
mostCurrent._camex._savepicturetofile /*String*/ (_data,anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),mostCurrent._t_name+".jpg");
 //BA.debugLineNum = 531;BA.debugLine="camEx.StartPreview 'restart preview";
mostCurrent._camex._startpreview /*String*/ ();
 //BA.debugLineNum = 533;BA.debugLine="ToastMessageShow(\"Image saved: \" & File.Combine(F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Image saved: "+anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),mostCurrent._t_name+".jpg")),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 534;BA.debugLine="btnTakePicture.Enabled = True";
mostCurrent._btntakepicture.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 536;BA.debugLine="End Sub";
return "";
}
public static String  _camera1_ready(boolean _success) throws Exception{
 //BA.debugLineNum = 212;BA.debugLine="Sub Camera1_Ready (Success As Boolean)";
 //BA.debugLineNum = 213;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 214;BA.debugLine="camEx.SetJpegQuality(90)";
mostCurrent._camex._setjpegquality /*String*/ ((int) (90));
 //BA.debugLineNum = 215;BA.debugLine="camEx.SetContinuousAutoFocus";
mostCurrent._camex._setcontinuousautofocus /*String*/ ();
 //BA.debugLineNum = 216;BA.debugLine="camEx.CommitParameters";
mostCurrent._camex._commitparameters /*String*/ ();
 //BA.debugLineNum = 217;BA.debugLine="camEx.StartPreview";
mostCurrent._camex._startpreview /*String*/ ();
 //BA.debugLineNum = 218;BA.debugLine="Log(camEx.GetPreviewSize)";
anywheresoftware.b4a.keywords.Common.LogImpl("1720902",BA.ObjectToString(mostCurrent._camex._getpreviewsize /*avanue.nvwa.cameraexclass._camerasize*/ ()),0);
 }else {
 //BA.debugLineNum = 220;BA.debugLine="ToastMessageShow(\"Cannot open camera.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Cannot open camera."),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return "";
}
public static String  _cameraclick() throws Exception{
 //BA.debugLineNum = 294;BA.debugLine="Sub CameraClick";
 //BA.debugLineNum = 296;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 298;BA.debugLine="Activity.LoadLayout (\"record\")";
mostCurrent._activity.LoadLayout("record",mostCurrent.activityBA);
 //BA.debugLineNum = 299;BA.debugLine="Try";
try { //BA.debugLineNum = 300;BA.debugLine="InitializeCamera";
_initializecamera();
 } 
       catch (Exception e6) {
			processBA.setLastException(e6); //BA.debugLineNum = 302;BA.debugLine="Msgbox2Async(\"camera init err\", \"err\", \"OK\", \"\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("camera init err"),BA.ObjectToCharSequence("err"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 304;BA.debugLine="q_count.Text = \"总题数：\" & refresh_count(tag_subject";
mostCurrent._q_count.setText(BA.ObjectToCharSequence("总题数："+BA.NumberToString(_refresh_count(mostCurrent._tag_subject))));
 //BA.debugLineNum = 317;BA.debugLine="End Sub";
return "";
}
public static String  _cancel_click() throws Exception{
 //BA.debugLineNum = 619;BA.debugLine="Private Sub cancel_Click";
 //BA.debugLineNum = 620;BA.debugLine="A_Name = \"\"";
mostCurrent._a_name = "";
 //BA.debugLineNum = 621;BA.debugLine="Q_Name = \"\"";
mostCurrent._q_name = "";
 //BA.debugLineNum = 622;BA.debugLine="End Sub";
return "";
}
public static String  _change_rules_click() throws Exception{
 //BA.debugLineNum = 769;BA.debugLine="Private Sub change_rules_Click";
 //BA.debugLineNum = 770;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM \" & tag_s";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT * FROM "+mostCurrent._tag_subject+"_bank")));
 //BA.debugLineNum = 772;BA.debugLine="If cursor1.RowCount < 1 Then";
if (mostCurrent._cursor1.getRowCount()<1) { 
 //BA.debugLineNum = 773;BA.debugLine="Msgbox2Async(\"找不到题目呢\", \"ERR\", \"OK\", \"\", \"\", Null";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("找不到题目呢"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 774;BA.debugLine="Return (\"\")";
if (true) return ("");
 };
 //BA.debugLineNum = 777;BA.debugLine="random_num = Rnd(0,cursor1.RowCount)";
_random_num = anywheresoftware.b4a.keywords.Common.Rnd((int) (0),mostCurrent._cursor1.getRowCount());
 //BA.debugLineNum = 778;BA.debugLine="cursor1.Position = random_num";
mostCurrent._cursor1.setPosition(_random_num);
 //BA.debugLineNum = 780;BA.debugLine="Current_ID = cursor1.GetInt(\"ID\")";
_current_id = mostCurrent._cursor1.GetInt("ID");
 //BA.debugLineNum = 781;BA.debugLine="Current_Correct_Times = cursor1.GetInt(\"Correct_T";
_current_correct_times = mostCurrent._cursor1.GetInt("Correct_Times");
 //BA.debugLineNum = 782;BA.debugLine="Current_Last_Time = cursor1.GetString(\"Last_Time\"";
mostCurrent._current_last_time = mostCurrent._cursor1.GetString("Last_Time");
 //BA.debugLineNum = 784;BA.debugLine="Return(cursor1.GetString(\"Question_Image\"))";
if (true) return (mostCurrent._cursor1.GetString("Question_Image"));
 //BA.debugLineNum = 785;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 786;BA.debugLine="Activity.LoadLayout(\"select_rule\")";
mostCurrent._activity.LoadLayout("select_rule",mostCurrent.activityBA);
 //BA.debugLineNum = 788;BA.debugLine="End Sub";
return "";
}
public static String  _chemistry_click() throws Exception{
 //BA.debugLineNum = 339;BA.debugLine="Private Sub chemistry_Click";
 //BA.debugLineNum = 340;BA.debugLine="tag_subject= \"chemistry\"";
mostCurrent._tag_subject = "chemistry";
 //BA.debugLineNum = 341;BA.debugLine="CameraClick";
_cameraclick();
 //BA.debugLineNum = 342;BA.debugLine="End Sub";
return "";
}
public static String  _chemistry_imp_click() throws Exception{
 //BA.debugLineNum = 393;BA.debugLine="Private Sub chemistry_imp_Click";
 //BA.debugLineNum = 394;BA.debugLine="tag_subject= \"chemistry\"";
mostCurrent._tag_subject = "chemistry";
 //BA.debugLineNum = 395;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 396;BA.debugLine="Activity.LoadLayout(\"record_import\")";
mostCurrent._activity.LoadLayout("record_import",mostCurrent.activityBA);
 //BA.debugLineNum = 397;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
 //BA.debugLineNum = 398;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
 //BA.debugLineNum = 399;BA.debugLine="End Sub";
return "";
}
public static String  _chemistry_rev_click() throws Exception{
 //BA.debugLineNum = 670;BA.debugLine="Private Sub chemistry_rev_Click";
 //BA.debugLineNum = 671;BA.debugLine="tag_subject= \"chemistry\"";
mostCurrent._tag_subject = "chemistry";
 //BA.debugLineNum = 672;BA.debugLine="RevClick";
_revclick();
 //BA.debugLineNum = 673;BA.debugLine="End Sub";
return "";
}
public static String  _chinese_click() throws Exception{
 //BA.debugLineNum = 319;BA.debugLine="Private Sub chinese_Click";
 //BA.debugLineNum = 320;BA.debugLine="tag_subject= \"chinese\"";
mostCurrent._tag_subject = "chinese";
 //BA.debugLineNum = 321;BA.debugLine="CameraClick";
_cameraclick();
 //BA.debugLineNum = 322;BA.debugLine="End Sub";
return "";
}
public static String  _chinese_imp_click() throws Exception{
 //BA.debugLineNum = 361;BA.debugLine="Private Sub chinese_imp_Click";
 //BA.debugLineNum = 362;BA.debugLine="tag_subject= \"chinese\"";
mostCurrent._tag_subject = "chinese";
 //BA.debugLineNum = 363;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 364;BA.debugLine="Activity.LoadLayout(\"record_import\")";
mostCurrent._activity.LoadLayout("record_import",mostCurrent.activityBA);
 //BA.debugLineNum = 365;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
 //BA.debugLineNum = 366;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
 //BA.debugLineNum = 367;BA.debugLine="End Sub";
return "";
}
public static String  _chinese_rev_click() throws Exception{
 //BA.debugLineNum = 650;BA.debugLine="Private Sub chinese_rev_Click";
 //BA.debugLineNum = 651;BA.debugLine="tag_subject= \"chinese\"";
mostCurrent._tag_subject = "chinese";
 //BA.debugLineNum = 652;BA.debugLine="RevClick";
_revclick();
 //BA.debugLineNum = 653;BA.debugLine="End Sub";
return "";
}
public static String  _correct_click() throws Exception{
String _tn = "";
String _table_name = "";
 //BA.debugLineNum = 680;BA.debugLine="Private Sub correct_Click";
 //BA.debugLineNum = 681;BA.debugLine="Dim tn As String";
_tn = "";
 //BA.debugLineNum = 682;BA.debugLine="Dim table_name As String";
_table_name = "";
 //BA.debugLineNum = 683;BA.debugLine="table_name = tag_subject & \"_bank\"";
_table_name = mostCurrent._tag_subject+"_bank";
 //BA.debugLineNum = 686;BA.debugLine="Current_Correct_Times = Current_Correct_Times +1";
_current_correct_times = (int) (_current_correct_times+1);
 //BA.debugLineNum = 687;BA.debugLine="SQL1.ExecNonQuery(\"UPDATE '\"& table_name &\"' SET";
mostCurrent._sql1.ExecNonQuery("UPDATE '"+_table_name+"' SET Correct_Times = '"+BA.NumberToString(_current_correct_times)+"' WHERE  ID = '"+BA.NumberToString(_current_id)+"' ");
 //BA.debugLineNum = 688;BA.debugLine="tn = select_question(tag_subject)";
_tn = _select_question(mostCurrent._tag_subject);
 //BA.debugLineNum = 690;BA.debugLine="If tn = \"\" Then";
if ((_tn).equals("")) { 
 //BA.debugLineNum = 691;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 693;BA.debugLine="Refresh_question(random_num)";
_refresh_question(_random_num);
 //BA.debugLineNum = 694;BA.debugLine="End Sub";
return "";
}
public static String  _dbload() throws Exception{
 //BA.debugLineNum = 111;BA.debugLine="Sub DBload";
 //BA.debugLineNum = 114;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM \" & tag_s";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT * FROM "+mostCurrent._tag_subject+"_bank")));
 //BA.debugLineNum = 123;BA.debugLine="End Sub";
return "";
}
public static String  _english_click() throws Exception{
 //BA.debugLineNum = 329;BA.debugLine="Private Sub english_Click";
 //BA.debugLineNum = 330;BA.debugLine="tag_subject= \"english\"";
mostCurrent._tag_subject = "english";
 //BA.debugLineNum = 331;BA.debugLine="CameraClick";
_cameraclick();
 //BA.debugLineNum = 332;BA.debugLine="End Sub";
return "";
}
public static String  _english_imp_click() throws Exception{
 //BA.debugLineNum = 377;BA.debugLine="Private Sub english_imp_Click";
 //BA.debugLineNum = 378;BA.debugLine="tag_subject= \"english\"";
mostCurrent._tag_subject = "english";
 //BA.debugLineNum = 379;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 380;BA.debugLine="Activity.LoadLayout(\"record_import\")";
mostCurrent._activity.LoadLayout("record_import",mostCurrent.activityBA);
 //BA.debugLineNum = 381;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
 //BA.debugLineNum = 382;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
 //BA.debugLineNum = 383;BA.debugLine="End Sub";
return "";
}
public static String  _english_rev_click() throws Exception{
 //BA.debugLineNum = 660;BA.debugLine="Private Sub english_rev_Click";
 //BA.debugLineNum = 661;BA.debugLine="tag_subject= \"english\"";
mostCurrent._tag_subject = "english";
 //BA.debugLineNum = 662;BA.debugLine="RevClick";
_revclick();
 //BA.debugLineNum = 663;BA.debugLine="End Sub";
return "";
}
public static void  _get_tags(String _subject) throws Exception{
ResumableSub_get_tags rsub = new ResumableSub_get_tags(null,_subject);
rsub.resume(processBA, null);
}
public static class ResumableSub_get_tags extends BA.ResumableSub {
public ResumableSub_get_tags(avanue.nvwa.main parent,String _subject) {
this.parent = parent;
this._subject = _subject;
}
avanue.nvwa.main parent;
String _subject;
boolean _duplicatetest = false;
int _i = 0;
String[] _tag = null;
int _result = 0;
int step9;
int limit9;
int step33;
int limit33;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 233;BA.debugLine="Do While True '添加tag会保持循环，选择完tag会退出循环";
if (true) break;

case 1:
//do while
this.state = 41;
while (anywheresoftware.b4a.keywords.Common.True) {
this.state = 3;
if (true) break;
}
if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 234;BA.debugLine="Dim DuplicateTest As Boolean = False";
_duplicatetest = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 235;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM tags wher";
parent.mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(parent.mostCurrent._sql1.ExecQuery("SELECT * FROM tags where Subject =  '"+_subject+"' ")));
 //BA.debugLineNum = 237;BA.debugLine="If cursor1.RowCount < 1 Then";
if (true) break;

case 4:
//if
this.state = 7;
if (parent.mostCurrent._cursor1.getRowCount()<1) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 238;BA.debugLine="Msgbox2Async(\"当前科目还没有任何tag\", \"INFO\", \"OK\", \"\", \"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("当前科目还没有任何tag"),BA.ObjectToCharSequence("INFO"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 7:
//C
this.state = 8;
;
 //BA.debugLineNum = 240;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 241;BA.debugLine="Dim tag(cursor1.RowCount) As String";
_tag = new String[parent.mostCurrent._cursor1.getRowCount()];
java.util.Arrays.fill(_tag,"");
 //BA.debugLineNum = 242;BA.debugLine="For i = 0 To cursor1.RowCount - 1";
if (true) break;

case 8:
//for
this.state = 11;
step9 = 1;
limit9 = (int) (parent.mostCurrent._cursor1.getRowCount()-1);
_i = (int) (0) ;
this.state = 42;
if (true) break;

case 42:
//C
this.state = 11;
if ((step9 > 0 && _i <= limit9) || (step9 < 0 && _i >= limit9)) this.state = 10;
if (true) break;

case 43:
//C
this.state = 42;
_i = ((int)(0 + _i + step9)) ;
if (true) break;

case 10:
//C
this.state = 43;
 //BA.debugLineNum = 243;BA.debugLine="cursor1.Position = i";
parent.mostCurrent._cursor1.setPosition(_i);
 //BA.debugLineNum = 244;BA.debugLine="tag(i) = cursor1.GetString(\"tag_name\")";
_tag[_i] = parent.mostCurrent._cursor1.GetString("tag_name");
 if (true) break;
if (true) break;

case 11:
//C
this.state = 12;
;
 //BA.debugLineNum = 247;BA.debugLine="options.Initialize";
parent.mostCurrent._options._initialize /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 248;BA.debugLine="options.AllowMultiSelection = True";
parent.mostCurrent._options._allowmultiselection /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 249;BA.debugLine="options.Resize(300dip,200dip)";
parent.mostCurrent._options._resize /*String*/ (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
 //BA.debugLineNum = 250;BA.debugLine="options.Options = tag";
parent.mostCurrent._options._options /*anywheresoftware.b4a.objects.collections.List*/  = anywheresoftware.b4a.keywords.Common.ArrayToList(_tag);
 //BA.debugLineNum = 252;BA.debugLine="Wait For (TagDialog.ShowTemplate(options, \"OK\", \"";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, this, parent.mostCurrent._tagdialog._showtemplate /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ((Object)(parent.mostCurrent._options),(Object)("OK"),(Object)("ADD"),(Object)("CANCEL")));
this.state = 44;
return;
case 44:
//C
this.state = 12;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 253;BA.debugLine="Select Result";
if (true) break;

case 12:
//select
this.state = 40;
switch (BA.switchObjectToInt(_result,parent._xui.DialogResponse_Positive,parent._xui.DialogResponse_Negative,parent._xui.DialogResponse_Cancel)) {
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
 //BA.debugLineNum = 255;BA.debugLine="TagDialog.Show($\"选择的类别： ${options.SelectedItems}";
parent.mostCurrent._tagdialog._show /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ((Object)(("选择的类别： "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(parent.mostCurrent._options._selecteditems /*anywheresoftware.b4a.objects.collections.List*/ .getObject()))+"")),(Object)("OK"),(Object)(""),(Object)(""));
 //BA.debugLineNum = 256;BA.debugLine="Return";
if (true) return ;
 //BA.debugLineNum = 258;BA.debugLine="Exit";
this.state = 40;
if (true) break;
 if (true) break;

case 16:
//C
this.state = 17;
 //BA.debugLineNum = 260;BA.debugLine="InputTag.Initialize";
parent.mostCurrent._inputtag._initialize /*String*/ (mostCurrent.activityBA);
 //BA.debugLineNum = 261;BA.debugLine="InputTag.lblTitle.Text = \"添加标签\"";
parent.mostCurrent._inputtag._lbltitle /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setText(BA.ObjectToCharSequence("添加标签"));
 //BA.debugLineNum = 262;BA.debugLine="Wait For (TagDialog.ShowTemplate(InputTag, \"OK\",";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, this, parent.mostCurrent._tagdialog._showtemplate /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ ((Object)(parent.mostCurrent._inputtag),(Object)("OK"),(Object)(""),(Object)("CANCEL")));
this.state = 45;
return;
case 45:
//C
this.state = 17;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 263;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
if (true) break;

case 17:
//if
this.state = 37;
if (_result==parent._xui.DialogResponse_Positive) { 
this.state = 19;
}if (true) break;

case 19:
//C
this.state = 20;
 //BA.debugLineNum = 264;BA.debugLine="If InputTag.Text = \"\" Then";
if (true) break;

case 20:
//if
this.state = 33;
if ((parent.mostCurrent._inputtag._text /*String*/ ).equals("")) { 
this.state = 22;
}else {
this.state = 24;
}if (true) break;

case 22:
//C
this.state = 33;
 //BA.debugLineNum = 265;BA.debugLine="Msgbox2Async(\"还没有填标签名称呢！！\", \"ERR\", \"OK\", \"\", \"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("还没有填标签名称呢！！"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 266;BA.debugLine="Exit";
this.state = 40;
if (true) break;
 if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 268;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM tags W";
parent.mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(parent.mostCurrent._sql1.ExecQuery("SELECT * FROM tags WHERE subject = '"+parent.mostCurrent._tag_subject+"'")));
 //BA.debugLineNum = 269;BA.debugLine="For i = 0 To cursor1.RowCount - 1";
if (true) break;

case 25:
//for
this.state = 32;
step33 = 1;
limit33 = (int) (parent.mostCurrent._cursor1.getRowCount()-1);
_i = (int) (0) ;
this.state = 46;
if (true) break;

case 46:
//C
this.state = 32;
if ((step33 > 0 && _i <= limit33) || (step33 < 0 && _i >= limit33)) this.state = 27;
if (true) break;

case 47:
//C
this.state = 46;
_i = ((int)(0 + _i + step33)) ;
if (true) break;

case 27:
//C
this.state = 28;
 //BA.debugLineNum = 270;BA.debugLine="cursor1.Position = i";
parent.mostCurrent._cursor1.setPosition(_i);
 //BA.debugLineNum = 271;BA.debugLine="If InputTag.Text = cursor1.GetString(\"tag_nam";
if (true) break;

case 28:
//if
this.state = 31;
if ((parent.mostCurrent._inputtag._text /*String*/ ).equals(parent.mostCurrent._cursor1.GetString("tag_name"))) { 
this.state = 30;
}if (true) break;

case 30:
//C
this.state = 31;
 //BA.debugLineNum = 272;BA.debugLine="Msgbox2Async(\"标签名重了！！\", \"ERR\", \"OK\", \"\", \"\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("标签名重了！！"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 273;BA.debugLine="DuplicateTest = True";
_duplicatetest = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 274;BA.debugLine="Exit";
this.state = 32;
if (true) break;
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
;
 if (true) break;
;
 //BA.debugLineNum = 278;BA.debugLine="If Not(DuplicateTest) Then";

case 33:
//if
this.state = 36;
if (anywheresoftware.b4a.keywords.Common.Not(_duplicatetest)) { 
this.state = 35;
}if (true) break;

case 35:
//C
this.state = 36;
 //BA.debugLineNum = 279;BA.debugLine="SQL1.ExecNonQuery(\"INSERT INTO tags (tag_name,";
parent.mostCurrent._sql1.ExecNonQuery("INSERT INTO tags (tag_name,subject) VALUES ('"+parent.mostCurrent._inputtag._text /*String*/ +"','"+parent.mostCurrent._tag_subject+"')");
 //BA.debugLineNum = 280;BA.debugLine="ToastMessageShow( tag_subject & \" label '\" & I";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(parent.mostCurrent._tag_subject+" label '"+parent.mostCurrent._inputtag._text /*String*/ +"' added successfully"),anywheresoftware.b4a.keywords.Common.False);
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
 //BA.debugLineNum = 284;BA.debugLine="Return";
if (true) return ;
 //BA.debugLineNum = 285;BA.debugLine="Exit";
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
 //BA.debugLineNum = 288;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _complete(int _result) throws Exception{
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 26;BA.debugLine="Private camEx As CameraExClass";
mostCurrent._camex = new avanue.nvwa.cameraexclass();
 //BA.debugLineNum = 27;BA.debugLine="Dim TouchImageView1 As TouchImageView";
mostCurrent._touchimageview1 = new uk.co.martinpearman.b4a.touchimageview.TouchImageViewWrapper();
 //BA.debugLineNum = 28;BA.debugLine="Dim ID As String";
mostCurrent._id = "";
 //BA.debugLineNum = 29;BA.debugLine="Dim SQL1 As SQL";
mostCurrent._sql1 = new anywheresoftware.b4a.sql.SQL();
 //BA.debugLineNum = 30;BA.debugLine="Dim cursor1 As Cursor";
mostCurrent._cursor1 = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
 //BA.debugLineNum = 31;BA.debugLine="Dim now As Long";
_now = 0L;
 //BA.debugLineNum = 32;BA.debugLine="Public rp As RuntimePermissions";
mostCurrent._rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 33;BA.debugLine="Public tag_subject As String";
mostCurrent._tag_subject = "";
 //BA.debugLineNum = 35;BA.debugLine="Dim Panel1 As Panel";
mostCurrent._panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Dim btnTakePicture As Button";
mostCurrent._btntakepicture = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private MyTaskIndex As Int";
_mytaskindex = 0;
 //BA.debugLineNum = 39;BA.debugLine="Public rp As RuntimePermissions";
mostCurrent._rp = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 40;BA.debugLine="Dim q_count As Label";
mostCurrent._q_count = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Dim Q_Name , A_Name,T_Name  As String";
mostCurrent._q_name = "";
mostCurrent._a_name = "";
mostCurrent._t_name = "";
 //BA.debugLineNum = 42;BA.debugLine="Dim random_num  As Int";
_random_num = 0;
 //BA.debugLineNum = 43;BA.debugLine="Dim ImageView1 As ImageView";
mostCurrent._imageview1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Dim Current_ID As Int";
_current_id = 0;
 //BA.debugLineNum = 45;BA.debugLine="Dim Current_Time_Create As String";
mostCurrent._current_time_create = "";
 //BA.debugLineNum = 46;BA.debugLine="Dim Current_Time_Modify As String";
mostCurrent._current_time_modify = "";
 //BA.debugLineNum = 47;BA.debugLine="Dim Current_Time_Delete As String";
mostCurrent._current_time_delete = "";
 //BA.debugLineNum = 48;BA.debugLine="Dim Current_Valid As Int";
_current_valid = 0;
 //BA.debugLineNum = 49;BA.debugLine="Dim Current_Subject As String";
mostCurrent._current_subject = "";
 //BA.debugLineNum = 50;BA.debugLine="Dim Current_Leval As Int";
_current_leval = 0;
 //BA.debugLineNum = 51;BA.debugLine="Dim Current_Grade As Int";
_current_grade = 0;
 //BA.debugLineNum = 52;BA.debugLine="Dim Current_Tags As String";
mostCurrent._current_tags = "";
 //BA.debugLineNum = 53;BA.debugLine="Dim Current_Question_Image As String";
mostCurrent._current_question_image = "";
 //BA.debugLineNum = 54;BA.debugLine="Dim Current_Answer_Image As String";
mostCurrent._current_answer_image = "";
 //BA.debugLineNum = 55;BA.debugLine="Dim Current_Correct_Times As Int";
_current_correct_times = 0;
 //BA.debugLineNum = 56;BA.debugLine="Dim Current_Incorrect_Times As Int";
_current_incorrect_times = 0;
 //BA.debugLineNum = 57;BA.debugLine="Dim Current_Last_Time As String";
mostCurrent._current_last_time = "";
 //BA.debugLineNum = 58;BA.debugLine="Dim QA_S As Int";
_qa_s = 0;
 //BA.debugLineNum = 59;BA.debugLine="Dim rule_never_do As Int = 1";
_rule_never_do = (int) (1);
 //BA.debugLineNum = 60;BA.debugLine="Dim rule_correct As Int = 0";
_rule_correct = (int) (0);
 //BA.debugLineNum = 61;BA.debugLine="Dim rule_incorrect As Int =1";
_rule_incorrect = (int) (1);
 //BA.debugLineNum = 62;BA.debugLine="Dim tags As String";
mostCurrent._tags = "";
 //BA.debugLineNum = 65;BA.debugLine="Dim FileDialog1 As FileDialog";
mostCurrent._filedialog1 = new anywheresoftware.b4a.agraham.dialogs2.InputDialog.FileDialog();
 //BA.debugLineNum = 66;BA.debugLine="Dim QuesFilePath As String = File.DirRootExternal";
mostCurrent._quesfilepath = anywheresoftware.b4a.keywords.Common.File.getDirRootExternal();
 //BA.debugLineNum = 67;BA.debugLine="Dim QuesFileName As String = \" \"";
mostCurrent._quesfilename = " ";
 //BA.debugLineNum = 68;BA.debugLine="Dim AnsFilePath As String = File.DirRootExternal";
mostCurrent._ansfilepath = anywheresoftware.b4a.keywords.Common.File.getDirRootExternal();
 //BA.debugLineNum = 69;BA.debugLine="Dim AnsFileName As String = \" \"";
mostCurrent._ansfilename = " ";
 //BA.debugLineNum = 70;BA.debugLine="Dim BitmapQues As Bitmap";
mostCurrent._bitmapques = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 71;BA.debugLine="Dim BitmapAns As Bitmap";
mostCurrent._bitmapans = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 74;BA.debugLine="Private ScrAns As ScrollView2D";
mostCurrent._scrans = new flm.b4a.scrollview2d.ScrollView2DWrapper();
 //BA.debugLineNum = 75;BA.debugLine="Private ScrQues As ScrollView2D";
mostCurrent._scrques = new flm.b4a.scrollview2d.ScrollView2DWrapper();
 //BA.debugLineNum = 78;BA.debugLine="Private btnImpAns As Button";
mostCurrent._btnimpans = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 79;BA.debugLine="Private btnImpComplete As Button";
mostCurrent._btnimpcomplete = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 80;BA.debugLine="Private btnImpQues As Button";
mostCurrent._btnimpques = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 83;BA.debugLine="Private add_tag_biology As RadioButton";
mostCurrent._add_tag_biology = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 84;BA.debugLine="Private add_tag_chemistry As RadioButton";
mostCurrent._add_tag_chemistry = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 85;BA.debugLine="Private add_tag_chinese As RadioButton";
mostCurrent._add_tag_chinese = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 86;BA.debugLine="Private add_tag_english As RadioButton";
mostCurrent._add_tag_english = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 87;BA.debugLine="Private add_tag_maths As RadioButton";
mostCurrent._add_tag_maths = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 88;BA.debugLine="Private add_tag_physics As RadioButton";
mostCurrent._add_tag_physics = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
 //BA.debugLineNum = 90;BA.debugLine="Private add_tag_edit As EditText";
mostCurrent._add_tag_edit = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 92;BA.debugLine="Dim FT As FileTools";
mostCurrent._ft = new com.mathew.mmtools.filetools();
 //BA.debugLineNum = 94;BA.debugLine="Dim options As B4XListTemplate";
mostCurrent._options = new avanue.nvwa.b4xlisttemplate();
 //BA.debugLineNum = 95;BA.debugLine="Private TagDialog As B4XDialog";
mostCurrent._tagdialog = new avanue.nvwa.b4xdialog();
 //BA.debugLineNum = 96;BA.debugLine="Private Base As B4XView";
mostCurrent._base = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 97;BA.debugLine="Private InputTag As B4XInputTemplate";
mostCurrent._inputtag = new avanue.nvwa.b4xinputtemplate();
 //BA.debugLineNum = 99;BA.debugLine="End Sub";
return "";
}
public static String  _incorrect_click() throws Exception{
String _tn = "";
String _table_name = "";
 //BA.debugLineNum = 735;BA.debugLine="Private Sub incorrect_Click";
 //BA.debugLineNum = 736;BA.debugLine="Dim tn As String";
_tn = "";
 //BA.debugLineNum = 737;BA.debugLine="Dim table_name As String";
_table_name = "";
 //BA.debugLineNum = 738;BA.debugLine="table_name = tag_subject & \"_bank\"";
_table_name = mostCurrent._tag_subject+"_bank";
 //BA.debugLineNum = 740;BA.debugLine="Current_Incorrect_Times = Current_Incorrect_Times";
_current_incorrect_times = (int) (_current_incorrect_times+1);
 //BA.debugLineNum = 741;BA.debugLine="SQL1.ExecNonQuery(\"UPDATE '\"& table_name &\"' SET";
mostCurrent._sql1.ExecNonQuery("UPDATE '"+_table_name+"' SET Incorrect_Times = '"+BA.NumberToString(_current_incorrect_times)+"' WHERE  ID = '"+BA.NumberToString(_current_id)+"' ");
 //BA.debugLineNum = 743;BA.debugLine="tn = select_question(tag_subject)";
_tn = _select_question(mostCurrent._tag_subject);
 //BA.debugLineNum = 745;BA.debugLine="Refresh_question(random_num)";
_refresh_question(_random_num);
 //BA.debugLineNum = 746;BA.debugLine="End Sub";
return "";
}
public static void  _initializecamera() throws Exception{
ResumableSub_InitializeCamera rsub = new ResumableSub_InitializeCamera(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_InitializeCamera extends BA.ResumableSub {
public ResumableSub_InitializeCamera(avanue.nvwa.main parent) {
this.parent = parent;
}
avanue.nvwa.main parent;
String _permission = "";
boolean _result = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 549;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_CAMERA)";
parent.mostCurrent._rp.CheckAndRequest(processBA,parent.mostCurrent._rp.PERMISSION_CAMERA);
 //BA.debugLineNum = 550;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, this, null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
 //BA.debugLineNum = 551;BA.debugLine="If Result Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_result) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 552;BA.debugLine="camEx.Initialize(Panel1, frontCamera, Me, \"Camer";
parent.mostCurrent._camex._initialize /*String*/ (mostCurrent.activityBA,parent.mostCurrent._panel1,parent._frontcamera,main.getObject(),"Camera1");
 //BA.debugLineNum = 553;BA.debugLine="frontCamera = camEx.Front";
parent._frontcamera = parent.mostCurrent._camex._front /*boolean*/ ;
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 555;BA.debugLine="ToastMessageShow(\"No permission!!!\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No permission!!!"),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 557;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _maths_click() throws Exception{
 //BA.debugLineNum = 324;BA.debugLine="Private Sub maths_Click";
 //BA.debugLineNum = 325;BA.debugLine="tag_subject= \"maths\"";
mostCurrent._tag_subject = "maths";
 //BA.debugLineNum = 326;BA.debugLine="CameraClick";
_cameraclick();
 //BA.debugLineNum = 327;BA.debugLine="End Sub";
return "";
}
public static String  _maths_imp_click() throws Exception{
 //BA.debugLineNum = 369;BA.debugLine="Private Sub maths_imp_Click";
 //BA.debugLineNum = 370;BA.debugLine="tag_subject= \"maths\"";
mostCurrent._tag_subject = "maths";
 //BA.debugLineNum = 371;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 372;BA.debugLine="Activity.LoadLayout(\"record_import\")";
mostCurrent._activity.LoadLayout("record_import",mostCurrent.activityBA);
 //BA.debugLineNum = 373;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
 //BA.debugLineNum = 374;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
 //BA.debugLineNum = 375;BA.debugLine="End Sub";
return "";
}
public static String  _maths_rev_click() throws Exception{
 //BA.debugLineNum = 655;BA.debugLine="Private Sub maths_rev_Click";
 //BA.debugLineNum = 656;BA.debugLine="tag_subject= \"maths\"";
mostCurrent._tag_subject = "maths";
 //BA.debugLineNum = 657;BA.debugLine="RevClick";
_revclick();
 //BA.debugLineNum = 658;BA.debugLine="End Sub";
return "";
}
public static String  _now_string() throws Exception{
String _nows = "";
 //BA.debugLineNum = 101;BA.debugLine="Private Sub now_string As String";
 //BA.debugLineNum = 102;BA.debugLine="now  = DateTime.Now";
_now = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 103;BA.debugLine="Dim nows As String";
_nows = "";
 //BA.debugLineNum = 104;BA.debugLine="DateTime.DateFormat = \"YYYYMMdd.\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("YYYYMMdd.");
 //BA.debugLineNum = 106;BA.debugLine="DateTime.SetTimeZone(8)";
anywheresoftware.b4a.keywords.Common.DateTime.SetTimeZone(8);
 //BA.debugLineNum = 107;BA.debugLine="nows = DateTime.Date(now) & DateTime.Time(now)";
_nows = anywheresoftware.b4a.keywords.Common.DateTime.Date(_now)+anywheresoftware.b4a.keywords.Common.DateTime.Time(_now);
 //BA.debugLineNum = 108;BA.debugLine="Return nows";
if (true) return _nows;
 //BA.debugLineNum = 109;BA.debugLine="End Sub";
return "";
}
public static String  _physics_click() throws Exception{
 //BA.debugLineNum = 334;BA.debugLine="Private Sub physics_Click";
 //BA.debugLineNum = 335;BA.debugLine="tag_subject= \"physics\"";
mostCurrent._tag_subject = "physics";
 //BA.debugLineNum = 336;BA.debugLine="CameraClick";
_cameraclick();
 //BA.debugLineNum = 337;BA.debugLine="End Sub";
return "";
}
public static String  _physics_imp_click() throws Exception{
 //BA.debugLineNum = 385;BA.debugLine="Private Sub physics_imp_Click";
 //BA.debugLineNum = 386;BA.debugLine="tag_subject= \"physics\"";
mostCurrent._tag_subject = "physics";
 //BA.debugLineNum = 387;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 388;BA.debugLine="Activity.LoadLayout(\"record_import\")";
mostCurrent._activity.LoadLayout("record_import",mostCurrent.activityBA);
 //BA.debugLineNum = 389;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
 //BA.debugLineNum = 390;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
 //BA.debugLineNum = 391;BA.debugLine="End Sub";
return "";
}
public static String  _physics_rev_click() throws Exception{
 //BA.debugLineNum = 665;BA.debugLine="Private Sub physics_rev_Click";
 //BA.debugLineNum = 666;BA.debugLine="tag_subject= \"physics\"";
mostCurrent._tag_subject = "physics";
 //BA.debugLineNum = 667;BA.debugLine="RevClick";
_revclick();
 //BA.debugLineNum = 668;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
main._process_globals();
starter._process_globals();
xuiviewsutils._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 19;BA.debugLine="Private frontCamera As Boolean = False";
_frontcamera = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 20;BA.debugLine="Private Storage As ExternalStorage";
_storage = new avanue.nvwa.externalstorage();
 //BA.debugLineNum = 21;BA.debugLine="Private Parents_Dir As ExternalFile";
_parents_dir = new avanue.nvwa.externalstorage._externalfile();
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _quit_click() throws Exception{
 //BA.debugLineNum = 198;BA.debugLine="Private Sub quit_Click";
 //BA.debugLineNum = 199;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 //BA.debugLineNum = 200;BA.debugLine="End Sub";
return "";
}
public static String  _r_return_click() throws Exception{
 //BA.debugLineNum = 624;BA.debugLine="Private Sub r_return_Click";
 //BA.debugLineNum = 625;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 626;BA.debugLine="Activity.LoadLayout(\"subjects\")";
mostCurrent._activity.LoadLayout("subjects",mostCurrent.activityBA);
 //BA.debugLineNum = 627;BA.debugLine="End Sub";
return "";
}
public static String  _record_camera_click() throws Exception{
 //BA.debugLineNum = 351;BA.debugLine="Private Sub record_camera_Click";
 //BA.debugLineNum = 352;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 353;BA.debugLine="Activity.LoadLayout (\"subjects\")";
mostCurrent._activity.LoadLayout("subjects",mostCurrent.activityBA);
 //BA.debugLineNum = 354;BA.debugLine="End Sub";
return "";
}
public static String  _record_click() throws Exception{
 //BA.debugLineNum = 202;BA.debugLine="Private Sub record_Click";
 //BA.debugLineNum = 203;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 204;BA.debugLine="Activity.LoadLayout(\"record_choice\")";
mostCurrent._activity.LoadLayout("record_choice",mostCurrent.activityBA);
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return "";
}
public static String  _record_import_click() throws Exception{
 //BA.debugLineNum = 356;BA.debugLine="Private Sub record_import_Click";
 //BA.debugLineNum = 357;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 358;BA.debugLine="Activity.LoadLayout(\"subjects_imp\")";
mostCurrent._activity.LoadLayout("subjects_imp",mostCurrent.activityBA);
 //BA.debugLineNum = 359;BA.debugLine="End Sub";
return "";
}
public static int  _refresh_count(String _subs) throws Exception{
 //BA.debugLineNum = 574;BA.debugLine="Private Sub refresh_count(subs As String) As Int";
 //BA.debugLineNum = 575;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM \" & subs";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT * FROM "+_subs+"_bank")));
 //BA.debugLineNum = 576;BA.debugLine="Return cursor1.RowCount";
if (true) return mostCurrent._cursor1.getRowCount();
 //BA.debugLineNum = 577;BA.debugLine="End Sub";
return 0;
}
public static String  _refresh_question(int _cn) throws Exception{
String _question_file = "";
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap1 = null;
 //BA.debugLineNum = 716;BA.debugLine="Private Sub Refresh_question(cn As Int)";
 //BA.debugLineNum = 717;BA.debugLine="Dim Question_file As String";
_question_file = "";
 //BA.debugLineNum = 719;BA.debugLine="TouchImageView1.MinScale=0.25			'	default is 0.5";
mostCurrent._touchimageview1.setMinScale((float) (0.25));
 //BA.debugLineNum = 720;BA.debugLine="TouchImageView1.MaxScale=2				'	default is 1.5";
mostCurrent._touchimageview1.setMaxScale((float) (2));
 //BA.debugLineNum = 721;BA.debugLine="TouchImageView1.TranslatePadding=128dip	'	default";
mostCurrent._touchimageview1.setTranslatePadding(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (128)));
 //BA.debugLineNum = 723;BA.debugLine="Question_file = File.Combine(File.DirDefaultExter";
_question_file = anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),mostCurrent._cursor1.GetString("Question_Image"));
 //BA.debugLineNum = 726;BA.debugLine="Dim Bitmap1 As Bitmap";
_bitmap1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 727;BA.debugLine="Bitmap1.Initialize(File.DirDefaultExternal,cursor";
_bitmap1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),mostCurrent._cursor1.GetString("Question_Image"));
 //BA.debugLineNum = 729;BA.debugLine="TouchImageView1.SetBitmap(Bitmap1)";
mostCurrent._touchimageview1.SetBitmap(mostCurrent.activityBA,(android.graphics.Bitmap)(_bitmap1.getObject()));
 //BA.debugLineNum = 731;BA.debugLine="QA_S = 0";
_qa_s = (int) (0);
 //BA.debugLineNum = 732;BA.debugLine="End Sub";
return "";
}
public static String  _revclick() throws Exception{
String _tn = "";
 //BA.debugLineNum = 635;BA.debugLine="Sub RevClick";
 //BA.debugLineNum = 636;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 637;BA.debugLine="Activity.LoadLayout(\"review\")";
mostCurrent._activity.LoadLayout("review",mostCurrent.activityBA);
 //BA.debugLineNum = 638;BA.debugLine="Dim tn As String";
_tn = "";
 //BA.debugLineNum = 639;BA.debugLine="tn = select_question(tag_subject)";
_tn = _select_question(mostCurrent._tag_subject);
 //BA.debugLineNum = 640;BA.debugLine="If tn = \"\" Then";
if ((_tn).equals("")) { 
 //BA.debugLineNum = 641;BA.debugLine="Msgbox2Async(\"没题啊\", \"ERR\", \"OK\", \"\", \"\", Null, T";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("没题啊"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 642;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 645;BA.debugLine="TouchImageView1.Initialize(\"TouchImageView1\")";
mostCurrent._touchimageview1.Initialize(mostCurrent.activityBA,"TouchImageView1");
 //BA.debugLineNum = 646;BA.debugLine="Activity.AddView(TouchImageView1, 0, 0, 100%x, 10";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._touchimageview1.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 647;BA.debugLine="Refresh_question(random_num)";
_refresh_question(_random_num);
 //BA.debugLineNum = 648;BA.debugLine="End Sub";
return "";
}
public static String  _review_click() throws Exception{
 //BA.debugLineNum = 629;BA.debugLine="Private Sub review_Click";
 //BA.debugLineNum = 630;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
 //BA.debugLineNum = 631;BA.debugLine="Activity.LoadLayout(\"subjects_rev\")";
mostCurrent._activity.LoadLayout("subjects_rev",mostCurrent.activityBA);
 //BA.debugLineNum = 633;BA.debugLine="End Sub";
return "";
}
public static String  _select_question(String _subject) throws Exception{
String _table_name = "";
 //BA.debugLineNum = 696;BA.debugLine="private Sub select_question(subject As String) As";
 //BA.debugLineNum = 697;BA.debugLine="Dim table_name As String";
_table_name = "";
 //BA.debugLineNum = 698;BA.debugLine="table_name = subject & \"_bank\"";
_table_name = _subject+"_bank";
 //BA.debugLineNum = 699;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM \" & table";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT * FROM "+_table_name)));
 //BA.debugLineNum = 701;BA.debugLine="If cursor1.RowCount < 1 Then";
if (mostCurrent._cursor1.getRowCount()<1) { 
 //BA.debugLineNum = 702;BA.debugLine="Msgbox2Async(\"找不到题目呢\", \"ERR\", \"OK\", \"\", \"\", Null";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("找不到题目呢"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 703;BA.debugLine="Return (\"\")";
if (true) return ("");
 };
 //BA.debugLineNum = 705;BA.debugLine="random_num = Rnd(0,cursor1.RowCount)";
_random_num = anywheresoftware.b4a.keywords.Common.Rnd((int) (0),mostCurrent._cursor1.getRowCount());
 //BA.debugLineNum = 706;BA.debugLine="cursor1.Position = random_num";
mostCurrent._cursor1.setPosition(_random_num);
 //BA.debugLineNum = 708;BA.debugLine="Current_ID = cursor1.GetInt(\"ID\")";
_current_id = mostCurrent._cursor1.GetInt("ID");
 //BA.debugLineNum = 709;BA.debugLine="Current_Correct_Times = cursor1.GetInt(\"Correct_T";
_current_correct_times = mostCurrent._cursor1.GetInt("Correct_Times");
 //BA.debugLineNum = 710;BA.debugLine="Current_Last_Time = cursor1.GetString(\"Last_Time\"";
mostCurrent._current_last_time = mostCurrent._cursor1.GetString("Last_Time");
 //BA.debugLineNum = 712;BA.debugLine="Return(cursor1.GetString(\"Question_Image\"))";
if (true) return (mostCurrent._cursor1.GetString("Question_Image"));
 //BA.debugLineNum = 714;BA.debugLine="End Sub";
return "";
}
public static String  _submit_click() throws Exception{
String _table_name = "";
String _td = "";
int _level = 0;
int _newid = 0;
 //BA.debugLineNum = 585;BA.debugLine="Private Sub submit_Click";
 //BA.debugLineNum = 586;BA.debugLine="If  A_Name = \"\" Or Q_Name = \"\" Then";
if ((mostCurrent._a_name).equals("") || (mostCurrent._q_name).equals("")) { 
 //BA.debugLineNum = 587;BA.debugLine="Msgbox2Async(\"请先拍题目再拍答案\", \"ERR\", \"OK\", \"\", \"\", N";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("请先拍题目再拍答案"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 588;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 590;BA.debugLine="Dim table_name As String";
_table_name = "";
 //BA.debugLineNum = 591;BA.debugLine="table_name = tag_subject & \"_bank\"";
_table_name = mostCurrent._tag_subject+"_bank";
 //BA.debugLineNum = 592;BA.debugLine="Dim td As String";
_td = "";
 //BA.debugLineNum = 593;BA.debugLine="td = now_string";
_td = _now_string();
 //BA.debugLineNum = 594;BA.debugLine="Dim level As Int";
_level = 0;
 //BA.debugLineNum = 595;BA.debugLine="level = 1";
_level = (int) (1);
 //BA.debugLineNum = 596;BA.debugLine="Dim NewID As Int = 0";
_newid = (int) (0);
 //BA.debugLineNum = 597;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT ID FROM \" & tabl";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT ID FROM "+_table_name)));
 //BA.debugLineNum = 607;BA.debugLine="NewID = cursor1.RowCount + 1 ' add 1 to the ID nu";
_newid = (int) (mostCurrent._cursor1.getRowCount()+1);
 //BA.debugLineNum = 609;BA.debugLine="SQL1.ExecNonQuery(\"INSERT INTO \" & table_name &\"";
mostCurrent._sql1.ExecNonQuery("INSERT INTO "+_table_name+"  (ID,Time_Create,Valid,Level,Question_Image,Answer_Image)  VALUES('"+BA.NumberToString(_newid)+"','"+_td+"','"+_td+"','"+BA.NumberToString(_level)+"','"+mostCurrent._q_name+".jpg"+"','"+mostCurrent._a_name+".jpg"+"')");
 //BA.debugLineNum = 611;BA.debugLine="get_tags(tag_subject)'添加标签";
_get_tags(mostCurrent._tag_subject);
 //BA.debugLineNum = 613;BA.debugLine="A_Name = \"\"";
mostCurrent._a_name = "";
 //BA.debugLineNum = 614;BA.debugLine="Q_Name = \"\"";
mostCurrent._q_name = "";
 //BA.debugLineNum = 616;BA.debugLine="q_count.Text = \"总题数：\" & refresh_count(tag_subject";
mostCurrent._q_count.setText(BA.ObjectToCharSequence("总题数："+BA.NumberToString(_refresh_count(mostCurrent._tag_subject))));
 //BA.debugLineNum = 617;BA.debugLine="End Sub";
return "";
}
public static String  _switch_qa_click() throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap1 = null;
 //BA.debugLineNum = 748;BA.debugLine="Private Sub switch_qa_Click";
 //BA.debugLineNum = 749;BA.debugLine="Dim Bitmap1 As Bitmap";
_bitmap1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 750;BA.debugLine="If QA_S =0 Then";
if (_qa_s==0) { 
 //BA.debugLineNum = 751;BA.debugLine="QA_S = 1";
_qa_s = (int) (1);
 //BA.debugLineNum = 752;BA.debugLine="Bitmap1.Initialize(File.DirDefaultExternal,curso";
_bitmap1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),mostCurrent._cursor1.GetString("Answer_Image"));
 }else {
 //BA.debugLineNum = 754;BA.debugLine="QA_S = 0";
_qa_s = (int) (0);
 //BA.debugLineNum = 755;BA.debugLine="Bitmap1.Initialize(File.DirDefaultExternal,curso";
_bitmap1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),mostCurrent._cursor1.GetString("Question_Image"));
 };
 //BA.debugLineNum = 757;BA.debugLine="TouchImageView1.SetBitmap(Bitmap1)";
mostCurrent._touchimageview1.SetBitmap(mostCurrent.activityBA,(android.graphics.Bitmap)(_bitmap1.getObject()));
 //BA.debugLineNum = 758;BA.debugLine="End Sub";
return "";
}
}
