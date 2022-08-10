
package avanue.nvwa;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "avanue.nvwa.main");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _frontcamera = RemoteObject.createImmutable(false);
public static RemoteObject _storage = RemoteObject.declareNull("avanue.nvwa.externalstorage");
public static RemoteObject _parents_dir = RemoteObject.declareNull("avanue.nvwa.externalstorage._externalfile");
public static RemoteObject _camex = RemoteObject.declareNull("avanue.nvwa.cameraexclass");
public static RemoteObject _touchimageview1 = RemoteObject.declareNull("uk.co.martinpearman.b4a.touchimageview.TouchImageViewWrapper");
public static RemoteObject _id = RemoteObject.createImmutable("");
public static RemoteObject _sql1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL");
public static RemoteObject _cursor1 = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
public static RemoteObject _now = RemoteObject.createImmutable(0L);
public static RemoteObject _rp = RemoteObject.declareNull("anywheresoftware.b4a.objects.RuntimePermissions");
public static RemoteObject _tag_subject = RemoteObject.createImmutable("");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btntakepicture = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _mytaskindex = RemoteObject.createImmutable(0);
public static RemoteObject _q_count = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _q_name = RemoteObject.createImmutable("");
public static RemoteObject _a_name = RemoteObject.createImmutable("");
public static RemoteObject _t_name = RemoteObject.createImmutable("");
public static RemoteObject _random_num = RemoteObject.createImmutable(0);
public static RemoteObject _imageview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _current_id = RemoteObject.createImmutable(0);
public static RemoteObject _current_time_create = RemoteObject.createImmutable("");
public static RemoteObject _current_time_modify = RemoteObject.createImmutable("");
public static RemoteObject _current_time_delete = RemoteObject.createImmutable("");
public static RemoteObject _current_valid = RemoteObject.createImmutable(0);
public static RemoteObject _current_subject = RemoteObject.createImmutable("");
public static RemoteObject _current_leval = RemoteObject.createImmutable(0);
public static RemoteObject _current_grade = RemoteObject.createImmutable(0);
public static RemoteObject _current_tags = RemoteObject.createImmutable("");
public static RemoteObject _current_question_image = RemoteObject.createImmutable("");
public static RemoteObject _current_answer_image = RemoteObject.createImmutable("");
public static RemoteObject _current_correct_times = RemoteObject.createImmutable(0);
public static RemoteObject _current_incorrect_times = RemoteObject.createImmutable(0);
public static RemoteObject _current_last_time = RemoteObject.createImmutable("");
public static RemoteObject _qa_s = RemoteObject.createImmutable(0);
public static RemoteObject _rule_never_do = RemoteObject.createImmutable(0);
public static RemoteObject _rule_correct = RemoteObject.createImmutable(0);
public static RemoteObject _rule_incorrect = RemoteObject.createImmutable(0);
public static RemoteObject _tags = RemoteObject.createImmutable("");
public static RemoteObject _filedialog1 = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs2.InputDialog.FileDialog");
public static RemoteObject _quesfilepath = RemoteObject.createImmutable("");
public static RemoteObject _quesfilename = RemoteObject.createImmutable("");
public static RemoteObject _ansfilepath = RemoteObject.createImmutable("");
public static RemoteObject _ansfilename = RemoteObject.createImmutable("");
public static RemoteObject _bitmapques = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _bitmapans = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
public static RemoteObject _scrans = RemoteObject.declareNull("flm.b4a.scrollview2d.ScrollView2DWrapper");
public static RemoteObject _scrques = RemoteObject.declareNull("flm.b4a.scrollview2d.ScrollView2DWrapper");
public static RemoteObject _btnimpans = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnimpcomplete = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnimpques = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _add_tag_biology = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _add_tag_chemistry = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _add_tag_chinese = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _add_tag_english = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _add_tag_maths = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _add_tag_physics = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
public static RemoteObject _add_tag_edit = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _ft = RemoteObject.declareNull("com.mathew.mmtools.filetools");
public static RemoteObject _options = RemoteObject.declareNull("avanue.nvwa.b4xlisttemplate");
public static RemoteObject _tagdialog = RemoteObject.declareNull("avanue.nvwa.b4xdialog");
public static RemoteObject _base = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _inputtag = RemoteObject.declareNull("avanue.nvwa.b4xinputtemplate");
public static RemoteObject _dateutils = RemoteObject.declareNull("b4a.example.dateutils");
public static avanue.nvwa.starter _starter = null;
public static avanue.nvwa.xuiviewsutils _xuiviewsutils = null;
  public Object[] GetGlobals() {
		return new Object[] {"A_Name",main.mostCurrent._a_name,"Activity",main.mostCurrent._activity,"add_tag_biology",main.mostCurrent._add_tag_biology,"add_tag_chemistry",main.mostCurrent._add_tag_chemistry,"add_tag_chinese",main.mostCurrent._add_tag_chinese,"add_tag_edit",main.mostCurrent._add_tag_edit,"add_tag_english",main.mostCurrent._add_tag_english,"add_tag_maths",main.mostCurrent._add_tag_maths,"add_tag_physics",main.mostCurrent._add_tag_physics,"AnsFileName",main.mostCurrent._ansfilename,"AnsFilePath",main.mostCurrent._ansfilepath,"Base",main.mostCurrent._base,"BitmapAns",main.mostCurrent._bitmapans,"BitmapQues",main.mostCurrent._bitmapques,"btnImpAns",main.mostCurrent._btnimpans,"btnImpComplete",main.mostCurrent._btnimpcomplete,"btnImpQues",main.mostCurrent._btnimpques,"btnTakePicture",main.mostCurrent._btntakepicture,"camEx",main.mostCurrent._camex,"Current_Answer_Image",main.mostCurrent._current_answer_image,"Current_Correct_Times",main._current_correct_times,"Current_Grade",main._current_grade,"Current_ID",main._current_id,"Current_Incorrect_Times",main._current_incorrect_times,"Current_Last_Time",main.mostCurrent._current_last_time,"Current_Leval",main._current_leval,"Current_Question_Image",main.mostCurrent._current_question_image,"Current_Subject",main.mostCurrent._current_subject,"Current_Tags",main.mostCurrent._current_tags,"Current_Time_Create",main.mostCurrent._current_time_create,"Current_Time_Delete",main.mostCurrent._current_time_delete,"Current_Time_Modify",main.mostCurrent._current_time_modify,"Current_Valid",main._current_valid,"cursor1",main.mostCurrent._cursor1,"DateUtils",main.mostCurrent._dateutils,"FileDialog1",main.mostCurrent._filedialog1,"frontCamera",main._frontcamera,"FT",main.mostCurrent._ft,"ID",main.mostCurrent._id,"ImageView1",main.mostCurrent._imageview1,"InputTag",main.mostCurrent._inputtag,"MyTaskIndex",main._mytaskindex,"now",main._now,"options",main.mostCurrent._options,"Panel1",main.mostCurrent._panel1,"Parents_Dir",main._parents_dir,"q_count",main.mostCurrent._q_count,"Q_Name",main.mostCurrent._q_name,"QA_S",main._qa_s,"QuesFileName",main.mostCurrent._quesfilename,"QuesFilePath",main.mostCurrent._quesfilepath,"random_num",main._random_num,"rp",main.mostCurrent._rp,"rule_correct",main._rule_correct,"rule_incorrect",main._rule_incorrect,"rule_never_do",main._rule_never_do,"ScrAns",main.mostCurrent._scrans,"ScrQues",main.mostCurrent._scrques,"SQL1",main.mostCurrent._sql1,"Starter",Debug.moduleToString(avanue.nvwa.starter.class),"Storage",main._storage,"T_Name",main.mostCurrent._t_name,"tag_subject",main.mostCurrent._tag_subject,"TagDialog",main.mostCurrent._tagdialog,"tags",main.mostCurrent._tags,"TouchImageView1",main.mostCurrent._touchimageview1,"xui",main._xui,"XUIViewsUtils",Debug.moduleToString(avanue.nvwa.xuiviewsutils.class)};
}
}