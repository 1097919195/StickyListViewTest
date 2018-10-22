package zjl.example.com.stickylistviewtest;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/10/22 0022.
 * 这个方式不太好
 */

public class ToastUtil {

    private static ArrayList<Toast> toastList = new ArrayList<Toast>();

    public static void newToast(Context context, String content) {
        cancelAll();
        Toast toast = Toast.makeText(context,content,Toast.LENGTH_SHORT);
        toastList.add(toast);
        toast.show();
    }

    public static void cancelAll() {
        if (!toastList.isEmpty()){
            for (Toast t : toastList) {
                t.cancel();
            }
            toastList.clear();
        }
    }
}
