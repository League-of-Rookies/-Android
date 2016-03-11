package com.lor.utils;

import android.util.Log;

/**
 * <pre>
 * Created by YanJin on 2016/3/11. 17:10
 * </pre>
 * 用于控制日志的打印
 */
public class LogUtil {
    /**
     * 用来控制日志的过滤显示
     */
    public static int LEVEL = Version.VERBOSE.ordinal();
    private static final String DEFAULT_TAG = null;

    /**
     * VERBOSE, DEBUG, INFO, WARN, ERROR, NOTHING
     */
    public enum Version {
        VERBOSE, DEBUG, INFO, WARN, ERROR, NOTHING
    }

    public static void v(String msg, Throwable tr) {
        v(DEFAULT_TAG, msg, tr);
    }

    public static void v(String tag, String msg, Throwable tr) {
        if (LEVEL <= Version.ERROR.ordinal()) {
            String[] arr = getSimpleName();
            if (tag == null) {
                tag = arr[0];
            }
            Log.v(tag, getStartStr(arr) + "\n" + connStr(msg), tr);
        }
    }

    public static void v(String tag, String msg) {

        if (LEVEL <= Version.VERBOSE.ordinal()) {
            String[] arr = getSimpleName();
            if (tag == null) {
                tag = arr[0];
            }
            Log.v(tag, getStartStr(arr) + "\n" + connStr(msg));
        }
    }

    public static void v(String msg) {
        v(DEFAULT_TAG, msg);
    }

    public static void d(String msg, Throwable tr) {
        d(DEFAULT_TAG, msg, tr);
    }

    public static void d(String tag, String msg, Throwable tr) {
        if (LEVEL <= Version.ERROR.ordinal()) {
            String[] arr = getSimpleName();
            if (tag == null) {
                tag = arr[0];
            }
            Log.d(tag, getStartStr(arr) + "\n" + connStr(msg), tr);
        }
    }

    public static void d(String tag, String msg) {
        if (LEVEL <= Version.DEBUG.ordinal()) {
            String[] arr = getSimpleName();
            if (tag == null) {
                tag = arr[0];
            }
            Log.d(tag, getStartStr(arr) + "\n" + connStr(msg));
        }
    }

    public static void d(String msg) {
        d(DEFAULT_TAG, msg);
    }

    public static void i(String msg, Throwable tr) {
        i(DEFAULT_TAG, msg, tr);
    }

    public static void i(String tag, String msg, Throwable tr) {
        if (LEVEL <= Version.ERROR.ordinal()) {
            String[] arr = getSimpleName();
            if (tag == null) {
                tag = arr[0];
            }
            Log.i(tag, getStartStr(arr) + "\n" + connStr(msg), tr);
        }
    }

    public static void i(String tag, String msg) {
        if (LEVEL <= Version.INFO.ordinal()) {
            String[] arr = getSimpleName();
            if (tag == null) {
                tag = arr[0];
            }
            Log.i(tag, getStartStr(arr) + "\n" + connStr(msg));
        }
    }

    public static void i(String msg) {
        i(DEFAULT_TAG, msg);
    }

    public static void w(String msg, Throwable tr) {
        w(DEFAULT_TAG, msg, tr);
    }

    public static void w(String tag, String msg, Throwable tr) {
        if (LEVEL <= Version.ERROR.ordinal()) {
            String[] arr = getSimpleName();
            if (tag == null) {
                tag = arr[0];
            }
            Log.w(tag, getStartStr(arr) + "\n" + connStr(msg), tr);
        }
    }

    public static void w(String tag, String msg) {
        if (LEVEL <= Version.WARN.ordinal()) {
            String[] arr = getSimpleName();
            if (tag == null) {
                tag = arr[0];
            }
            Log.w(tag, getStartStr(arr) + "\n" + connStr(msg));
        }
    }

    public static void w(String msg) {
        w(DEFAULT_TAG, msg);
    }

    public static void e(String msg, Throwable tr) {
        e(DEFAULT_TAG, msg, tr);
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (LEVEL <= Version.ERROR.ordinal()) {
            String[] arr = getSimpleName();
            if (tag == null) {
                tag = arr[0];
            }
            Log.e(tag, getStartStr(arr) + "\n" + connStr(msg), tr);
        }
    }

    public static void e(String tag, String msg) {
        if (LEVEL <= Version.ERROR.ordinal()) {
            String[] arr = getSimpleName();
            if (tag == null) {
                tag = arr[0];
            }
            Log.e(tag, getStartStr(arr) + "\n" + connStr(msg));
        }
    }

    public static void e(String msg) {
        e(DEFAULT_TAG, msg);
    }

    private static String connStr(String str) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            sb.append("NULL");
        } else {
            sb.append(getContentStr()).append(str);
        }
        return sb.toString();
    }

    /**
     * 获取线程名、类名、方法名、行号等信息
     *
     * @return --
     */
    private static String getStartStr(String[] arr) {
        return "[ Thread:" + arr[1] + ", at：" + arr[2] + "." + arr[3] + "():" + "第 " + arr[4] + " 行" + "]";
    }

    private static String[] getSimpleName() {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        String[] str = new String[5];
        if (stackTraceElement != null) {
            for (StackTraceElement ste : stackTraceElement) {
                if (ste.isNativeMethod()) {
                    continue;
                }
                if (ste.getClassName().equals(Thread.class.getName())) {
                    continue;
                }
                if (ste.getClassName().equals(LogUtil.class.getName())) {
                    continue;
                }

                str[0] = ste.getFileName();
                str[1] = Thread.currentThread().getName();
                str[2] = ste.getClassName();
                str[3] = ste.getMethodName();
                str[4] = ste.getLineNumber() + "";

                break;
            }
        }
        return str;
    }

    private static String getContentStr() {
        return ">>>>";
    }

}
