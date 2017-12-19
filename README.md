# MyEidtText
自定义验证码输入框
how to use:
  
```gradle
 allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
	
  
 dependencies {
 	compile 'com.github.hylinslove:MyEidtText:v1.1'
}

// in activity
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
	codeLayout.onKeyDown(keyCode,event);
        return super.onKeyDown(keyCode, event);
}
