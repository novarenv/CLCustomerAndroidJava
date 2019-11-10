package com.example.clcustomer.api;

import android.util.Base64;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

public final class Decode {
    private static String[] split;

    @NotNull
    public static String decoded(@NotNull String JWTEncoded) throws Exception {
        Intrinsics.checkParameterIsNotNull(JWTEncoded, "JWTEncoded");

        try {
            List<String> var10000;
            label51: {
                String var2 = "\\.";
                Regex var11 = new Regex(var2);
                byte var13 = 0;
                List<String> $this$dropLastWhile$iv = var11.split(JWTEncoded, var13);
                if (!$this$dropLastWhile$iv.isEmpty()) {
                    ListIterator<String> iterator$iv = $this$dropLastWhile$iv.listIterator($this$dropLastWhile$iv.size());

                    while(iterator$iv.hasPrevious()) {
                        CharSequence var6 = iterator$iv.previous();
                        if (var6.length() != 0) {
                            var10000 = CollectionsKt.take($this$dropLastWhile$iv, iterator$iv.nextIndex() + 1);
                            break label51;
                        }
                    }
                }

                var10000 = CollectionsKt.emptyList();
            }

            Collection<String> $this$toTypedArray$iv = var10000;
            Object[] var16 = $this$toTypedArray$iv.toArray(new Object[0]);

            split = (String[])var16;
            StringBuilder var10001 = (new StringBuilder()).append("Header: ");
            String[] var10002 = split;
            if (var10002 == null) {
                Intrinsics.throwNpe();
            }

            Log.d("JWT_DECODED", var10001.append(getJson(var10002[0])).toString());
            var10001 = (new StringBuilder()).append("Body: ");
            var10002 = split;
            if (var10002 == null) {
                Intrinsics.throwNpe();
            }

            Log.d("JWT_DECODED", var10001.append(getJson(var10002[1])).toString());
            var10001 = (new StringBuilder()).append("Signiture: ");
            var10002 = split;
            if (var10002 == null) {
                Intrinsics.throwNpe();
            }

            Log.d("JWT_DECODED", var10001.append(getJson(var10002[2])).toString());
        } catch (UnsupportedEncodingException ignored) {
        }

        String[] var17 = split;
        if (var17 == null) {
            Intrinsics.throwNpe();
        }

        return getJson(var17[1]);
    }

    private static String getJson(String strEncoded) throws UnsupportedEncodingException {
        byte[] decodedBytes = Base64.decode(strEncoded, 8);
        Intrinsics.checkExpressionValueIsNotNull(decodedBytes, "decodedBytes");
        Charset var3 = Charset.forName("UTF-8");
        return new String(decodedBytes, var3);
    }
}
