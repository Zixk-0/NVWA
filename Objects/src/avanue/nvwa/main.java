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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "avanue.nvwa", "avanue.nvwa.main");
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



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        b4a.example.dateutils._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
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
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="Storage.Initialize (Me, \"Storage\")";
_storage._initialize /*String*/ (null,processBA,main.getObject(),"Storage");
RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="Parents_Dir.Initialize";
_parents_dir.Initialize();
RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="Base = Activity";
mostCurrent._base = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(mostCurrent._activity.getObject()));
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="TagDialog.Initialize (Base)";
mostCurrent._tagdialog._initialize /*String*/ (null,mostCurrent.activityBA,mostCurrent._base);
RDebugUtils.currentLine=262151;
 //BA.debugLineNum = 262151;BA.debugLine="TagDialog.Title = \"选择题目类别\"";
mostCurrent._tagdialog._title /*Object*/  = (Object)("选择题目类别");
RDebugUtils.currentLine=262152;
 //BA.debugLineNum = 262152;BA.debugLine="options.Initialize";
mostCurrent._options._initialize /*String*/ (null,mostCurrent.activityBA);
RDebugUtils.currentLine=262153;
 //BA.debugLineNum = 262153;BA.debugLine="options.AllowMultiSelection = True";
mostCurrent._options._allowmultiselection /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=262154;
 //BA.debugLineNum = 262154;BA.debugLine="options.Resize(300dip,200dip)";
mostCurrent._options._resize /*String*/ (null,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
RDebugUtils.currentLine=262155;
 //BA.debugLineNum = 262155;BA.debugLine="InputTag.Initialize";
mostCurrent._inputtag._initialize /*String*/ (null,mostCurrent.activityBA);
RDebugUtils.currentLine=262157;
 //BA.debugLineNum = 262157;BA.debugLine="Activity.LoadLayout(\"main\")";
mostCurrent._activity.LoadLayout("main",mostCurrent.activityBA);
RDebugUtils.currentLine=262164;
 //BA.debugLineNum = 262164;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_READ_EXTERNAL_S";
mostCurrent._rp.CheckAndRequest(processBA,mostCurrent._rp.PERMISSION_READ_EXTERNAL_STORAGE);
RDebugUtils.currentLine=262165;
 //BA.debugLineNum = 262165;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_EXTERNAL_";
mostCurrent._rp.CheckAndRequest(processBA,mostCurrent._rp.PERMISSION_WRITE_EXTERNAL_STORAGE);
RDebugUtils.currentLine=262166;
 //BA.debugLineNum = 262166;BA.debugLine="rp.GetAllSafeDirsExternal (\"\")";
mostCurrent._rp.GetAllSafeDirsExternal("");
RDebugUtils.currentLine=262167;
 //BA.debugLineNum = 262167;BA.debugLine="If File.Exists(File.DirDefaultExternal ,\"nvwa.db";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"nvwa.db")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=262168;
 //BA.debugLineNum = 262168;BA.debugLine="Try";
try {RDebugUtils.currentLine=262169;
 //BA.debugLineNum = 262169;BA.debugLine="File.Copy(File.DirAssets,\"nvwa.db\",File.DirDef";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"nvwa.db",anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"nvwa.db");
 } 
       catch (Exception e19) {
			processBA.setLastException(e19);RDebugUtils.currentLine=262171;
 //BA.debugLineNum = 262171;BA.debugLine="Msgbox2Async(\"Copy error\", \"ERR\", \"OK\", \"\", \"\"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Copy error"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=262173;
 //BA.debugLineNum = 262173;BA.debugLine="Msgbox2Async(\"nvwa not exits\", \"DEST\", \"OK\", \"\"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("nvwa not exits"),BA.ObjectToCharSequence("DEST"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=262176;
 //BA.debugLineNum = 262176;BA.debugLine="If SQL1.IsInitialized = False Then";
if (mostCurrent._sql1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=262177;
 //BA.debugLineNum = 262177;BA.debugLine="Try";
try {RDebugUtils.currentLine=262178;
 //BA.debugLineNum = 262178;BA.debugLine="SQL1.Initialize(File.DirDefaultExternal, \"nvwa";
mostCurrent._sql1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),"nvwa.db",anywheresoftware.b4a.keywords.Common.False);
 } 
       catch (Exception e27) {
			processBA.setLastException(e27);RDebugUtils.currentLine=262180;
 //BA.debugLineNum = 262180;BA.debugLine="Msgbox2Async(\"DB Init Error\", \"ERR\", \"OK\", \"\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("DB Init Error"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 };
 };
 };
RDebugUtils.currentLine=262194;
 //BA.debugLineNum = 262194;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="If camEx.IsInitialized Then";
if (mostCurrent._camex.IsInitialized /*boolean*/ ()) { 
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="camEx.Release";
mostCurrent._camex._release /*String*/ (null);
 };
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="End Sub";
return "";
}
public static String  _activity_permissionresult(String _permission,boolean _result) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_permissionresult", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_permissionresult", new Object[] {_permission,_result}));}
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Activity_PermissionResult (Permission As Strin";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="If Result=False Then";
if (_result==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="Msgbox2Async(\"Permission Denied\", \"PD\", \"OK\", \"\"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Permission Denied"),BA.ObjectToCharSequence("PD"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="CallSubDelayed(Me, \"permission_done\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,main.getObject(),"permission_done");
 };
RDebugUtils.currentLine=393223;
 //BA.debugLineNum = 393223;BA.debugLine="Log(Permission)";
anywheresoftware.b4a.keywords.Common.LogImpl("2393223",_permission,0);
RDebugUtils.currentLine=393224;
 //BA.debugLineNum = 393224;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_add_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_tag_add_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_tag_add_click", null));}
int _i = 0;
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Private Sub add_tag_add_Click";
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="If add_tag_edit.Text = \"\" Then";
if ((mostCurrent._add_tag_edit.getText()).equals("")) { 
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="Msgbox2Async(\"还没有填标签名称呢！！\", \"ERR\", \"OK\", \"\", \"\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("还没有填标签名称呢！！"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="Return";
if (true) return "";
 }else {
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM tags WHE";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT * FROM tags WHERE subject = '"+mostCurrent._tag_subject+"'")));
RDebugUtils.currentLine=4128775;
 //BA.debugLineNum = 4128775;BA.debugLine="For i = 0 To cursor1.RowCount - 1";
{
final int step6 = 1;
final int limit6 = (int) (mostCurrent._cursor1.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=4128776;
 //BA.debugLineNum = 4128776;BA.debugLine="cursor1.Position = i";
mostCurrent._cursor1.setPosition(_i);
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="If add_tag_edit.Text = cursor1.GetString(\"tag_n";
if ((mostCurrent._add_tag_edit.getText()).equals(mostCurrent._cursor1.GetString("tag_name"))) { 
RDebugUtils.currentLine=4128778;
 //BA.debugLineNum = 4128778;BA.debugLine="Msgbox2Async(\"标签名重了！！\", \"ERR\", \"OK\", \"\", \"\", N";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("标签名重了！！"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128779;
 //BA.debugLineNum = 4128779;BA.debugLine="Return";
if (true) return "";
 };
 }
};
 };
RDebugUtils.currentLine=4128783;
 //BA.debugLineNum = 4128783;BA.debugLine="SQL1.ExecNonQuery(\"INSERT INTO tags (tag_name,sub";
mostCurrent._sql1.ExecNonQuery("INSERT INTO tags (tag_name,subject) VALUES ('"+mostCurrent._add_tag_edit.getText()+"','"+mostCurrent._tag_subject+"')");
RDebugUtils.currentLine=4128784;
 //BA.debugLineNum = 4128784;BA.debugLine="ToastMessageShow( tag_subject & \" label '\" & add";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(mostCurrent._tag_subject+" label '"+mostCurrent._add_tag_edit.getText()+"' added successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128785;
 //BA.debugLineNum = 4128785;BA.debugLine="add_tag_edit.Text = \"\"";
mostCurrent._add_tag_edit.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4128786;
 //BA.debugLineNum = 4128786;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_biology_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_tag_biology_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_tag_biology_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Private Sub add_tag_biology_CheckedChange(Checked";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="If Checked = True Then";
if (_checked==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="tag_subject = \"biology\"";
mostCurrent._tag_subject = "biology";
 };
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_chemistry_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_tag_chemistry_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_tag_chemistry_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Private Sub add_tag_chemistry_CheckedChange(Checke";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="If Checked = True Then";
if (_checked==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="tag_subject = \"chemistry\"";
mostCurrent._tag_subject = "chemistry";
 };
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_chinese_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_tag_chinese_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_tag_chinese_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Private Sub add_tag_chinese_CheckedChange(Checked";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="If Checked = True Then";
if (_checked==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="tag_subject = \"chinese\"";
mostCurrent._tag_subject = "chinese";
 };
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_english_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_tag_english_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_tag_english_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Private Sub add_tag_english_CheckedChange(Checked";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="If Checked = True Then";
if (_checked==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="tag_subject = \"english\"";
mostCurrent._tag_subject = "english";
 };
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_maths_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_tag_maths_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_tag_maths_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Private Sub add_tag_maths_CheckedChange(Checked As";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="If Checked = True Then";
if (_checked==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="tag_subject = \"maths\"";
mostCurrent._tag_subject = "maths";
 };
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="End Sub";
return "";
}
public static String  _add_tag_physics_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "add_tag_physics_checkedchange", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "add_tag_physics_checkedchange", new Object[] {_checked}));}
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Private Sub add_tag_physics_CheckedChange(Checked";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="If Checked = True Then";
if (_checked==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="tag_subject = \"physics\"";
mostCurrent._tag_subject = "physics";
 };
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="End Sub";
return "";
}
public static String  _addtag_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addtag_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addtag_click", null));}
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Private Sub addtag_Click";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Activity.LoadLayout(\"add_tag\")";
mostCurrent._activity.LoadLayout("add_tag",mostCurrent.activityBA);
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="add_tag_chinese.Checked = True";
mostCurrent._add_tag_chinese.setChecked(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="add_tag_maths.Checked = False";
mostCurrent._add_tag_maths.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="add_tag_english.Checked = False";
mostCurrent._add_tag_english.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="add_tag_physics.Checked = False";
mostCurrent._add_tag_physics.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="add_tag_chemistry.Checked = False";
mostCurrent._add_tag_chemistry.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3670024;
 //BA.debugLineNum = 3670024;BA.debugLine="add_tag_biology.Checked = False";
mostCurrent._add_tag_biology.setChecked(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3670025;
 //BA.debugLineNum = 3670025;BA.debugLine="tag_subject = \"chinese\"";
mostCurrent._tag_subject = "chinese";
RDebugUtils.currentLine=3670026;
 //BA.debugLineNum = 3670026;BA.debugLine="End Sub";
return "";
}
public static String  _answer_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "answer_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "answer_click", null));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Private Sub answer_Click";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="A_Name = now_string";
mostCurrent._a_name = _now_string();
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="T_Name = A_Name";
mostCurrent._t_name = mostCurrent._a_name;
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="camEx.TakePicture";
mostCurrent._camex._takepicture /*String*/ (null);
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="End Sub";
return "";
}
public static String  _now_string() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "now_string", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "now_string", null));}
String _nows = "";
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Private Sub now_string As String";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="now  = DateTime.Now";
_now = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Dim nows As String";
_nows = "";
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="DateTime.DateFormat = \"YYYYMMdd.\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("YYYYMMdd.");
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="DateTime.SetTimeZone(8)";
anywheresoftware.b4a.keywords.Common.DateTime.SetTimeZone(8);
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="nows = DateTime.Date(now) & DateTime.Time(now)";
_nows = anywheresoftware.b4a.keywords.Common.DateTime.Date(_now)+anywheresoftware.b4a.keywords.Common.DateTime.Time(_now);
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Return nows";
if (true) return _nows;
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="End Sub";
return "";
}
public static String  _back_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "back_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "back_click", null));}
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Private Sub back_Click";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Activity.LoadLayout(\"main\")";
mostCurrent._activity.LoadLayout("main",mostCurrent.activityBA);
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="End Sub";
return "";
}
public static String  _back_rev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "back_rev_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "back_rev_click", null));}
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Private Sub back_rev_Click";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="Activity.LoadLayout(\"subjects_rev\")";
mostCurrent._activity.LoadLayout("subjects_rev",mostCurrent.activityBA);
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="End Sub";
return "";
}
public static String  _back_rule_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "back_rule_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "back_rule_click", null));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Private Sub back_rule_Click";
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="Activity.LoadLayout(\"review\")";
mostCurrent._activity.LoadLayout("review",mostCurrent.activityBA);
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="End Sub";
return "";
}
public static String  _biology_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "biology_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "biology_click", null));}
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Private Sub biology_Click";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="tag_subject= \"biology\"";
mostCurrent._tag_subject = "biology";
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="CameraClick";
_cameraclick();
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="End Sub";
return "";
}
public static String  _cameraclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cameraclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cameraclick", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub CameraClick";
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="Activity.LoadLayout (\"record\")";
mostCurrent._activity.LoadLayout("record",mostCurrent.activityBA);
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="Try";
try {RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="InitializeCamera";
_initializecamera();
 } 
       catch (Exception e6) {
			processBA.setLastException(e6);RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="Msgbox2Async(\"camera init err\", \"err\", \"OK\", \"\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("camera init err"),BA.ObjectToCharSequence("err"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=917514;
 //BA.debugLineNum = 917514;BA.debugLine="q_count.Text = \"总题数：\" & refresh_count(tag_subject";
mostCurrent._q_count.setText(BA.ObjectToCharSequence("总题数："+BA.NumberToString(_refresh_count(mostCurrent._tag_subject))));
RDebugUtils.currentLine=917527;
 //BA.debugLineNum = 917527;BA.debugLine="End Sub";
return "";
}
public static String  _biology_imp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "biology_imp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "biology_imp_click", null));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Private Sub biology_imp_Click";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="tag_subject= \"biology\"";
mostCurrent._tag_subject = "biology";
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="Activity.LoadLayout(\"record_import\")";
mostCurrent._activity.LoadLayout("record_import",mostCurrent.activityBA);
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
RDebugUtils.currentLine=1835014;
 //BA.debugLineNum = 1835014;BA.debugLine="End Sub";
return "";
}
public static String  _biology_rev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "biology_rev_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "biology_rev_click", null));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Private Sub biology_rev_Click";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="tag_subject= \"biology\"";
mostCurrent._tag_subject = "biology";
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="RevClick";
_revclick();
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="End Sub";
return "";
}
public static String  _revclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "revclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "revclick", null));}
String _tn = "";
RDebugUtils.currentLine=31064064;
 //BA.debugLineNum = 31064064;BA.debugLine="Sub RevClick";
RDebugUtils.currentLine=31064065;
 //BA.debugLineNum = 31064065;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=31064066;
 //BA.debugLineNum = 31064066;BA.debugLine="Activity.LoadLayout(\"review\")";
mostCurrent._activity.LoadLayout("review",mostCurrent.activityBA);
RDebugUtils.currentLine=31064067;
 //BA.debugLineNum = 31064067;BA.debugLine="Dim tn As String";
_tn = "";
RDebugUtils.currentLine=31064068;
 //BA.debugLineNum = 31064068;BA.debugLine="tn = select_question(tag_subject)";
_tn = _select_question(mostCurrent._tag_subject);
RDebugUtils.currentLine=31064069;
 //BA.debugLineNum = 31064069;BA.debugLine="If tn = \"\" Then";
if ((_tn).equals("")) { 
RDebugUtils.currentLine=31064070;
 //BA.debugLineNum = 31064070;BA.debugLine="Msgbox2Async(\"没题啊\", \"ERR\", \"OK\", \"\", \"\", Null, T";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("没题啊"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=31064071;
 //BA.debugLineNum = 31064071;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=31064074;
 //BA.debugLineNum = 31064074;BA.debugLine="TouchImageView1.Initialize(\"TouchImageView1\")";
mostCurrent._touchimageview1.Initialize(mostCurrent.activityBA,"TouchImageView1");
RDebugUtils.currentLine=31064075;
 //BA.debugLineNum = 31064075;BA.debugLine="Activity.AddView(TouchImageView1, 0, 0, 100%x, 10";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._touchimageview1.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=31064076;
 //BA.debugLineNum = 31064076;BA.debugLine="Refresh_question(random_num)";
_refresh_question(_random_num);
RDebugUtils.currentLine=31064077;
 //BA.debugLineNum = 31064077;BA.debugLine="End Sub";
return "";
}
public static String  _btnflash_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnflash_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnflash_click", null));}
float[] _f = null;
anywheresoftware.b4a.objects.collections.List _flashmodes = null;
String _flash = "";
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Private Sub btnFlash_Click";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Dim f() As Float = camEx.GetFocusDistances";
_f = mostCurrent._camex._getfocusdistances /*float[]*/ (null);
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Log(f(0) & \", \" & f(1) & \", \" & f(2))";
anywheresoftware.b4a.keywords.Common.LogImpl("22293762",BA.NumberToString(_f[(int) (0)])+", "+BA.NumberToString(_f[(int) (1)])+", "+BA.NumberToString(_f[(int) (2)]),0);
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="Dim flashModes As List = camEx.GetSupportedFlashM";
_flashmodes = new anywheresoftware.b4a.objects.collections.List();
_flashmodes = mostCurrent._camex._getsupportedflashmodes /*anywheresoftware.b4a.objects.collections.List*/ (null);
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="If flashModes.IsInitialized = False Then";
if (_flashmodes.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="ToastMessageShow(\"Flash not supported.\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Flash not supported."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="Dim flash As String = flashModes.Get((flashModes.";
_flash = BA.ObjectToString(_flashmodes.Get((int) ((_flashmodes.IndexOf((Object)(mostCurrent._camex._getflashmode /*String*/ (null)))+1)%_flashmodes.getSize())));
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="camEx.SetFlashMode(flash)";
mostCurrent._camex._setflashmode /*String*/ (null,_flash);
RDebugUtils.currentLine=2293770;
 //BA.debugLineNum = 2293770;BA.debugLine="ToastMessageShow(flash, False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_flash),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293771;
 //BA.debugLineNum = 2293771;BA.debugLine="camEx.CommitParameters";
mostCurrent._camex._commitparameters /*String*/ (null);
RDebugUtils.currentLine=2293773;
 //BA.debugLineNum = 2293773;BA.debugLine="End Sub";
return "";
}
public static String  _btnimpans_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnimpans_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnimpans_click", null));}
int _answ = 0;
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Private Sub btnImpAns_Click";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="Dim Answ As Int";
_answ = 0;
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="FileDialog1.FilePath = AnsFilePath";
mostCurrent._filedialog1.setFilePath(mostCurrent._ansfilepath);
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="Answ = FileDialog1.Show(\"Databases\",\"Load\",\"Cance";
_answ = mostCurrent._filedialog1.Show(BA.ObjectToCharSequence("Databases"),"Load","Cancel","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="Select Answ";
switch (BA.switchObjectToInt(_answ,anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE,anywheresoftware.b4a.keywords.Common.DialogResponse.CANCEL)) {
case 0: {
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="AnsFileName = FileDialog1.ChosenName";
mostCurrent._ansfilename = mostCurrent._filedialog1.getChosenName();
RDebugUtils.currentLine=1966089;
 //BA.debugLineNum = 1966089;BA.debugLine="AnsFilePath = FileDialog1.FilePath";
mostCurrent._ansfilepath = mostCurrent._filedialog1.getFilePath();
RDebugUtils.currentLine=1966090;
 //BA.debugLineNum = 1966090;BA.debugLine="ScrAns.Panel.SetBackgroundImage(LoadBitmap(AnsF";
mostCurrent._scrans.getPanel().SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(mostCurrent._ansfilepath,mostCurrent._ansfilename).getObject()));
RDebugUtils.currentLine=1966091;
 //BA.debugLineNum = 1966091;BA.debugLine="BitmapAns.Initialize(AnsFilePath, AnsFileName)";
mostCurrent._bitmapans.Initialize(mostCurrent._ansfilepath,mostCurrent._ansfilename);
RDebugUtils.currentLine=1966092;
 //BA.debugLineNum = 1966092;BA.debugLine="ScrAns.Panel.SetBackgroundImage(BitmapAns)";
mostCurrent._scrans.getPanel().SetBackgroundImageNew((android.graphics.Bitmap)(mostCurrent._bitmapans.getObject()));
RDebugUtils.currentLine=1966093;
 //BA.debugLineNum = 1966093;BA.debugLine="ScrAns.Panel.Height = Floor(BitmapAns.Height /";
mostCurrent._scrans.getPanel().setHeight((int) (anywheresoftware.b4a.keywords.Common.Floor(mostCurrent._bitmapans.getHeight()/(double)5)*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
RDebugUtils.currentLine=1966094;
 //BA.debugLineNum = 1966094;BA.debugLine="ScrAns.Panel.Width = Floor(BitmapAns.Width / 5)";
mostCurrent._scrans.getPanel().setWidth((int) (anywheresoftware.b4a.keywords.Common.Floor(mostCurrent._bitmapans.getWidth()/(double)5)*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
 break; }
case 1: {
 break; }
}
;
RDebugUtils.currentLine=1966098;
 //BA.debugLineNum = 1966098;BA.debugLine="End Sub";
return "";
}
public static String  _btnimpcomplete_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnimpcomplete_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnimpcomplete_click", null));}
String _td = "";
int _level = 0;
int _newid = 0;
String _quesfilenamenew = "";
String _ansfilenamenew = "";
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Private Sub btnImpComplete_Click";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="If QuesFileName = \" \" Or AnsFileName = \" \" Then";
if ((mostCurrent._quesfilename).equals(" ") || (mostCurrent._ansfilename).equals(" ")) { 
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="Msgbox2Async(\"没选完呢！！\", \"ERR\", \"OK\", \"\", \"\", Null";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("没选完呢！！"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="Dim td As String";
_td = "";
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="td = now_string";
_td = _now_string();
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="Dim level As Int";
_level = 0;
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="level = 1";
_level = (int) (1);
RDebugUtils.currentLine=2031625;
 //BA.debugLineNum = 2031625;BA.debugLine="Dim NewID As Int = 0";
_newid = (int) (0);
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT ID FROM \" & tag_";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT ID FROM "+mostCurrent._tag_subject+"_bank")));
RDebugUtils.currentLine=2031627;
 //BA.debugLineNum = 2031627;BA.debugLine="NewID = cursor1.RowCount + 1 ' add 1 to the ID nu";
_newid = (int) (mostCurrent._cursor1.getRowCount()+1);
RDebugUtils.currentLine=2031663;
 //BA.debugLineNum = 2031663;BA.debugLine="Dim QuesFileNameNew As String = td & \"_1.\" & FT.F";
_quesfilenamenew = _td+"_1."+mostCurrent._ft._fileextension(mostCurrent._quesfilename);
RDebugUtils.currentLine=2031664;
 //BA.debugLineNum = 2031664;BA.debugLine="Dim AnsFileNameNew As String = td & \"_2.\" & FT.Fi";
_ansfilenamenew = _td+"_2."+mostCurrent._ft._fileextension(mostCurrent._ansfilename);
RDebugUtils.currentLine=2031665;
 //BA.debugLineNum = 2031665;BA.debugLine="Try";
try {RDebugUtils.currentLine=2031666;
 //BA.debugLineNum = 2031666;BA.debugLine="File.Copy(QuesFilePath,QuesFileName,File.DirDefa";
anywheresoftware.b4a.keywords.Common.File.Copy(mostCurrent._quesfilepath,mostCurrent._quesfilename,anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),_quesfilenamenew);
RDebugUtils.currentLine=2031667;
 //BA.debugLineNum = 2031667;BA.debugLine="File.Copy(AnsFilePath,AnsFileName,File.DirDefaul";
anywheresoftware.b4a.keywords.Common.File.Copy(mostCurrent._ansfilepath,mostCurrent._ansfilename,anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),_ansfilenamenew);
 } 
       catch (Exception e18) {
			processBA.setLastException(e18);RDebugUtils.currentLine=2031669;
 //BA.debugLineNum = 2031669;BA.debugLine="Msgbox2Async(\"未能成功复制文件\", \"ERR\", \"OK\", \"\", \"\", Nu";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("未能成功复制文件"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2031670;
 //BA.debugLineNum = 2031670;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("22031670",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 };
RDebugUtils.currentLine=2031672;
 //BA.debugLineNum = 2031672;BA.debugLine="SQL1.ExecNonQuery(\"INSERT INTO \" & tag_subject &";
mostCurrent._sql1.ExecNonQuery("INSERT INTO "+mostCurrent._tag_subject+"_bank"+" (ID,Time_Create,Valid,Level,Question_Image,Answer_Image)  VALUES('"+BA.NumberToString(_newid)+"','"+_td+"','"+_td+"','"+BA.NumberToString(_level)+"','"+_quesfilenamenew+"','"+_ansfilenamenew+"')");
RDebugUtils.currentLine=2031675;
 //BA.debugLineNum = 2031675;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
RDebugUtils.currentLine=2031676;
 //BA.debugLineNum = 2031676;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
RDebugUtils.currentLine=2031677;
 //BA.debugLineNum = 2031677;BA.debugLine="QuesFileNameNew = \" \"";
_quesfilenamenew = " ";
RDebugUtils.currentLine=2031678;
 //BA.debugLineNum = 2031678;BA.debugLine="AnsFileNameNew = \" \"";
_ansfilenamenew = " ";
RDebugUtils.currentLine=2031681;
 //BA.debugLineNum = 2031681;BA.debugLine="ScrQues.Panel.SetBackgroundImage(LoadBitmap(File.";
mostCurrent._scrques.getPanel().SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"import_empty.jpg").getObject()));
RDebugUtils.currentLine=2031682;
 //BA.debugLineNum = 2031682;BA.debugLine="ScrAns.Panel.SetBackgroundImage(LoadBitmap(File.D";
mostCurrent._scrans.getPanel().SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"import_empty.jpg").getObject()));
RDebugUtils.currentLine=2031683;
 //BA.debugLineNum = 2031683;BA.debugLine="ScrQues.Panel.Height = 220dip";
mostCurrent._scrques.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (220)));
RDebugUtils.currentLine=2031684;
 //BA.debugLineNum = 2031684;BA.debugLine="ScrQues.Panel.Width = 220dip";
mostCurrent._scrques.getPanel().setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (220)));
RDebugUtils.currentLine=2031685;
 //BA.debugLineNum = 2031685;BA.debugLine="ScrAns.Panel.Height = 220dip";
mostCurrent._scrans.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (220)));
RDebugUtils.currentLine=2031686;
 //BA.debugLineNum = 2031686;BA.debugLine="ScrAns.Panel.Width = 220dip";
mostCurrent._scrans.getPanel().setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (220)));
RDebugUtils.currentLine=2031687;
 //BA.debugLineNum = 2031687;BA.debugLine="End Sub";
return "";
}
public static String  _btnimpques_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnimpques_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnimpques_click", null));}
int _answ = 0;
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Private Sub btnImpQues_Click";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Dim Answ As Int";
_answ = 0;
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="FileDialog1.FilePath = QuesFilePath '弹出选择窗口";
mostCurrent._filedialog1.setFilePath(mostCurrent._quesfilepath);
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="Answ = FileDialog1.Show(\"Databases\",\"Load\",\"Cance";
_answ = mostCurrent._filedialog1.Show(BA.ObjectToCharSequence("Databases"),"Load","Cancel","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="Select Answ";
switch (BA.switchObjectToInt(_answ,anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE,anywheresoftware.b4a.keywords.Common.DialogResponse.CANCEL)) {
case 0: {
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="QuesFileName = FileDialog1.ChosenName";
mostCurrent._quesfilename = mostCurrent._filedialog1.getChosenName();
RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="QuesFilePath = FileDialog1.FilePath";
mostCurrent._quesfilepath = mostCurrent._filedialog1.getFilePath();
RDebugUtils.currentLine=1900554;
 //BA.debugLineNum = 1900554;BA.debugLine="BitmapQues.Initialize(QuesFilePath, QuesFileNam";
mostCurrent._bitmapques.Initialize(mostCurrent._quesfilepath,mostCurrent._quesfilename);
RDebugUtils.currentLine=1900555;
 //BA.debugLineNum = 1900555;BA.debugLine="ScrQues.Panel.SetBackgroundImage(BitmapQues)";
mostCurrent._scrques.getPanel().SetBackgroundImageNew((android.graphics.Bitmap)(mostCurrent._bitmapques.getObject()));
RDebugUtils.currentLine=1900556;
 //BA.debugLineNum = 1900556;BA.debugLine="ScrQues.Panel.Height = Floor(BitmapQues.Height";
mostCurrent._scrques.getPanel().setHeight((int) (anywheresoftware.b4a.keywords.Common.Floor(mostCurrent._bitmapques.getHeight()/(double)5)*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
RDebugUtils.currentLine=1900557;
 //BA.debugLineNum = 1900557;BA.debugLine="ScrQues.Panel.Width = Floor(BitmapQues.Width /";
mostCurrent._scrques.getPanel().setWidth((int) (anywheresoftware.b4a.keywords.Common.Floor(mostCurrent._bitmapques.getWidth()/(double)5)*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))));
 break; }
case 1: {
 break; }
}
;
RDebugUtils.currentLine=1900561;
 //BA.debugLineNum = 1900561;BA.debugLine="End Sub";
return "";
}
public static String  _btntakepicture_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btntakepicture_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btntakepicture_click", null));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub btnTakePicture_Click";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="Q_Name = now_string";
mostCurrent._q_name = _now_string();
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="T_Name = Q_Name";
mostCurrent._t_name = mostCurrent._q_name;
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="camEx.TakePicture";
mostCurrent._camex._takepicture /*String*/ (null);
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="End Sub";
return "";
}
public static String  _camera1_focusdone(boolean _success) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "camera1_focusdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "camera1_focusdone", new Object[] {_success}));}
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub Camera1_FocusDone(Success As Boolean)";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Msgbox2Async(\"Mamera focus down\", \"FD\", \"OK\", \"\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Mamera focus down"),BA.ObjectToCharSequence("FD"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="Msgbox2Async(\"Camera focus down\", \"Focus DONE\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Camera focus down"),BA.ObjectToCharSequence("Focus DONE"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="End Sub";
return "";
}
public static String  _camera1_picturetaken(byte[] _data) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "camera1_picturetaken", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "camera1_picturetaken", new Object[] {_data}));}
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub Camera1_PictureTaken (Data() As Byte)";
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="camEx.SavePictureToFile(Data, File.DirDefaultExte";
mostCurrent._camex._savepicturetofile /*String*/ (null,_data,anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),mostCurrent._t_name+".jpg");
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="camEx.StartPreview 'restart preview";
mostCurrent._camex._startpreview /*String*/ (null);
RDebugUtils.currentLine=2097160;
 //BA.debugLineNum = 2097160;BA.debugLine="ToastMessageShow(\"Image saved: \" & File.Combine(F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Image saved: "+anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),mostCurrent._t_name+".jpg")),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2097161;
 //BA.debugLineNum = 2097161;BA.debugLine="btnTakePicture.Enabled = True";
mostCurrent._btntakepicture.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2097163;
 //BA.debugLineNum = 2097163;BA.debugLine="End Sub";
return "";
}
public static String  _camera1_ready(boolean _success) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "camera1_ready", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "camera1_ready", new Object[] {_success}));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub Camera1_Ready (Success As Boolean)";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="camEx.SetJpegQuality(90)";
mostCurrent._camex._setjpegquality /*String*/ (null,(int) (90));
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="camEx.SetContinuousAutoFocus";
mostCurrent._camex._setcontinuousautofocus /*String*/ (null);
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="camEx.CommitParameters";
mostCurrent._camex._commitparameters /*String*/ (null);
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="camEx.StartPreview";
mostCurrent._camex._startpreview /*String*/ (null);
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="Log(camEx.GetPreviewSize)";
anywheresoftware.b4a.keywords.Common.LogImpl("2720902",BA.ObjectToString(mostCurrent._camex._getpreviewsize /*avanue.nvwa.cameraexclass._camerasize*/ (null)),0);
 }else {
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="ToastMessageShow(\"Cannot open camera.\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Cannot open camera."),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="End Sub";
return "";
}
public static void  _initializecamera() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "initializecamera", false))
	 {Debug.delegate(mostCurrent.activityBA, "initializecamera", null); return;}
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
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_CAMERA)";
parent.mostCurrent._rp.CheckAndRequest(processBA,parent.mostCurrent._rp.PERMISSION_CAMERA);
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="Wait For Activity_PermissionResult (Permission As";
anywheresoftware.b4a.keywords.Common.WaitFor("activity_permissionresult", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "initializecamera"), null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_permission = (String) result[0];
_result = (Boolean) result[1];
;
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="If Result Then";
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
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="camEx.Initialize(Panel1, frontCamera, Me, \"Camer";
parent.mostCurrent._camex._initialize /*String*/ (null,mostCurrent.activityBA,parent.mostCurrent._panel1,parent._frontcamera,main.getObject(),"Camera1");
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="frontCamera = camEx.Front";
parent._frontcamera = parent.mostCurrent._camex._front /*boolean*/ ;
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=2228231;
 //BA.debugLineNum = 2228231;BA.debugLine="ToastMessageShow(\"No permission!!!\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No permission!!!"),anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 6:
//C
this.state = -1;
;
RDebugUtils.currentLine=2228233;
 //BA.debugLineNum = 2228233;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static int  _refresh_count(String _subs) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "refresh_count", false))
	 {return ((Integer) Debug.delegate(mostCurrent.activityBA, "refresh_count", new Object[] {_subs}));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Private Sub refresh_count(subs As String) As Int";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM \" & subs";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT * FROM "+_subs+"_bank")));
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="Return cursor1.RowCount";
if (true) return mostCurrent._cursor1.getRowCount();
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="End Sub";
return 0;
}
public static String  _cancel_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cancel_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cancel_click", null));}
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Private Sub cancel_Click";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="A_Name = \"\"";
mostCurrent._a_name = "";
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Q_Name = \"\"";
mostCurrent._q_name = "";
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="End Sub";
return "";
}
public static String  _change_rules_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "change_rules_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "change_rules_click", null));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Private Sub change_rules_Click";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM \" & tag_s";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT * FROM "+mostCurrent._tag_subject+"_bank")));
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="If cursor1.RowCount < 1 Then";
if (mostCurrent._cursor1.getRowCount()<1) { 
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="Msgbox2Async(\"找不到题目呢\", \"ERR\", \"OK\", \"\", \"\", Null";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("找不到题目呢"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="Return (\"\")";
if (true) return ("");
 };
RDebugUtils.currentLine=3538952;
 //BA.debugLineNum = 3538952;BA.debugLine="random_num = Rnd(0,cursor1.RowCount)";
_random_num = anywheresoftware.b4a.keywords.Common.Rnd((int) (0),mostCurrent._cursor1.getRowCount());
RDebugUtils.currentLine=3538953;
 //BA.debugLineNum = 3538953;BA.debugLine="cursor1.Position = random_num";
mostCurrent._cursor1.setPosition(_random_num);
RDebugUtils.currentLine=3538955;
 //BA.debugLineNum = 3538955;BA.debugLine="Current_ID = cursor1.GetInt(\"ID\")";
_current_id = mostCurrent._cursor1.GetInt("ID");
RDebugUtils.currentLine=3538956;
 //BA.debugLineNum = 3538956;BA.debugLine="Current_Correct_Times = cursor1.GetInt(\"Correct_T";
_current_correct_times = mostCurrent._cursor1.GetInt("Correct_Times");
RDebugUtils.currentLine=3538957;
 //BA.debugLineNum = 3538957;BA.debugLine="Current_Last_Time = cursor1.GetString(\"Last_Time\"";
mostCurrent._current_last_time = mostCurrent._cursor1.GetString("Last_Time");
RDebugUtils.currentLine=3538959;
 //BA.debugLineNum = 3538959;BA.debugLine="Return(cursor1.GetString(\"Question_Image\"))";
if (true) return (mostCurrent._cursor1.GetString("Question_Image"));
RDebugUtils.currentLine=3538960;
 //BA.debugLineNum = 3538960;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=3538961;
 //BA.debugLineNum = 3538961;BA.debugLine="Activity.LoadLayout(\"select_rule\")";
mostCurrent._activity.LoadLayout("select_rule",mostCurrent.activityBA);
RDebugUtils.currentLine=3538963;
 //BA.debugLineNum = 3538963;BA.debugLine="End Sub";
return "";
}
public static String  _chemistry_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chemistry_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chemistry_click", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub chemistry_Click";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="tag_subject= \"chemistry\"";
mostCurrent._tag_subject = "chemistry";
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="CameraClick";
_cameraclick();
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="End Sub";
return "";
}
public static String  _chemistry_imp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chemistry_imp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chemistry_imp_click", null));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Private Sub chemistry_imp_Click";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="tag_subject= \"chemistry\"";
mostCurrent._tag_subject = "chemistry";
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="Activity.LoadLayout(\"record_import\")";
mostCurrent._activity.LoadLayout("record_import",mostCurrent.activityBA);
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="End Sub";
return "";
}
public static String  _chemistry_rev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chemistry_rev_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chemistry_rev_click", null));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Private Sub chemistry_rev_Click";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="tag_subject= \"chemistry\"";
mostCurrent._tag_subject = "chemistry";
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="RevClick";
_revclick();
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="End Sub";
return "";
}
public static String  _chinese_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chinese_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chinese_click", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Private Sub chinese_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="tag_subject= \"chinese\"";
mostCurrent._tag_subject = "chinese";
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="CameraClick";
_cameraclick();
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="End Sub";
return "";
}
public static String  _chinese_imp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chinese_imp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chinese_imp_click", null));}
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Private Sub chinese_imp_Click";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="tag_subject= \"chinese\"";
mostCurrent._tag_subject = "chinese";
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="Activity.LoadLayout(\"record_import\")";
mostCurrent._activity.LoadLayout("record_import",mostCurrent.activityBA);
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="End Sub";
return "";
}
public static String  _chinese_rev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "chinese_rev_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "chinese_rev_click", null));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Private Sub chinese_rev_Click";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="tag_subject= \"chinese\"";
mostCurrent._tag_subject = "chinese";
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="RevClick";
_revclick();
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="End Sub";
return "";
}
public static String  _correct_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "correct_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "correct_click", null));}
String _tn = "";
String _table_name = "";
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Private Sub correct_Click";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="Dim tn As String";
_tn = "";
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="Dim table_name As String";
_table_name = "";
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="table_name = tag_subject & \"_bank\"";
_table_name = mostCurrent._tag_subject+"_bank";
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="Current_Correct_Times = Current_Correct_Times +1";
_current_correct_times = (int) (_current_correct_times+1);
RDebugUtils.currentLine=3145735;
 //BA.debugLineNum = 3145735;BA.debugLine="SQL1.ExecNonQuery(\"UPDATE '\"& table_name &\"' SET";
mostCurrent._sql1.ExecNonQuery("UPDATE '"+_table_name+"' SET Correct_Times = '"+BA.NumberToString(_current_correct_times)+"' WHERE  ID = '"+BA.NumberToString(_current_id)+"' ");
RDebugUtils.currentLine=3145736;
 //BA.debugLineNum = 3145736;BA.debugLine="tn = select_question(tag_subject)";
_tn = _select_question(mostCurrent._tag_subject);
RDebugUtils.currentLine=3145738;
 //BA.debugLineNum = 3145738;BA.debugLine="If tn = \"\" Then";
if ((_tn).equals("")) { 
RDebugUtils.currentLine=3145739;
 //BA.debugLineNum = 3145739;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=3145741;
 //BA.debugLineNum = 3145741;BA.debugLine="Refresh_question(random_num)";
_refresh_question(_random_num);
RDebugUtils.currentLine=3145742;
 //BA.debugLineNum = 3145742;BA.debugLine="End Sub";
return "";
}
public static String  _select_question(String _subject) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "select_question", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "select_question", new Object[] {_subject}));}
String _table_name = "";
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="private Sub select_question(subject As String) As";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="Dim table_name As String";
_table_name = "";
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="table_name = subject & \"_bank\"";
_table_name = _subject+"_bank";
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM \" & table";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT * FROM "+_table_name)));
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="If cursor1.RowCount < 1 Then";
if (mostCurrent._cursor1.getRowCount()<1) { 
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="Msgbox2Async(\"找不到题目呢\", \"ERR\", \"OK\", \"\", \"\", Null";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("找不到题目呢"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="Return (\"\")";
if (true) return ("");
 };
RDebugUtils.currentLine=3211273;
 //BA.debugLineNum = 3211273;BA.debugLine="random_num = Rnd(0,cursor1.RowCount)";
_random_num = anywheresoftware.b4a.keywords.Common.Rnd((int) (0),mostCurrent._cursor1.getRowCount());
RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="cursor1.Position = random_num";
mostCurrent._cursor1.setPosition(_random_num);
RDebugUtils.currentLine=3211276;
 //BA.debugLineNum = 3211276;BA.debugLine="Current_ID = cursor1.GetInt(\"ID\")";
_current_id = mostCurrent._cursor1.GetInt("ID");
RDebugUtils.currentLine=3211277;
 //BA.debugLineNum = 3211277;BA.debugLine="Current_Correct_Times = cursor1.GetInt(\"Correct_T";
_current_correct_times = mostCurrent._cursor1.GetInt("Correct_Times");
RDebugUtils.currentLine=3211278;
 //BA.debugLineNum = 3211278;BA.debugLine="Current_Last_Time = cursor1.GetString(\"Last_Time\"";
mostCurrent._current_last_time = mostCurrent._cursor1.GetString("Last_Time");
RDebugUtils.currentLine=3211280;
 //BA.debugLineNum = 3211280;BA.debugLine="Return(cursor1.GetString(\"Question_Image\"))";
if (true) return (mostCurrent._cursor1.GetString("Question_Image"));
RDebugUtils.currentLine=3211282;
 //BA.debugLineNum = 3211282;BA.debugLine="End Sub";
return "";
}
public static String  _refresh_question(int _cn) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "refresh_question", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "refresh_question", new Object[] {_cn}));}
String _question_file = "";
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap1 = null;
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Private Sub Refresh_question(cn As Int)";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="Dim Question_file As String";
_question_file = "";
RDebugUtils.currentLine=3276803;
 //BA.debugLineNum = 3276803;BA.debugLine="TouchImageView1.MinScale=0.25			'	default is 0.5";
mostCurrent._touchimageview1.setMinScale((float) (0.25));
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="TouchImageView1.MaxScale=2				'	default is 1.5";
mostCurrent._touchimageview1.setMaxScale((float) (2));
RDebugUtils.currentLine=3276805;
 //BA.debugLineNum = 3276805;BA.debugLine="TouchImageView1.TranslatePadding=128dip	'	default";
mostCurrent._touchimageview1.setTranslatePadding(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (128)));
RDebugUtils.currentLine=3276807;
 //BA.debugLineNum = 3276807;BA.debugLine="Question_file = File.Combine(File.DirDefaultExter";
_question_file = anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),mostCurrent._cursor1.GetString("Question_Image"));
RDebugUtils.currentLine=3276810;
 //BA.debugLineNum = 3276810;BA.debugLine="Dim Bitmap1 As Bitmap";
_bitmap1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=3276811;
 //BA.debugLineNum = 3276811;BA.debugLine="Bitmap1.Initialize(File.DirDefaultExternal,cursor";
_bitmap1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),mostCurrent._cursor1.GetString("Question_Image"));
RDebugUtils.currentLine=3276813;
 //BA.debugLineNum = 3276813;BA.debugLine="TouchImageView1.SetBitmap(Bitmap1)";
mostCurrent._touchimageview1.SetBitmap(mostCurrent.activityBA,(android.graphics.Bitmap)(_bitmap1.getObject()));
RDebugUtils.currentLine=3276815;
 //BA.debugLineNum = 3276815;BA.debugLine="QA_S = 0";
_qa_s = (int) (0);
RDebugUtils.currentLine=3276816;
 //BA.debugLineNum = 3276816;BA.debugLine="End Sub";
return "";
}
public static String  _dbload() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dbload", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "dbload", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub DBload";
RDebugUtils.currentLine=196611;
 //BA.debugLineNum = 196611;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM \" & tag_s";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT * FROM "+mostCurrent._tag_subject+"_bank")));
RDebugUtils.currentLine=196620;
 //BA.debugLineNum = 196620;BA.debugLine="End Sub";
return "";
}
public static String  _english_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "english_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "english_click", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Private Sub english_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="tag_subject= \"english\"";
mostCurrent._tag_subject = "english";
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="CameraClick";
_cameraclick();
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="End Sub";
return "";
}
public static String  _english_imp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "english_imp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "english_imp_click", null));}
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Private Sub english_imp_Click";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="tag_subject= \"english\"";
mostCurrent._tag_subject = "english";
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="Activity.LoadLayout(\"record_import\")";
mostCurrent._activity.LoadLayout("record_import",mostCurrent.activityBA);
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="End Sub";
return "";
}
public static String  _english_rev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "english_rev_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "english_rev_click", null));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Private Sub english_rev_Click";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="tag_subject= \"english\"";
mostCurrent._tag_subject = "english";
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="RevClick";
_revclick();
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="End Sub";
return "";
}
public static void  _get_tags(String _subject) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "get_tags", false))
	 {Debug.delegate(mostCurrent.activityBA, "get_tags", new Object[] {_subject}); return;}
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
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Do While True";
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
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Dim DuplicateTest As Boolean = False";
_duplicatetest = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM tags wher";
parent.mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(parent.mostCurrent._sql1.ExecQuery("SELECT * FROM tags where Subject =  '"+_subject+"' ")));
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="If cursor1.RowCount < 1 Then";
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
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="Msgbox2Async(\"当前科目还没有任何tag\", \"Warning\", \"OK\", \"\"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("当前科目还没有任何tag"),BA.ObjectToCharSequence("Warning"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 7:
//C
this.state = 8;
;
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="Dim i As Int";
_i = 0;
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="Dim tag(cursor1.RowCount) As String";
_tag = new String[parent.mostCurrent._cursor1.getRowCount()];
java.util.Arrays.fill(_tag,"");
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="For i = 0 To cursor1.RowCount - 1";
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
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="cursor1.Position = i";
parent.mostCurrent._cursor1.setPosition(_i);
RDebugUtils.currentLine=851980;
 //BA.debugLineNum = 851980;BA.debugLine="tag(i) = cursor1.GetString(\"tag_name\")";
_tag[_i] = parent.mostCurrent._cursor1.GetString("tag_name");
 if (true) break;
if (true) break;

case 11:
//C
this.state = 12;
;
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="options.Initialize";
parent.mostCurrent._options._initialize /*String*/ (null,mostCurrent.activityBA);
RDebugUtils.currentLine=851984;
 //BA.debugLineNum = 851984;BA.debugLine="options.AllowMultiSelection = True";
parent.mostCurrent._options._allowmultiselection /*boolean*/  = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=851985;
 //BA.debugLineNum = 851985;BA.debugLine="options.Resize(300dip,200dip)";
parent.mostCurrent._options._resize /*String*/ (null,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (300)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (200)));
RDebugUtils.currentLine=851986;
 //BA.debugLineNum = 851986;BA.debugLine="options.Options = tag";
parent.mostCurrent._options._options /*anywheresoftware.b4a.objects.collections.List*/  = anywheresoftware.b4a.keywords.Common.ArrayToList(_tag);
RDebugUtils.currentLine=851988;
 //BA.debugLineNum = 851988;BA.debugLine="Wait For (TagDialog.ShowTemplate(options, \"OK\", \"";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "get_tags"), parent.mostCurrent._tagdialog._showtemplate /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,(Object)(parent.mostCurrent._options),(Object)("OK"),(Object)("ADD"),(Object)("CANCEL")));
this.state = 44;
return;
case 44:
//C
this.state = 12;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=851989;
 //BA.debugLineNum = 851989;BA.debugLine="Select Result";
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
RDebugUtils.currentLine=851991;
 //BA.debugLineNum = 851991;BA.debugLine="TagDialog.Show($\"选择的类别： ${options.SelectedItems}";
parent.mostCurrent._tagdialog._show /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,(Object)(("选择的类别： "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(parent.mostCurrent._options._selecteditems /*anywheresoftware.b4a.objects.collections.List*/ .getObject()))+"")),(Object)("OK"),(Object)(""),(Object)(""));
RDebugUtils.currentLine=851992;
 //BA.debugLineNum = 851992;BA.debugLine="Return";
if (true) return ;
RDebugUtils.currentLine=851993;
 //BA.debugLineNum = 851993;BA.debugLine="Exit";
this.state = 40;
if (true) break;
 if (true) break;

case 16:
//C
this.state = 17;
RDebugUtils.currentLine=851995;
 //BA.debugLineNum = 851995;BA.debugLine="InputTag.Initialize";
parent.mostCurrent._inputtag._initialize /*String*/ (null,mostCurrent.activityBA);
RDebugUtils.currentLine=851996;
 //BA.debugLineNum = 851996;BA.debugLine="InputTag.lblTitle.Text = \"添加标签\"";
parent.mostCurrent._inputtag._lbltitle /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setText(BA.ObjectToCharSequence("添加标签"));
RDebugUtils.currentLine=851997;
 //BA.debugLineNum = 851997;BA.debugLine="Wait For (TagDialog.ShowTemplate(InputTag, \"OK\",";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "get_tags"), parent.mostCurrent._tagdialog._showtemplate /*anywheresoftware.b4a.keywords.Common.ResumableSubWrapper*/ (null,(Object)(parent.mostCurrent._inputtag),(Object)("OK"),(Object)(""),(Object)("CANCEL")));
this.state = 45;
return;
case 45:
//C
this.state = 17;
_result = (Integer) result[0];
;
RDebugUtils.currentLine=851998;
 //BA.debugLineNum = 851998;BA.debugLine="If Result = xui.DialogResponse_Positive Then";
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
RDebugUtils.currentLine=851999;
 //BA.debugLineNum = 851999;BA.debugLine="If InputTag.Text = \"\" Then";
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
RDebugUtils.currentLine=852000;
 //BA.debugLineNum = 852000;BA.debugLine="Msgbox2Async(\"还没有填标签名称呢！！\", \"ERR\", \"OK\", \"\", \"";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("还没有填标签名称呢！！"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=852001;
 //BA.debugLineNum = 852001;BA.debugLine="Continue";
this.state = 40;
if (true) break;;
 if (true) break;

case 24:
//C
this.state = 25;
RDebugUtils.currentLine=852003;
 //BA.debugLineNum = 852003;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT * FROM tags W";
parent.mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(parent.mostCurrent._sql1.ExecQuery("SELECT * FROM tags WHERE subject = '"+parent.mostCurrent._tag_subject+"'")));
RDebugUtils.currentLine=852004;
 //BA.debugLineNum = 852004;BA.debugLine="For i = 0 To cursor1.RowCount - 1";
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
RDebugUtils.currentLine=852005;
 //BA.debugLineNum = 852005;BA.debugLine="cursor1.Position = i";
parent.mostCurrent._cursor1.setPosition(_i);
RDebugUtils.currentLine=852006;
 //BA.debugLineNum = 852006;BA.debugLine="If InputTag.Text = cursor1.GetString(\"tag_nam";
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
RDebugUtils.currentLine=852007;
 //BA.debugLineNum = 852007;BA.debugLine="Msgbox2Async(\"标签名重了！！\", \"ERR\", \"OK\", \"\", \"\",";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("标签名重了！！"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=852008;
 //BA.debugLineNum = 852008;BA.debugLine="DuplicateTest = True";
_duplicatetest = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=852009;
 //BA.debugLineNum = 852009;BA.debugLine="Continue";
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
;
 if (true) break;
;
RDebugUtils.currentLine=852013;
 //BA.debugLineNum = 852013;BA.debugLine="If Not(DuplicateTest) Then";

case 33:
//if
this.state = 36;
if (anywheresoftware.b4a.keywords.Common.Not(_duplicatetest)) { 
this.state = 35;
}if (true) break;

case 35:
//C
this.state = 36;
RDebugUtils.currentLine=852014;
 //BA.debugLineNum = 852014;BA.debugLine="SQL1.ExecNonQuery(\"INSERT INTO tags (tag_name,";
parent.mostCurrent._sql1.ExecNonQuery("INSERT INTO tags (tag_name,subject) VALUES ('"+parent.mostCurrent._inputtag._text /*String*/ +"','"+parent.mostCurrent._tag_subject+"')");
RDebugUtils.currentLine=852015;
 //BA.debugLineNum = 852015;BA.debugLine="ToastMessageShow( tag_subject & \" label '\" & I";
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
RDebugUtils.currentLine=852019;
 //BA.debugLineNum = 852019;BA.debugLine="Return";
if (true) return ;
RDebugUtils.currentLine=852020;
 //BA.debugLineNum = 852020;BA.debugLine="Exit";
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
RDebugUtils.currentLine=852023;
 //BA.debugLineNum = 852023;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _incorrect_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "incorrect_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "incorrect_click", null));}
String _tn = "";
String _table_name = "";
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Private Sub incorrect_Click";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="Dim tn As String";
_tn = "";
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="Dim table_name As String";
_table_name = "";
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="table_name = tag_subject & \"_bank\"";
_table_name = mostCurrent._tag_subject+"_bank";
RDebugUtils.currentLine=3342341;
 //BA.debugLineNum = 3342341;BA.debugLine="Current_Incorrect_Times = Current_Incorrect_Times";
_current_incorrect_times = (int) (_current_incorrect_times+1);
RDebugUtils.currentLine=3342342;
 //BA.debugLineNum = 3342342;BA.debugLine="SQL1.ExecNonQuery(\"UPDATE '\"& table_name &\"' SET";
mostCurrent._sql1.ExecNonQuery("UPDATE '"+_table_name+"' SET Incorrect_Times = '"+BA.NumberToString(_current_incorrect_times)+"' WHERE  ID = '"+BA.NumberToString(_current_id)+"' ");
RDebugUtils.currentLine=3342344;
 //BA.debugLineNum = 3342344;BA.debugLine="tn = select_question(tag_subject)";
_tn = _select_question(mostCurrent._tag_subject);
RDebugUtils.currentLine=3342346;
 //BA.debugLineNum = 3342346;BA.debugLine="Refresh_question(random_num)";
_refresh_question(_random_num);
RDebugUtils.currentLine=3342347;
 //BA.debugLineNum = 3342347;BA.debugLine="End Sub";
return "";
}
public static String  _maths_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "maths_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "maths_click", null));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Private Sub maths_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="tag_subject= \"maths\"";
mostCurrent._tag_subject = "maths";
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="CameraClick";
_cameraclick();
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="End Sub";
return "";
}
public static String  _maths_imp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "maths_imp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "maths_imp_click", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Private Sub maths_imp_Click";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="tag_subject= \"maths\"";
mostCurrent._tag_subject = "maths";
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="Activity.LoadLayout(\"record_import\")";
mostCurrent._activity.LoadLayout("record_import",mostCurrent.activityBA);
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="End Sub";
return "";
}
public static String  _maths_rev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "maths_rev_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "maths_rev_click", null));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Private Sub maths_rev_Click";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="tag_subject= \"maths\"";
mostCurrent._tag_subject = "maths";
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="RevClick";
_revclick();
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="End Sub";
return "";
}
public static String  _physics_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "physics_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "physics_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub physics_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="tag_subject= \"physics\"";
mostCurrent._tag_subject = "physics";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="CameraClick";
_cameraclick();
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="End Sub";
return "";
}
public static String  _physics_imp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "physics_imp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "physics_imp_click", null));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Private Sub physics_imp_Click";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="tag_subject= \"physics\"";
mostCurrent._tag_subject = "physics";
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="Activity.LoadLayout(\"record_import\")";
mostCurrent._activity.LoadLayout("record_import",mostCurrent.activityBA);
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="QuesFileName = \" \"";
mostCurrent._quesfilename = " ";
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="AnsFileName = \" \"";
mostCurrent._ansfilename = " ";
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="End Sub";
return "";
}
public static String  _physics_rev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "physics_rev_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "physics_rev_click", null));}
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Private Sub physics_rev_Click";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="tag_subject= \"physics\"";
mostCurrent._tag_subject = "physics";
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="RevClick";
_revclick();
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="End Sub";
return "";
}
public static String  _quit_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "quit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "quit_click", null));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Private Sub quit_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
public static String  _r_return_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "r_return_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "r_return_click", null));}
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Private Sub r_return_Click";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="Activity.LoadLayout(\"subjects\")";
mostCurrent._activity.LoadLayout("subjects",mostCurrent.activityBA);
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="End Sub";
return "";
}
public static String  _record_camera_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "record_camera_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "record_camera_click", null));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Private Sub record_camera_Click";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Activity.LoadLayout (\"subjects\")";
mostCurrent._activity.LoadLayout("subjects",mostCurrent.activityBA);
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="End Sub";
return "";
}
public static String  _record_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "record_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "record_click", null));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub record_Click";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Activity.LoadLayout(\"record_choice\")";
mostCurrent._activity.LoadLayout("record_choice",mostCurrent.activityBA);
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="End Sub";
return "";
}
public static String  _record_import_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "record_import_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "record_import_click", null));}
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Private Sub record_import_Click";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Activity.LoadLayout(\"subjects_imp\")";
mostCurrent._activity.LoadLayout("subjects_imp",mostCurrent.activityBA);
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="End Sub";
return "";
}
public static String  _review_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "review_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "review_click", null));}
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Private Sub review_Click";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="Activity.RemoveAllViews";
mostCurrent._activity.RemoveAllViews();
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Activity.LoadLayout(\"subjects_rev\")";
mostCurrent._activity.LoadLayout("subjects_rev",mostCurrent.activityBA);
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="End Sub";
return "";
}
public static String  _submit_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "submit_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "submit_click", null));}
String _table_name = "";
String _td = "";
int _level = 0;
int _newid = 0;
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Private Sub submit_Click";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="If  A_Name = \"\" Or Q_Name = \"\" Then";
if ((mostCurrent._a_name).equals("") || (mostCurrent._q_name).equals("")) { 
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="Msgbox2Async(\"请先拍题目再拍答案\", \"ERR\", \"OK\", \"\", \"\", N";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("请先拍题目再拍答案"),BA.ObjectToCharSequence("ERR"),"OK","","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="Dim table_name As String";
_table_name = "";
RDebugUtils.currentLine=2490374;
 //BA.debugLineNum = 2490374;BA.debugLine="table_name = tag_subject & \"_bank\"";
_table_name = mostCurrent._tag_subject+"_bank";
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="Dim td As String";
_td = "";
RDebugUtils.currentLine=2490376;
 //BA.debugLineNum = 2490376;BA.debugLine="td = now_string";
_td = _now_string();
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="Dim level As Int";
_level = 0;
RDebugUtils.currentLine=2490378;
 //BA.debugLineNum = 2490378;BA.debugLine="level = 1";
_level = (int) (1);
RDebugUtils.currentLine=2490379;
 //BA.debugLineNum = 2490379;BA.debugLine="Dim NewID As Int = 0";
_newid = (int) (0);
RDebugUtils.currentLine=2490380;
 //BA.debugLineNum = 2490380;BA.debugLine="cursor1 = SQL1.ExecQuery(\"SELECT ID FROM \" & tabl";
mostCurrent._cursor1 = (anywheresoftware.b4a.sql.SQL.CursorWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.sql.SQL.CursorWrapper(), (android.database.Cursor)(mostCurrent._sql1.ExecQuery("SELECT ID FROM "+_table_name)));
RDebugUtils.currentLine=2490390;
 //BA.debugLineNum = 2490390;BA.debugLine="NewID = cursor1.RowCount + 1 ' add 1 to the ID nu";
_newid = (int) (mostCurrent._cursor1.getRowCount()+1);
RDebugUtils.currentLine=2490391;
 //BA.debugLineNum = 2490391;BA.debugLine="get_tags(tag_subject)";
_get_tags(mostCurrent._tag_subject);
RDebugUtils.currentLine=2490394;
 //BA.debugLineNum = 2490394;BA.debugLine="SQL1.ExecNonQuery(\"INSERT INTO \" & table_name &\"";
mostCurrent._sql1.ExecNonQuery("INSERT INTO "+_table_name+"  (ID,Time_Create,Valid,Level,Question_Image,Answer_Image)  VALUES('"+BA.NumberToString(_newid)+"','"+_td+"','"+_td+"','"+BA.NumberToString(_level)+"','"+mostCurrent._q_name+".jpg"+"','"+mostCurrent._a_name+".jpg"+"')");
RDebugUtils.currentLine=2490395;
 //BA.debugLineNum = 2490395;BA.debugLine="A_Name = \"\"";
mostCurrent._a_name = "";
RDebugUtils.currentLine=2490396;
 //BA.debugLineNum = 2490396;BA.debugLine="Q_Name = \"\"";
mostCurrent._q_name = "";
RDebugUtils.currentLine=2490398;
 //BA.debugLineNum = 2490398;BA.debugLine="q_count.Text = \"总题数：\" & refresh_count(tag_subject";
mostCurrent._q_count.setText(BA.ObjectToCharSequence("总题数："+BA.NumberToString(_refresh_count(mostCurrent._tag_subject))));
RDebugUtils.currentLine=2490399;
 //BA.debugLineNum = 2490399;BA.debugLine="End Sub";
return "";
}
public static String  _switch_qa_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "switch_qa_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "switch_qa_click", null));}
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bitmap1 = null;
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Private Sub switch_qa_Click";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="Dim Bitmap1 As Bitmap";
_bitmap1 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="If QA_S =0 Then";
if (_qa_s==0) { 
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="QA_S = 1";
_qa_s = (int) (1);
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="Bitmap1.Initialize(File.DirDefaultExternal,curso";
_bitmap1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),mostCurrent._cursor1.GetString("Answer_Image"));
 }else {
RDebugUtils.currentLine=3407878;
 //BA.debugLineNum = 3407878;BA.debugLine="QA_S = 0";
_qa_s = (int) (0);
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="Bitmap1.Initialize(File.DirDefaultExternal,curso";
_bitmap1.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirDefaultExternal(),mostCurrent._cursor1.GetString("Question_Image"));
 };
RDebugUtils.currentLine=3407881;
 //BA.debugLineNum = 3407881;BA.debugLine="TouchImageView1.SetBitmap(Bitmap1)";
mostCurrent._touchimageview1.SetBitmap(mostCurrent.activityBA,(android.graphics.Bitmap)(_bitmap1.getObject()));
RDebugUtils.currentLine=3407882;
 //BA.debugLineNum = 3407882;BA.debugLine="End Sub";
return "";
}
}