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

package com.gigigo.orchextra.sdk.background;

import android.content.Intent;
import android.os.Bundle;

import com.gigigo.orchextra.di.injector.InjectorImpl;
import com.gigigo.orchextra.domain.abstractions.device.OrchextraSDKLogLevel;
import com.gigigo.orchextra.domain.abstractions.device.OrchextraLogger;
import com.gigigo.orchextra.sdk.OrchextraManager;
import com.gigigo.orchextra.device.actions.ActionRecovery;
import com.gigigo.orchextra.device.actions.scheduler.ActionsSchedulerGcmImpl;
import com.gigigo.orchextra.device.notifications.dtos.AndroidBasicAction;
//import com.google.android.gms.gcm.GcmNetworkManager;
//import com.google.android.gms.gcm.GcmTaskService;
//import com.google.android.gms.gcm.TaskParams;

import android.app.Service;
import android.os.IBinder;
import android.support.annotationox.Nullable;

import com.google.gson.Gson;

import orchextra.javax.inject.Inject;

public class OrchextraGcmTaskService extends Service {

    @Inject
    ActionRecovery actionRecovery;
    @Inject
    Gson gson;
    @Inject
    OrchextraLogger orchextraLogger;

    //@Override
    public void onCreate() {
        //  super.onCreate();
        injectTaskServiceComponent();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void injectTaskServiceComponent() {
        InjectorImpl injector = OrchextraManager.getInjector();
        if (injector != null) {
            injector.injectTaskServiceComponent(this);
        }
    }

    public int onRunTask(Object taskParams) {
        orchextraLogger.log("Executing Scheduled action FAKE");
        return 0;
    }

}
