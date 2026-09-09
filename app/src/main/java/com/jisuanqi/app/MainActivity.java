// 在 MainActivity 类中添加一个内部类
public class JSBridge {
    @android.webkit.JavascriptInterface
    public String getClipboardText() {
        try {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            android.content.ClipData clip = clipboard.getPrimaryClip();
            if (clip != null && clip.getItemCount() > 0) {
                return clip.getItemAt(0).getText().toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

// 在 WebView 初始化时，注册这个接口
webView.addJavascriptInterface(new JSBridge(), "jsAndroidBridge");
