package android88.slidingmenu.demo;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android88.slidingmenu.fragment.LeftFragment;
import android88.slidingmenu.fragment.RightFragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity implements
		OnClickListener {

	private SlidingMenu _SlidingMenu; // 侧边栏菜单
	private LeftFragment _LeftFragment; // 左侧菜单Fragment
	private RightFragment _RightFragment; // 右侧菜单Fragment

	private Button _LeftButton, _RightButton; // 左右菜单展开关闭按钮

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		_LeftButton = (Button) findViewById(R.id.leftButton);
		_RightButton = (Button) findViewById(R.id.rightButton);

		_LeftButton.setOnClickListener(this);
		_RightButton.setOnClickListener(this);

		initSlidingMenu();
	}

	/**
	 * 初始化侧边栏菜单
	 */
	private void initSlidingMenu() {
		_LeftFragment = new LeftFragment(); // 创建左边菜单Fragment
		_RightFragment = new RightFragment();// 创建右边菜单Fragment

		_SlidingMenu = getSlidingMenu(); // 由于Activity继承自SlidingFragmentActivity,所以直接获取当前的侧边栏菜单

		_SlidingMenu.setMode(SlidingMenu.LEFT_RIGHT); // 设置侧边栏菜单为左右模式
		_SlidingMenu.setBehindWidthRes(R.dimen.left_menu_width); // 设置左边菜单的宽度,该值为左菜单展开的宽度
		_SlidingMenu.setShadowDrawable(R.drawable.shadow); // 设置左菜单的阴影
		_SlidingMenu.setShadowWidth(10); // 设置阴影宽度
		_SlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN); // 设置侧边栏菜单触摸模式为全屏模式

		setBehindContentView(R.layout.left_menu_layout); // 设置左菜单的默认VIEW
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.leftMenu, _LeftFragment).commit(); // 将左菜单默认VIEW替换为左菜单Fragment

		_SlidingMenu.setSecondaryMenu(R.layout.right_menu_layout); // 设置右菜单默认VIEW
		_SlidingMenu.setSecondaryShadowDrawable(R.drawable.shadowright); // 设置右菜单阴影
		_SlidingMenu.setRightBehindWidthRes(R.dimen.right_menu_width); // 设置右菜单的宽度,该值为右菜单展开的宽度
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.rightMenu, _RightFragment).commit(); // 将右菜单默认VIEW替换为右菜单Fragment

	}

	@Override
	public void onClick(View v) {
		if (v == _LeftButton) {
			if (!_SlidingMenu.isMenuShowing()) {
				_SlidingMenu.showMenu();
			} else {
				_SlidingMenu.showContent();
			}
		} else if (v == _RightButton) {
			if (!_SlidingMenu.isSecondaryMenuShowing()) {
				_SlidingMenu.showSecondaryMenu();
			} else {
				_SlidingMenu.showContent();
			}
		}
	}
}
