package avanue.nvwa;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class b4xseekbar extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "avanue.nvwa.b4xseekbar");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", avanue.nvwa.b4xseekbar.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public String _meventname = "";
public Object _mcallback = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public int _color1 = 0;
public int _color2 = 0;
public int _thumbcolor = 0;
public anywheresoftware.b4a.objects.B4XCanvas _cvs = null;
public Object _tag = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _touchpanel = null;
public int _mvalue = 0;
public int _minvalue = 0;
public int _maxvalue = 0;
public int _interval = 0;
public boolean _vertical = false;
public int _size1 = 0;
public int _size2 = 0;
public int _radius1 = 0;
public int _radius2 = 0;
public boolean _pressed = false;
public int _size = 0;
public b4a.example.dateutils _dateutils = null;
public avanue.nvwa.main _main = null;
public avanue.nvwa.starter _starter = null;
public avanue.nvwa.xuiviewsutils _xuiviewsutils = null;
public String  _base_resize(avanue.nvwa.b4xseekbar __ref,double _width,double _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xseekbar";
if (Debug.shouldDelegate(ba, "base_resize", true))
	 {return ((String) Debug.delegate(ba, "base_resize", new Object[] {_width,_height}));}
RDebugUtils.currentLine=24641536;
 //BA.debugLineNum = 24641536;BA.debugLine="Private Sub Base_Resize (Width As Double, Height A";
RDebugUtils.currentLine=24641537;
 //BA.debugLineNum = 24641537;BA.debugLine="cvs.Resize(Width, Height)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Resize((float) (_width),(float) (_height));
RDebugUtils.currentLine=24641538;
 //BA.debugLineNum = 24641538;BA.debugLine="TouchPanel.SetLayoutAnimated(0, 0, 0, Width, Heig";
__ref._touchpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
RDebugUtils.currentLine=24641539;
 //BA.debugLineNum = 24641539;BA.debugLine="Vertical = mBase.Height > mBase.Width";
__ref._vertical /*boolean*/  = __ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight()>__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth();
RDebugUtils.currentLine=24641540;
 //BA.debugLineNum = 24641540;BA.debugLine="size = Max(mBase.Height, mBase.Width) - 2 * Radiu";
__ref._size /*int*/  = (int) (__c.Max(__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight(),__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth())-2*__ref._radius2 /*int*/ );
RDebugUtils.currentLine=24641541;
 //BA.debugLineNum = 24641541;BA.debugLine="Update";
__ref._update /*String*/ (null);
RDebugUtils.currentLine=24641542;
 //BA.debugLineNum = 24641542;BA.debugLine="End Sub";
return "";
}
public String  _update(avanue.nvwa.b4xseekbar __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xseekbar";
if (Debug.shouldDelegate(ba, "update", true))
	 {return ((String) Debug.delegate(ba, "update", null));}
int _s1 = 0;
int _y = 0;
int _x = 0;
RDebugUtils.currentLine=24707072;
 //BA.debugLineNum = 24707072;BA.debugLine="Public Sub Update";
RDebugUtils.currentLine=24707074;
 //BA.debugLineNum = 24707074;BA.debugLine="cvs.ClearRect(cvs.TargetRect)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .ClearRect(__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .getTargetRect());
RDebugUtils.currentLine=24707075;
 //BA.debugLineNum = 24707075;BA.debugLine="If size > 0 Then";
if (__ref._size /*int*/ >0) { 
RDebugUtils.currentLine=24707076;
 //BA.debugLineNum = 24707076;BA.debugLine="If Vertical = False Then";
if (__ref._vertical /*boolean*/ ==__c.False) { 
RDebugUtils.currentLine=24707077;
 //BA.debugLineNum = 24707077;BA.debugLine="Dim s1 As Int = Radius2 + (mValue - MinValue) /";
_s1 = (int) (__ref._radius2 /*int*/ +(__ref._mvalue /*int*/ -__ref._minvalue /*int*/ )/(double)(__ref._maxvalue /*int*/ -__ref._minvalue /*int*/ )*__ref._size /*int*/ );
RDebugUtils.currentLine=24707078;
 //BA.debugLineNum = 24707078;BA.debugLine="Dim y As Int = mBase.Height / 2";
_y = (int) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight()/(double)2);
RDebugUtils.currentLine=24707079;
 //BA.debugLineNum = 24707079;BA.debugLine="cvs.DrawLine(Radius2, y, s1, y, Color1, Size1)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine((float) (__ref._radius2 /*int*/ ),(float) (_y),(float) (_s1),(float) (_y),__ref._color1 /*int*/ ,(float) (__ref._size1 /*int*/ ));
RDebugUtils.currentLine=24707080;
 //BA.debugLineNum = 24707080;BA.debugLine="cvs.DrawLine(s1, y, mBase.Width - Radius2, y, C";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine((float) (_s1),(float) (_y),(float) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()-__ref._radius2 /*int*/ ),(float) (_y),__ref._color2 /*int*/ ,(float) (__ref._size2 /*int*/ ));
RDebugUtils.currentLine=24707081;
 //BA.debugLineNum = 24707081;BA.debugLine="cvs.DrawCircle(s1, y, Radius1, Color1, True, 0)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (_s1),(float) (_y),(float) (__ref._radius1 /*int*/ ),__ref._color1 /*int*/ ,__c.True,(float) (0));
RDebugUtils.currentLine=24707082;
 //BA.debugLineNum = 24707082;BA.debugLine="If Pressed Then";
if (__ref._pressed /*boolean*/ ) { 
RDebugUtils.currentLine=24707083;
 //BA.debugLineNum = 24707083;BA.debugLine="cvs.DrawCircle(s1, y, Radius2, ThumbColor, Tru";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (_s1),(float) (_y),(float) (__ref._radius2 /*int*/ ),__ref._thumbcolor /*int*/ ,__c.True,(float) (0));
 };
 }else {
RDebugUtils.currentLine=24707086;
 //BA.debugLineNum = 24707086;BA.debugLine="Dim s1 As Int = Radius2 + (MaxValue - mValue) /";
_s1 = (int) (__ref._radius2 /*int*/ +(__ref._maxvalue /*int*/ -__ref._mvalue /*int*/ )/(double)(__ref._maxvalue /*int*/ -__ref._minvalue /*int*/ )*__ref._size /*int*/ );
RDebugUtils.currentLine=24707087;
 //BA.debugLineNum = 24707087;BA.debugLine="Dim x As Int = mBase.Width / 2";
_x = (int) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth()/(double)2);
RDebugUtils.currentLine=24707088;
 //BA.debugLineNum = 24707088;BA.debugLine="cvs.DrawLine(x, Radius2, x, s1, Color2, Size2)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine((float) (_x),(float) (__ref._radius2 /*int*/ ),(float) (_x),(float) (_s1),__ref._color2 /*int*/ ,(float) (__ref._size2 /*int*/ ));
RDebugUtils.currentLine=24707089;
 //BA.debugLineNum = 24707089;BA.debugLine="cvs.DrawLine(x, s1, x, mBase.Height - Radius2,";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawLine((float) (_x),(float) (_s1),(float) (_x),(float) (__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight()-__ref._radius2 /*int*/ ),__ref._color1 /*int*/ ,(float) (__ref._size1 /*int*/ ));
RDebugUtils.currentLine=24707090;
 //BA.debugLineNum = 24707090;BA.debugLine="cvs.DrawCircle(x, s1, Radius1, Color1, True, 0)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (_x),(float) (_s1),(float) (__ref._radius1 /*int*/ ),__ref._color1 /*int*/ ,__c.True,(float) (0));
RDebugUtils.currentLine=24707091;
 //BA.debugLineNum = 24707091;BA.debugLine="If Pressed Then";
if (__ref._pressed /*boolean*/ ) { 
RDebugUtils.currentLine=24707092;
 //BA.debugLineNum = 24707092;BA.debugLine="cvs.DrawCircle(x, s1, Radius2, ThumbColor, Tru";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .DrawCircle((float) (_x),(float) (_s1),(float) (__ref._radius2 /*int*/ ),__ref._thumbcolor /*int*/ ,__c.True,(float) (0));
 };
 };
 };
RDebugUtils.currentLine=24707096;
 //BA.debugLineNum = 24707096;BA.debugLine="cvs.Invalidate";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Invalidate();
RDebugUtils.currentLine=24707097;
 //BA.debugLineNum = 24707097;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(avanue.nvwa.b4xseekbar __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xseekbar";
RDebugUtils.currentLine=24444928;
 //BA.debugLineNum = 24444928;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=24444929;
 //BA.debugLineNum = 24444929;BA.debugLine="Private mEventName As String 'ignore";
_meventname = "";
RDebugUtils.currentLine=24444930;
 //BA.debugLineNum = 24444930;BA.debugLine="Private mCallBack As Object 'ignore";
_mcallback = new Object();
RDebugUtils.currentLine=24444931;
 //BA.debugLineNum = 24444931;BA.debugLine="Public mBase As B4XView 'ignore";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=24444932;
 //BA.debugLineNum = 24444932;BA.debugLine="Private xui As XUI 'ignore";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=24444933;
 //BA.debugLineNum = 24444933;BA.debugLine="Public Color1, Color2, ThumbColor As Int";
_color1 = 0;
_color2 = 0;
_thumbcolor = 0;
RDebugUtils.currentLine=24444934;
 //BA.debugLineNum = 24444934;BA.debugLine="Private cvs As B4XCanvas";
_cvs = new anywheresoftware.b4a.objects.B4XCanvas();
RDebugUtils.currentLine=24444935;
 //BA.debugLineNum = 24444935;BA.debugLine="Public Tag As Object";
_tag = new Object();
RDebugUtils.currentLine=24444936;
 //BA.debugLineNum = 24444936;BA.debugLine="Private TouchPanel As B4XView";
_touchpanel = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=24444937;
 //BA.debugLineNum = 24444937;BA.debugLine="Private mValue As Int";
_mvalue = 0;
RDebugUtils.currentLine=24444938;
 //BA.debugLineNum = 24444938;BA.debugLine="Public MinValue, MaxValue As Int";
_minvalue = 0;
_maxvalue = 0;
RDebugUtils.currentLine=24444939;
 //BA.debugLineNum = 24444939;BA.debugLine="Public Interval As Int = 1";
_interval = (int) (1);
RDebugUtils.currentLine=24444940;
 //BA.debugLineNum = 24444940;BA.debugLine="Private Vertical As Boolean";
_vertical = false;
RDebugUtils.currentLine=24444941;
 //BA.debugLineNum = 24444941;BA.debugLine="Public Size1 = 4dip, Size2 = 2dip, Radius1 = 6dip";
_size1 = __c.DipToCurrent((int) (4));
_size2 = __c.DipToCurrent((int) (2));
_radius1 = __c.DipToCurrent((int) (6));
_radius2 = __c.DipToCurrent((int) (12));
RDebugUtils.currentLine=24444942;
 //BA.debugLineNum = 24444942;BA.debugLine="Private Pressed As Boolean";
_pressed = false;
RDebugUtils.currentLine=24444943;
 //BA.debugLineNum = 24444943;BA.debugLine="Private size As Int";
_size = 0;
RDebugUtils.currentLine=24444944;
 //BA.debugLineNum = 24444944;BA.debugLine="End Sub";
return "";
}
public String  _designercreateview(avanue.nvwa.b4xseekbar __ref,Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xseekbar";
if (Debug.shouldDelegate(ba, "designercreateview", true))
	 {return ((String) Debug.delegate(ba, "designercreateview", new Object[] {_base,_lbl,_props}));}
RDebugUtils.currentLine=24576000;
 //BA.debugLineNum = 24576000;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
RDebugUtils.currentLine=24576001;
 //BA.debugLineNum = 24576001;BA.debugLine="mBase = Base";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_base));
RDebugUtils.currentLine=24576002;
 //BA.debugLineNum = 24576002;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
__ref._tag /*Object*/  = __ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getTag();
RDebugUtils.currentLine=24576002;
 //BA.debugLineNum = 24576002;BA.debugLine="Tag = mBase.Tag : mBase.Tag = Me";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .setTag(this);
RDebugUtils.currentLine=24576003;
 //BA.debugLineNum = 24576003;BA.debugLine="Color1 = xui.PaintOrColorToColor(Props.Get(\"Color";
__ref._color1 /*int*/  = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .PaintOrColorToColor(_props.Get((Object)("Color1")));
RDebugUtils.currentLine=24576004;
 //BA.debugLineNum = 24576004;BA.debugLine="Color2 = xui.PaintOrColorToColor(Props.Get(\"Color";
__ref._color2 /*int*/  = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .PaintOrColorToColor(_props.Get((Object)("Color2")));
RDebugUtils.currentLine=24576005;
 //BA.debugLineNum = 24576005;BA.debugLine="ThumbColor = xui.PaintOrColorToColor(Props.Get(\"T";
__ref._thumbcolor /*int*/  = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .PaintOrColorToColor(_props.Get((Object)("ThumbColor")));
RDebugUtils.currentLine=24576006;
 //BA.debugLineNum = 24576006;BA.debugLine="Interval = Max(1, Props.GetDefault(\"Interval\", 1)";
__ref._interval /*int*/  = (int) (__c.Max(1,(double)(BA.ObjectToNumber(_props.GetDefault((Object)("Interval"),(Object)(1))))));
RDebugUtils.currentLine=24576007;
 //BA.debugLineNum = 24576007;BA.debugLine="MinValue = Props.Get(\"Min\")";
__ref._minvalue /*int*/  = (int)(BA.ObjectToNumber(_props.Get((Object)("Min"))));
RDebugUtils.currentLine=24576008;
 //BA.debugLineNum = 24576008;BA.debugLine="MaxValue = Props.Get(\"Max\")";
__ref._maxvalue /*int*/  = (int)(BA.ObjectToNumber(_props.Get((Object)("Max"))));
RDebugUtils.currentLine=24576009;
 //BA.debugLineNum = 24576009;BA.debugLine="mValue = Max(MinValue, Min(MaxValue, Props.Get(\"V";
__ref._mvalue /*int*/  = (int) (__c.Max(__ref._minvalue /*int*/ ,__c.Min(__ref._maxvalue /*int*/ ,(double)(BA.ObjectToNumber(_props.Get((Object)("Value")))))));
RDebugUtils.currentLine=24576010;
 //BA.debugLineNum = 24576010;BA.debugLine="cvs.Initialize(mBase)";
__ref._cvs /*anywheresoftware.b4a.objects.B4XCanvas*/ .Initialize(__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ );
RDebugUtils.currentLine=24576011;
 //BA.debugLineNum = 24576011;BA.debugLine="TouchPanel = xui.CreatePanel(\"TouchPanel\")";
__ref._touchpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .CreatePanel(ba,"TouchPanel");
RDebugUtils.currentLine=24576012;
 //BA.debugLineNum = 24576012;BA.debugLine="mBase.AddView(TouchPanel, 0, 0, mBase.Width, mBas";
__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .AddView((android.view.View)(__ref._touchpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getObject()),(int) (0),(int) (0),__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth(),__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight());
RDebugUtils.currentLine=24576013;
 //BA.debugLineNum = 24576013;BA.debugLine="If xui.IsB4A Or xui.IsB4i Then Radius2 = 20dip";
if (__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .getIsB4A() || __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .getIsB4i()) { 
__ref._radius2 /*int*/  = __c.DipToCurrent((int) (20));};
RDebugUtils.currentLine=24576014;
 //BA.debugLineNum = 24576014;BA.debugLine="If xui.IsB4A Then Base_Resize(mBase.Width, mBase.";
if (__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .getIsB4A()) { 
__ref._base_resize /*String*/ (null,__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getWidth(),__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight());};
RDebugUtils.currentLine=24576015;
 //BA.debugLineNum = 24576015;BA.debugLine="End Sub";
return "";
}
public int  _getvalue(avanue.nvwa.b4xseekbar __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xseekbar";
if (Debug.shouldDelegate(ba, "getvalue", true))
	 {return ((Integer) Debug.delegate(ba, "getvalue", null));}
RDebugUtils.currentLine=25034752;
 //BA.debugLineNum = 25034752;BA.debugLine="Public Sub getValue As Int";
RDebugUtils.currentLine=25034753;
 //BA.debugLineNum = 25034753;BA.debugLine="Return mValue";
if (true) return __ref._mvalue /*int*/ ;
RDebugUtils.currentLine=25034754;
 //BA.debugLineNum = 25034754;BA.debugLine="End Sub";
return 0;
}
public String  _initialize(avanue.nvwa.b4xseekbar __ref,anywheresoftware.b4a.BA _ba,Object _callback,String _eventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="b4xseekbar";
if (Debug.shouldDelegate(ba, "initialize", true))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba,_callback,_eventname}));}
RDebugUtils.currentLine=24510464;
 //BA.debugLineNum = 24510464;BA.debugLine="Public Sub Initialize (Callback As Object, EventNa";
RDebugUtils.currentLine=24510465;
 //BA.debugLineNum = 24510465;BA.debugLine="mEventName = EventName";
__ref._meventname /*String*/  = _eventname;
RDebugUtils.currentLine=24510466;
 //BA.debugLineNum = 24510466;BA.debugLine="mCallBack = Callback";
__ref._mcallback /*Object*/  = _callback;
RDebugUtils.currentLine=24510467;
 //BA.debugLineNum = 24510467;BA.debugLine="End Sub";
return "";
}
public String  _raisetouchstateevent(avanue.nvwa.b4xseekbar __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xseekbar";
if (Debug.shouldDelegate(ba, "raisetouchstateevent", true))
	 {return ((String) Debug.delegate(ba, "raisetouchstateevent", null));}
RDebugUtils.currentLine=24838144;
 //BA.debugLineNum = 24838144;BA.debugLine="Private Sub RaiseTouchStateEvent";
RDebugUtils.currentLine=24838145;
 //BA.debugLineNum = 24838145;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_TouchS";
if (__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .SubExists(ba,__ref._mcallback /*Object*/ ,__ref._meventname /*String*/ +"_TouchStateChanged",(int) (1))) { 
RDebugUtils.currentLine=24838146;
 //BA.debugLineNum = 24838146;BA.debugLine="CallSubDelayed2(mCallBack, mEventName & \"_TouchS";
__c.CallSubDelayed2(ba,__ref._mcallback /*Object*/ ,__ref._meventname /*String*/ +"_TouchStateChanged",(Object)(__ref._pressed /*boolean*/ ));
 };
RDebugUtils.currentLine=24838148;
 //BA.debugLineNum = 24838148;BA.debugLine="End Sub";
return "";
}
public String  _setvalue(avanue.nvwa.b4xseekbar __ref,int _v) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xseekbar";
if (Debug.shouldDelegate(ba, "setvalue", true))
	 {return ((String) Debug.delegate(ba, "setvalue", new Object[] {_v}));}
RDebugUtils.currentLine=24969216;
 //BA.debugLineNum = 24969216;BA.debugLine="Public Sub setValue(v As Int)";
RDebugUtils.currentLine=24969217;
 //BA.debugLineNum = 24969217;BA.debugLine="mValue = Max(MinValue, Min(MaxValue, v))";
__ref._mvalue /*int*/  = (int) (__c.Max(__ref._minvalue /*int*/ ,__c.Min(__ref._maxvalue /*int*/ ,_v)));
RDebugUtils.currentLine=24969218;
 //BA.debugLineNum = 24969218;BA.debugLine="Update";
__ref._update /*String*/ (null);
RDebugUtils.currentLine=24969219;
 //BA.debugLineNum = 24969219;BA.debugLine="End Sub";
return "";
}
public String  _setvaluebasedontouch(avanue.nvwa.b4xseekbar __ref,int _x,int _y) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xseekbar";
if (Debug.shouldDelegate(ba, "setvaluebasedontouch", true))
	 {return ((String) Debug.delegate(ba, "setvaluebasedontouch", new Object[] {_x,_y}));}
int _v = 0;
int _newvalue = 0;
RDebugUtils.currentLine=24903680;
 //BA.debugLineNum = 24903680;BA.debugLine="Private Sub SetValueBasedOnTouch(x As Int, y As In";
RDebugUtils.currentLine=24903681;
 //BA.debugLineNum = 24903681;BA.debugLine="Dim v As Int";
_v = 0;
RDebugUtils.currentLine=24903682;
 //BA.debugLineNum = 24903682;BA.debugLine="If Vertical Then";
if (__ref._vertical /*boolean*/ ) { 
RDebugUtils.currentLine=24903683;
 //BA.debugLineNum = 24903683;BA.debugLine="v = (mBase.Height - Radius2 - y) / size * (MaxVa";
_v = (int) ((__ref._mbase /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .getHeight()-__ref._radius2 /*int*/ -_y)/(double)__ref._size /*int*/ *(__ref._maxvalue /*int*/ -__ref._minvalue /*int*/ )+__ref._minvalue /*int*/ );
 }else {
RDebugUtils.currentLine=24903685;
 //BA.debugLineNum = 24903685;BA.debugLine="v = (x - Radius2) / size * (MaxValue - MinValue)";
_v = (int) ((_x-__ref._radius2 /*int*/ )/(double)__ref._size /*int*/ *(__ref._maxvalue /*int*/ -__ref._minvalue /*int*/ )+__ref._minvalue /*int*/ );
 };
RDebugUtils.currentLine=24903687;
 //BA.debugLineNum = 24903687;BA.debugLine="v = Round (v / Interval) * Interval";
_v = (int) (__c.Round(_v/(double)__ref._interval /*int*/ )*__ref._interval /*int*/ );
RDebugUtils.currentLine=24903688;
 //BA.debugLineNum = 24903688;BA.debugLine="Dim NewValue As Int = Max(MinValue, Min(MaxValue,";
_newvalue = (int) (__c.Max(__ref._minvalue /*int*/ ,__c.Min(__ref._maxvalue /*int*/ ,_v)));
RDebugUtils.currentLine=24903689;
 //BA.debugLineNum = 24903689;BA.debugLine="If NewValue <> mValue Then";
if (_newvalue!=__ref._mvalue /*int*/ ) { 
RDebugUtils.currentLine=24903690;
 //BA.debugLineNum = 24903690;BA.debugLine="mValue = NewValue";
__ref._mvalue /*int*/  = _newvalue;
RDebugUtils.currentLine=24903691;
 //BA.debugLineNum = 24903691;BA.debugLine="If xui.SubExists(mCallBack, mEventName & \"_Value";
if (__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .SubExists(ba,__ref._mcallback /*Object*/ ,__ref._meventname /*String*/ +"_ValueChanged",(int) (1))) { 
RDebugUtils.currentLine=24903692;
 //BA.debugLineNum = 24903692;BA.debugLine="CallSubDelayed2(mCallBack, mEventName & \"_Value";
__c.CallSubDelayed2(ba,__ref._mcallback /*Object*/ ,__ref._meventname /*String*/ +"_ValueChanged",(Object)(__ref._mvalue /*int*/ ));
 };
 };
RDebugUtils.currentLine=24903695;
 //BA.debugLineNum = 24903695;BA.debugLine="End Sub";
return "";
}
public String  _touchpanel_touch(avanue.nvwa.b4xseekbar __ref,int _action,float _x,float _y) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xseekbar";
if (Debug.shouldDelegate(ba, "touchpanel_touch", true))
	 {return ((String) Debug.delegate(ba, "touchpanel_touch", new Object[] {_action,_x,_y}));}
RDebugUtils.currentLine=24772608;
 //BA.debugLineNum = 24772608;BA.debugLine="Private Sub TouchPanel_Touch (Action As Int, X As";
RDebugUtils.currentLine=24772609;
 //BA.debugLineNum = 24772609;BA.debugLine="If Action = TouchPanel.TOUCH_ACTION_DOWN Then";
if (_action==__ref._touchpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .TOUCH_ACTION_DOWN) { 
RDebugUtils.currentLine=24772610;
 //BA.debugLineNum = 24772610;BA.debugLine="Pressed = True";
__ref._pressed /*boolean*/  = __c.True;
RDebugUtils.currentLine=24772611;
 //BA.debugLineNum = 24772611;BA.debugLine="RaiseTouchStateEvent";
__ref._raisetouchstateevent /*String*/ (null);
RDebugUtils.currentLine=24772612;
 //BA.debugLineNum = 24772612;BA.debugLine="SetValueBasedOnTouch(X, Y)";
__ref._setvaluebasedontouch /*String*/ (null,(int) (_x),(int) (_y));
 }else 
{RDebugUtils.currentLine=24772613;
 //BA.debugLineNum = 24772613;BA.debugLine="Else If Action = TouchPanel.TOUCH_ACTION_MOVE The";
if (_action==__ref._touchpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .TOUCH_ACTION_MOVE) { 
RDebugUtils.currentLine=24772614;
 //BA.debugLineNum = 24772614;BA.debugLine="SetValueBasedOnTouch(X, Y)";
__ref._setvaluebasedontouch /*String*/ (null,(int) (_x),(int) (_y));
 }else 
{RDebugUtils.currentLine=24772615;
 //BA.debugLineNum = 24772615;BA.debugLine="Else If Action = TouchPanel.TOUCH_ACTION_UP Then";
if (_action==__ref._touchpanel /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .TOUCH_ACTION_UP) { 
RDebugUtils.currentLine=24772616;
 //BA.debugLineNum = 24772616;BA.debugLine="Pressed = False";
__ref._pressed /*boolean*/  = __c.False;
RDebugUtils.currentLine=24772617;
 //BA.debugLineNum = 24772617;BA.debugLine="RaiseTouchStateEvent";
__ref._raisetouchstateevent /*String*/ (null);
 }}}
;
RDebugUtils.currentLine=24772619;
 //BA.debugLineNum = 24772619;BA.debugLine="Update";
__ref._update /*String*/ (null);
RDebugUtils.currentLine=24772620;
 //BA.debugLineNum = 24772620;BA.debugLine="End Sub";
return "";
}
}