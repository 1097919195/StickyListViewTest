package zjl.example.com.stickylistviewtest;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/10/22 0022.
 */

public class ToastUtil2 {
    // 构造方法私有化 不允许new对象
    private ToastUtil2() {
    }

    // Toast对象
    private static Toast toast = null;

    /**
     * 显示Toast
     */
    public static void showText(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }
}
