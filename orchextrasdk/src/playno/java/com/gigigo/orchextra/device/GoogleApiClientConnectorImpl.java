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

package com.gigigo.orchextra.device;

import android.os.Bundle;
import android.text.TextUtils;

import com.gigigo.ggglib.ContextProvider;
import com.gigigo.orchextra.device.permissions.GoogleApiPermissionChecker;
import com.gigigo.orchextra.domain.abstractions.device.OrchextraSDKLogLevel;
import com.gigigo.orchextra.domain.abstractions.device.OrchextraLogger;
import com.gigigo.orchextra.sdk.features.GooglePlayServicesStatus;
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GoogleApiAvailability;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.location.LocationServices;

public class GoogleApiClientConnectorImpl implements GoogleApiClientConnector {

  private final ContextProvider contextProvider;
  private final GoogleApiPermissionChecker googleApiPermissionChecker;
  private final OrchextraLogger orchextraLogger;

  private Object client;
  private OnConnectedListener onConnectedListener;

  public GoogleApiClientConnectorImpl(ContextProvider contextProvider,
                                      GoogleApiPermissionChecker googleApiPermissionChecker,
                                      OrchextraLogger orchextraLogger) {
    this.contextProvider = contextProvider;
    this.googleApiPermissionChecker = googleApiPermissionChecker;
    this.orchextraLogger = orchextraLogger;
  }

  @Override
  public void connect() {
    if (contextProvider.getApplicationContext() != null ) {
      onConnected(new Bundle());
    }
  }
    //@Override
   public void onConnected(Bundle bundle) {
    orchextraLogger.log("onConnected");

    if (onConnectedListener != null) {
      onConnectedListener.onConnected(bundle);
    }
  }



 //TODO gcmtest
  public Object getGoogleApiClient() {
    return null;
  }

  //TODO gcmtest
  public boolean isConnected() {
    return true;
  }

  //TODO gcmtest
  public void disconnected() {

  }

  //TODO gcmtest
  public boolean isGoogleApiClientAvailable() {
      return true;

  }

  @Override
  public void setOnConnectedListener(OnConnectedListener onConnectedListener) {
    this.onConnectedListener = onConnectedListener;
  }
}
