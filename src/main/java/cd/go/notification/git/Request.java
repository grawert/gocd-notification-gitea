/*
 * Copyright 2018 ThoughtWorks, Inc.
 * Copyright 2019 Uwe Grawert <grawert@b1-systems.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cd.go.notification.git;

/**
 * Enumerable that represents one of the messages that the server sends to the plugin
 */
public enum Request {
    REQUEST_GET_PLUGIN_ICON("cd.go.artifact.get-icon"),
    
    REQUEST_NOTIFICATIONS_INTERESTED_IN("notifications-interested-in"),
    REQUEST_STAGE_STATUS("stage-status"),

    // settings related requests that the server makes to the plugin
    PLUGIN_SETTINGS_GET_CONFIGURATION(Constants.GO_PLUGIN_SETTINGS_PREFIX + ".get-configuration"),
    PLUGIN_SETTINGS_GET_VIEW(Constants.GO_PLUGIN_SETTINGS_PREFIX + ".get-view"),
    PLUGIN_SETTINGS_CHANGED(Constants.GO_PLUGIN_SETTINGS_PREFIX + ".plugin-settings-changed"),
    PLUGIN_SETTINGS_VALIDATE_CONFIGURATION(Constants.GO_PLUGIN_SETTINGS_PREFIX + ".validate-configuration"),;

    private final String requestName;

    Request(String requestName) {
        this.requestName = requestName;
    }

    public String requestName() {
        return requestName;
    }

    public static Request fromString(String requestName) {
        if (requestName != null) {
            for (Request request : Request.values()) {
                if (requestName.equalsIgnoreCase(request.requestName)) {
                    return request;
                }
            }
        }

        return null;
    }

    private static class Constants {
        public static final String GO_PLUGIN_SETTINGS_PREFIX = "go.plugin-settings";
    }
}
