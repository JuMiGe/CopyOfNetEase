package android88.slidingmenu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android88.slidingmenu.demo.R;

public class RightFragment extends Fragment {
	View _RootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		_RootView = inflater.inflate(R.layout.right_fragment_menu, null);
		return _RootView;
	}
}
