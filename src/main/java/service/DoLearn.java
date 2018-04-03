package service;

public class DoLearn {
	static {
		System.loadLibrary("");
	}
	public native void studyClass(int classid);
	public native void cutPhotos(String path);

}
