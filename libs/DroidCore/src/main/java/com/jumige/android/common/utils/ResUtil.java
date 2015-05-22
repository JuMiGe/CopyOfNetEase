package com.jumige.android.common.utils;

import android.content.Context;
import android.content.res.Resources;

public class ResUtil {
	private Resources resources;
	private String pkg;
	private static ResUtil forumResource;

	private ResUtil(Context context) {
		pkg = context.getPackageName();
		resources = context.getResources();
	}

	public static ResUtil getInstance(Context context) {
		if (forumResource == null)
			forumResource = new ResUtil(context);
		return forumResource;
	}

	protected int getResourcesId(Context context, String type, String name) {
		try {
			int id = resources.getIdentifier(name, type, pkg);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getStringId(String name) {
		try {
			int id = resources.getIdentifier(name, "string", pkg);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}		return 0;
	}

	public int getColorId(String name) {
		try {
			int id = resources.getIdentifier(name, "color", pkg);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getDimenId(String name) {
		try {
			int id = resources.getIdentifier(name, "dimen", pkg);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getStyleId(String name) {
		try {
			int id = resources.getIdentifier(name, "style", pkg);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getLayoutId(String name) {
		try {
			int id = resources.getIdentifier(name, "layout", pkg);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getViewId(String name) {
		try {
			int id = resources.getIdentifier(name, "id", pkg);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getAnimId(String name) {
		try {
			int id = resources.getIdentifier(name, "anim", pkg);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getArrayId(String name) {
		try {
			int id = resources.getIdentifier(name, "array", pkg);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getDrawableId(String name) {
		try {
			int id = resources.getIdentifier(name, "drawable", pkg);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getRawId(String name) {
		try {
			int id = resources.getIdentifier(name, "raw", pkg);
			return id;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
