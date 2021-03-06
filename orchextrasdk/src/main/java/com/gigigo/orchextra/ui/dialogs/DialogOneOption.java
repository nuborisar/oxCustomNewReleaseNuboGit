/*
 * Created by Orchextra
 *
 * Copyright (C) 2016 Gigigo Mobile Services SL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gigigo.orchextra.ui.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;

import com.gigigo.orchextra.R;

public class DialogOneOption {

    private final Context context;
    private final String title;
    private final String message;
    private final String okText;
    private final DialogInterface.OnClickListener positiveListener;

    public DialogOneOption(Context context, String title, String message, String positiveText, DialogInterface.OnClickListener positiveListener) {
        this.context = context;
        this.title = title;
        this.message = message;
        this.okText = positiveText;
        this.positiveListener = positiveListener;
    }

    public Dialog onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.AlertDialogCustom));
        AlertDialog dialog = builder.setIcon(R.drawable.ox_notification_large_icon)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(okText, positiveListener)
                .create();

        return dialog;
    }
}
