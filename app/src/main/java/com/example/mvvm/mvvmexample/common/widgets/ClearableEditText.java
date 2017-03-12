package com.example.mvvm.mvvmexample.common.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.example.mvvm.mvvmexample.common.utils.StringUtils;

public class ClearableEditText
	extends AppCompatEditText
	implements View.OnTouchListener, View.OnFocusChangeListener, TextWatcherAdapter.TextWatcherListener {

	public interface OnTextClearedListener {
		void wasClearedText();
	}

	private Drawable drawables;
	private OnTextClearedListener textClearedListener;
	private OnTouchListener touchListener;
	private OnFocusChangeListener focusChangeListener;

	public ClearableEditText(Context context) {
		super(context);
		init();
	}

	public ClearableEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ClearableEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		drawables = getCompoundDrawables()[2];
		if (drawables == null) {
			drawables = getResources().getDrawable(android.R.drawable.presence_offline);
		}
		drawables.setBounds(0, 0, drawables.getIntrinsicWidth(), drawables.getIntrinsicHeight());
		setClearIconVisible(false);
		super.setOnTouchListener(this);
		super.setOnFocusChangeListener(this);
		addTextChangedListener(new TextWatcherAdapter(this, this));
	}

	public void setOnTextClearedListener(OnTextClearedListener listener) {
		this.textClearedListener = listener;
	}

	@Override
	public void setOnTouchListener(OnTouchListener listener) {
		this.touchListener = listener;
	}

	@Override
	public void setOnFocusChangeListener(OnFocusChangeListener listener) {
		this.focusChangeListener = listener;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (getCompoundDrawables()[2] != null) {
			boolean tappedX = event.getX() > (getWidth() - getPaddingRight() - drawables.getIntrinsicWidth());
			if (tappedX) {
				if (event.getAction() == MotionEvent.ACTION_UP) {
					setText("");
					if (textClearedListener != null) {
						textClearedListener.wasClearedText();
					}
				}
				return true;
			}
		}
		if (touchListener != null) {
			return touchListener.onTouch(v, event);
		}
		return false;
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		setClearIconVisible(isNotEmpty(getText()));
		if (focusChangeListener != null) {
			focusChangeListener.onFocusChange(v, hasFocus);
		}
	}

	@Override
	public void onTextChanged(EditText view, String text) {
		setClearIconVisible(isNotEmpty(text));
	}

	protected void setClearIconVisible(boolean visible) {
		boolean wasVisible = (getCompoundDrawables()[2] != null);
		if (visible != wasVisible) {
			Drawable x = visible ? drawables : null;
			setCompoundDrawables(
				getCompoundDrawables()[0],
				getCompoundDrawables()[1],
				x,
				getCompoundDrawables()[3]
			);
		}
	}

	private boolean isNotEmpty(CharSequence str) {
		if (str == null)
			return false;
		return StringUtils.isNotEmpty(str.toString());
	}

}
